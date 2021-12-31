package nc.bs.fdcpmpay.pay.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.bs.dao.BaseDAO;
import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.fdcpmpay.util.ExamineApproveNCC;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.itf.baseapp.utils.IPushSingleNCC;
import nc.itf.cmp.settlement.ISettlement;
import nc.itf.org.IBasicOrgUnitQryService;
import nc.vo.cmp.BusiStatus;
import nc.vo.cmp.SettleStatus;
import nc.vo.cmp.settlement.CmpMsg;
import nc.vo.cmp.settlement.SettlementAggVO;
import nc.vo.cmp.settlement.SettlementBatchOperateVO;
import nc.vo.cmp.settlement.SettlementBodyVO;
import nc.vo.cmp.settlement.SettlementHeadVO;
import nc.vo.fdcpmbd.pub.tool.SafeCompute;
import nc.vo.fdcpmpay.pay.AggPayVO;
import nc.vo.fdcpmpay.pay.PayAccVO;
import nc.vo.fdcpmpay.pay.PayDealVO;
import nc.vo.fdcpmpay.pay.PayVO;
import nc.vo.org.OrgVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.VOStatus;
import nc.vo.pub.billtype.BilltypeVO;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pub.pf.IPfRetCheckInfo;
import nc.vo.pub.pf.IWorkFlowStatus;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import ncc.itf.baseapp.nccsign.INCCServiceHandler;

/**
 * �������ͨ�����ֽ����Ľ��㵥
 * @author lichsha
 *
 */
public class ApprovePaymentSettleNCC implements IRule<AggPayVO> {

	@Override
	public void process(AggPayVO[] vos) {

		if(vos == null || vos.length <1){
			return;
		}
		
		//���˳�����״̬������ͨ���ĸ��
		List<AggPayVO> passList = getPassedPayBill(vos);
		if(passList.size() < 1){
			return;
		}
		try {
//			generatorCmpSettlement(passList);
			//��NCC�Ƹ�����㵥 -- dongqingzheng
			IPushSingleNCC single = NCLocator.getInstance().lookup(IPushSingleNCC.class);
			String result = single.ExamineApproveNCC(vos);
			Logger.info("11"+result);
		} catch (Exception e) {
			ExceptionUtils.wrappBusinessException("�����쳣��" + e.getMessage());
		}
		
	}

