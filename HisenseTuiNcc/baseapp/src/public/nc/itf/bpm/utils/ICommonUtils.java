package nc.itf.bpm.utils;

import java.util.List;
import java.util.Map;

import nc.vo.bpm.BPMApproveRecordVO;
import nc.vo.bpm.LogVO;
import nc.vo.fdcpmco.contract.CoContractVO;

public interface ICommonUtils {
	//post�����ʺ�.net�汾BPM
	public String doPost_RequiresNew(String url,String param);
	//��ȡ�°�BPM�ӿ�token
	public String getTokenFromBPM_RequiresNew();
	//��ȡ�°�BPM�ӿ�tokenID
	public String getTokenIDFromBPM_RequiresNew();
	//
	public String getTokenIDByUseridFromBPM_RequiresNew();
	//�����°�BPM�ӿڷ�������
	public String doPostJavaBPM_RequiresNew(String url,String token,String sourceSys,Map<String,Object> requestParams);
	//��ѯ�°�BPM����ͼurl
	public String getBPMWorkflowurl_RequiresNew(String url,String token,String sourcesys,String billid,String k2id,String psncode,int formType);
	//��¼��־
	public void recordLog_RequiresNew(LogVO log);
	//��¼BPM���̺�NC���ݶ�Ӧ��ϵ
	public void recordApprove_RequiresNew(List<BPMApproveRecordVO> list,String billid);
	//����BPM�������Ͻӿ�
	public void deleteBPMFlow(String cuserid,Object[] obj);
	//�����°汾BPM��ѯ������¼
	public void getApproveRecordFromNewBPM_RequiresNew(String pk_bill);
	//�޸ĵ���״̬���ύΪ����������
	public String changeBillStatusSubmit2Approving(Object obj);
	//��Ŀ�Ŷ����Ͳ��Ϲ���ϵͳ
	public String projTeam2Xinrui_RequiresNew(CoContractVO contVO);
	//��Ŀ�Ŷ����Ͳ��Ϲ���ϵͳ�׳��쳣ʱ�޸����ݿ�
	public Object InsertORModify_RequiresNew(String pk_cont);
	//������������Ϊapplication/x-www-form-urlencoded
	public String doPostNew_RequiresNew(String url,String param);
	//������Ϣ���Ľӿ�
	public List<Object> doPostMsgCenter_RequiresNew(String urlStr, String param);
	//����https post�ӿ�
	public String getBPMWorkflowurl_RequiresNew(String url,String param);
}
