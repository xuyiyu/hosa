/*
 * Automatically generated
 */

package com.hosa.web.web.action.organization;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
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
import com.hosa.web.model.Staff;
import com.hosa.web.service.IDepartmentService;
import com.hosa.web.service.IRoleService;
import com.hosa.web.service.IStaffService;
import com.hosa.web.vo.query.DepartmentQuery;
import com.hosa.web.vo.query.RoleQuery;
import com.hosa.web.vo.query.StaffQuery;
import com.hosa.web.web.action.WebActionSupport;

@Namespace("/webadmin/organization/staff")
@Scope("prototype")
public class StaffAction extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(StaffAction.class);

	@Autowired
	@Qualifier("staffService")
	private IStaffService staffService;
	
	@Autowired
	@Qualifier("departmentService")
	private IDepartmentService departmentService;
	
	@Autowired
	@Qualifier("roleService")
	private IRoleService roleService;
	
	private java.lang.Long id;
	
	private Page<Staff> page;
	
	private StaffQuery staffQuery;
	
	private List<java.lang.Long> checkedIdList;
	
	private Staff staff;
	

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		try {
			if(page == null) {
				page = new Page<Staff>();
			}
			if (!page.isOrderBySetted()) {
		        	page.setOrderBy("id");
					page.setOrder(Page.DESC);
				
			}
			if(staffQuery == null) {
				staffQuery = new StaffQuery();
			}
			staffQuery.setIdGT(1L);
			staffQuery.setDepartmentIdList(getManagementDepartmentIdList());
			page = staffService.findPage(page, staffQuery);
			responseSuccessJson(page, "staff.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("label.staff", ex.getErrorCode()));
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
			
			staffService.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "staff.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("label.staff", ex.getErrorCode()));
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
			
			staffService.saveOrUpdate(staff);
			responseSuccessJson(staff, "staff.save.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonSaveErrorInfo("label.staff", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}
	
	public String input() throws Exception {
		try {
			staff = new Staff();
			if(id != null) {
				staff = staffService.getById(id);
			}
			responseSuccessJson(staff, "staff.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("label.staff", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("input error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	public String loadDepartment() throws Exception {
		try {
			DepartmentQuery departmentQuery = new DepartmentQuery();
			departmentQuery.setSortColumns("level asc");
			departmentQuery.setIdList(getManagementDepartmentIdList());
			List<Department> departmentList = departmentService.findList(departmentQuery);
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
	
	@Action(value="/webadmin/savePassword")
	public String savePassword() throws Exception {
		try {
//			String password = Struts2Utils.getParameter("password");
//			String newPassword = Struts2Utils.getParameter("password");
//			staff.setId(id);
//			staff.setPassword(password);
//			staff.setNewPassword(newPassword);
			staffService.savePassword(staff);
			responseSuccessJson(staff, "staff.save.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonSaveErrorInfo("label.staff", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
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

	public Page<Staff> getPage() {
		return page;
	}

	public void setPage(Page<Staff> page) {
		this.page = page;
	}

	public void setStaffQuery(StaffQuery staffQuery) {
		this.staffQuery = staffQuery;
	}

	public StaffQuery getStaffQuery() {
		return staffQuery;
	}

	public List<java.lang.Long> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<java.lang.Long> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	

}
