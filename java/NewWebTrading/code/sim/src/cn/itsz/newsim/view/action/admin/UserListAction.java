package cn.itsz.newsim.view.action.admin;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import cn.itsz.newsim.common.Constants;
import cn.itsz.newsim.dto.request.UserProfileRequest;
import cn.itsz.newsim.dto.response.UserProfileResponse;
import cn.itsz.newsim.view.action.BaseAction;
import cn.itsz.newsim.view.form.RegForm;

@Controller("/nadmin/userList")
public class UserListAction extends BaseAction {
	
	@Override
	protected boolean isRequiredLogon() {
		return false;
	}

	@Override
	protected ActionForward executeAction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		UserProfileRequest model = new UserProfileRequest();
		form2Model(request, form, model, response);
		UserProfileResponse upResponse = facade.enquireUserProfileList(model);
		
		request.setAttribute("userResponse", upResponse);
		
		return mapping.findForward(Constants.Status.SUCCESS);
	}
	
	public static void form2Model(HttpServletRequest request,
			ActionForm form, UserProfileRequest destModel, HttpServletResponse response) {
		RegForm model = (RegForm)form;
		destModel.setPageNo(model.getPageNo());
//		destModel.setLoginId(model.getLoginId());
	}
}
