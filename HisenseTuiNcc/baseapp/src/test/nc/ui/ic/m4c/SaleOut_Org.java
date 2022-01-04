package nc.ui.ic.m4c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.ui.uif2.factory.AbstractJavaBeanDefinition;

public class SaleOut_Org extends nc.ui.ic.m4c.SaleOut_Event{
	private Map<String, Object> context = new HashMap();
public nc.ui.uif2.userdefitem.QueryParam getQueryParams1(){
 if(context.get("queryParams1")!=null)
 return (nc.ui.uif2.userdefitem.QueryParam)context.get("queryParams1");
  nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
  context.put("queryParams1",bean);
  bean.setMdfullname("ic.SaleOutHeadVO");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.userdefitem.QueryParam getQueryParams2(){
 if(context.get("queryParams2")!=null)
 return (nc.ui.uif2.userdefitem.QueryParam)context.get("queryParams2");
  nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
  context.put("queryParams2",bean);
  bean.setMdfullname("ic.SaleOutBodyVO");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.UserdefQueryParam getUserQueryParams1(){
 if(context.get("userQueryParams1")!=null)
 return (nc.ui.uif2.editor.UserdefQueryParam)context.get("userQueryParams1");
  nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
  context.put("userQueryParams1",bean);
  bean.setMdfullname("ic.SaleOutHeadVO");
  bean.setPos(0);
  bean.setPrefix("vdef");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.UserdefQueryParam getUserQueryParams2(){
 if(context.get("userQueryParams2")!=null)
 return (nc.ui.uif2.editor.UserdefQueryParam)context.get("userQueryParams2");
  nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
  context.put("userQueryParams2",bean);
  bean.setMdfullname("ic.SaleOutBodyVO");
  bean.setPos(1);
  bean.setPrefix("vbdef");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.general.model.ICGenRevisePageService getPageQuery(){
 if(context.get("pageQuery")!=null)
 return (nc.ui.ic.general.model.ICGenRevisePageService)context.get("pageQuery");
  nc.ui.ic.general.model.ICGenRevisePageService bean = new nc.ui.ic.general.model.ICGenRevisePageService();
  context.put("pageQuery",bean);
  bean.setVoClassName("nc.vo.ic.m4c.entity.SaleOutVO");
  bean.setBillType("4C");
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

public nc.ui.ic.m4c.model.SaleOutModelService getManageModelService(){
 if(context.get("manageModelService")!=null)
 return (nc.ui.ic.m4c.model.SaleOutModelService)context.get("manageModelService");
  nc.ui.ic.m4c.model.SaleOutModelService bean = new nc.ui.ic.m4c.model.SaleOutModelService();
  context.put("manageModelService",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.general.model.ICGenBizModel getIcBizModel(){
 if(context.get("icBizModel")!=null)
 return (nc.ui.ic.general.model.ICGenBizModel)context.get("icBizModel");
  nc.ui.ic.general.model.ICGenBizModel bean = new nc.ui.ic.general.model.ICGenBizModel();
  context.put("icBizModel",bean);
  bean.setService(getManageModelService());
  bean.setBusinessObjectAdapterFactory((nc.vo.bd.meta.IBDObjectAdapterFactory)findBeanInUIF2BeanFactory("boadatorfactory"));
  bean.setIcUIContext((nc.ui.ic.pub.env.ICUIContext)findBeanInUIF2BeanFactory("icUIContext"));
  bean.setBillType("4C");
  bean.setPowerValidate(true);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.deal.SaleOutDLGWrapper getQryDLGInitializer(){
 if(context.get("qryDLGInitializer")!=null)
 return (nc.ui.ic.m4c.deal.SaleOutDLGWrapper)context.get("qryDLGInitializer");
  nc.ui.ic.m4c.deal.SaleOutDLGWrapper bean = new nc.ui.ic.m4c.deal.SaleOutDLGWrapper();
  context.put("qryDLGInitializer",bean);
  bean.setModel(getIcBizModel());
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

public nc.ui.pubapp.uif2app.actions.PfAddInfoLoader getPfAddInfoLoader(){
 if(context.get("pfAddInfoLoader")!=null)
 return (nc.ui.pubapp.uif2app.actions.PfAddInfoLoader)context.get("pfAddInfoLoader");
  nc.ui.pubapp.uif2app.actions.PfAddInfoLoader bean = new nc.ui.pubapp.uif2app.actions.PfAddInfoLoader();
  context.put("pfAddInfoLoader",bean);
  bean.setBillType("4C");
  bean.setModel(getIcBizModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.action.SaleOutAddMenuAction getAddMenu(){
 if(context.get("addMenu")!=null)
 return (nc.ui.ic.m4c.action.SaleOutAddMenuAction)context.get("addMenu");
  nc.ui.ic.m4c.action.SaleOutAddMenuAction bean = new nc.ui.ic.m4c.action.SaleOutAddMenuAction();
  context.put("addMenu",bean);
  bean.setActions(getManagedList0());
  bean.setTooltip(getI18nFB_8f2f0f());
  bean.setBillType("4C");
  bean.setModel(getIcBizModel());
  bean.setPfAddInfoLoader(getPfAddInfoLoader());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList0(){  List list = new ArrayList();  list.add(getAddManualAction());  list.add(getAddFrom4331Action());  list.add(getAddFrom30Action());  list.add(getAddFrom32Action());  list.add(getAddFrom5730Action());  list.add(getAddFrom6030Action());  return list;}

private nc.ui.ic.m4c.action.AddFromSourceAction getAddFrom4331Action(){
 if(context.get("addFrom4331Action")!=null)
 return (nc.ui.ic.m4c.action.AddFromSourceAction)context.get("addFrom4331Action");
  nc.ui.ic.m4c.action.AddFromSourceAction bean = new nc.ui.ic.m4c.action.AddFromSourceAction();
  context.put("addFrom4331Action",bean);
  bean.setSourceBillType("4331");
  bean.setSourceBillName(getI18nFB_1795258());
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
  bean.setDestBillType("4C");
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setPfButtonClickContext(2);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1795258(){
 if(context.get("nc.ui.uif2.I18nFB#1795258")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1795258");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1795258",bean);  bean.setResDir("funcode");
  bean.setResId("btn_40080802_Ref4331");
  bean.setDefaultValue("发货单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1795258",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private nc.ui.ic.m4c.action.AddFromSourceAction getAddFrom30Action(){
 if(context.get("addFrom30Action")!=null)
 return (nc.ui.ic.m4c.action.AddFromSourceAction)context.get("addFrom30Action");
  nc.ui.ic.m4c.action.AddFromSourceAction bean = new nc.ui.ic.m4c.action.AddFromSourceAction();
  context.put("addFrom30Action",bean);
  bean.setSourceBillType("30");
  bean.setSourceBillName(getI18nFB_d1757());
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
  bean.setDestBillType("4C");
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setPfButtonClickContext(2);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_d1757(){
 if(context.get("nc.ui.uif2.I18nFB#d1757")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#d1757");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#d1757",bean);  bean.setResDir("funcode");
  bean.setResId("btn_40080802_Ref30");
  bean.setDefaultValue("销售订单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#d1757",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private nc.ui.ic.m4c.action.AddFromSourceAction getAddFrom32Action(){
 if(context.get("addFrom32Action")!=null)
 return (nc.ui.ic.m4c.action.AddFromSourceAction)context.get("addFrom32Action");
  nc.ui.ic.m4c.action.AddFromSourceAction bean = new nc.ui.ic.m4c.action.AddFromSourceAction();
  context.put("addFrom32Action",bean);
  bean.setSourceBillType("32");
  bean.setSourceBillName(getI18nFB_1778518());
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
  bean.setDestBillType("4C");
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setPfButtonClickContext(2);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1778518(){
 if(context.get("nc.ui.uif2.I18nFB#1778518")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1778518");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1778518",bean);  bean.setResDir("funcode");
  bean.setResId("btn_40080802_Ref32");
  bean.setDefaultValue("销售发票");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1778518",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private nc.ui.ic.m4c.action.AddFromSourceAction getAddFrom5730Action(){
 if(context.get("addFrom5730Action")!=null)
 return (nc.ui.ic.m4c.action.AddFromSourceAction)context.get("addFrom5730Action");
  nc.ui.ic.m4c.action.AddFromSourceAction bean = new nc.ui.ic.m4c.action.AddFromSourceAction();
  context.put("addFrom5730Action",bean);
  bean.setSourceBillType("5730");
  bean.setSourceBillName(getI18nFB_1c31eb3());
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
  bean.setDestBillType("4C");
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setPfButtonClickContext(2);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1c31eb3(){
 if(context.get("nc.ui.uif2.I18nFB#1c31eb3")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1c31eb3");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1c31eb3",bean);  bean.setResDir("funcode");
  bean.setResId("btn_40080802_Ref5730");
  bean.setDefaultValue("出口明细单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1c31eb3",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private nc.ui.ic.m4c.action.AddFromSourceAction getAddFrom6030Action(){
 if(context.get("addFrom6030Action")!=null)
 return (nc.ui.ic.m4c.action.AddFromSourceAction)context.get("addFrom6030Action");
  nc.ui.ic.m4c.action.AddFromSourceAction bean = new nc.ui.ic.m4c.action.AddFromSourceAction();
  context.put("addFrom6030Action",bean);
  bean.setSourceBillType("6030");
  bean.setSourceBillName(getI18nFB_1147ec6());
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
  bean.setDestBillType("4C");
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setPfButtonClickContext(2);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1147ec6(){
 if(context.get("nc.ui.uif2.I18nFB#1147ec6")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1147ec6");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1147ec6",bean);  bean.setResDir("funcode");
  bean.setResId("btn_40080802_Ref6030");
  bean.setDefaultValue("转口明细单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1147ec6",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private java.lang.String getI18nFB_8f2f0f(){
 if(context.get("nc.ui.uif2.I18nFB#8f2f0f")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#8f2f0f");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#8f2f0f",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0739");
  bean.setDefaultValue("新增");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#8f2f0f",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.ic.m4c.action.SaleOutAddManualAction getAddManualAction(){
 if(context.get("addManualAction")!=null)
 return (nc.ui.ic.m4c.action.SaleOutAddManualAction)context.get("addManualAction");
  nc.ui.ic.m4c.action.SaleOutAddManualAction bean = new nc.ui.ic.m4c.action.SaleOutAddManualAction();
  context.put("addManualAction",bean);
  bean.setSourceBillType("MANUAL");
  bean.setSourceBillName(getI18nFB_5aa2e5());
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setInterceptor(getCompositeActionInterceptor_7ca61e());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_5aa2e5(){
 if(context.get("nc.ui.uif2.I18nFB#5aa2e5")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#5aa2e5");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#5aa2e5",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0335");
  bean.setDefaultValue("自制");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#5aa2e5",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor getCompositeActionInterceptor_7ca61e(){
 if(context.get("nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor#7ca61e")!=null)
 return (nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor)context.get("nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor#7ca61e");
  nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor bean = new nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor();
  context.put("nc.ui.pubapp.uif2app.actions.interceptor.CompositeActionInterceptor#7ca61e",bean);
  bean.setInterceptors(getManagedList1());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList1(){  List list = new ArrayList();  list.add((nc.ui.uif2.actions.ActionInterceptor)findBeanInUIF2BeanFactory("cardInterceptor"));  return list;}

public nc.ui.ic.m4c.action.SaleOutCopyAction getCopyAction(){
 if(context.get("copyAction")!=null)
 return (nc.ui.ic.m4c.action.SaleOutCopyAction)context.get("copyAction");
  nc.ui.ic.m4c.action.SaleOutCopyAction bean = new nc.ui.ic.m4c.action.SaleOutCopyAction();
  context.put("copyAction",bean);
  bean.setModel(getIcBizModel());
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setEditor(getCard());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.action.PurchaseInAction getPurchaseInAction(){
 if(context.get("purchaseInAction")!=null)
 return (nc.ui.ic.m4c.action.PurchaseInAction)context.get("purchaseInAction");
  nc.ui.ic.m4c.action.PurchaseInAction bean = new nc.ui.ic.m4c.action.PurchaseInAction();
  context.put("purchaseInAction",bean);
  bean.setSourceBillType("45");
  bean.setBtShowName(getI18nFB_17dfee5());
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
  bean.setDestBillType("4C");
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setPfButtonClickContext(2);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_17dfee5(){
 if(context.get("nc.ui.uif2.I18nFB#17dfee5")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#17dfee5");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#17dfee5",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0754");
  bean.setDefaultValue("参照采购入库单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#17dfee5",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.ic.m4c.action.CoordinatePurchaseInAction getCoordinatePurchaseInAction(){
 if(context.get("coordinatePurchaseInAction")!=null)
 return (nc.ui.ic.m4c.action.CoordinatePurchaseInAction)context.get("coordinatePurchaseInAction");
  nc.ui.ic.m4c.action.CoordinatePurchaseInAction bean = new nc.ui.ic.m4c.action.CoordinatePurchaseInAction();
  context.put("coordinatePurchaseInAction",bean);
  bean.setModel(getIcBizModel());
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setActionName("COOPO");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.action.DirectPurchaseInAction getDirectPurchaseInAction(){
 if(context.get("directPurchaseInAction")!=null)
 return (nc.ui.ic.m4c.action.DirectPurchaseInAction)context.get("directPurchaseInAction");
  nc.ui.ic.m4c.action.DirectPurchaseInAction bean = new nc.ui.ic.m4c.action.DirectPurchaseInAction();
  context.put("directPurchaseInAction",bean);
  bean.setSourceBillType("45");
  bean.setBtShowName(getI18nFB_e99e64());
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
  bean.setDestBillType("4C");
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setPfButtonClickContext(2);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_e99e64(){
 if(context.get("nc.ui.uif2.I18nFB#e99e64")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#e99e64");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#e99e64",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0755");
  bean.setDefaultValue("直运采购入库单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#e99e64",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.ic.m4c.action.BackAction getBackAction(){
 if(context.get("backAction")!=null)
 return (nc.ui.ic.m4c.action.BackAction)context.get("backAction");
  nc.ui.ic.m4c.action.BackAction bean = new nc.ui.ic.m4c.action.BackAction();
  context.put("backAction",bean);
  bean.setModel(getIcBizModel());
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setEditor(getCard());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.action.AssembleAction getAssembleAction(){
 if(context.get("assembleAction")!=null)
 return (nc.ui.ic.m4c.action.AssembleAction)context.get("assembleAction");
  nc.ui.ic.m4c.action.AssembleAction bean = new nc.ui.ic.m4c.action.AssembleAction();
  context.put("assembleAction",bean);
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.action.CompleteSetAction getCompleteSetAction(){
 if(context.get("completeSetAction")!=null)
 return (nc.ui.ic.m4c.action.CompleteSetAction)context.get("completeSetAction");
  nc.ui.ic.m4c.action.CompleteSetAction bean = new nc.ui.ic.m4c.action.CompleteSetAction();
  context.put("completeSetAction",bean);
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.action.LinkQryOutHedgingAction getLinkQryOutHedgingAction(){
 if(context.get("linkQryOutHedgingAction")!=null)
 return (nc.ui.ic.m4c.action.LinkQryOutHedgingAction)context.get("linkQryOutHedgingAction");
  nc.ui.ic.m4c.action.LinkQryOutHedgingAction bean = new nc.ui.ic.m4c.action.LinkQryOutHedgingAction();
  context.put("linkQryOutHedgingAction",bean);
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.action.TrafficStateQryAction getTrafficStateQryAction(){
 if(context.get("trafficStateQryAction")!=null)
 return (nc.ui.ic.m4c.action.TrafficStateQryAction)context.get("trafficStateQryAction");
  nc.ui.ic.m4c.action.TrafficStateQryAction bean = new nc.ui.ic.m4c.action.TrafficStateQryAction();
  context.put("trafficStateQryAction",bean);
  bean.setModel(getIcBizModel());
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.action.SumBatchPrintAction getSumBatchPrintAction(){
 if(context.get("sumBatchPrintAction")!=null)
 return (nc.ui.ic.m4c.action.SumBatchPrintAction)context.get("sumBatchPrintAction");
  nc.ui.ic.m4c.action.SumBatchPrintAction bean = new nc.ui.ic.m4c.action.SumBatchPrintAction();
  context.put("sumBatchPrintAction",bean);
  bean.setModel(getIcBizModel());
  bean.setEditorModel((nc.ui.ic.pub.model.ICBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setPrintProcessor((nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction.IBeforePrintDataProcess)findBeanInUIF2BeanFactory("printProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.MenuAction getRelatFunctionBrowseAction_OUT(){
 if(context.get("relatFunctionBrowseAction_OUT")!=null)
 return (nc.funcnode.ui.action.MenuAction)context.get("relatFunctionBrowseAction_OUT");
  nc.funcnode.ui.action.MenuAction bean = new nc.funcnode.ui.action.MenuAction();
  context.put("relatFunctionBrowseAction_OUT",bean);
  bean.setCode("NrelatMngBrowseAction");
  bean.setName(getI18nFB_19dc2fc());
  bean.setTooltip(getI18nFB_6c5112());
  bean.setActions(getManagedList2());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_19dc2fc(){
 if(context.get("nc.ui.uif2.I18nFB#19dc2fc")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#19dc2fc");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#19dc2fc",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0741");
  bean.setDefaultValue("辅助功能");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#19dc2fc",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private java.lang.String getI18nFB_6c5112(){
 if(context.get("nc.ui.uif2.I18nFB#6c5112")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#6c5112");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#6c5112",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0789");
  bean.setDefaultValue("辅助功能(Alt+M)");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#6c5112",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList2(){  List list = new ArrayList();  list.add(getPurchaseInAction());  list.add(getCoordinatePurchaseInAction());  list.add(getDirectPurchaseInAction());  list.add(getBackAction());  list.add(getAssembleAction());  list.add(getCompleteSetAction());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("attachMentMngAction"));  return list;}

public nc.funcnode.ui.action.MenuAction getLinkQryBrowseGroupAction(){
 if(context.get("linkQryBrowseGroupAction")!=null)
 return (nc.funcnode.ui.action.MenuAction)context.get("linkQryBrowseGroupAction");
  nc.funcnode.ui.action.MenuAction bean = new nc.funcnode.ui.action.MenuAction();
  context.put("linkQryBrowseGroupAction",bean);
  bean.setCode("linkQryAction");
  bean.setName(getI18nFB_13e8a80());
  bean.setTooltip(getI18nFB_f6f0b4());
  bean.setActions(getManagedList3());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_13e8a80(){
 if(context.get("nc.ui.uif2.I18nFB#13e8a80")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#13e8a80");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#13e8a80",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0742");
  bean.setDefaultValue("联查");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#13e8a80",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private java.lang.String getI18nFB_f6f0b4(){
 if(context.get("nc.ui.uif2.I18nFB#f6f0b4")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#f6f0b4");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#f6f0b4",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0781");
  bean.setDefaultValue("联查(Ctrl+K)");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#f6f0b4",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList3(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("linkQryAction"));  list.add(getSeparatorAction_34ed35());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("displayOrhideAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("setPieceAtion"));  list.add(getLinkQryOutHedgingAction());  list.add(getTrafficStateQryAction());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_34ed35(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#34ed35")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#34ed35");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#34ed35",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.MenuAction getLinkQryEditGroupAction(){
 if(context.get("linkQryEditGroupAction")!=null)
 return (nc.funcnode.ui.action.MenuAction)context.get("linkQryEditGroupAction");
  nc.funcnode.ui.action.MenuAction bean = new nc.funcnode.ui.action.MenuAction();
  context.put("linkQryEditGroupAction",bean);
  bean.setCode("linkQryAction");
  bean.setName(getI18nFB_c13ae3());
  bean.setTooltip(getI18nFB_10e7e());
  bean.setActions(getManagedList4());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_c13ae3(){
 if(context.get("nc.ui.uif2.I18nFB#c13ae3")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#c13ae3");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#c13ae3",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0742");
  bean.setDefaultValue("联查");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#c13ae3",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private java.lang.String getI18nFB_10e7e(){
 if(context.get("nc.ui.uif2.I18nFB#10e7e")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#10e7e");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#10e7e",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0782");
  bean.setDefaultValue("联查(Shift+L)");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#10e7e",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList4(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("displayOrhideAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("setPieceAtion"));  return list;}

public nc.funcnode.ui.action.GroupAction getPrintMngAction(){
 if(context.get("printMngAction")!=null)
 return (nc.funcnode.ui.action.GroupAction)context.get("printMngAction");
  nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
  context.put("printMngAction",bean);
  bean.setCode("printMngAction");
  bean.setName(getI18nFB_15ea162());
  bean.setActions(getManagedList5());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_15ea162(){
 if(context.get("nc.ui.uif2.I18nFB#15ea162")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#15ea162");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#15ea162",bean);  bean.setResDir("4008001_0");
  bean.setResId("04008001-0738");
  bean.setDefaultValue("打印");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#15ea162",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList5(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("templatePrintAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("templatePreviewAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("outputAction"));  list.add(getSeparatorAction_1b54e8f());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("printQAAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("mergerShowAction"));  list.add(getSumBatchPrintAction());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("printLocAction"));  list.add(getPrintCountQueryAction());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("dirPrintBarcodeAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("printBarcodeAction"));  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1b54e8f(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#1b54e8f")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#1b54e8f");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#1b54e8f",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.pub.action.ICPrintCountQueryAction getPrintCountQueryAction(){
 if(context.get("printCountQueryAction")!=null)
 return (nc.ui.ic.pub.action.ICPrintCountQueryAction)context.get("printCountQueryAction");
  nc.ui.ic.pub.action.ICPrintCountQueryAction bean = new nc.ui.ic.pub.action.ICPrintCountQueryAction();
  context.put("printCountQueryAction",bean);
  bean.setBilldateFieldName("");
  bean.setModel(getIcBizModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.action.EditAction getSaleOuteditAction(){
 if(context.get("saleOuteditAction")!=null)
 return (nc.ui.ic.m4c.action.EditAction)context.get("saleOuteditAction");
  nc.ui.ic.m4c.action.EditAction bean = new nc.ui.ic.m4c.action.EditAction();
  context.put("saleOuteditAction",bean);
  bean.setModel(getIcBizModel());
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setInterceptor((nc.ui.uif2.actions.ActionInterceptor)findBeanInUIF2BeanFactory("cardInterceptor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.ActionContributors getToftpanelActionContributors(){
 if(context.get("toftpanelActionContributors")!=null)
 return (nc.ui.uif2.actions.ActionContributors)context.get("toftpanelActionContributors");
  nc.ui.uif2.actions.ActionContributors bean = new nc.ui.uif2.actions.ActionContributors();
  context.put("toftpanelActionContributors",bean);
  bean.setContributors(getManagedList6());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList6(){  List list = new ArrayList();  list.add(getActionsOfList());  list.add(getActionsOfCard());  return list;}

public nc.ui.uif2.actions.StandAloneToftPanelActionContainer getActionsOfList(){
 if(context.get("actionsOfList")!=null)
 return (nc.ui.uif2.actions.StandAloneToftPanelActionContainer)context.get("actionsOfList");
  nc.ui.uif2.actions.StandAloneToftPanelActionContainer bean = new nc.ui.uif2.actions.StandAloneToftPanelActionContainer(getList());  context.put("actionsOfList",bean);
  bean.setActions(getManagedList7());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList7(){  List list = new ArrayList();  list.add(getSaleOuteditAction());  list.add(getDeleteAction());  list.add(getCopyAction());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("queryAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("refreshAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("maintainMenu"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("signActionMenu"));  list.add(getRelatFunctionBrowseAction_OUT());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add(getLinkQryBrowseGroupAction());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("importExportAction"));  list.add(getPrintMngAction());  return list;}

public nc.ui.uif2.actions.StandAloneToftPanelActionContainer getActionsOfCard(){
 if(context.get("actionsOfCard")!=null)
 return (nc.ui.uif2.actions.StandAloneToftPanelActionContainer)context.get("actionsOfCard");
  nc.ui.uif2.actions.StandAloneToftPanelActionContainer bean = new nc.ui.uif2.actions.StandAloneToftPanelActionContainer(getCard());  context.put("actionsOfCard",bean);
  bean.setModel(getIcBizModel());
  bean.setActions(getManagedList8());
  bean.setEditActions(getManagedList9());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList8(){  List list = new ArrayList();  list.add(getSaleOuteditAction());  list.add(getDeleteAction());  list.add(getCopyAction());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("queryAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("refreshCardAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("maintainMenu"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("signActionMenu"));  list.add(getRelatFunctionBrowseAction_OUT());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add(getLinkQryBrowseGroupAction());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("importExportAction"));  list.add(getPrintMngAction());  return list;}

private List getManagedList9(){  List list = new ArrayList();  list.add(getSaveAction());  list.add(getSeparatorAction_38c16d());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("cancelAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("fetchAutoAction"));  list.add(getPickAutoAction());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("maintainMenu"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add(getLinkQryEditGroupAction());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("separatorAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("importExportAction"));  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_38c16d(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#38c16d")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#38c16d");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#38c16d",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.deal.SaleOutUIProcessorInfo getUIProcesorInfo(){
 if(context.get("UIProcesorInfo")!=null)
 return (nc.ui.ic.m4c.deal.SaleOutUIProcessorInfo)context.get("UIProcesorInfo");
  nc.ui.ic.m4c.deal.SaleOutUIProcessorInfo bean = new nc.ui.ic.m4c.deal.SaleOutUIProcessorInfo();
  context.put("UIProcesorInfo",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.deal.SaleOutBillScaleProcessor getScaleStrategy(){
 if(context.get("scaleStrategy")!=null)
 return (nc.ui.ic.m4c.deal.SaleOutBillScaleProcessor)context.get("scaleStrategy");
  nc.ui.ic.m4c.deal.SaleOutBillScaleProcessor bean = new nc.ui.ic.m4c.deal.SaleOutBillScaleProcessor();
  context.put("scaleStrategy",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.action.SaleOutSignAction getSignAction(){
 if(context.get("signAction")!=null)
 return (nc.ui.ic.m4c.action.SaleOutSignAction)context.get("signAction");
  nc.ui.ic.m4c.action.SaleOutSignAction bean = new nc.ui.ic.m4c.action.SaleOutSignAction();
  context.put("signAction",bean);
  bean.setModel(getIcBizModel());
  bean.setActionName("SIGN");
  bean.setFilledUpInFlow(false);
  bean.setEditor(getCard());
  bean.setBillForm(getCard());
  bean.setListView(getList());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.action.SaleOutSaveAction getSaveAction(){
 if(context.get("saveAction")!=null)
 return (nc.ui.ic.m4c.action.SaleOutSaveAction)context.get("saveAction");
  nc.ui.ic.m4c.action.SaleOutSaveAction bean = new nc.ui.ic.m4c.action.SaleOutSaveAction();
  context.put("saveAction",bean);
  bean.setModel(getIcBizModel());
  bean.setEditorModel((nc.ui.ic.pub.model.ICBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setEditor(getCard());
  bean.setActionName("WRITE");
  bean.setValidationService((nc.bs.uif2.validation.IValidationService)findBeanInUIF2BeanFactory("validateService"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.action.SaleOutDeleteAction getDeleteAction(){
 if(context.get("deleteAction")!=null)
 return (nc.ui.ic.m4c.action.SaleOutDeleteAction)context.get("deleteAction");
  nc.ui.ic.m4c.action.SaleOutDeleteAction bean = new nc.ui.ic.m4c.action.SaleOutDeleteAction();
  context.put("deleteAction",bean);
  bean.setModel(getIcBizModel());
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setEditor(getCard());
  bean.setActionName("DELETE");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.general.action.PickAutoAction getPickAutoAction(){
 if(context.get("pickAutoAction")!=null)
 return (nc.ui.ic.general.action.PickAutoAction)context.get("pickAutoAction");
  nc.ui.ic.general.action.PickAutoAction bean = new nc.ui.ic.general.action.PickAutoAction();
  context.put("pickAutoAction",bean);
  bean.setEditorModel((nc.ui.ic.general.model.ICGenBizEditorModel)findBeanInUIF2BeanFactory("icBizEditorModel"));
  bean.setBCalcMny(true);
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
  bean.setVoClassName("nc.vo.ic.m4c.entity.SaleOutVO");
  bean.setAutoShowUpComponent(getCard());
  bean.setQueryAction((nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction)findBeanInUIF2BeanFactory("queryAction"));
  bean.setProcessorMap(getManagedMap0());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private Map getManagedMap0(){  Map map = new HashMap();  map.put("40",getNtbInitProcessor_22e57a());  return map;}

private nc.ui.ic.general.view.NtbInitProcessor getNtbInitProcessor_22e57a(){
 if(context.get("nc.ui.ic.general.view.NtbInitProcessor#22e57a")!=null)
 return (nc.ui.ic.general.view.NtbInitProcessor)context.get("nc.ui.ic.general.view.NtbInitProcessor#22e57a");
  nc.ui.ic.general.view.NtbInitProcessor bean = new nc.ui.ic.general.view.NtbInitProcessor();
  context.put("nc.ui.ic.general.view.NtbInitProcessor#22e57a",bean);
  bean.setModel(getIcBizModel());
  bean.setQueryArea((nc.ui.uif2.actions.QueryAreaShell)findBeanInUIF2BeanFactory("queryArea"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.outbound.bizcheck.OutLinkQuery getOutLinkQuery(){
 if(context.get("outLinkQuery")!=null)
 return (nc.ui.ic.outbound.bizcheck.OutLinkQuery)context.get("outLinkQuery");
  nc.ui.ic.outbound.bizcheck.OutLinkQuery bean = new nc.ui.ic.outbound.bizcheck.OutLinkQuery();
  context.put("outLinkQuery",bean);
  bean.setVoClassName("nc.vo.ic.m4c.entity.SaleOutVO");
  bean.setModel(getIcBizModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.view.SaleOutBizBillListView getList(){
 if(context.get("list")!=null)
 return (nc.ui.ic.m4c.view.SaleOutBizBillListView)context.get("list");
  nc.ui.ic.m4c.view.SaleOutBizBillListView bean = new nc.ui.ic.m4c.view.SaleOutBizBillListView();
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

public nc.ui.ic.m4c.view.SaleOutBizView getCard(){
 if(context.get("card")!=null)
 return (nc.ui.ic.m4c.view.SaleOutBizView)context.get("card");
  nc.ui.ic.m4c.view.SaleOutBizView bean = new nc.ui.ic.m4c.view.SaleOutBizView();
  context.put("card",bean);
  bean.setModel(getIcBizModel());
  bean.setBarCodeInputPanel((nc.ui.ic.pub.view.BarCodeInputPanel)findBeanInUIF2BeanFactory("barcodecard"));
  bean.setTemplateContainer((nc.ui.uif2.editor.TemplateContainer)findBeanInUIF2BeanFactory("templateContainer"));
  bean.setTangramContainer(getContainer());
  bean.setUserdefitemPreparator((nc.ui.pub.bill.IBillData)findBeanInUIF2BeanFactory("userdefAndMarAsstCardPreparator"));
  bean.setAutoAddLine(false);
  bean.setTemplateNotNullValidate(true);
  bean.setBlankChildrenFilter(getSingleFieldBlankChildrenFilter_107b9fd());
  bean.setBodyLineActions(getManagedList10());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter getSingleFieldBlankChildrenFilter_107b9fd(){
 if(context.get("nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter#107b9fd")!=null)
 return (nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter)context.get("nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter#107b9fd");
  nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter bean = new nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter();
  context.put("nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter#107b9fd",bean);
  bean.setFieldName("cmaterialvid");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList10(){  List list = new ArrayList();  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyAddLineAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyInsertLineAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyDelLineAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyCopyLineAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyPasteLineAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyPasteToTailAction"));  list.add(getActionsBar_ActionsBarSeparator_43c6e9());  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("rearrangeRowNoBodyLineAction"));  list.add((javax.swing.Action)findBeanInUIF2BeanFactory("bodyLineEditAction"));  list.add(getActionsBar_ActionsBarSeparator_1b829b4());  list.add(getDefaultBodyZoomAction_1ba25d3());  return list;}

private nc.ui.pub.beans.ActionsBar.ActionsBarSeparator getActionsBar_ActionsBarSeparator_43c6e9(){
 if(context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#43c6e9")!=null)
 return (nc.ui.pub.beans.ActionsBar.ActionsBarSeparator)context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#43c6e9");
  nc.ui.pub.beans.ActionsBar.ActionsBarSeparator bean = new nc.ui.pub.beans.ActionsBar.ActionsBarSeparator();
  context.put("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#43c6e9",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pub.beans.ActionsBar.ActionsBarSeparator getActionsBar_ActionsBarSeparator_1b829b4(){
 if(context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1b829b4")!=null)
 return (nc.ui.pub.beans.ActionsBar.ActionsBarSeparator)context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1b829b4");
  nc.ui.pub.beans.ActionsBar.ActionsBarSeparator bean = new nc.ui.pub.beans.ActionsBar.ActionsBarSeparator();
  context.put("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1b829b4",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction getDefaultBodyZoomAction_1ba25d3(){
 if(context.get("nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction#1ba25d3")!=null)
 return (nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction)context.get("nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction#1ba25d3");
  nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction bean = new nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction();
  context.put("nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction#1ba25d3",bean);
  bean.setPos(1);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.ic.m4c.deal.SaleOutBillScaleProcessor getScalePrcStrategy(){
 if(context.get("scalePrcStrategy")!=null)
 return (nc.ui.ic.m4c.deal.SaleOutBillScaleProcessor)context.get("scalePrcStrategy");
  nc.ui.ic.m4c.deal.SaleOutBillScaleProcessor bean = new nc.ui.ic.m4c.deal.SaleOutBillScaleProcessor();
  context.put("scalePrcStrategy",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

}
