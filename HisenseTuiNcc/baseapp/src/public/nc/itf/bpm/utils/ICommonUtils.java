package nc.itf.bpm.utils;

import java.util.List;
import java.util.Map;

import nc.vo.bpm.BPMApproveRecordVO;
import nc.vo.bpm.LogVO;
import nc.vo.fdcpmco.contract.CoContractVO;

public interface ICommonUtils {
	//post请求，适合.net版本BPM
	public String doPost_RequiresNew(String url,String param);
	//获取新版BPM接口token
	public String getTokenFromBPM_RequiresNew();
	//获取新版BPM接口tokenID
	public String getTokenIDFromBPM_RequiresNew();
	//
	public String getTokenIDByUseridFromBPM_RequiresNew();
	//调用新版BPM接口发起流程
	public String doPostJavaBPM_RequiresNew(String url,String token,String sourceSys,Map<String,Object> requestParams);
	//查询新版BPM流程图url
	public String getBPMWorkflowurl_RequiresNew(String url,String token,String sourcesys,String billid,String k2id,String psncode,int formType);
	//记录日志
	public void recordLog_RequiresNew(LogVO log);
	//记录BPM流程和NC单据对应关系
	public void recordApprove_RequiresNew(List<BPMApproveRecordVO> list,String billid);
	//调用BPM流程作废接口
	public void deleteBPMFlow(String cuserid,Object[] obj);
	//调用新版本BPM查询审批记录
	public void getApproveRecordFromNewBPM_RequiresNew(String pk_bill);
	//修改单据状态已提交为审批进行中
	public String changeBillStatusSubmit2Approving(Object obj);
	//项目团队推送材料管理系统
	public String projTeam2Xinrui_RequiresNew(CoContractVO contVO);
	//项目团队推送材料管理系统抛出异常时修改数据库
	public Object InsertORModify_RequiresNew(String pk_cont);
	//请求内容类型为application/x-www-form-urlencoded
	public String doPostNew_RequiresNew(String url,String param);
	//调用消息中心接口
	public List<Object> doPostMsgCenter_RequiresNew(String urlStr, String param);
	//调用https post接口
	public String getBPMWorkflowurl_RequiresNew(String url,String param);
}
