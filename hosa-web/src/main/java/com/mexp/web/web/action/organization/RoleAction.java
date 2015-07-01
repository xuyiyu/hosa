/*
 * Automatically generated
 */

package com.mexp.web.web.action.organization;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.mexp.core.exceptions.ServiceException;
import com.mexp.core.page.Page;
import com.mexp.web.model.Authority;
import com.mexp.web.model.Role;
import com.mexp.web.service.IAuthorityService;
import com.mexp.web.service.IRoleService;
import com.mexp.web.vo.query.AuthorityQuery;
import com.mexp.web.vo.query.RoleQuery;
import com.mexp.web.web.action.WebActionSupport;

@Namespace("/webadmin/organization/role")
@Scope("prototype")
public class RoleAction extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(RoleAction.class);

	@Autowired
	@Qualifier("roleService")
	private IRoleService roleService;
	
	@Autowired
	@Qualifier("authorityService")
	private IAuthorityService authorityService;
	
	private java.lang.Long id;
	
	private Page<Role> page;
	
	private RoleQuery roleQuery;
	
	private List<java.lang.Long> checkedIdList;
	
	private Role role;

	private List<Role> roleList;
	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		try {
			
			if(roleQuery == null) {
				roleQuery = new RoleQuery();
			}
			roleQuery.setSortColumns("id desc");
			roleList = roleService.findList(roleQuery);
			responseSuccessJson(roleList, "role.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("label.role", ex.getErrorCode()));
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
			
			roleService.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "role.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("label.role", ex.getErrorCode()));
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
			
			roleService.saveOrUpdate(role);
			responseSuccessJson(role, "role.save.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonSaveErrorInfo("label.role", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}
	
	public String input() throws Exception {
		try {
			role = new Role();
			if(id != null) {
				role = roleService.getById(id);
			}
			responseSuccessJson(role, "role.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("label.role", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("input error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	public String loadAuthority() throws Exception {
		try {
			AuthorityQuery authorityQuery = new AuthorityQuery();
			authorityQuery.setSortColumns("id");
			List<Authority> authorityList = authorityService.findList(authorityQuery);
			responseSuccessJson(authorityList, "authority.list.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("label.authority", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("input error.", e);
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

	public Page<Role> getPage() {
		return page;
	}

	public void setPage(Page<Role> page) {
		this.page = page;
	}

	public void setRoleQuery(RoleQuery roleQuery) {
		this.roleQuery = roleQuery;
	}

	public RoleQuery getRoleQuery() {
		return roleQuery;
	}

	public List<java.lang.Long> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<java.lang.Long> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	

}
