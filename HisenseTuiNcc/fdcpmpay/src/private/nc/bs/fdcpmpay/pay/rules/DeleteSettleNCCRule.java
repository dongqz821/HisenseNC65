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
 * 删除凭证
 * @author lichsha
 *
 */
public class DeleteSettleNCCRule implements IRule<AggPayVO> {

	private String sendFlagField = "bisendvoucher";
	
	public DeleteSettleNCCRule() {
		super();
	}
	
	/**
	 * 构�?函数
	 * @param sendFlagField 传凭证标识字段名�? 默认为bisendvoucher
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
			String user = InvocationInfoProxy.getInstance().getUserId();// g01----00011A10000000003ALB ���õ�ǰ�����û�
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
                ExceptionUtils.wrappBusinessException("����sql�����쳣��"+e.getMessage());
			}
			map.put("pk_org",  org.get("pk_corp"));
			map.put("pk_pk", headvo.getPk_pay());
			ICallNccOpenAPIUtil CallNccOpenAPI = NCLocator.getInstance().lookup(ICallNccOpenAPIUtil.class);
			String param = JSONObject.toJSONString(map);//������ת����json��ʽ
			JSONObject json = JSONObject.parseObject(param);//json���ݸ�ʽת����json����
			
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
						ExceptionUtils.wrappBusinessException("����NCC�ӿ��쳣:" + jsonsucc.getString("msg"));
					}
				}else {
					ExceptionUtils.wrappBusinessException("������ƾ֤������ɾ������");
//					return "{\"success\":\"false\",\"code\":\"200\",\"msg\":\"������ƾ֤������ɾ������\"}";
				}
			} catch (Exception e) {
				ExceptionUtils.wrappBusinessException("����NCC�ӿ��쳣:" + e.getMessage());
			}
			
			list.add(aggvo);
			
		}
		
	}
	
	/**
	 * 现金管理-结算回写未支付，删除凭证
	 * @param list
	 */
	public void deleteFip4Cmp(List<AggPayVO> list){
		if(CommonUtilObj.isEmpty(list)){
			return;
		}
	}
}
