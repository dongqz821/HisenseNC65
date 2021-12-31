package nc.bs.fdcpmpay.pay.rules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.itf.baseapp.utils.ICallNccOpenAPIUtil;
import nc.itf.fdcpmbd.voucher.IFDCToFIP;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.MapProcessor;
import nc.vo.fdcpmbd.pub.tool.CommonUtilObj;
import nc.vo.fdcpmbd.pub.tool.SafeCompute;
import nc.vo.fdcpmpay.pay.AggPayVO;
import nc.vo.fdcpmpay.pay.PayVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pub.pf.IPfRetCheckInfo;
import nc.vo.pubapp.pattern.data.ValueUtils;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import ncc.baseapp.utils.ConfigUtils;

/**
 * 鍒犻櫎鍑瘉
 * @author lichsha
 *
 */
public class DeleteSettleNCCRule implements IRule<AggPayVO> {

	private String sendFlagField = "bisendvoucher";
	
	public DeleteSettleNCCRule() {
		super();
	}
	
	/**
	 * 鏋勯?鍑芥暟
	 * @param sendFlagField 浼犲嚟璇佹爣璇嗗瓧娈靛悕绉? 榛樿涓篵isendvoucher
	 */
	public DeleteSettleNCCRule(String sendFlagField) {
		super();
		this.sendFlagField = sendFlagField;
	}
	
	@Override
	public void process(AggPayVO[] vos) {
		if(CommonUtilObj.isEmpty(vos)){
			return;
		}
		
		List<AggPayVO> list = new ArrayList<AggPayVO>();
		for(AggPayVO aggvo : vos){
			PayVO headvo = aggvo.getParentVO();
			if(!ValueUtils.getBoolean(headvo.getAttributeValue(sendFlagField))) {
				continue ;
			}
			Map<String, Object> map = new HashMap<>();
//			map.put("bill_no", headvo.getVbillcode());
			String user = InvocationInfoProxy.getInstance().getUserId();// g01----00011A10000000003ALB 设置当前操作用户
			map.put("pk_approver", user);	
			IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
			Map org = null;
			try {
				Object object = query.executeQuery("select g.pk_corp from fdcpm_pay_pay f inner join org_orgs o on f.pk_org  = o.pk_org inner join org_corp g on o.pk_corp = g.pk_corp where nvl(g.dr,0)=0 and f.pk_org ='" + headvo.getPk_org() + "'", new MapProcessor());
				if (object != null) {
					org = (Map) object;
				}
			} catch (BusinessException e) {
				Logger.error(e.getMessage());
                ExceptionUtils.wrappBusinessException("调用sql发生异常："+e.getMessage());
			}
			map.put("pk_org",  org.get("pk_corp"));
			map.put("pk_pk", headvo.getPk_pay());
			ICallNccOpenAPIUtil CallNccOpenAPI = NCLocator.getInstance().lookup(ICallNccOpenAPIUtil.class);
			String param = JSONObject.toJSONString(map);//将数组转化成json格式
			JSONObject json = JSONObject.parseObject(param);//json数据格式转换成json对象
			
			String nccdelip = ConfigUtils.getValueFromProperties("nccdelip");
			String nccdelyz = ConfigUtils.getValueFromProperties("nccdelyz");
			try {
				
				JSONObject jjson = new JSONObject();
				String[] str = new String[1];
				str[0] = json.getString("pk_pk");
				jjson.put("data", str);	
				String api = CallNccOpenAPI.callAPI(nccdelyz, jjson);
				JSONObject jsonapi = JSONObject.parseObject(api);
				if (jsonapi.getBooleanValue("success")) {
					String resout = CallNccOpenAPI.callAPI(nccdelip, json);
					JSONObject jsonsucc = JSONObject.parseObject(resout);
					if (!jsonsucc.getBooleanValue("success")) {
						ExceptionUtils.wrappBusinessException("调用NCC接口异常:" + jsonsucc.getString("msg"));
					}
				}else {
					ExceptionUtils.wrappBusinessException("已生成凭证，不可删除！！");
//					return "{\"success\":\"false\",\"code\":\"200\",\"msg\":\"已生成凭证，不可删除！！\"}";
				}
			} catch (Exception e) {
				ExceptionUtils.wrappBusinessException("调用NCC接口异常:" + e.getMessage());
			}
			
			list.add(aggvo);
			
		}
		
	}
	
	/**
	 * 鐜伴噾绠＄悊-缁撶畻鍥炲啓鏈敮浠橈紝鍒犻櫎鍑瘉
	 * @param list
	 */
	public void deleteFip4Cmp(List<AggPayVO> list){
		if(CommonUtilObj.isEmpty(list)){
			return;
		}
	}
}
