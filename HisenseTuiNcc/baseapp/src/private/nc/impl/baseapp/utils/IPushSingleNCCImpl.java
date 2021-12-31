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
 * NC65��NCC�Ƹ�����㵥 dongqz
 */
public class IPushSingleNCCImpl implements IPushSingleNCC{
	//�ʽ���NCC������� dongqz
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
			headmap.put("pk_tradetypeid","10016A100000003GEE85");//���ݽ������� F5-Cxx-NC65
			headmap.put("source_flag", "2");//��Դϵͳ
			headmap.put("def20", "F3");//��ϵͳ��������
			headmap.put("bill_date", new UFDateTime().toLocalString());//��������
			headmap.put("primal_money", applyVO.getApplysum().doubleValue());//	����ԭ�ҽ��
			headmap.put("pk_currtype", "1002Z0100000000001K1");//���� �����
//			headmap.put("pk_balatype", "10011A100000000I4MPN");//���㷽ʽ-- �Ա���Ϊ׼
			headmap.put("memo", applyVO.getVbillno());//��ע������������
			headmap.put("objecttype", "1");
			headmap.put("pk_supplier", applyVO.getPk_supplier());//��Ӧ��
			headmap.put("pk_upbill", applyVO.getPk_apply());//���ε�������   
			headmap.put("pk_account", applyVO.getPk_bankacc_r());
			headmap.put("pk_upperbill",applyVO.getPk_apply()); //������������
			headmap.put("bill_status","-1");//����״̬
			map.put("head", headmap);//��ͷ��ֵ
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
                ExceptionUtils.wrappBusinessException("����sql�����쳣��"+e.getMessage());
			}			
			for (int j = 0; j < children.length; j++) {
				ApplyBVO bvo = children[j];
				Map<String,Object> map1 = new HashMap<>();
				map1.put("pk_org", bvo.getPk_org());
				map1.put("pk_group", bvo.getPk_group());
				map1.put("bill_type", "F5");//��������
				map1.put("trade_type", "F5-Cxx-NC65");//�����������
				map1.put("pk_tradetypeid","10016A100000003GEE85");//���ݽ�������
				map1.put("pk_currtype", bvo.getPk_currtype());//����
				map1.put("bill_date", new UFDateTime().toLocalString());//�Ƶ�����applyVO.getBillmakedate().toLocalString()+" 00:00:00"
				map1.put("pay_primal", bvo.getApplymny().doubleValue());//����ԭ�ҽ�� -- ���븶����
				map1.put("pk_oppaccount", bvo.getPk_bankacc_p());//�����˺�
				map1.put("creationtime", applyVO.getCreationtime().toLocalString());//
				map1.put("direction", "-1");
				map1.put("pk_account", bvo.getPk_bankacc_r());//�տ������˻� 		
				map1.put("accountopenbank", bank.get("name"));//�տ��������� 
				map1.put("accountname", bank.get("accname"));//�տ��˻����� 
				map1.put("pk_balatype", bvo.getPk_balatype());//���㷽ʽ--(��ȡ)
				map1.put("objecttype", "1");
				map1.put("pk_supplier", applyVO.getPk_supplier());//��Ӧ��
				map1.put("pay_last", bvo.getApplymny().doubleValue());//ʵ��ԭ�ҽ����㣩applymny��ȡ�������븶����
				map1.put("paylocal_last", bvo.getApplymny().doubleValue());//ʵ�����ҽ����㣩applymny��ȡ�������븶����
				list.add(map1); 
			}
			
			map.put("body", list);//���帳ֵ
			ICallNccOpenAPIUtil CallNccOpenAPI = NCLocator.getInstance().lookup(ICallNccOpenAPIUtil.class);
			String param = JSONObject.toJSONString(map);//������ת����json��ʽ
			JSONObject json = JSONObject.parseObject(param);//json���ݸ�ʽת����json����
			
			String nccip = ConfigUtils.getValueFromProperties("nccip");
			result = CallNccOpenAPI.callAPI(nccip, json);
		}
		
		return result;
	}
	
	//�ɱ���NCC�������
	@Override
	public String ExamineApproveNCC(Object[] os) {
		String result = "";
		for (int i = 0; i < os.length; i++) {
			AggPayVO vo = (AggPayVO) os[i];
			PayVO hvo = (PayVO) vo.getParentVO();
			// PayDealVO[] bvo1 = (PayDealVO[])
			// vo.getChildren(PayDealVO.class);//����������ϸ����
			PayAccVO[] bvo2 = (PayAccVO[]) vo.getChildren(PayAccVO.class);// �˺���Ϣ����
			// PayCostDetailVO[] bvo3 = (PayCostDetailVO[])
			// vo.getChildren(PayCostDetailVO.class);//֧���ɱ���ϸ����
			// PayInfVO[] bvo4 = (PayInfVO[])
			// vo.getChildren(PayInfVO.class);//��Ʊ�ǼǱ���VO(������ͬ��)

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
                ExceptionUtils.wrappBusinessException("����sql�����쳣��"+e.getMessage());
			}
			List<BillDetailVO> billDetailVO = new ArrayList<>();
			PayAccVO[] payAccVos = (PayAccVO[])vo.getChildren(PayAccVO.class);
			if(payAccVos==null || payAccVos.length < 1){
				ExceptionUtils.wrappBusinessException("�����"+hvo.getVbillcode()+"��û���˻���Ϣ��");
			}else if(payAccVos.length > 1){
				ExceptionUtils.wrappBusinessException("�����"+hvo.getVbillcode()+"���˻���Ϣ����ֻ����һ����");
			}
			//�ֻ㡢���ߵַ��ֶ������������ɽ��㵥����һ�У����㷽ʽ�ֻ� 10011A100000000I4MPN
			if(hvo.getVdef1() != null && SafeCompute.compare(new UFDouble(hvo.getVdef1()), UFDouble.ZERO_DBL) > 0){
				BillDetailVO bodybillvo = convertTobillBodyvo(hvo, payAccVos[0]);	
				bodybillvo.setPay_primal(new UFDouble(hvo.getVdef1()));//����ԭ�ҽ��
				bodybillvo.setPay_local(new UFDouble(hvo.getVdef1()));//������֯���ҽ��
				bodybillvo.setPk_balatype("10011A100000000I4MPN");			
				billDetailVO.add(bodybillvo);
			}
			if(hvo.getVdef3() != null && SafeCompute.compare(new UFDouble(hvo.getVdef3()), UFDouble.ZERO_DBL) > 0){
				BillDetailVO bodybillvo = convertTobillBodyvo(hvo, payAccVos[0]);
				bodybillvo.setPay_primal(new UFDouble(hvo.getVdef3()));//����ԭ�ҽ��
				bodybillvo.setPay_local(new UFDouble(hvo.getVdef3()));//������֯���ҽ��
				bodybillvo.setPk_balatype("10011A100000000I4MPN");
				billDetailVO.add(bodybillvo);
			}
			//�жһ�Ʊ�ֶ������������ɽ��㵥����һ�У����㷽ʽ�жһ�Ʊ 10011A100000000I4MPU
			if(hvo.getVdef2() != null && SafeCompute.compare(new UFDouble(hvo.getVdef2()), UFDouble.ZERO_DBL) > 0){
				BillDetailVO bodybillvo = convertTobillBodyvo(hvo, payAccVos[0]);
				bodybillvo.setPay_primal(new UFDouble(hvo.getVdef2()));//����ԭ�ҽ��
				bodybillvo.setPay_local(new UFDouble(hvo.getVdef2()));//������֯���ҽ��
				bodybillvo.setPk_balatype("10011A100000000I4MPU");//�жһ�Ʊ
				billDetailVO.add(bodybillvo);
			}
			//�ֻ��жһ��ߵַ���Ϊ0���߿գ��ۿΪ0�����ұ�ͷ��ͬ�ҷ��ͱ���ʵ���տλ��ͬ���������㣬�ۿ����������ֻ㡣  added by dingxm
			if((hvo.getVdef1() == null || SafeCompute.compare(new UFDouble(hvo.getVdef1()), UFDouble.ZERO_DBL) == 0) 
					&& (hvo.getVdef2() == null || SafeCompute.compare(new UFDouble(hvo.getVdef2()), UFDouble.ZERO_DBL) == 0) 
					&& (hvo.getVdef3() == null || SafeCompute.compare(new UFDouble(hvo.getVdef3()), UFDouble.ZERO_DBL) == 0)
					&& (hvo.getVdef7() != null && SafeCompute.compare(new UFDouble(hvo.getVdef7()), UFDouble.ZERO_DBL) > 0)){
				BillDetailVO bodybillvo = convertTobillBodyvo(hvo, payAccVos[0]);
				bodybillvo.setPay_primal(new UFDouble(hvo.getVdef7()));//����ԭ�ҽ��
				bodybillvo.setPay_local(new UFDouble(hvo.getVdef7()));//������֯���ҽ��
				bodybillvo.setPk_balatype("10011A100000000I4MPN");//�ֻ�
				billDetailVO.add(bodybillvo);
			}
						
			headmap.put("pk_org", org.get("pk_corp"));
			headmap.put("pk_group", hvo.getPk_group());
			headmap.put("bill_type", "F5");
			headmap.put("trade_type", "F5-Cxx-NC65");
			headmap.put("pk_tradetypeid", "10016A100000003GEE85");// ���ݽ�������
			headmap.put("source_flag", "2");// ��Դϵͳ
			headmap.put("def20", "H194");// ��ϵͳ��������
			headmap.put("bill_date", new UFDateTime().toLocalString());// ��������hvo.getDbilldate().toLocalString()+ " 00:00:00"
			headmap.put("primal_money", hvo.getNorigthismny().doubleValue());// ����ԭ�ҽ��// norigthismny
			headmap.put("pk_currtype", hvo.getCorigcurrencyid());// ����--�����// 1002Z0100000000001K1
			// headmap.put("pk_balatype", "10011A100000000I4MPN");//���㷽ʽ-- �Ա���Ϊ׼
			headmap.put("memo", hvo.getVbillcode());// ��ע�����ݱ��
			headmap.put("objecttype", "1");//���׶��� -- ��Ӧ��
			headmap.put("pk_supplier", hvo.getPk_supplier());// ��Ӧ��
			headmap.put("pk_upbill", hvo.getPk_pay());// ���ε�������
			// headmap.put("pk_account", hvo.getPk_bankacc_r());//�տ������˻�-- �Ա���Ϊ׼
			// headmap.put("pk_upperbill",hvo.getPk_pay());
			headmap.put("bill_status", "-1");// ����״̬
			map.put("head", headmap);// ��ͷ��ֵ
			// map.put("billtype", "paybill");
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			
			
			for (int j = 0; j < bvo2.length; j++) {
				PayAccVO bvo = bvo2[j];
				Map<String, Object> map1 = new HashMap<>();
				map1.put("pk_org", org.get("pk_corp"));// org.get("pk_org")
//				map1.put("pk_group", hvo.getPk_group());
				map1.put("bill_type", "F5");// ��������
				map1.put("trade_type", "F5-Cxx-NC65");// �����������
				map1.put("pk_tradetypeid", "10016A100000003GEE85");// ���ݽ�������
				map1.put("pk_currtype", "1002Z0100000000001K1");
				map1.put("bill_date", new UFDateTime().toLocalString());
				map1.put("pay_primal", bvo.getNorigrealpaymny().doubleValue());// ����ԭ�ҽ��
				map1.put("pk_oppaccount", bvo.getPk_payaccount());// �����˺�
				map1.put("creationtime", hvo.getCreationtime().toLocalString());
				map1.put("direction", "-1");
				map1.put("pk_account", bvo.getVbdef10());// �տ������˻�

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
	                ExceptionUtils.wrappBusinessException("����sql�����쳣��"+e.getMessage());
				}

				map1.put("accountopenbank", bank.get("name"));// �տ���������
				map1.put("accountname", bank.get("accname"));// �տ��˻�����
				map1.put("pk_balatype", bvo.getPk_paytype());// ���㷽ʽ
				map1.put("objecttype", "1");
				map1.put("pk_supplier", bvo.getPk_realreceive());// ��Ӧ�� -- �տλ
				map1.put("pay_last", bvo.getNorigrealpaymny().doubleValue());// ʵ��ԭ�ҽ����㣩applymny��ȡ�������븶����
				map1.put("paylocal_last", bvo.getNorigrealpaymny()
						.doubleValue());// ʵ�����ҽ����㣩applymny��ȡ�������븶����
				list.add(map1);
			}

			map.put("body", list);// ���帳ֵ
			ICallNccOpenAPIUtil CallNccOpenAPI = NCLocator.getInstance().lookup(ICallNccOpenAPIUtil.class);
			String param = JSONObject.toJSONString(map);// ������ת����json��ʽ
			JSONObject json = JSONObject.parseObject(param);// json���ݸ�ʽת����json����
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
		//�����˻�	pk_payaccount	�����˻����Ƿ�ֻ��һ�У���ȷ�ϡ�	pk_account
		bodysettlevo.setPk_account(payAccvo.getPk_payaccount());
		//�Է��˺�	vothernum	�Է��˻����Ƿ�ֻ��һ�У���ȷ�ϡ�	tradername
		bodysettlevo.setPk_oppaccount(payAccvo.getVothernum());
		
		//��ע	vmemo	��ע----��ժҪ��	��Ŀ���� memo
		bodysettlevo.setMemo(payAccvo.getVmemo());
		//�Զ�����1-5
		bodysettlevo.setDef1(payAccvo.getVbdef1());
		bodysettlevo.setDef2(payAccvo.getVbdef2());
		bodysettlevo.setDef3(payAccvo.getVbdef3());
		bodysettlevo.setDef4(payAccvo.getVbdef4());
		bodysettlevo.setDef5(payAccvo.getVbdef5());
		//����-��
		bodysettlevo.setDirection(1);
		//����
		bodysettlevo.setPk_currtype(headvo.getCcurrencyid());
