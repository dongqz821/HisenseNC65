package nc.bs.pub.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import nc.bs.er.util.BXDataPermissionChkUtil;
import nc.bs.erm.util.ErUtil;
import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.bs.pub.compiler.AbstractCompiler2;
import nc.imag.itf.IImagUtil;
import nc.itf.baseapp.utils.ICallNccOpenAPIUtil;
import nc.itf.baseapp.utils.IPushSingleNCC;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.MapProcessor;
import nc.vo.arap.bx.util.ActionUtils;
import nc.vo.arap.bx.util.BXConstans;
import nc.vo.ep.bx.BXVO;
import nc.vo.ep.bx.JKBXVO;
import nc.vo.erm.common.MessageVO;
import nc.vo.erm.util.ImageCheckUtil;
import nc.vo.fipub.exception.ExceptionHandler;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.change.PublicHeadVO;
import nc.vo.pub.compiler.PfParameterVO;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.trade.pub.IBillStatus;
import nc.vo.uap.pf.PFBusinessException;
import ncc.baseapp.utils.ConfigUtils;

/**
 * 备注：借款单的审核 单据动作执行中的动态执行类的动态执行类。
 * 
 * 创建日期：(2007-7-9)
 * 
 * @author 平台脚本生成
 */
public class N_264X_UNAPPROVE extends AbstractCompiler2 {

	public N_264X_UNAPPROVE() {
		super();
//		m_methodReturnHas = new Hashtable<String, Object>();
		m_keyHas = null;
	}

	/*
	 * 备注：平台编写规则类 接口执行类
	 */
	@Override
	public Object runComClass(PfParameterVO vo) throws BusinessException {
		try {
			super.m_tmpVo = vo;
			
			// ####本脚本必须含有返回值,返回DLG和PNL的组件不允许有返回值####
			Object retObj = null;
			// ####重要说明：生成的业务组件方法尽量不要进行修改####
			// ####该组件为单动作工作流处理结束...不能进行修改####
			// 方法说明:null
			
			List<JKBXVO> auditVOs=new ArrayList<JKBXVO>();
			
			List<MessageVO> fMsgs=new ArrayList<MessageVO>();
			
			BXVO bxvo = (BXVO) vo.m_preValueVo;
			
//begin--added by chendya 报销单反审核数据权限校验			
			//是否期初单据
			boolean isQc = bxvo.getParentVO().getQcbz().booleanValue();
			//是否常用单据
			boolean isInit = bxvo.getParentVO().isInit();
			//是否从NC客户端
			boolean isNCClient=bxvo.isNCClient();
			//非期初、常用单据校验数据权限
			if(isNCClient){
				if(!isQc&&!isInit){
					//审核操作权限校验	
					BXDataPermissionChkUtil.process(bxvo, BXConstans.ERMEXPRESOURCECODE, BXConstans.EXPUNAPPROVECODE,vo.m_operator);
				}
			}
//--end			
			int spStatus = bxvo.getParentVO().getSpzt();
			boolean bflag = procUnApproveFlow(vo);
			boolean isWorkFlow = ErUtil.isUseWorkFlow(bxvo.getParentVO().getPk_org());
			boolean isWorkFlowFinalNode = ErUtil.isWorkFlowFinalNode(vo);
			
			//报销单取消审批影像校验
			if(isWorkFlow){
				checkImage(bxvo);
			}
			
			if (isWorkFlow && isWorkFlowFinalNode) {// 工作流时
				auditVOs.add(bxvo);
			} else {
				if (!isWorkFlow) {// 审批流时
					if (bflag && spStatus != IBillStatus.NOPASS) {
						if (vo.m_workFlow == null) {
							bxvo.getParentVO().setSpzt(IBillStatus.COMMIT);
						}
						auditVOs.add(bxvo);
					} else {
						fMsgs.add(new MessageVO(bxvo, ActionUtils.UNAUDIT));
					}
				} else {
					fMsgs.add(new MessageVO(bxvo, ActionUtils.UNAUDIT));
				}
			}
			
			setParameter("billVO", auditVOs.toArray(new BXVO[] {}));

			retObj = runClass("nc.bs.arap.bx.BXZbBO", "unAudit", "&billVO:nc.vo.ep.bx.JKBXVO[]", vo, m_keyHas);

			if (retObj != null){
				MessageVO[] msgs=(MessageVO[]) retObj;
				for (int i = 0; i < msgs.length; i++) {
					fMsgs.add(msgs[i]);
				}
				//调NCC删除的接口
				Map<String, Object> map = new HashMap<String, Object>();
				String user = InvocationInfoProxy.getInstance().getUserId();// g01----00011A10000000003ALB 设置当前操作用户
				map.put("pk_approver", user);
				
				IUAPQueryBS query = NCLocator.getInstance().lookup(
						IUAPQueryBS.class);
				Map bank = null;
				try {
					Object object = query
							.executeQuery(
									"select pk_org from org_orgs where isbusinessunit = 'Y' and dr = 0 and  name = '"+ bxvo.getParentVO().getZyx1() + "'",
									new MapProcessor());
					if (object != null) {
						bank = (Map) object;
					}
				} catch (BusinessException e) {
					Logger.error(e.getMessage());
	                ExceptionUtils.wrappBusinessException("调用sql发生异常："+e.getMessage());
				}
				
				map.put("pk_org", bank.get("pk_org"));
				map.put("pk_pk", bxvo.getParentVO().getPk_jkbx());
//				map.put("", bxvo.getParentVO().getPk_jkbx());
				try {
					String param = JSONObject.toJSONString(map);//将数组转化成json格式
					JSONObject json = JSONObject.parseObject(param);//json数据格式转换成json对象
					ICallNccOpenAPIUtil nccdel = NCLocator.getInstance().lookup(ICallNccOpenAPIUtil.class);
					String nccdelip = ConfigUtils.getValueFromProperties("nccdelip");
					String nccdelyz = ConfigUtils.getValueFromProperties("nccdelyz");	
					
					JSONObject jjson = new JSONObject();
					String[] str = new String[1];
					str[0] = json.getString("pk_pk");
					jjson.put("data", str);	
					String api = nccdel.callAPI(nccdelyz, jjson);
					JSONObject jsonapi = JSONObject.parseObject(api);
					if (jsonapi.getBooleanValue("success")) {
						String resout = nccdel.callAPI(nccdelip, json);
						JSONObject jsonsucc = JSONObject.parseObject(resout);
						if (!jsonsucc.getBooleanValue("success")) {
							ExceptionUtils.wrappBusinessException("调用NCC接口异常:" + jsonsucc.getString("msg"));
						}
					}else {
						return "{\"success\":\"false\",\"code\":\"200\",\"msg\":\"已生成凭证，不可删除！！\"}";
					}
				} catch (Exception e) {
					ExceptionUtils.wrappBusinessException("调用NCC接口异常!"+e.getMessage());
				}
			}
			
			return fMsgs.toArray(new MessageVO[]{});
			
		} catch (Exception ex) {
			if (ex instanceof BusinessException)
				throw (BusinessException) ex;
			else
				throw new PFBusinessException(ex.getMessage(), ex);
		}
	}


