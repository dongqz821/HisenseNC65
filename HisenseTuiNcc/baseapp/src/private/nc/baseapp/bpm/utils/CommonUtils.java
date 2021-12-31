package nc.baseapp.bpm.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.bs.trade.billsource.DefaultBillFlowFactory;
import nc.bs.trade.billsource.DefaultDataFinder;
import nc.bs.trade.billsource.IBillDataFinder;
import nc.impl.mdm.service.DES;
import nc.itf.bpm.utils.ICommonUtils;
import nc.itf.fdcpmco.esign.ConfigUtils;
import nc.itf.fdcpmco.esign.FtpUtils;
import nc.itf.fdcpr.app.InterfaceLogVO;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.ArrayProcessor;
import nc.jdbc.framework.processor.BeanListProcessor;
import nc.jdbc.framework.processor.BeanProcessor;
import nc.jdbc.framework.processor.MapListProcessor;
import nc.jdbc.framework.processor.MapProcessor;
import nc.vo.baseapp.pushmsg.TransFailMsgVO;
import nc.vo.bd.balatype.BalaTypeVO;
import nc.vo.bd.currtype.CurrtypeVO;
import nc.vo.bd.defdoc.DefdocVO;
import nc.vo.bd.psn.PsndocVO;
import nc.vo.bd.supplier.SupplierVO;
import nc.vo.bpm.BPMApproveRecordVO;
import nc.vo.bpm.BpmApproveStatus;
import nc.vo.bpm.LogVO;
import nc.vo.bpm.WorkflowVO;
import nc.vo.ep.bx.JKBXVO;
import nc.vo.ep.bx.JKVO;
import nc.vo.erm.matterapp.AggMatterAppVO;
import nc.vo.fdcpmbd.conttype.ContTypeVO;
import nc.vo.fdcpmbd.pub.tools.conttemplet.IPrintService;
import nc.vo.fdcpmbd.pub.tools.rtf.ICMGenerateRTFDocument;
import nc.vo.fdcpmbd.pub.tools.rtf.IWordDef;
import nc.vo.fdcpmbd.pub.tools.rtf.jacob.RtfHelper;
import nc.vo.fdcpmco.contract.AggCoContractVO;
import nc.vo.fdcpmco.contract.CoContractVO;
import nc.vo.fdcpmco.contractrevise.AggCoContractReviseVO;
import nc.vo.fdcpmco.fdcpm_sm_zb.AggZBVO;
import nc.vo.fdcpmco.htmblc.AggHtmblcVO;
import nc.vo.fdcpmco.htmblc.HtmblcVO;
import nc.vo.fdcpmco.nocont.AggConocontVO;
import nc.vo.fdcpmcost.accum.AggCostAccumVO;
import nc.vo.fdcpmcs.contalter.AggContAlterVO;
import nc.vo.fdcpmcs.mate.AggMateMeteVO;
import nc.vo.fdcpmcs.prodappr.AggProdApprVO;
import nc.vo.fdcpmfp.allocation.AggFPAllocationVO;
import nc.vo.fdcpmfp.temporary.AggFPTemporaryVO;
import nc.vo.fdcpmpay.apply.AggPayApplyVO;
import nc.vo.fdcpmrp.contplan.AggRPContPlanVO;
import nc.vo.fdcprhx.discountplan.AggDiscountPlanVO;
import nc.vo.fdcprhx.refund.AggRefundVO;
import nc.vo.org.DeptVO;
import nc.vo.org.OrgVO;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.VOStatus;
import nc.vo.pub.billtype.BilltypeVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pub.workflownote.WorkflownoteVO;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.sm.UserVO;
import nc.vo.trade.billsource.LightBillVO;
import nc.vo.vorg.FinanceOrgVersionVO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import sun.misc.BASE64Encoder;
import uap.pub.fs.client.FileStorageClient;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * 接口工具类
 * @author dingxm
 * @date 2020-07-22
 *
 */
public class CommonUtils implements ICommonUtils{
	
	/**
	 * 查询自定义档案中配置的BPM参数是否启用（只查询月度资金计划TB0003是否启用接口）
	 * @param defdoccode自定义档案编码
	 * @return
	 */
	public boolean getDefDoc(String defdoccode){
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		boolean bpmenable = false;
		try {
			String memo = "";
			StringBuffer sql = new StringBuffer(" select b.def2 from bd_defdoclist a")
				.append(" inner join bd_defdoc b on a.pk_defdoclist = b.pk_defdoclist")
				.append(" where a.code = 'UAP001' and b.code = '" + defdoccode + "'");
			Object[] objs = (Object[]) query.executeQuery(sql.toString(), new ArrayProcessor());
			if(objs!=null && objs.length>0){
				if(objs[0]!=null){
					memo = objs[0].toString();
				}
			}
			bpmenable = "Y".equals(memo)?true:false;
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("查询用户自定义档案中BPM参数是否启用发生异常："+e.getMessage());
		}
		return bpmenable;
		
	}
	
