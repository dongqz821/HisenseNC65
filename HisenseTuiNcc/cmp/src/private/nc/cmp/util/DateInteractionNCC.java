package nc.cmp.util;

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
import nc.vo.cmp.apply.AggApplyVO;
import nc.vo.cmp.apply.ApplyBVO;
import nc.vo.cmp.apply.ApplyVO;
import nc.vo.pub.BusinessException;
import nc.vo.sm.UserVO;

/*
 * �ʽ���NCC������� dongqz
 */

public class DateInteractionNCC implements IPushSingleNCC{
	
	public String DateInteractionNCC(Object[] os){
		
		for (int i = 0; i < os.length; i++) {
			AggApplyVO vo = (AggApplyVO) os[i];
			ApplyVO applyVO = (ApplyVO) vo.getParentVO();
			ApplyBVO[] children = (ApplyBVO[]) vo.getChildren(ApplyBVO.class);
			
			Map<String,Object> map = new HashMap<>();
			
			Map<String,Object> headmap = new HashMap<>();
			headmap.put("pk_org", applyVO.getPk_org());
			headmap.put("pk_group", applyVO.getPk_group());
			headmap.put("bill_type", "F5");
			headmap.put("trade_type", "F5-Cxx-NC65");
			headmap.put("pk_tradetypeid","10011A100000003A10PW");//���ݽ�������
			headmap.put("source_flag", "2");//��Դϵͳ
			headmap.put("def20", "F3");//��ϵͳ��������
			headmap.put("bill_date", applyVO.getBillmakedate().toLocalString()+" 00:00:00");//��������
			headmap.put("primal_money", applyVO.getApplysum().doubleValue());//	����ԭ�ҽ��
			headmap.put("pk_currtype", "1002Z0100000000001K1");//
//			headmap.put("pk_balatype", "10011A100000000I4MPN");//���㷽ʽ-- �Ա���Ϊ׼
			headmap.put("memo", applyVO.getVbillno());//��ע������������
			headmap.put("objecttype", "1");
			headmap.put("pk_supplier", applyVO.getPk_supplier());//��Ӧ��
			headmap.put("pk_upbill", applyVO.getPk_apply());//���ε�������   
			headmap.put("pk_account", applyVO.getPk_bankacc_r());
			headmap.put("pk_upperbill",applyVO.getPk_apply()); //������������
			headmap.put("bill_status","-1");//����״̬
			map.put("head", headmap);//��ͷ��ֵ
//			map.put("billtype", "paybill");
			//pk_tradetype 
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
			Map bank = null;
			try {
				Object object = query.executeQuery("select b.accname,bdc.name from cmp_apply c inner join bd_bankaccsub b on c.pk_bankacc_r = b.pk_bankaccsub  inner join bd_bankaccbas bd on b.pk_bankaccbas  = bd.pk_bankaccbas inner join bd_bankdoc bdc on bd.pk_bankdoc = bdc.pk_bankdoc where c.pk_bankacc_r = '"+applyVO.getPk_bankacc_r()+"'", new MapProcessor());
				if(object!=null){
					bank = (Map) object;
				}
			} catch (BusinessException e) {
				e.printStackTrace();
			}			
			for (int j = 0; j < children.length; j++) {
				ApplyBVO bvo = children[j];
				Map<String,Object> map1 = new HashMap<>();
				map1.put("pk_org", bvo.getPk_org());
				map1.put("pk_group", bvo.getPk_group());
				map1.put("bill_type", "F5");//��������
				map1.put("trade_type", "F5-Cxx-NC65");//�����������
				map1.put("pk_tradetypeid","10011A100000003A10PW");//���ݽ�������
				map1.put("pk_currtype", bvo.getPk_currtype());
				map1.put("bill_date", applyVO.getBillmakedate().toLocalString()+" 00:00:00");
				map1.put("pay_primal", bvo.getApplymny().doubleValue());//����ԭ�ҽ�� -- ���븶����
				map1.put("pk_oppaccount", bvo.getPk_bankacc_p());//�����˺�
				map1.put("creationtime", applyVO.getCreationtime().toLocalString());//
				map1.put("direction", "-1");
				map1.put("pk_account", bvo.getPk_bankacc_r());//�տ������˻� 		
				map1.put("accountopenbank", bank.get("name"));//�տ��������� 
				map1.put("accountname", bank.get("accname"));//�տ��˻����� 
				map1.put("pk_balatype", bvo.getPk_balatype());//���㷽ʽ--(��ȡ)
				map1.put("objecttype", "1");
				map1.put("pk_supplier", applyVO.getPk_supplier());//��Ӧ��
				map1.put("pay_last", bvo.getApplymny().doubleValue());//ʵ��ԭ�ҽ����㣩applymny��ȡ�������븶����
				map1.put("paylocal_last", bvo.getApplymny().doubleValue());//ʵ�����ҽ����㣩applymny��ȡ�������븶����
				list.add(map1); 
			}
			
			map.put("body", list);//���帳ֵ
			ICallNccOpenAPIUtil CallNccOpenAPI = NCLocator.getInstance().lookup(ICallNccOpenAPIUtil.class);
			String param = JSONObject.toJSONString(map);//������ת����json��ʽ
			JSONObject json = JSONObject.parseObject(param);//json���ݸ�ʽת����json����
//			CallNccOpenAPI.callAPI(json);
		}
		return null;
	}

	@Override
	public String ExamineApproveNCC(Object[] os) {
		return null;
	}

	@Override
	public String ExpenseApproveNCC(Object[] os) {
		return null;
	}

	
}





















