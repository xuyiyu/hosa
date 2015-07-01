package com.mexp.web.service.security.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.mexp.core.exceptions.ServiceException;
import com.mexp.core.utils.ConvertUtils;
import com.mexp.web.model.Authority;
import com.mexp.web.model.Department;
import com.mexp.web.model.Staff;
import com.mexp.web.service.IAuthorityService;
import com.mexp.web.service.IDepartmentService;
import com.mexp.web.service.IStaffService;
import com.mexp.web.service.security.UserSession;
import com.mexp.web.service.security.UserToken;



public class AuthRealm extends AuthorizingRealm {
	@Autowired
	@Qualifier("staffService")
	private IStaffService staffService;

	@Autowired
	@Qualifier("authorityService")
	private IAuthorityService authorityService;
	
	
	@Autowired
	@Qualifier("departmentService")
	private IDepartmentService departmentService;
	
	public AuthRealm() {
//		setCredentialsMatcher(new WebCredentialsMatcher());
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		UserSession userSession = (UserSession)principals;

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(userSession.getRoles());
		info.setStringPermissions(userSession.getPermissions());
		
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {

		UserToken userToken = (UserToken)token;
		Staff staff = staffService.getByLoginId(userToken.getUsername());

		if(staff == null) {
			staff = staffService.getByMobile(userToken.getUsername());
		}
		
		if(staff != null) {
			if(staff.getIsAvailable() == 0) {
				return null;
			}
//			staff.setLastAccess(DateConvertUtils.getCurrentDateTime());
//			staffService.update(staff);
			UserSession userSession = new UserSession(staff);
			Department department = departmentService.getById(staff.getDepartmentId());
			if(department != null) {
				userSession.setDepartment(department);
				staff.setDepartmentName(department.getName());
				List<Department> deptList = departmentService.findManagementDepartmentById(department.getId());
				@SuppressWarnings("unchecked")
				List<Long> deptIdList = ConvertUtils.convertElementPropertyToList(deptList, "id");
				userSession.setManagementDepartmentIdList(deptIdList);
				
				Long parentId = department.getParentId();
				Department rootDepartment = null;
				if(parentId > 1) {				
					rootDepartment = departmentService.getRootDepartment(department.getId());					
				} else {
					rootDepartment = department;
				}
				staff.setRootDepartment(rootDepartment);
				userSession.setRootDepartment(rootDepartment);
			}
			
			try {
				Set<String> authorityKeys = queryAuthority(staff.getId());
				userSession.setRoles(authorityKeys);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
			
			
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo();
			info.setPrincipals(userSession);
			info.setCredentials(staff.getPassword());
			return info;
		}
		return null;
	}
	
	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

	private Set<String> queryAuthority(Long staffId) {
		try {
			Set<String> authorityKeys = new HashSet<String>(); 
		
			List<Authority> authorityList = authorityService.findListByStaffId(staffId);
			if(!authorityList.isEmpty()) {
				@SuppressWarnings("unchecked")
				List<String> keysList =   ConvertUtils.convertElementPropertyToList(authorityList, "mark");
				authorityKeys.addAll(keysList);
			}
			authorityKeys.add("auth-main");
			authorityKeys.add("auth-menu");
			authorityKeys.add("auth-upload");
			authorityKeys.add("auth-modifyPassword");
			authorityKeys.add("auth-logout");
			return authorityKeys;
		} catch (Exception e) {
			e.printStackTrace();
			return new HashSet<String>();
		} 
	}
}
