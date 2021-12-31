package nc.impl.baseapp.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.itf.baseapp.utils.ICallNccOpenAPIUtil;
import nc.itf.baseapp.utils.IPushSingleNCC;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.MapProcessor;
import nc.vo.cmp.apply.AggApplyVO;
import nc.vo.cmp.apply.ApplyBVO;
import nc.vo.cmp.apply.ApplyVO;
import nc.vo.cmp.bill.BillDetailVO;
import nc.vo.ep.bx.BXBusItemVO;
import nc.vo.ep.bx.BXVO;
import nc.vo.ep.bx.JKBXHeaderVO;
import nc.vo.fdcpmbd.pub.tool.SafeCompute;
import nc.vo.fdcpmpay.pay.AggPayVO;
import nc.vo.fdcpmpay.pay.PayAccVO;
import nc.vo.fdcpmpay.pay.PayVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.VOStatus;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import ncc.baseapp.utils.ConfigUtils;
/*
 * NC65向NCC推付款结算单 dongqz
 */
public class IPushSingleNCCImpl implements IPushSingleNCC{
	//资金推NCC付款结算 dongqz
	@Override
	public String DateInteractionNCC(Object[] os) {
		String result = "";
		for (int i = 0; i < os.length; i++) {
			AggApplyVO vo = (AggApplyVO) os[i];
			ApplyVO applyVO = (ApplyVO) vo.getParentVO();
			ApplyBVO[] children = (ApplyBVO[]) vo.getChildren(ApplyBVO.class);
			
			Map<String,Object> map = new HashMap<>();
			
			Map<String,Object> headmap = new HashMap<>();
			headmap.put("pk_org", applyVO.getPk_org());
			headmap.put("pk_group", applyVO.getPk_group());
			headmap.put("bill_type", "F5");
			headmap.put("trade_type", "F5-Cxx-NC65");
			headmap.put("pk_tradetypeid","10016A100000003GEE85");//单据交易类型 F5-Cxx-NC65
			headmap.put("source_flag", "2");//来源系统
			headmap.put("def20", "F3");//外系统单据类型
			headmap.put("bill_date", new UFDateTime().toLocalString());//单据日期
			headmap.put("primal_money", applyVO.getApplysum().doubleValue());//	付款原币金额
			headmap.put("pk_currtype", "1002Z0100000000001K1");//币种 人民币
//			headmap.put("pk_balatype", "10011A100000000I4MPN");//结算方式-- 以表体为准
			headmap.put("memo", applyVO.getVbillno());//备注：付款申请编号
			headmap.put("objecttype", "1");
			headmap.put("pk_supplier", applyVO.getPk_supplier());//供应商
			headmap.put("pk_upbill", applyVO.getPk_apply());//上游单据主键   
			headmap.put("pk_account", applyVO.getPk_bankacc_r());
			headmap.put("pk_upperbill",applyVO.getPk_apply()); //付款申请主键
			headmap.put("bill_status","-1");//单据状态
			map.put("head", headmap);//表头赋值
//			map.put("billtype", "paybill");
			//pk_tradetype 
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
			Map bank = null;
			try {
				Object object = query.executeQuery("select b.accname,bdc.name from cmp_apply c inner join bd_bankaccsub b on c.pk_bankacc_r = b.pk_bankaccsub  inner join bd_bankaccbas bd on b.pk_bankaccbas  = bd.pk_bankaccbas inner join bd_bankdoc bdc on bd.pk_bankdoc = bdc.pk_bankdoc where nvl(b.dr,0)=0 and c.pk_bankacc_r = '"+applyVO.getPk_bankacc_r()+"'", new MapProcessor());
				if(object!=null){
					bank = (Map) object;
				}
			} catch (BusinessException e) {
				Logger.error(e.getMessage());
                ExceptionUtils.wrappBusinessException("调用sql发生异常："+e.getMessage());
			}			
			for (int j = 0; j < children.length; j++) {
				ApplyBVO bvo = children[j];
				Map<String,Object> map1 = new HashMap<>();
				map1.put("pk_org", bvo.getPk_org());
				map1.put("pk_group", bvo.getPk_group());
				map1.put("bill_type", "F5");//单据类型
				map1.put("trade_type", "F5-Cxx-NC65");//付款结算类型
				map1.put("pk_tradetypeid","10016A100000003GEE85");//单据交易类型
				map1.put("pk_currtype", bvo.getPk_currtype());//币种
				map1.put("bill_date", new UFDateTime().toLocalString());//制单日期applyVO.getBillmakedate().toLocalString()+" 00:00:00"
				map1.put("pay_primal", bvo.getApplymny().doubleValue());//付款原币金额 -- 申请付款金额
				map1.put("pk_oppaccount", bvo.getPk_bankacc_p());//付款账号
				map1.put("creationtime", applyVO.getCreationtime().toLocalString());//
				map1.put("direction", "-1");
				map1.put("pk_account", bvo.getPk_bankacc_r());//收款银行账户 		
				map1.put("accountopenbank", bank.get("name"));//收款银行名称 
				map1.put("accountname", bank.get("accname"));//收款账户户名 
				map1.put("pk_balatype", bvo.getPk_balatype());//结算方式--(获取)
				map1.put("objecttype", "1");
				map1.put("pk_supplier", applyVO.getPk_supplier());//供应商
				map1.put("pay_last", bvo.getApplymny().doubleValue());//实付原币金额（结算）applymny获取的是申请付款金额
				map1.put("paylocal_last", bvo.getApplymny().doubleValue());//实付本币金额（结算）applymny获取的是申请付款金额
				list.add(map1); 
			}
			
			map.put("body", list);//表体赋值
			ICallNccOpenAPIUtil CallNccOpenAPI = NCLocator.getInstance().lookup(ICallNccOpenAPIUtil.class);
			String param = JSONObject.toJSONString(map);//将数组转化成json格式
			JSONObject json = JSONObject.parseObject(param);//json数据格式转换成json对象
			
			String nccip = ConfigUtils.getValueFromProperties("nccip");
			result = CallNccOpenAPI.callAPI(nccip, json);
		}
		
		return result;
	}
	