	private List<AggPayVO> getPassedPayBill(AggPayVO[] vos){
		List<AggPayVO> passList = new ArrayList<AggPayVO>();
		
		for(AggPayVO aggvo : vos){
			PayVO headvo = aggvo.getParentVO();
			if(IPfRetCheckInfo.PASSING == headvo.getFstatusflag()
					&& (SafeCompute.compare(new UFDouble(headvo.getVdef1()), UFDouble.ZERO_DBL) > 0 
							|| SafeCompute.compare(new UFDouble(headvo.getVdef3()), UFDouble.ZERO_DBL) > 0 
							|| SafeCompute.compare(new UFDouble(headvo.getVdef2()), UFDouble.ZERO_DBL) > 0)){
				passList.add(aggvo);
			}
		}
		
		return passList;
	}
	
	
	private void generatorCmpSettlement(List<AggPayVO> passList) throws BusinessException{
		//��ѯ����ĵ�������+��������
		queryTranstypeByBilltype(passList.get(0).getParentVO().getCbilltypecode());
		
		List<SettlementBatchOperateVO> settleOperatevos = new ArrayList<>();
		for(AggPayVO aggPayvo : passList){
			
			SettlementBatchOperateVO operatevo = new SettlementBatchOperateVO();
			operatevo.setBusibill(aggPayvo);
			//
			SettlementAggVO aggsettlevo = new SettlementAggVO();
			convertPayBilltoSettlement(aggsettlevo, aggPayvo);
			aggPayvo.setSettlementInfo(aggsettlevo);
			//
			CmpMsg msg = new CmpMsg();
			initCmpMsg(msg, aggPayvo);
			operatevo.setMsg(msg);
			
			settleOperatevos.add(operatevo);
			
		}
		
		
		ISettlement settleService = NCLocator.getInstance().lookup(ISettlement.class);
		settleService.notifySettlementBatchSave(settleOperatevos.toArray(new SettlementBatchOperateVO[0]));
	}
	
	
	private void convertPayBilltoSettlement(SettlementAggVO aggsettlevo, AggPayVO aggPayvo) throws BusinessException{
		//�ֽ����-���㵥��ͷ
		SettlementHeadVO headsettlevo = new SettlementHeadVO();
		aggsettlevo.setParentVO(headsettlevo);

		PayVO headvo = aggPayvo.getParentVO();
		headsettlevo.setStatus(VOStatus.NEW);
		headsettlevo.setPk_group(headvo.getPk_group());
		//��֯����Ϊ��Ӧ��������˾
		OrgVO orgvo = queryOrgvo(headvo.getPk_org());
		if(orgvo!=null){
			headsettlevo.setPk_org(orgvo.getPk_org());
			headsettlevo.setPk_org_v(orgvo.getPk_vid());
		}else{
			
			headsettlevo.setPk_org(headvo.getPk_org());
			headsettlevo.setPk_org_v(headvo.getPk_org_v());
		}
		//ҵ�񵥾�����\ҵ�񵥾ݽ�������
		headsettlevo.setPk_billtype("H194");
		headsettlevo.setPk_billtypeid("1001AA10000000008UOZ");
		headsettlevo.setPk_tradetype("H194");
		headsettlevo.setPk_tradetypeid("1001AA10000000008UOZ");
		/*if(headvo.getVtranstype() !=null){
			headsettlevo.setPk_tradetypeid(billtypeMap.get(headvo.getVtranstype()).getPk_billtypeid());
		}*/
		headsettlevo.setArithmetic(0);
		//ҵ�񵥾ݱ��
		headsettlevo.setBillcode(headvo.getVbillcode());
		//ҵ�񵥾�״̬--����ͨ��
		headsettlevo.setBusistatus(1);
		//��Ŀ����
		headsettlevo.setDef6(headvo.getPk_project());
		//ҵ�񵥾�����
		headsettlevo.setBusi_billdate(headvo.getDbilldate());
		//�Զ����ֶ�--����޸�ʱ�䡾û������޸�ʱ�䴫����ʱ�䡿
		headsettlevo.setDef7(headvo.getModifiedtime() == null ? headvo.getCreationtime().toString() : headvo.getModifiedtime().toString());
		//�Զ����ֶ�--��ͬ��
		headsettlevo.setDef8(headvo.getPk_cont());
		//ԭ�ҽ��
		headsettlevo.setPrimal(headvo.getNorigthismny());
		headsettlevo.setOrglocal(headvo.getNorigthismny());
		//�Զ����ֶ�1-5
		headsettlevo.setDef1(headvo.getVdef1());
		headsettlevo.setDef2(headvo.getVdef2());
		headsettlevo.setDef3(headvo.getVdef3());
		headsettlevo.setDef4(headvo.getVdef4());
		headsettlevo.setDef5(headvo.getVdef5());
		
		headsettlevo.setPk_busibill(headvo.getPrimaryKey());
		headsettlevo.setSettlestatus(0);
		headsettlevo.setDirection(1);
		headsettlevo.setAduitstatus(IWorkFlowStatus.WORKFLOW_FINISHED);
		
		//���㵥����
		PayAccVO[] payAccVos = (PayAccVO[])aggPayvo.getChildren(PayAccVO.class);
		if(payAccVos==null || payAccVos.length < 1){
			ExceptionUtils.wrappBusinessException("�����"+headvo.getVbillcode()+"��û���˻���Ϣ��");
		}else if(payAccVos.length > 1){
			ExceptionUtils.wrappBusinessException("�����"+headvo.getVbillcode()+"���˻���Ϣ����ֻ����һ����");
		}
		List<SettlementBodyVO> settlementbodyList = new ArrayList<>();
		//�ֻ㡢���ߵַ��ֶ������������ɽ��㵥����һ�У����㷽ʽ�ֻ� 10011A100000000I4MPN
		if(headvo.getVdef1() != null && SafeCompute.compare(new UFDouble(headvo.getVdef1()), UFDouble.ZERO_DBL) > 0){
			SettlementBodyVO bodysettlevo =convertToSettlementBodyvo(headvo, payAccVos[0]);
			//�ֻ�/�ַ�����ͷ��	vdef1/vdef3	����ԭ�ҽ�����ҽ����㷽ʽ--�ֻ�	pay/paylocal
			bodysettlevo.setPay(new UFDouble(headvo.getVdef1()));
			bodysettlevo.setPaylocal(new UFDouble(headvo.getVdef1()));
			bodysettlevo.setPk_balatype("10011A100000000I4MPN");
			settlementbodyList.add(bodysettlevo);
		}
		if(headvo.getVdef3() != null && SafeCompute.compare(new UFDouble(headvo.getVdef3()), UFDouble.ZERO_DBL) > 0){
			SettlementBodyVO bodysettlevo =convertToSettlementBodyvo(headvo, payAccVos[0]);
			//�ֻ�/�ַ�����ͷ��	vdef1/vdef3	����ԭ�ҽ�����ҽ����㷽ʽ--�ֻ�	pay/paylocal
			bodysettlevo.setPay(new UFDouble(headvo.getVdef3()));
			bodysettlevo.setPaylocal(new UFDouble(headvo.getVdef3()));
			bodysettlevo.setPk_balatype("10011A100000000I4MPN");
			settlementbodyList.add(bodysettlevo);
		}
		
		//�жһ�Ʊ�ֶ������������ɽ��㵥����һ�У����㷽ʽ�жһ�Ʊ 10011A100000000I4MPU
		if(headvo.getVdef2() != null && SafeCompute.compare(new UFDouble(headvo.getVdef2()), UFDouble.ZERO_DBL) > 0){
			//�жһ�Ʊ����ͷ��	vdef2	����ԭ�ҽ�����ҽ����㷽ʽ--�жһ�Ʊ	pay/paylocal
			SettlementBodyVO bodysettlevo =convertToSettlementBodyvo(headvo, payAccVos[0]);
			//�ֻ�/�ַ�����ͷ��	vdef1/vdef3	����ԭ�ҽ�����ҽ����㷽ʽ--�ֻ�	pay/paylocal
			bodysettlevo.setPay(new UFDouble(headvo.getVdef2()));
			bodysettlevo.setPaylocal(new UFDouble(headvo.getVdef2()));
			bodysettlevo.setPk_balatype("10011A100000000I4MPU");//�жһ�Ʊ
			settlementbodyList.add(bodysettlevo);
		}
		//�ֻ��жһ��ߵַ���Ϊ0���߿գ��ۿΪ0�����ұ�ͷ��ͬ�ҷ��ͱ���ʵ���տλ��ͬ���������㣬�ۿ����������ֻ㡣  added by dingxm
		if((headvo.getVdef1() == null || SafeCompute.compare(new UFDouble(headvo.getVdef1()), UFDouble.ZERO_DBL) == 0) 
				&& (headvo.getVdef2() == null || SafeCompute.compare(new UFDouble(headvo.getVdef2()), UFDouble.ZERO_DBL) == 0) 
				&& (headvo.getVdef3() == null || SafeCompute.compare(new UFDouble(headvo.getVdef3()), UFDouble.ZERO_DBL) == 0)
				&& (headvo.getVdef7() != null && SafeCompute.compare(new UFDouble(headvo.getVdef7()), UFDouble.ZERO_DBL) > 0)){
			String pk_second = headvo.getPk_second();
			PayDealVO[] dealVOs = (PayDealVO[]) aggPayvo.getChildren(PayDealVO.class);
			if(dealVOs!=null && dealVOs.length>0){
				String pk_realreceive = dealVOs[0].getPk_realreceive();
				if(pk_second!=null && !pk_second.equals(pk_realreceive)){
					SettlementBodyVO bodysettlevo =convertToSettlementBodyvo(headvo, payAccVos[0]);
					bodysettlevo.setPay(new UFDouble(headvo.getVdef7()));
					bodysettlevo.setPaylocal(new UFDouble(headvo.getVdef7()));
					bodysettlevo.setPk_balatype("10011A100000000I4MPN");//�ֻ�
					settlementbodyList.add(bodysettlevo);
				}
			}
			
			
		}
		
		aggsettlevo.setChildrenVO(settlementbodyList.toArray(new SettlementBodyVO[0]));
	}
	
