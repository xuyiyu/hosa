/*
 * Automatically generated
 */

package com.hosa.web.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.hosa.web.web.action.WebActionSupport;
import com.hosa.web.service.IUserService;
import com.hosa.core.page.Page;
import com.hosa.web.model.User;
import com.hosa.web.vo.query.UserQuery;
import com.hosa.core.exceptions.ServiceException;

@Namespace("/webadmin/user")
@Scope("prototype")
public class UserAction extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(UserAction.class);

	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	private java.lang.Long id;
	
	private Page<User> page;
	
	private UserQuery userQuery;
	
	private List<java.lang.Long> checkedIdList;
	
	private User user;
	

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/user/list")
	public String list() throws Exception {
		try {
			if(page == null) {
				page = new Page<User>();
			}
			if (!page.isOrderBySetted()) {
		        	page.setOrderBy("id");
					page.setOrder(Page.DESC);
				
			}
			if(userQuery == null) {
				userQuery = new UserQuery();
			}
			page = userService.findPage(page, userQuery);
			responseSuccessJson(page, "user.label.user", "common.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("user.label.user", ex.getErrorCode()));
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
	@Action(value="/webadmin/user/delete/save")
	public String delete() throws Exception {
		try {
			
			userService.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "user.label.user", "common.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("user.label.user", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("delete error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}
	
	/**
	 * 新增保存
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/user/add/save")
	public String add() throws Exception {
		try {			
			userService.save(user);
			responseSuccessJson(user, "user.label.user", "common.add.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonAddErrorInfo("user.label.user", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}
	
	/**
	 * 修改保存
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/user/edit/save")
	public String edit() throws Exception {
		try {			
			userService.update(user);
			responseSuccessJson(user, "user.label.user", "common.edit.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonEditErrorInfo("user.label.user", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	@Action(value="/webadmin/user/input")
	public String input() throws Exception {
		try {
			user = new User();
			if(id != null) {
				user = userService.getById(id);
			}
			responseSuccessJson(user, "user.label.user", "common.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("user.label.user", ex.getErrorCode()));
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

	public Page<User> getPage() {
		return page;
	}

	public void setPage(Page<User> page) {
		this.page = page;
	}

	public void setUserQuery(UserQuery userQuery) {
		this.userQuery = userQuery;
	}

	public UserQuery getUserQuery() {
		return userQuery;
	}

	public List<java.lang.Long> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<java.lang.Long> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
