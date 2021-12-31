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
 * �ɱ���NCC������� dongqz
 */

public class ExamineApproveNCC implements IPushSingleNCC{

	public String ExamineApproveNCC(Object[] os) {

		for (int i = 0; i < os.length; i++) {
			AggPayVO vo = (AggPayVO) os[i];
			PayVO hvo = (PayVO) vo.getParentVO();
			// PayDealVO[] bvo1 = (PayDealVO[])
			// vo.getChildren(PayDealVO.class);//����������ϸ����
			PayAccVO[] bvo2 = (PayAccVO[]) vo.getChildren(PayAccVO.class);// �˺���Ϣ����
			// PayCostDetailVO[] bvo3 = (PayCostDetailVO[])
			// vo.getChildren(PayCostDetailVO.class);//֧���ɱ���ϸ����
			// PayInfVO[] bvo4 = (PayInfVO[])
			// vo.getChildren(PayInfVO.class);//��Ʊ�ǼǱ���VO(������ͬ��)

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
			headmap.put("pk_tradetypeid", "10011A100000003A10PW");// ���ݽ�������
			headmap.put("source_flag", "2");// ��Դϵͳ
			headmap.put("def20", "H194");// ��ϵͳ��������
			headmap.put("bill_date", hvo.getDbilldate().toLocalString()
					+ " 00:00:00");// ��������
			headmap.put("primal_money", hvo.getNorigthismny().doubleValue());// ����ԭ�ҽ��
																				// norigthismny
			headmap.put("pk_currtype", hvo.getCorigcurrencyid());// ����--�����
																	// 1002Z0100000000001K1
			// headmap.put("pk_balatype", "10011A100000000I4MPN");//���㷽ʽ-- �Ա���Ϊ׼
			headmap.put("memo", hvo.getVbillcode());// ��ע�����ݱ��
			headmap.put("objecttype", "1");
			headmap.put("pk_supplier", hvo.getPk_supplier());// ��Ӧ��
			headmap.put("pk_upbill", hvo.getPk_pay());// ���ε�������
			// headmap.put("pk_account", hvo.getPk_bankacc_r());//�տ������˻�-- �Ա���Ϊ׼
			// headmap.put("pk_upperbill",hvo.getPk_pay());
			headmap.put("bill_status", "-1");// ����״̬
			map.put("head", headmap);// ��ͷ��ֵ
			// map.put("billtype", "paybill");
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

			for (int j = 0; j < bvo2.length; j++) {
				PayAccVO bvo = bvo2[j];
				Map<String, Object> map1 = new HashMap<>();
				map1.put("pk_org", org.get("pk_corp"));// org.get("pk_org")
				map1.put("pk_group", hvo.getPk_group());
				map1.put("bill_type", "F5");// ��������
				map1.put("trade_type", "F5-Cxx-NC65");// �����������
				map1.put("pk_tradetypeid", "10011A100000003A10PW");// ���ݽ�������
				map1.put("pk_currtype", "1002Z0100000000001K1");
				map1.put("bill_date", hvo.getDbilldate().toLocalString()
						+ " 00:00:00");
				map1.put("pay_primal", bvo.getNorigrealpaymny().doubleValue());// ����ԭ�ҽ��
																				// --
																				// ʵ��֧�����
				map1.put("pk_oppaccount", bvo.getPk_payaccount());// �����˺�
				map1.put("creationtime", hvo.getCreationtime().toLocalString());
				map1.put("direction", "-1");
				map1.put("pk_account", bvo.getVbdef10());// �տ������˻�

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

				map1.put("accountopenbank", bank.get("name"));// �տ���������
				map1.put("accountname", bank.get("accname"));// �տ��˻�����
				map1.put("pk_balatype", bvo.getPk_paytype());// ���㷽ʽ
				map1.put("objecttype", "1");
				map1.put("pk_supplier", bvo.getPk_realreceive());// ��Ӧ�� -- �տλ
				map1.put("pay_last", bvo.getNorigrealpaymny().doubleValue());// ʵ��ԭ�ҽ����㣩applymny��ȡ�������븶����
				map1.put("paylocal_last", bvo.getNorigrealpaymny()
						.doubleValue());// ʵ�����ҽ����㣩applymny��ȡ�������븶����
				list.add(map1);
			}

			map.put("body", list);// ���帳ֵ
			ICallNccOpenAPIUtil CallNccOpenAPI = NCLocator.getInstance()
					.lookup(ICallNccOpenAPIUtil.class);
			String param = JSONObject.toJSONString(map);// ������ת����json��ʽ
			JSONObject json = JSONObject.parseObject(param);// json���ݸ�ʽת����json����
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
