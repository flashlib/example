package com.taifook.adminportal.web.ipo.action;

import java.util.List;
import java.util.Date;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.taifook.adminportal.web.ipo.delegate.IPOMaintenanceDelegate;
import com.taifook.adminportal.web.ipo.exception.IPOMaintenanceException;
import com.taifook.adminportal.web.ipo.form.IPOAddForm;
import com.taifook.adminportal.web.ipo.dto.IPORecord;
import com.taifook.adminportal.common.BaseAction;
import com.taifook.adminportal.common.Constants;
import com.taifook.adminportal.web.ipo.WebActionError;

/**
 * @struts.action
 *    path="/ipo/IPOStatusMngAction"
 *    name="IPOAddForm"
 *
 * @struts.action-forward
 *    name="success"
 *    path="/jsp/eipo/viewIPO.jsp"
 *    redirect="false"
 *
 * @struts.action-forward
 *    name="timefailure"
 *    path="/jsp/eipo/timeerr.jsp"
 *    redirect="false"
 *
 * @struts.action-forward
 *    name="failure"
 *    path="/jsp/eipo/oprtErr.jsp"
 *    redirect="false"
 **/

public class IPOStatusMngAction
    extends BaseAction {

  public IPOStatusMngAction() {
  }

  public ActionForward executeAction(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response) throws
      Exception {

    String forwardTarget = Constants.FAILURE;
    ActionErrors errors = new ActionErrors();
    IPOAddForm ipoAddForm = (IPOAddForm) form;

    try {
      String ipoStatus = ipoAddForm.getStatus();
      long ipoMasterId = 0;
      ipoMasterId = ipoAddForm.getIpoMasterId().longValue();

      IPORecord ipoRecord = new IPORecord();
      IPOMaintenanceDelegate ipoMaintenanceDelegate = new
          IPOMaintenanceDelegate();

      ipoRecord = ipoMaintenanceDelegate.getIPORecord(ipoMasterId);
      Date applyDate = new Date();
      String nowTime = new Timestamp(applyDate.getTime()).toString();
      String deadLine = ipoRecord.getDeadLine().toString();
      if (nowTime.compareTo(deadLine) >= 0) {
        forwardTarget = "time" + Constants.SUCCESS;
        return mapping.findForward(forwardTarget);
      }
      ipoRecord.setStatus(ipoStatus);
      ipoMaintenanceDelegate.updateIPORecord(ipoMasterId, ipoRecord);

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

        //int pageNum = new Float(recordNum / 20).intValue() + 1;
        request.setAttribute("ipoRecordList", ipoRecordList);
        request.setAttribute("pageNum", Integer.toString(pageNum));
      }

      String pageNo = ipoAddForm.getPageNo();
      request.setAttribute("pageNo", pageNo);
      forwardTarget = Constants.SUCCESS;
    }
    catch (Exception bme) {
      errors.add(ActionErrors.GLOBAL_ERROR,
                 new WebActionError(
          "errors.ipoInsertForm.ipoMaintenanceError"));
    }

    if (!errors.isEmpty()) {
      saveErrors(request, errors);
    }

    return mapping.findForward(forwardTarget);

  }
}
