package nc.fdcpmpay.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import nc.bs.framework.common.NCLocator;
import nc.itf.baseapp.utils.ICallNccOpenAPIUtil;
import nc.itf.baseapp.utils.IPushSingleNCC;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.BeanProcessor;
import nc.jdbc.framework.processor.MapProcessor;
import nc.vo.cmp.apply.ApplyBVO;
import nc.vo.fdcpmpay.apply.PayCostDetailVO;
import nc.vo.fdcpmpay.fdcpm_pay_pay.PayInfVO;
import nc.vo.fdcpmpay.pay.AggPayVO;
import nc.vo.fdcpmpay.pay.PayAccVO;
import nc.vo.fdcpmpay.pay.PayDealVO;
import nc.vo.fdcpmpay.pay.PayVO;
import nc.vo.pub.BusinessException;
import nc.vo.sm.UserVO;

/*
 * 成本推NCC付款结算 dongqz
 */

public class ExamineApproveNCC implements IPushSingleNCC{

	public String ExamineApproveNCC(Object[] os) {

		for (int i = 0; i < os.length; i++) {
			AggPayVO vo = (AggPayVO) os[i];
			PayVO hvo = (PayVO) vo.getParentVO();
			// PayDealVO[] bvo1 = (PayDealVO[])
			// vo.getChildren(PayDealVO.class);//付款内容明细表体
			PayAccVO[] bvo2 = (PayAccVO[]) vo.getChildren(PayAccVO.class);// 账号信息表体
			// PayCostDetailVO[] bvo3 = (PayCostDetailVO[])
			// vo.getChildren(PayCostDetailVO.class);//支付成本明细表体
			// PayInfVO[] bvo4 = (PayInfVO[])
			// vo.getChildren(PayInfVO.class);//发票登记表体VO(两个不同包)

			Map<String, Object> map = new HashMap<>();

			Map<String, Object> headmap = new HashMap<>();

			IUAPQueryBS query = NCLocator.getInstance().lookup(
					IUAPQueryBS.class);
			Map org = null;
			try {
				Object object = query
						.executeQuery(
								"select g.pk_corp from fdcpm_pay_pay f inner join org_orgs o on f.pk_org  = o.pk_org inner join org_corp g on o.pk_corp = g.pk_corp where f.pk_org ='"
										+ hvo.getPk_org() + "'",
								new MapProcessor());
				if (object != null) {
					org = (Map) object;
				}
			} catch (BusinessException e) {
				e.printStackTrace();
			}
			headmap.put("pk_org", org.get("pk_corp"));
			headmap.put("pk_group", hvo.getPk_group());
			headmap.put("bill_type", "F5");
			headmap.put("trade_type", "F5-Cxx-NC65");
			headmap.put("pk_tradetypeid", "10011A100000003A10PW");// 单据交易类型
			headmap.put("source_flag", "2");// 来源系统
			headmap.put("def20", "H194");// 外系统单据类型
			headmap.put("bill_date", hvo.getDbilldate().toLocalString()
					+ " 00:00:00");// 单据日期
			headmap.put("primal_money", hvo.getNorigthismny().doubleValue());// 付款原币金额
																				// norigthismny
			headmap.put("pk_currtype", hvo.getCorigcurrencyid());// 币种--人民币
																	// 1002Z0100000000001K1
			// headmap.put("pk_balatype", "10011A100000000I4MPN");//结算方式-- 以表体为准
			headmap.put("memo", hvo.getVbillcode());// 备注：单据编号
			headmap.put("objecttype", "1");
			headmap.put("pk_supplier", hvo.getPk_supplier());// 供应商
			headmap.put("pk_upbill", hvo.getPk_pay());// 上游单据主键
			// headmap.put("pk_account", hvo.getPk_bankacc_r());//收款银行账户-- 以表体为准
			// headmap.put("pk_upperbill",hvo.getPk_pay());
			headmap.put("bill_status", "-1");// 单据状态
			map.put("head", headmap);// 表头赋值
			// map.put("billtype", "paybill");
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

			for (int j = 0; j < bvo2.length; j++) {
				PayAccVO bvo = bvo2[j];
				Map<String, Object> map1 = new HashMap<>();
				map1.put("pk_org", org.get("pk_corp"));// org.get("pk_org")
				map1.put("pk_group", hvo.getPk_group());
				map1.put("bill_type", "F5");// 单据类型
				map1.put("trade_type", "F5-Cxx-NC65");// 付款结算类型
				map1.put("pk_tradetypeid", "10011A100000003A10PW");// 单据交易类型
				map1.put("pk_currtype", "1002Z0100000000001K1");
				map1.put("bill_date", hvo.getDbilldate().toLocalString()
						+ " 00:00:00");
				map1.put("pay_primal", bvo.getNorigrealpaymny().doubleValue());// 付款原币金额
																				// --
																				// 实际支付金额
				map1.put("pk_oppaccount", bvo.getPk_payaccount());// 付款账号
				map1.put("creationtime", hvo.getCreationtime().toLocalString());
				map1.put("direction", "-1");
				map1.put("pk_account", bvo.getVbdef10());// 收款银行账户

				Map bank = null;
				try {
					Object object = query
							.executeQuery(
									"select b.accname,bdc.name from fdcpm_pay_pay_acc c inner join bd_bankaccsub b on c.vbdef10 = b.pk_bankaccsub inner join bd_bankaccbas bd on b.pk_bankaccbas  = bd.pk_bankaccbas inner join bd_bankdoc bdc on bd.pk_bankdoc = bdc.pk_bankdoc where c.vbdef10 = '"
											+ bvo.getVbdef10() + "'",
									new MapProcessor());
					if (object != null) {
						bank = (Map) object;
					}
				} catch (BusinessException e) {
					e.printStackTrace();
				}

				map1.put("accountopenbank", bank.get("name"));// 收款银行名称
				map1.put("accountname", bank.get("accname"));// 收款账户户名
				map1.put("pk_balatype", bvo.getPk_paytype());// 结算方式
				map1.put("objecttype", "1");
				map1.put("pk_supplier", bvo.getPk_realreceive());// 供应商 -- 收款单位
				map1.put("pay_last", bvo.getNorigrealpaymny().doubleValue());// 实付原币金额（结算）applymny获取的是申请付款金额
				map1.put("paylocal_last", bvo.getNorigrealpaymny()
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
	public String ExpenseApproveNCC(Object[] os) {
		return null;
	}

}
