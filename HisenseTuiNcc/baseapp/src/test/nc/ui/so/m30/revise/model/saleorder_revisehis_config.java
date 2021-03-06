package nc.ui.so.m30.revise.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.ui.uif2.factory.AbstractJavaBeanDefinition;

public class saleorder_revisehis_config extends AbstractJavaBeanDefinition{
	private Map<String, Object> context = new HashMap();
public nc.vo.uif2.LoginContext getContext(){
 if(context.get("context")!=null)
 return (nc.vo.uif2.LoginContext)context.get("context");
  nc.vo.uif2.LoginContext bean = new nc.vo.uif2.LoginContext();
  context.put("context",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.value.AggVOMetaBDObjectAdapterFactory getBoadatorfactory(){
 if(context.get("boadatorfactory")!=null)
 return (nc.ui.pubapp.uif2app.view.value.AggVOMetaBDObjectAdapterFactory)context.get("boadatorfactory");
  nc.ui.pubapp.uif2app.view.value.AggVOMetaBDObjectAdapterFactory bean = new nc.ui.pubapp.uif2app.view.value.AggVOMetaBDObjectAdapterFactory();
  context.put("boadatorfactory",bean);
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
  nc.ui.pubapp.uif2app.actions.pagination.BillModelPaginationDelegator bean = new nc.ui.pubapp.uif2app.actions.pagination.BillModelPaginationDelegator(getManageAppModel());  context.put("pageDelegator",bean);
  bean.setPaginationQuery(getPageQuery());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.revise.model.SaleOrderRevisePageService getPageQuery(){
 if(context.get("pageQuery")!=null)
 return (nc.ui.so.m30.revise.model.SaleOrderRevisePageService)context.get("pageQuery");
  nc.ui.so.m30.revise.model.SaleOrderRevisePageService bean = new nc.ui.so.m30.revise.model.SaleOrderRevisePageService();
  context.put("pageQuery",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.revise.model.SaleOrderRevisePageMediator getPageMediator(){
 if(context.get("pageMediator")!=null)
 return (nc.ui.so.m30.revise.model.SaleOrderRevisePageMediator)context.get("pageMediator");
  nc.ui.so.m30.revise.model.SaleOrderRevisePageMediator bean = new nc.ui.so.m30.revise.model.SaleOrderRevisePageMediator();
  context.put("pageMediator",bean);
  bean.setNeedPage(false);
  bean.init();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.model.BillManageModel getManageAppModel(){
 if(context.get("ManageAppModel")!=null)
 return (nc.ui.pubapp.uif2app.model.BillManageModel)context.get("ManageAppModel");
  nc.ui.pubapp.uif2app.model.BillManageModel bean = new nc.ui.pubapp.uif2app.model.BillManageModel();
  context.put("ManageAppModel",bean);
  bean.setBusinessObjectAdapterFactory(getBoadatorfactory());
  bean.setContext(getContext());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.scmpub.page.model.SCMBillPageModelDataManager getModelDataManager(){
 if(context.get("modelDataManager")!=null)
 return (nc.ui.scmpub.page.model.SCMBillPageModelDataManager)context.get("modelDataManager");
  nc.ui.scmpub.page.model.SCMBillPageModelDataManager bean = new nc.ui.scmpub.page.model.SCMBillPageModelDataManager();
  context.put("modelDataManager",bean);
  bean.setModel(getManageAppModel());
  bean.setPageQuery(getPageQuery());
  bean.setPageDelegator(getPageDelegator());
  bean.setPagePanel(getListToolbarPnl());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.TemplateContainer getTemplateContainer(){
 if(context.get("templateContainer")!=null)
 return (nc.ui.uif2.editor.TemplateContainer)context.get("templateContainer");
  nc.ui.uif2.editor.TemplateContainer bean = new nc.ui.uif2.editor.TemplateContainer();
  context.put("templateContainer",bean);
  bean.setContext(getContext());
  bean.load();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.revise.lazilyload.M30ReviseDefaultBillLazilyLoader getBillLazilyLoader(){
 if(context.get("billLazilyLoader")!=null)
 return (nc.ui.so.m30.revise.lazilyload.M30ReviseDefaultBillLazilyLoader)context.get("billLazilyLoader");
  nc.ui.so.m30.revise.lazilyload.M30ReviseDefaultBillLazilyLoader bean = new nc.ui.so.m30.revise.lazilyload.M30ReviseDefaultBillLazilyLoader();
  context.put("billLazilyLoader",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager getLasilyLodadMediator(){
 if(context.get("LasilyLodadMediator")!=null)
 return (nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager)context.get("LasilyLodadMediator");
  nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager bean = new nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager();
  context.put("LasilyLodadMediator",bean);
  bean.setModel(getManageAppModel());
  bean.setLoader(getBillLazilyLoader());
  bean.setLazilyLoadSupporter(getManagedList0());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList0(){  List list = new ArrayList();  list.add(getCardPanelLazilyLoad_4b911a());  list.add(getListPanelLazilyLoad_1237ea2());  list.add(getActionLazilyLoad_14eec6c());  return list;}

private nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad getCardPanelLazilyLoad_4b911a(){
 if(context.get("nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad#4b911a")!=null)
 return (nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad)context.get("nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad#4b911a");
  nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad bean = new nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad();
  context.put("nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad#4b911a",bean);
  bean.setBillform(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad getListPanelLazilyLoad_1237ea2(){
 if(context.get("nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad#1237ea2")!=null)
 return (nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad)context.get("nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad#1237ea2");
  nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad bean = new nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad();
  context.put("nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad#1237ea2",bean);
  bean.setListView(getListView());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad getActionLazilyLoad_14eec6c(){
 if(context.get("nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad#14eec6c")!=null)
 return (nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad)context.get("nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad#14eec6c");
  nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad bean = new nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad();
  context.put("nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad#14eec6c",bean);
  bean.setModel(getManageAppModel());
  bean.setActionList(getManagedList1());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList1(){  List list = new ArrayList();  list.add(getPrintAction());  list.add(getPreviewAction());  list.add(getOutputAction());  list.add(getSplitPrintAction());  return list;}

public nc.ui.so.m30.billui.view.SaleOrderBillListView getListView(){
 if(context.get("listView")!=null)
 return (nc.ui.so.m30.billui.view.SaleOrderBillListView)context.get("listView");
  nc.ui.so.m30.billui.view.SaleOrderBillListView bean = new nc.ui.so.m30.billui.view.SaleOrderBillListView();
  context.put("listView",bean);
  bean.setModel(getManageAppModel());
  bean.setMultiSelectionMode(0);
  bean.setTemplateContainer(getTemplateContainer());
  bean.setUserdefitemListPreparator(getUserdefAndMarAsstListPreparator());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.view.CompositeBillListDataPrepare getUserdefAndMarAsstListPreparator(){
 if(context.get("userdefAndMarAsstListPreparator")!=null)
 return (nc.ui.pubapp.uif2app.view.CompositeBillListDataPrepare)context.get("userdefAndMarAsstListPreparator");
  nc.ui.pubapp.uif2app.view.CompositeBillListDataPrepare bean = new nc.ui.pubapp.uif2app.view.CompositeBillListDataPrepare();
  context.put("userdefAndMarAsstListPreparator",bean);
  bean.setBillListDataPrepares(getManagedList2());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList2(){  List list = new ArrayList();  list.add(getUserdefitemlistPreparator());  list.add(getMarAsstPreparator());  return list;}

public nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator getLinkQueryHyperlinkMediator(){
 if(context.get("linkQueryHyperlinkMediator")!=null)
 return (nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator)context.get("linkQueryHyperlinkMediator");
  nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator bean = new nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator();
  context.put("linkQueryHyperlinkMediator",bean);
  bean.setModel(getManageAppModel());
  bean.setSrcBillIdField("cfirstid");
  bean.setSrcBillNOField("vfirstcode");
  bean.setSrcBillTypeField("vfirsttype");
  bean.setSrcBillTypeFieldPos(1);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator getAlinkQueryHyperlinkMediator(){
 if(context.get("alinkQueryHyperlinkMediator")!=null)
 return (nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator)context.get("alinkQueryHyperlinkMediator");
  nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator bean = new nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator();
  context.put("alinkQueryHyperlinkMediator",bean);
  bean.setModel(getManageAppModel());
  bean.setSrcBillIdField("csrcid");
  bean.setSrcBillNOField("vsrccode");
  bean.setSrcBillTypeField("vsrctype");
  bean.setSrcBillTypeFieldPos(1);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator getBlinkQueryHyperlinkMediator(){
 if(context.get("blinkQueryHyperlinkMediator")!=null)
 return (nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator)context.get("blinkQueryHyperlinkMediator");
  nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator bean = new nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator();
  context.put("blinkQueryHyperlinkMediator",bean);
  bean.setModel(getManageAppModel());
  bean.setSrcBillIdField("cctmanageid");
  bean.setSrcBillNOField("vctcode");
  bean.setSrcBillTypeField("vsrctype");
  bean.setSrcBillTypeFieldPos(1);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.view.SaleOrderBillForm getBillFormEditor(){
 if(context.get("billFormEditor")!=null)
 return (nc.ui.so.m30.billui.view.SaleOrderBillForm)context.get("billFormEditor");
  nc.ui.so.m30.billui.view.SaleOrderBillForm bean = new nc.ui.so.m30.billui.view.SaleOrderBillForm();
  context.put("billFormEditor",bean);
  bean.setModel(getManageAppModel());
  bean.setTemplateContainer(getTemplateContainer());
  bean.setTemplateNotNullValidate(true);
  bean.setAutoAddLine(true);
  bean.setUserdefitemPreparator(getUserdefAndMarAsstCardPreparator());
  bean.setBlankChildrenFilter(getMultiFieldsBlankChildrenFilter_83e3a5());
  bean.setClearHyperlink(getManagedList5());
  bean.setBodyLineActions(getManagedList6());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.view.CompositeBillDataPrepare getUserdefAndMarAsstCardPreparator(){
 if(context.get("userdefAndMarAsstCardPreparator")!=null)
 return (nc.ui.pubapp.uif2app.view.CompositeBillDataPrepare)context.get("userdefAndMarAsstCardPreparator");
  nc.ui.pubapp.uif2app.view.CompositeBillDataPrepare bean = new nc.ui.pubapp.uif2app.view.CompositeBillDataPrepare();
  context.put("userdefAndMarAsstCardPreparator",bean);
  bean.setBillDataPrepares(getManagedList3());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList3(){  List list = new ArrayList();  list.add(getUserdefitemPreparator());  list.add(getMarAsstPreparator());  return list;}

private nc.ui.pubapp.uif2app.view.value.MultiFieldsBlankChildrenFilter getMultiFieldsBlankChildrenFilter_83e3a5(){
 if(context.get("nc.ui.pubapp.uif2app.view.value.MultiFieldsBlankChildrenFilter#83e3a5")!=null)
 return (nc.ui.pubapp.uif2app.view.value.MultiFieldsBlankChildrenFilter)context.get("nc.ui.pubapp.uif2app.view.value.MultiFieldsBlankChildrenFilter#83e3a5");
  nc.ui.pubapp.uif2app.view.value.MultiFieldsBlankChildrenFilter bean = new nc.ui.pubapp.uif2app.view.value.MultiFieldsBlankChildrenFilter();
  context.put("nc.ui.pubapp.uif2app.view.value.MultiFieldsBlankChildrenFilter#83e3a5",bean);
  bean.setFilterMap(getManagedMap0());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private Map getManagedMap0(){  Map map = new HashMap();  map.put("bodytable1",getManagedList4());  return map;}

private List getManagedList4(){  List list = new ArrayList();  list.add("cmaterialvid");  return list;}

private List getManagedList5(){  List list = new ArrayList();  list.add("vbillcode");  return list;}

private List getManagedList6(){  List list = new ArrayList();  list.add(getBodyAddLineAction_d6961d());  list.add(getBodyInsertLineAction_195cd0());  list.add(getSaleOrderReviseDelLineAction_11c5dca());  list.add(getBodyCopyLineAction_15187b4());  list.add(getSaleOrderRevisePasteLineAction_1a453b7());  list.add(getSaleOrderRevisePasteToTailAction_174446f());  list.add(getSeparatorAction());  list.add(getDefaultBodyZoomAction());  return list;}

private nc.ui.pubapp.uif2app.actions.BodyAddLineAction getBodyAddLineAction_d6961d(){
 if(context.get("nc.ui.pubapp.uif2app.actions.BodyAddLineAction#d6961d")!=null)
 return (nc.ui.pubapp.uif2app.actions.BodyAddLineAction)context.get("nc.ui.pubapp.uif2app.actions.BodyAddLineAction#d6961d");
  nc.ui.pubapp.uif2app.actions.BodyAddLineAction bean = new nc.ui.pubapp.uif2app.actions.BodyAddLineAction();
  context.put("nc.ui.pubapp.uif2app.actions.BodyAddLineAction#d6961d",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.BodyInsertLineAction getBodyInsertLineAction_195cd0(){
 if(context.get("nc.ui.pubapp.uif2app.actions.BodyInsertLineAction#195cd0")!=null)
 return (nc.ui.pubapp.uif2app.actions.BodyInsertLineAction)context.get("nc.ui.pubapp.uif2app.actions.BodyInsertLineAction#195cd0");
  nc.ui.pubapp.uif2app.actions.BodyInsertLineAction bean = new nc.ui.pubapp.uif2app.actions.BodyInsertLineAction();
  context.put("nc.ui.pubapp.uif2app.actions.BodyInsertLineAction#195cd0",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.so.m30.revise.action.line.SaleOrderReviseDelLineAction getSaleOrderReviseDelLineAction_11c5dca(){
 if(context.get("nc.ui.so.m30.revise.action.line.SaleOrderReviseDelLineAction#11c5dca")!=null)
 return (nc.ui.so.m30.revise.action.line.SaleOrderReviseDelLineAction)context.get("nc.ui.so.m30.revise.action.line.SaleOrderReviseDelLineAction#11c5dca");
  nc.ui.so.m30.revise.action.line.SaleOrderReviseDelLineAction bean = new nc.ui.so.m30.revise.action.line.SaleOrderReviseDelLineAction();
  context.put("nc.ui.so.m30.revise.action.line.SaleOrderReviseDelLineAction#11c5dca",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.BodyCopyLineAction getBodyCopyLineAction_15187b4(){
 if(context.get("nc.ui.pubapp.uif2app.actions.BodyCopyLineAction#15187b4")!=null)
 return (nc.ui.pubapp.uif2app.actions.BodyCopyLineAction)context.get("nc.ui.pubapp.uif2app.actions.BodyCopyLineAction#15187b4");
  nc.ui.pubapp.uif2app.actions.BodyCopyLineAction bean = new nc.ui.pubapp.uif2app.actions.BodyCopyLineAction();
  context.put("nc.ui.pubapp.uif2app.actions.BodyCopyLineAction#15187b4",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteLineAction getSaleOrderRevisePasteLineAction_1a453b7(){
 if(context.get("nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteLineAction#1a453b7")!=null)
 return (nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteLineAction)context.get("nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteLineAction#1a453b7");
  nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteLineAction bean = new nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteLineAction();
  context.put("nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteLineAction#1a453b7",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteToTailAction getSaleOrderRevisePasteToTailAction_174446f(){
 if(context.get("nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteToTailAction#174446f")!=null)
 return (nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteToTailAction)context.get("nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteToTailAction#174446f");
  nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteToTailAction bean = new nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteToTailAction();
  context.put("nc.ui.so.m30.revise.action.line.SaleOrderRevisePasteToTailAction#174446f",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.SeparatorAction getSeparatorAction(){
 if(context.get("separatorAction")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("separatorAction");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("separatorAction",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction getDefaultBodyZoomAction(){
 if(context.get("DefaultBodyZoomAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction)context.get("DefaultBodyZoomAction");
  nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction bean = new nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction();
  context.put("DefaultBodyZoomAction",bean);
  bean.setPos(1);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.MouseClickShowPanelMediator getMouseClickShowPanelMediator(){
 if(context.get("mouseClickShowPanelMediator")!=null)
 return (nc.ui.pubapp.uif2app.view.MouseClickShowPanelMediator)context.get("mouseClickShowPanelMediator");
  nc.ui.pubapp.uif2app.view.MouseClickShowPanelMediator bean = new nc.ui.pubapp.uif2app.view.MouseClickShowPanelMediator();
  context.put("mouseClickShowPanelMediator",bean);
  bean.setListView(getListView());
  bean.setShowUpComponent(getBillFormEditor());
  bean.setHyperLinkColumn("vbillcode");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor getFormInterceptor(){
 if(context.get("formInterceptor")!=null)
 return (nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor)context.get("formInterceptor");
  nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor bean = new nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor();
  context.put("formInterceptor",bean);
  bean.setShowUpComponent(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor getListInterceptor(){
 if(context.get("listInterceptor")!=null)
 return (nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor)context.get("listInterceptor");
  nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor bean = new nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor();
  context.put("listInterceptor",bean);
  bean.setShowUpComponent(getListView());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.scmpub.listener.BillCodeEditMediator getBillCodeMediator(){
 if(context.get("billCodeMediator")!=null)
 return (nc.ui.scmpub.listener.BillCodeEditMediator)context.get("billCodeMediator");
  nc.ui.scmpub.listener.BillCodeEditMediator bean = new nc.ui.scmpub.listener.BillCodeEditMediator();
  context.put("billCodeMediator",bean);
  bean.setBillCodeKey("vbillcode");
  bean.setBillType("30R");
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.FunNodeClosingHandler getClosingListener(){
 if(context.get("ClosingListener")!=null)
 return (nc.ui.uif2.FunNodeClosingHandler)context.get("ClosingListener");
  nc.ui.uif2.FunNodeClosingHandler bean = new nc.ui.uif2.FunNodeClosingHandler();
  context.put("ClosingListener",bean);
  bean.setModel(getManageAppModel());
  bean.setSaveaction(getSaveAction());
  bean.setCancelaction(getCancelAction());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener getInitDataListener(){
 if(context.get("InitDataListener")!=null)
 return (nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener)context.get("InitDataListener");
  nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener bean = new nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener();
  context.put("InitDataListener",bean);
  bean.setModel(getManageAppModel());
  bean.setVoClassName("nc.vo.so.m30.entity.SaleOrderVO");
  bean.setAutoShowUpComponent(getListView());
  bean.setProcessorMap(getManagedMap1());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private Map getManagedMap1(){  Map map = new HashMap();  map.put("19",getM30ReviseInitDataProcessor_ee17e4());  return map;}

private nc.ui.so.m30.revise.model.M30ReviseInitDataProcessor getM30ReviseInitDataProcessor_ee17e4(){
 if(context.get("nc.ui.so.m30.revise.model.M30ReviseInitDataProcessor#ee17e4")!=null)
 return (nc.ui.so.m30.revise.model.M30ReviseInitDataProcessor)context.get("nc.ui.so.m30.revise.model.M30ReviseInitDataProcessor#ee17e4");
  nc.ui.so.m30.revise.model.M30ReviseInitDataProcessor bean = new nc.ui.so.m30.revise.model.M30ReviseInitDataProcessor();
  context.put("nc.ui.so.m30.revise.model.M30ReviseInitDataProcessor#ee17e4",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.RowNoMediator getRowNoMediator(){
 if(context.get("rowNoMediator")!=null)
 return (nc.ui.pubapp.uif2app.view.RowNoMediator)context.get("rowNoMediator");
  nc.ui.pubapp.uif2app.view.RowNoMediator bean = new nc.ui.pubapp.uif2app.view.RowNoMediator();
  context.put("rowNoMediator",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.UserdefitemContainerPreparator getUserdefitemPreparator(){
 if(context.get("userdefitemPreparator")!=null)
 return (nc.ui.uif2.editor.UserdefitemContainerPreparator)context.get("userdefitemPreparator");
  nc.ui.uif2.editor.UserdefitemContainerPreparator bean = new nc.ui.uif2.editor.UserdefitemContainerPreparator();
  context.put("userdefitemPreparator",bean);
  bean.setContainer(getUserdefitemContainer());
  bean.setParams(getManagedList7());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList7(){  List list = new ArrayList();  list.add(getUserdefQueryParam_38e284());  list.add(getUserdefQueryParam_9f66ff());  return list;}

private nc.ui.uif2.editor.UserdefQueryParam getUserdefQueryParam_38e284(){
 if(context.get("nc.ui.uif2.editor.UserdefQueryParam#38e284")!=null)
 return (nc.ui.uif2.editor.UserdefQueryParam)context.get("nc.ui.uif2.editor.UserdefQueryParam#38e284");
  nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
  context.put("nc.ui.uif2.editor.UserdefQueryParam#38e284",bean);
  bean.setMdfullname("so.so_saleorder");
  bean.setPos(0);
  bean.setPrefix("vdef");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.editor.UserdefQueryParam getUserdefQueryParam_9f66ff(){
 if(context.get("nc.ui.uif2.editor.UserdefQueryParam#9f66ff")!=null)
 return (nc.ui.uif2.editor.UserdefQueryParam)context.get("nc.ui.uif2.editor.UserdefQueryParam#9f66ff");
  nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
  context.put("nc.ui.uif2.editor.UserdefQueryParam#9f66ff",bean);
  bean.setMdfullname("so.so_saleorder_b");
  bean.setPos(1);
  bean.setPrefix("vbdef");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.UserdefitemBillListDataPreparator getUserdefitemlistPreparator(){
 if(context.get("userdefitemlistPreparator")!=null)
 return (nc.ui.uif2.editor.UserdefitemBillListDataPreparator)context.get("userdefitemlistPreparator");
  nc.ui.uif2.editor.UserdefitemBillListDataPreparator bean = new nc.ui.uif2.editor.UserdefitemBillListDataPreparator(getContext());  context.put("userdefitemlistPreparator",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.material.assistant.MarAsstPreparator getMarAsstPreparator(){
 if(context.get("marAsstPreparator")!=null)
 return (nc.ui.pubapp.uif2app.view.material.assistant.MarAsstPreparator)context.get("marAsstPreparator");
  nc.ui.pubapp.uif2app.view.material.assistant.MarAsstPreparator bean = new nc.ui.pubapp.uif2app.view.material.assistant.MarAsstPreparator();
  context.put("marAsstPreparator",bean);
  bean.setModel(getManageAppModel());
  bean.setContainer(getUserdefitemContainer());
  bean.setPrefix("vfree");
  bean.setMaterialField("cmaterialid");
  bean.setProjectField("cprojectid");
  bean.setSupplierField("cvendorid");
  bean.setProductorField("cproductorid");
  bean.setSignatureField("cmffileid");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.userdefitem.UserDefItemContainer getUserdefitemContainer(){
 if(context.get("userdefitemContainer")!=null)
 return (nc.ui.uif2.userdefitem.UserDefItemContainer)context.get("userdefitemContainer");
  nc.ui.uif2.userdefitem.UserDefItemContainer bean = new nc.ui.uif2.userdefitem.UserDefItemContainer();
  context.put("userdefitemContainer",bean);
  bean.setContext(getContext());
  bean.setParams(getManagedList8());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList8(){  List list = new ArrayList();  list.add(getQueryParam_1230d6a());  list.add(getQueryParam_45c66d());  list.add(getQueryParam_e64e75());  return list;}

private nc.ui.uif2.userdefitem.QueryParam getQueryParam_1230d6a(){
 if(context.get("nc.ui.uif2.userdefitem.QueryParam#1230d6a")!=null)
 return (nc.ui.uif2.userdefitem.QueryParam)context.get("nc.ui.uif2.userdefitem.QueryParam#1230d6a");
  nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
  context.put("nc.ui.uif2.userdefitem.QueryParam#1230d6a",bean);
  bean.setMdfullname("so.orderhistory");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.userdefitem.QueryParam getQueryParam_45c66d(){
 if(context.get("nc.ui.uif2.userdefitem.QueryParam#45c66d")!=null)
 return (nc.ui.uif2.userdefitem.QueryParam)context.get("nc.ui.uif2.userdefitem.QueryParam#45c66d");
  nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
  context.put("nc.ui.uif2.userdefitem.QueryParam#45c66d",bean);
  bean.setMdfullname("so.orderhistory_b");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.userdefitem.QueryParam getQueryParam_e64e75(){
 if(context.get("nc.ui.uif2.userdefitem.QueryParam#e64e75")!=null)
 return (nc.ui.uif2.userdefitem.QueryParam)context.get("nc.ui.uif2.userdefitem.QueryParam#e64e75");
  nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
  context.put("nc.ui.uif2.userdefitem.QueryParam#e64e75",bean);
  bean.setRulecode("materialassistant");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.FractionFixMediator getFractionFixMediator(){
 if(context.get("fractionFixMediator")!=null)
 return (nc.ui.pubapp.uif2app.view.FractionFixMediator)context.get("fractionFixMediator");
  nc.ui.pubapp.uif2app.view.FractionFixMediator bean = new nc.ui.pubapp.uif2app.view.FractionFixMediator(getManagedList9(),getManagedList10());  context.put("fractionFixMediator",bean);
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList9(){  List list = new ArrayList();  list.add(getBillFormEditor());  return list;}

private List getManagedList10(){  List list = new ArrayList();  list.add(getListView());  return list;}

public nc.ui.pubapp.uif2app.model.BillBodySortMediator getBillBodySortMediator(){
 if(context.get("billBodySortMediator")!=null)
 return (nc.ui.pubapp.uif2app.model.BillBodySortMediator)context.get("billBodySortMediator");
  nc.ui.pubapp.uif2app.model.BillBodySortMediator bean = new nc.ui.pubapp.uif2app.model.BillBodySortMediator(getManageAppModel(),getBillFormEditor(),getListView());  context.put("billBodySortMediator",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.model.AppEventHandlerMediator getAppEventHandlerMediator(){
 if(context.get("appEventHandlerMediator")!=null)
 return (nc.ui.pubapp.uif2app.model.AppEventHandlerMediator)context.get("appEventHandlerMediator");
  nc.ui.pubapp.uif2app.model.AppEventHandlerMediator bean = new nc.ui.pubapp.uif2app.model.AppEventHandlerMediator();
  context.put("appEventHandlerMediator",bean);
  bean.setModel(getManageAppModel());
  bean.setHandlerMap(getManagedMap2());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private Map getManagedMap2(){  Map map = new HashMap();  map.put("nc.ui.pubapp.uif2app.event.card.CardHeadTailBeforeEditEvent",getManagedList11());  map.put("nc.ui.pubapp.uif2app.event.card.CardHeadTailAfterEditEvent",getManagedList12());  map.put("nc.ui.pubapp.uif2app.event.card.CardBodyBeforeEditEvent",getManagedList13());  map.put("nc.ui.pubapp.uif2app.event.card.CardBodyAfterEditEvent",getManagedList14());  map.put("nc.ui.pubapp.uif2app.event.card.CardBodyAfterRowEditEvent",getManagedList15());  map.put("nc.ui.pubapp.uif2app.event.OrgChangedEvent",getManagedList16());  return map;}

private List getManagedList11(){  List list = new ArrayList();  list.add(getReviseHeadBeforeEditHandler_28ff7b());  return list;}

private nc.ui.so.m30.revise.editor.headevent.ReviseHeadBeforeEditHandler getReviseHeadBeforeEditHandler_28ff7b(){
 if(context.get("nc.ui.so.m30.revise.editor.headevent.ReviseHeadBeforeEditHandler#28ff7b")!=null)
 return (nc.ui.so.m30.revise.editor.headevent.ReviseHeadBeforeEditHandler)context.get("nc.ui.so.m30.revise.editor.headevent.ReviseHeadBeforeEditHandler#28ff7b");
  nc.ui.so.m30.revise.editor.headevent.ReviseHeadBeforeEditHandler bean = new nc.ui.so.m30.revise.editor.headevent.ReviseHeadBeforeEditHandler();
  context.put("nc.ui.so.m30.revise.editor.headevent.ReviseHeadBeforeEditHandler#28ff7b",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList12(){  List list = new ArrayList();  list.add(getHeadAfterEditHandler_19d0a46());  return list;}

private nc.ui.so.m30.billui.editor.headevent.HeadAfterEditHandler getHeadAfterEditHandler_19d0a46(){
 if(context.get("nc.ui.so.m30.billui.editor.headevent.HeadAfterEditHandler#19d0a46")!=null)
 return (nc.ui.so.m30.billui.editor.headevent.HeadAfterEditHandler)context.get("nc.ui.so.m30.billui.editor.headevent.HeadAfterEditHandler#19d0a46");
  nc.ui.so.m30.billui.editor.headevent.HeadAfterEditHandler bean = new nc.ui.so.m30.billui.editor.headevent.HeadAfterEditHandler();
  context.put("nc.ui.so.m30.billui.editor.headevent.HeadAfterEditHandler#19d0a46",bean);
  bean.setBillform(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList13(){  List list = new ArrayList();  list.add(getReviseBodyBeforeEditHandler_10d9f6b());  return list;}

private nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyBeforeEditHandler getReviseBodyBeforeEditHandler_10d9f6b(){
 if(context.get("nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyBeforeEditHandler#10d9f6b")!=null)
 return (nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyBeforeEditHandler)context.get("nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyBeforeEditHandler#10d9f6b");
  nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyBeforeEditHandler bean = new nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyBeforeEditHandler();
  context.put("nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyBeforeEditHandler#10d9f6b",bean);
  bean.setBillform(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList14(){  List list = new ArrayList();  list.add(getReviseBodyAfterEditHandler_15d5da1());  return list;}

private nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyAfterEditHandler getReviseBodyAfterEditHandler_15d5da1(){
 if(context.get("nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyAfterEditHandler#15d5da1")!=null)
 return (nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyAfterEditHandler)context.get("nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyAfterEditHandler#15d5da1");
  nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyAfterEditHandler bean = new nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyAfterEditHandler();
  context.put("nc.ui.so.m30.revise.editor.bodyevent.ReviseBodyAfterEditHandler#15d5da1",bean);
  bean.setBillform(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList15(){  List list = new ArrayList();  list.add(getCardBodyAfterRowEditHandler_ae26f7());  return list;}

private nc.ui.so.m30.billui.editor.bodyevent.CardBodyAfterRowEditHandler getCardBodyAfterRowEditHandler_ae26f7(){
 if(context.get("nc.ui.so.m30.billui.editor.bodyevent.CardBodyAfterRowEditHandler#ae26f7")!=null)
 return (nc.ui.so.m30.billui.editor.bodyevent.CardBodyAfterRowEditHandler)context.get("nc.ui.so.m30.billui.editor.bodyevent.CardBodyAfterRowEditHandler#ae26f7");
  nc.ui.so.m30.billui.editor.bodyevent.CardBodyAfterRowEditHandler bean = new nc.ui.so.m30.billui.editor.bodyevent.CardBodyAfterRowEditHandler();
  context.put("nc.ui.so.m30.billui.editor.bodyevent.CardBodyAfterRowEditHandler#ae26f7",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList16(){  List list = new ArrayList();  list.add(getOrgEditHandler_1803f33());  return list;}

private nc.ui.so.m30.billui.editor.orgevent.OrgEditHandler getOrgEditHandler_1803f33(){
 if(context.get("nc.ui.so.m30.billui.editor.orgevent.OrgEditHandler#1803f33")!=null)
 return (nc.ui.so.m30.billui.editor.orgevent.OrgEditHandler)context.get("nc.ui.so.m30.billui.editor.orgevent.OrgEditHandler#1803f33");
  nc.ui.so.m30.billui.editor.orgevent.OrgEditHandler bean = new nc.ui.so.m30.billui.editor.orgevent.OrgEditHandler(getBillFormEditor(),getContext());  context.put("nc.ui.so.m30.billui.editor.orgevent.OrgEditHandler#1803f33",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.TangramContainer getContainer(){
 if(context.get("container")!=null)
 return (nc.ui.uif2.TangramContainer)context.get("container");
  nc.ui.uif2.TangramContainer bean = new nc.ui.uif2.TangramContainer();
  context.put("container",bean);
  bean.setTangramLayoutRoot(getTBNode_15e19c6());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.TBNode getTBNode_15e19c6(){
 if(context.get("nc.ui.uif2.tangramlayout.node.TBNode#15e19c6")!=null)
 return (nc.ui.uif2.tangramlayout.node.TBNode)context.get("nc.ui.uif2.tangramlayout.node.TBNode#15e19c6");
  nc.ui.uif2.tangramlayout.node.TBNode bean = new nc.ui.uif2.tangramlayout.node.TBNode();
  context.put("nc.ui.uif2.tangramlayout.node.TBNode#15e19c6",bean);
  bean.setShowMode("CardLayout");
  bean.setTabs(getManagedList17());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList17(){  List list = new ArrayList();  list.add(getVSNode_7e9e37());  list.add(getVSNode_1d0873a());  return list;}

private nc.ui.uif2.tangramlayout.node.VSNode getVSNode_7e9e37(){
 if(context.get("nc.ui.uif2.tangramlayout.node.VSNode#7e9e37")!=null)
 return (nc.ui.uif2.tangramlayout.node.VSNode)context.get("nc.ui.uif2.tangramlayout.node.VSNode#7e9e37");
  nc.ui.uif2.tangramlayout.node.VSNode bean = new nc.ui.uif2.tangramlayout.node.VSNode();
  context.put("nc.ui.uif2.tangramlayout.node.VSNode#7e9e37",bean);
  bean.setUp(getCNode_3e6b3b());
  bean.setDown(getCNode_9e1526());
  bean.setDividerLocation(25f);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_3e6b3b(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#3e6b3b")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#3e6b3b");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#3e6b3b",bean);
  bean.setComponent(getListToolbarPnl());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_9e1526(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#9e1526")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#9e1526");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#9e1526",bean);
  bean.setName(getI18nFB_1f1ff06());
  bean.setComponent(getListView());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1f1ff06(){
 if(context.get("nc.ui.uif2.I18nFB#1f1ff06")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1f1ff06");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1f1ff06",bean);  bean.setResDir("common");
  bean.setResId("UC001-0000107");
  bean.setDefaultValue("????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1f1ff06",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private nc.ui.uif2.tangramlayout.node.VSNode getVSNode_1d0873a(){
 if(context.get("nc.ui.uif2.tangramlayout.node.VSNode#1d0873a")!=null)
 return (nc.ui.uif2.tangramlayout.node.VSNode)context.get("nc.ui.uif2.tangramlayout.node.VSNode#1d0873a");
  nc.ui.uif2.tangramlayout.node.VSNode bean = new nc.ui.uif2.tangramlayout.node.VSNode();
  context.put("nc.ui.uif2.tangramlayout.node.VSNode#1d0873a",bean);
  bean.setUp(getCNode_c53f98());
  bean.setDown(getCNode_856596());
  bean.setDividerLocation(25f);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_c53f98(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#c53f98")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#c53f98");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#c53f98",bean);
  bean.setComponent(getCardToolbarPnl());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_856596(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#856596")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#856596");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#856596",bean);
  bean.setComponent(getBillFormEditor());
  bean.setName(getI18nFB_1d2500c());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1d2500c(){
 if(context.get("nc.ui.uif2.I18nFB#1d2500c")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1d2500c");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1d2500c",bean);  bean.setResDir("common");
  bean.setResId("UC001-0000106");
  bean.setDefaultValue("????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1d2500c",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pubapp.uif2app.tangramlayout.UEQueryAreaShell getQueryArea(){
 if(context.get("queryArea")!=null)
 return (nc.ui.pubapp.uif2app.tangramlayout.UEQueryAreaShell)context.get("queryArea");
  nc.ui.pubapp.uif2app.tangramlayout.UEQueryAreaShell bean = new nc.ui.pubapp.uif2app.tangramlayout.UEQueryAreaShell();
  context.put("queryArea",bean);
  bean.setQueryAreaCreator(getQueryAction());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel getListToolbarPnl(){
 if(context.get("listToolbarPnl")!=null)
 return (nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel)context.get("listToolbarPnl");
  nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel bean = new nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel();
  context.put("listToolbarPnl",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.view.SaleOrderUECardLayoutToolbarPanel getCardToolbarPnl(){
 if(context.get("cardToolbarPnl")!=null)
 return (nc.ui.so.m30.billui.view.SaleOrderUECardLayoutToolbarPanel)context.get("cardToolbarPnl");
  nc.ui.so.m30.billui.view.SaleOrderUECardLayoutToolbarPanel bean = new nc.ui.so.m30.billui.view.SaleOrderUECardLayoutToolbarPanel();
  context.put("cardToolbarPnl",bean);
  bean.setActions(getManagedList18());
  bean.setTitleAction(getReturnaction());
  bean.setModel(getManageAppModel());
  bean.setRightExActions(getManagedList19());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList18(){  List list = new ArrayList();  list.add(getFirstLineAction());  list.add(getPreLineAction());  list.add(getNextLineAction());  list.add(getLastLineAction());  return list;}

private nc.ui.uif2.actions.FirstLineAction getFirstLineAction(){
 if(context.get("firstLineAction")!=null)
 return (nc.ui.uif2.actions.FirstLineAction)context.get("firstLineAction");
  nc.ui.uif2.actions.FirstLineAction bean = new nc.ui.uif2.actions.FirstLineAction();
  context.put("firstLineAction",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.actions.PreLineAction getPreLineAction(){
 if(context.get("preLineAction")!=null)
 return (nc.ui.uif2.actions.PreLineAction)context.get("preLineAction");
  nc.ui.uif2.actions.PreLineAction bean = new nc.ui.uif2.actions.PreLineAction();
  context.put("preLineAction",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.actions.NextLineAction getNextLineAction(){
 if(context.get("nextLineAction")!=null)
 return (nc.ui.uif2.actions.NextLineAction)context.get("nextLineAction");
  nc.ui.uif2.actions.NextLineAction bean = new nc.ui.uif2.actions.NextLineAction();
  context.put("nextLineAction",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.actions.LastLineAction getLastLineAction(){
 if(context.get("lastLineAction")!=null)
 return (nc.ui.uif2.actions.LastLineAction)context.get("lastLineAction");
  nc.ui.uif2.actions.LastLineAction bean = new nc.ui.uif2.actions.LastLineAction();
  context.put("lastLineAction",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.UEReturnAction getReturnaction(){
 if(context.get("returnaction")!=null)
 return (nc.ui.pubapp.uif2app.actions.UEReturnAction)context.get("returnaction");
  nc.ui.pubapp.uif2app.actions.UEReturnAction bean = new nc.ui.pubapp.uif2app.actions.UEReturnAction();
  context.put("returnaction",bean);
  bean.setGoComponent(getListView());
  bean.setSaveAction(getSaveAction());
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList19(){  List list = new ArrayList();  list.add(getActionsBar_ActionsBarSeparator_82873d());  list.add(getHeadZoomAction());  return list;}

private nc.ui.pub.beans.ActionsBar.ActionsBarSeparator getActionsBar_ActionsBarSeparator_82873d(){
 if(context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#82873d")!=null)
 return (nc.ui.pub.beans.ActionsBar.ActionsBarSeparator)context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#82873d");
  nc.ui.pub.beans.ActionsBar.ActionsBarSeparator bean = new nc.ui.pub.beans.ActionsBar.ActionsBarSeparator();
  context.put("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#82873d",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.DefaultHeadZoomAction getHeadZoomAction(){
 if(context.get("headZoomAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.DefaultHeadZoomAction)context.get("headZoomAction");
  nc.ui.pubapp.uif2app.actions.DefaultHeadZoomAction bean = new nc.ui.pubapp.uif2app.actions.DefaultHeadZoomAction();
  context.put("headZoomAction",bean);
  bean.setBillForm(getBillFormEditor());
  bean.setModel(getManageAppModel());
  bean.setPos(0);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.components.widget.BesideWidget getBesidewidget(){
 if(context.get("besidewidget")!=null)
 return (nc.ui.uif2.components.widget.BesideWidget)context.get("besidewidget");
  nc.ui.uif2.components.widget.BesideWidget bean = new nc.ui.uif2.components.widget.BesideWidget();
  context.put("besidewidget",bean);
  bean.setBesideWidgetlets(getManagedList20());
  bean.setContext(getContext());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList20(){  List list = new ArrayList();  list.add(getCreditSideForm());  list.add(getPaySideForm());  list.add(getATPSideForm());  return list;}

public nc.ui.so.m30.billui.view.sideform.CreditSideForm getCreditSideForm(){
 if(context.get("creditSideForm")!=null)
 return (nc.ui.so.m30.billui.view.sideform.CreditSideForm)context.get("creditSideForm");
  nc.ui.so.m30.billui.view.sideform.CreditSideForm bean = new nc.ui.so.m30.billui.view.sideform.CreditSideForm();
  context.put("creditSideForm",bean);
  bean.setBillForm(getBillFormEditor());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.view.sideform.PaySideForm getPaySideForm(){
 if(context.get("paySideForm")!=null)
 return (nc.ui.so.m30.billui.view.sideform.PaySideForm)context.get("paySideForm");
  nc.ui.so.m30.billui.view.sideform.PaySideForm bean = new nc.ui.so.m30.billui.view.sideform.PaySideForm();
  context.put("paySideForm",bean);
  bean.setBillForm(getBillFormEditor());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.view.sideform.ATPSideForm getATPSideForm(){
 if(context.get("ATPSideForm")!=null)
 return (nc.ui.so.m30.billui.view.sideform.ATPSideForm)context.get("ATPSideForm");
  nc.ui.so.m30.billui.view.sideform.ATPSideForm bean = new nc.ui.so.m30.billui.view.sideform.ATPSideForm();
  context.put("ATPSideForm",bean);
  bean.setBillForm(getBillFormEditor());
  bean.setExceptionHandler(getExceptionHandler());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.view.sideform.SaleOrderSideFormMediator getSideFormMediator(){
 if(context.get("sideFormMediator")!=null)
 return (nc.ui.so.m30.billui.view.sideform.SaleOrderSideFormMediator)context.get("sideFormMediator");
  nc.ui.so.m30.billui.view.sideform.SaleOrderSideFormMediator bean = new nc.ui.so.m30.billui.view.sideform.SaleOrderSideFormMediator();
  context.put("sideFormMediator",bean);
  bean.setModel(getManageAppModel());
  bean.setCreditSideForm(getCreditSideForm());
  bean.setPaySideForm(getPaySideForm());
  bean.setAtpSideForm(getATPSideForm());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.ActionContributors getToftpanelActionContributors(){
 if(context.get("toftpanelActionContributors")!=null)
 return (nc.ui.uif2.actions.ActionContributors)context.get("toftpanelActionContributors");
  nc.ui.uif2.actions.ActionContributors bean = new nc.ui.uif2.actions.ActionContributors();
  context.put("toftpanelActionContributors",bean);
  bean.setContributors(getManagedList21());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList21(){  List list = new ArrayList();  list.add(getActionsOfList());  list.add(getActionsOfCard());  return list;}

public nc.ui.uif2.actions.StandAloneToftPanelActionContainer getActionsOfList(){
 if(context.get("actionsOfList")!=null)
 return (nc.ui.uif2.actions.StandAloneToftPanelActionContainer)context.get("actionsOfList");
  nc.ui.uif2.actions.StandAloneToftPanelActionContainer bean = new nc.ui.uif2.actions.StandAloneToftPanelActionContainer(getListView());  context.put("actionsOfList",bean);
  bean.setActions(getManagedList22());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList22(){  List list = new ArrayList();  list.add(getReturnAction());  return list;}

public nc.ui.uif2.actions.StandAloneToftPanelActionContainer getActionsOfCard(){
 if(context.get("actionsOfCard")!=null)
 return (nc.ui.uif2.actions.StandAloneToftPanelActionContainer)context.get("actionsOfCard");
  nc.ui.uif2.actions.StandAloneToftPanelActionContainer bean = new nc.ui.uif2.actions.StandAloneToftPanelActionContainer(getBillFormEditor());  context.put("actionsOfCard",bean);
  bean.setActions(getManagedList23());
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList23(){  List list = new ArrayList();  list.add(getReturnAction());  return list;}

public nc.ui.pubapp.uif2app.actions.AddMenuAction getAddMenu(){
 if(context.get("addMenu")!=null)
 return (nc.ui.pubapp.uif2app.actions.AddMenuAction)context.get("addMenu");
  nc.ui.pubapp.uif2app.actions.AddMenuAction bean = new nc.ui.pubapp.uif2app.actions.AddMenuAction();
  context.put("addMenu",bean);
  bean.setBillType("30R");
  bean.setActions(getManagedList24());
  bean.setModel(getManageAppModel());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList24(){  List list = new ArrayList();  list.add(getAddManualAction());  list.add(getAdd2AAction());  list.add(getAdd4310Action());  list.add(getAdd38Action());  list.add(getAdd4HAction());  return list;}

public nc.funcnode.ui.action.MenuAction getActionGroupgt3(){
 if(context.get("actionGroupgt3")!=null)
 return (nc.funcnode.ui.action.MenuAction)context.get("actionGroupgt3");
  nc.funcnode.ui.action.MenuAction bean = new nc.funcnode.ui.action.MenuAction();
  context.put("actionGroupgt3",bean);
  bean.setCode("gt3");
  bean.setName(getI18nFB_17ce74b());
  bean.setActions(getManagedList25());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_17ce74b(){
 if(context.get("nc.ui.uif2.I18nFB#17ce74b")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#17ce74b");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#17ce74b",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0400");
  bean.setDefaultValue("????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#17ce74b",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList25(){  List list = new ArrayList();  list.add(getTransInfoAction());  list.add(getPriceFormAction());  list.add(getSeparatorAction());  list.add(getDocManageAction());  return list;}

public nc.funcnode.ui.action.MenuAction getImportExportActionGroup(){
 if(context.get("importExportActionGroup")!=null)
 return (nc.funcnode.ui.action.MenuAction)context.get("importExportActionGroup");
  nc.funcnode.ui.action.MenuAction bean = new nc.funcnode.ui.action.MenuAction();
  context.put("importExportActionGroup",bean);
  bean.setCode("importExport");
  bean.setName(getI18nFB_134f9ff());
  bean.setTooltip(getI18nFB_1090113());
  bean.setActions(getManagedList26());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_134f9ff(){
 if(context.get("nc.ui.uif2.I18nFB#134f9ff")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#134f9ff");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#134f9ff",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0466");
  bean.setDefaultValue("????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#134f9ff",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private java.lang.String getI18nFB_1090113(){
 if(context.get("nc.ui.uif2.I18nFB#1090113")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1090113");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1090113",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0466");
  bean.setDefaultValue("????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1090113",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList26(){  List list = new ArrayList();  list.add(getDocManageAction());  return list;}

public nc.ui.so.m30.revise.action.M30ReviseEditAction getReviseAction(){
 if(context.get("reviseAction")!=null)
 return (nc.ui.so.m30.revise.action.M30ReviseEditAction)context.get("reviseAction");
  nc.ui.so.m30.revise.action.M30ReviseEditAction bean = new nc.ui.so.m30.revise.action.M30ReviseEditAction();
  context.put("reviseAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setInterceptor(getFormInterceptor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.GroupAction getOffsetActionGroup(){
 if(context.get("offsetActionGroup")!=null)
 return (nc.funcnode.ui.action.GroupAction)context.get("offsetActionGroup");
  nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
  context.put("offsetActionGroup",bean);
  bean.setCode("offsetFunc");
  bean.setName(getI18nFB_25b309());
  bean.setActions(getManagedList27());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_25b309(){
 if(context.get("nc.ui.uif2.I18nFB#25b309")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#25b309");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#25b309",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0467");
  bean.setDefaultValue("????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#25b309",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList27(){  List list = new ArrayList();  list.add(getOffsetAction());  list.add(getUnoffsetAction());  return list;}

public nc.ui.so.m30.billui.action.SaleOrderOffsetAction getOffsetAction(){
 if(context.get("offsetAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderOffsetAction)context.get("offsetAction");
  nc.ui.so.m30.billui.action.SaleOrderOffsetAction bean = new nc.ui.so.m30.billui.action.SaleOrderOffsetAction();
  context.put("offsetAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderUnOffsetAction getUnoffsetAction(){
 if(context.get("unoffsetAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderUnOffsetAction)context.get("unoffsetAction");
  nc.ui.so.m30.billui.action.SaleOrderUnOffsetAction bean = new nc.ui.so.m30.billui.action.SaleOrderUnOffsetAction();
  context.put("unoffsetAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderAddAction getAddManualAction(){
 if(context.get("addManualAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderAddAction)context.get("addManualAction");
  nc.ui.so.m30.billui.action.SaleOrderAddAction bean = new nc.ui.so.m30.billui.action.SaleOrderAddAction();
  context.put("addManualAction",bean);
  bean.setSourceBillType("MANUAL");
  bean.setSourceBillName(getI18nFB_10d1c27());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setInterceptor(getFormInterceptor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_10d1c27(){
 if(context.get("nc.ui.uif2.I18nFB#10d1c27")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#10d1c27");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#10d1c27",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0393");
  bean.setDefaultValue("????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#10d1c27",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pubapp.billref.dest.DefaultBillDataLogic getTransferLogic(){
 if(context.get("transferLogic")!=null)
 return (nc.ui.pubapp.billref.dest.DefaultBillDataLogic)context.get("transferLogic");
  nc.ui.pubapp.billref.dest.DefaultBillDataLogic bean = new nc.ui.pubapp.billref.dest.DefaultBillDataLogic();
  context.put("transferLogic",bean);
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.billref.dest.TransferBillViewProcessor getTransferProcessor(){
 if(context.get("transferProcessor")!=null)
 return (nc.ui.pubapp.billref.dest.TransferBillViewProcessor)context.get("transferProcessor");
  nc.ui.pubapp.billref.dest.TransferBillViewProcessor bean = new nc.ui.pubapp.billref.dest.TransferBillViewProcessor();
  context.put("transferProcessor",bean);
  bean.setList(getListView());
  bean.setActionContainer(getContainer());
  bean.setTransferLogic(getTransferLogic());
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderAddFromZ3Action getAdd2AAction(){
 if(context.get("add2AAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderAddFromZ3Action)context.get("add2AAction");
  nc.ui.so.m30.billui.action.SaleOrderAddFromZ3Action bean = new nc.ui.so.m30.billui.action.SaleOrderAddFromZ3Action();
  context.put("add2AAction",bean);
  bean.setSourceBillType("Z3");
  bean.setSourceBillName(getI18nFB_1b35250());
  bean.setFlowBillType(false);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferBillViewProcessor(getTransferProcessorforZ3());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1b35250(){
 if(context.get("nc.ui.uif2.I18nFB#1b35250")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1b35250");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1b35250",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0394");
  bean.setDefaultValue("????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1b35250",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.so.m30.billui.tranferbill.M30RefZ3TransferBillDataLogic getTransferLogicforZ3(){
 if(context.get("transferLogicforZ3")!=null)
 return (nc.ui.so.m30.billui.tranferbill.M30RefZ3TransferBillDataLogic)context.get("transferLogicforZ3");
  nc.ui.so.m30.billui.tranferbill.M30RefZ3TransferBillDataLogic bean = new nc.ui.so.m30.billui.tranferbill.M30RefZ3TransferBillDataLogic();
  context.put("transferLogicforZ3",bean);
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.billref.dest.TransferBillViewProcessor getTransferProcessorforZ3(){
 if(context.get("transferProcessorforZ3")!=null)
 return (nc.ui.pubapp.billref.dest.TransferBillViewProcessor)context.get("transferProcessorforZ3");
  nc.ui.pubapp.billref.dest.TransferBillViewProcessor bean = new nc.ui.pubapp.billref.dest.TransferBillViewProcessor();
  context.put("transferProcessorforZ3",bean);
  bean.setList(getListView());
  bean.setActionContainer(getContainer());
  bean.setTransferLogic(getTransferLogicforZ3());
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderAddFrom4310Action getAdd4310Action(){
 if(context.get("add4310Action")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderAddFrom4310Action)context.get("add4310Action");
  nc.ui.so.m30.billui.action.SaleOrderAddFrom4310Action bean = new nc.ui.so.m30.billui.action.SaleOrderAddFrom4310Action();
  context.put("add4310Action",bean);
  bean.setSourceBillType("4310");
  bean.setSourceBillName(getI18nFB_1e1409b());
  bean.setFlowBillType(false);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferBillViewProcessor(getTransferProcessorfor4310());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1e1409b(){
 if(context.get("nc.ui.uif2.I18nFB#1e1409b")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1e1409b");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1e1409b",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0395");
  bean.setDefaultValue("??????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1e1409b",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.so.m30.billui.tranferbill.M30Ref4310TransferBillDataLogic getTransferLogicfor4310(){
 if(context.get("transferLogicfor4310")!=null)
 return (nc.ui.so.m30.billui.tranferbill.M30Ref4310TransferBillDataLogic)context.get("transferLogicfor4310");
  nc.ui.so.m30.billui.tranferbill.M30Ref4310TransferBillDataLogic bean = new nc.ui.so.m30.billui.tranferbill.M30Ref4310TransferBillDataLogic();
  context.put("transferLogicfor4310",bean);
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.billref.dest.TransferBillViewProcessor getTransferProcessorfor4310(){
 if(context.get("transferProcessorfor4310")!=null)
 return (nc.ui.pubapp.billref.dest.TransferBillViewProcessor)context.get("transferProcessorfor4310");
  nc.ui.pubapp.billref.dest.TransferBillViewProcessor bean = new nc.ui.pubapp.billref.dest.TransferBillViewProcessor();
  context.put("transferProcessorfor4310",bean);
  bean.setList(getListView());
  bean.setActionContainer(getContainer());
  bean.setTransferLogic(getTransferLogicfor4310());
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderAddFrom38Action getAdd38Action(){
 if(context.get("add38Action")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderAddFrom38Action)context.get("add38Action");
  nc.ui.so.m30.billui.action.SaleOrderAddFrom38Action bean = new nc.ui.so.m30.billui.action.SaleOrderAddFrom38Action();
  context.put("add38Action",bean);
  bean.setSourceBillType("38");
  bean.setSourceBillName(getI18nFB_158b772());
  bean.setFlowBillType(false);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferBillViewProcessor(getTransferProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_158b772(){
 if(context.get("nc.ui.uif2.I18nFB#158b772")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#158b772");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#158b772",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0396");
  bean.setDefaultValue("??????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#158b772",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.so.m30.billui.action.SaleOrderAddFrom4HAction getAdd4HAction(){
 if(context.get("add4HAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderAddFrom4HAction)context.get("add4HAction");
  nc.ui.so.m30.billui.action.SaleOrderAddFrom4HAction bean = new nc.ui.so.m30.billui.action.SaleOrderAddFrom4HAction();
  context.put("add4HAction",bean);
  bean.setSourceBillType("4H");
  bean.setSourceBillName(getI18nFB_173a643());
  bean.setFlowBillType(false);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferBillViewProcessor(getTransferProcessorfor4H());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_173a643(){
 if(context.get("nc.ui.uif2.I18nFB#173a643")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#173a643");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#173a643",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0397");
  bean.setDefaultValue("??????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#173a643",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.so.m30.billui.tranferbill.M30Ref4HTransferBillDataLogic getTransferLogicfor4H(){
 if(context.get("transferLogicfor4H")!=null)
 return (nc.ui.so.m30.billui.tranferbill.M30Ref4HTransferBillDataLogic)context.get("transferLogicfor4H");
  nc.ui.so.m30.billui.tranferbill.M30Ref4HTransferBillDataLogic bean = new nc.ui.so.m30.billui.tranferbill.M30Ref4HTransferBillDataLogic();
  context.put("transferLogicfor4H",bean);
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.billref.dest.TransferBillViewProcessor getTransferProcessorfor4H(){
 if(context.get("transferProcessorfor4H")!=null)
 return (nc.ui.pubapp.billref.dest.TransferBillViewProcessor)context.get("transferProcessorfor4H");
  nc.ui.pubapp.billref.dest.TransferBillViewProcessor bean = new nc.ui.pubapp.billref.dest.TransferBillViewProcessor();
  context.put("transferProcessorfor4H",bean);
  bean.setList(getListView());
  bean.setActionContainer(getContainer());
  bean.setTransferLogic(getTransferLogicfor4H());
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.view.SaleOrderQueryDLGInitializer getQueryDLGInitializer(){
 if(context.get("queryDLGInitializer")!=null)
 return (nc.ui.so.m30.billui.view.SaleOrderQueryDLGInitializer)context.get("queryDLGInitializer");
  nc.ui.so.m30.billui.view.SaleOrderQueryDLGInitializer bean = new nc.ui.so.m30.billui.view.SaleOrderQueryDLGInitializer();
  context.put("queryDLGInitializer",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.QueryTemplateContainer getQueryTemplateContainer(){
 if(context.get("queryTemplateContainer")!=null)
 return (nc.ui.uif2.editor.QueryTemplateContainer)context.get("queryTemplateContainer");
  nc.ui.uif2.editor.QueryTemplateContainer bean = new nc.ui.uif2.editor.QueryTemplateContainer();
  context.put("queryTemplateContainer",bean);
  bean.setContext(getContext());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction getQueryAction(){
 if(context.get("queryAction")!=null)
 return (nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction)context.get("queryAction");
  nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction bean = new nc.ui.pubapp.uif2app.query2.action.DefaultQueryAction();
  context.put("queryAction",bean);
  bean.setModel(getManageAppModel());
  bean.setDataManager(getModelDataManager());
  bean.setQryCondDLGInitializer(getQueryDLGInitializer());
  bean.setTemplateContainer(getQueryTemplateContainer());
  bean.setInterceptor(getListInterceptor());
  bean.setShowUpComponent(getListView());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderEditAction getEditAction(){
 if(context.get("editAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderEditAction)context.get("editAction");
  nc.ui.so.m30.billui.action.SaleOrderEditAction bean = new nc.ui.so.m30.billui.action.SaleOrderEditAction();
  context.put("editAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setInterceptor(getFormInterceptor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderDeleteAction getDeleteAction(){
 if(context.get("deleteAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderDeleteAction)context.get("deleteAction");
  nc.ui.so.m30.billui.action.SaleOrderDeleteAction bean = new nc.ui.so.m30.billui.action.SaleOrderDeleteAction();
  context.put("deleteAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setActionName("DELETE");
  bean.setBillType("30R");
  bean.setValidationService(getPowerdeletevalidservice());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.pub.power.PowerValidateService getPowerdeletevalidservice(){
 if(context.get("powerdeletevalidservice")!=null)
 return (nc.ui.pubapp.pub.power.PowerValidateService)context.get("powerdeletevalidservice");
  nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
  context.put("powerdeletevalidservice",bean);
  bean.setActionCode("delete");
  bean.setBillCodeFiledName("vbillcode");
  bean.setPermissionCode("30R");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.revise.action.M30ReviseSaveAction getSaveAction(){
 if(context.get("saveAction")!=null)
 return (nc.ui.so.m30.revise.action.M30ReviseSaveAction)context.get("saveAction");
  nc.ui.so.m30.revise.action.M30ReviseSaveAction bean = new nc.ui.so.m30.revise.action.M30ReviseSaveAction();
  context.put("saveAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setActionName("REVISEWRITE");
  bean.setBillType("30R");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderSaveAndSendAction getSaveandsendApproveAction(){
 if(context.get("saveandsendApproveAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderSaveAndSendAction)context.get("saveandsendApproveAction");
  nc.ui.so.m30.billui.action.SaleOrderSaveAndSendAction bean = new nc.ui.so.m30.billui.action.SaleOrderSaveAndSendAction(getSaveAction(),getSendApproveAction());  context.put("saveandsendApproveAction",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.pub.power.PowerSaveValidateService getPowerwritevalidservice(){
 if(context.get("powerwritevalidservice")!=null)
 return (nc.ui.pubapp.pub.power.PowerSaveValidateService)context.get("powerwritevalidservice");
  nc.ui.pubapp.pub.power.PowerSaveValidateService bean = new nc.ui.pubapp.pub.power.PowerSaveValidateService();
  context.put("powerwritevalidservice",bean);
  bean.setInsertActionCode("insert");
  bean.setEditActionCode("edit");
  bean.setBillCodeFiledName("vbillcode");
  bean.setPermissionCode("30R");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderCancelAction getCancelAction(){
 if(context.get("cancelAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderCancelAction)context.get("cancelAction");
  nc.ui.so.m30.billui.action.SaleOrderCancelAction bean = new nc.ui.so.m30.billui.action.SaleOrderCancelAction();
  context.put("cancelAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction getListRefreshAction(){
 if(context.get("listRefreshAction")!=null)
 return (nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction)context.get("listRefreshAction");
  nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction bean = new nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction();
  context.put("listRefreshAction",bean);
  bean.setDataManager(getModelDataManager());
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.revise.action.M30ReviseRefreshSingleAction getCardRefreshAction(){
 if(context.get("cardRefreshAction")!=null)
 return (nc.ui.so.m30.revise.action.M30ReviseRefreshSingleAction)context.get("cardRefreshAction");
  nc.ui.so.m30.revise.action.M30ReviseRefreshSingleAction bean = new nc.ui.so.m30.revise.action.M30ReviseRefreshSingleAction();
  context.put("cardRefreshAction",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.GroupAction getSendActionGroup(){
 if(context.get("sendActionGroup")!=null)
 return (nc.funcnode.ui.action.GroupAction)context.get("sendActionGroup");
  nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
  context.put("sendActionGroup",bean);
  bean.setActions(getManagedList28());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList28(){  List list = new ArrayList();  list.add(getSendApproveAction());  list.add(getUnsendApproveAction());  return list;}

public nc.ui.so.m30.revise.action.M30ReviseSendApproveAction getSendApproveAction(){
 if(context.get("sendApproveAction")!=null)
 return (nc.ui.so.m30.revise.action.M30ReviseSendApproveAction)context.get("sendApproveAction");
  nc.ui.so.m30.revise.action.M30ReviseSendApproveAction bean = new nc.ui.so.m30.revise.action.M30ReviseSendApproveAction();
  context.put("sendApproveAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setFilledUpInFlow(true);
  bean.setActionName("SAVE");
  bean.setBillType("30R");
  bean.setValidationService(getPowersendappvalidservice());
  bean.setTpaProgressUtil(getTpaprogressutil());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.components.progress.TPAProgressUtil getTpaprogressutil(){
 if(context.get("tpaprogressutil")!=null)
 return (nc.ui.uif2.components.progress.TPAProgressUtil)context.get("tpaprogressutil");
  nc.ui.uif2.components.progress.TPAProgressUtil bean = new nc.ui.uif2.components.progress.TPAProgressUtil();
  context.put("tpaprogressutil",bean);
  bean.setContext(getContext());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.pub.power.PowerValidateService getPowersendappvalidservice(){
 if(context.get("powersendappvalidservice")!=null)
 return (nc.ui.pubapp.pub.power.PowerValidateService)context.get("powersendappvalidservice");
  nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
  context.put("powersendappvalidservice",bean);
  bean.setActionCode("commit");
  bean.setBillCodeFiledName("vbillcode");
  bean.setPermissionCode("30R");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.revise.action.M30ReviseUnSendApproveAction getUnsendApproveAction(){
 if(context.get("unsendApproveAction")!=null)
 return (nc.ui.so.m30.revise.action.M30ReviseUnSendApproveAction)context.get("unsendApproveAction");
  nc.ui.so.m30.revise.action.M30ReviseUnSendApproveAction bean = new nc.ui.so.m30.revise.action.M30ReviseUnSendApproveAction();
  context.put("unsendApproveAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setFilledUpInFlow(true);
  bean.setActionName("UNSAVE");
  bean.setBillType("30R");
  bean.setValidationService(getPowerunsendappvalidservice());
  bean.setTpaProgressUtil(getTpaprogressutil());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.pub.power.PowerValidateService getPowerunsendappvalidservice(){
 if(context.get("powerunsendappvalidservice")!=null)
 return (nc.ui.pubapp.pub.power.PowerValidateService)context.get("powerunsendappvalidservice");
  nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
  context.put("powerunsendappvalidservice",bean);
  bean.setActionCode("uncommit");
  bean.setBillCodeFiledName("vbillcode");
  bean.setPermissionCode("30R");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.GroupAction getApproveActionGroup(){
 if(context.get("approveActionGroup")!=null)
 return (nc.funcnode.ui.action.GroupAction)context.get("approveActionGroup");
  nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
  context.put("approveActionGroup",bean);
  bean.setActions(getManagedList29());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList29(){  List list = new ArrayList();  list.add(getApproveAction());  list.add(getUnApproveAction());  list.add(getQueryAuditFlowAction());  return list;}

public nc.ui.so.m30.revise.action.M30ReviseApproveAction getApproveAction(){
 if(context.get("approveAction")!=null)
 return (nc.ui.so.m30.revise.action.M30ReviseApproveAction)context.get("approveAction");
  nc.ui.so.m30.revise.action.M30ReviseApproveAction bean = new nc.ui.so.m30.revise.action.M30ReviseApproveAction();
  context.put("approveAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setFilledUpInFlow(true);
  bean.setActionName("APPROVE");
  bean.setBillType("30R");
  bean.setValidationService(getPowerapprovevalidservice());
  bean.setTpaProgressUtil(getTpaprogressutil());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.pub.power.PowerValidateService getPowerapprovevalidservice(){
 if(context.get("powerapprovevalidservice")!=null)
 return (nc.ui.pubapp.pub.power.PowerValidateService)context.get("powerapprovevalidservice");
  nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
  context.put("powerapprovevalidservice",bean);
  bean.setActionCode("approve");
  bean.setBillCodeFiledName("vbillcode");
  bean.setPermissionCode("30R");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.revise.action.M30ReviseUnApproveAction getUnApproveAction(){
 if(context.get("unApproveAction")!=null)
 return (nc.ui.so.m30.revise.action.M30ReviseUnApproveAction)context.get("unApproveAction");
  nc.ui.so.m30.revise.action.M30ReviseUnApproveAction bean = new nc.ui.so.m30.revise.action.M30ReviseUnApproveAction();
  context.put("unApproveAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setFilledUpInFlow(true);
  bean.setActionName("UNAPPROVE");
  bean.setBillType("30R");
  bean.setValidationService(getPowerunapprovevalidservice());
  bean.setTpaProgressUtil(getTpaprogressutil());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.pub.power.PowerValidateService getPowerunapprovevalidservice(){
 if(context.get("powerunapprovevalidservice")!=null)
 return (nc.ui.pubapp.pub.power.PowerValidateService)context.get("powerunapprovevalidservice");
  nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
  context.put("powerunapprovevalidservice",bean);
  bean.setActionCode("unapprove");
  bean.setBillCodeFiledName("vbillcode");
  bean.setPermissionCode("30R");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.link.QueryAuditFlowAction getQueryAuditFlowAction(){
 if(context.get("QueryAuditFlowAction")!=null)
 return (nc.ui.so.m30.billui.action.link.QueryAuditFlowAction)context.get("QueryAuditFlowAction");
  nc.ui.so.m30.billui.action.link.QueryAuditFlowAction bean = new nc.ui.so.m30.billui.action.link.QueryAuditFlowAction();
  context.put("QueryAuditFlowAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderCopyAction getCopyAction(){
 if(context.get("copyAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderCopyAction)context.get("copyAction");
  nc.ui.so.m30.billui.action.SaleOrderCopyAction bean = new nc.ui.so.m30.billui.action.SaleOrderCopyAction();
  context.put("copyAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setInterceptor(getFormInterceptor());
  bean.setCopyActionProcessor(getCopyActionProcessor_1a8a58f());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.so.m30.billui.action.CopyActionProcessor getCopyActionProcessor_1a8a58f(){
 if(context.get("nc.ui.so.m30.billui.action.CopyActionProcessor#1a8a58f")!=null)
 return (nc.ui.so.m30.billui.action.CopyActionProcessor)context.get("nc.ui.so.m30.billui.action.CopyActionProcessor#1a8a58f");
  nc.ui.so.m30.billui.action.CopyActionProcessor bean = new nc.ui.so.m30.billui.action.CopyActionProcessor();
  context.put("nc.ui.so.m30.billui.action.CopyActionProcessor#1a8a58f",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderGatheringAction getActiont2(){
 if(context.get("actiont2")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderGatheringAction)context.get("actiont2");
  nc.ui.so.m30.billui.action.SaleOrderGatheringAction bean = new nc.ui.so.m30.billui.action.SaleOrderGatheringAction();
  context.put("actiont2",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderReceiveVerifyAction getActiont3(){
 if(context.get("actiont3")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderReceiveVerifyAction)context.get("actiont3");
  nc.ui.so.m30.billui.action.SaleOrderReceiveVerifyAction bean = new nc.ui.so.m30.billui.action.SaleOrderReceiveVerifyAction();
  context.put("actiont3",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderSendArrangeAction getSendArrange(){
 if(context.get("sendArrange")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderSendArrangeAction)context.get("sendArrange");
  nc.ui.so.m30.billui.action.SaleOrderSendArrangeAction bean = new nc.ui.so.m30.billui.action.SaleOrderSendArrangeAction();
  context.put("sendArrange",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderBHArrangeAction getBHArrange(){
 if(context.get("BHArrange")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderBHArrangeAction)context.get("BHArrange");
  nc.ui.so.m30.billui.action.SaleOrderBHArrangeAction bean = new nc.ui.so.m30.billui.action.SaleOrderBHArrangeAction();
  context.put("BHArrange",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderZYArrangeAction getZYArrange(){
 if(context.get("ZYArrange")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderZYArrangeAction)context.get("ZYArrange");
  nc.ui.so.m30.billui.action.SaleOrderZYArrangeAction bean = new nc.ui.so.m30.billui.action.SaleOrderZYArrangeAction();
  context.put("ZYArrange",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.MenuAction getActionGroupgt2(){
 if(context.get("actionGroupgt2")!=null)
 return (nc.funcnode.ui.action.MenuAction)context.get("actionGroupgt2");
  nc.funcnode.ui.action.MenuAction bean = new nc.funcnode.ui.action.MenuAction();
  context.put("actionGroupgt2",bean);
  bean.setCode("gt2");
  bean.setName(getI18nFB_10d857a());
  bean.setActions(getManagedList30());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_10d857a(){
 if(context.get("nc.ui.uif2.I18nFB#10d857a")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#10d857a");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#10d857a",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0399");
  bean.setDefaultValue("????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#10d857a",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList30(){  List list = new ArrayList();  list.add(getSendArrange());  list.add(getBHArrange());  list.add(getZYArrange());  return list;}

public nc.ui.so.m30.billui.action.assist.FreezeAction getActiont7(){
 if(context.get("actiont7")!=null)
 return (nc.ui.so.m30.billui.action.assist.FreezeAction)context.get("actiont7");
  nc.ui.so.m30.billui.action.assist.FreezeAction bean = new nc.ui.so.m30.billui.action.assist.FreezeAction();
  context.put("actiont7",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.assist.UnFreezeAction getActiont8(){
 if(context.get("actiont8")!=null)
 return (nc.ui.so.m30.billui.action.assist.UnFreezeAction)context.get("actiont8");
  nc.ui.so.m30.billui.action.assist.UnFreezeAction bean = new nc.ui.so.m30.billui.action.assist.UnFreezeAction();
  context.put("actiont8",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.assist.SaleOrderCloseAction getCloseAction(){
 if(context.get("closeAction")!=null)
 return (nc.ui.so.m30.billui.action.assist.SaleOrderCloseAction)context.get("closeAction");
  nc.ui.so.m30.billui.action.assist.SaleOrderCloseAction bean = new nc.ui.so.m30.billui.action.assist.SaleOrderCloseAction();
  context.put("closeAction",bean);
  bean.setModel(getManageAppModel());
  bean.setSingleBillService(getM30CloseBillCloseService_b62ced());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.so.m30.closemanage.model.M30CloseBillCloseService getM30CloseBillCloseService_b62ced(){
 if(context.get("nc.ui.so.m30.closemanage.model.M30CloseBillCloseService#b62ced")!=null)
 return (nc.ui.so.m30.closemanage.model.M30CloseBillCloseService)context.get("nc.ui.so.m30.closemanage.model.M30CloseBillCloseService#b62ced");
  nc.ui.so.m30.closemanage.model.M30CloseBillCloseService bean = new nc.ui.so.m30.closemanage.model.M30CloseBillCloseService();
  context.put("nc.ui.so.m30.closemanage.model.M30CloseBillCloseService#b62ced",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.assist.SaleOrderReverseAction getActiont10(){
 if(context.get("actiont10")!=null)
 return (nc.ui.so.m30.billui.action.assist.SaleOrderReverseAction)context.get("actiont10");
  nc.ui.so.m30.billui.action.assist.SaleOrderReverseAction bean = new nc.ui.so.m30.billui.action.assist.SaleOrderReverseAction();
  context.put("actiont10",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setListView(getListView());
  bean.setRefreshAction(getCardRefreshAction());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.assist.TransInfoAction getTransInfoAction(){
 if(context.get("TransInfoAction")!=null)
 return (nc.ui.so.m30.billui.action.assist.TransInfoAction)context.get("TransInfoAction");
  nc.ui.so.m30.billui.action.assist.TransInfoAction bean = new nc.ui.so.m30.billui.action.assist.TransInfoAction();
  context.put("TransInfoAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.assist.SaleOrderPushTo21Action getActiont12(){
 if(context.get("actiont12")!=null)
 return (nc.ui.so.m30.billui.action.assist.SaleOrderPushTo21Action)context.get("actiont12");
  nc.ui.so.m30.billui.action.assist.SaleOrderPushTo21Action bean = new nc.ui.so.m30.billui.action.assist.SaleOrderPushTo21Action();
  context.put("actiont12",bean);
  bean.setSourceBillName(getI18nFB_3f842d());
  bean.setFlowBillType(false);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_3f842d(){
 if(context.get("nc.ui.uif2.I18nFB#3f842d")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#3f842d");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#3f842d",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0464");
  bean.setDefaultValue("????????????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#3f842d",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.so.m30.billui.tranferbill.M30RefCoop21TransferBillDataLogic getTransferLogicforCoop21(){
 if(context.get("transferLogicforCoop21")!=null)
 return (nc.ui.so.m30.billui.tranferbill.M30RefCoop21TransferBillDataLogic)context.get("transferLogicforCoop21");
  nc.ui.so.m30.billui.tranferbill.M30RefCoop21TransferBillDataLogic bean = new nc.ui.so.m30.billui.tranferbill.M30RefCoop21TransferBillDataLogic();
  context.put("transferLogicforCoop21",bean);
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.billref.dest.TransferBillViewProcessor getTransferProcessorforCoop21(){
 if(context.get("transferProcessorforCoop21")!=null)
 return (nc.ui.pubapp.billref.dest.TransferBillViewProcessor)context.get("transferProcessorforCoop21");
  nc.ui.pubapp.billref.dest.TransferBillViewProcessor bean = new nc.ui.pubapp.billref.dest.TransferBillViewProcessor();
  context.put("transferProcessorforCoop21",bean);
  bean.setList(getListView());
  bean.setActionContainer(getContainer());
  bean.setTransferLogic(getTransferLogicforCoop21());
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.assist.SaleOrderRefCoop21Action getRefCoop21Action(){
 if(context.get("refCoop21Action")!=null)
 return (nc.ui.so.m30.billui.action.assist.SaleOrderRefCoop21Action)context.get("refCoop21Action");
  nc.ui.so.m30.billui.action.assist.SaleOrderRefCoop21Action bean = new nc.ui.so.m30.billui.action.assist.SaleOrderRefCoop21Action();
  context.put("refCoop21Action",bean);
  bean.setSourceBillType("21");
  bean.setSourceBillName(getI18nFB_1febaff());
  bean.setFlowBillType(false);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferBillViewProcessor(getTransferProcessorforCoop21());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1febaff(){
 if(context.get("nc.ui.uif2.I18nFB#1febaff")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1febaff");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1febaff",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0401");
  bean.setDefaultValue("????????????????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1febaff",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.so.m30.billui.tranferbill.M30Ref30TransferBillDataLogic getTransferLogicforwithdraw(){
 if(context.get("transferLogicforwithdraw")!=null)
 return (nc.ui.so.m30.billui.tranferbill.M30Ref30TransferBillDataLogic)context.get("transferLogicforwithdraw");
  nc.ui.so.m30.billui.tranferbill.M30Ref30TransferBillDataLogic bean = new nc.ui.so.m30.billui.tranferbill.M30Ref30TransferBillDataLogic();
  context.put("transferLogicforwithdraw",bean);
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.billref.dest.TransferBillViewProcessor getTransferProcessorforwithdraw(){
 if(context.get("transferProcessorforwithdraw")!=null)
 return (nc.ui.pubapp.billref.dest.TransferBillViewProcessor)context.get("transferProcessorforwithdraw");
  nc.ui.pubapp.billref.dest.TransferBillViewProcessor bean = new nc.ui.pubapp.billref.dest.TransferBillViewProcessor();
  context.put("transferProcessorforwithdraw",bean);
  bean.setList(getListView());
  bean.setActionContainer(getContainer());
  bean.setTransferLogic(getTransferLogicforwithdraw());
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.assist.ReturnSaleOrderAddFrom30Action getReturnSaleOrderAction(){
 if(context.get("ReturnSaleOrderAction")!=null)
 return (nc.ui.so.m30.billui.action.assist.ReturnSaleOrderAddFrom30Action)context.get("ReturnSaleOrderAction");
  nc.ui.so.m30.billui.action.assist.ReturnSaleOrderAddFrom30Action bean = new nc.ui.so.m30.billui.action.assist.ReturnSaleOrderAddFrom30Action();
  context.put("ReturnSaleOrderAction",bean);
  bean.setSourceBillType("30R");
  bean.setSourceBillName(getI18nFB_a6ed9c());
  bean.setFlowBillType(false);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferBillViewProcessor(getTransferProcessorforwithdraw());
  bean.setInterceptor(getFormInterceptor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_a6ed9c(){
 if(context.get("nc.ui.uif2.I18nFB#a6ed9c")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#a6ed9c");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#a6ed9c",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0402");
  bean.setDefaultValue("????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#a6ed9c",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.so.m30.billui.tranferbill.M30Ref4CTransferBillDataLogic getTransferLogicforsaleout(){
 if(context.get("transferLogicforsaleout")!=null)
 return (nc.ui.so.m30.billui.tranferbill.M30Ref4CTransferBillDataLogic)context.get("transferLogicforsaleout");
  nc.ui.so.m30.billui.tranferbill.M30Ref4CTransferBillDataLogic bean = new nc.ui.so.m30.billui.tranferbill.M30Ref4CTransferBillDataLogic();
  context.put("transferLogicforsaleout",bean);
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.billref.dest.TransferBillViewProcessor getTransferProcessorforsaleout(){
 if(context.get("transferProcessorforsaleout")!=null)
 return (nc.ui.pubapp.billref.dest.TransferBillViewProcessor)context.get("transferProcessorforsaleout");
  nc.ui.pubapp.billref.dest.TransferBillViewProcessor bean = new nc.ui.pubapp.billref.dest.TransferBillViewProcessor();
  context.put("transferProcessorforsaleout",bean);
  bean.setList(getListView());
  bean.setActionContainer(getContainer());
  bean.setTransferLogic(getTransferLogicforsaleout());
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.assist.ReturnSaleOrderAddFrom4CAction getReturnSaleOutAction(){
 if(context.get("ReturnSaleOutAction")!=null)
 return (nc.ui.so.m30.billui.action.assist.ReturnSaleOrderAddFrom4CAction)context.get("ReturnSaleOutAction");
  nc.ui.so.m30.billui.action.assist.ReturnSaleOrderAddFrom4CAction bean = new nc.ui.so.m30.billui.action.assist.ReturnSaleOrderAddFrom4CAction();
  context.put("ReturnSaleOutAction",bean);
  bean.setSourceBillType("4C");
  bean.setSourceBillName(getI18nFB_139aa6f());
  bean.setFlowBillType(false);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferBillViewProcessor(getTransferProcessorforsaleout());
  bean.setInterceptor(getFormInterceptor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_139aa6f(){
 if(context.get("nc.ui.uif2.I18nFB#139aa6f")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#139aa6f");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#139aa6f",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0465");
  bean.setDefaultValue("??????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#139aa6f",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.so.m30.billui.action.assist.SaleOrderPriceFormAction getPriceFormAction(){
 if(context.get("priceFormAction")!=null)
 return (nc.ui.so.m30.billui.action.assist.SaleOrderPriceFormAction)context.get("priceFormAction");
  nc.ui.so.m30.billui.action.assist.SaleOrderPriceFormAction bean = new nc.ui.so.m30.billui.action.assist.SaleOrderPriceFormAction();
  context.put("priceFormAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setListview(getListView());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.pub.actions.SOManageDocumentAction getDocManageAction(){
 if(context.get("docManageAction")!=null)
 return (nc.ui.so.pub.actions.SOManageDocumentAction)context.get("docManageAction");
  nc.ui.so.pub.actions.SOManageDocumentAction bean = new nc.ui.so.pub.actions.SOManageDocumentAction();
  context.put("docManageAction",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.revise.action.SaleReviseLinkQueryAction getLinkQueryAction(){
 if(context.get("LinkQueryAction")!=null)
 return (nc.ui.so.m30.revise.action.SaleReviseLinkQueryAction)context.get("LinkQueryAction");
  nc.ui.so.m30.revise.action.SaleReviseLinkQueryAction bean = new nc.ui.so.m30.revise.action.SaleReviseLinkQueryAction();
  context.put("LinkQueryAction",bean);
  bean.setModel(getManageAppModel());
  bean.setBillType("30R");
  bean.setOpenMode(1);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.revise.action.M30ReviseHistoryAction getReviseHistoryAction(){
 if(context.get("ReviseHistoryAction")!=null)
 return (nc.ui.so.m30.revise.action.M30ReviseHistoryAction)context.get("ReviseHistoryAction");
  nc.ui.so.m30.revise.action.M30ReviseHistoryAction bean = new nc.ui.so.m30.revise.action.M30ReviseHistoryAction();
  context.put("ReviseHistoryAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.link.QueryCustInfoAction getQueryCustInfo(){
 if(context.get("QueryCustInfo")!=null)
 return (nc.ui.so.m30.billui.action.link.QueryCustInfoAction)context.get("QueryCustInfo");
  nc.ui.so.m30.billui.action.link.QueryCustInfoAction bean = new nc.ui.so.m30.billui.action.link.QueryCustInfoAction();
  context.put("QueryCustInfo",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.link.SaleOrderProfitAction getCrossProfitRptAction(){
 if(context.get("CrossProfitRptAction")!=null)
 return (nc.ui.so.m30.billui.action.link.SaleOrderProfitAction)context.get("CrossProfitRptAction");
  nc.ui.so.m30.billui.action.link.SaleOrderProfitAction bean = new nc.ui.so.m30.billui.action.link.SaleOrderProfitAction();
  context.put("CrossProfitRptAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.link.QueryExecInfoAction getQueryExecInfoAction(){
 if(context.get("QueryExecInfoAction")!=null)
 return (nc.ui.so.m30.billui.action.link.QueryExecInfoAction)context.get("QueryExecInfoAction");
  nc.ui.so.m30.billui.action.link.QueryExecInfoAction bean = new nc.ui.so.m30.billui.action.link.QueryExecInfoAction();
  context.put("QueryExecInfoAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.MenuAction getActionGroupgt4(){
 if(context.get("actionGroupgt4")!=null)
 return (nc.funcnode.ui.action.MenuAction)context.get("actionGroupgt4");
  nc.funcnode.ui.action.MenuAction bean = new nc.funcnode.ui.action.MenuAction();
  context.put("actionGroupgt4",bean);
  bean.setCode("gt4");
  bean.setName(getI18nFB_e480ea());
  bean.setActions(getManagedList31());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_e480ea(){
 if(context.get("nc.ui.uif2.I18nFB#e480ea")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#e480ea");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#e480ea",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0392");
  bean.setDefaultValue("????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#e480ea",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList31(){  List list = new ArrayList();  list.add(getLinkQueryAction());  list.add(getReviseHistoryAction());  list.add(getQueryOnhandAction());  list.add(getCreditQueryAction());  list.add(getQueryCustInfo());  list.add(getCrossProfitRptAction());  list.add(getQueryExecInfoAction());  return list;}

public nc.ui.so.m30.billui.action.printaction.SaleOrderPreviewAction getPreviewAction(){
 if(context.get("previewAction")!=null)
 return (nc.ui.so.m30.billui.action.printaction.SaleOrderPreviewAction)context.get("previewAction");
  nc.ui.so.m30.billui.action.printaction.SaleOrderPreviewAction bean = new nc.ui.so.m30.billui.action.printaction.SaleOrderPreviewAction();
  context.put("previewAction",bean);
  bean.setPreview(true);
  bean.setModel(getManageAppModel());
  bean.setBeforePrintDataProcess(getPrintProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.printaction.SaleOrderPrintAction getPrintAction(){
 if(context.get("printAction")!=null)
 return (nc.ui.so.m30.billui.action.printaction.SaleOrderPrintAction)context.get("printAction");
  nc.ui.so.m30.billui.action.printaction.SaleOrderPrintAction bean = new nc.ui.so.m30.billui.action.printaction.SaleOrderPrintAction();
  context.put("printAction",bean);
  bean.setPreview(false);
  bean.setModel(getManageAppModel());
  bean.setBeforePrintDataProcess(getPrintProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.printaction.SaleOrderPrintProcessor getPrintProcessor(){
 if(context.get("printProcessor")!=null)
 return (nc.ui.so.m30.billui.action.printaction.SaleOrderPrintProcessor)context.get("printProcessor");
  nc.ui.so.m30.billui.action.printaction.SaleOrderPrintProcessor bean = new nc.ui.so.m30.billui.action.printaction.SaleOrderPrintProcessor();
  context.put("printProcessor",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.scmpub.action.SCMPrintCountQueryAction getPrintCountQueryAction(){
 if(context.get("printCountQueryAction")!=null)
 return (nc.ui.scmpub.action.SCMPrintCountQueryAction)context.get("printCountQueryAction");
  nc.ui.scmpub.action.SCMPrintCountQueryAction bean = new nc.ui.scmpub.action.SCMPrintCountQueryAction();
  context.put("printCountQueryAction",bean);
  bean.setModel(getManageAppModel());
  bean.setBilldateFieldName("dbilldate");
  bean.setBillType("30R");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.printaction.SaleOrderSplitPrintAction getSplitPrintAction(){
 if(context.get("SplitPrintAction")!=null)
 return (nc.ui.so.m30.billui.action.printaction.SaleOrderSplitPrintAction)context.get("SplitPrintAction");
  nc.ui.so.m30.billui.action.printaction.SaleOrderSplitPrintAction bean = new nc.ui.so.m30.billui.action.printaction.SaleOrderSplitPrintAction();
  context.put("SplitPrintAction",bean);
  bean.setModel(getManageAppModel());
  bean.setPrintAction(getPrintAction());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.GroupAction getActionGroupgt5(){
 if(context.get("actionGroupgt5")!=null)
 return (nc.funcnode.ui.action.GroupAction)context.get("actionGroupgt5");
  nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
  context.put("actionGroupgt5",bean);
  bean.setCode("gt5");
  bean.setName(getI18nFB_1cbaa16());
  bean.setActions(getManagedList32());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1cbaa16(){
 if(context.get("nc.ui.uif2.I18nFB#1cbaa16")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1cbaa16");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1cbaa16",bean);  bean.setResDir("common");
  bean.setResId("UC001-0000007");
  bean.setDefaultValue("????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1cbaa16",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList32(){  List list = new ArrayList();  list.add(getPrintAction());  list.add(getPreviewAction());  list.add(getOutputAction());  list.add(getSeparatorAction());  list.add(getSplitPrintAction());  list.add(getPrintCountQueryAction());  return list;}

public nc.ui.pubapp.uif2app.actions.OutputAction getOutputAction(){
 if(context.get("outputAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.OutputAction)context.get("outputAction");
  nc.ui.pubapp.uif2app.actions.OutputAction bean = new nc.ui.pubapp.uif2app.actions.OutputAction();
  context.put("outputAction",bean);
  bean.setModel(getManageAppModel());
  bean.setParent(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderFindPriceAction getFindPriceAction(){
 if(context.get("findPriceAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderFindPriceAction)context.get("findPriceAction");
  nc.ui.so.m30.billui.action.SaleOrderFindPriceAction bean = new nc.ui.so.m30.billui.action.SaleOrderFindPriceAction();
  context.put("findPriceAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderLargessApportionAction getLargessApportionAction(){
 if(context.get("LargessApportionAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderLargessApportionAction)context.get("LargessApportionAction");
  nc.ui.so.m30.billui.action.SaleOrderLargessApportionAction bean = new nc.ui.so.m30.billui.action.SaleOrderLargessApportionAction();
  context.put("LargessApportionAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.SaleOrderUndoLargessApportionAction getUndoLargessApportionAction(){
 if(context.get("UndoLargessApportionAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderUndoLargessApportionAction)context.get("UndoLargessApportionAction");
  nc.ui.so.m30.billui.action.SaleOrderUndoLargessApportionAction bean = new nc.ui.so.m30.billui.action.SaleOrderUndoLargessApportionAction();
  context.put("UndoLargessApportionAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.MenuAction getActionGroupgt6(){
 if(context.get("actionGroupgt6")!=null)
 return (nc.funcnode.ui.action.MenuAction)context.get("actionGroupgt6");
  nc.funcnode.ui.action.MenuAction bean = new nc.funcnode.ui.action.MenuAction();
  context.put("actionGroupgt6",bean);
  bean.setCode("gt6");
  bean.setName(getI18nFB_ba1d7());
  bean.setActions(getManagedList33());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_ba1d7(){
 if(context.get("nc.ui.uif2.I18nFB#ba1d7")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#ba1d7");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#ba1d7",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0400");
  bean.setDefaultValue("????????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#ba1d7",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList33(){  List list = new ArrayList();  list.add(getFindPriceAction());  list.add(getPriceFormAction());  list.add(getFeatureSelectAction());  return list;}

public nc.ui.so.m30.billui.action.SaleOrderFeatureSelectAction getFeatureSelectAction(){
 if(context.get("featureSelectAction")!=null)
 return (nc.ui.so.m30.billui.action.SaleOrderFeatureSelectAction)context.get("featureSelectAction");
  nc.ui.so.m30.billui.action.SaleOrderFeatureSelectAction bean = new nc.ui.so.m30.billui.action.SaleOrderFeatureSelectAction();
  context.put("featureSelectAction",bean);
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.pub.actions.SOQueryOnhandAction getQueryOnhandAction(){
 if(context.get("queryOnhandAction")!=null)
 return (nc.ui.so.pub.actions.SOQueryOnhandAction)context.get("queryOnhandAction");
  nc.ui.so.pub.actions.SOQueryOnhandAction bean = new nc.ui.so.pub.actions.SOQueryOnhandAction();
  context.put("queryOnhandAction",bean);
  bean.setCard(getBillFormEditor());
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.so.m30.billui.action.link.SaleOrderCreditQueryAction getCreditQueryAction(){
 if(context.get("creditQueryAction")!=null)
 return (nc.ui.so.m30.billui.action.link.SaleOrderCreditQueryAction)context.get("creditQueryAction");
  nc.ui.so.m30.billui.action.link.SaleOrderCreditQueryAction bean = new nc.ui.so.m30.billui.action.link.SaleOrderCreditQueryAction();
  context.put("creditQueryAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.MenuAction getActionGroupgt7(){
 if(context.get("actionGroupgt7")!=null)
 return (nc.funcnode.ui.action.MenuAction)context.get("actionGroupgt7");
  nc.funcnode.ui.action.MenuAction bean = new nc.funcnode.ui.action.MenuAction();
  context.put("actionGroupgt7",bean);
  bean.setCode("gt7");
  bean.setName(getI18nFB_1ae358f());
  bean.setActions(getManagedList34());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1ae358f(){
 if(context.get("nc.ui.uif2.I18nFB#1ae358f")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1ae358f");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1ae358f",bean);  bean.setResDir("4006011_0");
  bean.setResId("04006011-0392");
  bean.setDefaultValue("????");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1ae358f",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList34(){  List list = new ArrayList();  list.add(getQueryOnhandAction());  list.add(getCreditQueryAction());  list.add(getQueryCustInfo());  list.add(getCrossProfitRptAction());  list.add(getQueryExecInfoAction());  return list;}

public nc.ui.uif2.DefaultExceptionHanler getExceptionHandler(){
 if(context.get("exceptionHandler")!=null)
 return (nc.ui.uif2.DefaultExceptionHanler)context.get("exceptionHandler");
  nc.ui.uif2.DefaultExceptionHanler bean = new nc.ui.uif2.DefaultExceptionHanler();
  context.put("exceptionHandler",bean);
  bean.setContext(getContext());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller getRemoteCallCombinatorCaller(){
 if(context.get("remoteCallCombinatorCaller")!=null)
 return (nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller)context.get("remoteCallCombinatorCaller");
  nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller bean = new nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller();
  context.put("remoteCallCombinatorCaller",bean);
  bean.setRemoteCallers(getManagedList35());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList35(){  List list = new ArrayList();  list.add(getQueryTemplateContainer());  list.add(getTemplateContainer());  list.add(getUserdefitemContainer());  return list;}

public nc.ui.so.m30.revise.action.M30ReviseReturnAction getReturnAction(){
 if(context.get("returnAction")!=null)
 return (nc.ui.so.m30.revise.action.M30ReviseReturnAction)context.get("returnAction");
  nc.ui.so.m30.revise.action.M30ReviseReturnAction bean = new nc.ui.so.m30.revise.action.M30ReviseReturnAction();
  context.put("returnAction",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

}
