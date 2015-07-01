/*
 * Automatically generated
 */

package com.hosa.web.web.action.organization;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.hosa.core.exceptions.ServiceException;
import com.hosa.core.page.Page;
import com.hosa.web.model.Department;
import com.hosa.web.model.Role;
import com.hosa.web.service.IDepartmentService;
import com.hosa.web.service.IRoleService;
import com.hosa.web.vo.query.DepartmentQuery;
import com.hosa.web.vo.query.RoleQuery;
import com.hosa.web.web.action.WebActionSupport;

@Namespace("/webadmin/organization/department")
@Scope("prototype")
public class DepartmentAction extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(DepartmentAction.class);

	@Autowired
	@Qualifier("departmentService")
	private IDepartmentService departmentService;
	
	@Autowired
	@Qualifier("roleService")
	private IRoleService roleService;
	
	private java.lang.Long id;
	
	private Page<Department> page;
	
	private DepartmentQuery departmentQuery;
	
	private List<java.lang.Long> checkedIdList;
	
	private Department department;
	
	private List<Department> departmentList;

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		try {

			if(departmentQuery == null) {
				departmentQuery = new DepartmentQuery();
				departmentQuery.setSortColumns("level asc");
			}
//			departmentQuery.setIdList(getManagementDepartmentIdList());
			departmentQuery.setLevelBeginLike(getDepartmentLevel());
//			departmentQuery.setIdGT(1L);
			departmentList = departmentService.findList(departmentQuery);
			responseSuccessJson(departmentList, "department.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("label.department", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("list error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	public String delete() throws Exception {
		try {
			
			departmentService.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "department.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("label.department", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("delete error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}
	
	/**
	 * 保存
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		try {
			
			departmentService.saveOrUpdate(department);
			responseSuccessJson(department, "department.save.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonSaveErrorInfo("label.department", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}
	
	public String input() throws Exception {
		try {
			department = new Department();
			if(id != null) {
				department = departmentService.getById(id);
			}
			responseSuccessJson(department, "department.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("label.department", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("input error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	public String loadRole() throws Exception {
		try {
			RoleQuery roleQuery = new RoleQuery();
			roleQuery.setSortColumns("id");
			List<Role> roleyList = roleService.findList(roleQuery);
			responseSuccessJson(roleyList, "role.list.success");			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("label.role", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("list error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}
	
	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public Page<Department> getPage() {
		return page;
	}

	public void setPage(Page<Department> page) {
		this.page = page;
	}

	public void setDepartmentQuery(DepartmentQuery departmentQuery) {
		this.departmentQuery = departmentQuery;
	}

	public DepartmentQuery getDepartmentQuery() {
		return departmentQuery;
	}

	public List<java.lang.Long> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<java.lang.Long> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	
	

}
