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
import com.hosa.web.service.ILocationFollowingService;
import com.hosa.core.page.Page;
import com.hosa.web.model.LocationFollowing;
import com.hosa.web.vo.query.LocationFollowingQuery;
import com.hosa.core.exceptions.ServiceException;

@Namespace("/webadmin/locationfollowing")
@Scope("prototype")
public class LocationFollowingAction extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(LocationFollowingAction.class);

	@Autowired
	@Qualifier("locationFollowingService")
	private ILocationFollowingService locationFollowingService;
	
	private java.lang.Integer id;
	
	private Page<LocationFollowing> page;
	
	private LocationFollowingQuery locationFollowingQuery;
	
	private List<java.lang.Integer> checkedIdList;
	
	private LocationFollowing locationFollowing;
	

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/locationfollowing/list")
	public String list() throws Exception {
		try {
			if(page == null) {
				page = new Page<LocationFollowing>();
			}
			if (!page.isOrderBySetted()) {
		        	page.setOrderBy("id");
					page.setOrder(Page.DESC);
				
			}
			if(locationFollowingQuery == null) {
				locationFollowingQuery = new LocationFollowingQuery();
			}
			page = locationFollowingService.findPage(page, locationFollowingQuery);
			responseSuccessJson(page, "locationfollowing.label.locationfollowing", "common.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("locationfollowing.label.locationfollowing", ex.getErrorCode()));
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
	@Action(value="/webadmin/locationfollowing/delete/save")
	public String delete() throws Exception {
		try {
			
			locationFollowingService.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "locationfollowing.label.locationfollowing", "common.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("locationfollowing.label.locationfollowing", ex.getErrorCode()));
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
	@Action(value="/webadmin/locationfollowing/add/save")
	public String add() throws Exception {
		try {			
			locationFollowingService.save(locationFollowing);
			responseSuccessJson(locationFollowing, "locationfollowing.label.locationfollowing", "common.add.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonAddErrorInfo("locationfollowing.label.locationfollowing", ex.getErrorCode()));
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
	@Action(value="/webadmin/locationfollowing/edit/save")
	public String edit() throws Exception {
		try {			
			locationFollowingService.update(locationFollowing);
			responseSuccessJson(locationFollowing, "locationfollowing.label.locationfollowing", "common.edit.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonEditErrorInfo("locationfollowing.label.locationfollowing", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	@Action(value="/webadmin/locationfollowing/input")
	public String input() throws Exception {
		try {
			locationFollowing = new LocationFollowing();
			if(id != null) {
				locationFollowing = locationFollowingService.getById(id);
			}
			responseSuccessJson(locationFollowing, "locationfollowing.label.locationfollowing", "common.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("locationfollowing.label.locationfollowing", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("input error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	
	
	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public Page<LocationFollowing> getPage() {
		return page;
	}

	public void setPage(Page<LocationFollowing> page) {
		this.page = page;
	}

	public void setLocationFollowingQuery(LocationFollowingQuery locationFollowingQuery) {
		this.locationFollowingQuery = locationFollowingQuery;
	}

	public LocationFollowingQuery getLocationFollowingQuery() {
		return locationFollowingQuery;
	}

	public List<java.lang.Integer> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<java.lang.Integer> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public LocationFollowing getLocationFollowing() {
		return locationFollowing;
	}

	public void setLocationFollowing(LocationFollowing locationFollowing) {
		this.locationFollowing = locationFollowing;
	}
	
	

}
