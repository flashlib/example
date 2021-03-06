//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.0/xslt/JavaClass.xsl

package cn.hxex.blog.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.hxex.blog.auth.util.AuthorityUtil;
import cn.hxex.blog.dao.DaoFactory;
import cn.hxex.blog.dao.IUserDAO;
import cn.hxex.blog.model.User;
import cn.hxex.blog.struts.ext.BaseAction;
import cn.hxex.blog.struts.form.LogonForm;

/** 
 * MyEclipse Struts
 * Creation date: 07-22-2006
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class LogonAction extends BaseAction {

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) throws Exception{

		LogonForm logonForm = (LogonForm)form;
		
		IUserDAO dao = DaoFactory.getUserDAO();
		User user = dao.getUser( logonForm.getUsername() );
		if( user!=null && user.getPassword().equals( logonForm.getPassword() ) ) {
			
			AuthorityUtil.saveUser( request, user );
			return mapping.findForward( "homepage" );
		}
		addMessage( request, "logon.failed" );
		
		return mapping.getInputForward();
	}

}

