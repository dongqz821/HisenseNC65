package nc.itf.baseapp.utils;

/*
 * 向NCC推单接口
 */

public interface IPushSingleNCC {

	public String DateInteractionNCC(Object[] os);//资金推NCC付款结算
	
	public String ExamineApproveNCC(Object[] os);//成本推NCC付款结算
	
	public String ExpenseApproveNCC(Object[] os);//报销推NCC付款结算
	
}
