/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.gaojiaoyuan.web.web.action.WebActionSupport;
import com.gaojiaoyuan.web.service.IUserFollowingService;
import com.gaojiaoyuan.core.page.Page;
import com.gaojiaoyuan.web.model.UserFollowing;
import com.gaojiaoyuan.web.vo.query.UserFollowingQuery;
import com.gaojiaoyuan.core.exceptions.ServiceException;

@Namespace("/webadmin/userfollowing")
@Scope("prototype")
public class UserFollowingAction extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(UserFollowingAction.class);

	@Autowired
	@Qualifier("userFollowingService")
	private IUserFollowingService userFollowingService;
	
	private java.lang.Long id;
	
	private Page<UserFollowing> page;
	
	private UserFollowingQuery userFollowingQuery;
	
	private List<java.lang.Long> checkedIdList;
	
	private UserFollowing userFollowing;
	

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/userfollowing/list")
	public String list() throws Exception {
		try {
			if(page == null) {
				page = new Page<UserFollowing>();
			}
			if (!page.isOrderBySetted()) {
		        	page.setOrderBy("id");
					page.setOrder(Page.DESC);
				
			}
			if(userFollowingQuery == null) {
				userFollowingQuery = new UserFollowingQuery();
			}
			page = userFollowingService.findPage(page, userFollowingQuery);
			responseSuccessJson(page, "userfollowing.label.userfollowing", "common.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("userfollowing.label.userfollowing", ex.getErrorCode()));
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
	@Action(value="/webadmin/userfollowing/delete/save")
	public String delete() throws Exception {
		try {
			
			userFollowingService.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "userfollowing.label.userfollowing", "common.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("userfollowing.label.userfollowing", ex.getErrorCode()));
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
	@Action(value="/webadmin/userfollowing/add/save")
	public String add() throws Exception {
		try {			
			userFollowingService.save(userFollowing);
			responseSuccessJson(userFollowing, "userfollowing.label.userfollowing", "common.add.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonAddErrorInfo("userfollowing.label.userfollowing", ex.getErrorCode()));
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
	@Action(value="/webadmin/userfollowing/edit/save")
	public String edit() throws Exception {
		try {			
			userFollowingService.update(userFollowing);
			responseSuccessJson(userFollowing, "userfollowing.label.userfollowing", "common.edit.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonEditErrorInfo("userfollowing.label.userfollowing", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	@Action(value="/webadmin/userfollowing/input")
	public String input() throws Exception {
		try {
			userFollowing = new UserFollowing();
			if(id != null) {
				userFollowing = userFollowingService.getById(id);
			}
			responseSuccessJson(userFollowing, "userfollowing.label.userfollowing", "common.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("userfollowing.label.userfollowing", ex.getErrorCode()));
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

	public Page<UserFollowing> getPage() {
		return page;
	}

	public void setPage(Page<UserFollowing> page) {
		this.page = page;
	}

	public void setUserFollowingQuery(UserFollowingQuery userFollowingQuery) {
		this.userFollowingQuery = userFollowingQuery;
	}

	public UserFollowingQuery getUserFollowingQuery() {
		return userFollowingQuery;
	}

	public List<java.lang.Long> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<java.lang.Long> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public UserFollowing getUserFollowing() {
		return userFollowing;
	}

	public void setUserFollowing(UserFollowing userFollowing) {
		this.userFollowing = userFollowing;
	}
	
	

}