	/**
	 * 根据自定义档案主键查询自定义档案VO
	 * @param pk_defdoc
	 * @return
	 */
	public DefdocVO getDefdocVOByPK(String pk_defdoc){
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		DefdocVO defdocVO = null;
		try {
			defdocVO = (DefdocVO) query.retrieveByPK(DefdocVO.class, pk_defdoc);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return defdocVO;
	}
	
	/**
	 * 根据单据类型查询各个单据是否启用BPM接口(月度资金计划除外)
	 * @param billtypecode
	 * @return
	 */
	public boolean getEnableByBilltype(String billtypecode){
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		boolean res = false;
		try{
			StringBuffer sql = new StringBuffer(" select a.def2,c.pk_billtypecode from bd_defdoc a")
				.append(" inner join bd_defdoclist b on a.pk_defdoclist = b.pk_defdoclist")
				.append(" inner join bd_billtype c on a.def1 = c.pk_billtypeid")
				.append(" where b.code='UAP001'")
				.append(" and c.pk_billtypecode = '" + billtypecode + "'");
			Object[] objs = (Object[]) query.executeQuery(sql.toString(), new ArrayProcessor());
			if(objs!=null && objs.length>0 && objs[0]!=null && "Y".equals(objs[0].toString())){
				res = true;
			}
		}catch(Exception e){
			res = false;
		}
		return res;
	}
	
	/**
	 * 数据类型转交换(UFDouble、UFDateTime)
	 * @param obj
	 * @return
	 */
	public static Object getValueFromObject(Object obj){
		Object res = null;
		if(obj instanceof UFDouble){
			res = ((UFDouble)obj).doubleValue();
		}else if(obj instanceof UFDateTime){
			res = ((UFDateTime)obj).toStdString();
		}else if(obj instanceof UFDate){
			res = ((UFDate)obj).toLocalString();
		}else{
			res = obj;
		}
		return res;
	}
	/**
	 * 获取成本核算对象和项目名称对应map
	 * @return
	 */
	public Map<String,String> getProjectNameMap(){
		Map<String,String> map = null;
		String sql = new StringBuffer(" select a.pk_cbs, b.project_name from fdcpm_bd_cbs a")
			.append(" inner join bd_project b on a.pk_project_level = b.pk_project")
			.append(" where nvl(a.dr, 0) = 0 and nvl(b.dr, 0) = 0 and b.def1 <> '~'").toString();
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			List<Map<String,String>> list = (List<Map<String, String>>) query.executeQuery(sql, new MapListProcessor());
			if(list!=null && list.size()>0){
				map = new HashMap<String,String>();
				for(int i=0;i<list.size();i++){
					map.put(list.get(i).get("pk_cbs"), list.get(i).get("project_name"));
				}
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("获取成本核算对象与项目名称对应关系发生异常："+e.getMessage());
		}
		return map;
			
	}
	/**
	 * 根据查询语句查询结果，返回ListMap
	 * @param sql
	 * @return
	 */
	public List<Map<String,Object>> getResultBySQL(String sql){
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		List<Map<String,Object>> list = null;
		try {
			list = (List<Map<String, Object>>) query.executeQuery(sql, new MapListProcessor());
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("查询语句执行错误"+sql);
		}
		return list;
	}
	/**
	 * 根据NC单据主键查询NC和BPM中间表hx_bpm_workflow中K2ID字段值
	 * @param pk_bill
	 * @return
	 */
	public String getConttypeCodeByPk(String pk_conttype){
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		String conttypecode = "";
		try {
			ContTypeVO vo = (ContTypeVO) query.retrieveByPK(ContTypeVO.class, pk_conttype);
			if(vo!=null){
				conttypecode = vo.getCode();
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("查询合同类型编码发生异常："+e.getMessage());
		}
		return conttypecode;
	}
	
	/**
	 * 根据NC单据主键查询NC和BPM中间表hx_bpm_workflow中K2ID字段值
	 * @param pk_bill
	 * @return
	 */
	public WorkflowVO getWorkflowVObyNCBillID(String field,String pk_bill,int bpmapprovestatus){
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		WorkflowVO vo = null;
		try {
			List<WorkflowVO> list = (List<WorkflowVO>) query.retrieveByClause(WorkflowVO.class, field+"='"+pk_bill+"' and k2approvestatus="+bpmapprovestatus);
			if(list!=null &&list.size()>0&& list.get(0)!=null){
				vo = list.get(0);
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("查询NC和BPM审批中间表hx_bpm_workflow发生异常："+e.getMessage());
		}
		return vo;
	}
	
	/**
	 * 根据NC单据主键查询NC和BPM中间表hx_bpm_workflow中K2ID字段值
	 * @param pk_bill
	 * @return
	 */
	public WorkflowVO getWorkflowVObyNCBillID(String field,String pk_bill){
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		WorkflowVO vo = null;
		try {
			List<WorkflowVO> list = (List<WorkflowVO>) query.retrieveByClause(WorkflowVO.class, field+"='"+pk_bill+"'");
			if(list!=null &&list.size()>0&& list.get(0)!=null){
				vo = list.get(0);
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("查询NC和BPM审批中间表hx_bpm_workflow发生异常："+e.getMessage());
		}
		return vo;
	}
	
	/**
	 * 根据用户编码获取用户VO
	 * @param dao
	 * @param usercode
	 * @return
	 */
	public UserVO getUserVOByCode(BaseDAO dao,String usercode){
		UserVO uservo = null;
		try {
			List<UserVO> uservoList = (List<UserVO>) dao.retrieveByClause(UserVO.class, "nvl(dr,0)=0 and user_code='"+usercode+"'");
			if(uservoList!=null && uservoList.size()>0){
				uservo = uservoList.get(0);
			}
			return uservo;
		} catch (Exception e) {
			return null;
		}
	}
	
	public UserVO getUserVOByPsncode(String psncode){
		if(psncode==null || "".equals(psncode)){
			return null;
		}
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		UserVO user = null;
		try {
			Object object = query.executeQuery("select * from sm_user a left join bd_psndoc b on a.pk_psndoc = b.pk_psndoc where nvl(b.dr,0)=0 and b.code='"+psncode+"'", new BeanProcessor(UserVO.class));
			if(object!=null){
				user = (UserVO) object;
			}
		} catch (BusinessException e) {
			return  null;
		}
		return user;
	}
	
	public String getPk_UserByPsncode(String psncode){
		if(psncode==null || "".equals(psncode)){
			return null;
		}
		
		String pk_user = "";
		try {
			IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
			Object[] objs = (Object[]) query.executeQuery("select cuserid from sm_user a left join bd_psndoc b on a.pk_psndoc = b.pk_psndoc where nvl(b.dr,0)=0 and b.code='"+psncode+"'", new ArrayProcessor());
			if(objs!=null && objs.length>0){
				if(objs[0]!=null){
					pk_user = objs[0].toString();					
				}
			}
		} catch (Exception e) {
		}
		return pk_user;
	}
	
	/**
	 * 根据组织编码获取组织主键
	 * @param dao
	 * @param orgCode
	 * @return
	 */
	public String getPkorgByCode(BaseDAO dao,String orgCode){
		String pk_org = "";
		try {
			List<OrgVO> orgList = (List<OrgVO>) dao.retrieveByClause(OrgVO.class, "code='"+orgCode+"'");
			if(orgList!=null && orgList.size()>0){
				pk_org = orgList.get(0).getPk_org();
			}
		} catch (DAOException e) {
		}
		return pk_org;
	}
	
	/**
	 * 根据组织主键获取组织
	 * @param dao
	 * @param orgCode
	 * @return
	 */
	public OrgVO getOrgBypkorg(String pk_org){
		OrgVO orgVO = null;
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			orgVO = (OrgVO) query.retrieveByPK(OrgVO.class, pk_org);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("查询组织发生错误："+e.getMessage());
		}
		return orgVO;
	}
	
	/**
	 * 根据财务组织编码获取财务组织FinanceOrgVersionVO
	 * @param dao
	 * @param orgCode
	 * @return
	 */
	public FinanceOrgVersionVO getOrgbyCode(String orgCode){
		FinanceOrgVersionVO orgVO = null;
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			List<FinanceOrgVersionVO> list= (List<FinanceOrgVersionVO>) query.retrieveByClause(FinanceOrgVersionVO.class, "code='"+orgCode+"'");
			if(list!=null && list.size()>0){
				orgVO = list.get(0);
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("查询财务组织发生错误："+e.getMessage());
		}
		return orgVO;
	}
	/**
	 * 根据银行账户子户编码查询子户vo
	 * @param accountCode
	 * @return
	 */
	public nc.vo.bd.bankaccount.BankAccSubVO getBankAccSubVObyCode(String accountCode){
		nc.vo.bd.bankaccount.BankAccSubVO subVO = null;
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			List<nc.vo.bd.bankaccount.BankAccSubVO> list= (List<nc.vo.bd.bankaccount.BankAccSubVO>) query.retrieveByClause(nc.vo.bd.bankaccount.BankAccSubVO.class, "accnum='"+accountCode+"'");
			if(list!=null && list.size()>0){
				subVO = list.get(0);
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("查询银行账户子户发生错误："+e.getMessage());
		}
		return subVO;
	}
	
	/**
	 * 根据部门编码查询部门VO
	 * @param deptCode
	 * @return
	 */
	public DeptVO getDeptVObyCode(String deptCode){
		DeptVO deptVO = null;
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			List<DeptVO> list= (List<DeptVO>) query.retrieveByClause(DeptVO.class, "code='"+deptCode+"'");
			if(list!=null && list.size()>0){
				deptVO = list.get(0);
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("查询部门VO发生错误："+e.getMessage());
		}
		return deptVO;
	}
	
	/**
	 * 根据交易类型编码查询交易类型VO
	 * @param billtypeCode
	 * @return
	 */
	public BilltypeVO getBilltypeVObyCode(String billtypeCode){
		BilltypeVO tradetypeVO = null;
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			List<BilltypeVO> list= (List<BilltypeVO>) query.retrieveByClause(BilltypeVO.class, "pk_billtypecode='"+billtypeCode+"'");
			if(list!=null && list.size()>0){
				tradetypeVO = list.get(0);
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("查询交易类型发生错误："+e.getMessage());
		}
		return tradetypeVO;
	}
	
	/**
	 * 根据交易类型编码查询交易类型VO
	 * @param balatypeCode
	 * @return
	 */
	public BalaTypeVO getBalaTypeVObyCode(String balatypeCode){
		BalaTypeVO balaTypeVO = null;
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			List<BalaTypeVO> list= (List<BalaTypeVO>) query.retrieveByClause(BalaTypeVO.class, "code='"+balatypeCode+"'");
			if(list!=null && list.size()>0){
				balaTypeVO = list.get(0);
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("查询结算方式发生错误："+e.getMessage());
		}
		return balaTypeVO;
	}
	
	/**
	 * 根据纳税人识别号查询供应商VO
	 * @param taxCode
	 * @return
	 */
	public SupplierVO getSupplierVObyTaxcode(String taxCode){
		SupplierVO supplierVO = null;
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			List<SupplierVO> list= (List<SupplierVO>) query.retrieveByClause(SupplierVO.class, "taxpayerid='"+taxCode+"'");
			if(list!=null && list.size()>0){
				supplierVO = list.get(0);
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("根据纳税人识别号查询供应商VO错误："+e.getMessage());
		}
		return supplierVO;
	}
	
	/**
	 * 根据币种编码查询币种VO
	 * @param accountCode
	 * @return
	 */
	public CurrtypeVO getCurrtypeVObyCode(String code){
		CurrtypeVO currtypeVO = null;
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			List<CurrtypeVO> list= (List<CurrtypeVO>) query.retrieveByClause(CurrtypeVO.class, "code='"+code+"'");
			if(list!=null && list.size()>0){
				currtypeVO = list.get(0);
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("根据编码查询币种错误："+e.getMessage());
		}
		return currtypeVO;
	}
	
	
	/**
	 * 根据核素对象主键查询核算对象名称和项目编码(主数据编码)
	 * @param pk_cbs
	 * @return
	 */
	public String[] getCBSNameAndProjcode(String pk_cbs){
		String[] result = new String[2];
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		StringBuffer sb = new StringBuffer(" select a.name projectname, b.def1 projectcode from fdcpm_bd_cbs a")
			.append(" inner join bd_project b on a.pk_project_level = b.pk_project")
			.append(" where a.pk_cbs = '"+pk_cbs+"'");
		try {
			Object[] objs = (Object[]) query.executeQuery(sb.toString(), new ArrayProcessor());
			if(objs!=null && objs.length>0){
				if(objs[0]!=null){
					result[0] = objs[0].toString();
				}
				if(objs[1]!=null){
					result[1] = objs[1].toString();
				}
			}
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("根据核算对象查询项目编码发生错误："+e.getMessage());
		}
		return result;

	}
	
	/**
	 * 获取指定组织下所有部门
	 * @param dao
	 * @param pk_org
	 * @return
	 */
	public Map<String,String> getDeptListByPkOrg(BaseDAO dao,String pk_org){
		StringBuffer sql = new StringBuffer("select dept.code,dept.pk_dept from org_dept dept")
			.append(" where nvl(dept.dr,0)=0 and dept.pk_org ='"+pk_org+"'");
		Map<String,String> map = null;
		try {
			List<Map<String,String>> list = (List<Map<String, String>>) dao.executeQuery(sql.toString(), new MapListProcessor());
			if(list!=null && list.size()>0){
				map = new HashMap<String,String>();
				for(int i=0;i<list.size();i++){
					Map<String,String> tmp = list.get(i);
					map.put(tmp.get("code"), tmp.get("pk_dept"));
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 获取指定组织下所有部门
	 * @param dao
	 * @param pk_org
	 * @return
	 */
	public Map<String,String> getDeptNameMapByPkOrg(String pk_org){
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		StringBuffer sql = new StringBuffer("select dept.name,dept.pk_dept from org_dept dept")
			.append(" where nvl(dept.dr,0)=0 and dept.pk_org ='"+pk_org+"'");
		Map<String,String> map = null;
		try {
			List<Map<String,String>> list = (List<Map<String, String>>) query.executeQuery(sql.toString(), new MapListProcessor());
			if(list!=null && list.size()>0){
				map = new HashMap<String,String>();
				for(int i=0;i<list.size();i++){
					Map<String,String> tmp = list.get(i);
					map.put(tmp.get("pk_dept"),tmp.get("name"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 根据主键获取部门vo
	 * @param dao
	 * @param pk_org
	 * @return
	 */
	public DeptVO getDeptVObyPkdept(String pk_dept){
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		DeptVO deptVO = null;
		try {
			deptVO = (DeptVO) query.retrieveByPK(DeptVO.class, pk_dept);
		} catch (BusinessException e) {
			ExceptionUtils.wrappBusinessException("查询部门名称发生错误："+e.getMessage());
		}
		return deptVO;
	}
	/**
	 * 根据人员编码获取人员vo
	 * @param dao
	 * @param psncode员工编码
	 * @return
	 */
	public PsndocVO getPsnByCode(BaseDAO dao,String psncode){
		PsndocVO psndocVO = null;
		try {
			List<PsndocVO> orgList = (List<PsndocVO>) dao.retrieveByClause(PsndocVO.class, "code='"+psncode+"'");
			if(orgList!=null && orgList.size()>0){
				psndocVO = orgList.get(0);
			}
		} catch (DAOException e) {
			ExceptionUtils.wrappBusinessException("查询组织发生错误："+e.getMessage());
		}
		return psndocVO;
	}
	
	/**
	 * 根据用户主键获取关联身份的员工编码
	 * @param dao
	 * @param psncode员工编码
	 * @return
	 */
	public Map<String,String> getPsnInfoByUserid(String userid){
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		Map<String,String> map = null;
		StringBuffer sb = new StringBuffer(" select a.cuserid, b.code, b.name ,d.name orgname,d.code orgcode,")
			.append("dept.code deptcode,dept.name deptname,e.postcode,e.postname,f.jobcode,f.jobname from sm_user a")
			.append(" inner join bd_psndoc b on a.pk_psndoc = b.pk_psndoc")
			.append(" left join hi_psnjob c on b.pk_psndoc = c.pk_psndoc and c.ismainjob='Y' and c.lastflag='Y' ")
			.append(" left join org_orgs d on d.pk_org = c.pk_org")
			.append(" left join org_dept dept on c.pk_dept = dept.pk_dept")
			.append(" left join om_post e on e.pk_post = c.pk_post")
			.append(" left join om_job f on c.pk_job = f.pk_job")
			.append(" where a.cuserid = '"+userid+"'");
		try {
			List<Map<String,String>> list = (List<Map<String, String>>) query.executeQuery(sb.toString(), new MapListProcessor());
			if(list!=null && list.size()>0){
				map = list.get(0);
			}
			if(map==null){
				ExceptionUtils.wrappBusinessException("当前用户未关联身份，请联系系统管理员维护用户身份");
			}
		} catch (Exception e) {
			ExceptionUtils.wrappBusinessException("根据用户主键获取员工编码发生错误："+e.getMessage());
		}
		return map;
	}
	
	/**
	 * 获取所有成本科目
	 * @param dao
	 * @param pk_org
	 * @return
	 */
	public Map<String,Map<String,String>> getAllCostpro(){
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		String sql = "select a.pk_costpro,a.name,a.code,b.code parentcode,b.pk_costpro pk_parentcostpro from fdcpm_bd_costpro a left join fdcpm_bd_costpro b on a.pk_parent = b.pk_costpro where nvl(a.dr,0)=0 and a.enablestate=2";
		Map<String,Map<String,String>> map= null;
		try {
			List<Map<String,String>> list = (List<Map<String, String>>) query.executeQuery(sql.toString(), new MapListProcessor());
			if(list!=null && list.size()>0){
				map = new HashMap<String,Map<String,String>>();
				for(int i=0;i<list.size();i++){
					Map<String,String> tmp = list.get(i);
					map.put(tmp.get("pk_costpro"), tmp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 获取所有成本科目编码
	 * @param dao
	 * @param pk_org
	 * @return
	 */
	public Map<String,String> getAllCostproCode(){
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		String sql = "select pk_costpro,name,code from fdcpm_bd_costpro where nvl(dr,0)=0 and enablestate=2";
		Map<String,String> map = new HashMap<String,String>();
		try {
			List<Map<String,String>> list = (List<Map<String, String>>) query.executeQuery(sql.toString(), new MapListProcessor());
			if(list!=null && list.size()>0){
				for(int i=0;i<list.size();i++){
					Map<String,String> tmp = list.get(i);
					map.put(tmp.get("pk_costpro"),tmp.get("code"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}	
	
	/**
	 * 单据附件(包含一键打印的成本合同根据模板生成的pdf文件)上传FTP服务器
	 * @param pk_bill合同模板设置单主键
	 * @param obj
	 */
	public List<Map<String,String>> updateFiles2FTP(String pk_bill,Object obj){
		List<Map<String,String>> fileList = new ArrayList<Map<String,String>>();
		List<Map<String,String>> onekeyPrintFileList = null;
		//合同模板设置单据
		if(obj instanceof AggHtmblcVO){//
			Map<String,String> cast2WordMap = uploadContTemplate((AggHtmblcVO)obj);
			onekeyPrintFileList = new ArrayList<Map<String,String>>();
			onekeyPrintFileList.add(cast2WordMap);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("select pk, pk_doc,filepath,filelength from sm_pub_filesystem where isfolder='n'")
		.append(" and (filepath = '" + pk_bill + "' or filepath like '" + pk_bill + "/%') order by signsort asc");
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		List<Map<String, String>> list = null;
		try {
			list = (List<Map<String, String>>) query.executeQuery(sb.toString(), new MapListProcessor());
		} catch (BusinessException e1) {
			ExceptionUtils.wrappBusinessException("查询单据附件发生异常："+e1.getMessage());
		}
		
		for(int f=0;f<list.size();f++){
			Map<String,String> map = list.get(f);
			String filepath = map.get("filepath");
			String pk_doc = map.get("pk_doc");
			String pk_file = map.get("pk");
	        int index = filepath.lastIndexOf("/");
	        String fileName = filepath.substring(index + 1);
            fileName = pk_bill + "-" + fileName;
            
            File file = new File(FileStorageClient.getInstance().downloadByFilePath(pk_doc,"dingxm"));
			InputStream is = null;
			try {
				is = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				ExceptionUtils.wrappBusinessException("获取NC文件服务器上的文件异常："+e.getMessage());
			}
			if(is==null){
				ExceptionUtils.wrappBusinessException("从NC文件服务器上获取的文件为空");
			}
			FtpUtils utils = new FtpUtils();
			String period = new UFDate().toString().substring(0, 7);
			utils.uploadFile(ConfigUtils.getValueFromProperties("ftppath")+"/"+period, fileName, is);
	        String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
			StringBuffer ftpurl = new StringBuffer("ftp://")
					.append(ConfigUtils.getValueFromProperties("ftpip"))
					.append( ":" + ConfigUtils.getValueFromProperties("ftpport")) 
					.append( "/" + ConfigUtils.getValueFromProperties("ftppath")) 
					.append( "/" + period )
					.append( "/" + fileName);
			map.put("fileName", fileName);
			map.put("fileSize", String.valueOf(file.length()));
			map.put("downLoadType", "4");
			map.put("fileDownloadAddress", ftpurl.toString());
			map.put("fileExtensionName", fileType);
			//兼容新BPM
			map.put("datetime", new UFDateTime().toLocalString());
			map.put("relativePath", ftpurl.toString());
			map.put("originalFileName", fileName);
			map.put("fileId", pk_file);
			map.put("path", ftpurl.toString());
			
			fileList.add(map);
		}
		if(onekeyPrintFileList!=null){
			fileList.addAll(onekeyPrintFileList);			
		}
		return fileList;
	}
	/**
	 * 生成一键打印的文件下载url
	 * @param billid
	 * @return
	 */
	public List<Map<String,Object>> getOneKeyFileUrlUrl(String billid,Object obj){
		Map<String,Object> map = new HashMap<>();
		Map<String,String> urlMap = new HashMap<>();
		List<Map<String,Object>> annexFormList = null;
		BASE64Encoder encoder = new BASE64Encoder();
		DES des = new DES();
		if(obj instanceof AggCoContractVO){
//			AggCoContractVO aggVO = (AggCoContractVO) obj;
			CoContractVO hvo = ((AggCoContractVO) obj).getParentVO();
			String htmb = hvo.getVdef20();
			if(htmb!=null && !"".equals(htmb) && !"~".equals(htmb) && !"10011A1hxcb0000YFL0W".equals(htmb)){
				String fileName = hvo.getVname()+hvo.getVbillcode()+".doc";
				
				/*String url_fileName = "";
				try {
					url_fileName = URLEncoder.encode(fileName.replace("%", "！"),"utf-8").replaceAll("%(?![0-9a-fA-F]{2})", "%25");
					
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}*/
				String oneKeyFileUrl = ConfigUtils.getValueFromProperties("ncip")+"/servlet/GetFileServlet?onekeyprint=Y&pk_bill="+billid;
				urlMap.put("label", oneKeyFileUrl);
				urlMap.put("value","下载");
				map.put("url", urlMap);
				map.put("date", new UFDateTime().toLocalString());
				map.put("name", "NC65");
				map.put("fileName", fileName);
				map.put("needsign", "是");
				map.put("signsort",0);
				map.put("onekeyprint", "是");
				annexFormList = new ArrayList<Map<String,Object>>();
				annexFormList.add(map);								
			}
		}
		return annexFormList;
		
	}
	public List<Map<String,Object>> getPatchFileInfoByBillid(String billid){
		List<Map<String,Object>> annexFormList = new ArrayList<>();
		List<Map<String,String>> list = new ArrayList<>();
		StringBuffer sb = new StringBuffer();
		sb.append("select a.pk_doc,a.lasttime,c.name psnname,a.filepath,a.needsign,a.signsort from sm_pub_filesystem a left join sm_user b on a.creator = b.cuserid left join bd_psndoc c on b.pk_psndoc = c.pk_psndoc where a.isfolder='n'")
			.append(" and (a.filepath = '"+billid+"' or a.filepath like '"+billid+"/%')");
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		try {
			list = (List<Map<String, String>>) query.executeQuery(sb.toString(), new MapListProcessor());
			Map<String,Object> map = null;
			for(int i=0;list!=null && i<list.size();i++){
				map = new HashMap<>();
				Map<String,String> tmpMap = list.get(i);
				String pk_doc = tmpMap.get("pk_doc");
				String lasttime = tmpMap.get("lasttime");
				String psnname = tmpMap.get("psnname");
				String filepath = tmpMap.get("filepath");
				int index = filepath.lastIndexOf("/");
		        String fileName = filepath.substring(index + 1);
				Map<String,String> urlMap = new HashMap<>();
				urlMap.put("label", ConfigUtils.getValueFromProperties("ncip")+"/servlet/GetFileServlet?onekeyprint=N&pk_doc="+pk_doc);
				urlMap.put("value","下载");
				map.put("url", urlMap);
				Date date = new Date();
				date.setTime(Long.decode(lasttime));
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				map.put("date", sd.format(date));
				map.put("fileDate", sd.format(date));
				map.put("name", psnname);
				map.put("fileName", fileName);
				map.put("needsign", tmpMap.get("needsign")==null?"否":("1".equals(tmpMap.get("needsign"))?"是":"否"));
				map.put("signsort", tmpMap.get("signsort"));
				annexFormList.add(map);
			}
		} catch (Exception e) {
			ExceptionUtils.wrappBusinessException("查询附件信息发生异常："+e.getMessage());
		}
		return annexFormList;
	}
	/**
	 * 合同模板设置单据模板转换为word上传ftp
	 * @param aggVO
	 * @return
	 */
	public Map<String,String> uploadContTemplate(AggHtmblcVO aggVO){
		HtmblcVO headvo=aggVO.getParentVO();
		String pk_htmb = headvo.getPk_htmblc();
		Map<String,String> resMap = null;
		if(pk_htmb==null || "".equals(pk_htmb) || "~".equals(pk_htmb) || "10011A1hxcb0000YFL0W".equals(pk_htmb)){
			return null;
		}
		try{
			IPrintService printService = NCLocator.getInstance().lookup(IPrintService.class);
			HtmblcVO wordDef = printService.queryContractModelByPk(headvo.getPk_htmblc());
			//一键打印根据模板生成word文件并上传FTP服务器
			resMap = Cast2Word2FTP(aggVO,"", wordDef, null);			
		}catch(Exception e){
			e.printStackTrace();
		}
		return resMap;
	}
	
	public Map<String,String> Cast2Word2FTP(AggHtmblcVO aggVO,String condition, IWordDef wordDef, Map<String, Object> mapContext)
    {
		Map<String,String> map = new HashMap<String,String>();
        try
        {
            String previewFileName = "preview_word_" + System.currentTimeMillis() + ".doc";
            String file = RtfHelper.strDocTempletDirPath + previewFileName;
            String dir = new File(file).getParent();
            File fileDir = new File(dir);
            if (!fileDir.exists())
            {
                fileDir.mkdir();
            }
            ICMGenerateRTFDocument grd = NCLocator.getInstance().lookup(ICMGenerateRTFDocument.class);
            byte bytes[] = grd.createRtfFile( condition, wordDef,mapContext);
            FileUtils.writeByteArrayToFile(new File(file), bytes);
            //合同表头VO
            HtmblcVO headvo=aggVO.getParentVO();

        	InputStream is = new FileInputStream(new File(file));
        	FtpUtils utils = new FtpUtils();
			String period = headvo.getDbilldate().toString().substring(0, 7);
			
			String fileName = headvo.getPk_htmblc()+"-"+new File(file).getName();
			utils.uploadFile(ConfigUtils.getValueFromProperties("ftppath")+"/"+period, fileName, is);
			
	        String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
			StringBuffer ftpurl = new StringBuffer("ftp://")
					.append(ConfigUtils.getValueFromProperties("ftpip"))
					.append( ":" + ConfigUtils.getValueFromProperties("ftpport")) 
					.append( "/" + ConfigUtils.getValueFromProperties("ftppath")) 
					.append( "/" + period)
					.append( "/" + fileName);
			map.put("fileName", "fileName");
			map.put("fileSize", String.valueOf(new File(file).length()));
			map.put("downLoadType", "4");
			map.put("fileDownloadAddress", ftpurl.toString());
			map.put("fileExtensionName", fileType);
            
        }catch (Exception e)
        {
            Logger.error(e.getMessage(), e);
        }
        return map;
    }

	@Override
	public String doPost_RequiresNew(String urlStr, String param) {
		StringBuffer sb = new StringBuffer("");
  		try {
  			// 创建连接
  			URL url = new URL(urlStr);
  			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
  			connection.setDoOutput(true);
  			connection.setDoInput(true);
  			connection.setRequestMethod("POST");
  			connection.setUseCaches(false);
  			connection.setInstanceFollowRedirects(true);
  			connection.setRequestProperty("Content-Type", "application/json;");
  			connection.setRequestProperty("encoding", "UTF-8");
  			connection.setConnectTimeout(30000);
  			connection.setReadTimeout(30000);
  			connection.connect();
  			// POST请求
  			DataOutputStream out = new DataOutputStream(
  					connection.getOutputStream());
  			out.write(param.getBytes("UTF-8"));
  			out.flush();
  			out.close();
  			// 读取响应
  			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
  			String lines;
  			while ((lines = reader.readLine()) != null) {
  				lines = new String(lines.getBytes());
  				sb.append(lines);
  			}
  			reader.close();
  			// 断开连接
  			connection.disconnect();
  		} catch (Exception e) {
  			Logger.error(e.getMessage());
  			ExceptionUtils.wrappBusinessException("调用接口("+urlStr+")发生异常："+e.getMessage());
  		} 
  		return sb.toString();
	}

	@Override
	public void recordLog_RequiresNew(LogVO log) {
		//记录日志
  		BaseDAO dao = new BaseDAO(InvocationInfoProxy.getInstance().getUserDataSource());
  		try {
  			log.setStatus(VOStatus.NEW);
  			dao.insertVO(log);
  		} catch (Exception e) {
  			Logger.error("接口调用异常"+e.getMessage());
  			ExceptionUtils.wrappBusinessException("日志保存失败："+e.getMessage());
  		}	
	}
	@Override
	public void recordApprove_RequiresNew(List<BPMApproveRecordVO> list,String billid) {
		BaseDAO dao = new BaseDAO(InvocationInfoProxy.getInstance().getUserDataSource());
		try {
			if(billid!=null && !"".equals(billid)){
				dao.deleteByClause(BPMApproveRecordVO.class, "billid='"+billid+"'");				
			}
  			dao.insertVOList(list);
  		} catch (Exception e) {
  			Logger.error("BPM审批记录回写后，NC65保存发生异常"+e.getMessage());
  			ExceptionUtils.wrappBusinessException("日志保存失败："+e.getMessage());
  		}
	}

	@Override
	public void deleteBPMFlow(String cuserid, Object[] obj) {
		try {
			for (int i = 0; obj != null && obj.length > 0 && i < obj.length; i++) {
				String k2id = "";
				String billtype = "";
				String ncbillid = "";
				String pk_workflow = "";
				String senderCode = "";
//				boolean alreadyLog = false;
				if (obj[i] instanceof AggregatedValueObject) {
					ncbillid = ((AggregatedValueObject) obj[i]).getParentVO().getPrimaryKey();
					IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
					Object[] objs = (Object[]) query.executeQuery("select k2formid,billtype,pk_workflow,def2 from hx_bpm_workflow where ncbillid ='" + ncbillid + "'", new ArrayProcessor());//查询自由态和已经删除的
					if (objs != null && objs.length > 0) {
						k2id = objs[0]==null?"":objs[0].toString();
						billtype = objs[1]==null?"":objs[1].toString();
						pk_workflow = objs[2]==null?"":objs[2].toString();
						senderCode = objs[3]==null?"":objs[3].toString();
					}
				}
				if (pk_workflow==null || "".equals(pk_workflow)) {
					return;
				}
				String userid = InvocationInfoProxy.getInstance().getUserId();
				Map<String, String> map = getPsnInfoByUserid(userid);
				ICommonUtils util = NCLocator.getInstance().lookup(ICommonUtils.class);
				Map<String, Object> paramMap = new HashMap<String, Object>();
				String result = "";
				if ("36B2".equals(billtype) || "36B3".equals(billtype)
						|| "36K6".equals(billtype) || "TB0003".equals(billtype)
						|| "36V1".equals(billtype) || "36V2".equals(billtype)
						|| "36FA".equals(billtype) || "36FB".equals(billtype)
						|| "36FE".equals(billtype) || "36G2".equals(billtype)
						|| "36Q2".equals(billtype) || "36S4".equals(billtype)
						|| "36E1".equals(billtype) || "36E4".equals(billtype)) {// 旧版BPM(资金系统单据)
					String url = ConfigUtils.getValueFromProperties("bpmdeleteurl");
					paramMap.put("Folio", k2id);
					paramMap.put("SourceId", "NC65");
					paramMap.put("usercode", map.get("code"));
					result = util.doPost_RequiresNew(url,JSONObject.toJSONString(paramMap));
					JSONObject resultJson = JSONObject.parseObject(result);
					int code = resultJson.getInteger("code");
					if (code != 200) {
						ExceptionUtils.wrappBusinessException("单据删除时在老版BPM同步删除审批流发生错误:" + resultJson.getString("msg"));
					}
				} else {// 新版BPM
					String javabpmurl = "";
					if (!"".equals(k2id)) {//调用流程作废接口
						paramMap.put("k2ProcInstId", k2id);
						paramMap.put("employeeNo", map.get("code"));//当前操作人
//						paramMap.put("employeeNo", "".equals(senderCode)?map.get("code"):senderCode);//该流程实际发起人
						javabpmurl = ConfigUtils.getValueFromProperties("javabpmcancelurl");// 流程作废接口
					} else {// 调用流程草稿删除接口
						paramMap.put("bizId", ncbillid);
						javabpmurl = ConfigUtils.getValueFromProperties("javabpmdeleteurl");// BPM流程草稿删除接口
					}
					String token = util.getTokenFromBPM_RequiresNew();
					result = util.doPostJavaBPM_RequiresNew(javabpmurl, token,"NC65", paramMap);
					//记录日志
					LogVO log = new LogVO("DeleteBill", "out", ncbillid, JSONObject.toJSONString(paramMap), result, new UFDateTime(), new UFDateTime());
					util.recordLog_RequiresNew(log);
					
					JSONObject resultJson = JSONObject.parseObject(result);
					String responseCode = resultJson.getString("responseCode");
					if (!"100".equals(responseCode)) {
						Object messageList = resultJson.get("messageList");
						ExceptionUtils.wrappBusinessException("K2-BPM审批流作废失败(responseCode不等于100)："+ messageList);
					} else {
						if (!"Y".equals(resultJson.getString("ifSuccess"))) {
							Object messageList = resultJson.get("messageList");
							ExceptionUtils.wrappBusinessException("K2-BPM审批流作废失败(ifSuccess不等于Y)："+ messageList);
						}
					}
//					if (!"".equals(k2id)) {// 流程作废后更新NC里记录的BPM流程状态
//					}
					
					BaseDAO dao = new BaseDAO();
					WorkflowVO workflowVO = (WorkflowVO) dao.retrieveByPK(WorkflowVO.class, pk_workflow);
					if(workflowVO!=null){
						workflowVO.setK2approvestatus(BpmApproveStatus.DELETE);
						dao.updateVO(workflowVO);						
						dao.deleteByClause(WorkflownoteVO.class, "billid='"+ncbillid+"'");
					}
				}
			}
		} catch (Exception e) {
			ExceptionUtils.wrappBusinessException("单据删除时在BPM同步删除审批流发生异常:" + e.getMessage());
		}
	}
	/**
	 * 获取新版BPM接口token
	 * @param requestParams
	 * @return token
	 */
	@Override
	public String getTokenFromBPM_RequiresNew(){
		String result = "";
		String token = "";
		String tokenurl = "";
		try{
			tokenurl = ConfigUtils.getValueFromProperties("javabpmtokenurl");//获取token的url
//			RestTemplate rt = new RestTemplate();
			RestTemplate rt = getRestTemplateInstance();
			MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<String,String>();
			
			requestMap.add("username", "SYS_PLAN");
			requestMap.add("password", "123456");
			requestMap.add("grant_type","password");
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic azI6SzJwYXNzIQ==");
			HttpEntity requestEntity = new HttpEntity(requestMap,headers);
			
			result = rt.postForObject(tokenurl,requestEntity,String.class);
			
			if(result!=null && !"".equals(result)){
				JSONObject tokenJson = JSONObject.parseObject(result);
				token = tokenJson.getString("access_token");
			}
		}catch(Exception e){
			ExceptionUtils.wrappBusinessException("调用BPM接口获取token("+tokenurl+")发生异常："+e.getMessage());
		}
		return token;
	}
	
	private RestTemplate getRestTemplateInstance() {
		 RestTemplate restTemplate = new RestTemplate();
		 SimpleClientHttpRequestFactory requestFactory;
		 requestFactory = getUnsafeClientHttpRequestFactory();
//		 requestFactory.setConnectTimeout(5000);
//		 requestFactory.setReadTimeout(5000);
		 restTemplate.setRequestFactory(requestFactory);
		 return restTemplate;
	 }
	
	private SimpleClientHttpRequestFactory getUnsafeClientHttpRequestFactory() {
        TrustManager[] byPassTrustManagers = new TrustManager[]{new X509TrustManager() {

            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
			@Override
			public void checkClientTrusted(X509Certificate[] arg0, String arg1)
					throws CertificateException {
				
			}
			@Override
			public void checkServerTrusted(X509Certificate[] arg0, String arg1)
					throws CertificateException {
				
			}
        }};
        final SSLContext sslContext;
        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, byPassTrustManagers, new SecureRandom());
            sslContext.getSocketFactory();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new RuntimeException(e);
        }

        return new SimpleClientHttpRequestFactory() {
            @Override
            protected void prepareConnection(HttpURLConnection connection,
                                             String httpMethod) throws IOException {
                super.prepareConnection(connection, httpMethod);
                if (connection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) connection).setSSLSocketFactory(
                            sslContext.getSocketFactory());
                }
            }
        };
}
	
	/**
	 * 获取新版BPM接口token
	 * @param requestParams
	 * @return token
	 */
	@Override
	public String getTokenIDFromBPM_RequiresNew(){
		String tokenurl = "";
		String tokenid = "";
		String result = "";
		try{
			tokenurl = ConfigUtils.getValueFromProperties("javabpmtokenurl");//获取token的url
//			RestTemplate rt = new RestTemplate();
			RestTemplate rt = getRestTemplateInstance();
			MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<String,String>();
			
			requestMap.add("username", "SYS_PLAN");
			requestMap.add("password", "123456");
			requestMap.add("grant_type","password");
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic azI6SzJwYXNzIQ==");
			HttpEntity requestEntity = new HttpEntity(requestMap,headers);
			
			result = rt.postForObject(tokenurl,requestEntity,String.class);
			if(result!=null && !"".equals(result)){
				JSONObject tokenJson = JSONObject.parseObject(result);
				tokenid = tokenJson.getString("jti");
			}
		}catch(Exception e){
			ExceptionUtils.wrappBusinessException("调用BPM接口获取token("+tokenurl+")发生异常："+e.getMessage());
		}
		return tokenid;
	}
	
	/**
	 * 根据用户获取新版BPM接口token
	 * @param requestParams
	 * @return token
	 */
	@Override
	public String getTokenIDByUseridFromBPM_RequiresNew(){
		String tokenurl = "";
		String result = "";
		String tokenid = "";
		try{
			tokenurl = ConfigUtils.getValueFromProperties("javabpmtokenurl");//获取token的url
//			RestTemplate rt = new RestTemplate();
			RestTemplate rt = getRestTemplateInstance();
			MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<String,String>();
			
			Map<String,String> psnMap = getPsnInfoByUserid(InvocationInfoProxy.getInstance().getUserId());
			requestMap.add("username", psnMap==null?"":psnMap.get("code"));
			requestMap.add("password", "123456");
			requestMap.add("grant_type","password");
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic azI6SzJwYXNzIQ==");
			HttpEntity requestEntity = new HttpEntity(requestMap,headers);
			
			result = rt.postForObject(tokenurl,requestEntity,String.class);
			if(result!=null && !"".equals(result)){
				JSONObject tokenJson = JSONObject.parseObject(result);
				tokenid = tokenJson.getString("jti");
			}
		}catch(Exception e){
			ExceptionUtils.wrappBusinessException("调用BPM接口获取token("+tokenurl+")发生异常："+e.getMessage());
		}
		return tokenid;
	}
	/**
	 * 调用新版BPM接口
	 */
	public String doPostJavaBPM_RequiresNew(String url,String token,String sourceSys,Map<String,Object> requestParams){
		String result = "";
		try{
//			RestTemplate rt = new RestTemplate();
			RestTemplate rt = getRestTemplateInstance();
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer "+token);
			HttpEntity requestEntity = new HttpEntity(requestParams,headers);
			result = rt.postForObject(url,requestEntity,String.class);
		}catch(Exception e){
			ExceptionUtils.wrappBusinessException("调用BPM接口发生异常，接口地址："+url+",异常信息："+e.getMessage());
		}
		return result;
	}
	
	private void trustAllHosts() {
        // 创建不验证证书链的信任管理器 这里使用的是x509证书
        TrustManager[] trustAllCerts = new TrustManager[]{new MyX509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }
 
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }
 
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }
        }};
        // 安装所有信任的信任管理器
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            //HttpsURLConnection通过SSLSocket来建立与HTTPS的安全连接，SSLSocket对象是由SSLSocketFactory生成的。
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	/**
	 * 获取新版BPM审批单据审批页面地址
	 * @param token
	 * @param sourcesys来源系统
	 * @param billid单据逐渐
	 * @param k2id BPM流程id
	 * @param psncode人员编码
	 * @param formType表单类型：0-查看表单,1-审批表单,2-流程图查看
	 * @return 表单审批界面url
	 */
	@Override
	public String getBPMWorkflowurl_RequiresNew(String url,String token,String sourcesys,String ncbillid,String k2id,String psncode,int formType) {
		
		Map<String, Object> requestMap = new HashMap<String,Object>();
		Map<String,String> psnMap = getPsnInfoByUserid(InvocationInfoProxy.getInstance().getUserId());
		requestMap.put("employeeNo", psnMap==null?"":psnMap.get("code"));
		requestMap.put("k2ProcInstId", k2id);
		requestMap.put("formType",formType+"");
		
		StringBuffer sb = new StringBuffer("");
  		try {
  			trustAllHosts();
  			// 创建连接
  			URL urlobj = new URL(url);
  			HttpsURLConnection connection = (HttpsURLConnection) urlobj.openConnection();
  			connection.setHostnameVerifier(createInsecureHostnameVerifier());
  			connection.setDoOutput(true);
  			connection.setDoInput(true);
  			connection.setRequestMethod("POST");
  			connection.setUseCaches(false);
  			connection.setInstanceFollowRedirects(true);
  			connection.setRequestProperty("Content-Type", "application/json;");
  			connection.setRequestProperty("encoding", "UTF-8");
  			connection.setConnectTimeout(12000);
  			connection.setReadTimeout(12000);
  			connection.connect();
  			// POST请求
  			DataOutputStream out = new DataOutputStream(
  					connection.getOutputStream());
  			out.write(JSONObject.toJSONString(requestMap).getBytes("UTF-8"));
  			out.flush();
  			out.close();
  			// 读取响应
  			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
  			String lines;
  			while ((lines = reader.readLine()) != null) {
  				lines = new String(lines.getBytes());
  				sb.append(lines);
  			}
  			reader.close();
  			// 断开连接
  			connection.disconnect();
  		} catch (Exception e) {
  			Logger.error(e.getMessage());
  			ExceptionUtils.wrappBusinessException("调用BPM接口("+url+")发生异常："+e.getMessage());
  		} 
		
		String formurl = "";
		if(sb.length()>0){
			JSONObject json = JSONObject.parseObject(sb.toString());
			String responseCode = json.getString("responseCode");
			if("100".equals(responseCode)){
				formurl = json.getString("formUrl");
			}else{
				List list = (List<String>)json.get("messageList");
				ExceptionUtils.wrappBusinessException(""+list);
			}
		}
		return formurl;
	}
	
	/**
	 * 项目团队调用材料管理接口
	 * @param url
	 * @param param
	 * @return
	 */
	@Override
	public String getBPMWorkflowurl_RequiresNew(String url,String param) {
		
		StringBuffer sb = new StringBuffer("");
  		try {
  			trustAllHosts();
  			// 创建连接
  			URL urlobj = new URL(url);
  			HttpsURLConnection connection = (HttpsURLConnection) urlobj.openConnection();
  			connection.setHostnameVerifier(createInsecureHostnameVerifier());
  			connection.setDoOutput(true);
  			connection.setDoInput(true);
  			connection.setRequestMethod("POST");
  			connection.setUseCaches(false);
  			connection.setInstanceFollowRedirects(true);
  			connection.setRequestProperty("Content-Type", "application/json;");
  			connection.setRequestProperty("encoding", "UTF-8");
  			connection.setConnectTimeout(12000);
  			connection.setReadTimeout(12000);
  			connection.connect();
  			// POST请求
  			DataOutputStream out = new DataOutputStream(
  					connection.getOutputStream());
  			out.write(param.getBytes("UTF-8"));
  			out.flush();
  			out.close();
  			// 读取响应
  			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
  			String lines;
  			while ((lines = reader.readLine()) != null) {
  				lines = new String(lines.getBytes());
  				sb.append(lines);
  			}
  			reader.close();
  			// 断开连接
  			connection.disconnect();
  		} catch (Exception e) {
  			ExceptionUtils.wrappBusinessException(e.getMessage());
  		} 
		
		return sb.toString();
	}
	
	public HostnameVerifier createInsecureHostnameVerifier() {
	    return new HostnameVerifier() {
	        @Override
	        public boolean verify(String hostname, SSLSession session) {
	           return true;
	        }
	    };
	}
	
	@Override
	public void getApproveRecordFromNewBPM_RequiresNew(String pk_bill) {
		boolean enable = getDefDoc("001");
		if(!enable){
			return;
		}
		WorkflowVO workflowVO = getWorkflowVObyNCBillID("ncbillid",pk_bill);
		if(workflowVO==null){
			return;
		}
		String k2ID = workflowVO.getK2flowid();
		
		String url = ConfigUtils.getValueFromProperties("javabpmapproverecordurl")+"?sourceId=NC65&bizId="+pk_bill;
		Map<String,Object> requestParams = new HashMap<String,Object>();
		requestParams.put("k2ProcInstId", k2ID);

		String token = getTokenFromBPM_RequiresNew();
		String result = doPostJavaBPM_RequiresNew(url,token,"NC65",requestParams);
		
		JSONObject json = JSONObject.parseObject(result);
		String responseCode = json.getString("responseCode");
		List<BPMApproveRecordVO> historyList = new ArrayList<>();
		if("100".equals(responseCode)){
			JSONArray array = json.getJSONArray("processLogObjList");
			JSONArray array2 = json.getJSONArray("communicationList");//沟通及对应回复
			if(array.isEmpty()){return;}
			BPMApproveRecordVO recordVO = null;
			int index = 0;
			UFDateTime lastDealTime = null;
			for(int i=0;i<array.size();i++){
				JSONObject curRecordJson = array.getJSONObject(i);
				String finalAction = curRecordJson.getString("finalAction");
				if("PA_ReturnOriginator".equals(finalAction)|| "PA_ProcStart".equals(finalAction)||"reSubmit".equals(finalAction)){//驳回、提交、重新提交
					index = i;
					lastDealTime = new UFDateTime(curRecordJson.getString("taskStartDate"));
				}
			}
			for(int i=index+1;i<array.size();i++){
				JSONObject curRecordJson = array.getJSONObject(i);
				recordVO = new BPMApproveRecordVO();
				recordVO.setStatus(VOStatus.NEW);
				recordVO.setBillid(pk_bill);
				recordVO.setBillversionpk(pk_bill);
				recordVO.setCheckman(getPk_UserByPsncode(curRecordJson.getString("destEmployeeName")));
				recordVO.setChecknote(curRecordJson.getString("destMessage"));
				if(curRecordJson.getString("destDate")!=null){
					recordVO.setDealdate(new UFDateTime(curRecordJson.getString("destDate")));					
				}
				recordVO.setMessageNote(curRecordJson.getString("destMessage"));
				recordVO.setPk_billtype(workflowVO.getBilltype());
				if(curRecordJson.getString("taskStartDate")!=null){
					recordVO.setSenddate(new UFDateTime(curRecordJson.getString("taskStartDate")));					
				}else if(curRecordJson.getString("destDate")!=null){
					recordVO.setSenddate(new UFDateTime(curRecordJson.getString("destDate")));	
				}
				recordVO.setSenderman(getPk_UserByPsncode(curRecordJson.getString("destEmployeeName")));
				recordVO.setActionType("Z");
				String finalAction = curRecordJson.getString("finalAction");
				if("Accept".equals(finalAction)){//同意
					recordVO.setActionType("Z");
					recordVO.setApproveResult("Y");
					recordVO.setApproveStatus(1);
					recordVO.setIscheck("Y");
					recordVO.setTs(new UFDateTime(curRecordJson.getString("destDate")));
				}else if("PA_Redirect".equals(finalAction)){//转办
					recordVO.setActionType("Z");
					recordVO.setApproveResult("T");
					recordVO.setApproveStatus(4);
					recordVO.setIscheck("N");
					recordVO.setTs(new UFDateTime(curRecordJson.getString("destDate")));
				}else if("PA_ApprovalRecall".equals(finalAction)){//取消审批:NC中无对应状态，所以不记录
					continue;
				}else{
					recordVO.setActionType("Z");
					recordVO.setApproveResult("");
					recordVO.setApproveStatus(4);
					recordVO.setIscheck("N");
				}
				recordVO.setApproveStatus((finalAction==null || "".equals(finalAction))?0:1);
				historyList.add(recordVO);
			}
			//获取沟通、回复
			for(int i=0;array2!=null && i<array2.size();i++){
				JSONObject curRecordJson = array2.getJSONObject(i);
				JSONArray detailList = curRecordJson.getJSONArray("detailList");
				UFDateTime communicationDateTime = new UFDateTime(dealDateFormat(curRecordJson.get("communicationDate").toString()));
				if(lastDealTime!=null && lastDealTime.after(communicationDateTime)){
					continue;
				}
				recordVO = new BPMApproveRecordVO();
				recordVO.setStatus(VOStatus.NEW);
				recordVO.setBillid(pk_bill);
				recordVO.setBillversionpk(pk_bill);
				recordVO.setCheckman(getPk_UserByPsncode(curRecordJson.getString("launchEmpName")));
				recordVO.setChecknote(curRecordJson.getString("content"));
				if(curRecordJson.getString("communicationDate")!=null){
					recordVO.setDealdate(communicationDateTime);					
				}
				recordVO.setMessageNote(curRecordJson.getString("content"));
				recordVO.setPk_billtype(workflowVO.getBilltype());
				if(curRecordJson.getString("communicationDate")!=null){
					recordVO.setSenddate(communicationDateTime);					
				}
				recordVO.setSenderman(getPk_UserByPsncode(curRecordJson.getString("launchEmpName")));
				recordVO.setActionType("Z");
				recordVO.setApproveResult("A");
				recordVO.setApproveStatus(4);
				recordVO.setIscheck("N");
				
				historyList.add(recordVO);
				for(int j=0;detailList!=null && j<detailList.size();j++){					
					JSONObject detailJson = detailList.getJSONObject(j);
					String replyDate = detailJson.getString("replyDate");
					UFDateTime replyDateTime = replyDate==null?new UFDateTime():new UFDateTime(dealDateFormat(replyDate));
					recordVO = new BPMApproveRecordVO();
					recordVO.setStatus(VOStatus.NEW);
					recordVO.setBillid(pk_bill);
					recordVO.setBillversionpk(pk_bill);
					recordVO.setCheckman(getPk_UserByPsncode(detailJson.getString("receiveEmpName")));
					recordVO.setChecknote(detailJson.getString("content"));
					if(replyDate!=null){
						recordVO.setDealdate(replyDateTime);					
					}
					recordVO.setMessageNote(detailJson.getString("content"));
					recordVO.setPk_billtype(workflowVO.getBilltype());
					if(communicationDateTime!=null){
						recordVO.setSenddate(communicationDateTime);					
					}
					recordVO.setSenderman(getPk_UserByPsncode(detailJson.getString("receiveEmpName")));
					recordVO.setActionType("Z_A");
					recordVO.setApproveResult("B");
					recordVO.setApproveStatus(4);
					recordVO.setIscheck("Y");
					recordVO.setApproveStatus(4);
					historyList.add(recordVO);
				}
			}
		if(historyList!=null && historyList.size()>0){
			recordApprove_RequiresNew(historyList,pk_bill);			
		}
		//3、记录日志开始-----------------------------------------------
		LogVO log = new LogVO("GetApproveHistory", "out",pk_bill, result, result, new UFDateTime(), new UFDateTime());
		recordLog_RequiresNew(log);
		}
	}
	@Override
	public String changeBillStatusSubmit2Approving(Object obj) {
		BaseDAO bsdao = new BaseDAO(InvocationInfoProxy.getInstance().getUserDataSource());
		boolean enable = getDefDoc("000");
		if(!enable){
			return "E";
		}
		String updateSql = "";
		String ncbillid = null;
		String res = "E";
		try {
			ncbillid = ((AggregatedValueObject)obj).getParentVO().getPrimaryKey();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if(obj instanceof nc.vo.fdcpmbm.bmedit.AggBmEditVO){//目标成本编制
			updateSql = "update fdcpm_bm_edit set fstatusflag=2 where pk_edit='"+ncbillid+"'";
		}else if(obj instanceof AggRPContPlanVO){//项目合约规划编制
			updateSql = "update fdcpm_rp_contplan set fstatusflag=2 where pk_contplan='"+ncbillid+"'";
		}else if(obj instanceof AggCoContractVO){//合同录入
			updateSql = "update fdcpm_co_cont set fstatusflag=2 where pk_cont='"+ncbillid+"'";
		}else if(obj instanceof AggCoContractReviseVO){//合同修订
			updateSql = "update fdcpm_co_contrevise set fstatusflag=2 where pk_contrevise='"+ncbillid+"'";
		}else if(obj instanceof AggConocontVO){//无合同费用单
			updateSql = "update fdcpm_co_nocont set fstatusflag=2 where pk_nocont='"+ncbillid+"'";
		}else if(obj instanceof AggProdApprVO){//产值核定
			updateSql = "update fdcpm_cs_prodappr set fstatusflag=2 where pk_prodappr='"+ncbillid+"'";
		}else if(obj instanceof nc.vo.fdcpmcs.rewardde.AggRewarddeVO){//奖励扣款单
			updateSql = "update fdcpm_cs_rewardde set fstatusflag=2 where pk_rewardde='"+ncbillid+"'";
		}else if(obj instanceof AggMateMeteVO){//材料进场
			updateSql = "update fdcpm_cs_mate set fstatusflag=2 where pk_metecheck='"+ncbillid+"'";
		}else if(obj instanceof AggContAlterVO){//H164变更报告、H165变更签证
			updateSql = "update fdcpm_cs_contalter set fstatusflag=2 where pk_contalter='"+ncbillid+"'";
		}else if(obj instanceof nc.vo.fdcpmsm.settle.AggContSettleVO){//合同结算
			updateSql = "update fdcpm_sm_settle set fstatusflag=2 where pk_settle='"+ncbillid+"'";
		}else if(obj instanceof AggZBVO){//质保到期审批单
			updateSql = "update fdcpmco_cust_zb set fstatusflag=2 where pk_zb='"+ncbillid+"'";
		}else if(obj instanceof nc.vo.fdcpmfp.summary.org.AggFPOrgSummaryVO){//项目月度付款计划汇总-组织
			updateSql = "update fdcpm_fp_orgsum set fstatusflag=2 where pk_orgsum='"+ncbillid+"'";
		}else if(obj instanceof AggFPAllocationVO){//项目月度付款计划分配
			updateSql = "update fdcpm_fp_allocation set fstatusflag=2 where pk_allocation='"+ncbillid+"'";
		}else if(obj instanceof AggFPTemporaryVO){//项目月度临时付款计划
			updateSql = "update fdcpm_fp_temporary set fstatusflag=2 where pk_temporary='"+ncbillid+"'";
		}else if(obj instanceof AggPayApplyVO){//付款申请
			updateSql = "update fdcpm_pay_apply set fstatusflag=2 where pk_apply='"+ncbillid+"'";
		}else if(obj instanceof AggCostAccumVO){//成本单据
			updateSql = "update fdcpm_cost_accum set fstatusflag=2 where pk_accum='"+ncbillid+"'";
		}else if(obj instanceof AggHtmblcVO){//合同模板设置
			
		}else if(obj instanceof AggDiscountPlanVO){//折扣方案
			//updateSql = "update fdcpr_hx_discountplan set fstatusflag=2 where pk_discountplan='"+ncbillid+"'";
		}else if(obj instanceof AggRefundVO){//退款申请
			//updateSql = "update fdcpr_hx_refund set fstatusflag=2 where pk_refund='"+ncbillid+"'";
		}
//		else if(obj instanceof nc.vo.fdcprhx.fdcpr_hx_busiapply.AggHeadBusiTransVO){//开票申请
//			updateSql = "update fdcpr_hx_busiapply set fstatusflag=2 where pk_busitrans='"+ncbillid+"'";
//		}else if(obj instanceof nc.vo.fdcprhx.fdcpr_hx_busichange.AggHeadBusiChangeVO){//发票变更申请
//			updateSql = "update fdcpr_hx_busichange set fstatusflag=2 where pk_busitrans='"+ncbillid+"'";
//		}
		else if(obj instanceof JKBXVO || obj instanceof JKVO){//报销、还款、借款
			String tradecode = ((JKBXVO)obj).getParentVO().getDjlxbm();
			if("2632".equals(tradecode)){//借款单
				updateSql = "update er_jkzb set spzt=2 where pk_jkbx='"+ncbillid+"'";
			}else{
				updateSql = "update er_bxzb set spzt=2 where pk_jkbx='"+ncbillid+"'";				
			}
		}else if(obj instanceof AggMatterAppVO){//费用申请
			updateSql = "update er_mtapp_bill set apprstatus =2 where pk_mtapp_bill='"+ncbillid+"'";
		}else{
			updateSql = "";
		}
		if(!"".equals(updateSql)){
			try {
				bsdao.executeUpdate(updateSql);
				res = "S";
			} catch (DAOException e) {
				ExceptionUtils.wrappBusinessException("单据状态由提交态改为审批进行中发生异常："+e.getMessage());
			}			
		}
		return res;
	}	
	
	public String dealDateFormat(String oldDateStr){
		
		try{
			oldDateStr = oldDateStr.replace("+0000", "+00:00");
			if(!oldDateStr.contains(".")){
				oldDateStr = oldDateStr.replace("+",".00+");				
			}
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");  //yyyy-MM-dd'T'HH:mm:ss.SSSZ
			SimpleDateFormat df1 = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
			Date  date = df.parse(oldDateStr);
			Date date1 =  df1.parse(date.toString());
			DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df2.format(date1);			
		}catch(Exception e){
			return null;
		}
    }
	/**
	 * 查询单据上游单据在BPM审批的表单url
	 * @param id当前单据主键
	 * @param billtypecode当前单据类型编码
	 * @return
	 */
	public String getNCBillApproveBPMFormUrl(String id, String billtypecode) {
		String sourceid = "";
		String viewurl = "";
		String bpmtokenid = "";
		
		LightBillVO vo = new LightBillVO();
		vo.setID(id);
		vo.setType(billtypecode);
		DefaultBillFlowFactory factory = new DefaultBillFlowFactory();
		IBillDataFinder dataFinder = new DefaultDataFinder();
		LightBillVO[] vos = dataFinder.getSourceBills(vo.getType(), vo.getID());		
		if (vos!=null && vos.length>0) {
			sourceid = vos[0].getID();
			viewurl = getBPMApproveUrlbyPK(sourceid);
		}
		return viewurl;
	}
	
	public String getBPMApproveUrlbyPK(String sourceid){
		String viewurl = "";
		String bpmtokenid = "";
		IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		Object[] objs = null;
		try {
			objs = (Object[]) query.executeQuery("select viewurl,k2formid from hx_bpm_workflow where ncbillid ='" + sourceid + "'", new ArrayProcessor());
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (objs != null && objs.length > 0) {
			if ("".equals(viewurl)) {// 新版BPM流程发起时无法返回流程表单查看链接，所有在联查审批意见时实时调用BPM接口查询审批表单url，所有数据库中原来的viewurl为空
				// 获取新版BPM审批流程图url
				ICommonUtils util = NCLocator.getInstance().lookup(ICommonUtils.class);
				bpmtokenid = util.getTokenIDByUseridFromBPM_RequiresNew();// 获取接口tokenid
				String getworkflowurl = ConfigUtils.getValueFromProperties("javabpmapprovepageurl") + "?sourceId=NC65&bizId=" + sourceid;// 获取链接
				viewurl = util.getBPMWorkflowurl_RequiresNew(getworkflowurl, bpmtokenid, "NC65", sourceid, objs[1].toString(), "", 0);
			}
		}
		return viewurl;
	}
	
	@Override
	public String projTeam2Xinrui_RequiresNew(CoContractVO hvo){

	  	 Map<String,String> conttypeMap = getAllContType();
	  	 //获取字段
		 String pk_conttype = hvo.getPk_conttype();
		 String conttypecode = conttypeMap.get(pk_conttype);
		 //判断是否为空
		 if(StringUtils.isEmpty(conttypecode)){
			 return "";
		 }
		 //获取bd_Supplier表
		 Map<String, String> supplierMap = getSupplier(hvo.getPk_second());
		 //获取contractType
		 String contractType = null;
		 if(("0101").equals(conttypecode) || ("0102").equals(conttypecode) || ("0103").equals(conttypecode)){
			 contractType = "工程合同";
		 } else if(("0201").equals(conttypecode) || ("0202").equals(conttypecode)){
			 contractType = "材料合同";
		 } else if(("0304").equals(conttypecode)){
			 contractType = "监理合同";
		 } else if(("0305").equals(conttypecode)){
			 contractType = "造价咨询合同";
		 }else{
			 return null;
		 }
		 //获取stagesCode
		 Map<String, String> stamap = getcbs(hvo.getPk_project());
		 //调用接口所需要的值
		 Map<String,String> paramMap = new HashMap<>();
		 paramMap.put("taxpayerId", supplierMap.get("taxpayerid"));
		 paramMap.put("supplierName", supplierMap.get("name"));
		 paramMap.put("stagesCode", stamap.get("def1"));
		 paramMap.put("contractType", contractType);
		 
//		 //推第三方系统
//		 JSONObject resJson = null;
//		 ProjectTeamVO teamVO = null;
//		 try{
//			 String result = getBPMWorkflowurl_RequiresNew(ConfigUtils.getValueFromProperties("zksupurl"),JSONObject.toJSONString(paramMap));
//			 if(result==null){//1、推送异常1：接口返回为空
//				 teamVO = new ProjectTeamVO(hvo.getPk_cont(),supplierMap.get("taxpayerid"),supplierMap.get("name"),stamap.get("def1"),contractType,new UFDateTime(),"材料管理返回为空");
//			 }else{
//				 resJson = JSONObject.parseObject(result);
//				 if((!"200".equals(resJson.getString("code")) || !resJson.getBooleanValue("success"))){//2、推送异常2：返回状态码为失败
//					 teamVO = new ProjectTeamVO(hvo.getPk_cont(),supplierMap.get("taxpayerid"),supplierMap.get("name"),stamap.get("def1"),contractType,new UFDateTime(),resJson.getString("message"));
//				 }			 
//			 }
//		 }catch(Exception ex){//3、推送异常3：调用接口抛出异常
//			 teamVO = new ProjectTeamVO(hvo.getPk_cont(),supplierMap.get("taxpayerid"),supplierMap.get("name"),stamap.get("def1"),contractType,new UFDateTime(),"调用项目团队推送接口发生异常："+ex.getMessage());
//		 }
//		 if(teamVO!=null){
//			 ILogUtils logUtils = NCLocator.getInstance().lookup(ILogUtils.class);
//			 logUtils.Write_RequiresNew(teamVO);
//		 }
		 return null;
	}
	
	//查询fdcpm_bd_conttype表
	  public Map<String,String> getAllContType(){
		   Map<String,String> resMap = new HashMap<>();
		   IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		   String sql = "select pk_conttype,code from fdcpm_bd_conttype where enablestate=2 and dr=0 and code in('0101','0102','0103','0201','0202','0304','0305')";
		   try {
				List<Map<String,String>> list = (List<Map<String, String>>) query.executeQuery(sql,new MapListProcessor());
				for(Map<String,String> map:list){
					resMap.put(map.get("pk_conttype"), map.get("code"));
				}
		   } catch (BusinessException e) {
				ExceptionUtils.wrappBusinessException("查询合同类型发生异常："+e.getMessage());
		   }
		   
		   return resMap;
		   
	  }

	  //查询bd_Supplier表
	  public Map<String, String> getSupplier(String supplier){
		   Map<String,String> resMap = new HashMap<>();
		   IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		   String sql = "select name,taxpayerid,creator,code,pk_supplier from bd_supplier where pk_supplier ='" + supplier +"'";
		   Map<String, String> map = null;
		   try {
				map = (Map<String, String>) query.executeQuery(sql,new MapProcessor());
				
		   } catch (BusinessException e) {
				ExceptionUtils.wrappBusinessException("查询供应商表发生异常："+e.getMessage());
		   }
		   return map;
		   
	  }
	  
	  //查询fdcpm_bd_cbs表
	  public Map<String, String> getcbs(String project){
		   Map<String,String> resMap = new HashMap<>();
		   IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		   String sql = "select b.project_code,b.project_name,b.def1 from fdcpm_bd_cbs a inner join bd_project b on a.pk_project_level = b.pk_project where pk_cbs='" + project +"'";
		   Map<String, String> map = null;
		   try {
				map = (Map<String, String>) query.executeQuery(sql,new MapProcessor());
				
		   } catch (BusinessException e) {
				ExceptionUtils.wrappBusinessException("查询主数据项目编码表发生异常："+e.getMessage());
		   }
		   return map;
		   
	 }
	  
	@Override
	public Object InsertORModify_RequiresNew(String pk_cont) {
//		// TODO Auto-generated method stub
//		List<ErrorTableVO> listvo =null;
//		try {
//		    listvo = (List<ErrorTableVO>)new BaseDAO().executeQuery("select pk_cont,counts from error_table where pk_cont = '"+pk_cont+"'",new BeanListProcessor(ErrorTableVO.class));
//		} catch(BusinessException e) {
//		   e.printStackTrace();
//		}
//		//保存
//		String result = null;
//		BaseDAO dao=new BaseDAO();
//		ErrorTableVO errorTable = new ErrorTableVO();
//		errorTable.setPk_cont(pk_cont);
//		errorTable.setCounts(1);
//		errorTable.setResults("待");
//		try {
////			result = dao.insertObject(errorTable, null);
//			result = dao.insertVO(errorTable);
//		} catch (DAOException e) {
//				e.printStackTrace();
//		}
		return null;
	}
	/**
	 * 请求内容类型为application/x-www-form-urlencoded
	 * @param url
	 * @param param
	 * @return
	 */
	@Override
	public String doPostNew_RequiresNew(String url,String param) {
		
//		Map<String, Object> requestMap = new HashMap<String,Object>();
		
		StringBuffer sb = new StringBuffer("");
  		try {
  			trustAllHosts();
  			// 创建连接
  			URL urlobj = new URL(url);
  			HttpsURLConnection connection = (HttpsURLConnection) urlobj.openConnection();
  			connection.setHostnameVerifier(createInsecureHostnameVerifier());
  			connection.setDoOutput(true);
  			connection.setDoInput(true);
  			connection.setRequestMethod("POST");
  			connection.setUseCaches(false);
  			connection.setInstanceFollowRedirects(true);
  			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
  			connection.setRequestProperty("encoding", "UTF-8");
  			connection.setConnectTimeout(12000);
  			connection.setReadTimeout(12000);
  			connection.connect();
  			// POST请求
  			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
  			out.write(param.getBytes("UTF-8"));
  			out.flush();
  			out.close();
  			// 读取响应
  			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
  			String lines;
  			while ((lines = reader.readLine()) != null) {
  				lines = new String(lines.getBytes());
  				sb.append(lines);
  			}
  			reader.close();
  			// 断开连接
  			connection.disconnect();
  		} catch (Exception e) {
  			Logger.error(e.getMessage());
  			ExceptionUtils.wrappBusinessException("调用中控接口发生异常："+e.getMessage());
  		} 
		
		
		return sb.toString();
	}
	
	/**
	 * 调用消息中心https接口
	 */
	@Override
	public List<Object> doPostMsgCenter_RequiresNew(String urlStr, String param) {
		StringBuffer sb = new StringBuffer("");
		boolean success = false;
		InterfaceLogVO log = null;
		TransFailMsgVO msgvo = null;
		List<Object> resultList = new ArrayList<Object>();
		String error = "";
		try {
			// 创建连接
			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/json;");
			connection.setRequestProperty("encoding", "UTF-8");
			connection.setConnectTimeout(5000);
			connection.connect();
			// POST请求
			DataOutputStream out = new DataOutputStream(
					connection.getOutputStream());
			out.write(param.getBytes("UTF-8"));
			out.flush();
			out.close();
			// 读取响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
			String lines;
			while ((lines = reader.readLine()) != null) {
				lines = new String(lines.getBytes());
				sb.append(lines);
			}
			reader.close();
			// 断开连接
			connection.disconnect();
			
			JSONObject json = JSONObject.parseObject(sb.toString());
			
			String status = json.getString("code");
			
			if("200".equals(status)){
				success = json.getBooleanValue("success");
				if(!success){
					error = json.getString("message");
				}
			}else{
				error = json.getString("message");
			}
		} catch (Exception e) {
			error = e.getMessage();
			success = false;
		} 
		if(!success){//推送失败
			JSONObject temp = JSONObject.parseObject(param);
			msgvo = new TransFailMsgVO();
			msgvo.setPk_checkflow(temp.getString("bizId"));
			msgvo.setSuccess(UFBoolean.FALSE);
			msgvo.setRequestUrl(urlStr);
			msgvo.setRequestCount(0);
			msgvo.setStatus(VOStatus.NEW);
			msgvo.setTs(new UFDateTime());
			msgvo.setDef1(error);
			resultList.add(msgvo);
		}		
		log = new InterfaceLogVO("中控平台","待办消息",param,sb.toString(),new UFDateTime(),new UFDateTime());
		resultList.add(log);
		return resultList;
	}

}
