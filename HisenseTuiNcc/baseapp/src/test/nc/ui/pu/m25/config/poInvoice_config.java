package nc.ui.pu.m25.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.ui.uif2.factory.AbstractJavaBeanDefinition;

public class poInvoice_config extends AbstractJavaBeanDefinition{
	private Map<String, Object> context = new HashMap();
public nc.ui.pu.m25.action.InvoiceQueryAction getQueryAction(){
 if(context.get("queryAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceQueryAction)context.get("queryAction");
  nc.ui.pu.m25.action.InvoiceQueryAction bean = new nc.ui.pu.m25.action.InvoiceQueryAction();
  context.put("queryAction",bean);
  bean.setModel(getManageAppModel());
  bean.setDataManager(getModelDataManager());
  bean.setQryCondDLGInitializer(getInvoiceQryCondDLGInitializer());
  bean.setShowUpComponent(getListView());
  bean.setTemplateContainer(getQueryTemplateContainer());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.query.InvoiceQryCondDlgInitializer getInvoiceQryCondDLGInitializer(){
 if(context.get("invoiceQryCondDLGInitializer")!=null)
 return (nc.ui.pu.m25.query.InvoiceQryCondDlgInitializer)context.get("invoiceQryCondDLGInitializer");
  nc.ui.pu.m25.query.InvoiceQryCondDlgInitializer bean = new nc.ui.pu.m25.query.InvoiceQryCondDlgInitializer();
  context.put("invoiceQryCondDLGInitializer",bean);
  bean.setModel(getManageAppModel());
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

public nc.ui.pu.m25.action.InvoiceRefreshSingleAction getCardRefreshAction(){
 if(context.get("cardRefreshAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceRefreshSingleAction)context.get("cardRefreshAction");
  nc.ui.pu.m25.action.InvoiceRefreshSingleAction bean = new nc.ui.pu.m25.action.InvoiceRefreshSingleAction();
  context.put("cardRefreshAction",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceEditAction getEditAction(){
 if(context.get("editAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceEditAction)context.get("editAction");
  nc.ui.pu.m25.action.InvoiceEditAction bean = new nc.ui.pu.m25.action.InvoiceEditAction();
  context.put("editAction",bean);
  bean.setModel(getManageAppModel());
  bean.setInterceptor(getShowUpComponentInterceptor_11c7f45());
  bean.setPowercheck(true);
  bean.setPermissioncode("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor getShowUpComponentInterceptor_11c7f45(){
 if(context.get("nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#11c7f45")!=null)
 return (nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor)context.get("nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#11c7f45");
  nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor bean = new nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor();
  context.put("nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#11c7f45",bean);
  bean.setShowUpComponent(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceDeleteAction getDeleteAction(){
 if(context.get("deleteAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceDeleteAction)context.get("deleteAction");
  nc.ui.pu.m25.action.InvoiceDeleteAction bean = new nc.ui.pu.m25.action.InvoiceDeleteAction();
  context.put("deleteAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setActionName("DISCARD");
  bean.setBillType("25");
  bean.setValidationService(getPowerDeleteValidService());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.pub.power.PowerValidateService getPowerDeleteValidService(){
 if(context.get("powerDeleteValidService")!=null)
 return (nc.ui.pubapp.pub.power.PowerValidateService)context.get("powerDeleteValidService");
  nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
  context.put("powerDeleteValidService",bean);
  bean.setActionCode("delete");
  bean.setBillCodeFiledName("vbillcode");
  bean.setPermissionCode("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.processor.CopyActionProcessor getCopyActionProcessor(){
 if(context.get("copyActionProcessor")!=null)
 return (nc.ui.pu.m25.action.processor.CopyActionProcessor)context.get("copyActionProcessor");
  nc.ui.pu.m25.action.processor.CopyActionProcessor bean = new nc.ui.pu.m25.action.processor.CopyActionProcessor();
  context.put("copyActionProcessor",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceCopyAction getCopyAction(){
 if(context.get("copyAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceCopyAction)context.get("copyAction");
  nc.ui.pu.m25.action.InvoiceCopyAction bean = new nc.ui.pu.m25.action.InvoiceCopyAction();
  context.put("copyAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setInterceptor(getFormInterceptor());
  bean.setCopyActionProcessor(getCopyActionProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceSaveAction getSaveAction(){
 if(context.get("saveAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceSaveAction)context.get("saveAction");
  nc.ui.pu.m25.action.InvoiceSaveAction bean = new nc.ui.pu.m25.action.InvoiceSaveAction();
  context.put("saveAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setActionName("SAVEBASE");
  bean.setBillType("25");
  bean.setValidationService(getValidateService());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.validation.CompositeValidation getValidateService(){
 if(context.get("validateService")!=null)
 return (nc.ui.pubapp.uif2app.validation.CompositeValidation)context.get("validateService");
  nc.ui.pubapp.uif2app.validation.CompositeValidation bean = new nc.ui.pubapp.uif2app.validation.CompositeValidation();
  context.put("validateService",bean);
  bean.setValidators(getManagedList0());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList0(){  List list = new ArrayList();  list.add(getPowerSaveValidService());  return list;}

public nc.ui.pubapp.pub.power.PowerSaveValidateService getPowerSaveValidService(){
 if(context.get("powerSaveValidService")!=null)
 return (nc.ui.pubapp.pub.power.PowerSaveValidateService)context.get("powerSaveValidService");
  nc.ui.pubapp.pub.power.PowerSaveValidateService bean = new nc.ui.pubapp.pub.power.PowerSaveValidateService();
  context.put("powerSaveValidService",bean);
  bean.setEditActionCode("edit");
  bean.setBillCodeFiledName("vbillcode");
  bean.setPermissionCode("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceApproveAction getApproveAction(){
 if(context.get("approveAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceApproveAction)context.get("approveAction");
  nc.ui.pu.m25.action.InvoiceApproveAction bean = new nc.ui.pu.m25.action.InvoiceApproveAction();
  context.put("approveAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setFilledUpInFlow(true);
  bean.setActionName("APPROVE");
  bean.setBillType("25");
  bean.setValidationService(getPowerApproveValidService());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.pub.power.PowerValidateService getPowerApproveValidService(){
 if(context.get("powerApproveValidService")!=null)
 return (nc.ui.pubapp.pub.power.PowerValidateService)context.get("powerApproveValidService");
  nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
  context.put("powerApproveValidService",bean);
  bean.setActionCode("approve");
  bean.setBillCodeFiledName("vbillcode");
  bean.setPermissionCode("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceUnApproveAction getUnApproveAction(){
 if(context.get("unApproveAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceUnApproveAction)context.get("unApproveAction");
  nc.ui.pu.m25.action.InvoiceUnApproveAction bean = new nc.ui.pu.m25.action.InvoiceUnApproveAction();
  context.put("unApproveAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setFilledUpInFlow(true);
  bean.setActionName("UNAPPROVE");
  bean.setBillType("25");
  bean.setValidationService(getPowerUnapproveValidService());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.pub.power.PowerValidateService getPowerUnapproveValidService(){
 if(context.get("powerUnapproveValidService")!=null)
 return (nc.ui.pubapp.pub.power.PowerValidateService)context.get("powerUnapproveValidService");
  nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
  context.put("powerUnapproveValidService",bean);
  bean.setActionCode("unapprove");
  bean.setBillCodeFiledName("vbillcode");
  bean.setPermissionCode("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.CancelAction getCancelAction(){
 if(context.get("cancelAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.CancelAction)context.get("cancelAction");
  nc.ui.pubapp.uif2app.actions.CancelAction bean = new nc.ui.pubapp.uif2app.actions.CancelAction();
  context.put("cancelAction",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.processor.InvoicePrintProcessor getPrintProcessor(){
 if(context.get("printProcessor")!=null)
 return (nc.ui.pu.m25.action.processor.InvoicePrintProcessor)context.get("printProcessor");
  nc.ui.pu.m25.action.processor.InvoicePrintProcessor bean = new nc.ui.pu.m25.action.processor.InvoicePrintProcessor();
  context.put("printProcessor",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction getPreviewAction(){
 if(context.get("previewAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction)context.get("previewAction");
  nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction bean = new nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction();
  context.put("previewAction",bean);
  bean.setPreview(true);
  bean.setNodeKey("4004100002");
  bean.setModel(getManageAppModel());
  bean.setBeforePrintDataProcess(getPrintProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction getPrintAction(){
 if(context.get("printAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction)context.get("printAction");
  nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction bean = new nc.ui.pubapp.uif2app.actions.MetaDataBasedPrintAction();
  context.put("printAction",bean);
  bean.setPreview(false);
  bean.setNodeKey("4004100002");
  bean.setModel(getManageAppModel());
  bean.setBeforePrintDataProcess(getPrintProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.OutputAction getOutputAction(){
 if(context.get("outputAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.OutputAction)context.get("outputAction");
  nc.ui.pubapp.uif2app.actions.OutputAction bean = new nc.ui.pubapp.uif2app.actions.OutputAction();
  context.put("outputAction",bean);
  bean.setNodeKey("4004100002");
  bean.setModel(getManageAppModel());
  bean.setParent(getBillFormEditor());
  bean.setBeforePrintDataProcess(getPrintProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoicePrintCombineAction getPrintCombineAction(){
 if(context.get("printCombineAction")!=null)
 return (nc.ui.pu.m25.action.InvoicePrintCombineAction)context.get("printCombineAction");
  nc.ui.pu.m25.action.InvoicePrintCombineAction bean = new nc.ui.pu.m25.action.InvoicePrintCombineAction();
  context.put("printCombineAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceSendApAction getSendApAction(){
 if(context.get("sendApAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceSendApAction)context.get("sendApAction");
  nc.ui.pu.m25.action.InvoiceSendApAction bean = new nc.ui.pu.m25.action.InvoiceSendApAction();
  context.put("sendApAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setFilledUpInFlow(true);
  bean.setActionName("SENDAP");
  bean.setBillType("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceCancelSendApAction getCancelSendApAction(){
 if(context.get("cancelSendApAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceCancelSendApAction)context.get("cancelSendApAction");
  nc.ui.pu.m25.action.InvoiceCancelSendApAction bean = new nc.ui.pu.m25.action.InvoiceCancelSendApAction();
  context.put("cancelSendApAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setFilledUpInFlow(true);
  bean.setActionName("CANCELSENDAP");
  bean.setBillType("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.pflow.SaveAndCommitScriptAction getSaveCommitAction(){
 if(context.get("saveCommitAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.pflow.SaveAndCommitScriptAction)context.get("saveCommitAction");
  nc.ui.pubapp.uif2app.actions.pflow.SaveAndCommitScriptAction bean = new nc.ui.pubapp.uif2app.actions.pflow.SaveAndCommitScriptAction(getSaveAction(),getSendApproveAction());  context.put("saveCommitAction",bean);
  bean.setModel(getManageAppModel());
  bean.setBtnName(getI18nFB_1e7bac4());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1e7bac4(){
 if(context.get("nc.ui.uif2.I18nFB#1e7bac4")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1e7bac4");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1e7bac4",bean);  bean.setResDir("common");
  bean.setResId("2SCMPUB-000027");
  bean.setDefaultValue("保存提交");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1e7bac4",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceSendApproveAction getSendApproveAction(){
 if(context.get("sendApproveAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceSendApproveAction)context.get("sendApproveAction");
  nc.ui.pu.m25.action.InvoiceSendApproveAction bean = new nc.ui.pu.m25.action.InvoiceSendApproveAction();
  context.put("sendApproveAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setPreActionNames(getManagedList1());
  bean.setActionName("SAVE");
  bean.setBillType("25");
  bean.setFilledUpInFlow(true);
  bean.setValidationService(getSendpowervalidservice());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList1(){  List list = new ArrayList();  list.add("SAVEBASE");  return list;}

public nc.ui.pu.pub.action.UnSaveScriptAction getUnSendApproveAction(){
 if(context.get("unSendApproveAction")!=null)
 return (nc.ui.pu.pub.action.UnSaveScriptAction)context.get("unSendApproveAction");
  nc.ui.pu.pub.action.UnSaveScriptAction bean = new nc.ui.pu.pub.action.UnSaveScriptAction();
  context.put("unSendApproveAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setActionName("UNSAVEBILL");
  bean.setBillType("25");
  bean.setFilledUpInFlow(true);
  bean.setValidationService(getUnsendpowervalidservice());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.pub.power.PowerValidateService getSendpowervalidservice(){
 if(context.get("sendpowervalidservice")!=null)
 return (nc.ui.pubapp.pub.power.PowerValidateService)context.get("sendpowervalidservice");
  nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
  context.put("sendpowervalidservice",bean);
  bean.setActionCode("commit");
  bean.setBillCodeFiledName("vbillcode");
  bean.setPermissionCode("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.pub.power.PowerValidateService getUnsendpowervalidservice(){
 if(context.get("unsendpowervalidservice")!=null)
 return (nc.ui.pubapp.pub.power.PowerValidateService)context.get("unsendpowervalidservice");
  nc.ui.pubapp.pub.power.PowerValidateService bean = new nc.ui.pubapp.pub.power.PowerValidateService();
  context.put("unsendpowervalidservice",bean);
  bean.setActionCode("uncommit");
  bean.setBillCodeFiledName("vbillcode");
  bean.setPermissionCode("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.GroupAction getSendApproveMenuAction(){
 if(context.get("sendApproveMenuAction")!=null)
 return (nc.funcnode.ui.action.GroupAction)context.get("sendApproveMenuAction");
  nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
  context.put("sendApproveMenuAction",bean);
  bean.setCode("sendApproveMenuAction");
  bean.setActions(getManagedList2());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList2(){  List list = new ArrayList();  list.add(getSendApproveAction());  list.add(getUnSendApproveAction());  return list;}

public nc.ui.pu.m25.action.InvoiceAddFeeBillAction getAddfeeinvoice(){
 if(context.get("addfeeinvoice")!=null)
 return (nc.ui.pu.m25.action.InvoiceAddFeeBillAction)context.get("addfeeinvoice");
  nc.ui.pu.m25.action.InvoiceAddFeeBillAction bean = new nc.ui.pu.m25.action.InvoiceAddFeeBillAction();
  context.put("addfeeinvoice",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceRetFromFeeBillAction getRetfeeinvoice(){
 if(context.get("retfeeinvoice")!=null)
 return (nc.ui.pu.m25.action.InvoiceRetFromFeeBillAction)context.get("retfeeinvoice");
  nc.ui.pu.m25.action.InvoiceRetFromFeeBillAction bean = new nc.ui.pu.m25.action.InvoiceRetFromFeeBillAction();
  context.put("retfeeinvoice",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.FeeInvoiceAddAction getNewfeeinvoice(){
 if(context.get("newfeeinvoice")!=null)
 return (nc.ui.pu.m25.action.FeeInvoiceAddAction)context.get("newfeeinvoice");
  nc.ui.pu.m25.action.FeeInvoiceAddAction bean = new nc.ui.pu.m25.action.FeeInvoiceAddAction();
  context.put("newfeeinvoice",bean);
  bean.setModel(getManageAppModel());
  bean.setInterceptor(getFormInterceptor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceRef21AddAction getAddFrom21Action(){
 if(context.get("addFrom21Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef21AddAction)context.get("addFrom21Action");
  nc.ui.pu.m25.action.InvoiceRef21AddAction bean = new nc.ui.pu.m25.action.InvoiceRef21AddAction();
  context.put("addFrom21Action",bean);
  bean.setSourceBillType("21");
  bean.setSourceBillName(getI18nFB_96d862());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_96d862(){
 if(context.get("nc.ui.uif2.I18nFB#96d862")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#96d862");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#96d862",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0494");
  bean.setDefaultValue("采购订单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#96d862",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef4TAddAction getAddFrom4TAction(){
 if(context.get("addFrom4TAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef4TAddAction)context.get("addFrom4TAction");
  nc.ui.pu.m25.action.InvoiceRef4TAddAction bean = new nc.ui.pu.m25.action.InvoiceRef4TAddAction();
  context.put("addFrom4TAction",bean);
  bean.setSourceBillType("4T");
  bean.setSourceBillName(getI18nFB_158396b());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_158396b(){
 if(context.get("nc.ui.uif2.I18nFB#158396b")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#158396b");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#158396b",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0490");
  bean.setDefaultValue("期初暂估单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#158396b",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef4TAddRowsAction getAddRowsFrom4TAction(){
 if(context.get("addRowsFrom4TAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef4TAddRowsAction)context.get("addRowsFrom4TAction");
  nc.ui.pu.m25.action.InvoiceRef4TAddRowsAction bean = new nc.ui.pu.m25.action.InvoiceRef4TAddRowsAction();
  context.put("addRowsFrom4TAction",bean);
  bean.setSourceBillType("4T");
  bean.setSourceBillName(getI18nFB_121ba22());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_121ba22(){
 if(context.get("nc.ui.uif2.I18nFB#121ba22")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#121ba22");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#121ba22",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0490");
  bean.setDefaultValue("期初暂估单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#121ba22",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef21AddRowsAction getAddRowsFrom21Action(){
 if(context.get("addRowsFrom21Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef21AddRowsAction)context.get("addRowsFrom21Action");
  nc.ui.pu.m25.action.InvoiceRef21AddRowsAction bean = new nc.ui.pu.m25.action.InvoiceRef21AddRowsAction();
  context.put("addRowsFrom21Action",bean);
  bean.setSourceBillType("21");
  bean.setSourceBillName(getI18nFB_143420d());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_143420d(){
 if(context.get("nc.ui.uif2.I18nFB#143420d")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#143420d");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#143420d",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0494");
  bean.setDefaultValue("采购订单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#143420d",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef45AddAction getAddFrom45Action(){
 if(context.get("addFrom45Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef45AddAction)context.get("addFrom45Action");
  nc.ui.pu.m25.action.InvoiceRef45AddAction bean = new nc.ui.pu.m25.action.InvoiceRef45AddAction();
  context.put("addFrom45Action",bean);
  bean.setSourceBillType("45");
  bean.setSourceBillName(getI18nFB_a5683b());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_a5683b(){
 if(context.get("nc.ui.uif2.I18nFB#a5683b")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#a5683b");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#a5683b",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0438");
  bean.setDefaultValue("采购入库单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#a5683b",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef45AddRowsAction getAddRowsFrom45Action(){
 if(context.get("addRowsFrom45Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef45AddRowsAction)context.get("addRowsFrom45Action");
  nc.ui.pu.m25.action.InvoiceRef45AddRowsAction bean = new nc.ui.pu.m25.action.InvoiceRef45AddRowsAction();
  context.put("addRowsFrom45Action",bean);
  bean.setSourceBillType("45");
  bean.setSourceBillName(getI18nFB_15e0934());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_15e0934(){
 if(context.get("nc.ui.uif2.I18nFB#15e0934")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#15e0934");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#15e0934",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0438");
  bean.setDefaultValue("采购入库单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#15e0934",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef50AddAction getAddFrom50Action(){
 if(context.get("addFrom50Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef50AddAction)context.get("addFrom50Action");
  nc.ui.pu.m25.action.InvoiceRef50AddAction bean = new nc.ui.pu.m25.action.InvoiceRef50AddAction();
  context.put("addFrom50Action",bean);
  bean.setSourceBillType("50");
  bean.setSourceBillName(getI18nFB_ae7539());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_ae7539(){
 if(context.get("nc.ui.uif2.I18nFB#ae7539")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#ae7539");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#ae7539",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0479");
  bean.setDefaultValue("消耗汇总");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#ae7539",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef50AddRowsAction getAddRowsFrom50Action(){
 if(context.get("addRowsFrom50Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef50AddRowsAction)context.get("addRowsFrom50Action");
  nc.ui.pu.m25.action.InvoiceRef50AddRowsAction bean = new nc.ui.pu.m25.action.InvoiceRef50AddRowsAction();
  context.put("addRowsFrom50Action",bean);
  bean.setSourceBillType("50");
  bean.setSourceBillName(getI18nFB_192060c());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_192060c(){
 if(context.get("nc.ui.uif2.I18nFB#192060c")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#192060c");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#192060c",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0479");
  bean.setDefaultValue("消耗汇总");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#192060c",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef61AddAction getAddFrom61Action(){
 if(context.get("addFrom61Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef61AddAction)context.get("addFrom61Action");
  nc.ui.pu.m25.action.InvoiceRef61AddAction bean = new nc.ui.pu.m25.action.InvoiceRef61AddAction();
  context.put("addFrom61Action",bean);
  bean.setSourceBillType("61");
  bean.setSourceBillName(getI18nFB_1cb29b7());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1cb29b7(){
 if(context.get("nc.ui.uif2.I18nFB#1cb29b7")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1cb29b7");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1cb29b7",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0515");
  bean.setDefaultValue("委外订单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1cb29b7",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef61AddRowsAction getAddRowsFrom61Action(){
 if(context.get("addRowsFrom61Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef61AddRowsAction)context.get("addRowsFrom61Action");
  nc.ui.pu.m25.action.InvoiceRef61AddRowsAction bean = new nc.ui.pu.m25.action.InvoiceRef61AddRowsAction();
  context.put("addRowsFrom61Action",bean);
  bean.setSourceBillType("61");
  bean.setSourceBillName(getI18nFB_11fe196());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_11fe196(){
 if(context.get("nc.ui.uif2.I18nFB#11fe196")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#11fe196");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#11fe196",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0515");
  bean.setDefaultValue("委外订单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#11fe196",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef47AddAction getAddFrom47Action(){
 if(context.get("addFrom47Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef47AddAction)context.get("addFrom47Action");
  nc.ui.pu.m25.action.InvoiceRef47AddAction bean = new nc.ui.pu.m25.action.InvoiceRef47AddAction();
  context.put("addFrom47Action",bean);
  bean.setSourceBillType("47");
  bean.setSourceBillName(getI18nFB_137f07());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_137f07(){
 if(context.get("nc.ui.uif2.I18nFB#137f07")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#137f07");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#137f07",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0450");
  bean.setDefaultValue("委托加工入库单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#137f07",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef47AddRowsAction getAddRowsFrom47Action(){
 if(context.get("addRowsFrom47Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef47AddRowsAction)context.get("addRowsFrom47Action");
  nc.ui.pu.m25.action.InvoiceRef47AddRowsAction bean = new nc.ui.pu.m25.action.InvoiceRef47AddRowsAction();
  context.put("addRowsFrom47Action",bean);
  bean.setSourceBillType("47");
  bean.setSourceBillName(getI18nFB_1f8c154());
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1f8c154(){
 if(context.get("nc.ui.uif2.I18nFB#1f8c154")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1f8c154");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1f8c154",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0450");
  bean.setDefaultValue("委托加工入库单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1f8c154",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef55E6AddAction getAddFrom55E6Action(){
 if(context.get("addFrom55E6Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef55E6AddAction)context.get("addFrom55E6Action");
  nc.ui.pu.m25.action.InvoiceRef55E6AddAction bean = new nc.ui.pu.m25.action.InvoiceRef55E6AddAction();
  context.put("addFrom55E6Action",bean);
  bean.setSourceBillType("55E6");
  bean.setSourceBillName(getI18nFB_5c75e2());
  bean.setFlowBillType(false);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_5c75e2(){
 if(context.get("nc.ui.uif2.I18nFB#5c75e2")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#5c75e2");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#5c75e2",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0653");
  bean.setDefaultValue("工序委外加工费");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#5c75e2",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceHqhpAction getHqhpAction(){
 if(context.get("hqhpAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceHqhpAction)context.get("hqhpAction");
  nc.ui.pu.m25.action.InvoiceHqhpAction bean = new nc.ui.pu.m25.action.InvoiceHqhpAction();
  context.put("hqhpAction",bean);
  bean.setModel(getManageAppModel());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceFrozenAction getFrozenAction(){
 if(context.get("frozenAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceFrozenAction)context.get("frozenAction");
  nc.ui.pu.m25.action.InvoiceFrozenAction bean = new nc.ui.pu.m25.action.InvoiceFrozenAction();
  context.put("frozenAction",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceUnFrozenAction getUnFrozenAction(){
 if(context.get("unFrozenAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceUnFrozenAction)context.get("unFrozenAction");
  nc.ui.pu.m25.action.InvoiceUnFrozenAction bean = new nc.ui.pu.m25.action.InvoiceUnFrozenAction();
  context.put("unFrozenAction",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.FileDocManageAction getDocMngAction(){
 if(context.get("docMngAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.FileDocManageAction)context.get("docMngAction");
  nc.ui.pubapp.uif2app.actions.FileDocManageAction bean = new nc.ui.pubapp.uif2app.actions.FileDocManageAction();
  context.put("docMngAction",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.pub.action.PULinkQueryAction getLinkQueryBill(){
 if(context.get("linkQueryBill")!=null)
 return (nc.ui.pu.pub.action.PULinkQueryAction)context.get("linkQueryBill");
  nc.ui.pu.pub.action.PULinkQueryAction bean = new nc.ui.pu.pub.action.PULinkQueryAction();
  context.put("linkQueryBill",bean);
  bean.setModel(getManageAppModel());
  bean.setBillType("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.LinkQueryFeeInvoiceAction getLinkQueryFeeInvoice(){
 if(context.get("linkQueryFeeInvoice")!=null)
 return (nc.ui.pu.m25.action.LinkQueryFeeInvoiceAction)context.get("linkQueryFeeInvoice");
  nc.ui.pu.m25.action.LinkQueryFeeInvoiceAction bean = new nc.ui.pu.m25.action.LinkQueryFeeInvoiceAction();
  context.put("linkQueryFeeInvoice",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.pflow.PFApproveStatusInfoAction getLinkQueryAuditFlowStatus(){
 if(context.get("linkQueryAuditFlowStatus")!=null)
 return (nc.ui.pubapp.uif2app.actions.pflow.PFApproveStatusInfoAction)context.get("linkQueryAuditFlowStatus");
  nc.ui.pubapp.uif2app.actions.pflow.PFApproveStatusInfoAction bean = new nc.ui.pubapp.uif2app.actions.pflow.PFApproveStatusInfoAction();
  context.put("linkQueryAuditFlowStatus",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceAddManualAction getAddManualAction(){
 if(context.get("addManualAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceAddManualAction)context.get("addManualAction");
  nc.ui.pu.m25.action.InvoiceAddManualAction bean = new nc.ui.pu.m25.action.InvoiceAddManualAction();
  context.put("addManualAction",bean);
  bean.setSourceBillType("MANUAL");
  bean.setSourceBillName(getI18nFB_3f77cd());
  bean.setModel(getManageAppModel());
  bean.setInterceptor(getFormInterceptor());
  bean.setEditor(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_3f77cd(){
 if(context.get("nc.ui.uif2.I18nFB#3f77cd")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#3f77cd");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#3f77cd",bean);  bean.setResDir("common");
  bean.setResId("14004000-0000");
  bean.setDefaultValue("自制");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#3f77cd",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceAddMenuAction getAddMenu(){
 if(context.get("addMenu")!=null)
 return (nc.ui.pu.m25.action.InvoiceAddMenuAction)context.get("addMenu");
  nc.ui.pu.m25.action.InvoiceAddMenuAction bean = new nc.ui.pu.m25.action.InvoiceAddMenuAction();
  context.put("addMenu",bean);
  bean.setBillType("25");
  bean.setTooltip(getI18nFB_d2519b());
  bean.setActions(getManagedList3());
  bean.setModel(getManageAppModel());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_d2519b(){
 if(context.get("nc.ui.uif2.I18nFB#d2519b")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#d2519b");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#d2519b",bean);  bean.setResDir("common");
  bean.setResId("04004000-0001");
  bean.setDefaultValue("新增业务数据(Ctrl+N)");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#d2519b",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList3(){  List list = new ArrayList();  return list;}

public nc.funcnode.ui.action.GroupAction getInvoiceApproveMenuAction(){
 if(context.get("invoiceApproveMenuAction")!=null)
 return (nc.funcnode.ui.action.GroupAction)context.get("invoiceApproveMenuAction");
  nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
  context.put("invoiceApproveMenuAction",bean);
  bean.setCode("auditMenuAction");
  bean.setActions(getManagedList4());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList4(){  List list = new ArrayList();  list.add(getApproveAction());  list.add(getUnApproveAction());  list.add(getSeparatorAction_1eba5e5());  list.add(getLinkQueryAuditFlowStatus());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1eba5e5(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#1eba5e5")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#1eba5e5");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#1eba5e5",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.RefAddRowsMenuAction getRefAddRowsMenuAction(){
 if(context.get("refAddRowsMenuAction")!=null)
 return (nc.ui.pu.m25.action.RefAddRowsMenuAction)context.get("refAddRowsMenuAction");
  nc.ui.pu.m25.action.RefAddRowsMenuAction bean = new nc.ui.pu.m25.action.RefAddRowsMenuAction();
  context.put("refAddRowsMenuAction",bean);
  bean.setActions(getManagedList5());
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList5(){  List list = new ArrayList();  list.add(getAddRowsFrom21Action());  list.add(getAddRowsFrom45Action());  list.add(getAddRowsFrom4TAction());  list.add(getAddRowsFrom50Action());  list.add(getAddRowsFrom61Action());  list.add(getAddRowsFrom47Action());  return list;}

public nc.ui.pu.m25.action.InvoiceAssistMenuAction getAssistMenuAction(){
 if(context.get("assistMenuAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceAssistMenuAction)context.get("assistMenuAction");
  nc.ui.pu.m25.action.InvoiceAssistMenuAction bean = new nc.ui.pu.m25.action.InvoiceAssistMenuAction();
  context.put("assistMenuAction",bean);
  bean.setActions(getManagedList6());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList6(){  List list = new ArrayList();  list.add(getFrozenAction());  list.add(getUnFrozenAction());  list.add(getSeparatorAction_1d87804());  list.add(getDocMngAction());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1d87804(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#1d87804")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#1d87804");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#1d87804",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceAssistMenuAction getNormalEditAstMenuAction(){
 if(context.get("normalEditAstMenuAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceAssistMenuAction)context.get("normalEditAstMenuAction");
  nc.ui.pu.m25.action.InvoiceAssistMenuAction bean = new nc.ui.pu.m25.action.InvoiceAssistMenuAction();
  context.put("normalEditAstMenuAction",bean);
  bean.setActions(getManagedList7());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList7(){  List list = new ArrayList();  list.add(getHqhpAction());  return list;}

public nc.ui.pu.m25.action.LinkQueryMenuAction getLinkQueryMenuAction(){
 if(context.get("linkQueryMenuAction")!=null)
 return (nc.ui.pu.m25.action.LinkQueryMenuAction)context.get("linkQueryMenuAction");
  nc.ui.pu.m25.action.LinkQueryMenuAction bean = new nc.ui.pu.m25.action.LinkQueryMenuAction();
  context.put("linkQueryMenuAction",bean);
  bean.setActions(getManagedList8());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList8(){  List list = new ArrayList();  list.add(getLinkQueryBill());  list.add(getSeparatorAction_af6933());  list.add(getLinkQueryFeeInvoice());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_af6933(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#af6933")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#af6933");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#af6933",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.RelatingFunctionsMenuAction getRelatingFunctionsMenuAction(){
 if(context.get("relatingFunctionsMenuAction")!=null)
 return (nc.ui.pu.m25.action.RelatingFunctionsMenuAction)context.get("relatingFunctionsMenuAction");
  nc.ui.pu.m25.action.RelatingFunctionsMenuAction bean = new nc.ui.pu.m25.action.RelatingFunctionsMenuAction();
  context.put("relatingFunctionsMenuAction",bean);
  bean.setActions(getManagedList9());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList9(){  List list = new ArrayList();  list.add(getSendApAction());  list.add(getCancelSendApAction());  list.add(getAddfeeinvoice());  return list;}

public nc.ui.pu.m25.action.RelatingFunctionsMenuAction getRelatingFunctionsMenuActionFee(){
 if(context.get("relatingFunctionsMenuActionFee")!=null)
 return (nc.ui.pu.m25.action.RelatingFunctionsMenuAction)context.get("relatingFunctionsMenuActionFee");
  nc.ui.pu.m25.action.RelatingFunctionsMenuAction bean = new nc.ui.pu.m25.action.RelatingFunctionsMenuAction();
  context.put("relatingFunctionsMenuActionFee",bean);
  bean.setActions(getManagedList10());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList10(){  List list = new ArrayList();  list.add(getSendApAction());  list.add(getCancelSendApAction());  return list;}

public nc.ui.pu.m25.action.RelatingFunctionsMenuAction getRelatingFunctionsMenuActionEdit(){
 if(context.get("relatingFunctionsMenuActionEdit")!=null)
 return (nc.ui.pu.m25.action.RelatingFunctionsMenuAction)context.get("relatingFunctionsMenuActionEdit");
  nc.ui.pu.m25.action.RelatingFunctionsMenuAction bean = new nc.ui.pu.m25.action.RelatingFunctionsMenuAction();
  context.put("relatingFunctionsMenuActionEdit",bean);
  bean.setActions(getManagedList11());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList11(){  List list = new ArrayList();  return list;}

public nc.ui.scmpub.action.SCMPrintCountQueryAction getPrintCountQueryAction(){
 if(context.get("printCountQueryAction")!=null)
 return (nc.ui.scmpub.action.SCMPrintCountQueryAction)context.get("printCountQueryAction");
  nc.ui.scmpub.action.SCMPrintCountQueryAction bean = new nc.ui.scmpub.action.SCMPrintCountQueryAction();
  context.put("printCountQueryAction",bean);
  bean.setModel(getManageAppModel());
  bean.setBilldateFieldName("dbilldate");
  bean.setBillType("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.funcnode.ui.action.GroupAction getInvoicePrintMenuAction(){
 if(context.get("invoicePrintMenuAction")!=null)
 return (nc.funcnode.ui.action.GroupAction)context.get("invoicePrintMenuAction");
  nc.funcnode.ui.action.GroupAction bean = new nc.funcnode.ui.action.GroupAction();
  context.put("invoicePrintMenuAction",bean);
  bean.setCode("printMenuAction");
  bean.setActions(getManagedList12());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList12(){  List list = new ArrayList();  list.add(getPrintAction());  list.add(getPreviewAction());  list.add(getOutputAction());  list.add(getPrintCountQueryAction());  list.add(getSeparatorAction_23b88c());  list.add(getPrintCombineAction());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_23b88c(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#23b88c")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#23b88c");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#23b88c",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.editor.org.OrgChangedEventHandler getMainorgchghandler(){
 if(context.get("mainorgchghandler")!=null)
 return (nc.ui.pu.m25.editor.org.OrgChangedEventHandler)context.get("mainorgchghandler");
  nc.ui.pu.m25.editor.org.OrgChangedEventHandler bean = new nc.ui.pu.m25.editor.org.OrgChangedEventHandler();
  context.put("mainorgchghandler",bean);
  bean.setCardForm(getBillFormEditor());
  bean.setListView(getListView());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.editor.card.beforeedit.CardHeadTailBeforeEditEventHandler getCard_before_headtail_edithandler(){
 if(context.get("card_before_headtail_edithandler")!=null)
 return (nc.ui.pu.m25.editor.card.beforeedit.CardHeadTailBeforeEditEventHandler)context.get("card_before_headtail_edithandler");
  nc.ui.pu.m25.editor.card.beforeedit.CardHeadTailBeforeEditEventHandler bean = new nc.ui.pu.m25.editor.card.beforeedit.CardHeadTailBeforeEditEventHandler();
  context.put("card_before_headtail_edithandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.editor.card.afteredit.CardHeadTailAfterEditEventHandler getCard_after_headtail_edithandler(){
 if(context.get("card_after_headtail_edithandler")!=null)
 return (nc.ui.pu.m25.editor.card.afteredit.CardHeadTailAfterEditEventHandler)context.get("card_after_headtail_edithandler");
  nc.ui.pu.m25.editor.card.afteredit.CardHeadTailAfterEditEventHandler bean = new nc.ui.pu.m25.editor.card.afteredit.CardHeadTailAfterEditEventHandler();
  context.put("card_after_headtail_edithandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.editor.card.beforeedit.CardBodyBeforeEditEventHandler getCard_before_body_edithandler(){
 if(context.get("card_before_body_edithandler")!=null)
 return (nc.ui.pu.m25.editor.card.beforeedit.CardBodyBeforeEditEventHandler)context.get("card_before_body_edithandler");
  nc.ui.pu.m25.editor.card.beforeedit.CardBodyBeforeEditEventHandler bean = new nc.ui.pu.m25.editor.card.beforeedit.CardBodyBeforeEditEventHandler();
  context.put("card_before_body_edithandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.editor.card.afteredit.CardBodyAfterEditEventHandler getCard_after_body_edithandler(){
 if(context.get("card_after_body_edithandler")!=null)
 return (nc.ui.pu.m25.editor.card.afteredit.CardBodyAfterEditEventHandler)context.get("card_after_body_edithandler");
  nc.ui.pu.m25.editor.card.afteredit.CardBodyAfterEditEventHandler bean = new nc.ui.pu.m25.editor.card.afteredit.CardBodyAfterEditEventHandler();
  context.put("card_after_body_edithandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.editor.list.HeadRowChangeHandler getList_head_rowchangehandler(){
 if(context.get("list_head_rowchangehandler")!=null)
 return (nc.ui.pu.m25.editor.list.HeadRowChangeHandler)context.get("list_head_rowchangehandler");
  nc.ui.pu.m25.editor.list.HeadRowChangeHandler bean = new nc.ui.pu.m25.editor.list.HeadRowChangeHandler();
  context.put("list_head_rowchangehandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.editor.card.InvoiceAddEventHandler getInvoiceAddHandler(){
 if(context.get("invoiceAddHandler")!=null)
 return (nc.ui.pu.m25.editor.card.InvoiceAddEventHandler)context.get("invoiceAddHandler");
  nc.ui.pu.m25.editor.card.InvoiceAddEventHandler bean = new nc.ui.pu.m25.editor.card.InvoiceAddEventHandler();
  context.put("invoiceAddHandler",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.editor.TotalValueHanlder getTotalvaluehandler(){
 if(context.get("totalvaluehandler")!=null)
 return (nc.ui.pu.m25.editor.TotalValueHanlder)context.get("totalvaluehandler");
  nc.ui.pu.m25.editor.TotalValueHanlder bean = new nc.ui.pu.m25.editor.TotalValueHanlder();
  context.put("totalvaluehandler",bean);
  bean.setBodyHeadMap(getManagedMap0());
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private Map getManagedMap0(){  Map map = new HashMap();  map.put("nastnum","ntotalastnum");  map.put("norigtaxmny","ntotalorigmny");  return map;}

public nc.ui.pu.m25.editor.utils.RelationCalculate getRelationCalculate(){
 if(context.get("relationCalculate")!=null)
 return (nc.ui.pu.m25.editor.utils.RelationCalculate)context.get("relationCalculate");
  nc.ui.pu.m25.editor.utils.RelationCalculate bean = new nc.ui.pu.m25.editor.utils.RelationCalculate();
  context.put("relationCalculate",bean);
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
  bean.setHandlerMap(getManagedMap1());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private Map getManagedMap1(){  Map map = new HashMap();  map.put("nc.ui.pubapp.uif2app.event.card.CardHeadTailBeforeEditEvent",getManagedList13());  map.put("nc.ui.pubapp.uif2app.event.card.CardHeadTailAfterEditEvent",getManagedList14());  map.put("nc.ui.pubapp.uif2app.event.card.CardBodyBeforeEditEvent",getManagedList15());  map.put("nc.ui.pubapp.uif2app.event.card.CardBodyAfterEditEvent",getManagedList16());  map.put("nc.ui.pubapp.uif2app.event.list.ListHeadRowChangedEvent",getManagedList17());  map.put("nc.ui.pubapp.uif2app.event.OrgChangedEvent",getManagedList18());  map.put("nc.ui.pubapp.uif2app.event.AppUiStateChangeEvent",getManagedList19());  map.put("nc.ui.pubapp.uif2app.event.billform.AddEvent",getManagedList20());  return map;}

private List getManagedList13(){  List list = new ArrayList();  list.add(getCard_before_headtail_edithandler());  return list;}

private List getManagedList14(){  List list = new ArrayList();  list.add(getCard_after_headtail_edithandler());  return list;}

private List getManagedList15(){  List list = new ArrayList();  list.add(getCard_before_body_edithandler());  return list;}

private List getManagedList16(){  List list = new ArrayList();  list.add(getCard_after_body_edithandler());  list.add(getRelationCalculate());  return list;}

private List getManagedList17(){  List list = new ArrayList();  list.add(getList_head_rowchangehandler());  return list;}

private List getManagedList18(){  List list = new ArrayList();  list.add(getMainorgchghandler());  return list;}

private List getManagedList19(){  List list = new ArrayList();  list.add(getFeeViewTransfer());  return list;}

private List getManagedList20(){  List list = new ArrayList();  list.add(getInvoiceAddHandler());  return list;}

public nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener getInitDataListener(){
 if(context.get("InitDataListener")!=null)
 return (nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener)context.get("InitDataListener");
  nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener bean = new nc.ui.pubapp.uif2app.model.DefaultFuncNodeInitDataListener();
  context.put("InitDataListener",bean);
  bean.setContext(getContext());
  bean.setModel(getManageAppModel());
  bean.setVoClassName("nc.vo.pu.m25.entity.InvoiceVO");
  bean.setAutoShowUpComponent(getBillFormEditor());
  bean.setQueryAction(getQueryAction());
  bean.setProcessorMap(getManagedMap2());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private Map getManagedMap2(){  Map map = new HashMap();  map.put("19",getInitDataProcessor_101b48d());  map.put("40",getInitDataForTbbProcessor_f4c2a1());  return map;}

private nc.ui.pu.m25.billref.processor.InitDataProcessor getInitDataProcessor_101b48d(){
 if(context.get("nc.ui.pu.m25.billref.processor.InitDataProcessor#101b48d")!=null)
 return (nc.ui.pu.m25.billref.processor.InitDataProcessor)context.get("nc.ui.pu.m25.billref.processor.InitDataProcessor#101b48d");
  nc.ui.pu.m25.billref.processor.InitDataProcessor bean = new nc.ui.pu.m25.billref.processor.InitDataProcessor();
  context.put("nc.ui.pu.m25.billref.processor.InitDataProcessor#101b48d",bean);
  bean.setTransferViewProcessor(getTransferViewProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pu.m25.billref.processor.InitDataForTbbProcessor getInitDataForTbbProcessor_f4c2a1(){
 if(context.get("nc.ui.pu.m25.billref.processor.InitDataForTbbProcessor#f4c2a1")!=null)
 return (nc.ui.pu.m25.billref.processor.InitDataForTbbProcessor)context.get("nc.ui.pu.m25.billref.processor.InitDataForTbbProcessor#f4c2a1");
  nc.ui.pu.m25.billref.processor.InitDataForTbbProcessor bean = new nc.ui.pu.m25.billref.processor.InitDataForTbbProcessor();
  context.put("nc.ui.pu.m25.billref.processor.InitDataForTbbProcessor#f4c2a1",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.vo.uif2.LoginContext getContext(){
 if(context.get("context")!=null)
 return (nc.vo.uif2.LoginContext)context.get("context");
  nc.vo.uif2.LoginContext bean = new nc.vo.uif2.LoginContext();
  context.put("context",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.model.InvoiceModelServcie getManageModelService(){
 if(context.get("ManageModelService")!=null)
 return (nc.ui.pu.m25.model.InvoiceModelServcie)context.get("ManageModelService");
  nc.ui.pu.m25.model.InvoiceModelServcie bean = new nc.ui.pu.m25.model.InvoiceModelServcie();
  context.put("ManageModelService",bean);
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

public nc.ui.pubapp.uif2app.view.value.AggVOMetaBDObjectAdapterFactory getBoadatorfactory(){
 if(context.get("boadatorfactory")!=null)
 return (nc.ui.pubapp.uif2app.view.value.AggVOMetaBDObjectAdapterFactory)context.get("boadatorfactory");
  nc.ui.pubapp.uif2app.view.value.AggVOMetaBDObjectAdapterFactory bean = new nc.ui.pubapp.uif2app.view.value.AggVOMetaBDObjectAdapterFactory();
  context.put("boadatorfactory",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.model.InvoiceBillManageModel getManageAppModel(){
 if(context.get("ManageAppModel")!=null)
 return (nc.ui.pu.m25.model.InvoiceBillManageModel)context.get("ManageAppModel");
  nc.ui.pu.m25.model.InvoiceBillManageModel bean = new nc.ui.pu.m25.model.InvoiceBillManageModel();
  context.put("ManageAppModel",bean);
  bean.setService(getManageModelService());
  bean.setBusinessObjectAdapterFactory(getBoadatorfactory());
  bean.setContext(getContext());
  bean.setBillType("25");
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
  bean.setPagePanel(getQueryInfo());
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

public nc.ui.pu.m25.model.InvoicePageModelService getPageQuery(){
 if(context.get("pageQuery")!=null)
 return (nc.ui.pu.m25.model.InvoicePageModelService)context.get("pageQuery");
  nc.ui.pu.m25.model.InvoicePageModelService bean = new nc.ui.pu.m25.model.InvoicePageModelService();
  context.put("pageQuery",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.scmpub.page.model.SCMBillPageMediator getPageMediator(){
 if(context.get("pageMediator")!=null)
 return (nc.ui.scmpub.page.model.SCMBillPageMediator)context.get("pageMediator");
  nc.ui.scmpub.page.model.SCMBillPageMediator bean = new nc.ui.scmpub.page.model.SCMBillPageMediator();
  context.put("pageMediator",bean);
  bean.setListView(getListView());
  bean.setRecordInPage(10);
  bean.setCachePages(10);
  bean.setPageDelegator(getPageDelegator());
  bean.init();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.funcnode.trantype.TrantypeBillTemplateMender getBillTemplateMender(){
 if(context.get("billTemplateMender")!=null)
 return (nc.ui.pubapp.uif2app.funcnode.trantype.TrantypeBillTemplateMender)context.get("billTemplateMender");
  nc.ui.pubapp.uif2app.funcnode.trantype.TrantypeBillTemplateMender bean = new nc.ui.pubapp.uif2app.funcnode.trantype.TrantypeBillTemplateMender(getContext());  context.put("billTemplateMender",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.TemplateContainer getTemplateContainer(){
 if(context.get("templateContainer")!=null)
 return (nc.ui.pubapp.uif2app.view.TemplateContainer)context.get("templateContainer");
  nc.ui.pubapp.uif2app.view.TemplateContainer bean = new nc.ui.pubapp.uif2app.view.TemplateContainer();
  context.put("templateContainer",bean);
  bean.setContext(getContext());
  bean.setBillTemplateMender(getBillTemplateMender());
  bean.load();
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

public nc.ui.pu.m25.view.InvoiceBillListView getListView(){
 if(context.get("listView")!=null)
 return (nc.ui.pu.m25.view.InvoiceBillListView)context.get("listView");
  nc.ui.pu.m25.view.InvoiceBillListView bean = new nc.ui.pu.m25.view.InvoiceBillListView();
  context.put("listView",bean);
  bean.setModel(getManageAppModel());
  bean.setMultiSelectionMode(0);
  bean.setTemplateContainer(getTemplateContainer());
  bean.setPaginationBar(getPageBar());
  bean.setUserdefitemListPreparator(getUserdefAndMarAsstListPreparator());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public java.util.ArrayList getPasteClearItem(){
 if(context.get("pasteClearItem")!=null)
 return (java.util.ArrayList)context.get("pasteClearItem");
  java.util.ArrayList bean = new java.util.ArrayList(getManagedList21());  context.put("pasteClearItem",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList21(){  List list = new ArrayList();  list.add("naccumsettmny");  list.add("naccumsettnum");  list.add("pk_invoice_b");  list.add("ts");  return list;}

public nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator getVsourcecodeMediator(){
 if(context.get("vsourcecodeMediator")!=null)
 return (nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator)context.get("vsourcecodeMediator");
  nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator bean = new nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator();
  context.put("vsourcecodeMediator",bean);
  bean.setModel(getManageAppModel());
  bean.setSrcBillIdField("csourceid");
  bean.setSrcBillNOField("vsourcecode");
  bean.setSrcBillTypeField("csourcetypecode");
  bean.setSrcBillTypeFieldPos(1);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator getVfirstcodeMediator(){
 if(context.get("vfirstcodeMediator")!=null)
 return (nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator)context.get("vfirstcodeMediator");
  nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator bean = new nc.ui.pubapp.uif2app.linkquery.LinkQueryHyperlinkMediator();
  context.put("vfirstcodeMediator",bean);
  bean.setModel(getManageAppModel());
  bean.setSrcBillIdField("cfirstid");
  bean.setSrcBillNOField("vfirstcode");
  bean.setSrcBillTypeField("cfirsttypecode");
  bean.setSrcBillTypeFieldPos(1);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.view.InvoiceBillForm getBillFormEditor(){
 if(context.get("billFormEditor")!=null)
 return (nc.ui.pu.m25.view.InvoiceBillForm)context.get("billFormEditor");
  nc.ui.pu.m25.view.InvoiceBillForm bean = new nc.ui.pu.m25.view.InvoiceBillForm();
  context.put("billFormEditor",bean);
  bean.setModel(getManageAppModel());
  bean.setTemplateContainer(getTemplateContainer());
  bean.setUserdefitemPreparator(getUserdefAndMarAsstCardPreparator());
  bean.setTemplateNotNullValidate(true);
  bean.setAutoAddLine(true);
  bean.setBlankChildrenFilter(getBlankitemfilter());
  bean.setBodyLineActions(getManagedList22());
  bean.setTotalValueHandler(getTotalvaluehandler());
  bean.setClearHyperlink(getManagedList23());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList22(){  List list = new ArrayList();  list.add(getInvoiceBodyAddLineAction_1161924());  list.add(getInvoiceBodyInsertLineAction_1ccc790());  list.add(getBodyDelLineAction_141e5d0());  list.add(getBodyCopyLineAction_156f4c7());  list.add(getBodyPasteLineAction_1e043dd());  list.add(getBodyPasteToTailAction_877ed3());  list.add(getActionsBar_ActionsBarSeparator_1978234());  list.add(getBodyLineEditAction_1e56350());  list.add(getRearrangeRowNoBodyLineAction_db2571());  list.add(getActionsBar_ActionsBarSeparator_177493c());  list.add(getDefaultBodyZoomAction_694384());  return list;}

private nc.ui.pu.m25.action.InvoiceBodyAddLineAction getInvoiceBodyAddLineAction_1161924(){
 if(context.get("nc.ui.pu.m25.action.InvoiceBodyAddLineAction#1161924")!=null)
 return (nc.ui.pu.m25.action.InvoiceBodyAddLineAction)context.get("nc.ui.pu.m25.action.InvoiceBodyAddLineAction#1161924");
  nc.ui.pu.m25.action.InvoiceBodyAddLineAction bean = new nc.ui.pu.m25.action.InvoiceBodyAddLineAction();
  context.put("nc.ui.pu.m25.action.InvoiceBodyAddLineAction#1161924",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pu.m25.action.InvoiceBodyInsertLineAction getInvoiceBodyInsertLineAction_1ccc790(){
 if(context.get("nc.ui.pu.m25.action.InvoiceBodyInsertLineAction#1ccc790")!=null)
 return (nc.ui.pu.m25.action.InvoiceBodyInsertLineAction)context.get("nc.ui.pu.m25.action.InvoiceBodyInsertLineAction#1ccc790");
  nc.ui.pu.m25.action.InvoiceBodyInsertLineAction bean = new nc.ui.pu.m25.action.InvoiceBodyInsertLineAction();
  context.put("nc.ui.pu.m25.action.InvoiceBodyInsertLineAction#1ccc790",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.BodyDelLineAction getBodyDelLineAction_141e5d0(){
 if(context.get("nc.ui.pubapp.uif2app.actions.BodyDelLineAction#141e5d0")!=null)
 return (nc.ui.pubapp.uif2app.actions.BodyDelLineAction)context.get("nc.ui.pubapp.uif2app.actions.BodyDelLineAction#141e5d0");
  nc.ui.pubapp.uif2app.actions.BodyDelLineAction bean = new nc.ui.pubapp.uif2app.actions.BodyDelLineAction();
  context.put("nc.ui.pubapp.uif2app.actions.BodyDelLineAction#141e5d0",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.BodyCopyLineAction getBodyCopyLineAction_156f4c7(){
 if(context.get("nc.ui.pubapp.uif2app.actions.BodyCopyLineAction#156f4c7")!=null)
 return (nc.ui.pubapp.uif2app.actions.BodyCopyLineAction)context.get("nc.ui.pubapp.uif2app.actions.BodyCopyLineAction#156f4c7");
  nc.ui.pubapp.uif2app.actions.BodyCopyLineAction bean = new nc.ui.pubapp.uif2app.actions.BodyCopyLineAction();
  context.put("nc.ui.pubapp.uif2app.actions.BodyCopyLineAction#156f4c7",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.BodyPasteLineAction getBodyPasteLineAction_1e043dd(){
 if(context.get("nc.ui.pubapp.uif2app.actions.BodyPasteLineAction#1e043dd")!=null)
 return (nc.ui.pubapp.uif2app.actions.BodyPasteLineAction)context.get("nc.ui.pubapp.uif2app.actions.BodyPasteLineAction#1e043dd");
  nc.ui.pubapp.uif2app.actions.BodyPasteLineAction bean = new nc.ui.pubapp.uif2app.actions.BodyPasteLineAction();
  context.put("nc.ui.pubapp.uif2app.actions.BodyPasteLineAction#1e043dd",bean);
  bean.setClearItems(getPasteClearItem());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction getBodyPasteToTailAction_877ed3(){
 if(context.get("nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction#877ed3")!=null)
 return (nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction)context.get("nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction#877ed3");
  nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction bean = new nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction();
  context.put("nc.ui.pubapp.uif2app.actions.BodyPasteToTailAction#877ed3",bean);
  bean.setClearItems(getPasteClearItem());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pub.beans.ActionsBar.ActionsBarSeparator getActionsBar_ActionsBarSeparator_1978234(){
 if(context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1978234")!=null)
 return (nc.ui.pub.beans.ActionsBar.ActionsBarSeparator)context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1978234");
  nc.ui.pub.beans.ActionsBar.ActionsBarSeparator bean = new nc.ui.pub.beans.ActionsBar.ActionsBarSeparator();
  context.put("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#1978234",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.BodyLineEditAction getBodyLineEditAction_1e56350(){
 if(context.get("nc.ui.pubapp.uif2app.actions.BodyLineEditAction#1e56350")!=null)
 return (nc.ui.pubapp.uif2app.actions.BodyLineEditAction)context.get("nc.ui.pubapp.uif2app.actions.BodyLineEditAction#1e56350");
  nc.ui.pubapp.uif2app.actions.BodyLineEditAction bean = new nc.ui.pubapp.uif2app.actions.BodyLineEditAction();
  context.put("nc.ui.pubapp.uif2app.actions.BodyLineEditAction#1e56350",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction getRearrangeRowNoBodyLineAction_db2571(){
 if(context.get("nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction#db2571")!=null)
 return (nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction)context.get("nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction#db2571");
  nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction bean = new nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction();
  context.put("nc.ui.pubapp.uif2app.actions.RearrangeRowNoBodyLineAction#db2571",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pub.beans.ActionsBar.ActionsBarSeparator getActionsBar_ActionsBarSeparator_177493c(){
 if(context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#177493c")!=null)
 return (nc.ui.pub.beans.ActionsBar.ActionsBarSeparator)context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#177493c");
  nc.ui.pub.beans.ActionsBar.ActionsBarSeparator bean = new nc.ui.pub.beans.ActionsBar.ActionsBarSeparator();
  context.put("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#177493c",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction getDefaultBodyZoomAction_694384(){
 if(context.get("nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction#694384")!=null)
 return (nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction)context.get("nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction#694384");
  nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction bean = new nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction();
  context.put("nc.ui.pubapp.uif2app.actions.DefaultBodyZoomAction#694384",bean);
  bean.setPos(1);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList23(){  List list = new ArrayList();  list.add("vbillcode");  return list;}

public nc.ui.pu.m25.linkquery.InvoiceLinkQueryHyperlinkMediator getParentCodeLinkQueryHyperlinkMediator(){
 if(context.get("parentCodeLinkQueryHyperlinkMediator")!=null)
 return (nc.ui.pu.m25.linkquery.InvoiceLinkQueryHyperlinkMediator)context.get("parentCodeLinkQueryHyperlinkMediator");
  nc.ui.pu.m25.linkquery.InvoiceLinkQueryHyperlinkMediator bean = new nc.ui.pu.m25.linkquery.InvoiceLinkQueryHyperlinkMediator();
  context.put("parentCodeLinkQueryHyperlinkMediator",bean);
  bean.setModel(getManageAppModel());
  bean.setSrcBillIdField("pk_parentinvoice");
  bean.setSrcBillNOField("vparentcode");
  bean.setSrcBillType("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter getBlankitemfilter(){
 if(context.get("blankitemfilter")!=null)
 return (nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter)context.get("blankitemfilter");
  nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter bean = new nc.ui.pubapp.uif2app.view.value.SingleFieldBlankChildrenFilter();
  context.put("blankitemfilter",bean);
  bean.setFieldName("pk_material");
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

public nc.ui.pubapp.uif2app.model.BillBodySortMediator getBillBodySortMediator(){
 if(context.get("billBodySortMediator")!=null)
 return (nc.ui.pubapp.uif2app.model.BillBodySortMediator)context.get("billBodySortMediator");
  nc.ui.pubapp.uif2app.model.BillBodySortMediator bean = new nc.ui.pubapp.uif2app.model.BillBodySortMediator(getManageAppModel(),getBillFormEditor(),getListView());  context.put("billBodySortMediator",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

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

public nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel getQueryInfo(){
 if(context.get("queryInfo")!=null)
 return (nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel)context.get("queryInfo");
  nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel bean = new nc.ui.uif2.tangramlayout.CardLayoutToolbarPanel();
  context.put("queryInfo",bean);
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.tangramlayout.UECardLayoutToolbarPanel getCardInfoPnl(){
 if(context.get("cardInfoPnl")!=null)
 return (nc.ui.pubapp.uif2app.tangramlayout.UECardLayoutToolbarPanel)context.get("cardInfoPnl");
  nc.ui.pubapp.uif2app.tangramlayout.UECardLayoutToolbarPanel bean = new nc.ui.pubapp.uif2app.tangramlayout.UECardLayoutToolbarPanel();
  context.put("cardInfoPnl",bean);
  bean.setTitleAction(getReturnaction());
  bean.setModel(getManageAppModel());
  bean.setRightExActions(getManagedList24());
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

private List getManagedList24(){  List list = new ArrayList();  list.add(getActionsBar_ActionsBarSeparator_cfc8c4());  list.add(getHeadZoomAction());  return list;}

private nc.ui.pub.beans.ActionsBar.ActionsBarSeparator getActionsBar_ActionsBarSeparator_cfc8c4(){
 if(context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#cfc8c4")!=null)
 return (nc.ui.pub.beans.ActionsBar.ActionsBarSeparator)context.get("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#cfc8c4");
  nc.ui.pub.beans.ActionsBar.ActionsBarSeparator bean = new nc.ui.pub.beans.ActionsBar.ActionsBarSeparator();
  context.put("nc.ui.pub.beans.ActionsBar.ActionsBarSeparator#cfc8c4",bean);
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

public nc.ui.uif2.TangramContainer getContainer(){
 if(context.get("container")!=null)
 return (nc.ui.uif2.TangramContainer)context.get("container");
  nc.ui.uif2.TangramContainer bean = new nc.ui.uif2.TangramContainer();
  context.put("container",bean);
  bean.setModel(getManageAppModel());
  bean.setTangramLayoutRoot(getTBNode_119bc99());
  bean.setActions(getManagedList26());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.TBNode getTBNode_119bc99(){
 if(context.get("nc.ui.uif2.tangramlayout.node.TBNode#119bc99")!=null)
 return (nc.ui.uif2.tangramlayout.node.TBNode)context.get("nc.ui.uif2.tangramlayout.node.TBNode#119bc99");
  nc.ui.uif2.tangramlayout.node.TBNode bean = new nc.ui.uif2.tangramlayout.node.TBNode();
  context.put("nc.ui.uif2.tangramlayout.node.TBNode#119bc99",bean);
  bean.setShowMode("CardLayout");
  bean.setTabs(getManagedList25());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList25(){  List list = new ArrayList();  list.add(getHSNode_1220019());  list.add(getVSNode_10a9a52());  return list;}

private nc.ui.uif2.tangramlayout.node.HSNode getHSNode_1220019(){
 if(context.get("nc.ui.uif2.tangramlayout.node.HSNode#1220019")!=null)
 return (nc.ui.uif2.tangramlayout.node.HSNode)context.get("nc.ui.uif2.tangramlayout.node.HSNode#1220019");
  nc.ui.uif2.tangramlayout.node.HSNode bean = new nc.ui.uif2.tangramlayout.node.HSNode();
  context.put("nc.ui.uif2.tangramlayout.node.HSNode#1220019",bean);
  bean.setLeft(getCNode_185c374());
  bean.setRight(getVSNode_17032f7());
  bean.setDividerLocation(0.22f);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_185c374(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#185c374")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#185c374");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#185c374",bean);
  bean.setComponent(getQueryArea());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.VSNode getVSNode_17032f7(){
 if(context.get("nc.ui.uif2.tangramlayout.node.VSNode#17032f7")!=null)
 return (nc.ui.uif2.tangramlayout.node.VSNode)context.get("nc.ui.uif2.tangramlayout.node.VSNode#17032f7");
  nc.ui.uif2.tangramlayout.node.VSNode bean = new nc.ui.uif2.tangramlayout.node.VSNode();
  context.put("nc.ui.uif2.tangramlayout.node.VSNode#17032f7",bean);
  bean.setUp(getCNode_e32bd2());
  bean.setDown(getCNode_df3a5b());
  bean.setDividerLocation(30f);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_e32bd2(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#e32bd2")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#e32bd2");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#e32bd2",bean);
  bean.setComponent(getQueryInfo());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_df3a5b(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#df3a5b")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#df3a5b");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#df3a5b",bean);
  bean.setName(getI18nFB_51f5c8());
  bean.setComponent(getListView());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_51f5c8(){
 if(context.get("nc.ui.uif2.I18nFB#51f5c8")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#51f5c8");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#51f5c8",bean);  bean.setResDir("common");
  bean.setResId("UC001-0000107");
  bean.setDefaultValue("列表");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#51f5c8",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private nc.ui.uif2.tangramlayout.node.VSNode getVSNode_10a9a52(){
 if(context.get("nc.ui.uif2.tangramlayout.node.VSNode#10a9a52")!=null)
 return (nc.ui.uif2.tangramlayout.node.VSNode)context.get("nc.ui.uif2.tangramlayout.node.VSNode#10a9a52");
  nc.ui.uif2.tangramlayout.node.VSNode bean = new nc.ui.uif2.tangramlayout.node.VSNode();
  context.put("nc.ui.uif2.tangramlayout.node.VSNode#10a9a52",bean);
  bean.setUp(getCNode_1347f6e());
  bean.setDown(getCNode_59461e());
  bean.setDividerLocation(30f);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_1347f6e(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#1347f6e")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#1347f6e");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#1347f6e",bean);
  bean.setComponent(getCardInfoPnl());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.tangramlayout.node.CNode getCNode_59461e(){
 if(context.get("nc.ui.uif2.tangramlayout.node.CNode#59461e")!=null)
 return (nc.ui.uif2.tangramlayout.node.CNode)context.get("nc.ui.uif2.tangramlayout.node.CNode#59461e");
  nc.ui.uif2.tangramlayout.node.CNode bean = new nc.ui.uif2.tangramlayout.node.CNode();
  context.put("nc.ui.uif2.tangramlayout.node.CNode#59461e",bean);
  bean.setName(getI18nFB_19a3240());
  bean.setComponent(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_19a3240(){
 if(context.get("nc.ui.uif2.I18nFB#19a3240")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#19a3240");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#19a3240",bean);  bean.setResDir("common");
  bean.setResId("UC001-0000106");
  bean.setDefaultValue("卡片");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#19a3240",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

private List getManagedList26(){  List list = new ArrayList();  return list;}

public nc.ui.uif2.actions.ActionContributors getToftpanelActionContributors(){
 if(context.get("toftpanelActionContributors")!=null)
 return (nc.ui.uif2.actions.ActionContributors)context.get("toftpanelActionContributors");
  nc.ui.uif2.actions.ActionContributors bean = new nc.ui.uif2.actions.ActionContributors();
  context.put("toftpanelActionContributors",bean);
  bean.setContributors(getManagedList27());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList27(){  List list = new ArrayList();  list.add(getActionsOfList());  list.add(getActionsOfCard());  return list;}

public nc.ui.uif2.actions.StandAloneToftPanelActionContainer getActionsOfList(){
 if(context.get("actionsOfList")!=null)
 return (nc.ui.uif2.actions.StandAloneToftPanelActionContainer)context.get("actionsOfList");
  nc.ui.uif2.actions.StandAloneToftPanelActionContainer bean = new nc.ui.uif2.actions.StandAloneToftPanelActionContainer(getListView());  context.put("actionsOfList",bean);
  bean.setActions(getManagedList28());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList28(){  List list = new ArrayList();  list.add(getAddMenu());  list.add(getEditAction());  list.add(getDeleteAction());  list.add(getCopyAction());  list.add(getSeparatorAction_ad1cde());  list.add(getQueryAction());  list.add(getListRefreshAction());  list.add(getSeparatorAction_1426a8f());  list.add(getSendApproveMenuAction());  list.add(getAssistMenuAction());  list.add(getSeparatorAction_1620011());  list.add(getLinkQueryMenuAction());  list.add(getSeparatorAction_f26815());  list.add(getRelatingFunctionsMenuAction());  list.add(getSeparatorAction_8f4c9f());  list.add(getInvoicePrintMenuAction());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_ad1cde(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#ad1cde")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#ad1cde");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#ad1cde",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1426a8f(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#1426a8f")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#1426a8f");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#1426a8f",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1620011(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#1620011")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#1620011");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#1620011",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_f26815(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#f26815")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#f26815");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#f26815",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_8f4c9f(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#8f4c9f")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#8f4c9f");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#8f4c9f",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public java.util.ArrayList getNormEditAction(){
 if(context.get("normEditAction")!=null)
 return (java.util.ArrayList)context.get("normEditAction");
  java.util.ArrayList bean = new java.util.ArrayList(getManagedList29());  context.put("normEditAction",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList29(){  List list = new ArrayList();  list.add(getSaveAction());  list.add(getSaveCommitAction());  list.add(getSeparatorAction_1ef8825());  list.add(getCancelAction());  list.add(getSeparatorAction_d3499e());  list.add(getRefAddRowsMenuAction());  list.add(getNormalEditAstMenuAction());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1ef8825(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#1ef8825")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#1ef8825");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#1ef8825",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_d3499e(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#d3499e")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#d3499e");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#d3499e",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.actions.StandAloneToftPanelActionContainer getActionsOfCard(){
 if(context.get("actionsOfCard")!=null)
 return (nc.ui.uif2.actions.StandAloneToftPanelActionContainer)context.get("actionsOfCard");
  nc.ui.uif2.actions.StandAloneToftPanelActionContainer bean = new nc.ui.uif2.actions.StandAloneToftPanelActionContainer(getBillFormEditor());  context.put("actionsOfCard",bean);
  bean.setActions(getManagedList30());
  bean.setEditActions(getNormEditAction());
  bean.setModel(getManageAppModel());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList30(){  List list = new ArrayList();  list.add(getAddMenu());  list.add(getEditAction());  list.add(getDeleteAction());  list.add(getCopyAction());  list.add(getSeparatorAction_18654b5());  list.add(getQueryAction());  list.add(getCardRefreshAction());  list.add(getSeparatorAction_2337db());  list.add(getSendApproveMenuAction());  list.add(getAssistMenuAction());  list.add(getSeparatorAction_281844());  list.add(getLinkQueryMenuAction());  list.add(getSeparatorAction_515910());  list.add(getRelatingFunctionsMenuAction());  list.add(getSeparatorAction_ae682c());  list.add(getInvoicePrintMenuAction());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_18654b5(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#18654b5")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#18654b5");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#18654b5",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_2337db(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#2337db")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#2337db");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#2337db",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_281844(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#281844")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#281844");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#281844",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_515910(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#515910")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#515910");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#515910",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_ae682c(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#ae682c")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#ae682c");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#ae682c",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.view.FeeInvoiceViewTransfer getFeeViewTransfer(){
 if(context.get("feeViewTransfer")!=null)
 return (nc.ui.pu.m25.view.FeeInvoiceViewTransfer)context.get("feeViewTransfer");
  nc.ui.pu.m25.view.FeeInvoiceViewTransfer bean = new nc.ui.pu.m25.view.FeeInvoiceViewTransfer();
  context.put("feeViewTransfer",bean);
  bean.setFeeCardAction(getManagedList31());
  bean.setFeeListAction(getManagedList32());
  bean.setFeeEditAction(getManagedList33());
  bean.setNormEditAction(getNormEditAction());
  bean.setActionContributor(getToftpanelActionContributors());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList31(){  List list = new ArrayList();  list.add(getNewfeeinvoice());  list.add(getEditAction());  list.add(getDeleteAction());  list.add(getCopyAction());  list.add(getSeparatorAction_395b86());  list.add(getSendApproveMenuAction());  list.add(getAssistMenuAction());  list.add(getSeparatorAction_1a7c6d6());  list.add(getRelatingFunctionsMenuActionFee());  list.add(getSeparatorAction_1ef3ba3());  list.add(getInvoicePrintMenuAction());  list.add(getRetfeeinvoice());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_395b86(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#395b86")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#395b86");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#395b86",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1a7c6d6(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#1a7c6d6")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#1a7c6d6");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#1a7c6d6",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1ef3ba3(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#1ef3ba3")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#1ef3ba3");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#1ef3ba3",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList32(){  List list = new ArrayList();  list.add(getNewfeeinvoice());  list.add(getEditAction());  list.add(getDeleteAction());  list.add(getCopyAction());  list.add(getSeparatorAction_13463f1());  list.add(getSendApproveMenuAction());  list.add(getAssistMenuAction());  list.add(getSeparatorAction_8d8cdd());  list.add(getRelatingFunctionsMenuActionFee());  list.add(getSeparatorAction_11b255a());  list.add(getInvoicePrintMenuAction());  list.add(getRetfeeinvoice());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_13463f1(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#13463f1")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#13463f1");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#13463f1",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_8d8cdd(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#8d8cdd")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#8d8cdd");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#8d8cdd",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_11b255a(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#11b255a")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#11b255a");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#11b255a",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList33(){  List list = new ArrayList();  list.add(getSaveAction());  list.add(getCancelAction());  list.add(getSendApproveAction());  return list;}

public nc.ui.pu.m25.billref.processor.InvoiceTransferListProcessor getInvoiceTransferListProcessor(){
 if(context.get("invoiceTransferListProcessor")!=null)
 return (nc.ui.pu.m25.billref.processor.InvoiceTransferListProcessor)context.get("invoiceTransferListProcessor");
  nc.ui.pu.m25.billref.processor.InvoiceTransferListProcessor bean = new nc.ui.pu.m25.billref.processor.InvoiceTransferListProcessor();
  context.put("invoiceTransferListProcessor",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.billref.dest.TransferViewProcessor getTransferViewProcessor(){
 if(context.get("transferViewProcessor")!=null)
 return (nc.ui.pubapp.billref.dest.TransferViewProcessor)context.get("transferViewProcessor");
  nc.ui.pubapp.billref.dest.TransferViewProcessor bean = new nc.ui.pubapp.billref.dest.TransferViewProcessor();
  context.put("transferViewProcessor",bean);
  bean.setList(getListView());
  bean.setActionContainer(getActionsOfList());
  bean.setCardActionContainer(getActionsOfCard());
  bean.setSaveAction(getSaveAction());
  bean.setCommitAction(getSendApproveAction());
  bean.setCancelAction(getCancelAction());
  bean.setBillForm(getBillFormEditor());
  bean.setQueryAreaShell(getQueryArea());
  bean.setQueryInfoToolbarPanel(getQueryInfo());
  bean.setTransferLogic(getDefaultBillDataLogic_13174cd());
  bean.setListProcessor(getInvoiceTransferListProcessor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.billref.dest.DefaultBillDataLogic getDefaultBillDataLogic_13174cd(){
 if(context.get("nc.ui.pubapp.billref.dest.DefaultBillDataLogic#13174cd")!=null)
 return (nc.ui.pubapp.billref.dest.DefaultBillDataLogic)context.get("nc.ui.pubapp.billref.dest.DefaultBillDataLogic#13174cd");
  nc.ui.pubapp.billref.dest.DefaultBillDataLogic bean = new nc.ui.pubapp.billref.dest.DefaultBillDataLogic();
  context.put("nc.ui.pubapp.billref.dest.DefaultBillDataLogic#13174cd",bean);
  bean.setBillForm(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.FractionFixMediator getFractionFixMediator(){
 if(context.get("fractionFixMediator")!=null)
 return (nc.ui.pubapp.uif2app.view.FractionFixMediator)context.get("fractionFixMediator");
  nc.ui.pubapp.uif2app.view.FractionFixMediator bean = new nc.ui.pubapp.uif2app.view.FractionFixMediator(getBillFormEditor(),getListView());  context.put("fractionFixMediator",bean);
  bean.initUI();
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
  bean.setBillType("25");
  bean.setBillForm(getBillFormEditor());
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.view.CompositeBillDataPrepare getUserdefAndMarAsstCardPreparator(){
 if(context.get("userdefAndMarAsstCardPreparator")!=null)
 return (nc.ui.pubapp.uif2app.view.CompositeBillDataPrepare)context.get("userdefAndMarAsstCardPreparator");
  nc.ui.pubapp.uif2app.view.CompositeBillDataPrepare bean = new nc.ui.pubapp.uif2app.view.CompositeBillDataPrepare();
  context.put("userdefAndMarAsstCardPreparator",bean);
  bean.setBillDataPrepares(getManagedList34());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList34(){  List list = new ArrayList();  list.add(getUserdefitemPreparator());  list.add(getMarAsstPreparator());  return list;}

public nc.ui.pubapp.uif2app.view.CompositeBillListDataPrepare getUserdefAndMarAsstListPreparator(){
 if(context.get("userdefAndMarAsstListPreparator")!=null)
 return (nc.ui.pubapp.uif2app.view.CompositeBillListDataPrepare)context.get("userdefAndMarAsstListPreparator");
  nc.ui.pubapp.uif2app.view.CompositeBillListDataPrepare bean = new nc.ui.pubapp.uif2app.view.CompositeBillListDataPrepare();
  context.put("userdefAndMarAsstListPreparator",bean);
  bean.setBillListDataPrepares(getManagedList35());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList35(){  List list = new ArrayList();  list.add(getUserdefitemlistPreparator());  list.add(getMarAsstPreparator());  return list;}

public nc.ui.uif2.editor.UserdefitemContainerPreparator getUserdefitemPreparator(){
 if(context.get("userdefitemPreparator")!=null)
 return (nc.ui.uif2.editor.UserdefitemContainerPreparator)context.get("userdefitemPreparator");
  nc.ui.uif2.editor.UserdefitemContainerPreparator bean = new nc.ui.uif2.editor.UserdefitemContainerPreparator();
  context.put("userdefitemPreparator",bean);
  bean.setContainer(getUserdefitemContainer());
  bean.setParams(getManagedList36());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList36(){  List list = new ArrayList();  list.add(getUserdefQueryParam_1eb4aa0());  list.add(getUserdefQueryParam_7066f4());  return list;}

private nc.ui.uif2.editor.UserdefQueryParam getUserdefQueryParam_1eb4aa0(){
 if(context.get("nc.ui.uif2.editor.UserdefQueryParam#1eb4aa0")!=null)
 return (nc.ui.uif2.editor.UserdefQueryParam)context.get("nc.ui.uif2.editor.UserdefQueryParam#1eb4aa0");
  nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
  context.put("nc.ui.uif2.editor.UserdefQueryParam#1eb4aa0",bean);
  bean.setMdfullname("pu.po_invoice");
  bean.setPos(0);
  bean.setPrefix("vdef");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.editor.UserdefQueryParam getUserdefQueryParam_7066f4(){
 if(context.get("nc.ui.uif2.editor.UserdefQueryParam#7066f4")!=null)
 return (nc.ui.uif2.editor.UserdefQueryParam)context.get("nc.ui.uif2.editor.UserdefQueryParam#7066f4");
  nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
  context.put("nc.ui.uif2.editor.UserdefQueryParam#7066f4",bean);
  bean.setMdfullname("pu.po_invoice_b");
  bean.setPos(1);
  bean.setPrefix("vbdef");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.UserdefitemContainerListPreparator getUserdefitemlistPreparator(){
 if(context.get("userdefitemlistPreparator")!=null)
 return (nc.ui.uif2.editor.UserdefitemContainerListPreparator)context.get("userdefitemlistPreparator");
  nc.ui.uif2.editor.UserdefitemContainerListPreparator bean = new nc.ui.uif2.editor.UserdefitemContainerListPreparator();
  context.put("userdefitemlistPreparator",bean);
  bean.setContainer(getUserdefitemContainer());
  bean.setParams(getManagedList37());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList37(){  List list = new ArrayList();  list.add(getUserdefQueryParam_1771d65());  list.add(getUserdefQueryParam_12afcb2());  return list;}

private nc.ui.uif2.editor.UserdefQueryParam getUserdefQueryParam_1771d65(){
 if(context.get("nc.ui.uif2.editor.UserdefQueryParam#1771d65")!=null)
 return (nc.ui.uif2.editor.UserdefQueryParam)context.get("nc.ui.uif2.editor.UserdefQueryParam#1771d65");
  nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
  context.put("nc.ui.uif2.editor.UserdefQueryParam#1771d65",bean);
  bean.setMdfullname("pu.po_invoice");
  bean.setPos(0);
  bean.setPrefix("vdef");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.editor.UserdefQueryParam getUserdefQueryParam_12afcb2(){
 if(context.get("nc.ui.uif2.editor.UserdefQueryParam#12afcb2")!=null)
 return (nc.ui.uif2.editor.UserdefQueryParam)context.get("nc.ui.uif2.editor.UserdefQueryParam#12afcb2");
  nc.ui.uif2.editor.UserdefQueryParam bean = new nc.ui.uif2.editor.UserdefQueryParam();
  context.put("nc.ui.uif2.editor.UserdefQueryParam#12afcb2",bean);
  bean.setMdfullname("pu.po_invoice_b");
  bean.setPos(1);
  bean.setTabcode("invoicebody");
  bean.setPrefix("vbdef");
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
  bean.setMaterialField("pk_material");
  bean.setProjectField("cprojectid");
  bean.setProductorField("cproductorid");
  bean.setCustomerField("casscustid");
  bean.setSignatureField("cffileid");
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
  bean.setParams(getManagedList38());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList38(){  List list = new ArrayList();  list.add(getQueryParam_1342355());  list.add(getQueryParam_1fbe1aa());  list.add(getQueryParam_19c9642());  return list;}

private nc.ui.uif2.userdefitem.QueryParam getQueryParam_1342355(){
 if(context.get("nc.ui.uif2.userdefitem.QueryParam#1342355")!=null)
 return (nc.ui.uif2.userdefitem.QueryParam)context.get("nc.ui.uif2.userdefitem.QueryParam#1342355");
  nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
  context.put("nc.ui.uif2.userdefitem.QueryParam#1342355",bean);
  bean.setMdfullname("pu.po_invoice");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.userdefitem.QueryParam getQueryParam_1fbe1aa(){
 if(context.get("nc.ui.uif2.userdefitem.QueryParam#1fbe1aa")!=null)
 return (nc.ui.uif2.userdefitem.QueryParam)context.get("nc.ui.uif2.userdefitem.QueryParam#1fbe1aa");
  nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
  context.put("nc.ui.uif2.userdefitem.QueryParam#1fbe1aa",bean);
  bean.setMdfullname("pu.po_invoice_b");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.uif2.userdefitem.QueryParam getQueryParam_19c9642(){
 if(context.get("nc.ui.uif2.userdefitem.QueryParam#19c9642")!=null)
 return (nc.ui.uif2.userdefitem.QueryParam)context.get("nc.ui.uif2.userdefitem.QueryParam#19c9642");
  nc.ui.uif2.userdefitem.QueryParam bean = new nc.ui.uif2.userdefitem.QueryParam();
  context.put("nc.ui.uif2.userdefitem.QueryParam#19c9642",bean);
  bean.setRulecode("materialassistant");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.query.InvoiceLazilyLoader getBillLazilyLoader(){
 if(context.get("billLazilyLoader")!=null)
 return (nc.ui.pu.m25.query.InvoiceLazilyLoader)context.get("billLazilyLoader");
  nc.ui.pu.m25.query.InvoiceLazilyLoader bean = new nc.ui.pu.m25.query.InvoiceLazilyLoader();
  context.put("billLazilyLoader",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad getLazyActions(){
 if(context.get("lazyActions")!=null)
 return (nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad)context.get("lazyActions");
  nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad bean = new nc.ui.pubapp.uif2app.lazilyload.ActionLazilyLoad();
  context.put("lazyActions",bean);
  bean.setModel(getManageAppModel());
  bean.setActionList(getManagedList39());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList39(){  List list = new ArrayList();  list.add(getPrintAction());  list.add(getPreviewAction());  list.add(getOutputAction());  return list;}

public nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager getLasilyLodadMediator(){
 if(context.get("LasilyLodadMediator")!=null)
 return (nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager)context.get("LasilyLodadMediator");
  nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager bean = new nc.ui.pubapp.uif2app.lazilyload.LazilyLoadManager();
  context.put("LasilyLodadMediator",bean);
  bean.setModel(getManageAppModel());
  bean.setLoader(getBillLazilyLoader());
  bean.setLazilyLoadSupporter(getManagedList40());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList40(){  List list = new ArrayList();  list.add(getLazyActions());  list.add(getCardPanelLazilyLoad_14cd32a());  list.add(getListPanelLazilyLoad_bb7f94());  return list;}

private nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad getCardPanelLazilyLoad_14cd32a(){
 if(context.get("nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad#14cd32a")!=null)
 return (nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad)context.get("nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad#14cd32a");
  nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad bean = new nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad();
  context.put("nc.ui.pubapp.uif2app.lazilyload.CardPanelLazilyLoad#14cd32a",bean);
  bean.setBillform(getBillFormEditor());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad getListPanelLazilyLoad_bb7f94(){
 if(context.get("nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad#bb7f94")!=null)
 return (nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad)context.get("nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad#bb7f94");
  nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad bean = new nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad();
  context.put("nc.ui.pubapp.uif2app.lazilyload.ListPanelLazilyLoad#bb7f94",bean);
  bean.setListView(getListView());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller getRemoteCallCombinatorCaller(){
 if(context.get("remoteCallCombinatorCaller")!=null)
 return (nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller)context.get("remoteCallCombinatorCaller");
  nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller bean = new nc.ui.uif2.editor.UIF2RemoteCallCombinatorCaller();
  context.put("remoteCallCombinatorCaller",bean);
  bean.setRemoteCallers(getManagedList41());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private List getManagedList41(){  List list = new ArrayList();  list.add(getQueryTemplateContainer());  list.add(getTemplateContainer());  list.add(getUserdefitemContainer());  return list;}

}
