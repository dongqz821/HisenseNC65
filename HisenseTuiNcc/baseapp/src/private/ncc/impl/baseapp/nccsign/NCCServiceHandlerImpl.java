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
 * ncc���㵥��дdongqz
 */
public class NCCServiceHandlerImpl implements INCCServiceHandler {
/*
 * ������� 
 * 2021/11/10
 */
	
	@Override
	public String examine(String ds, JSONObject json) {
		ResponseVO response = new ResponseVO();
		String result = "";
		String pk = json.getString("pk_upbill");
		try {
			if ( "F3".equals(json.getString("def20"))) {//��ϵͳ��������
				IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
				//������Դ���� �ҵ�������������������ݿ��������� ���� �� ���������
				Map bank = null;
				try {
					//sql:��ѯ�� ��Ӧ�̸�������� 
					Object object = (Map) query.executeQuery("select p.pk_paybill from cmp_apply cmp inner join ap_payitem ap on cmp.pk_apply = ap.top_billid inner join ap_paybill p on ap.pk_paybill = p.pk_paybill where p.dr = 0 and cmp.pk_apply = '"+ pk +"'", new MapProcessor());
					bank = (Map) object;
					String dettlemen = (String) bank.get("pk_paybill");
					IBillQueryService service1 = NCLocator.getInstance().lookup(IBillQueryService.class);
					AggPayBillVO payaggvo = service1.querySingleBillByPk(AggPayBillVO .class, dettlemen);
					IPFBusiAction busiAction = (IPFBusiAction)NCLocator.getInstance().lookup(IPFBusiAction.class);//���õ��ݽű�����������NC65�󲿷ֵ��ݶ�����ͨ��������������ύ���������ջأ��Ȳ���
					if ("8.0".equals(json.getString("busistatus"))) {
						busiAction.processAction("APPROVE", "F3", null, payaggvo, null, null);//�����ķ���
					}else if("1.0".equals(json.getString("busistatus"))) {
						busiAction.processAction("UNAPPROVE", "F3", null, payaggvo, null, null);//�����ķ���
					}
				} catch (Exception e){
					Logger.error(e.getMessage());
//		            ExceptionUtils.wrappBusinessException(" nc65��д����ʧ�ܣ�"+e.getMessage());
					response.setCode("100");
					response.setMsg("��дnc65����ʧ�ܣ�"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
			}else {
				return null;
			}
			response.setCode("200");
			response.setMsg("��������ɹ�");
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		} catch (Exception e) {
			Logger.error(e.getStackTrace());
			//ʧ�ܷ���
			response.setCode("100");
			response.setMsg("�����������ʧ�ܣ�"+e.getMessage());
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		}
		return result;
	}
/* 
 * ���㵥 ǩ��
 * 2021.11.15
 */
	@Override
	public String signature(String ds, JSONObject json) {
//		json.getString("pk_upbill");//���ε�������
//		json.getString("busistatus");//����״̬
//		json.getString("bill_type");//�������� F5
//		json.getString("source_flag");//��Դϵͳ 2�ֽ�����ʽ� 999��Ŀ����ɱ���
		
		//ʵҵ��Ŀ F3  
		//�ɱ� H194
		//���� 264X
		
		ResponseVO response = new ResponseVO();
		String result = "";
		String pk = json.getString("pk_upbill");
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			
			if ( "F3".equals(json.getString("def20"))) {//��ϵͳ�������� -- ��ҵ��Ŀ
				//������Դ���� �ҵ�������������������ݿ��������� ���� �� ���������
				Map bank = null;
				try {
					//sql:��ѯ�� ��Ӧ�̸�������� 
					Object object = (Map) query.executeQuery("select p.pk_paybill from cmp_apply cmp inner join ap_payitem ap on cmp.pk_apply = ap.top_billid inner join ap_paybill p on ap.pk_paybill = p.pk_paybill where p.dr = 0 and cmp.pk_apply = '"+ pk +"'", new MapProcessor());
//					BaseDAO updata = new BaseDAO();
					bank = (Map) object;
					String dettlemen = (String) bank.get("pk_paybill");
					ISettlementQueryService service = NCLocator.getInstance().lookup(ISettlementQueryService.class);//��ȡVO�Ľӿ�
					SettlementAggVO aggvo = service.querySettlementAggByPk_busibill(dettlemen);//���ݽ��㵥����Դ���� ���� ���㵥�� aggvo
					aggvo.getParentVO().setAttributeValue("signdate", new UFDate());
					ISettlementServiceRequiresNew servic = NCLocator.getInstance().lookup(ISettlementServiceRequiresNew.class);//ǩ�ֵĽӿ�
					//����״̬ 9=δȷ�ϣ�-1=���棬1=����ͨ����2=�����У�-99=�ݴ棬8=ǩ�֣�
					if ("8.0".equals(json.getString("busistatus"))) {//NCC����״̬Ϊ ����ͨ�� 
						//�޸ĸ���� ����״̬��Ϊ ��ǩ�֣� ����״̬ ��Ϊ ת�˳ɹ�
						//settleflag ����״̬0=Ĭ�ϣ�1=ת�˳ɹ���-1=ת��ʧ�ܣ�2=ת���У�11=����
//						updata.executeUpdate("update ap_paybill set billstatus = 1 where pk_paybill = '"+bank.get("pk_paybill")+"'");
						servic.handleSign_RequiresNew(aggvo);//ǩ�ֵķ���
					}else if("1.0".equals(json.getString("busistatus"))){//NCC����״̬Ϊ ǩ��
//						updata.executeUpdate("update ap_paybill t set billstatus = 1 where pk_paybill = '"+bank.get("pk_paybill")+"'");
						servic.handleCancelSign_RequiresNew(aggvo);
					}
				} catch (Exception e) {
					Logger.error(e.getMessage());
//	                ExceptionUtils.wrappBusinessException("nc65ǩ�ַ����쳣��"+e.getMessage());
					response.setCode("100");
					response.setMsg("��дNC65ǩ��ʧ��:"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
				
			}else if ("H194".equals(json.getString("def20"))) {//��ϵͳ�������� -- �ɱ�
				try {
//					
					//��ѯ���
					String dettlemen = json.getString("pk_upbill");
					IBillQueryService service1 = NCLocator.getInstance().lookup(IBillQueryService.class);
					AggPayVO payaggvo = service1.querySingleBillByPk(AggPayVO.class, dettlemen);//����������ѯ�� AggVO
					List<PayVO> hvoList = new ArrayList<>();
					PayVO headvo = payaggvo.getParentVO();
					
					if ("8.0".equals(json.getString("busistatus"))) {
						PayDealVO[] bvo = (PayDealVO[]) payaggvo.getChildrenVO();
						boolean b = false;
						for (int i = 0; i < bvo.length; i++) {
							String str = bvo[i].getPaymethod();
							if (str.equals("10011A100000000I4MPN")) {//�жϽ��㷽ʽ���ֻ�
								b = true;
								break;
							}
						}
						if (b) {
							headvo.setAttributeValue("vdef9", "��ǩ��");   
					    	headvo.setStatus(VOStatus.UPDATED);
					    	hvoList.add(headvo);
						}else{
							headvo.setAttributeValue("vdef9", "�ѽ���");   
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
//		            ExceptionUtils.wrappBusinessException(" ��дNC65ǩ��ʧ�ܣ�"+e.getMessage());
					response.setCode("100");
					response.setMsg("��дNC65ǩ��ʧ��:"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
			}else if ("264X".equals(json.getString("def20"))) { // ������д
				//������д -- ������� ����ǩ��
				Map bank = null;
				try {
					//sql:��ѯ�� ��Ӧ�̸�������� 
					ISettlementQueryService service = NCLocator.getInstance().lookup(ISettlementQueryService.class);//��ȡVO�Ľӿ�
					SettlementAggVO aggvo = service.querySettlementAggByPk_busibill(pk);//���ݽ��㵥����Դ���� ���� ���㵥�� aggvo
					aggvo.getParentVO().setAttributeValue("signdate", new UFDate());
					SettlementBodyVO[] settleaccountMap = (SettlementBodyVO[]) aggvo.getChildrenVO();
					for (SettlementBodyVO body : settleaccountMap) {
						body.setTallydate(new UFDate());
					}
					ISettlementServiceRequiresNew servic = NCLocator.getInstance().lookup(ISettlementServiceRequiresNew.class);//ǩ�ֵĽӿ�
					//����״̬ 9=δȷ�ϣ�-1=���棬1=����ͨ����2=�����У�-99=�ݴ棬8=ǩ�֣�
					if ("8.0".equals(json.getString("busistatus"))) {//NCC����״̬Ϊ ����ͨ�� 
						servic.handleSign_RequiresNew(aggvo);//ǩ�ֵķ���
					}else if("1.0".equals(json.getString("busistatus"))){//NCC����״̬Ϊ ǩ��
						servic.handleCancelSign_RequiresNew(aggvo);
					}
				} catch (Exception e) {
					Logger.error(e.getMessage());
//		            ExceptionUtils.wrappBusinessException(" ��дNC65ǩ��ʧ�ܣ�"+e.getMessage());
					response.setCode("100");
					response.setMsg("��дNC65ǩ��ʧ��:"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
			}
			
			response.setCode("200");
			response.setMsg("��д�ɹ�");
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		} catch (Exception e) {//BusinessException
			Logger.error(e.getStackTrace());
			//ʧ�ܷ���
			
			response.setCode("100");
			response.setMsg("��дʧ�ܣ�"+e.getMessage());
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		}
		
		return result;
	}

/*
 * NCC���㵥 ����Ļ�д����
 * 2021.11.21
 */
	@Override
	public String settleAccounts(String ds, JSONObject json) {//����ķ���

		ResponseVO response = new ResponseVO();
		String result = "";
		String pk = json.getString("pk_upbill");//���ε�������
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			
			if ( "F3".equals(json.getString("def20"))) {//��ϵͳ��������  -- ʵҵ��Ŀ
				//������Դ���� �ҵ�������������������ݿ��������� ���� �� ���������
				Map bank = null;
				try {
					//sql:��ѯ�� ��Ӧ�̸�������� 
					Object object = (Map) query.executeQuery("select p.pk_paybill from cmp_apply cmp inner join ap_payitem ap on cmp.pk_apply = ap.top_billid inner join ap_paybill p on ap.pk_paybill = p.pk_paybill where p.dr = 0 and cmp.pk_apply = '"+ pk +"'", new MapProcessor());
					bank = (Map) object;
					String dettlemen = (String) bank.get("pk_paybill");//��Ӧ�̸������
//					BaseDAO updata = new BaseDAO();
					ISettlementQueryService service = NCLocator.getInstance().lookup(ISettlementQueryService.class);//��ȡVO�Ľӿ�
					SettlementAggVO aggvo = service.querySettlementAggByPk_busibill(dettlemen);//���ݽ��㵥����Դ���� ���� ���㵥�� aggvo
					aggvo.getParentVO().setAttributeValue("signdate", new UFDate());
					ISettlementServiceRequiresNew servic = NCLocator.getInstance().lookup(ISettlementServiceRequiresNew.class);//����Ľӿ�
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
					//����״̬
					if ("1".equals(json.getString("settlestatus"))) {//NCC���㵥Ϊ δ���� �ֶ�ֵΪ1
						servic.handleSettle_RequiresNew(aggvo);//����ķ���
//						updata.executeUpdate("update ap_paybill set settleflag = 1 where pk_paybill = '"+dettlemen+"'");
					}else if("0".equals(json.getString("settlestatus"))){//NCC���㵥Ϊ �ѽ��� �ֶ�ֵΪ0
						serv.handleCancelSettle(sett);
//						servic.handleCancelSettle_RequiresNew(aggvo);//ȡ������ķ���
//						updata.executeUpdate("update ap_paybill set settleflag = 0 where pk_paybill = '"+dettlemen+"'");
					}
				} catch (Exception e) {
					Logger.error(e.getMessage());
//		            ExceptionUtils.wrappBusinessException("��дNC65����ʧ�ܣ�"+e.getMessage());
		            response.setCode("100");
					response.setMsg("��дNC65����ʧ��:"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
			}else if ("H194".equals(json.getString("def20"))) {// �ɱ�
				try {
					//��ѯ���
					IBillQueryService service1 = NCLocator.getInstance().lookup(IBillQueryService.class);
					AggPayVO payaggvo = service1.querySingleBillByPk(AggPayVO .class, pk);
					List<PayVO> hvoList = new ArrayList<>();
					PayVO headvo = payaggvo.getParentVO();
					if ("1".equals(json.getString("settlestatus"))) {
						headvo.setAttributeValue("vdef9", "�ѽ���");   
				    	headvo.setStatus(VOStatus.UPDATED);
				    	hvoList.add(headvo);
					}else if("0".equals(json.getString("settlestatus"))){
						headvo.setAttributeValue("vdef9", "��ǩ��"); 
				    	headvo.setStatus(VOStatus.UPDATED);
				    	hvoList.add(headvo);
					}
						
				    if(hvoList.size()>0){
				    	 new BaseDAO().updateVOArray((SuperVO[])hvoList.toArray(new PayVO[0]), new String[] { "vdef9"});    	 
				    }
				} catch (Exception e) {
					Logger.error(e.getMessage());
//		            ExceptionUtils.wrappBusinessException("��дNC65����ʧ�ܣ�"+e.getMessage());
		            response.setCode("100");
					response.setMsg("��дNC65����ʧ��:"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
			}else if ("264X".equals(json.getString("def20"))) {// ����
//				Map bank = null;
				try {
					//sql:��ѯ�� ��Ӧ�̸�������� 
					ISettlementQueryService service = NCLocator.getInstance().lookup(ISettlementQueryService.class);//��ȡVO�Ľӿ�
					SettlementAggVO aggvo = service.querySettlementAggByPk_busibill(pk);//���ݽ��㵥����Դ���� ���� ���㵥�� aggvo
					aggvo.getParentVO().setAttributeValue("signdate", new UFDate());
					SettlementBodyVO[] settleaccountMap = (SettlementBodyVO[]) aggvo.getChildrenVO();
					for (SettlementBodyVO body : settleaccountMap) {
						body.setTallydate(new UFDate());
					}
					ISettlementServiceRequiresNew servic = NCLocator.getInstance().lookup(ISettlementServiceRequiresNew.class);//����Ľӿ�
//					String dettlemen = (String) bank.get("pk_paybill");
//					BaseDAO updata = new BaseDAO();
					ISettlementService serv =  NCLocator.getInstance().lookup(ISettlementService.class);
					SettleContext sett = new SettleContext();
					List<SettlementAggVO> list = new ArrayList<>();
					list.add(aggvo);
					sett.setBeanList(list);
					sett.setGenerateOne(false);
					//����״̬
					if ("1".equals(json.getString("settlestatus"))) {//NCC���㵥Ϊ δ����
						servic.handleSettle_RequiresNew(aggvo);//����ķ���
//						updata.executeUpdate("update er_bxzb set payflag = 3 where pk_jkbx = '"+pk+"'");
					}else if("0".equals(json.getString("settlestatus"))){//NCC���㵥Ϊ �ѽ���
						serv.handleCancelSettle(sett);
//						servic.handleCancelSettle_RequiresNew(aggvo);//ȡ������ķ���
//						updata.executeUpdate("update er_bxzb set payflag = 1 where pk_jkbx = '"+pk+"'");
					}
				} catch (Exception e) {
					Logger.error(e.getMessage());
//		            ExceptionUtils.wrappBusinessException("��дNC65����ʧ�ܣ�"+e.getMessage());
		            response.setCode("100");
					response.setMsg("��дNC65����ʧ��:"+e.getMessage());
					response.setResponsetime(new UFDateTime().toStdString());
					result = JSONObject.toJSONString(response);
				}
			}
				
			response.setCode("200");
			response.setMsg("��д�ɹ�");
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		} catch (Exception e) {
			Logger.error(e.getStackTrace());
			//ʧ�ܷ���
			response.setCode("100");
			response.setMsg("��дʧ�ܣ�"+e.getMessage());
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		}
		return result;
	}
	
	/*
	 * ncc֧����д 
	 * 2021.12.21
	 * @see ncc.itf.baseapp.nccsign.INCCServiceHandler#notifyPay(java.lang.String, com.alibaba.fastjson.JSONObject)
	 */
	@Override
	public String notifyPay(String ds, JSONObject param) {
		ResponseVO response = new ResponseVO();
		String result = "";
		String pk = param.getString("pk_upbill");//���ε�������
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		BaseDAO updata = new BaseDAO();
		try {
			if ("F3".equals(param.getString("def20"))) {//��ϵͳ��������  -- ʵҵ��Ŀ
				Map bank = null;
				try {
					//sql:��ѯ�� ��Ӧ�̸�������� 
					Object object = (Map) query.executeQuery("select p.pk_paybill from cmp_apply cmp inner join ap_payitem ap on cmp.pk_apply = ap.top_billid inner join ap_paybill p on ap.pk_paybill = p.pk_paybill where p.dr = 0 and cmp.pk_apply = '"+ pk +"'", new MapProcessor());
					bank = (Map) object;
					String dettlemen = (String) bank.get("pk_paybill");//��Ӧ�̸������
					updata.executeUpdate("update ap_paybill set settleflag = 1 where pk_paybill = '"+dettlemen+"'");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if("H194".equals(param.getString("def20"))){//�ɱ�
				try {
					updata.executeUpdate("update fdcpm_pay_pay set def9 = '��֧��' where pk_jkbx = '"+pk+"'");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if("264X".equals(param.getString("def20"))){//����
				try {
					updata.executeUpdate("update er_bxzb set payflag = 3 where pk_jkbx = '"+pk+"'");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			response.setCode("200");
			response.setMsg("��д�ɹ�");
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		}catch (Exception e){
			Logger.error(e.getStackTrace());
			//ʧ�ܷ���
			response.setCode("100");
			response.setMsg("֧��ʧ�ܣ�"+e.getMessage());
			response.setResponsetime(new UFDateTime().toStdString());
			result = JSONObject.toJSONString(response);
		}
		return result;
	}

}
