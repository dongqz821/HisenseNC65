package nc.ui.ic.m45;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.ui.uif2.factory.AbstractJavaBeanDefinition;

public class PurchaseIn_Org extends nc.ui.ic.m45.PurchaseInAction{
	private Map<String, Object> context = new HashMap();
public nc.ui.uif2.userdefitem.QueryParam getQueryParams1(){
 if(context.get("queryParams1")!=null)
 return (nc.ui.uif2.userdefitem.QueryParam)context.get("queryParams1");
  nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
  context.put("queryParams1",bean);
  bean.setMdfullname("ic.PurchaseInHeadVO");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.userdefitem.QueryParam getQueryParams2(){
 if(context.get("queryParams2")!=null)
 return (nc.ui.uif2.userdefitem.QueryParam)context.get("queryParams2");
  nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
  context.put("queryParams2",bean);
  bean.setMdfullname("ic.PurchaseInBodyVO");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.UserdefQueryParam getUserQueryParams1(){
 if(context.get("userQueryParams1")!=null)
 return (nc.ui.uif2.editor.UserdefQueryParam)context.get("userQueryParams1");
  nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
  context.put("userQueryParams1",bean);
  bean.setMdfullname("ic.PurchaseInHeadVO");
  bean.setPos(0);
  bean.setPrefix("vdef");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.general.model.ICGenRevisePageService getPageQuery(){
 if(context.get("pageQuery")!=null)
 return (nc.ui.ic.general.model.ICGenRevisePageService)context.get("pageQuery");
  nc.ui.ic.general.model.ICGenRevisePageService bean = new nc.ui.ic.general.model.ICGenRevisePageService();
  context.put("pageQuery",bean);
  bean.setVoClassName("nc.vo.ic.m45.entity.PurchaseInVO");
  bean.setBillType("45");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.components.pagination.PaginationBar getPageBar(){
 if(context.get("pageBar")!=null)
 return (nc.ui.uif2.components.pagination.PaginationBar)context.get("pageBar");
  nc.ui.uif2.components.pagination.PaginationBar bean = new nc.ui.uif2.components.pagination.PaginationBar();
  context.put("pageBar",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.pagination.BillModelPaginationDelegator getPageDelegator(){
 if(context.get("pageDelegator")!=null)
 return (nc.ui.pubapp.uif2app.actions.pagination.BillModelPaginationDelegator)context.get("pageDelegator");
  nc.ui.pubapp.uif2app.actions.pagination.BillModelPaginationDelegator bean = new nc.ui.pubapp.uif2app.actions.pagination.BillModelPaginationDelegator(getIcBizModel());  context.put("pageDelegator",bean);
  bean.setPaginationQuery(getPageQuery());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.scmpub.page.model.SCMBillPageMediator getPageMediator(){
 if(context.get("pageMediator")!=null)
 return (nc.ui.scmpub.page.model.SCMBillPageMediator)context.get("pageMediator");
  nc.ui.scmpub.page.model.SCMBillPageMediator bean = new nc.ui.scmpub.page.model.SCMBillPageMediator();
  context.put("pageMediator",bean);
  bean.setListView(getList());
  bean.setRecordInPage(10);
  bean.setCachePages(10);
  bean.setPageDelegator(getPageDelegator());
  bean.init();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.UserdefQueryParam getUserQueryParams2(){
 if(context.get("userQueryParams2")!=null)
 return (nc.ui.uif2.editor.UserdefQueryParam)context.get("userQueryParams2");
  nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
  context.put("userQueryParams2",bean);
  bean.setMdfullname("ic.PurchaseInBodyVO");
  bean.setPos(1);
  bean.setTabcode("cgeneralbid");
  bean.setPrefix("vbdef");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.TangramContainer getContainer(){
 if(context.get("container")!=null)
 return (nc.ui.uif2.TangramContainer)context.get("container");
  nc.ui.uif2.TangramContainer bean = new nc.ui.uif2.TangramContainer();
  context.put("container",bean);
  bean.setTangramLayoutRoot((nc.ui.uif2.tangramlayout.node.TangramLayoutNode)findBeanInUIF2BeanFactory("vsnodequery"));
  bean.setModel(getIcBizModel());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.view.PurchaseInBizBillListView getList(){
 if(context.get("list")!=null)
 return (nc.ui.ic.m45.view.PurchaseInBizBillListView)context.get("list");
  nc.ui.ic.m45.view.PurchaseInBizBillListView bean = new nc.ui.ic.m45.view.PurchaseInBizBillListView();
  context.put("list",bean);
  bean.setModel(getIcBizModel());
  bean.setMultiSelectionMode(0);
  bean.setTemplateContainer((nc.ui.uif2.editor.TemplateContainer)findBeanInUIF2BeanFactory("templateContainer"));
  bean.setUserdefitemListPreparator((nc.ui.pub.bill.IBillListData)findBeanInUIF2BeanFactory("userdefAndMarAsstListPreparator"));
  bean.setPaginationBar(getPageBar());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.material.assistant.MarAsstPreparator getMarAsstPreparator(){
 if(context.get("marAsstPreparator")!=null)
 return (nc.ui.pubapp.uif2app.view.material.assistant.MarAsstPreparator)context.get("marAsstPreparator");
  nc.ui.pubapp.uif2app.view.material.assistant.MarAsstPreparator bean = new nc.ui.pubapp.uif2app.view.material.assistant.MarAsstPreparator();
  context.put("marAsstPreparator",bean);
  bean.setModel(getIcBizModel());
  bean.setContainer((nc.ui.uif2.userdefitem.UserDefItemContainer)findBeanInUIF2BeanFactory("userdefitemContainer"));
  bean.setPrefix("vfree");
  bean.setMaterialField("cmaterialvid");
  bean.setStoreStateField("cstateid");
  bean.setProjectField("cprojectid");
  bean.setProductorField("cproductorid");
  bean.setSignatureField("cffileid");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.model.PurchaseInModelService getManageModelService(){
 if(context.get("manageModelService")!=null)
 return (nc.ui.ic.m45.model.PurchaseInModelService)context.get("manageModelService");
  nc.ui.ic.m45.model.PurchaseInModelService bean = new nc.ui.ic.m45.model.PurchaseInModelService();
  context.put("manageModelService",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.deal.PurchaseInDLGWrapper getQryDLGInitializer(){
 if(context.get("qryDLGInitializer")!=null)
 return (nc.ui.ic.m45.deal.PurchaseInDLGWrapper)context.get("qryDLGInitializer");
  nc.ui.ic.m45.deal.PurchaseInDLGWrapper bean = new nc.ui.ic.m45.deal.PurchaseInDLGWrapper();
  context.put("qryDLGInitializer",bean);
  bean.setModel(getIcBizModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.deal.PurchaseInUIProcessorInfo getUIProcesorInfo(){
 if(context.get("UIProcesorInfo")!=null)
 return (nc.ui.ic.m45.deal.PurchaseInUIProcessorInfo)context.get("UIProcesorInfo");
  nc.ui.ic.m45.deal.PurchaseInUIProcessorInfo bean = new nc.ui.ic.m45.deal.PurchaseInUIProcessorInfo();
  context.put("UIProcesorInfo",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CmaterialvidHandlerFor45 getCmaterialvidHandler(){
 if(context.get("cmaterialvidHandler")!=null)
 return (nc.ui.ic.m45.handler.CmaterialvidHandlerFor45)context.get("cmaterialvidHandler");
  nc.ui.ic.m45.handler.CmaterialvidHandlerFor45 bean = new nc.ui.ic.m45.handler.CmaterialvidHandlerFor45();
  context.put("cmaterialvidHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.MainNumHandlerFor45 getMainNumHandler(){
 if(context.get("mainNumHandler")!=null)
 return (nc.ui.ic.m45.handler.MainNumHandlerFor45)context.get("mainNumHandler");
  nc.ui.ic.m45.handler.MainNumHandlerFor45 bean = new nc.ui.ic.m45.handler.MainNumHandlerFor45();
  context.put("mainNumHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NumHandlerFor45 getNumHandler(){
 if(context.get("numHandler")!=null)
 return (nc.ui.ic.m45.handler.NumHandlerFor45)context.get("numHandler");
  nc.ui.ic.m45.handler.NumHandlerFor45 bean = new nc.ui.ic.m45.handler.NumHandlerFor45();
  context.put("numHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.HslHandlerFor45 getHslHandler(){
 if(context.get("hslHandler")!=null)
 return (nc.ui.ic.m45.handler.HslHandlerFor45)context.get("hslHandler");
  nc.ui.ic.m45.handler.HslHandlerFor45 bean = new nc.ui.ic.m45.handler.HslHandlerFor45();
  context.put("hslHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CqtunitidHandler getCqtunitidHandler(){
 if(context.get("cqtunitidHandler")!=null)
 return (nc.ui.ic.m45.handler.CqtunitidHandler)context.get("cqtunitidHandler");
  nc.ui.ic.m45.handler.CqtunitidHandler bean = new nc.ui.ic.m45.handler.CqtunitidHandler();
  context.put("cqtunitidHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.general.handler.QtHslHandler getQtHslHandler(){
 if(context.get("qtHslHandler")!=null)
 return (nc.ui.ic.general.handler.QtHslHandler)context.get("qtHslHandler");
  nc.ui.ic.general.handler.QtHslHandler bean = new nc.ui.ic.general.handler.QtHslHandler();
  context.put("qtHslHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CastunitidHandlerFor45 getCastunitidHandler(){
 if(context.get("castunitidHandler")!=null)
 return (nc.ui.ic.m45.handler.CastunitidHandlerFor45)context.get("castunitidHandler");
  nc.ui.ic.m45.handler.CastunitidHandlerFor45 bean = new nc.ui.ic.m45.handler.CastunitidHandlerFor45();
  context.put("castunitidHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NCostmnyHandlerFor45 getNcostmnyHandler(){
 if(context.get("ncostmnyHandler")!=null)
 return (nc.ui.ic.m45.handler.NCostmnyHandlerFor45)context.get("ncostmnyHandler");
  nc.ui.ic.m45.handler.NCostmnyHandlerFor45 bean = new nc.ui.ic.m45.handler.NCostmnyHandlerFor45();
  context.put("ncostmnyHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NCostpriceHandlerFor45 getNcostPriceHandler(){
 if(context.get("ncostPriceHandler")!=null)
 return (nc.ui.ic.m45.handler.NCostpriceHandlerFor45)context.get("ncostPriceHandler");
  nc.ui.ic.m45.handler.NCostpriceHandlerFor45 bean = new nc.ui.ic.m45.handler.NCostpriceHandlerFor45();
  context.put("ncostPriceHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NgrossNumHandlerFor45 getNgrossNumHandler(){
 if(context.get("ngrossNumHandler")!=null)
 return (nc.ui.ic.m45.handler.NgrossNumHandlerFor45)context.get("ngrossNumHandler");
  nc.ui.ic.m45.handler.NgrossNumHandlerFor45 bean = new nc.ui.ic.m45.handler.NgrossNumHandlerFor45();
  context.put("ngrossNumHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NtareNumHandlerFor45 getNtareNumHandler(){
 if(context.get("ntareNumHandler")!=null)
 return (nc.ui.ic.m45.handler.NtareNumHandlerFor45)context.get("ntareNumHandler");
  nc.ui.ic.m45.handler.NtareNumHandlerFor45 bean = new nc.ui.ic.m45.handler.NtareNumHandlerFor45();
  context.put("ntareNumHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CtaxcodeidHandlerFor45 getCtaxcodeidHandler(){
 if(context.get("ctaxcodeidHandler")!=null)
 return (nc.ui.ic.m45.handler.CtaxcodeidHandlerFor45)context.get("ctaxcodeidHandler");
  nc.ui.ic.m45.handler.CtaxcodeidHandlerFor45 bean = new nc.ui.ic.m45.handler.CtaxcodeidHandlerFor45();
  context.put("ctaxcodeidHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.FtaxtypeflagHandlerFor45 getFtaxtypeflagHandler(){
 if(context.get("ftaxtypeflagHandler")!=null)
 return (nc.ui.ic.m45.handler.FtaxtypeflagHandlerFor45)context.get("ftaxtypeflagHandler");
  nc.ui.ic.m45.handler.FtaxtypeflagHandlerFor45 bean = new nc.ui.ic.m45.handler.FtaxtypeflagHandlerFor45();
  context.put("ftaxtypeflagHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NnosubtaxrateHandlerFor45 getNnosubtaxrateHandler(){
 if(context.get("nnosubtaxrateHandler")!=null)
 return (nc.ui.ic.m45.handler.NnosubtaxrateHandlerFor45)context.get("nnosubtaxrateHandler");
  nc.ui.ic.m45.handler.NnosubtaxrateHandlerFor45 bean = new nc.ui.ic.m45.handler.NnosubtaxrateHandlerFor45();
  context.put("nnosubtaxrateHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CvmivenderidHandlerFor45 getCvmivenderidHandler(){
 if(context.get("cvmivenderidHandler")!=null)
 return (nc.ui.ic.m45.handler.CvmivenderidHandlerFor45)context.get("cvmivenderidHandler");
  nc.ui.ic.m45.handler.CvmivenderidHandlerFor45 bean = new nc.ui.ic.m45.handler.CvmivenderidHandlerFor45();
  context.put("cvmivenderidHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CwarehouseidHandlerFor45 getCwarehouseidHandler(){
 if(context.get("cwarehouseidHandler")!=null)
 return (nc.ui.ic.m45.handler.CwarehouseidHandlerFor45)context.get("cwarehouseidHandler");
  nc.ui.ic.m45.handler.CwarehouseidHandlerFor45 bean = new nc.ui.ic.m45.handler.CwarehouseidHandlerFor45();
  context.put("cwarehouseidHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CdptvidHandlerFor45 getCdptvidHandler(){
 if(context.get("cdptvidHandler")!=null)
 return (nc.ui.ic.m45.handler.CdptvidHandlerFor45)context.get("cdptvidHandler");
  nc.ui.ic.m45.handler.CdptvidHandlerFor45 bean = new nc.ui.ic.m45.handler.CdptvidHandlerFor45();
  context.put("cdptvidHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NchangestdrateCalcHandler getNchangestdrateCalcHandler(){
 if(context.get("nchangestdrateCalcHandler")!=null)
 return (nc.ui.ic.m45.handler.NchangestdrateCalcHandler)context.get("nchangestdrateCalcHandler");
  nc.ui.ic.m45.handler.NchangestdrateCalcHandler bean = new nc.ui.ic.m45.handler.NchangestdrateCalcHandler();
  context.put("nchangestdrateCalcHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CbizidHandlerFor45 getCbizidHandler(){
 if(context.get("cbizidHandler")!=null)
 return (nc.ui.ic.m45.handler.CbizidHandlerFor45)context.get("cbizidHandler");
  nc.ui.ic.m45.handler.CbizidHandlerFor45 bean = new nc.ui.ic.m45.handler.CbizidHandlerFor45();
  context.put("cbizidHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CreqwareidHandlerFor45 getCreqwareidHandlerFor45(){
 if(context.get("creqwareidHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.CreqwareidHandlerFor45)context.get("creqwareidHandlerFor45");
  nc.ui.ic.m45.handler.CreqwareidHandlerFor45 bean = new nc.ui.ic.m45.handler.CreqwareidHandlerFor45();
  context.put("creqwareidHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CprojecttaskidHandler getCprojecttaskidHandler(){
 if(context.get("cprojecttaskidHandler")!=null)
 return (nc.ui.ic.m45.handler.CprojecttaskidHandler)context.get("cprojecttaskidHandler");
  nc.ui.ic.m45.handler.CprojecttaskidHandler bean = new nc.ui.ic.m45.handler.CprojecttaskidHandler();
  context.put("cprojecttaskidHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CfanaceorgvidHandlerFor45 getCfanaceorgvidHandlerFor45(){
 if(context.get("cfanaceorgvidHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.CfanaceorgvidHandlerFor45)context.get("cfanaceorgvidHandlerFor45");
  nc.ui.ic.m45.handler.CfanaceorgvidHandlerFor45 bean = new nc.ui.ic.m45.handler.CfanaceorgvidHandlerFor45();
  context.put("cfanaceorgvidHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CfanaceorgoidHandlerFor45 getCfanaceorgoidHandlerFor45(){
 if(context.get("cfanaceorgoidHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.CfanaceorgoidHandlerFor45)context.get("cfanaceorgoidHandlerFor45");
  nc.ui.ic.m45.handler.CfanaceorgoidHandlerFor45 bean = new nc.ui.ic.m45.handler.CfanaceorgoidHandlerFor45();
  context.put("cfanaceorgoidHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CvendoridHandlerFor45 getCvendoridHandlerFor45(){
 if(context.get("cvendoridHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.CvendoridHandlerFor45)context.get("cvendoridHandlerFor45");
  nc.ui.ic.m45.handler.CvendoridHandlerFor45 bean = new nc.ui.ic.m45.handler.CvendoridHandlerFor45();
  context.put("cvendoridHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CrececountryidHandlerFor45 getCrececountryidHandlerFor45(){
 if(context.get("crececountryidHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.CrececountryidHandlerFor45)context.get("crececountryidHandlerFor45");
  nc.ui.ic.m45.handler.CrececountryidHandlerFor45 bean = new nc.ui.ic.m45.handler.CrececountryidHandlerFor45();
  context.put("crececountryidHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CsendcountryidHandlerFor45 getCsendcountryidHandlerFor45(){
 if(context.get("csendcountryidHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.CsendcountryidHandlerFor45)context.get("csendcountryidHandlerFor45");
  nc.ui.ic.m45.handler.CsendcountryidHandlerFor45 bean = new nc.ui.ic.m45.handler.CsendcountryidHandlerFor45();
  context.put("csendcountryidHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CtaxcountryidHandlerFor45 getCtaxcountryidHandlerFor45(){
 if(context.get("ctaxcountryidHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.CtaxcountryidHandlerFor45)context.get("ctaxcountryidHandlerFor45");
  nc.ui.ic.m45.handler.CtaxcountryidHandlerFor45 bean = new nc.ui.ic.m45.handler.CtaxcountryidHandlerFor45();
  context.put("ctaxcountryidHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CdestiareaidHandlerFor45 getCdestiareaidHandlerFor45(){
 if(context.get("cdestiareaidHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.CdestiareaidHandlerFor45)context.get("cdestiareaidHandlerFor45");
  nc.ui.ic.m45.handler.CdestiareaidHandlerFor45 bean = new nc.ui.ic.m45.handler.CdestiareaidHandlerFor45();
  context.put("cdestiareaidHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CorigareaidHandlerFor45 getCorigareaidHandlerFor45(){
 if(context.get("corigareaidHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.CorigareaidHandlerFor45)context.get("corigareaidHandlerFor45");
  nc.ui.ic.m45.handler.CorigareaidHandlerFor45 bean = new nc.ui.ic.m45.handler.CorigareaidHandlerFor45();
  context.put("corigareaidHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NcaltaxmnyHandlerFor45 getNcaltaxmnyHandlerFor45(){
 if(context.get("ncaltaxmnyHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.NcaltaxmnyHandlerFor45)context.get("ncaltaxmnyHandlerFor45");
  nc.ui.ic.m45.handler.NcaltaxmnyHandlerFor45 bean = new nc.ui.ic.m45.handler.NcaltaxmnyHandlerFor45();
  context.put("ncaltaxmnyHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NorigmnyHandlerFor45 getNorigmnyHandlerFor45(){
 if(context.get("norigmnyHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.NorigmnyHandlerFor45)context.get("norigmnyHandlerFor45");
  nc.ui.ic.m45.handler.NorigmnyHandlerFor45 bean = new nc.ui.ic.m45.handler.NorigmnyHandlerFor45();
  context.put("norigmnyHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NorigtaxmnyHandlerFor45 getNorigtaxmnyHandlerFor45(){
 if(context.get("norigtaxmnyHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.NorigtaxmnyHandlerFor45)context.get("norigtaxmnyHandlerFor45");
  nc.ui.ic.m45.handler.NorigtaxmnyHandlerFor45 bean = new nc.ui.ic.m45.handler.NorigtaxmnyHandlerFor45();
  context.put("norigtaxmnyHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NorignetpriceHandlerFor45 getNorignetpriceHandlerFor45(){
 if(context.get("norignetpriceHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.NorignetpriceHandlerFor45)context.get("norignetpriceHandlerFor45");
  nc.ui.ic.m45.handler.NorignetpriceHandlerFor45 bean = new nc.ui.ic.m45.handler.NorignetpriceHandlerFor45();
  context.put("norignetpriceHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NorigtaxnetpriceHandlerFor45 getNorigtaxnetpriceHandlerFor45(){
 if(context.get("norigtaxnetpriceHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.NorigtaxnetpriceHandlerFor45)context.get("norigtaxnetpriceHandlerFor45");
  nc.ui.ic.m45.handler.NorigtaxnetpriceHandlerFor45 bean = new nc.ui.ic.m45.handler.NorigtaxnetpriceHandlerFor45();
  context.put("norigtaxnetpriceHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NnosubtaxHandlerFor45 getNnosubtaxHandlerFor45(){
 if(context.get("nnosubtaxHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.NnosubtaxHandlerFor45)context.get("nnosubtaxHandlerFor45");
  nc.ui.ic.m45.handler.NnosubtaxHandlerFor45 bean = new nc.ui.ic.m45.handler.NnosubtaxHandlerFor45();
  context.put("nnosubtaxHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CprojectidHandlerFor45 getCprojectidHandlerFor45(){
 if(context.get("cprojectidHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.CprojectidHandlerFor45)context.get("cprojectidHandlerFor45");
  nc.ui.ic.m45.handler.CprojectidHandlerFor45 bean = new nc.ui.ic.m45.handler.CprojectidHandlerFor45();
  context.put("cprojectidHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CpurorgoidHandler getCpurorgoidHandler(){
 if(context.get("cpurorgoidHandler")!=null)
 return (nc.ui.ic.m45.handler.CpurorgoidHandler)context.get("cpurorgoidHandler");
  nc.ui.ic.m45.handler.CpurorgoidHandler bean = new nc.ui.ic.m45.handler.CpurorgoidHandler();
  context.put("cpurorgoidHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.CpurorgvidHandler getCpurorgvidHandler(){
 if(context.get("cpurorgvidHandler")!=null)
 return (nc.ui.ic.m45.handler.CpurorgvidHandler)context.get("cpurorgvidHandler");
  nc.ui.ic.m45.handler.CpurorgvidHandler bean = new nc.ui.ic.m45.handler.CpurorgvidHandler();
  context.put("cpurorgvidHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.NitemdiscountrateHandlerFor45 getNitemdiscountrateHandlerFor45(){
 if(context.get("nitemdiscountrateHandlerFor45")!=null)
 return (nc.ui.ic.m45.handler.NitemdiscountrateHandlerFor45)context.get("nitemdiscountrateHandlerFor45");
  nc.ui.ic.m45.handler.NitemdiscountrateHandlerFor45 bean = new nc.ui.ic.m45.handler.NitemdiscountrateHandlerFor45();
  context.put("nitemdiscountrateHandlerFor45",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.pub.handler.card.ICCardEditEventHandlerMap getChildCardEditHandlerMap(){
 if(context.get("childCardEditHandlerMap")!=null)
 return (nc.ui.ic.pub.handler.card.ICCardEditEventHandlerMap)context.get("childCardEditHandlerMap");
  nc.ui.ic.pub.handler.card.ICCardEditEventHandlerMap bean = new nc.ui.ic.pub.handler.card.ICCardEditEventHandlerMap();
  context.put("childCardEditHandlerMap",bean);
  bean.setHandlerMap(getManagedMap0());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private Map getManagedMap0(){  Map map = new HashMap();  map.put("cmaterialvid",getCmaterialvidHandler());  map.put("cpurorgoid",getCpurorgoidHandler());  map.put("cpurorgvid",getCpurorgvidHandler());  map.put("ncostprice",getNcostPriceHandler());  map.put("cdptvid",getCdptvidHandler());  map.put("corigcurrencyid",getNchangestdrateCalcHandler());  map.put("ccurrencyid",getNchangestdrateCalcHandler());  map.put("pk_creqwareid",getCreqwareidHandlerFor45());  map.put("cprojecttaskid",getCprojecttaskidHandler());  map.put("cfanaceorgvid",getCfanaceorgvidHandlerFor45());  map.put("cfanaceorgoid",getCfanaceorgoidHandlerFor45());  map.put("cvendorid",getCvendoridHandlerFor45());  map.put("crececountryid",getCrececountryidHandlerFor45());  map.put("csendcountryid",getCsendcountryidHandlerFor45());  map.put("ctaxcountryid",getCtaxcountryidHandlerFor45());  map.put("cdestiareaid",getCdestiareaidHandlerFor45());  map.put("corigareaid",getCorigareaidHandlerFor45());  map.put("ncaltaxmny",getNcaltaxmnyHandlerFor45());  map.put("ctaxcodeid",getCtaxcodeidHandler());  map.put("cprojectid",getCprojectidHandlerFor45());  map.put("nnosubtaxrate",getNnosubtaxrateHandler());  map.put("ftaxtypeflag",getFtaxtypeflagHandler());  map.put("cqtunitid",getCqtunitidHandler());  map.put("vqtunitrate",getQtHslHandler());  map.put("norigmny",getNorigmnyHandlerFor45());  map.put("norigtaxmny",getNorigtaxmnyHandlerFor45());  map.put("norignetprice",getNorignetpriceHandlerFor45());  map.put("norigtaxnetprice",getNorigtaxnetpriceHandlerFor45());  map.put("nnosubtax",getNnosubtaxHandlerFor45());  map.put("nitemdiscountrate",getNitemdiscountrateHandlerFor45());  return map;}

public nc.ui.ic.general.model.ICGenBizModel getIcBizModel(){
 if(context.get("icBizModel")!=null)
 return (nc.ui.ic.general.model.ICGenBizModel)context.get("icBizModel");
  nc.ui.ic.general.model.ICGenBizModel bean = new nc.ui.ic.general.model.ICGenBizModel();
  context.put("icBizModel",bean);
  bean.setService(getManageModelService());
  bean.setBusinessObjectAdapterFactory((nc.vo.bd.meta.IBDObjectAdapterFactory)findBeanInUIF2BeanFactory("boadatorfactory"));
  bean.setIcUIContext((nc.ui.ic.pub.env.ICUIContext)findBeanInUIF2BeanFactory("icUIContext"));
  bean.setBillType("45");
  bean.setPowerValidate(true);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.view.PurchaseInBizView getCard(){
 if(context.get("card")!=null)
 return (nc.ui.ic.m45.view.PurchaseInBizView)context.get("card");
  nc.ui.ic.m45.view.PurchaseInBizView bean = new nc.ui.ic.m45.view.PurchaseInBizView();
  context.put("card",bean);
  bean.setModel(getIcBizModel());
  bean.setBarCodeInputPanel((nc.ui.ic.pub.view.BarCodeInputPanel)findBeanInUIF2BeanFactory("barcodecard"));
  bean.setTemplateContainer((nc.ui.uif2.editor.TemplateContainer)findBeanInUIF2BeanFactory("templateContainer"));
  bean.setTangramContainer(getContainer());
  bean.setUserdefitemPreparator((nc.ui.pub.bill.IBillData)findBeanInUIF2BeanFactory("userdefAndMarAsstCardPreparator"));
  bean.setAutoAddLine(true);
  bean.setTemplateNotNullValidate(true);
  bean.setBlankChildrenFilter(getSingleFieldBlankChildrenFilter_15be51a());
  bean.setBodyLineActions(getManagedList0());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter getSingleFieldBlankChildrenFilter_15be51a(){
 if(context.get("nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter#15be51a")!=null)
 return (nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter)context.get("nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter#15be51a");
  nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter bean = new nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter();
  context.put("nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter#15be51a",bean);
  bean.setFieldName("cmaterialvid");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList0(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyAddLineAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyInsertLineAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyDelLineAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyCopyLineAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyPasteLineAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyPasteToTailAction"));  list.add(getActionsBar_ActionsBarSeparator_1e1e0b());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("rearrangeRowNoBodyLineAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyLineEditAction"));  list.add(getActionsBar_ActionsBarSeparator_1468a30());  list.add(getDefaultBodyZoomAction_1a9697());  return list;}

private nc.ui.pub.beans.ActionsBar.ActionsBarSeparator getActionsBar_ActionsBarSeparator_1e1e0b(){
 if(context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1e1e0b")!=null)
 return (nc.ui.pub.beans.ActionsBar.ActionsBarSeparator)context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1e1e0b");
  nc.ui.pub.beans.ActionsBar.ActionsBarSeparator bean = new nc.ui.pub.beans.ActionsBar.ActionsBarSeparator();
  context.put("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1e1e0b",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pub.beans.ActionsBar.ActionsBarSeparator getActionsBar_ActionsBarSeparator_1468a30(){
 if(context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1468a30")!=null)
 return (nc.ui.pub.beans.ActionsBar.ActionsBarSeparator)context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1468a30");
  nc.ui.pub.beans.ActionsBar.ActionsBarSeparator bean = new nc.ui.pub.beans.ActionsBar.ActionsBarSeparator();
  context.put("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1468a30",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction getDefaultBodyZoomAction_1a9697(){
 if(context.get("nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction#1a9697")!=null)
 return (nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction)context.get("nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction#1a9697");
  nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction bean = new nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction();
  context.put("nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction#1a9697",bean);
  bean.setPos(1);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.ActionContributors getToftpanelActionContributors(){
 if(context.get("toftpanelActionContributors")!=null)
 return (nc.ui.uif2.actions.ActionContributors)context.get("toftpanelActionContributors");
  nc.ui.uif2.actions.ActionContributors bean = new nc.ui.uif2.actions.ActionContributors();
  context.put("toftpanelActionContributors",bean);
  bean.setContributors(getManagedList1());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList1(){  List list = new ArrayList();  list.add(getActionsOfList());  list.add(getActionsOfCard());  return list;}

public nc.ui.uif2.actions.StandAloneToftPanelActionContainer getActionsOfList(){
 if(context.get("actionsOfList")!=null)
 return (nc.ui.uif2.actions.StandAloneToftPanelActionContainer)context.get("actionsOfList");
  nc.ui.uif2.actions.StandAloneToftPanelActionContainer bean = new nc.ui.uif2.actions.StandAloneToftPanelActionContainer(getList());  context.put("actionsOfList",bean);
  bean.setActions(getManagedList2());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList2(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("editAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("deleteAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("copyAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("queryAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("refreshAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("maintainMenu"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("returnMenu"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("signActionMenu"));  list.add(getAssistantFunctionBrowseAction_IN());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("linkQryBrowseGroupAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add(getRelatFunctionBrowseAction_IN());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("importExportAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("printMngAction"));  return list;}

public nc.ui.uif2.actions.StandAloneToftPanelActionContainer getActionsOfCard(){
 if(context.get("actionsOfCard")!=null)
 return (nc.ui.uif2.actions.StandAloneToftPanelActionContainer)context.get("actionsOfCard");
  nc.ui.uif2.actions.StandAloneToftPanelActionContainer bean = new nc.ui.uif2.actions.StandAloneToftPanelActionContainer(getCard());  context.put("actionsOfCard",bean);
  bean.setModel(getIcBizModel());
  bean.setActions(getManagedList3());
  bean.setEditActions(getManagedList4());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList3(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("editAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("deleteAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("copyAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("queryAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("refreshCardAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("maintainMenu"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("returnMenu"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("signActionMenu"));  list.add(getAssistantFunctionBrowseAction_IN());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("linkQryBrowseGroupAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add(getRelatFunctionBrowseAction_IN());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("importExportAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("printMngAction"));  return list;}

private List getManagedList4(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("saveAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("cancelAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("fetchAutoAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("deductCalculateAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("maintainMenu"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("linkQryEditGroupAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("importExportAction"));  return list;}

public nc.funcnode.ui.action.MenuAction getAssistantFunctionBrowseAction_IN(){
 if(context.get("assistantFunctionBrowseAction_IN")!=null)
 return (nc.funcnode.ui.action.MenuAction)context.get("assistantFunctionBrowseAction_IN");
  nc.funcnode.ui.action.MenuAction bean = new nc.funcnode.ui.action.MenuAction();
  context.put("assistantFunctionBrowseAction_IN",bean);
  bean.setCode("NastMngBrowseAction");
  bean.setName(getI18nFB_194cd00());
  bean.setTooltip(getI18nFB_1eed0c());
  bean.setActions(getManagedList5());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_194cd00(){
 if(context.get("nc.ui.uif2.I18nFB#194cd00")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#194cd00");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#194cd00",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0741");
  bean.setDefaultValue("辅助功能");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#194cd00",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private java.lang.String getI18nFB_1eed0c(){
 if(context.get("nc.ui.uif2.I18nFB#1eed0c")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1eed0c");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1eed0c",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0785");
  bean.setDefaultValue("辅助功能(Alt+D)");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1eed0c",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList5(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("matchAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("attachMentMngAction"));  return list;}

public nc.funcnode.ui.action.MenuAction getRelatFunctionBrowseAction_IN(){
 if(context.get("relatFunctionBrowseAction_IN")!=null)
 return (nc.funcnode.ui.action.MenuAction)context.get("relatFunctionBrowseAction_IN");
  nc.funcnode.ui.action.MenuAction bean = new nc.funcnode.ui.action.MenuAction();
  context.put("relatFunctionBrowseAction_IN",bean);
  bean.setCode("NrelatMngBrowseAction");
  bean.setName(getI18nFB_5ce855());
  bean.setTooltip(getI18nFB_1996543());
  bean.setActions(getManagedList6());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_5ce855(){
 if(context.get("nc.ui.uif2.I18nFB#5ce855")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#5ce855");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#5ce855",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0743");
  bean.setDefaultValue("关联功能");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#5ce855",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private java.lang.String getI18nFB_1996543(){
 if(context.get("nc.ui.uif2.I18nFB#1996543")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1996543");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1996543",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0787");
  bean.setDefaultValue("关联功能(Shift+C)");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1996543",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList6(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("generateEquipCardAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("cancelGenerateEquipCardAction"));  list.add(getFixedAssetAction());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("delfixedAssetAction"));  list.add(getMaterialFetchAction());  return list;}

public nc.ui.ic.m45.action.PurchaseInMaterialFetchAction getMaterialFetchAction(){
 if(context.get("materialFetchAction")!=null)
 return (nc.ui.ic.m45.action.PurchaseInMaterialFetchAction)context.get("materialFetchAction");
  nc.ui.ic.m45.action.PurchaseInMaterialFetchAction bean = new nc.ui.ic.m45.action.PurchaseInMaterialFetchAction();
  context.put("materialFetchAction",bean);
  bean.setForm(getCard());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener getInitDataListener(){
 if(context.get("InitDataListener")!=null)
 return (nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener)context.get("InitDataListener");
  nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener bean = new nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener();
  context.put("InitDataListener",bean);
  bean.setModel(getIcBizModel());
  bean.setVoClassName("nc.vo.ic.m45.entity.PurchaseInVO");
  bean.setAutoShowUpComponent(getCard());
  bean.setQueryAction((nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction)findBeanInUIF2BeanFactory("queryAction"));
  bean.setProcessorMap(getManagedMap1());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private Map getManagedMap1(){  Map map = new HashMap();  map.put("40",getNtbInitProcessor_1c71494());  map.put("89",getIcGenMutiPkLinkQuery());  return map;}

private nc.ui.ic.general.view.NtbInitProcessor getNtbInitProcessor_1c71494(){
 if(context.get("nc.ui.ic.general.view.NtbInitProcessor#1c71494")!=null)
 return (nc.ui.ic.general.view.NtbInitProcessor)context.get("nc.ui.ic.general.view.NtbInitProcessor#1c71494");
  nc.ui.ic.general.view.NtbInitProcessor bean = new nc.ui.ic.general.view.NtbInitProcessor();
  context.put("nc.ui.ic.general.view.NtbInitProcessor#1c71494",bean);
  bean.setModel(getIcBizModel());
  bean.setQueryArea((nc.ui.uif2.actions.QueryAreaShell)findBeanInUIF2BeanFactory("queryArea"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.ic.inandoutui.linkquery.ICGenMutiPkLinkQuery getIcGenMutiPkLinkQuery(){
 if(context.get("icGenMutiPkLinkQuery")!=null)
 return (nc.ui.ic.inandoutui.linkquery.ICGenMutiPkLinkQuery)context.get("icGenMutiPkLinkQuery");
  nc.ui.ic.inandoutui.linkquery.ICGenMutiPkLinkQuery bean = new nc.ui.ic.inandoutui.linkquery.ICGenMutiPkLinkQuery();
  context.put("icGenMutiPkLinkQuery",bean);
  bean.setModel(getIcBizModel());
  bean.setAutoShowUpComponent(getList());
  bean.setVoClass("nc.vo.ic.m45.entity.PurchaseInVO");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.handler.PurchaseInCardEditEventHandler getCardEditEventHandlerMediator(){
 if(context.get("cardEditEventHandlerMediator")!=null)
 return (nc.ui.ic.m45.handler.PurchaseInCardEditEventHandler)context.get("cardEditEventHandlerMediator");
  nc.ui.ic.m45.handler.PurchaseInCardEditEventHandler bean = new nc.ui.ic.m45.handler.PurchaseInCardEditEventHandler();
  context.put("cardEditEventHandlerMediator",bean);
  bean.setEditorModel((nc.ui.ic.pub.model.ICBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setParentHandlerMap((nc.ui.ic.pub.handler.card.ICCardEditEventHandlerMap)findBeanInUIF2BeanFactory("parentCardEditHandlerMap"));
  bean.setChildHandlerMap(getChildCardEditHandlerMap());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.action.PurInFixedAssetAction getFixedAssetAction(){
 if(context.get("fixedAssetAction")!=null)
 return (nc.ui.ic.m45.action.PurInFixedAssetAction)context.get("fixedAssetAction");
  nc.ui.ic.m45.action.PurInFixedAssetAction bean = new nc.ui.ic.m45.action.PurInFixedAssetAction();
  context.put("fixedAssetAction",bean);
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.action.PurInDelFixedAssetAction getDelFixedAssetAction(){
 if(context.get("delFixedAssetAction")!=null)
 return (nc.ui.ic.m45.action.PurInDelFixedAssetAction)context.get("delFixedAssetAction");
  nc.ui.ic.m45.action.PurInDelFixedAssetAction bean = new nc.ui.ic.m45.action.PurInDelFixedAssetAction();
  context.put("delFixedAssetAction",bean);
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.deal.PurchaseInBillScaleProcessor getScalePrcStrategy(){
 if(context.get("scalePrcStrategy")!=null)
 return (nc.ui.ic.m45.deal.PurchaseInBillScaleProcessor)context.get("scalePrcStrategy");
  nc.ui.ic.m45.deal.PurchaseInBillScaleProcessor bean = new nc.ui.ic.m45.deal.PurchaseInBillScaleProcessor();
  context.put("scalePrcStrategy",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m45.view.QueryTemplateContainerFor45 getQueryTemplateContainer(){
 if(context.get("queryTemplateContainer")!=null)
 return (nc.ui.ic.m45.view.QueryTemplateContainerFor45)context.get("queryTemplateContainer");
  nc.ui.ic.m45.view.QueryTemplateContainerFor45 bean = new nc.ui.ic.m45.view.QueryTemplateContainerFor45();
  context.put("queryTemplateContainer",bean);
  bean.setContext((nc.vo.uif2.LoginContext)findBeanInUIF2BeanFactory("context"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

}
