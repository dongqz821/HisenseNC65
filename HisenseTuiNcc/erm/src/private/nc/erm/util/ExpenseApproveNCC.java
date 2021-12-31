package nc.erm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import nc.bs.framework.common.NCLocator;
import nc.itf.baseapp.utils.ICallNccOpenAPIUtil;
import nc.itf.baseapp.utils.IPushSingleNCC;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.MapProcessor;
import nc.vo.ep.bx.BXBusItemVO;
import nc.vo.ep.bx.BXVO;
import nc.vo.ep.bx.JKBXHeaderVO;
import nc.vo.pub.BusinessException;

/*
 * 报销推NCC付款结算 dongqz
 */

public class ExpenseApproveNCC implements IPushSingleNCC {

	public String ExpenseApproveNCC(Object[] os) {

		for (int i = 0; i < os.length; i++) {
			BXVO vo = (BXVO) os[i];
			JKBXHeaderVO  hvo = (JKBXHeaderVO) vo.getParentVO();
			BXBusItemVO[] bbvo = (BXBusItemVO[]) vo.getChildrenVO();//表体

			Map<String, Object> map = new HashMap<>();

			Map<String, Object> headmap = new HashMap<>();
			headmap.put("pk_org", hvo.getPk_org());
			headmap.put("pk_group", hvo.getPk_group());
			headmap.put("bill_type", "F5");
			headmap.put("trade_type", "F5-Cxx-NC65");
			headmap.put("pk_tradetypeid", "10011A100000003A10PW");// 单据交易类型
			headmap.put("source_flag", "2");// 来源系统
			headmap.put("def20", "264X");//外系统单据类型
			headmap.put("bill_date", hvo.getDjrq().toLocalString() + " 00:00:00");// 单据日期
			headmap.put("primal_money", hvo.getTotal().doubleValue());// 付款原币金额
			headmap.put("pk_currtype", hvo.getBzbm());// 币种--人民币	
			headmap.put("pk_balatype", hvo.getJsfs());//结算方式-- 以表体为准
			headmap.put("memo", hvo.getDjbh());// 备注：单据编号
			headmap.put("up_tradetype", hvo.getDjlxbm());//  up_tradetype(上有单据交易类型)
			headmap.put("pk_supplier", hvo.getHbbm());// 供应商
			headmap.put("pk_upbill", hvo.getPk_jkbx());// 上游单据主键
			// headmap.put("pk_account", hvo.getPk_bankacc_r());//收款银行账户-- 以表体为准
			headmap.put("bill_status", "-1");// 单据状态
			headmap.put("up_tradetype", hvo.getPk_tradetypeid());//上游单据交易类型 
			headmap.put("payperson ", "");
			map.put("head", headmap);// 表头赋值
			// map.put("billtype", "paybill");
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

			for (int j = 0; j < bbvo.length; j++) {
				BXBusItemVO bvo = bbvo[j];
				Map<String, Object> map1 = new HashMap<>();
				map1.put("pk_org", hvo.getPk_org());// org.get("pk_org")
				map1.put("pk_group", hvo.getPk_group());
				map1.put("bill_type", "F5");// 单据类型
				map1.put("trade_type", "F5-Cxx-NC65");// 付款结算类型
				map1.put("pk_tradetypeid", "10011A100000003A10PW");// 单据交易类型
				map1.put("pk_currtype", "1002Z0100000000001K1");
				map1.put("bill_date", hvo.getDjrq().toLocalString() + " 00:00:00");
				map1.put("pay_primal", bvo.getYbje().doubleValue());// 付款原币金额	
				map1.put("pk_oppaccount", hvo.getFkyhzh());// 付款账号
				map1.put("creationtime", hvo.getCreationtime().toLocalString());
				map1.put("direction", "-1");
				
				if (0 == bvo.getPaytarget()) {
					map1.put("objecttype", "3");//交易对象类型
					map1.put("pk_account", bvo.getSkyhzh());// 收款银行账户 个人
					map1.put("pk_busiman", hvo.getJkbxr());//业务员
				}else if (1 == bvo.getPaytarget()) {
					map1.put("objecttype", "1");
					map1.put("pk_account", bvo.getCustaccount());//客商
				}else if (2 == bvo.getPaytarget()) {
					map1.put("objecttype", "0");
					map1.put("pk_account", bvo.getCustaccount());
				}
				
				IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
				Map bank = null;
				try {
					Object object = query.executeQuery( "select b.name from bd_bankaccsub b inner join er_busitem e on b.pk_bankaccsub = e.skyhzh where e.skyhzh = '"+ bvo.getSkyhzh() + "'", new MapProcessor());
					if (object != null) {
						bank = (Map) object;
					}
				} catch (BusinessException e) {
					e.printStackTrace();
				}

				map1.put("accountopenbank", bank.get("name"));// 收款银行名称
				map1.put("accountname", bvo.getReceiver());// 收款账户户名
				map1.put("pk_balatype", hvo.getJsfs());// 结算方式
				map1.put("up_tradetype", hvo.getDjlxbm());
				map1.put("pk_supplier", bvo.getHbbm());// 供应商 -- 收款单位	
				map1.put("pay_last", bvo.getYbje().doubleValue());// 实付原币金额（结算）applymny获取的是申请付款金额
				map1.put("paylocal_last", bvo.getBbje()
						.doubleValue());// 实付本币金额（结算）applymny获取的是申请付款金额
				list.add(map1);
			}

			map.put("body", list);// 表体赋值
			ICallNccOpenAPIUtil CallNccOpenAPI = NCLocator.getInstance()
					.lookup(ICallNccOpenAPIUtil.class);
			String param = JSONObject.toJSONString(map);// 将数组转化成json格式
			JSONObject json = JSONObject.parseObject(param);// json数据格式转换成json对象
//			CallNccOpenAPI.callAPI(json);
		}
		return null;
	}

	@Override
	public String DateInteractionNCC(Object[] os) {
		return null;
	}

	@Override
	public String ExamineApproveNCC(Object[] os) {
		return null;
	}

}
