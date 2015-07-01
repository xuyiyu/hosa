package com.hosa.web.web.action;

import org.apache.shiro.SecurityUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import com.hosa.web.utils.Struts2Utils;

@Namespace("/webadmin")
@Scope("prototype")
public class LogoutAction extends WebActionSupport {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5766983433660047435L;
	private static final Logger log = LoggerFactory.getLogger(LogoutAction.class);


	public String execute() throws Exception {
		try {
			SecurityUtils.getSubject().logout();
		} catch(Exception e) {
			log.error("logout error.", e);
		}
		
		Struts2Utils.getResponse().sendRedirect("adminlogin.htm"); 
		return null;
	}

	
}
