package com.taifook.adminportal.web.ipo.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.taifook.adminportal.web.ipo.delegate.IPOMaintenanceDelegate;
import com.taifook.adminportal.web.ipo.exception.IPOMaintenanceException;
import com.taifook.adminportal.web.ipo.form.IPORequestForm;
import com.taifook.adminportal.common.BaseAction;
import com.taifook.adminportal.common.Constants;
import com.taifook.adminportal.web.ipo.WebActionError;

/**
 *
 * @struts.action
 *    path="/eipo/IPOQueryAllAction"
 *    name="IPORequestForm"
 *
 * @struts.action-forward
 *    name="success"
 *    path="/jsp/eipo/viewIPO.jsp"
 *    redirect="false"
 *
 * @struts.action-forward
 *    name="failure"
 *    path="/jsp/eipo/oprtErr.jsp"
 *    redirect="false"
 **/

public class IPOQueryAllAction
    extends BaseAction {

  public IPOQueryAllAction() {
  }

  public ActionForward executeAction(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws
      Exception {

    String forwardTarget = Constants.FAILURE;
    ActionErrors errors = new ActionErrors();
    IPORequestForm ipoRequestForm = (IPORequestForm) form;

    try {
      IPOMaintenanceDelegate ipoMaintenanceDelegate = new
          IPOMaintenanceDelegate();

      List ipoRecordList = (List) ipoMaintenanceDelegate.getAllIPORecord();

      if (ipoRecordList.size() > 0) {
        int recordNum = ipoRecordList.size();

        int pageNum = 1;
        float mod = recordNum % 20;
        if (mod == 0) {
          pageNum = new Float(recordNum / 20).intValue();
        }
        else {
          pageNum = new Float(recordNum / 20).intValue() + 1;
        }

        // int pageNum =   new Float(recordNum/20).intValue()+1;
        request.setAttribute("ipoRecordList", ipoRecordList);
        request.setAttribute("pageNum", Integer.toString(pageNum));
      }
      forwardTarget = Constants.SUCCESS;
    }
    catch (Exception bme) {
      errors.add(ActionErrors.GLOBAL_ERROR,
                 new WebActionError("errors.ipoRequestForm.ipoMaintenanceError"));
    }

    if (!errors.isEmpty()) {
      saveErrors(request, errors);
    }

    return mapping.findForward(forwardTarget);

  }
}