	private SettlementBodyVO convertToSettlementBodyvo(PayVO headvo,
			PayAccVO payAccvo){
		SettlementBodyVO bodysettlevo = new SettlementBodyVO();
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
		bodysettlevo.setPk_group(headvo.getPk_group());
		bodysettlevo.setPk_org(headvo.getPk_org());
		bodysettlevo.setPk_org_v(headvo.getPk_org_v());
		bodysettlevo.setSystemcode("999");//��Դϵͳ
		bodysettlevo.setPk_billtype(headvo.getCbilltypecode());
		
		bodysettlevo.setPk_bill(headvo.getPrimaryKey());
		bodysettlevo.setPk_billdetail(payAccvo.getPk_pay_account());
		bodysettlevo.setLocalrate(headvo.getNexchangerate());//���һ���
		
		return bodysettlevo;
	}
	
	
	private Map<String,BilltypeVO> billtypeMap = null;
	private Map<String,BilltypeVO> queryTranstypeByBilltype(String billtypecode) throws BusinessException{
		
		Collection<BilltypeVO> ctn = dao.retrieveByClause(BilltypeVO.class, " (pk_billtypecode ='"+billtypecode+"' or parentbilltype ='"+billtypecode+"') ", 
				new String[]{BilltypeVO.PK_BILLTYPECODE,BilltypeVO.BILLTYPENAME,BilltypeVO.PK_BILLTYPE_ID});
		
		billtypeMap = new HashMap<String,BilltypeVO>();
		
		for(BilltypeVO vo : ctn){
			billtypeMap.put(vo.getPk_billtypecode(), vo);
		}
		
		return billtypeMap;
	}
	
