package ncc.itf.baseapp.nccsign;


import com.alibaba.fastjson.JSONObject;

public interface INCCServiceHandler {
	
	public String examine(String ds,JSONObject param);//付款单审批
	
	public String signature(String ds,JSONObject param);//结算单 签字
	
	public String settleAccounts(String ds,JSONObject param);
	
	public String notifyPay(String ds,JSONObject param);
	
}