//		bodysettlevo.setPk_group(headvo.getPk_group());
//		bodysettlevo.setPk_org(headvo.getPk_org());
		bodysettlevo.setPk_org_v(headvo.getPk_org_v());
//		bodysettlevo.setSystemcode("2");//��Դϵͳ
		bodysettlevo.setUpper_billtype(headvo.getCbilltypecode());
//		bodysettlevo.setGlobal_rate(headvo.getNexchangerate());//ȫ�ֱ��һ���
		return bodysettlevo;
	}
	
	//������NCC�������
	@Override
	public String ExpenseApproveNCC(Object[] os) {
		String result = "";
		for (int i = 0; i < os.length; i++) {
			BXVO vo = (BXVO) os[i];
			JKBXHeaderVO  hvo = (JKBXHeaderVO) vo.getParentVO();
			BXBusItemVO[] bbvo = (BXBusItemVO[]) vo.getChildrenVO();//����

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
                ExceptionUtils.wrappBusinessException("����sql�����쳣��"+e.getMessage());
			}
			
			Map<String, Object> headmap = new HashMap<>();
			headmap.put("pk_org", bank.get("pk_org"));//��Ʊ��λ
			headmap.put("pk_group", hvo.getPk_group());
			headmap.put("bill_type", "F5");
			headmap.put("trade_type", "F5-Cxx-NC65");
			headmap.put("pk_tradetypeid", "10016A100000003GEE85");// ���ݽ�������
			headmap.put("source_flag", "2");// ��Դϵͳ
			headmap.put("def20", "264X");//��ϵͳ��������
			headmap.put("bill_date", new UFDateTime().toLocalString());// ��������hvo.getDjrq().toLocalString() + " 00:00:00"
			headmap.put("primal_money", hvo.getTotal().doubleValue());// ����ԭ�ҽ��
			headmap.put("pk_currtype", hvo.getBzbm());// ����--�����	
			headmap.put("pk_balatype", hvo.getJsfs());//���㷽ʽ-- �Ա���Ϊ׼
			headmap.put("memo", hvo.getDjbh());// ��ע�����ݱ��
			headmap.put("up_tradetype", hvo.getDjlxbm());//  up_tradetype(���е��ݽ�������)
			headmap.put("pk_supplier", hvo.getHbbm());// ��Ӧ��
			headmap.put("pk_upbill", hvo.getPk_jkbx());// ���ε�������
			// headmap.put("pk_account", hvo.getPk_bankacc_r());//�տ������˻�-- �Ա���Ϊ׼
			headmap.put("bill_status", "-1");// ����״̬
			headmap.put("up_tradetype", hvo.getPk_tradetypeid());//���ε��ݽ������� 
			headmap.put("payperson ", "");
			map.put("head", headmap);// ��ͷ��ֵ
			// map.put("billtype", "paybill");
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		
			for (int j = 0; j < bbvo.length; j++) {
				BXBusItemVO bvo = bbvo[j];
				Map<String, Object> map1 = new HashMap<>();
				map1.put("pk_org", bank.get("pk_org"));
				map1.put("pk_group", hvo.getPk_group());
				map1.put("bill_type", "F5");// ��������
				map1.put("trade_type", "F5-Cxx-NC65");// �����������
				map1.put("pk_tradetypeid", "10016A100000003GEE85");// ���ݽ�������
				map1.put("pk_currtype", "1002Z0100000000001K1");
				map1.put("bill_date", new UFDateTime().toLocalString());
				map1.put("pay_primal", bvo.getYbje().doubleValue());// ����ԭ�ҽ��	
				map1.put("pk_oppaccount", hvo.getFkyhzh());// �����˺�
				map1.put("creationtime", hvo.getCreationtime().toLocalString());
				map1.put("direction", "-1");
				
				if (0 == bvo.getPaytarget()) {
					map1.put("objecttype", "3");//���׶�������
					map1.put("pk_account", bvo.getSkyhzh());// �տ������˻� ����
					map1.put("pk_busiman", hvo.getJkbxr());//ҵ��Ա
				}else if (1 == bvo.getPaytarget()) {
					map1.put("objecttype", "1");
					map1.put("pk_account", bvo.getCustaccount());//����
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
	                ExceptionUtils.wrappBusinessException("����sql�����쳣��"+e.getMessage());
				}

				map1.put("accountopenbank", bank.get("name"));// �տ���������
				map1.put("accountname", bvo.getReceiver());// �տ��˻�����
				map1.put("pk_balatype", hvo.getJsfs());// ���㷽ʽ
				map1.put("up_tradetype", hvo.getDjlxbm());
				map1.put("pk_supplier", bvo.getHbbm());// ��Ӧ�� -- �տλ	
				map1.put("pay_last", bvo.getYbje().doubleValue());// ʵ��ԭ�ҽ����㣩applymny��ȡ�������븶����
				map1.put("paylocal_last", bvo.getBbje()
						.doubleValue());// ʵ�����ҽ����㣩applymny��ȡ�������븶����
				list.add(map1);
			}

			map.put("body", list);// ���帳ֵ
			ICallNccOpenAPIUtil CallNccOpenAPI = NCLocator.getInstance()
					.lookup(ICallNccOpenAPIUtil.class);
			String param = JSONObject.toJSONString(map);// ������ת����json��ʽ
			JSONObject json = JSONObject.parseObject(param);// json���ݸ�ʽת����json����
			String nccip = ConfigUtils.getValueFromProperties("nccip");
			result = CallNccOpenAPI.callAPI(nccip, json);
		}
		return result;
	}

}
