package com.mexp.web.service.security;

import java.util.List;
import java.util.Set;

import org.apache.shiro.subject.SimplePrincipalCollection;

import com.mexp.web.model.Department;
import com.mexp.web.model.Staff;


public class UserSession extends SimplePrincipalCollection {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7242641310056490155L;

	private Staff staff;
	private Set<String> roles;
	private Set<String> permissions;
	private Department department;
	private List<Long> managementDepartmentIdList;
	private Department rootDepartment;
	
	public UserSession(Staff staff) {
		super(staff,  "staff");
		this.staff = staff;
	}
	
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	public Set<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	
	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Staff getStaff() {
		return staff;
	}

	public List<Long> getManagementDepartmentIdList() {
		return managementDepartmentIdList;
	}

	public void setManagementDepartmentIdList(List<Long> managementDepartmentIdList) {
		this.managementDepartmentIdList = managementDepartmentIdList;
	}

	public Department getRootDepartment() {
		return rootDepartment;
	}

	public void setRootDepartment(Department rootDepartment) {
		this.rootDepartment = rootDepartment;
	}
	
	
	
	
}