	//成本推NCC付款结算
	@Override
	public String ExamineApproveNCC(Object[] os) {
		String result = "";
		for (int i = 0; i < os.length; i++) {
			AggPayVO vo = (AggPayVO) os[i];
			PayVO hvo = (PayVO) vo.getParentVO();
			// PayDealVO[] bvo1 = (PayDealVO[])
			// vo.getChildren(PayDealVO.class);//付款内容明细表体
			PayAccVO[] bvo2 = (PayAccVO[]) vo.getChildren(PayAccVO.class);// 账号信息表体
			// PayCostDetailVO[] bvo3 = (PayCostDetailVO[])
			// vo.getChildren(PayCostDetailVO.class);//支付成本明细表体
			// PayInfVO[] bvo4 = (PayInfVO[])
			// vo.getChildren(PayInfVO.class);//发票登记表体VO(两个不同包)

			Map<String, Object> map = new HashMap<>();

			Map<String, Object> headmap = new HashMap<>();

			IUAPQueryBS query = NCLocator.getInstance().lookup(
					IUAPQueryBS.class);
			Map org = null;
			try {
				Object object = query
						.executeQuery(
								"select g.pk_corp from fdcpm_pay_pay f inner join org_orgs o on f.pk_org  = o.pk_org inner join org_corp g on o.pk_corp = g.pk_corp where nvl(g.dr,0)=0 and f.pk_org ='"
										+ hvo.getPk_org() + "'",
								new MapProcessor());
				if (object != null) {
					org = (Map) object;
				}
			} catch (BusinessException e) {
				Logger.error(e.getMessage());
                ExceptionUtils.wrappBusinessException("调用sql发生异常："+e.getMessage());
			}
			List<BillDetailVO> billDetailVO = new ArrayList<>();
			PayAccVO[] payAccVos = (PayAccVO[])vo.getChildren(PayAccVO.class);
			if(payAccVos==null || payAccVos.length < 1){
				ExceptionUtils.wrappBusinessException("付款单："+hvo.getVbillcode()+"，没有账户信息！");
			}else if(payAccVos.length > 1){
				ExceptionUtils.wrappBusinessException("付款单："+hvo.getVbillcode()+"，账户信息数据只能是一条！");
			}
			//现汇、或者抵房字段有数，就生成结算单表体一行，结算方式现汇 10011A100000000I4MPN
			if(hvo.getVdef1() != null && SafeCompute.compare(new UFDouble(hvo.getVdef1()), UFDouble.ZERO_DBL) > 0){
				BillDetailVO bodybillvo = convertTobillBodyvo(hvo, payAccVos[0]);	
				bodybillvo.setPay_primal(new UFDouble(hvo.getVdef1()));//付款原币金额
				bodybillvo.setPay_local(new UFDouble(hvo.getVdef1()));//付款组织本币金额
				bodybillvo.setPk_balatype("10011A100000000I4MPN");			
				billDetailVO.add(bodybillvo);
			}
			if(hvo.getVdef3() != null && SafeCompute.compare(new UFDouble(hvo.getVdef3()), UFDouble.ZERO_DBL) > 0){
				BillDetailVO bodybillvo = convertTobillBodyvo(hvo, payAccVos[0]);
				bodybillvo.setPay_primal(new UFDouble(hvo.getVdef3()));//付款原币金额
				bodybillvo.setPay_local(new UFDouble(hvo.getVdef3()));//付款组织本币金额
				bodybillvo.setPk_balatype("10011A100000000I4MPN");
				billDetailVO.add(bodybillvo);
			}
			//承兑汇票字段有数，就生成结算单表体一行，结算方式承兑汇票 10011A100000000I4MPU
			if(hvo.getVdef2() != null && SafeCompute.compare(new UFDouble(hvo.getVdef2()), UFDouble.ZERO_DBL) > 0){
				BillDetailVO bodybillvo = convertTobillBodyvo(hvo, payAccVos[0]);
				bodybillvo.setPay_primal(new UFDouble(hvo.getVdef2()));//付款原币金额
				bodybillvo.setPay_local(new UFDouble(hvo.getVdef2()));//付款组织本币金额
				bodybillvo.setPk_balatype("10011A100000000I4MPU");//承兑汇票
				billDetailVO.add(bodybillvo);
			}
			//现汇或承兑或者抵房都为0或者空，扣款不为0，而且表头合同乙方和表体实际收款单位不同，传到结算，扣款金额传到结算的现汇。  added by dingxm
			if((hvo.getVdef1() == null || SafeCompute.compare(new UFDouble(hvo.getVdef1()), UFDouble.ZERO_DBL) == 0) 
					&& (hvo.getVdef2() == null || SafeCompute.compare(new UFDouble(hvo.getVdef2()), UFDouble.ZERO_DBL) == 0) 
					&& (hvo.getVdef3() == null || SafeCompute.compare(new UFDouble(hvo.getVdef3()), UFDouble.ZERO_DBL) == 0)
					&& (hvo.getVdef7() != null && SafeCompute.compare(new UFDouble(hvo.getVdef7()), UFDouble.ZERO_DBL) > 0)){
				BillDetailVO bodybillvo = convertTobillBodyvo(hvo, payAccVos[0]);
				bodybillvo.setPay_primal(new UFDouble(hvo.getVdef7()));//付款原币金额
				bodybillvo.setPay_local(new UFDouble(hvo.getVdef7()));//付款组织本币金额
				bodybillvo.setPk_balatype("10011A100000000I4MPN");//现汇
				billDetailVO.add(bodybillvo);
			}
						
			headmap.put("pk_org", org.get("pk_corp"));
			headmap.put("pk_group", hvo.getPk_group());
			headmap.put("bill_type", "F5");
			headmap.put("trade_type", "F5-Cxx-NC65");
			headmap.put("pk_tradetypeid", "10016A100000003GEE85");// 单据交易类型
			headmap.put("source_flag", "2");// 来源系统
			headmap.put("def20", "H194");// 外系统单据类型
			headmap.put("bill_date", new UFDateTime().toLocalString());// 单据日期hvo.getDbilldate().toLocalString()+ " 00:00:00"
			headmap.put("primal_money", hvo.getNorigthismny().doubleValue());// 付款原币金额// norigthismny
			headmap.put("pk_currtype", hvo.getCorigcurrencyid());// 币种--人民币// 1002Z0100000000001K1
			// headmap.put("pk_balatype", "10011A100000000I4MPN");//结算方式-- 以表体为准
			headmap.put("memo", hvo.getVbillcode());// 备注：单据编号
			headmap.put("objecttype", "1");//交易对象 -- 供应商
			headmap.put("pk_supplier", hvo.getPk_supplier());// 供应商
			headmap.put("pk_upbill", hvo.getPk_pay());// 上游单据主键
			// headmap.put("pk_account", hvo.getPk_bankacc_r());//收款银行账户-- 以表体为准
			// headmap.put("pk_upperbill",hvo.getPk_pay());
			headmap.put("bill_status", "-1");// 单据状态
			map.put("head", headmap);// 表头赋值
			// map.put("billtype", "paybill");
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			
			
			for (int j = 0; j < bvo2.length; j++) {
				PayAccVO bvo = bvo2[j];
				Map<String, Object> map1 = new HashMap<>();
				map1.put("pk_org", org.get("pk_corp"));// org.get("pk_org")
//				map1.put("pk_group", hvo.getPk_group());
				map1.put("bill_type", "F5");// 单据类型
				map1.put("trade_type", "F5-Cxx-NC65");// 付款结算类型
				map1.put("pk_tradetypeid", "10016A100000003GEE85");// 单据交易类型
				map1.put("pk_currtype", "1002Z0100000000001K1");
				map1.put("bill_date", new UFDateTime().toLocalString());
				map1.put("pay_primal", bvo.getNorigrealpaymny().doubleValue());// 付款原币金额
				map1.put("pk_oppaccount", bvo.getPk_payaccount());// 付款账号
				map1.put("creationtime", hvo.getCreationtime().toLocalString());
				map1.put("direction", "-1");
				map1.put("pk_account", bvo.getVbdef10());// 收款银行账户

				Map bank = null;
				try {
					Object object = query
							.executeQuery(
									"select b.accname,bdc.name from fdcpm_pay_pay_acc c inner join bd_bankaccsub b on c.vbdef10 = b.pk_bankaccsub inner join bd_bankaccbas bd on b.pk_bankaccbas  = bd.pk_bankaccbas inner join bd_bankdoc bdc on bd.pk_bankdoc = bdc.pk_bankdoc where nvl(b.dr,0)=0 and c.vbdef10 = '"
											+ bvo.getVbdef10() + "'",
									new MapProcessor());
					if (object != null) {
						bank = (Map) object;
					}
				} catch (BusinessException e) {
					Logger.error(e.getMessage());
	                ExceptionUtils.wrappBusinessException("调用sql发生异常："+e.getMessage());
				}

				map1.put("accountopenbank", bank.get("name"));// 收款银行名称
				map1.put("accountname", bank.get("accname"));// 收款账户户名
				map1.put("pk_balatype", bvo.getPk_paytype());// 结算方式
				map1.put("objecttype", "1");
				map1.put("pk_supplier", bvo.getPk_realreceive());// 供应商 -- 收款单位
				map1.put("pay_last", bvo.getNorigrealpaymny().doubleValue());// 实付原币金额（结算）applymny获取的是申请付款金额
				map1.put("paylocal_last", bvo.getNorigrealpaymny()
						.doubleValue());// 实付本币金额（结算）applymny获取的是申请付款金额
				list.add(map1);
			}

			map.put("body", list);// 表体赋值
			ICallNccOpenAPIUtil CallNccOpenAPI = NCLocator.getInstance().lookup(ICallNccOpenAPIUtil.class);
			String param = JSONObject.toJSONString(map);// 将数组转化成json格式
			JSONObject json = JSONObject.parseObject(param);// json数据格式转换成json对象
			String nccip = ConfigUtils.getValueFromProperties("nccip");
			result = CallNccOpenAPI.callAPI(nccip, json);
			Logger.info("22"+result);
		}
			
		return result;
	}
	
