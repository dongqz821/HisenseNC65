package nc.itf.baseapp.utils;

import com.alibaba.fastjson.JSONObject;

public interface ICallNccOpenAPIUtil {
	
	public String callAPI(String nccip, JSONObject json);
	
//	public String httpspost(String nccip, JSONObject json);
}