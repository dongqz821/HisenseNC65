package ncc.itf.baseapp.nccsign;


import com.alibaba.fastjson.JSONObject;

public interface INCCServiceHandler {
	
	public String examine(String ds,JSONObject param);//�������
	
	public String signature(String ds,JSONObject param);//���㵥 ǩ��
	
	public String settleAccounts(String ds,JSONObject param);
	
	public String notifyPay(String ds,JSONObject param);
	
}
