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
 * 付款单审批通过传现金管理的结算单
 * @author lichsha
 *
 */
public class ApprovePaymentSettleNCC implements IRule<AggPayVO> {

	@Override
	public void process(AggPayVO[] vos) {

		if(vos == null || vos.length <1){
			return;
		}
		
		//过滤出单据状态是审批通过的付款单
		List<AggPayVO> passList = getPassedPayBill(vos);
		if(passList.size() < 1){
			return;
		}
		try {
//			generatorCmpSettlement(passList);
			//向NCC推付款结算单 -- dongqingzheng
			IPushSingleNCC single = NCLocator.getInstance().lookup(IPushSingleNCC.class);
			String result = single.ExamineApproveNCC(vos);
			Logger.info("11"+result);
		} catch (Exception e) {
			ExceptionUtils.wrappBusinessException("数据异常：" + e.getMessage());
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
		//查询付款单的单据类型+交易类型
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
		//现金管理-结算单表头
		SettlementHeadVO headsettlevo = new SettlementHeadVO();
		aggsettlevo.setParentVO(headsettlevo);

		PayVO headvo = aggPayvo.getParentVO();
		headsettlevo.setStatus(VOStatus.NEW);
		headsettlevo.setPk_group(headvo.getPk_group());
		//组织设置为对应的所属公司
		OrgVO orgvo = queryOrgvo(headvo.getPk_org());
		if(orgvo!=null){
			headsettlevo.setPk_org(orgvo.getPk_org());
			headsettlevo.setPk_org_v(orgvo.getPk_vid());
		}else{
			
			headsettlevo.setPk_org(headvo.getPk_org());
			headsettlevo.setPk_org_v(headvo.getPk_org_v());
		}
		//业务单据类型\业务单据交易类型
		headsettlevo.setPk_billtype("H194");
		headsettlevo.setPk_billtypeid("1001AA10000000008UOZ");
		headsettlevo.setPk_tradetype("H194");
		headsettlevo.setPk_tradetypeid("1001AA10000000008UOZ");
		/*if(headvo.getVtranstype() !=null){
			headsettlevo.setPk_tradetypeid(billtypeMap.get(headvo.getVtranstype()).getPk_billtypeid());
		}*/
		headsettlevo.setArithmetic(0);
		//业务单据编号
		headsettlevo.setBillcode(headvo.getVbillcode());
		//业务单据状态--审批通过
		headsettlevo.setBusistatus(1);
		//项目名称
		headsettlevo.setDef6(headvo.getPk_project());
		//业务单据日期
		headsettlevo.setBusi_billdate(headvo.getDbilldate());
		//自定义字段--最后修改时间【没有最后修改时间传创建时间】
		headsettlevo.setDef7(headvo.getModifiedtime() == null ? headvo.getCreationtime().toString() : headvo.getModifiedtime().toString());
		//自定义字段--合同号
		headsettlevo.setDef8(headvo.getPk_cont());
		//原币金额
		headsettlevo.setPrimal(headvo.getNorigthismny());
		headsettlevo.setOrglocal(headvo.getNorigthismny());
		//自定义字段1-5
		headsettlevo.setDef1(headvo.getVdef1());
		headsettlevo.setDef2(headvo.getVdef2());
		headsettlevo.setDef3(headvo.getVdef3());
		headsettlevo.setDef4(headvo.getVdef4());
		headsettlevo.setDef5(headvo.getVdef5());
		
		headsettlevo.setPk_busibill(headvo.getPrimaryKey());
		headsettlevo.setSettlestatus(0);
		headsettlevo.setDirection(1);
		headsettlevo.setAduitstatus(IWorkFlowStatus.WORKFLOW_FINISHED);
		
		//结算单表体
		PayAccVO[] payAccVos = (PayAccVO[])aggPayvo.getChildren(PayAccVO.class);
		if(payAccVos==null || payAccVos.length < 1){
			ExceptionUtils.wrappBusinessException("付款单："+headvo.getVbillcode()+"，没有账户信息！");
		}else if(payAccVos.length > 1){
			ExceptionUtils.wrappBusinessException("付款单："+headvo.getVbillcode()+"，账户信息数据只能是一条！");
		}
		List<SettlementBodyVO> settlementbodyList = new ArrayList<>();
		//现汇、或者抵房字段有数，就生成结算单表体一行，结算方式现汇 10011A100000000I4MPN
		if(headvo.getVdef1() != null && SafeCompute.compare(new UFDouble(headvo.getVdef1()), UFDouble.ZERO_DBL) > 0){
			SettlementBodyVO bodysettlevo =convertToSettlementBodyvo(headvo, payAccVos[0]);
			//现汇/抵房（表头）	vdef1/vdef3	付款原币金额、付款本币金额，结算方式--现汇	pay/paylocal
			bodysettlevo.setPay(new UFDouble(headvo.getVdef1()));
			bodysettlevo.setPaylocal(new UFDouble(headvo.getVdef1()));
			bodysettlevo.setPk_balatype("10011A100000000I4MPN");
			settlementbodyList.add(bodysettlevo);
		}
		if(headvo.getVdef3() != null && SafeCompute.compare(new UFDouble(headvo.getVdef3()), UFDouble.ZERO_DBL) > 0){
			SettlementBodyVO bodysettlevo =convertToSettlementBodyvo(headvo, payAccVos[0]);
			//现汇/抵房（表头）	vdef1/vdef3	付款原币金额、付款本币金额，结算方式--现汇	pay/paylocal
			bodysettlevo.setPay(new UFDouble(headvo.getVdef3()));
			bodysettlevo.setPaylocal(new UFDouble(headvo.getVdef3()));
			bodysettlevo.setPk_balatype("10011A100000000I4MPN");
			settlementbodyList.add(bodysettlevo);
		}
		
		//承兑汇票字段有数，就生成结算单表体一行，结算方式承兑汇票 10011A100000000I4MPU
		if(headvo.getVdef2() != null && SafeCompute.compare(new UFDouble(headvo.getVdef2()), UFDouble.ZERO_DBL) > 0){
			//承兑汇票（表头）	vdef2	付款原币金额、付款本币金额，结算方式--承兑汇票	pay/paylocal
			SettlementBodyVO bodysettlevo =convertToSettlementBodyvo(headvo, payAccVos[0]);
			//现汇/抵房（表头）	vdef1/vdef3	付款原币金额、付款本币金额，结算方式--现汇	pay/paylocal
			bodysettlevo.setPay(new UFDouble(headvo.getVdef2()));
			bodysettlevo.setPaylocal(new UFDouble(headvo.getVdef2()));
			bodysettlevo.setPk_balatype("10011A100000000I4MPU");//承兑汇票
			settlementbodyList.add(bodysettlevo);
		}
		//现汇或承兑或者抵房都为0或者空，扣款不为0，而且表头合同乙方和表体实际收款单位不同，传到结算，扣款金额传到结算的现汇。  added by dingxm
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
					bodysettlevo.setPk_balatype("10011A100000000I4MPN");//现汇
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
		bodysettlevo.setPk_group(headvo.getPk_group());
		bodysettlevo.setPk_org(headvo.getPk_org());
		bodysettlevo.setPk_org_v(headvo.getPk_org_v());
		bodysettlevo.setSystemcode("999");//来源系统
		bodysettlevo.setPk_billtype(headvo.getCbilltypecode());
		
		bodysettlevo.setPk_bill(headvo.getPrimaryKey());
		bodysettlevo.setPk_billdetail(payAccvo.getPk_pay_account());
		bodysettlevo.setLocalrate(headvo.getNexchangerate());//本币汇率
		
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
		//单据类型
		msg.setBilltype(headvo.getCbilltypecode());
		//单据号
		msg.setBillcode(headvo.getVbillcode());
		//单据的主键
		msg.setBillkey(headvo.getPrimaryKey());
		//业务单据录入人
		msg.setBillOperator(headvo.getCreator());
		//业务单据日期
		msg.setBillDate(headvo.getDbilldate());
		//
		msg.setPk_group(headvo.getPk_group());
		//组织设置为对应的所属公司
		OrgVO orgvo = queryOrgvo(headvo.getPk_org());
		if(orgvo!=null){
			msg.setPk_org(orgvo.getPk_org());
			msg.setPk_org_v(orgvo.getPk_vid());
		}else{
			
			msg.setPk_org(headvo.getPk_org());
			msg.setPk_org_v(headvo.getPk_org_v());
		}
		//原币
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
