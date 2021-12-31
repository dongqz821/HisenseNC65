package ncc.itf.baseapp.nccsign;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.framework.common.NCLocator;
import nc.bs.framework.server.ISecurityTokenCallback;
import ncc.baseapp.utils.ConfigUtils;

import uap.ws.rest.resource.AbstractUAPRestResource;

@Path(value="/nccsign")
public class NCCService extends AbstractUAPRestResource {
	@Path(value = "/nccwrite")
	@POST    //请求协议
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")  //代码格式
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")//响应格式
	public String plan(JSONObject param){
		//NC数据源
		String ds = ConfigUtils.getValueFromProperties("ncds");//design
		//JSONObject json = JSONObject.parseObject(param);//String 转 json
		//查询接口固定部分
		InvocationInfoProxy.getInstance().setGroupId("00011A10000000000MDP");//设置当前操作集团
        InvocationInfoProxy.getInstance().setUserId("00011A10000000003ALB");// g01----00011A10000000003ALB 设置当前操作用户
        InvocationInfoProxy.getInstance().setUserDataSource(ds); //设置默认数据源
        NCLocator.getInstance().lookup(ISecurityTokenCallback.class).token("NCSystem".getBytes(), "pfxx".getBytes());//跳过token调研
        
        String result = "";
        INCCServiceHandler service = NCLocator.getInstance().lookup(INCCServiceHandler.class);
        if ("8.0".equals(param.getString("busistatus"))) {
        	service.examine(ds, param);//调用审批的方法
            result = service.signature(ds, param);//签字方法
		}else if("1.0".equals(param.getString("busistatus"))) {
			result = service.signature(ds, param);//取消签字
			service.examine(ds, param);//取消审批
        }
        if (!"".equals(param.getString("settlestatus")) && param.getString("settlestatus") != null) {//结算回写 -- 结算状态不为null
        	result = service.settleAccounts(ds, param);
        }
        if ("2".equals(param.get("pay")) || "2.0".equals(param.get("pay")) ){
        	 result = service.notifyPay(ds, param);//支付的方法
		}
        
        return result;
	}
	
	@Override
	public String getModule() {
		return "baseapp";
	}

}
