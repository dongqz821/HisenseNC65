package nc.bs.pub.action;
import nc.bs.fdcpmpay.pay.plugin.bpplugin.FDCPMPAYPayPluginPoint;
import nc.bs.fdcpmpay.pay.rules.ApproveGeneratorCmpSettlementRule;
import nc.bs.fdcpmpay.pay.rules.ApprovePaymentSettleNCC;
import nc.bs.fdcpmpay.pay.rules.SendVoucherRule;
import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.itf.fdcpmpay.IFDCPMPAYPayMaintain;
import nc.vo.fdcpmpay.pay.AggPayVO;
import nc.vo.pub.BusinessException;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

public class N_H194_APPROVE extends AbstractPfAction<AggPayVO>{

	
	public N_H194_APPROVE() {
		super();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	protected CompareAroundProcesser<AggPayVO> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggPayVO> processor = new CompareAroundProcesser<AggPayVO>(
				FDCPMPAYPayPluginPoint.APPROVE);
		IRule<AggPayVO> rule = null;
		rule = new nc.bs.pubapp.pub.rule.ApproveStatusCheckRule();

		processor.addBeforeRule(rule);

//		processor.addAfterRule(new SendVoucherRule<AggPayVO>());
		processor.addAfterRule(new SendVoucherRule());
		
		//�������ͨ����NCC������� -- dongqingzheng
		processor.addAfterRule(new ApprovePaymentSettleNCC());
		Logger.info("�������ͨ����NCC�������");
		//�������ͨ�����ֽ����Ľ��㵥
		processor.addAfterRule(new ApproveGeneratorCmpSettlementRule());
		
		return processor;
	}

	@Override
	protected AggPayVO[] processBP(Object userObj,
			AggPayVO[] clientFullVOs, AggPayVO[] originBills) {
		AggPayVO[] bills = null;
		IFDCPMPAYPayMaintain operator = NCLocator.getInstance().lookup(
				IFDCPMPAYPayMaintain.class);
		try {
			bills = operator.approve(clientFullVOs, originBills);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}

}
