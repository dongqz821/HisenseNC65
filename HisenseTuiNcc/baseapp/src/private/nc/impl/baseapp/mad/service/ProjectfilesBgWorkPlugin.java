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
	//��Ŀ
	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BusinessException {
		// ��ȡ�������ݿ����ֵ
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";//JDBC������
        String JDBC_URL = "jdbc:mysql://27.223.81.110:40085/ejc-market?characterEncoding=utf-8";
        String USER = "root";
        String PASS = "17Liancloud";
        //ͨ��DriverManager���ø����Ӷ�����ܷ������ݿ�
        Connection conn = null;
        Statement statement = null;// ͨ��Connection��øý����������ִ�о�̬��SQL���   
        try {
        	  Class.forName(JDBC_DRIVER);//ע��JDBC����
//            ���ݿ�����ӣ�ͨ��DriverManager���getConnection�����������������������ݿ�URL���û������û����룬ʵ����connection����
            conn = DriverManager.getConnection(JDBC_URL,USER,PASS);
//            ʵ����statement����
            statement = (Statement) conn.createStatement();           
//            �������ݿ��ѯ��䣺��ѯ����������
            String sql = "select * from ejc_market_project  where create_time BETWEEN '2021-07-13' AND '2021-07-14'";
            ResultSet rset = statement.executeQuery(sql);// ִ�в�ѯ���            
//            չ����ѯ��������
           // Map<String ,Object> map=new HashMap<String, Object>();
            List<Map<String ,Object>> list = new ArrayList<>();
            Map<String, Object> map = null;
        	while(rset.next()){
        		map=new HashMap<String, Object>();
        		map.put("id",rset.getString("id"));//id����
        		map.put("create_time",rset.getString("create_time"));//����ʱ��
        		map.put("create_time",rset.getString("create_time"));//�޸����˺�
        		map.put("update_time",rset.getString("update_time"));//�޸�ʱ��
        		map.put("code",rset.getString("code"));//��Ŀ����
        		map.put("name",rset.getString("name"));//��Ŀ����
        		map.put("org_id",rset.getString("org_id"));//������֯
        		map.put("status",rset.getString("status"));//��Ŀ״̬  1-δ����, 2-�ڽ���3-���    
        		map.put("type",rset.getString("type"));//��Ŀ���ͣ�1-��Ӫ��2-��Ӫ                              
        		map.put("funds_source",rset.getString("funds_source"));//�ʽ���Դ
        		map.put("cost_total",rset.getString("cost_total"));//�����
        		map.put("bidding_from",rset.getString("bidding_from"));//�б���ʽ
        		map.put("planned_commencement_date",rset.getString("planned_commencement_date"));//�ƻ���������
        		map.put("planned_finish_date", rset.getString("planned_finish_date"));//�ƻ���������
        		map.put("structure_type", rset.getString("structure_type"));//�ṹ����
        		map.put("engineering_purpose", rset.getString("engineering_purpose"));//
        		map.put("project_overview", rset.getString("project_overview"));//���̸ſ�
        		map.put("project_department_id",rset.getString("project_department_id"));//��Ŀid
        		map.put("valid_status",rset.getString("valid_status"));//��Ŀ״̬��0-���ã�1-ͣ��                              
        		map.put("org_name",rset.getString("org_name"));//������֯����
        		map.put("contractor_unit_name",rset.getString("contractor_unit_name"));//�а���λ���� 
        		map.put("pub_unit_name",rset.getString("pub_unit_name"));//������λ���� 
        		map.put("create_user_name",rset.getString("create_user_name"));//����������
        		map.put("version",rset.getString("version"));//�汾��
        		map.put("sign_date",rset.getString("sign_date"));//��Ŀǩ������
        		map.put("engineering_type",rset.getString("engineering_type"));//��Ŀ��������
        		map.put("material_verification",rset.getString("material_verification"));//�Ƿ�ʹ�ò��Ϻ���
        		map.put("focus_type",rset.getString("focus_type"));//��ע���� 0-��ͨ��Ŀ 1-���̾��ص��ע 2-���̾��ص���
        		map.put("area_id",rset.getString("area_id"));//����id
        		map.put("area_code",rset.getString("area_code"));//�������
        		map.put("area_name",rset.getString("area_name"));//��������
        		map.put("measurement_certificate",rset.getString("measurement_certificate"));//�Ƿ��м���֤��(0. �� 1. ��)
        		map.put("main_org_id",rset.getString("main_org_id"));//��Ʊ����
        		map.put("main_org_name",rset.getString("main_org_name"));//��Ʊ��������
        		map.put("tax_way",rset.getString("tax_way"));//��˰��ʽ(0-һ���˰ 1-���׼�˰)                       
            	//map.put("",rset.getString(""));
            	list.add(map);
        	}
			//���ιرն���
        	rset.close();
        	statement.close();
        	conn.close();
        	
        	Map<String, Object> map1 = null;
        	
	        for (int i = 0; list!=null && i < list.size(); i++) {
				//��ȡ����ֵ��VO��ֵ
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
            		projectHeadVO.setCreationtime(new UFDateTime());//����ʱ��
            		projectHeadVO.setCreator((String) map1.get("creator"));//������
            		projectHeadVO.setProject_code((String) map1.get("project_code"));//��Ŀ����
            		projectHeadVO.setProject_name((String) map1.get("project_name"));//��Ŀ����
            		projectHeadVO.setCreationstate((String) map1.get("creationstate"));//��Ŀ״̬
            		projectHeadVO.setPk_projectclass("1001A11000000000592R");//��Ŀ����
            		projectHeadVO.setPlan_start_date(new UFDate());//�ƻ���ʼ����
	            	projectHeadVO.setPk_projectstate((String) map1.get("pk_projectstate"));//״̬
	            	projectHeadVO.setEnablestate(2);//����״̬  Ĭ��������
	            	projectHeadVO.setPk_group("0001A110000000000BTY");//����(String) map.get("pk_group")
	            	projectHeadVO.setProject_name((String) map1.get("project_name"));//��Ŀ����
	            	projectHeadVO.setPk_eps("1001A11000000000592W");//EPS ��ҵ��Ŀ�ṹ
	            	projectHeadVO.setPk_parentpro((String) map1.get("pk_parentpro"));//����Ŀ
	            	projectHeadVO.setPk_org("0001A110000000002XYQ");//��֯
	            	projectHeadVO.setDef20((String) map1.get("id"));
	            	projectHeadVO.setStatus(VOStatus.NEW);
//	            	aggs = new ProjectBillVO();
//					aggs.setChildren(ProjectBodyVO.class, new ProjectBodyVO[] {projectBodyVO, projectBodyVO1, projectBodyVO2 });
//					aggs.setParentVO(projectHeadVO);
		    			try {
		    				InvocationInfoProxy.getInstance().setUserId("00011A10000000003ALB");// ������
		    				nc.vo.pmpub.project.ProjectHeadVO newAggVO = service.insertProject(projectHeadVO);
		    				System.out.println(newAggVO);
						} catch (Exception e) {
							e.printStackTrace();
						}
	            	}else{
	            		//operate = "update";
	            		projectvo.setModifier((String) map.get("modifier"));//����޸���
	            		projectvo.setModifiedtime(new UFDateTime());//�޸����ʱ��
	            		projectvo.setPlan_finish_date(new UFDate());//�ƻ���������
	            		projectvo.setProject_code((String) map1.get("project_code"));//��Ŀ����
	            		projectvo.setProject_name((String) map1.get("project_name"));//��Ŀ����
	            		projectvo.setCreationstate((String) map1.get("creationstate"));//��Ŀ״̬
	            		projectvo.setDef20((String) map1.get("id"));//��������
	            		projectvo.setProject_name((String) map1.get("project_name"));//��Ŀ����
	            		projectvo.setPk_parentpro((String) map1.get("pk_parentpro"));//����Ŀ
	            		projectvo.setPk_projectstate((String) map1.get("pk_projectstate"));//״̬
	            		projectvo.setPk_projectclass((String) map1.get("pk_projectclass"));//��Ŀ����
	            		projectvo.setProject_code((String) map1.get("project_code"));//��Ŀ����
	            		projectvo.setProject_name((String) map1.get("project_name"));//��Ŀ����
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

