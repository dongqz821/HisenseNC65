package nc.bs.pub.action;

import nc.bs.fdcpmpay.pay.rules.DeleteSettleNCCRule;
import nc.bs.fdcpmpay.pay.rules.DeleteVoucherRule;
import nc.bs.fdcpmpay.pay.plugin.bpplugin.FDCPMPAYPayPluginPoint;
import nc.bs.fdcpmpay.pay.rules.UnApproveCheckHasCmpSettlementBeforeRule;
import nc.bs.framework.common.NCLocator;
import nc.bs.pubapp.pf.action.AbstractPfAction;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.CompareAroundProcesser;
import nc.itf.fdcpmpay.IFDCPMPAYPayMaintain;
import nc.vo.fdcpmpay.pay.AggPayVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.VOStatus;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;

public class N_H194_UNAPPROVE extends AbstractPfAction<AggPayVO>{

	@Override
	@SuppressWarnings("unchecked")
	protected CompareAroundProcesser<AggPayVO> getCompareAroundProcesserWithRules(
			Object userObj) {
		CompareAroundProcesser<AggPayVO> processor = new CompareAroundProcesser<AggPayVO>(
				FDCPMPAYPayPluginPoint.UNAPPROVE);
		
		// 在此处添加前后规则
		IRule<AggPayVO> rule = new nc.bs.pubapp.pub.rule.UnapproveStatusCheckRule();
		processor.addBeforeRule(rule);
		processor.addBeforeRule(new nc.bs.fdcpmpay.pay.rules.UnApproveCheckRule());
		processor.addBeforeRule(new UnApproveCheckHasCmpSettlementBeforeRule());
		processor.addBeforeRule(new DeleteSettleNCCRule());
		processor.addBeforeRule(new DeleteVoucherRule());
		return processor;
	}

	@Override
	protected AggPayVO[] processBP(Object userObj,
			AggPayVO[] clientFullVOs,
			AggPayVO[] originBills) {
		for (int i = 0; clientFullVOs != null && i < clientFullVOs.length; i++) {
			clientFullVOs[i].getParentVO().setStatus(VOStatus.UPDATED);
		}
		AggPayVO[] bills = null;
		try {
			IFDCPMPAYPayMaintain operator = NCLocator.getInstance().lookup(
					IFDCPMPAYPayMaintain.class);
			bills = operator.unapprove(clientFullVOs, originBills);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException(e.getMessage());
		}
		return bills;
	}

}
