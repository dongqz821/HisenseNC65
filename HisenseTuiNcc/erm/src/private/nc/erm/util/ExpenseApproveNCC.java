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
 * ������NCC������� dongqz
 */

public class ExpenseApproveNCC implements IPushSingleNCC {

	public String ExpenseApproveNCC(Object[] os) {

		for (int i = 0; i < os.length; i++) {
			BXVO vo = (BXVO) os[i];
			JKBXHeaderVO  hvo = (JKBXHeaderVO) vo.getParentVO();
			BXBusItemVO[] bbvo = (BXBusItemVO[]) vo.getChildrenVO();//����

			Map<String, Object> map = new HashMap<>();

			Map<String, Object> headmap = new HashMap<>();
			headmap.put("pk_org", hvo.getPk_org());
			headmap.put("pk_group", hvo.getPk_group());
			headmap.put("bill_type", "F5");
			headmap.put("trade_type", "F5-Cxx-NC65");
			headmap.put("pk_tradetypeid", "10011A100000003A10PW");// ���ݽ�������
			headmap.put("source_flag", "2");// ��Դϵͳ
			headmap.put("def20", "264X");//��ϵͳ��������
			headmap.put("bill_date", hvo.getDjrq().toLocalString() + " 00:00:00");// ��������
			headmap.put("primal_money", hvo.getTotal().doubleValue());// ����ԭ�ҽ��
			headmap.put("pk_currtype", hvo.getBzbm());// ����--�����	
			headmap.put("pk_balatype", hvo.getJsfs());//���㷽ʽ-- �Ա���Ϊ׼
			headmap.put("memo", hvo.getDjbh());// ��ע�����ݱ��
			headmap.put("up_tradetype", hvo.getDjlxbm());//  up_tradetype(���е��ݽ�������)
			headmap.put("pk_supplier", hvo.getHbbm());// ��Ӧ��
			headmap.put("pk_upbill", hvo.getPk_jkbx());// ���ε�������
			// headmap.put("pk_account", hvo.getPk_bankacc_r());//�տ������˻�-- �Ա���Ϊ׼
			headmap.put("bill_status", "-1");// ����״̬
			headmap.put("up_tradetype", hvo.getPk_tradetypeid());//���ε��ݽ������� 
			headmap.put("payperson ", "");
			map.put("head", headmap);// ��ͷ��ֵ
			// map.put("billtype", "paybill");
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

			for (int j = 0; j < bbvo.length; j++) {
				BXBusItemVO bvo = bbvo[j];
				Map<String, Object> map1 = new HashMap<>();
				map1.put("pk_org", hvo.getPk_org());// org.get("pk_org")
				map1.put("pk_group", hvo.getPk_group());
				map1.put("bill_type", "F5");// ��������
				map1.put("trade_type", "F5-Cxx-NC65");// �����������
				map1.put("pk_tradetypeid", "10011A100000003A10PW");// ���ݽ�������
				map1.put("pk_currtype", "1002Z0100000000001K1");
				map1.put("bill_date", hvo.getDjrq().toLocalString() + " 00:00:00");
				map1.put("pay_primal", bvo.getYbje().doubleValue());// ����ԭ�ҽ��	
				map1.put("pk_oppaccount", hvo.getFkyhzh());// �����˺�
				map1.put("creationtime", hvo.getCreationtime().toLocalString());
				map1.put("direction", "-1");
				
				if (0 == bvo.getPaytarget()) {
					map1.put("objecttype", "3");//���׶�������
					map1.put("pk_account", bvo.getSkyhzh());// �տ������˻� ����
					map1.put("pk_busiman", hvo.getJkbxr());//ҵ��Ա
				}else if (1 == bvo.getPaytarget()) {
					map1.put("objecttype", "1");
					map1.put("pk_account", bvo.getCustaccount());//����
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

				map1.put("accountopenbank", bank.get("name"));// �տ���������
				map1.put("accountname", bvo.getReceiver());// �տ��˻�����
				map1.put("pk_balatype", hvo.getJsfs());// ���㷽ʽ
				map1.put("up_tradetype", hvo.getDjlxbm());
				map1.put("pk_supplier", bvo.getHbbm());// ��Ӧ�� -- �տλ	
				map1.put("pay_last", bvo.getYbje().doubleValue());// ʵ��ԭ�ҽ����㣩applymny��ȡ�������븶����
				map1.put("paylocal_last", bvo.getBbje()
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
	public String ExamineApproveNCC(Object[] os) {
		return null;
	}

}
