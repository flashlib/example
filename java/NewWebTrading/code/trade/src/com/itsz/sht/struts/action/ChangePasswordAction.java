package com.itsz.sht.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.itsz.sht.common.DataModelUtil;
import com.itsz.sht.common.model.request.ChangePwdRequestModel;
import com.itsz.sht.common.model.response.ChangePwdResponseModel;
import com.itsz.sht.common.user.UserObject;
import com.itsz.sht.struts.form.ChangePasswordForm;
import com.itsz.sht.vp.ViewProvider;
import com.itsz.sht.vp.common.ProcessBean;

public class ChangePasswordAction extends ITSZAction {
	public ActionForward executeAction(ViewProvider vp,
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)  {
		ChangePasswordForm passwordForm = (ChangePasswordForm) form;
		ChangePwdRequestModel changePwdRequestModel = new ChangePwdRequestModel();
		DataModelUtil.form2Model(request, passwordForm, changePwdRequestModel,response);
		changePwdRequestModel.setLoginId(((UserObject)request.getSession().getAttribute("User")).getLoginName());
		ChangePwdResponseModel responseModel = facade.changePassword(changePwdRequestModel);
		ProcessBean processBean = new ProcessBean(responseModel, null, mapping, request, response);
		return vp.processChangePassword(processBean);
	}
}
