package com.hosa.web.web.interceptor;

import org.apache.shiro.SecurityUtils;
import org.apache.struts2.StrutsStatics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hosa.web.context.Context;
import com.hosa.web.context.ContextHolder;
import com.hosa.web.model.Staff;
import com.hosa.web.service.security.UserSession;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**
 * 
 * @author allennb
 *
 */
public class CommonInterceptor extends AbstractInterceptor implements StrutsStatics {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4655990102064340928L;
	private static final Logger log = LoggerFactory.getLogger(CommonInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		final Object action = invocation.getAction();
		UserSession session = (UserSession)SecurityUtils.getSubject().getPrincipals();
		Staff staff = (Staff)SecurityUtils.getSubject().getPrincipal();
		if(staff != null && session != null) {
			Context context = new Context(staff.getId());
			context.setLoginId(staff.getLoginId());
			context.setUserName(staff.getName());
			context.setDepartmentId(staff.getDepartmentId());
			context.setManagementDepartmentIdList(session.getManagementDepartmentIdList());
			context.setRootDepartmentId(staff.getRootDepartment().getId());
			ContextHolder.set(context);
			
		}
		
		return invocation.invoke();
	}
}