	@Override
	public String getCodeRemark() {
		return "erm action script not allowed modify, all rights reserved!;";
	}

	/*
	 * 备注：设置脚本变量的HAS
	 */
	protected void setParameter(String key, Object val) {
		if (m_keyHas == null) {
			m_keyHas = new Hashtable<String, Object>();
		}
		if (val != null) {
			m_keyHas.put(key, val);
		}
	}
	
//	protected java.util.Hashtable<String, Object> m_methodReturnHas = new java.util.Hashtable<String, Object>();

	protected Hashtable<String, Object> m_keyHas = null;
	

	protected void getPfVO(PfParameterVO paraVo, JKBXVO bxvo) {
		
		PublicHeadVO standHeadVo = new PublicHeadVO();
		
		getHeadInfo(standHeadVo, bxvo, bxvo.getParentVO().getDjlxbm());

		paraVo.m_billType=standHeadVo.billType;
		paraVo.m_billNo = standHeadVo.billNo;
		paraVo.m_billId = standHeadVo.pkBillId;
		paraVo.m_pkOrg = standHeadVo.pkOrg;
		paraVo.m_makeBillOperator = standHeadVo.operatorId;
		paraVo.m_preValueVo = bxvo;
		paraVo.m_preValueVos = new JKBXVO[]{bxvo};
		paraVo.m_standHeadVo = standHeadVo;
	}
	
	private void getHeadInfo(nc.vo.pub.change.PublicHeadVO headvo, AggregatedValueObject vo,
			String billtype) {
		headvo.billType = billtype;
	
	}
	
	
	private void checkImage(JKBXVO bxvo) throws BusinessException{
		if(bxvo == null || bxvo.getParentVO() == null || bxvo.getParentVO().getPk_jkbx() ==null ){
			
		}
		
		boolean isWfOnImage = false;
		boolean isInstalled = ImageCheckUtil.isInstalledIamge(bxvo);//是否安装影像模块
		
		if(!isInstalled){
			return;
		}
		
		try {
			isWfOnImage = ((IImagUtil) NCLocator.getInstance().lookup(IImagUtil.class.getName())).isWFOnImageActivity(bxvo.getParentVO().getPk_jkbx());
		} catch (Exception e) {//影像服务无法判断是否安装，这里抛出异常就认为没有安装
			ExceptionHandler.handleException(e);
		}
		
		if(isWfOnImage){
			throw  new BusinessException(nc.vo.ml.NCLangRes4VoTransl.getNCLangRes().getStrByID("expensepub_0", "0expense-000006")/*
					 * @
					 * res
					 * "当前有影像扫描活动正在进行，无法反审单据"
					 */);
		}
	}
}
