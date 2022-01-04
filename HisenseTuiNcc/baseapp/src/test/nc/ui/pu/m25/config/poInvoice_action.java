package nc.ui.pu.m25.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.ui.uif2.factory.AbstractJavaBeanDefinition;

public class poInvoice_action extends AbstractJavaBeanDefinition{
	private Map<String, Object> context = new HashMap();
public nc.ui.pu.m25.action.InvoiceQueryAction getQueryAction(){
 if(context.get("queryAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceQueryAction)context.get("queryAction");
  nc.ui.pu.m25.action.InvoiceQueryAction bean = new nc.ui.pu.m25.action.InvoiceQueryAction();
  context.put("queryAction",bean);
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setDataManager((nc.ui.pubapp.uif2app.query2.model.IModelDataManager)findBeanInUIF2BeanFactory("modelDataManager"));
  bean.setQryCondDLGInitializer(getInvoiceQryCondDLGInitializer());
  bean.setShowUpComponent((nc.ui.uif2.components.IAutoShowUpComponent)findBeanInUIF2BeanFactory("listView"));
  bean.setTemplateContainer((nc.ui.uif2.editor.QueryTemplateContainer)findBeanInUIF2BeanFactory("queryTemplateContainer"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.query.InvoiceQryCondDlgInitializer getInvoiceQryCondDLGInitializer(){
 if(context.get("invoiceQryCondDLGInitializer")!=null)
 return (nc.ui.pu.m25.query.InvoiceQryCondDlgInitializer)context.get("invoiceQryCondDLGInitializer");
  nc.ui.pu.m25.query.InvoiceQryCondDlgInitializer bean = new nc.ui.pu.m25.query.InvoiceQryCondDlgInitializer();
  context.put("invoiceQryCondDLGInitializer",bean);
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction getListRefreshAction(){
 if(context.get("listRefreshAction")!=null)
 return (nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction)context.get("listRefreshAction");
  nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction bean = new nc.ui.pubapp.uif2app.query2.action.DefaultRefreshAction();
  context.put("listRefreshAction",bean);
  bean.setDataManager((nc.ui.pubapp.uif2app.query2.model.IModelDataManager)findBeanInUIF2BeanFactory("modelDataManager"));
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceRefreshSingleAction getCardRefreshAction(){
 if(context.get("cardRefreshAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceRefreshSingleAction)context.get("cardRefreshAction");
  nc.ui.pu.m25.action.InvoiceRefreshSingleAction bean = new nc.ui.pu.m25.action.InvoiceRefreshSingleAction();
  context.put("cardRefreshAction",bean);
  bean.setModel((nc.ui.uif2.model.AbstractAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceEditAction getEditAction(){
 if(context.get("editAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceEditAction)context.get("editAction");
  nc.ui.pu.m25.action.InvoiceEditAction bean = new nc.ui.pu.m25.action.InvoiceEditAction();
  context.put("editAction",bean);
  bean.setModel((nc.ui.uif2.model.AbstractAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setInterceptor(getShowUpComponentInterceptor_1da8b33());
  bean.setPowercheck(true);
  bean.setPermissioncode("25");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor getShowUpComponentInterceptor_1da8b33(){
 if(context.get("nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#1da8b33")!=null)
 return (nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor)context.get("nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#1da8b33");
  nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor bean = new nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor();
  context.put("nc.ui.pubapp.uif2app.actions.interceptor.ShowUpComponentInterceptor#1da8b33",bean);
  bean.setShowUpComponent((nc.ui.uif2.components.IAutoShowUpComponent)findBeanInUIF2BeanFactory("billFormEditor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceDeleteAction getDeleteAction(){
 if(context.get("deleteAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceDeleteAction)context.get("deleteAction");
  nc.ui.pu.m25.action.InvoiceDeleteAction bean = new nc.ui.pu.m25.action.InvoiceDeleteAction();
  context.put("deleteAction",bean);
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IEditor)findBeanInUIF2BeanFactory("billFormEditor"));
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
  bean.setModel((nc.ui.pu.m25.model.InvoiceBillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceCopyAction getCopyAction(){
 if(context.get("copyAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceCopyAction)context.get("copyAction");
  nc.ui.pu.m25.action.InvoiceCopyAction bean = new nc.ui.pu.m25.action.InvoiceCopyAction();
  context.put("copyAction",bean);
  bean.setModel((nc.ui.uif2.model.AbstractAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.pubapp.uif2app.view.BillForm)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setInterceptor((nc.ui.uif2.actions.ActionInterceptor)findBeanInUIF2BeanFactory("formInterceptor"));
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
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IEditor)findBeanInUIF2BeanFactory("billFormEditor"));
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
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IEditor)findBeanInUIF2BeanFactory("billFormEditor"));
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
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IEditor)findBeanInUIF2BeanFactory("billFormEditor"));
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
  bean.setModel((nc.ui.uif2.model.AbstractAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.processor.InvoicePrintProcessor getPrintProcessor(){
 if(context.get("printProcessor")!=null)
 return (nc.ui.pu.m25.action.processor.InvoicePrintProcessor)context.get("printProcessor");
  nc.ui.pu.m25.action.processor.InvoicePrintProcessor bean = new nc.ui.pu.m25.action.processor.InvoicePrintProcessor();
  context.put("printProcessor",bean);
  bean.setModel((nc.ui.uif2.model.AbstractAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
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
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
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
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
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
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setParent((java.awt.Container)findBeanInUIF2BeanFactory("billFormEditor"));
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
  bean.setModel((nc.ui.pu.m25.model.InvoiceBillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.pu.m25.view.InvoiceBillForm)findBeanInUIF2BeanFactory("billFormEditor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceSendApAction getSendApAction(){
 if(context.get("sendApAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceSendApAction)context.get("sendApAction");
  nc.ui.pu.m25.action.InvoiceSendApAction bean = new nc.ui.pu.m25.action.InvoiceSendApAction();
  context.put("sendApAction",bean);
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IEditor)findBeanInUIF2BeanFactory("billFormEditor"));
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
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IEditor)findBeanInUIF2BeanFactory("billFormEditor"));
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
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setBtnName(getI18nFB_e8f47c());
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_e8f47c(){
 if(context.get("nc.ui.uif2.I18nFB#e8f47c")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#e8f47c");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#e8f47c",bean);  bean.setResDir("common");
  bean.setResId("2SCMPUB-000027");
  bean.setDefaultValue("保存提交");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#e8f47c",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceSendApproveAction getSendApproveAction(){
 if(context.get("sendApproveAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceSendApproveAction)context.get("sendApproveAction");
  nc.ui.pu.m25.action.InvoiceSendApproveAction bean = new nc.ui.pu.m25.action.InvoiceSendApproveAction();
  context.put("sendApproveAction",bean);
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IEditor)findBeanInUIF2BeanFactory("billFormEditor"));
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
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IEditor)findBeanInUIF2BeanFactory("billFormEditor"));
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
  bean.setModel((nc.ui.pu.m25.model.InvoiceBillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceRetFromFeeBillAction getRetfeeinvoice(){
 if(context.get("retfeeinvoice")!=null)
 return (nc.ui.pu.m25.action.InvoiceRetFromFeeBillAction)context.get("retfeeinvoice");
  nc.ui.pu.m25.action.InvoiceRetFromFeeBillAction bean = new nc.ui.pu.m25.action.InvoiceRetFromFeeBillAction();
  context.put("retfeeinvoice",bean);
  bean.setModel((nc.ui.pu.m25.model.InvoiceBillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.FeeInvoiceAddAction getNewfeeinvoice(){
 if(context.get("newfeeinvoice")!=null)
 return (nc.ui.pu.m25.action.FeeInvoiceAddAction)context.get("newfeeinvoice");
  nc.ui.pu.m25.action.FeeInvoiceAddAction bean = new nc.ui.pu.m25.action.FeeInvoiceAddAction();
  context.put("newfeeinvoice",bean);
  bean.setModel((nc.ui.uif2.model.AbstractAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setInterceptor((nc.ui.uif2.actions.ActionInterceptor)findBeanInUIF2BeanFactory("formInterceptor"));
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
  bean.setSourceBillName(getI18nFB_b09c5());
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_b09c5(){
 if(context.get("nc.ui.uif2.I18nFB#b09c5")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#b09c5");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#b09c5",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0494");
  bean.setDefaultValue("采购订单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#b09c5",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef4TAddAction getAddFrom4TAction(){
 if(context.get("addFrom4TAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef4TAddAction)context.get("addFrom4TAction");
  nc.ui.pu.m25.action.InvoiceRef4TAddAction bean = new nc.ui.pu.m25.action.InvoiceRef4TAddAction();
  context.put("addFrom4TAction",bean);
  bean.setSourceBillType("4T");
  bean.setSourceBillName(getI18nFB_ae73eb());
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_ae73eb(){
 if(context.get("nc.ui.uif2.I18nFB#ae73eb")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#ae73eb");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#ae73eb",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0490");
  bean.setDefaultValue("期初暂估单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#ae73eb",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef4TAddRowsAction getAddRowsFrom4TAction(){
 if(context.get("addRowsFrom4TAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef4TAddRowsAction)context.get("addRowsFrom4TAction");
  nc.ui.pu.m25.action.InvoiceRef4TAddRowsAction bean = new nc.ui.pu.m25.action.InvoiceRef4TAddRowsAction();
  context.put("addRowsFrom4TAction",bean);
  bean.setSourceBillType("4T");
  bean.setSourceBillName(getI18nFB_13c7df7());
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_13c7df7(){
 if(context.get("nc.ui.uif2.I18nFB#13c7df7")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#13c7df7");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#13c7df7",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0490");
  bean.setDefaultValue("期初暂估单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#13c7df7",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef21AddRowsAction getAddRowsFrom21Action(){
 if(context.get("addRowsFrom21Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef21AddRowsAction)context.get("addRowsFrom21Action");
  nc.ui.pu.m25.action.InvoiceRef21AddRowsAction bean = new nc.ui.pu.m25.action.InvoiceRef21AddRowsAction();
  context.put("addRowsFrom21Action",bean);
  bean.setSourceBillType("21");
  bean.setSourceBillName(getI18nFB_7207aa());
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_7207aa(){
 if(context.get("nc.ui.uif2.I18nFB#7207aa")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#7207aa");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#7207aa",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0494");
  bean.setDefaultValue("采购订单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#7207aa",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef45AddAction getAddFrom45Action(){
 if(context.get("addFrom45Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef45AddAction)context.get("addFrom45Action");
  nc.ui.pu.m25.action.InvoiceRef45AddAction bean = new nc.ui.pu.m25.action.InvoiceRef45AddAction();
  context.put("addFrom45Action",bean);
  bean.setSourceBillType("45");
  bean.setSourceBillName(getI18nFB_555536());
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_555536(){
 if(context.get("nc.ui.uif2.I18nFB#555536")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#555536");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#555536",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0438");
  bean.setDefaultValue("采购入库单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#555536",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef45AddRowsAction getAddRowsFrom45Action(){
 if(context.get("addRowsFrom45Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef45AddRowsAction)context.get("addRowsFrom45Action");
  nc.ui.pu.m25.action.InvoiceRef45AddRowsAction bean = new nc.ui.pu.m25.action.InvoiceRef45AddRowsAction();
  context.put("addRowsFrom45Action",bean);
  bean.setSourceBillType("45");
  bean.setSourceBillName(getI18nFB_4d5186());
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_4d5186(){
 if(context.get("nc.ui.uif2.I18nFB#4d5186")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#4d5186");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#4d5186",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0438");
  bean.setDefaultValue("采购入库单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#4d5186",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef50AddAction getAddFrom50Action(){
 if(context.get("addFrom50Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef50AddAction)context.get("addFrom50Action");
  nc.ui.pu.m25.action.InvoiceRef50AddAction bean = new nc.ui.pu.m25.action.InvoiceRef50AddAction();
  context.put("addFrom50Action",bean);
  bean.setSourceBillType("50");
  bean.setSourceBillName(getI18nFB_2369e9());
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_2369e9(){
 if(context.get("nc.ui.uif2.I18nFB#2369e9")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#2369e9");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#2369e9",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0479");
  bean.setDefaultValue("消耗汇总");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#2369e9",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef50AddRowsAction getAddRowsFrom50Action(){
 if(context.get("addRowsFrom50Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef50AddRowsAction)context.get("addRowsFrom50Action");
  nc.ui.pu.m25.action.InvoiceRef50AddRowsAction bean = new nc.ui.pu.m25.action.InvoiceRef50AddRowsAction();
  context.put("addRowsFrom50Action",bean);
  bean.setSourceBillType("50");
  bean.setSourceBillName(getI18nFB_fe56a2());
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_fe56a2(){
 if(context.get("nc.ui.uif2.I18nFB#fe56a2")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#fe56a2");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#fe56a2",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0479");
  bean.setDefaultValue("消耗汇总");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#fe56a2",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef61AddAction getAddFrom61Action(){
 if(context.get("addFrom61Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef61AddAction)context.get("addFrom61Action");
  nc.ui.pu.m25.action.InvoiceRef61AddAction bean = new nc.ui.pu.m25.action.InvoiceRef61AddAction();
  context.put("addFrom61Action",bean);
  bean.setSourceBillType("61");
  bean.setSourceBillName(getI18nFB_1e9cb1e());
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1e9cb1e(){
 if(context.get("nc.ui.uif2.I18nFB#1e9cb1e")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1e9cb1e");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1e9cb1e",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0515");
  bean.setDefaultValue("委外订单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1e9cb1e",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef61AddRowsAction getAddRowsFrom61Action(){
 if(context.get("addRowsFrom61Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef61AddRowsAction)context.get("addRowsFrom61Action");
  nc.ui.pu.m25.action.InvoiceRef61AddRowsAction bean = new nc.ui.pu.m25.action.InvoiceRef61AddRowsAction();
  context.put("addRowsFrom61Action",bean);
  bean.setSourceBillType("61");
  bean.setSourceBillName(getI18nFB_16382b());
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_16382b(){
 if(context.get("nc.ui.uif2.I18nFB#16382b")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#16382b");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#16382b",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0515");
  bean.setDefaultValue("委外订单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#16382b",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef47AddAction getAddFrom47Action(){
 if(context.get("addFrom47Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef47AddAction)context.get("addFrom47Action");
  nc.ui.pu.m25.action.InvoiceRef47AddAction bean = new nc.ui.pu.m25.action.InvoiceRef47AddAction();
  context.put("addFrom47Action",bean);
  bean.setSourceBillType("47");
  bean.setSourceBillName(getI18nFB_c1c67d());
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_c1c67d(){
 if(context.get("nc.ui.uif2.I18nFB#c1c67d")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#c1c67d");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#c1c67d",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0450");
  bean.setDefaultValue("委托加工入库单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#c1c67d",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef47AddRowsAction getAddRowsFrom47Action(){
 if(context.get("addRowsFrom47Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef47AddRowsAction)context.get("addRowsFrom47Action");
  nc.ui.pu.m25.action.InvoiceRef47AddRowsAction bean = new nc.ui.pu.m25.action.InvoiceRef47AddRowsAction();
  context.put("addRowsFrom47Action",bean);
  bean.setSourceBillType("47");
  bean.setSourceBillName(getI18nFB_1ce4c6b());
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1ce4c6b(){
 if(context.get("nc.ui.uif2.I18nFB#1ce4c6b")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1ce4c6b");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1ce4c6b",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0450");
  bean.setDefaultValue("委托加工入库单");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1ce4c6b",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceRef55E6AddAction getAddFrom55E6Action(){
 if(context.get("addFrom55E6Action")!=null)
 return (nc.ui.pu.m25.action.InvoiceRef55E6AddAction)context.get("addFrom55E6Action");
  nc.ui.pu.m25.action.InvoiceRef55E6AddAction bean = new nc.ui.pu.m25.action.InvoiceRef55E6AddAction();
  context.put("addFrom55E6Action",bean);
  bean.setSourceBillType("55E6");
  bean.setSourceBillName(getI18nFB_fb444d());
  bean.setFlowBillType(false);
  bean.setModel((nc.ui.pubapp.uif2app.model.BillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
  bean.setTransferViewProcessor((nc.ui.pubapp.billref.dest.TransferViewProcessor)findBeanInUIF2BeanFactory("transferViewProcessor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_fb444d(){
 if(context.get("nc.ui.uif2.I18nFB#fb444d")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#fb444d");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#fb444d",bean);  bean.setResDir("4001002_0");
  bean.setResId("04001002-0653");
  bean.setDefaultValue("工序委外加工费");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#fb444d",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceHqhpAction getHqhpAction(){
 if(context.get("hqhpAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceHqhpAction)context.get("hqhpAction");
  nc.ui.pu.m25.action.InvoiceHqhpAction bean = new nc.ui.pu.m25.action.InvoiceHqhpAction();
  context.put("hqhpAction",bean);
  bean.setModel((nc.ui.pu.m25.model.InvoiceBillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setEditor((nc.ui.pu.m25.view.InvoiceBillForm)findBeanInUIF2BeanFactory("billFormEditor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceFrozenAction getFrozenAction(){
 if(context.get("frozenAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceFrozenAction)context.get("frozenAction");
  nc.ui.pu.m25.action.InvoiceFrozenAction bean = new nc.ui.pu.m25.action.InvoiceFrozenAction();
  context.put("frozenAction",bean);
  bean.setModel((nc.ui.pu.m25.model.InvoiceBillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.m25.action.InvoiceUnFrozenAction getUnFrozenAction(){
 if(context.get("unFrozenAction")!=null)
 return (nc.ui.pu.m25.action.InvoiceUnFrozenAction)context.get("unFrozenAction");
  nc.ui.pu.m25.action.InvoiceUnFrozenAction bean = new nc.ui.pu.m25.action.InvoiceUnFrozenAction();
  context.put("unFrozenAction",bean);
  bean.setModel((nc.ui.pu.m25.model.InvoiceBillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.FileDocManageAction getDocMngAction(){
 if(context.get("docMngAction")!=null)
 return (nc.ui.pubapp.uif2app.actions.FileDocManageAction)context.get("docMngAction");
  nc.ui.pubapp.uif2app.actions.FileDocManageAction bean = new nc.ui.pubapp.uif2app.actions.FileDocManageAction();
  context.put("docMngAction",bean);
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pu.pub.action.PULinkQueryAction getLinkQueryBill(){
 if(context.get("linkQueryBill")!=null)
 return (nc.ui.pu.pub.action.PULinkQueryAction)context.get("linkQueryBill");
  nc.ui.pu.pub.action.PULinkQueryAction bean = new nc.ui.pu.pub.action.PULinkQueryAction();
  context.put("linkQueryBill",bean);
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
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
  bean.setModel((nc.ui.pu.m25.model.InvoiceBillManageModel)findBeanInUIF2BeanFactory("ManageAppModel"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

public nc.ui.pubapp.uif2app.actions.pflow.PFApproveStatusInfoAction getLinkQueryAuditFlowStatus(){
 if(context.get("linkQueryAuditFlowStatus")!=null)
 return (nc.ui.pubapp.uif2app.actions.pflow.PFApproveStatusInfoAction)context.get("linkQueryAuditFlowStatus");
  nc.ui.pubapp.uif2app.actions.pflow.PFApproveStatusInfoAction bean = new nc.ui.pubapp.uif2app.actions.pflow.PFApproveStatusInfoAction();
  context.put("linkQueryAuditFlowStatus",bean);
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
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
  bean.setSourceBillName(getI18nFB_412e32());
  bean.setModel((nc.ui.uif2.model.AbstractAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.setInterceptor((nc.ui.uif2.actions.ActionInterceptor)findBeanInUIF2BeanFactory("formInterceptor"));
  bean.setEditor((nc.ui.uif2.editor.IBillCardPanelEditor)findBeanInUIF2BeanFactory("billFormEditor"));
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_412e32(){
 if(context.get("nc.ui.uif2.I18nFB#412e32")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#412e32");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#412e32",bean);  bean.setResDir("common");
  bean.setResId("14004000-0000");
  bean.setDefaultValue("自制");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#412e32",product);
     return (java.lang.String)product;
}
catch(Exception e) { throw new RuntimeException(e);}}

public nc.ui.pu.m25.action.InvoiceAddMenuAction getAddMenu(){
 if(context.get("addMenu")!=null)
 return (nc.ui.pu.m25.action.InvoiceAddMenuAction)context.get("addMenu");
  nc.ui.pu.m25.action.InvoiceAddMenuAction bean = new nc.ui.pu.m25.action.InvoiceAddMenuAction();
  context.put("addMenu",bean);
  bean.setBillType("25");
  bean.setTooltip(getI18nFB_1400c24());
  bean.setActions(getManagedList3());
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
  bean.initUI();
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

private java.lang.String getI18nFB_1400c24(){
 if(context.get("nc.ui.uif2.I18nFB#1400c24")!=null)
 return (java.lang.String)context.get("nc.ui.uif2.I18nFB#1400c24");
  nc.ui.uif2.I18nFB bean = new nc.ui.uif2.I18nFB();
    context.put("&nc.ui.uif2.I18nFB#1400c24",bean);  bean.setResDir("common");
  bean.setResId("04004000-0001");
  bean.setDefaultValue("新增业务数据(Ctrl+N)");
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
 try {
     Object product = bean.getObject();
    context.put("nc.ui.uif2.I18nFB#1400c24",product);
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

private List getManagedList4(){  List list = new ArrayList();  list.add(getApproveAction());  list.add(getUnApproveAction());  list.add(getSeparatorAction_1dd25aa());  list.add(getLinkQueryAuditFlowStatus());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1dd25aa(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#1dd25aa")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#1dd25aa");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#1dd25aa",bean);
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
  bean.setModel((nc.ui.uif2.model.AbstractUIAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
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

private List getManagedList6(){  List list = new ArrayList();  list.add(getFrozenAction());  list.add(getUnFrozenAction());  list.add(getSeparatorAction_1d3fa67());  list.add(getDocMngAction());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1d3fa67(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#1d3fa67")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#1d3fa67");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#1d3fa67",bean);
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

private List getManagedList8(){  List list = new ArrayList();  list.add(getLinkQueryBill());  list.add(getSeparatorAction_1dc9397());  list.add(getLinkQueryFeeInvoice());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_1dc9397(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#1dc9397")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#1dc9397");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#1dc9397",bean);
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
  bean.setModel((nc.ui.uif2.model.AbstractAppModel)findBeanInUIF2BeanFactory("ManageAppModel"));
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

private List getManagedList12(){  List list = new ArrayList();  list.add(getPrintAction());  list.add(getPreviewAction());  list.add(getOutputAction());  list.add(getPrintCountQueryAction());  list.add(getSeparatorAction_5de015());  list.add(getPrintCombineAction());  return list;}

private nc.funcnode.ui.action.SeparatorAction getSeparatorAction_5de015(){
 if(context.get("nc.funcnode.ui.action.SeparatorAction#5de015")!=null)
 return (nc.funcnode.ui.action.SeparatorAction)context.get("nc.funcnode.ui.action.SeparatorAction#5de015");
  nc.funcnode.ui.action.SeparatorAction bean = new nc.funcnode.ui.action.SeparatorAction();
  context.put("nc.funcnode.ui.action.SeparatorAction#5de015",bean);
setBeanFacotryIfBeanFacatoryAware(bean);
invokeInitializingBean(bean);
return bean;
}

}
