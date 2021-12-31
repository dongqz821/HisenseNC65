package ncc.impl.baseapp.nccsign;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSONObject;
import nc.bs.logging.Logger;
import nc.bs.dao.BaseDAO;
import nc.bs.framework.common.NCLocator;
import nc.itf.cmp.settlement.ISettlementQueryService;
import nc.itf.cmp.settlement.ISettlementService;
import nc.itf.cmp.settlement.ISettlementServiceRequiresNew;
import nc.itf.pubapp.pub.smart.IBillQueryService;
import nc.itf.uap.IUAPQueryBS;
import nc.itf.uap.pf.IPFBusiAction;
import nc.jdbc.framework.processor.MapProcessor;
import nc.vo.arap.pay.AggPayBillVO;
import nc.vo.bpm.ResponseVO;
import nc.vo.cmp.settlement.SettleContext;
import nc.vo.cmp.settlement.SettlementAggVO;
import nc.vo.cmp.settlement.SettlementBodyVO;
import nc.vo.fdcpmpay.pay.AggPayVO;
import nc.vo.fdcpmpay.pay.PayDealVO;
import nc.vo.fdcpmpay.pay.PayVO;
import nc.vo.pub.SuperVO;
import nc.vo.pub.VOStatus;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import ncc.itf.baseapp.nccsign.INCCServiceHandler;
/*
 * ncc结算单回写dongqz
 */
public class NCCServiceHandlerImpl implements INCCServiceHandler {
/*
 * 付款单审批 
 * 2021/11/10
 */
	
