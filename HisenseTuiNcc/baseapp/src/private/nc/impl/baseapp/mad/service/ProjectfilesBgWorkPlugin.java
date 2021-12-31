package nc.impl.baseapp.mad.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.bs.dao.BaseDAO;
import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.framework.common.NCLocator;
import nc.bs.pub.pa.PreAlertObject;
import nc.bs.pub.taskcenter.BgWorkingContext;
import nc.bs.pub.taskcenter.IBackgroundWorkPlugin;
import nc.itf.pmpub.prv.IProject;
import nc.itf.uap.IUAPQueryBS;
import nc.vo.bc.pmpub.project.ProjectHeadVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.VOStatus;
import nc.vo.pub.lang.UFDate;
import nc.vo.pub.lang.UFDateTime;

import com.mysql.jdbc.Statement;

public class ProjectfilesBgWorkPlugin implements IBackgroundWorkPlugin{
	//项目
	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BusinessException {
		// 获取市政数据库里的值
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";//JDBC驱动名
        String JDBC_URL = "jdbc:mysql://27.223.81.110:40085/ejc-market?characterEncoding=utf-8";
        String USER = "root";
        String PASS = "17Liancloud";
        //通过DriverManager类获得该连接对象才能访问数据库
        Connection conn = null;
        Statement statement = null;// 通过Connection获得该结果对象用于执行静态的SQL语句   
        try {
        	  Class.forName(JDBC_DRIVER);//注册JDBC驱动
//            数据库的连接：通过DriverManager类的getConnection方法，传入三个参数：数据库URL、用户名、用户密码，实例化connection对象
            conn = DriverManager.getConnection(JDBC_URL,USER,PASS);
//            实例化statement对象
            statement = (Statement) conn.createStatement();           
//            定义数据库查询语句：查询表中列数据
            String sql = "select * from ejc_market_project  where create_time BETWEEN '2021-07-13' AND '2021-07-14'";
            ResultSet rset = statement.executeQuery(sql);// 执行查询语句            
//            展开查询到的数据
           // Map<String ,Object> map=new HashMap<String, Object>();
            List<Map<String ,Object>> list = new ArrayList<>();
            Map<String, Object> map = null;
        	while(rset.next()){
        		map=new HashMap<String, Object>();
        		map.put("id",rset.getString("id"));//id主键
        		map.put("create_time",rset.getString("create_time"));//创建时间
        		map.put("create_time",rset.getString("create_time"));//修改者账号
        		map.put("update_time",rset.getString("update_time"));//修改时间
        		map.put("code",rset.getString("code"));//项目编码
        		map.put("name",rset.getString("name"));//项目名称
        		map.put("org_id",rset.getString("org_id"));//所属组织
        		map.put("status",rset.getString("status"));//项目状态  1-未开工, 2-在建，3-完成    
        		map.put("type",rset.getString("type"));//项目类型：1-自营，2-联营                              
        		map.put("funds_source",rset.getString("funds_source"));//资金来源
        		map.put("cost_total",rset.getString("cost_total"));//总造价
        		map.put("bidding_from",rset.getString("bidding_from"));//招标形式
        		map.put("planned_commencement_date",rset.getString("planned_commencement_date"));//计划开工日期
        		map.put("planned_finish_date", rset.getString("planned_finish_date"));//计划结束日期
        		map.put("structure_type", rset.getString("structure_type"));//结构类型
        		map.put("engineering_purpose", rset.getString("engineering_purpose"));//
        		map.put("project_overview", rset.getString("project_overview"));//工程概况
        		map.put("project_department_id",rset.getString("project_department_id"));//项目id
        		map.put("valid_status",rset.getString("valid_status"));//项目状态：0-启用，1-停用                              
        		map.put("org_name",rset.getString("org_name"));//所属组织名称
        		map.put("contractor_unit_name",rset.getString("contractor_unit_name"));//承包单位名字 
        		map.put("pub_unit_name",rset.getString("pub_unit_name"));//发包单位名称 
        		map.put("create_user_name",rset.getString("create_user_name"));//创建人名称
        		map.put("version",rset.getString("version"));//版本锁
        		map.put("sign_date",rset.getString("sign_date"));//项目签订日期
        		map.put("engineering_type",rset.getString("engineering_type"));//项目工程类型
        		map.put("material_verification",rset.getString("material_verification"));//是否使用材料核销
        		map.put("focus_type",rset.getString("focus_type"));//关注类型 0-普通项目 1-工程局重点关注 2-工程局重点监控
        		map.put("area_id",rset.getString("area_id"));//区域id
        		map.put("area_code",rset.getString("area_code"));//区域编码
        		map.put("area_name",rset.getString("area_name"));//区域名称
        		map.put("measurement_certificate",rset.getString("measurement_certificate"));//是否有计量证书(0. 否 1. 是)
        		map.put("main_org_id",rset.getString("main_org_id"));//开票主体
        		map.put("main_org_name",rset.getString("main_org_name"));//开票主体名称
        		map.put("tax_way",rset.getString("tax_way"));//计税方式(0-一般计税 1-简易计税)                       
            	//map.put("",rset.getString(""));
            	list.add(map);
        	}
			//依次关闭对象
        	rset.close();
        	statement.close();
        	conn.close();
        	
        	Map<String, Object> map1 = null;
        	
	        for (int i = 0; list!=null && i < list.size(); i++) {
				//用取到的值给VO赋值
	           	map1= list.get(i);      	
	           	ProjectHeadVO projectvo = null;//ProjectHeadVO projectHeadVO = null;
	           //	IOrgManagerService  manager = NCLocator.getInstance().lookup(IOrgManagerService.class);
			    IUAPQueryBS query = NCLocator.getInstance().lookup(IUAPQueryBS.class);
            	@SuppressWarnings("unchecked")
				List<ProjectHeadVO> list2 = (List<ProjectHeadVO>) query.retrieveByClause(ProjectHeadVO.class, "nvl(dr,0)=0  and def20='"+map1.get("id")+"'");
	           
            	if(list2!=null && list2.size()>0){
	           		projectvo = list2.get(0);
	           	}
	           	//String operate = "";
            	nc.vo.pmpub.project.ProjectHeadVO projectHeadVO = null;
        		IProject service = NCLocator.getInstance().lookup(IProject.class);
            	if(projectvo == null ){	            	
            		projectHeadVO = new nc.vo.pmpub.project.ProjectHeadVO();
            		projectHeadVO.setCreationtime(new UFDateTime());//创建时间
            		projectHeadVO.setCreator((String) map1.get("creator"));//创建人
            		projectHeadVO.setProject_code((String) map1.get("project_code"));//项目编码
            		projectHeadVO.setProject_name((String) map1.get("project_name"));//项目名称
            		projectHeadVO.setCreationstate((String) map1.get("creationstate"));//项目状态
            		projectHeadVO.setPk_projectclass("1001A11000000000592R");//项目类型
            		projectHeadVO.setPlan_start_date(new UFDate());//计划开始日期
	            	projectHeadVO.setPk_projectstate((String) map1.get("pk_projectstate"));//状态
	            	projectHeadVO.setEnablestate(2);//启用状态  默认已启用
	            	projectHeadVO.setPk_group("0001A110000000000BTY");//集团(String) map.get("pk_group")
	            	projectHeadVO.setProject_name((String) map1.get("project_name"));//项目名称
	            	projectHeadVO.setPk_eps("1001A11000000000592W");//EPS 企业项目结构
	            	projectHeadVO.setPk_parentpro((String) map1.get("pk_parentpro"));//父项目
	            	projectHeadVO.setPk_org("0001A110000000002XYQ");//组织
	            	projectHeadVO.setDef20((String) map1.get("id"));
	            	projectHeadVO.setStatus(VOStatus.NEW);
//	            	aggs = new ProjectBillVO();
//					aggs.setChildren(ProjectBodyVO.class, new ProjectBodyVO[] {projectBodyVO, projectBodyVO1, projectBodyVO2 });
//					aggs.setParentVO(projectHeadVO);
		    			try {
		    				InvocationInfoProxy.getInstance().setUserId("00011A10000000003ALB");// 创建人
		    				nc.vo.pmpub.project.ProjectHeadVO newAggVO = service.insertProject(projectHeadVO);
		    				System.out.println(newAggVO);
						} catch (Exception e) {
							e.printStackTrace();
						}
	            	}else{
	            		//operate = "update";
	            		projectvo.setModifier((String) map.get("modifier"));//最后修改人
	            		projectvo.setModifiedtime(new UFDateTime());//修改最后时间
	            		projectvo.setPlan_finish_date(new UFDate());//计划结束日期
	            		projectvo.setProject_code((String) map1.get("project_code"));//项目编码
	            		projectvo.setProject_name((String) map1.get("project_name"));//项目名称
	            		projectvo.setCreationstate((String) map1.get("creationstate"));//项目状态
	            		projectvo.setDef20((String) map1.get("id"));//市政主键
	            		projectvo.setProject_name((String) map1.get("project_name"));//项目名称
	            		projectvo.setPk_parentpro((String) map1.get("pk_parentpro"));//父项目
	            		projectvo.setPk_projectstate((String) map1.get("pk_projectstate"));//状态
	            		projectvo.setPk_projectclass((String) map1.get("pk_projectclass"));//项目类型
	            		projectvo.setProject_code((String) map1.get("project_code"));//项目编码
	            		projectvo.setProject_name((String) map1.get("project_name"));//项目名称
	            		projectvo.setStatus(VOStatus.UPDATED);
	            		try {
	            			BaseDAO dao = new BaseDAO();
	            			dao.updateVO(projectvo);
						} catch (Exception e) {
							e.printStackTrace();
						}	
	            	}
				}
            } catch (ClassNotFoundException e) {
            		e.printStackTrace();  
		} catch (SQLException e) {
			 e.printStackTrace();
		}

		return null;
	}

}

