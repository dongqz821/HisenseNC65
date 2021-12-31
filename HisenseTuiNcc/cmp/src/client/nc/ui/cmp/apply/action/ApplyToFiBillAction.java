package nc.ui.cmp.apply.action;

import java.awt.event.ActionEvent;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.cmp.util.DateInteractionNCC;
import nc.impl.baseapp.utils.CallNccOpenAPIUtiIlmpl;
import nc.itf.baseapp.utils.ICallNccOpenAPIUtil;
import nc.itf.baseapp.utils.IPushSingleNCC;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIDialog;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.vo.cmp.apply.AggApplyVO;
import nc.vo.cmp.apply.ApplyBVO;
import nc.vo.cmp.apply.ApplyBillStatus;
import nc.vo.cmp.apply.ApplyVO;
import nc.vo.pub.VOStatus;
import ncc.itf.baseapp.nccsign.INCCServiceHandler;

public class ApplyToFiBillAction extends ApplyPFCommonAction {
	private static final long serialVersionUID = 1L;
	private NCAction cardRefreshAction;
	private NCAction refreshAction;
	private final String TITLE = nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("3607apply_add_0","03607apply_add-0012")/*@res "ȷ������"*/;
	private final String QUESTION =nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("3607apply_add_0","03607apply_add-0013")/*@res "��ȷ��Ҫ���ɸ������һ�����ɣ��򲻿���ȡ�����ɣ�"*/;
	public NCAction getRefreshAction() {
		return refreshAction;
	}

	public void setRefreshAction(NCAction refreshAction) {
		this.refreshAction = refreshAction;
	}

	public NCAction getCardRefreshAction() {
		return cardRefreshAction;
	}

	public void setCardRefreshAction(NCAction cardRefreshAction) {
		this.cardRefreshAction = cardRefreshAction;
	}

	public ApplyToFiBillAction(String pftype) {
		super(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("3607apply_add_0","03607apply_add-0014")/*@res "����"*/, pftype);
	}
	ActionEvent e;
	@Override
	public void doAction(ActionEvent e) throws Exception {
		this.e = e;
		  if (UIDialog.ID_YES == MessageDialog.showYesNoDlg(this.getModel().getContext().getEntranceUI(), TITLE, QUESTION)){
			  try {
				//��NCC�Ƹ�����㵥 -- dongqingzheng
					IPushSingleNCC callncc = NCLocator.getInstance().lookup(IPushSingleNCC.class);
					Object[] os = this.getUIData();
					callncc.DateInteractionNCC(os);
				} catch (Exception e2) {
					Logger.error(e2.getMessage());
					throw new Exception(e2.getMessage());
				}
			  super.doAction(e);
		  }

	}
	@Override
	protected void successOperAction(Object retObj) throws Exception {

		if(getEditor().isShowing()){
			getCardRefreshAction().doAction(e);
		}else{
			getRefreshAction().doAction(e);
		}
	}
	protected void showSuccessInfo() {
		ShowStatusBarMsgUtil.showStatusBarMsg(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("3607apply_add_0","03607apply_add-0015")/*@res "���ɳɹ�"*/, getModel().getContext());
	}

	@Override
	protected boolean isActionEnable() {
		boolean ret = super.isActionEnable();
		// ���������ͨ������ҵ�����̵����ε��������ɸ���ģ��ŷ���true
		// ����ֻ�ж����ͨ����ҵ�����̵��жϷŵ���̨  !applyVO.getPk_acceptorg().equals(applyVO.getPk_org()
		if (ret) {
			Object[] os = this.getUIData();
			for (Object o : os) {
				AggApplyVO vo = (AggApplyVO) o;
				ApplyVO applyVO = (ApplyVO) vo.getParentVO();
				ApplyBVO[] children = (ApplyBVO[]) vo.getChildren(ApplyBVO.class);
				boolean isEditable = false;
				for (ApplyBVO applyBVO : children) {
					if (applyBVO.getStatus()!=VOStatus.DELETED&&(applyBVO.getIsfrozen() == null
							|| !applyBVO.getIsfrozen().booleanValue())&&

							(applyBVO.getVbillstatus() != null&& (applyBVO.getBusistatus() == ApplyBillStatus.WAIT_TOBILLPLAY_VALUE ||applyBVO
							.getBusistatus() == ApplyBillStatus.WAIT_TOBILLPLAY_PART_VALUE
							))){

						isEditable = true;
						break;
					}
				}
				if (!isEditable||(applyVO.getVbillstatus() == null
						|| (applyVO.getBusistatus() != ApplyBillStatus.WAIT_TOBILLPLAY_VALUE && applyVO.getBusistatus() != ApplyBillStatus.WAIT_TOBILLPLAY_PART_VALUE)
						)) {
					ret = false;
					break;
				}
			}
		}
		return ret;
	}




}