	@Override
	public String examine(String ds, JSONObject json) {
		ResponseVO response = new ResponseVO();
		String result = "";
		String pk = json.getString("pk_upbill");
		try {
			if ( "F3".equals(json.getString("def20"))) {//外系统单据类型
				IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
				//根据来源主键 找到付款申请的主键，根据款申请主键 查找 到 付款单的主键
				Map bank = null;
				try {
					//sql:查询出 供应商付款单的主键 
					Object object = (Map) query.executeQuery("select p.pk_paybill from cmp_apply cmp inner join ap_payitem ap on cmp.pk_apply = ap.top_billid inner join ap_paybill p on ap.pk_paybill = p.pk_paybill where p.dr = 0 and cmp.pk_apply = '"+ pk +"'", new MapProcessor());
					bank = (Map) object;
					String dettlemen = (String) bank.get("pk_paybill");
					IBillQueryService service1 = NCLocator.getInstance().lookup(IBillQueryService.class);
					AggPayBillVO payaggvo = service1.querySingleBillByPk(AggPayBillVO .class, dettlemen);
					IPFBusiAction busiAction = (IPFBusiAction)NCLocator.getInstance().lookup(IPFBusiAction.class);//调用单据脚本进行审批，NC65大部分单据都可以通过这个方法进行提交，审批，收回，等操作
					if ("8.0".equals(json.getString("busistatus"))) {
						busiAction.processAction("APPROVE", "F3", null, payaggvo, null, null);//审批的方法
					}else if("1.0".equals(json.getString("busistatus"))) {
						busiAction.processAction("UNAPPROVE", "F3", null, payaggvo, null, null);//审批的方法
					}
				} catch (Exception e){
					Logger.error(e.getMessage());
//		            ExceptionUtils.wrappBusinessException(" nc65回写审批失败："+e.getMessage());
					response.setCode("100");
					response.setMsg("回写nc65审批失败："+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
			}else {
				return null;
			}
			response.setCode("200");
			response.setMsg("付款单审批成功");
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		} catch (Exception e) {
			Logger.error(e.getStackTrace());
			//失败返回
			response.setCode("100");
			response.setMsg("付款单审批操作失败："+e.getMessage());
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		}
		return result;
	}
/* 
 * 结算单 签字
 * 2021.11.15
 */
	@Override
	public String signature(String ds, JSONObject json) {
//		json.getString("pk_upbill");//上游单据主键
//		json.getString("busistatus");//单据状态
//		json.getString("bill_type");//单据类型 F5
//		json.getString("source_flag");//来源系统 2现金管理（资金） 999项目付款（成本）
		
		//实业项目 F3  
		//成本 H194
		//报销 264X
		
		ResponseVO response = new ResponseVO();
		String result = "";
		String pk = json.getString("pk_upbill");
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			
			if ( "F3".equals(json.getString("def20"))) {//外系统单据类型 -- 事业项目
				//根据来源主键 找到付款申请的主键，根据款申请主键 查找 到 付款单的主键
				Map bank = null;
				try {
					//sql:查询出 供应商付款单的主键 
					Object object = (Map) query.executeQuery("select p.pk_paybill from cmp_apply cmp inner join ap_payitem ap on cmp.pk_apply = ap.top_billid inner join ap_paybill p on ap.pk_paybill = p.pk_paybill where p.dr = 0 and cmp.pk_apply = '"+ pk +"'", new MapProcessor());
//					BaseDAO updata = new BaseDAO();
					bank = (Map) object;
					String dettlemen = (String) bank.get("pk_paybill");
					ISettlementQueryService service = NCLocator.getInstance().lookup(ISettlementQueryService.class);//获取VO的接口
					SettlementAggVO aggvo = service.querySettlementAggByPk_busibill(dettlemen);//根据结算单的来源主键 查找 结算单的 aggvo
					aggvo.getParentVO().setAttributeValue("signdate", new UFDate());
					ISettlementServiceRequiresNew servic = NCLocator.getInstance().lookup(ISettlementServiceRequiresNew.class);//签字的接口
					//单据状态 9=未确认，-1=保存，1=审批通过，2=审批中，-99=暂存，8=签字，
					if ("8.0".equals(json.getString("busistatus"))) {//NCC单据状态为 审批通过 
						//修改付款单的 单据状态改为 已签字， 结算状态 改为 转账成功
						//settleflag 结算状态0=默认，1=转账成功，-1=转账失败，2=转账中，11=部分
//						updata.executeUpdate("update ap_paybill set billstatus = 1 where pk_paybill = '"+bank.get("pk_paybill")+"'");
						servic.handleSign_RequiresNew(aggvo);//签字的方法
					}else if("1.0".equals(json.getString("busistatus"))){//NCC单据状态为 签字
//						updata.executeUpdate("update ap_paybill t set billstatus = 1 where pk_paybill = '"+bank.get("pk_paybill")+"'");
						servic.handleCancelSign_RequiresNew(aggvo);
					}
				} catch (Exception e) {
					Logger.error(e.getMessage());
//	                ExceptionUtils.wrappBusinessException("nc65签字发生异常："+e.getMessage());
					response.setCode("100");
					response.setMsg("回写NC65签字失败:"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
				
			}else if ("H194".equals(json.getString("def20"))) {//外系统单据类型 -- 成本
				try {
//					
					//查询付款单
					String dettlemen = json.getString("pk_upbill");
					IBillQueryService service1 = NCLocator.getInstance().lookup(IBillQueryService.class);
					AggPayVO payaggvo = service1.querySingleBillByPk(AggPayVO.class, dettlemen);//根据主键查询出 AggVO
					List<PayVO> hvoList = new ArrayList<>();
					PayVO headvo = payaggvo.getParentVO();
					
					if ("8.0".equals(json.getString("busistatus"))) {
						PayDealVO[] bvo = (PayDealVO[]) payaggvo.getChildrenVO();
						boolean b = false;
						for (int i = 0; i < bvo.length; i++) {
							String str = bvo[i].getPaymethod();
							if (str.equals("10011A100000000I4MPN")) {//判断结算方式是现汇
								b = true;
								break;
							}
						}
						if (b) {
							headvo.setAttributeValue("vdef9", "已签字");   
					    	headvo.setStatus(VOStatus.UPDATED);
					    	hvoList.add(headvo);
						}else{
							headvo.setAttributeValue("vdef9", "已结算");   
					    	headvo.setStatus(VOStatus.UPDATED);
					    	hvoList.add(headvo);
						}
					}else if("1.0".equals(json.getString("busistatus"))){
						headvo.setAttributeValue("vdef9", "");   
				    	headvo.setStatus(VOStatus.UPDATED);
				    	hvoList.add(headvo);
					}
						
				    if(hvoList.size()>0){
				    	 new BaseDAO().updateVOArray((SuperVO[])hvoList.toArray(new PayVO[0]), new String[] { "vdef9"});    	 
				    }
				} catch (Exception e) {
					Logger.error(e.getMessage());
//		            ExceptionUtils.wrappBusinessException(" 回写NC65签字失败："+e.getMessage());
					response.setCode("100");
					response.setMsg("回写NC65签字失败:"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
			}else if ("264X".equals(json.getString("def20"))) { // 报销回写
				//报销回写 -- 联查结算 进行签字
				Map bank = null;
				try {
					//sql:查询出 供应商付款单的主键 
					ISettlementQueryService service = NCLocator.getInstance().lookup(ISettlementQueryService.class);//获取VO的接口
					SettlementAggVO aggvo = service.querySettlementAggByPk_busibill(pk);//根据结算单的来源主键 查找 结算单的 aggvo
					aggvo.getParentVO().setAttributeValue("signdate", new UFDate());
					SettlementBodyVO[] settleaccountMap = (SettlementBodyVO[]) aggvo.getChildrenVO();
					for (SettlementBodyVO body : settleaccountMap) {
						body.setTallydate(new UFDate());
					}
					ISettlementServiceRequiresNew servic = NCLocator.getInstance().lookup(ISettlementServiceRequiresNew.class);//签字的接口
					//单据状态 9=未确认，-1=保存，1=审批通过，2=审批中，-99=暂存，8=签字，
					if ("8.0".equals(json.getString("busistatus"))) {//NCC单据状态为 审批通过 
						servic.handleSign_RequiresNew(aggvo);//签字的方法
					}else if("1.0".equals(json.getString("busistatus"))){//NCC单据状态为 签字
						servic.handleCancelSign_RequiresNew(aggvo);
					}
				} catch (Exception e) {
					Logger.error(e.getMessage());
//		            ExceptionUtils.wrappBusinessException(" 回写NC65签字失败："+e.getMessage());
					response.setCode("100");
					response.setMsg("回写NC65签字失败:"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
			}
			
			response.setCode("200");
			response.setMsg("回写成功");
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		} catch (Exception e) {//BusinessException
			Logger.error(e.getStackTrace());
			//失败返回
			
			response.setCode("100");
			response.setMsg("回写失败："+e.getMessage());
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		}
		
		return result;
	}

/*
 * NCC结算单 结算的回写方法
 * 2021.11.21
 */
	@Override
	public String settleAccounts(String ds, JSONObject json) {//结算的方法

		ResponseVO response = new ResponseVO();
		String result = "";
		String pk = json.getString("pk_upbill");//上游单据主键
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			
			if ( "F3".equals(json.getString("def20"))) {//外系统单据类型  -- 实业项目
				//根据来源主键 找到付款申请的主键，根据款申请主键 查找 到 付款单的主键
				Map bank = null;
				try {
					//sql:查询出 供应商付款单的主键 
					Object object = (Map) query.executeQuery("select p.pk_paybill from cmp_apply cmp inner join ap_payitem ap on cmp.pk_apply = ap.top_billid inner join ap_paybill p on ap.pk_paybill = p.pk_paybill where p.dr = 0 and cmp.pk_apply = '"+ pk +"'", new MapProcessor());
					bank = (Map) object;
					String dettlemen = (String) bank.get("pk_paybill");//供应商付款单主键
//					BaseDAO updata = new BaseDAO();
					ISettlementQueryService service = NCLocator.getInstance().lookup(ISettlementQueryService.class);//获取VO的接口
					SettlementAggVO aggvo = service.querySettlementAggByPk_busibill(dettlemen);//根据结算单的来源主键 查找 结算单的 aggvo
					aggvo.getParentVO().setAttributeValue("signdate", new UFDate());
					ISettlementServiceRequiresNew servic = NCLocator.getInstance().lookup(ISettlementServiceRequiresNew.class);//结算的接口
					SettlementBodyVO[] settleaccountMap = (SettlementBodyVO[]) aggvo.getChildrenVO();
					for (SettlementBodyVO body : settleaccountMap) {
						body.setTallydate(new UFDate());
					}
					ISettlementService serv =  NCLocator.getInstance().lookup(ISettlementService.class);
					SettleContext sett = new SettleContext();
					List<SettlementAggVO> list = new ArrayList<>();
					list.add(aggvo);
					sett.setBeanList(list);
					sett.setGenerateOne(false);
					//结算状态
					if ("1".equals(json.getString("settlestatus"))) {//NCC结算单为 未结算 字段值为1
						servic.handleSettle_RequiresNew(aggvo);//结算的方法
//						updata.executeUpdate("update ap_paybill set settleflag = 1 where pk_paybill = '"+dettlemen+"'");
					}else if("0".equals(json.getString("settlestatus"))){//NCC结算单为 已结算 字段值为0
						serv.handleCancelSettle(sett);
//						servic.handleCancelSettle_RequiresNew(aggvo);//取消结算的方法
//						updata.executeUpdate("update ap_paybill set settleflag = 0 where pk_paybill = '"+dettlemen+"'");
					}
				} catch (Exception e) {
					Logger.error(e.getMessage());
//		            ExceptionUtils.wrappBusinessException("回写NC65结算失败："+e.getMessage());
		            response.setCode("100");
					response.setMsg("回写NC65结算失败:"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
			}else if ("H194".equals(json.getString("def20"))) {// 成本
				try {
					//查询付款单
					IBillQueryService service1 = NCLocator.getInstance().lookup(IBillQueryService.class);
					AggPayVO payaggvo = service1.querySingleBillByPk(AggPayVO .class, pk);
					List<PayVO> hvoList = new ArrayList<>();
					PayVO headvo = payaggvo.getParentVO();
					if ("1".equals(json.getString("settlestatus"))) {
						headvo.setAttributeValue("vdef9", "已结算");   
				    	headvo.setStatus(VOStatus.UPDATED);
				    	hvoList.add(headvo);
					}else if("0".equals(json.getString("settlestatus"))){
						headvo.setAttributeValue("vdef9", "已签字"); 
				    	headvo.setStatus(VOStatus.UPDATED);
				    	hvoList.add(headvo);
					}
						
				    if(hvoList.size()>0){
				    	 new BaseDAO().updateVOArray((SuperVO[])hvoList.toArray(new PayVO[0]), new String[] { "vdef9"});    	 
				    }
				} catch (Exception e) {
					Logger.error(e.getMessage());
//		            ExceptionUtils.wrappBusinessException("回写NC65结算失败："+e.getMessage());
		            response.setCode("100");
					response.setMsg("回写NC65结算失败:"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
			}else if ("264X".equals(json.getString("def20"))) {// 报销
//				Map bank = null;
				try {
					//sql:查询出 供应商付款单的主键 
					ISettlementQueryService service = NCLocator.getInstance().lookup(ISettlementQueryService.class);//获取VO的接口
					SettlementAggVO aggvo = service.querySettlementAggByPk_busibill(pk);//根据结算单的来源主键 查找 结算单的 aggvo
					aggvo.getParentVO().setAttributeValue("signdate", new UFDate());
					SettlementBodyVO[] settleaccountMap = (SettlementBodyVO[]) aggvo.getChildrenVO();
					for (SettlementBodyVO body : settleaccountMap) {
						body.setTallydate(new UFDate());
					}
					ISettlementServiceRequiresNew servic = NCLocator.getInstance().lookup(ISettlementServiceRequiresNew.class);//结算的接口
//					String dettlemen = (String) bank.get("pk_paybill");
//					BaseDAO updata = new BaseDAO();
					ISettlementService serv =  NCLocator.getInstance().lookup(ISettlementService.class);
					SettleContext sett = new SettleContext();
					List<SettlementAggVO> list = new ArrayList<>();
					list.add(aggvo);
					sett.setBeanList(list);
					sett.setGenerateOne(false);
					//结算状态
					if ("1".equals(json.getString("settlestatus"))) {//NCC结算单为 未结算
						servic.handleSettle_RequiresNew(aggvo);//结算的方法
//						updata.executeUpdate("update er_bxzb set payflag = 3 where pk_jkbx = '"+pk+"'");
					}else if("0".equals(json.getString("settlestatus"))){//NCC结算单为 已结算
						serv.handleCancelSettle(sett);
//						servic.handleCancelSettle_RequiresNew(aggvo);//取消结算的方法
//						updata.executeUpdate("update er_bxzb set payflag = 1 where pk_jkbx = '"+pk+"'");
					}
				} catch (Exception e) {
					Logger.error(e.getMessage());
//		            ExceptionUtils.wrappBusinessException("回写NC65结算失败："+e.getMessage());
		            response.setCode("100");
					response.setMsg("回写NC65结算失败:"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
			}
				
			response.setCode("200");
			response.setMsg("回写成功");
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		} catch (Exception e) {
			Logger.error(e.getStackTrace());
			//失败返回
			response.setCode("100");
			response.setMsg("回写失败："+e.getMessage());
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		}
		return result;
	}
	
	/*
	 * ncc支付回写 
	 * 2021.12.21
	 * @see ncc.itf.baseapp.nccsign.INCCServiceHandler#notifyPay(java.lang.String, com.alibaba.fastjson.JSONObject)
	 */
	@Override
	public String notifyPay(String ds, JSONObject param) {
		ResponseVO response = new ResponseVO();
		String result = "";
		String pk = param.getString("pk_upbill");//上游单据主键
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		BaseDAO updata = new BaseDAO();
		try {
			if ("F3".equals(param.getString("def20"))) {//外系统单据类型  -- 实业项目
				Map bank = null;
				try {
					//sql:查询出 供应商付款单的主键 
					Object object = (Map) query.executeQuery("select p.pk_paybill from cmp_apply cmp inner join ap_payitem ap on cmp.pk_apply = ap.top_billid inner join ap_paybill p on ap.pk_paybill = p.pk_paybill where p.dr = 0 and cmp.pk_apply = '"+ pk +"'", new MapProcessor());
					bank = (Map) object;
					String dettlemen = (String) bank.get("pk_paybill");//供应商付款单主键
					updata.executeUpdate("update ap_paybill set settleflag = 1 where pk_paybill = '"+dettlemen+"'");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if("H194".equals(param.getString("def20"))){//成本
				try {
					updata.executeUpdate("update fdcpm_pay_pay set def9 = '已支付' where pk_jkbx = '"+pk+"'");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if("264X".equals(param.getString("def20"))){//报销
				try {
					updata.executeUpdate("update er_bxzb set payflag = 3 where pk_jkbx = '"+pk+"'");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			response.setCode("200");
			response.setMsg("回写成功");
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		}catch (Exception e){
			Logger.error(e.getStackTrace());
			//失败返回
			response.setCode("100");
			response.setMsg("支付失败："+e.getMessage());
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		}
		return result;
	}

}
