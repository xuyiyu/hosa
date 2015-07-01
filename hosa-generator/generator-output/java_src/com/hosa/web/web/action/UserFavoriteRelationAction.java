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
import com.hosa.web.service.IUserFavoriteRelationService;
import com.hosa.core.page.Page;
import com.hosa.web.model.UserFavoriteRelation;
import com.hosa.web.vo.query.UserFavoriteRelationQuery;
import com.hosa.core.exceptions.ServiceException;

@Namespace("/webadmin/userfavoriterelation")
@Scope("prototype")
public class UserFavoriteRelationAction extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(UserFavoriteRelationAction.class);

	@Autowired
	@Qualifier("userFavoriteRelationService")
	private IUserFavoriteRelationService userFavoriteRelationService;
	
	private java.lang.Long id;
	
	private Page<UserFavoriteRelation> page;
	
	private UserFavoriteRelationQuery userFavoriteRelationQuery;
	
	private List<java.lang.Long> checkedIdList;
	
	private UserFavoriteRelation userFavoriteRelation;
	

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/userfavoriterelation/list")
	public String list() throws Exception {
		try {
			if(page == null) {
				page = new Page<UserFavoriteRelation>();
			}
			if (!page.isOrderBySetted()) {
		        	page.setOrderBy("id");
					page.setOrder(Page.DESC);
				
			}
			if(userFavoriteRelationQuery == null) {
				userFavoriteRelationQuery = new UserFavoriteRelationQuery();
			}
			page = userFavoriteRelationService.findPage(page, userFavoriteRelationQuery);
			responseSuccessJson(page, "userfavoriterelation.label.userfavoriterelation", "common.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("userfavoriterelation.label.userfavoriterelation", ex.getErrorCode()));
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
	@Action(value="/webadmin/userfavoriterelation/delete/save")
	public String delete() throws Exception {
		try {
			
			userFavoriteRelationService.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "userfavoriterelation.label.userfavoriterelation", "common.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("userfavoriterelation.label.userfavoriterelation", ex.getErrorCode()));
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
	@Action(value="/webadmin/userfavoriterelation/add/save")
	public String add() throws Exception {
		try {			
			userFavoriteRelationService.save(userFavoriteRelation);
			responseSuccessJson(userFavoriteRelation, "userfavoriterelation.label.userfavoriterelation", "common.add.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonAddErrorInfo("userfavoriterelation.label.userfavoriterelation", ex.getErrorCode()));
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
	@Action(value="/webadmin/userfavoriterelation/edit/save")
	public String edit() throws Exception {
		try {			
			userFavoriteRelationService.update(userFavoriteRelation);
			responseSuccessJson(userFavoriteRelation, "userfavoriterelation.label.userfavoriterelation", "common.edit.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonEditErrorInfo("userfavoriterelation.label.userfavoriterelation", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	@Action(value="/webadmin/userfavoriterelation/input")
	public String input() throws Exception {
		try {
			userFavoriteRelation = new UserFavoriteRelation();
			if(id != null) {
				userFavoriteRelation = userFavoriteRelationService.getById(id);
			}
			responseSuccessJson(userFavoriteRelation, "userfavoriterelation.label.userfavoriterelation", "common.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("userfavoriterelation.label.userfavoriterelation", ex.getErrorCode()));
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

	public Page<UserFavoriteRelation> getPage() {
		return page;
	}

	public void setPage(Page<UserFavoriteRelation> page) {
		this.page = page;
	}

	public void setUserFavoriteRelationQuery(UserFavoriteRelationQuery userFavoriteRelationQuery) {
		this.userFavoriteRelationQuery = userFavoriteRelationQuery;
	}

	public UserFavoriteRelationQuery getUserFavoriteRelationQuery() {
		return userFavoriteRelationQuery;
	}

	public List<java.lang.Long> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<java.lang.Long> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public UserFavoriteRelation getUserFavoriteRelation() {
		return userFavoriteRelation;
	}

	public void setUserFavoriteRelation(UserFavoriteRelation userFavoriteRelation) {
		this.userFavoriteRelation = userFavoriteRelation;
	}
	
	

}
