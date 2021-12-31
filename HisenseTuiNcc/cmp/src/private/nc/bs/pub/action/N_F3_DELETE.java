package nc.bs.pub.action;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.framework.common.NCLocator;
import nc.bs.pub.compiler.AbstractCompiler2;
import nc.itf.baseapp.utils.ICallNccOpenAPIUtil;
import nc.vo.arap.pay.PayBillItemVO;
import nc.vo.fipub.exception.ExceptionHandler;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.compiler.PfParameterVO;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import ncc.baseapp.utils.ConfigUtils;

public class N_F3_DELETE
  extends AbstractCompiler2
{
  private Hashtable<String, Object> m_keyHas = null;
  
  public Object runComClass(PfParameterVO paraVo)
    throws BusinessException
  {
    try
    {
      if (paraVo.m_preValueVos == null) {
        return null;
      }
      Object obj = null;
      this.m_tmpVo = paraVo;
      
      setParameter("context", paraVo.m_preValueVos);
      
      AggregatedValueObject[] hvo = paraVo.m_preValueVos;
      for (int i = 0; i < hvo.length; i++) {
    	  AggregatedValueObject aggvo = hvo[i];
    	  
    	  Map<String, Object> map = new HashMap<String, Object>();
    	  
    	  CircularlyAccessibleValueObject[] children = aggvo.getChildrenVO();
    	  for (int j = 0; j < children.length; j++) {
    		  PayBillItemVO bvo = (PayBillItemVO) children[i];
    		  map.put("pk_pk", bvo.getTop_billid());
    		  map.put("pk_org", bvo.getPk_org());
    		  String user = InvocationInfoProxy.getInstance().getUserId();
    		  map.put("pk_approver", user);	
    		  map.put("pk_paybill", bvo.getPk_paybill());
		}
    	  
    	ICallNccOpenAPIUtil CallNccOpenAPI = NCLocator.getInstance().lookup(ICallNccOpenAPIUtil.class);
		String param = JSONObject.toJSONString(map);//将数组转化成json格式
		JSONObject json = JSONObject.parseObject(param);//json数据格式转换成json对象
		String nccdelyz = ConfigUtils.getValueFromProperties("nccdelyz");	
		String nccdelip = ConfigUtils.getValueFromProperties("nccdelip");
		
		JSONObject jjson = new JSONObject();
		String[] str = new String[1];
		str[0] = json.getString("pk_paybill");
		jjson.put("data", str);	
		String api = CallNccOpenAPI.callAPI(nccdelyz, jjson);
		JSONObject jsonapi = JSONObject.parseObject(api);
		if (jsonapi.getBooleanValue("success")) {
			try {
				String resout = CallNccOpenAPI.callAPI(nccdelip, json);
				JSONObject jsonsucc = JSONObject.parseObject(resout);
				if (!jsonsucc.getBooleanValue("success")) {
					ExceptionUtils.wrappBusinessException("调用NCC接口异常:" + jsonsucc.getString("msg"));
				}
			} catch (Exception e) {
				ExceptionUtils.wrappBusinessException("调用NCC接口异常:" + e.getMessage());
			}
		}else{
			return "{\"success\":\"false\",\"code\":\"200\",\"msg\":\"已生成凭证，不可删除！！\"}";
		}
	}
      
      return runClass("nc.bs.arap.actions.PaybillDeleteBatchBSAction", "deleteVOs", "&context:nc.vo.pub.AggregatedValueObject[]", paraVo, this.m_keyHas);
    }
    catch (Exception ex)
    {
      throw ExceptionHandler.handleException(getClass(), ex);
    }
  }
  
  public String getCodeRemark()
  {
    return " arap action script not allowed to modify ,all rights reserved!";
  }
  
  protected void setParameter(String key, Object val)
  {
    if (this.m_keyHas == null) {
      this.m_keyHas = new Hashtable();
    }
    if (val != null) {
      this.m_keyHas.put(key, val);
    }
  }
}