	private void initCmpMsg(CmpMsg msg, AggPayVO aggPayvo) throws BusinessException{
		PayVO headvo = aggPayvo.getParentVO();
		//��������
		msg.setBilltype(headvo.getCbilltypecode());
		//���ݺ�
		msg.setBillcode(headvo.getVbillcode());
		//���ݵ�����
		msg.setBillkey(headvo.getPrimaryKey());
		//ҵ�񵥾�¼����
		msg.setBillOperator(headvo.getCreator());
		//ҵ�񵥾�����
		msg.setBillDate(headvo.getDbilldate());
		//
		msg.setPk_group(headvo.getPk_group());
		//��֯����Ϊ��Ӧ��������˾
		OrgVO orgvo = queryOrgvo(headvo.getPk_org());
		if(orgvo!=null){
			msg.setPk_org(orgvo.getPk_org());
			msg.setPk_org_v(orgvo.getPk_vid());
		}else{
			
			msg.setPk_org(headvo.getPk_org());
			msg.setPk_org_v(headvo.getPk_org_v());
		}
		//ԭ��
		msg.setPrimal(headvo.getNorigthismny());
		msg.setLocal(headvo.getNorigthismny());
		
		msg.setBusistatus( BusiStatus.Save);
		msg.setSettlestatus(SettleStatus.NONESETTLE);
		
		msg.setPk_upbill(headvo.getPrimaryKey());
	}
	
	private Map<String,OrgVO> orgMap = new HashMap();
	private OrgVO queryOrgvo(String pk_org) throws BusinessException{
		
		if(orgMap.containsKey(pk_org)){
			return orgMap.get(pk_org);
		}
		
		OrgVO orgvo = NCLocator.getInstance().lookup(IBasicOrgUnitQryService.class).getOrg(pk_org);
		
		orgvo = NCLocator.getInstance().lookup(IBasicOrgUnitQryService.class).getOrg(orgvo.getPk_corp());
		
		orgMap.put(pk_org, orgvo);
		
		return orgvo;
	}
	
	private BaseDAO dao = new BaseDAO();
}
