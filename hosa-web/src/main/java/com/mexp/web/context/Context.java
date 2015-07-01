package com.mexp.web.context;

import java.util.List;

public class Context {

	private Long staffId;
	
	private String loginId;
	
	private Long departmentId;
	
	private Long rootDepartmentId;
	
	private String userName;
	
	private List<Long> managementDepartmentIdList;

	public Context(Long staffId) {
		this.staffId = staffId;
	}

	
	

	public Long getStaffId() {
		return staffId;
	}




	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}




	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}




	public Long getDepartmentId() {
		return departmentId;
	}




	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}




	public List<Long> getManagementDepartmentIdList() {
		return managementDepartmentIdList;
	}




	public void setManagementDepartmentIdList(List<Long> managementDepartmentIdList) {
		this.managementDepartmentIdList = managementDepartmentIdList;
	}




	public Long getRootDepartmentId() {
		return rootDepartmentId;
	}




	public void setRootDepartmentId(Long rootDepartmentId) {
		this.rootDepartmentId = rootDepartmentId;
	}
	
	
}