	private BillDetailVO convertTobillBodyvo(PayVO headvo,
			PayAccVO payAccvo){
		BillDetailVO bodysettlevo = new BillDetailVO();
		bodysettlevo.setStatus(VOStatus.NEW);
		//付款账户	pk_payaccount	本方账户【是否只有一行，需确认】	pk_account
		bodysettlevo.setPk_account(payAccvo.getPk_payaccount());
		//对方账号	vothernum	对方账户【是否只有一行，需确认】	tradername
		bodysettlevo.setPk_oppaccount(payAccvo.getVothernum());
		
		//备注	vmemo	备注----》摘要？	项目主键 memo
		bodysettlevo.setMemo(payAccvo.getVmemo());
		//自定义项1-5
		bodysettlevo.setDef1(payAccvo.getVbdef1());
		bodysettlevo.setDef2(payAccvo.getVbdef2());
		bodysettlevo.setDef3(payAccvo.getVbdef3());
		bodysettlevo.setDef4(payAccvo.getVbdef4());
		bodysettlevo.setDef5(payAccvo.getVbdef5());
		//方向-付
		bodysettlevo.setDirection(1);
		//币种
		bodysettlevo.setPk_currtype(headvo.getCcurrencyid());
//		bodysettlevo.setPk_group(headvo.getPk_group());
//		bodysettlevo.setPk_org(headvo.getPk_org());
		bodysettlevo.setPk_org_v(headvo.getPk_org_v());
//		bodysettlevo.setSystemcode("2");//来源系统
		bodysettlevo.setUpper_billtype(headvo.getCbilltypecode());
//		bodysettlevo.setGlobal_rate(headvo.getNexchangerate());//全局本币汇率
		return bodysettlevo;
	}
	
