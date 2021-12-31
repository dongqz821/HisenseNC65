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
	@POST    //����Э��
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")  //�����ʽ
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")//��Ӧ��ʽ
	public String plan(JSONObject param){
		//NC����Դ
		String ds = ConfigUtils.getValueFromProperties("ncds");//design
		//JSONObject json = JSONObject.parseObject(param);//String ת json
		//��ѯ�ӿڹ̶�����
		InvocationInfoProxy.getInstance().setGroupId("00011A10000000000MDP");//���õ�ǰ��������
        InvocationInfoProxy.getInstance().setUserId("00011A10000000003ALB");// g01----00011A10000000003ALB ���õ�ǰ�����û�
        InvocationInfoProxy.getInstance().setUserDataSource(ds); //����Ĭ������Դ
        NCLocator.getInstance().lookup(ISecurityTokenCallback.class).token("NCSystem".getBytes(), "pfxx".getBytes());//����token����
        
        String result = "";
        INCCServiceHandler service = NCLocator.getInstance().lookup(INCCServiceHandler.class);
        if ("8.0".equals(param.getString("busistatus"))) {
        	service.examine(ds, param);//���������ķ���
            result = service.signature(ds, param);//ǩ�ַ���
		}else if("1.0".equals(param.getString("busistatus"))) {
			result = service.signature(ds, param);//ȡ��ǩ��
			service.examine(ds, param);//ȡ������
        }
        if (!"".equals(param.getString("settlestatus")) && param.getString("settlestatus") != null) {//�����д -- ����״̬��Ϊnull
        	result = service.settleAccounts(ds, param);
        }
        if ("2".equals(param.get("pay")) || "2.0".equals(param.get("pay")) ){
        	 result = service.notifyPay(ds, param);//֧���ķ���
		}
        
        return result;
	}
	
	@Override
	public String getModule() {
		return "baseapp";
	}

}
