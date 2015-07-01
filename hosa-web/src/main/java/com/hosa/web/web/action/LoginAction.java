package com.hosa.web.web.action;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.hosa.core.exceptions.ServiceException;
import com.hosa.core.utils.DateConvertUtils;
import com.hosa.core.utils.StringCodeUtils;
import com.hosa.web.context.Context;
import com.hosa.web.context.ContextHolder;
import com.hosa.web.model.Staff;
import com.hosa.web.service.ILoginService;
import com.hosa.web.service.IStaffService;
import com.hosa.web.service.security.UserSession;
import com.hosa.web.utils.Struts2Utils;


@Namespace("/webadmin")
@Scope("prototype")
public class LoginAction extends WebActionSupport {

	private static final Logger log = LoggerFactory.getLogger(LoginAction.class);

	@Autowired
	@Qualifier("loginService")
	private ILoginService loginService;
	
	@Autowired
	@Qualifier("staffService")
	private IStaffService staffService;
	
	
	
	private String j_username;
	private String j_password;
	private String j_code;
	private boolean rememberMe;
	
	private int errorCode;
	private String errorInfo;
	

	
	@Action(results={@Result(name="main", location="/webadmin/main.htm", type = "redirect"),
			@Result(name="login", location="/webadmin/adminlogin.htm", type = "redirect", params = {"errorInfo","${errorInfo}"})})	
	public String execute() throws Exception {
		
		String authenticityToken = Struts2Utils.getParameter("authenticity_token");
		long expires = 0L;
		try {
			expires = Long.parseLong(StringCodeUtils.decode(authenticityToken));
			Date currentDate = DateConvertUtils.getCurrentDateTime();
			if((currentDate.getTime() - expires) > 300000) {
				throw new ServiceException("Verification code expired.", "login.failure.verificationcodeexpired");
			}
			
			String captcha = StringUtils.substring(StringCodeUtils.md5(authenticityToken), 5, 9);
			if(!captcha.equalsIgnoreCase(j_code)) {
				throw new ServiceException("Verification code error.", "login.failure.verificationcodeerror");
			}
			
		} catch(Exception e) {
			errorInfo = getText("common.verificationcode.error");
			//addActionMessage(errorInfo);
			return "login";
		}

		
		try {
			loginService.login(j_username, j_password, rememberMe);
			
			UserSession session = (UserSession)SecurityUtils.getSubject().getPrincipals();
			Staff staff = (Staff)SecurityUtils.getSubject().getPrincipal();
			if(staff != null && session != null) {
				Context context = new Context(staff.getId());
				context.setLoginId(staff.getLoginId());
				context.setUserName(staff.getName());
				context.setDepartmentId(staff.getDepartmentId());
				context.setManagementDepartmentIdList(session.getManagementDepartmentIdList());
				ContextHolder.set(context);
				
			}
			
//			Long staffId = getStaffId();
//			Staff staff = staffService.getById(staffId);
//			staff.setId(staffId);
			staff.setLastAccess(DateConvertUtils.getCurrentDateTime());
			staffService.update(staff);
			
			
		} catch(ServiceException e) {
			log.warn(" login failure.", e);
			errorInfo = getErrorInfo(e);
			return "login";
		} catch(Exception e) {
			log.warn(" login error.", e);
			errorInfo = getCommonErrorInfo();
			return "login";
		}
		
		
		return "main";
	}

	@Action(value="/commons/refreshCaptcha")
	public String refreshCaptcha() throws Exception {
		String authenticityToken = (String) Struts2Utils.getRequest().getAttribute("authenticity_token");
		Struts2Utils.renderText(authenticityToken);
		return null;
	}



	public String getJ_username() {
		return j_username;
	}





	public void setJ_username(String j_username) {
		this.j_username = j_username;
	}





	public String getJ_password() {
		return j_password;
	}





	public void setJ_password(String j_password) {
		this.j_password = j_password;
	}





	public String getJ_code() {
		return j_code;
	}





	public void setJ_code(String j_code) {
		this.j_code = j_code;
	}





	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	
	
}