	//报销推NCC付款结算
	@Override
	public String ExpenseApproveNCC(Object[] os) {
		String result = "";
		for (int i = 0; i < os.length; i++) {
			BXVO vo = (BXVO) os[i];
			JKBXHeaderVO  hvo = (JKBXHeaderVO) vo.getParentVO();
			BXBusItemVO[] bbvo = (BXBusItemVO[]) vo.getChildrenVO();//表体

			Map<String, Object> map = new HashMap<>();

			IUAPQueryBS query = NCLocator.getInstance().lookup(
					IUAPQueryBS.class);
			Map bank = null;
			try {
				Object object = query
						.executeQuery(
								"select pk_org from org_orgs where isbusinessunit = 'Y' and dr = 0 and  name = '"+ hvo.getZyx1() + "'",
								new MapProcessor());
				if (object != null) {
					bank = (Map) object;
				}
			} catch (BusinessException e) {
				Logger.error(e.getMessage());
                ExceptionUtils.wrappBusinessException("调用sql发生异常："+e.getMessage());
			}
			
			Map<String, Object> headmap = new HashMap<>();
			headmap.put("pk_org", bank.get("pk_org"));//发票单位
			headmap.put("pk_group", hvo.getPk_group());
			headmap.put("bill_type", "F5");
			headmap.put("trade_type", "F5-Cxx-NC65");
			headmap.put("pk_tradetypeid", "10016A100000003GEE85");// 单据交易类型
			headmap.put("source_flag", "2");// 来源系统
			headmap.put("def20", "264X");//外系统单据类型
			headmap.put("bill_date", new UFDateTime().toLocalString());// 单据日期hvo.getDjrq().toLocalString() + " 00:00:00"
			headmap.put("primal_money", hvo.getTotal().doubleValue());// 付款原币金额
			headmap.put("pk_currtype", hvo.getBzbm());// 币种--人民币	
			headmap.put("pk_balatype", hvo.getJsfs());//结算方式-- 以表体为准
			headmap.put("memo", hvo.getDjbh());// 备注：单据编号
			headmap.put("up_tradetype", hvo.getDjlxbm());//  up_tradetype(上有单据交易类型)
			headmap.put("pk_supplier", hvo.getHbbm());// 供应商
			headmap.put("pk_upbill", hvo.getPk_jkbx());// 上游单据主键
			// headmap.put("pk_account", hvo.getPk_bankacc_r());//收款银行账户-- 以表体为准
			headmap.put("bill_status", "-1");// 单据状态
			headmap.put("up_tradetype", hvo.getPk_tradetypeid());//上游单据交易类型 
			headmap.put("payperson ", "");
			map.put("head", headmap);// 表头赋值
			// map.put("billtype", "paybill");
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
			for (int j = 0; j < bbvo.length; j++) {
				BXBusItemVO bvo = bbvo[j];
				Map<String, Object> map1 = new HashMap<>();
				map1.put("pk_org", bank.get("pk_org"));
				map1.put("pk_group", hvo.getPk_group());
				map1.put("bill_type", "F5");// 单据类型
				map1.put("trade_type", "F5-Cxx-NC65");// 付款结算类型
				map1.put("pk_tradetypeid", "10016A100000003GEE85");// 单据交易类型
				map1.put("pk_currtype", "1002Z0100000000001K1");
				map1.put("bill_date", new UFDateTime().toLocalString());
				map1.put("pay_primal", bvo.getYbje().doubleValue());// 付款原币金额	
				map1.put("pk_oppaccount", hvo.getFkyhzh());// 付款账号
				map1.put("creationtime", hvo.getCreationtime().toLocalString());
				map1.put("direction", "-1");
				
				if (0 == bvo.getPaytarget()) {
					map1.put("objecttype", "3");//交易对象类型
					map1.put("pk_account", bvo.getSkyhzh());// 收款银行账户 个人
					map1.put("pk_busiman", hvo.getJkbxr());//业务员
				}else if (1 == bvo.getPaytarget()) {
					map1.put("objecttype", "1");
					map1.put("pk_account", bvo.getCustaccount());//客商
				}else if (2 == bvo.getPaytarget()) {
					map1.put("objecttype", "0");
					map1.put("pk_account", bvo.getCustaccount());
				}
				
				try {
					Object object = query.executeQuery( "select b.name from bd_bankaccsub b inner join er_busitem e on b.pk_bankaccsub = e.skyhzh where nvl(b.dr,0)=0 and e.skyhzh = '"+ bvo.getSkyhzh() + "'", new MapProcessor());
					if (object != null) {
						bank = (Map) object;
					}
				} catch (BusinessException e) {
					Logger.error(e.getMessage());
	                ExceptionUtils.wrappBusinessException("调用sql发生异常："+e.getMessage());
				}

				map1.put("accountopenbank", bank.get("name"));// 收款银行名称
				map1.put("accountname", bvo.getReceiver());// 收款账户户名
				map1.put("pk_balatype", hvo.getJsfs());// 结算方式
				map1.put("up_tradetype", hvo.getDjlxbm());
				map1.put("pk_supplier", bvo.getHbbm());// 供应商 -- 收款单位	
				map1.put("pay_last", bvo.getYbje().doubleValue());// 实付原币金额（结算）applymny获取的是申请付款金额
				map1.put("paylocal_last", bvo.getBbje()
						.doubleValue());// 实付本币金额（结算）applymny获取的是申请付款金额
				list.add(map1);
			}

			map.put("body", list);// 表体赋值
			ICallNccOpenAPIUtil CallNccOpenAPI = NCLocator.getInstance()
					.lookup(ICallNccOpenAPIUtil.class);
			String param = JSONObject.toJSONString(map);// 将数组转化成json格式
			JSONObject json = JSONObject.parseObject(param);// json数据格式转换成json对象
			String nccip = ConfigUtils.getValueFromProperties("nccip");
			result = CallNccOpenAPI.callAPI(nccip, json);
		}
		return result;
	}

}
