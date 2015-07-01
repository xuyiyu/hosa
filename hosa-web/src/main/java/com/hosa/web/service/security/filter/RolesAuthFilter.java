package com.hosa.web.service.security.filter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

/**
 * 扩展shiro角色认证，使url认证的角色为或的关系
 * @author allennb
 *
 */
public class RolesAuthFilter extends RolesAuthorizationFilter {
	@SuppressWarnings({"unchecked"})
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
		String requestURI = getPathWithinApplication(request);
        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            //no roles specified, so nothing to check - allow access.
            return true;
        }

        Set<String> roles = CollectionUtils.asSet(rolesArray);
        for(String role: roles) {
        	if(subject.hasRole(role)) {
        		return true;
        	}
        }
        return false;
    }
}
