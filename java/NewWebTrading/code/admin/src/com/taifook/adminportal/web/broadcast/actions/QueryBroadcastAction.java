//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.1/xslt/JavaClass.xsl

package com.taifook.adminportal.web.broadcast.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.taifook.adminportal.common.Constants;
import com.taifook.adminportal.common.ServiceManager;
import com.taifook.adminportal.common.util.page.Page;
import com.taifook.adminportal.dao.BroadcastDAO;
import com.taifook.adminportal.dao.ParameterDAO;
import com.taifook.adminportal.web.broadcast.forms.BroadcastForm;

/**
 * MyEclipse Struts Creation date: 03-29-2006
 * 
 * XDoclet definition:
 * 
 * @struts.action validate="true"
 * @struts.action-forward name="success" path="/success.do"
 */
public class QueryBroadcastAction extends BaseBroadcastAction {

	// --------------------------------------------------------- Instance
	// Variables

	// --------------------------------------------------------- Methods

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward executeAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Log log = LogFactory.getLog(this.getClass());
		String forward = Constants.SUCCESS;

		try {
			BroadcastForm actionForm = (BroadcastForm) form;
			Object[] objects = this.getFiltersForDB(actionForm);
			int pageNumber = getPageNumber(request); // get current page
			// number
			int pageSize = getPageSize(); // get page size;
			Page page = ((BroadcastDAO) ServiceManager.getInstance()
					.getService(
							"com.taifook.adminportal.service.BroadcastService"))
					.findByPage(objects, pageNumber, pageSize);
			
			List result = ((ParameterDAO) ServiceManager.getInstance()
					.getService(
							"com.taifook.adminportal.service.ParameterService"))
					.loadChannels("7");			
			
			HttpSession session = request.getSession();
			session.removeAttribute(Constants.RESULT);					
			session.setAttribute(Constants.RESULT, page);
			request.setAttribute("channels",result);
			request.setAttribute(Constants.FILTER,actionForm);
			request.setAttribute(Constants.URL_PARAMETER,this.getFiltersForWeb(actionForm));
			
			forward = Constants.SUCCESS;			
		} catch (Exception e) {
			log
					.error("QueryParameterOtherAction-execute:load the page Exception!");
			log.error(e.getMessage());
			request.setAttribute(Constants.GLOBAL_ERROR,
					"query broadcast fail! " + e.getMessage());
			forward = Constants.FAILURE;
		}
		return mapping.findForward(forward);
	}



}
