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
import com.hosa.web.service.ILocationService;
import com.hosa.core.page.Page;
import com.hosa.web.model.Location;
import com.hosa.web.vo.query.LocationQuery;
import com.hosa.core.exceptions.ServiceException;

@Namespace("/webadmin/location")
@Scope("prototype")
public class LocationAction extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(LocationAction.class);

	@Autowired
	@Qualifier("locationService")
	private ILocationService locationService;
	
	private java.lang.Long id;
	
	private Page<Location> page;
	
	private LocationQuery locationQuery;
	
	private List<java.lang.Long> checkedIdList;
	
	private Location location;
	

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/location/list")
	public String list() throws Exception {
		try {
			if(page == null) {
				page = new Page<Location>();
			}
			if (!page.isOrderBySetted()) {
		        	page.setOrderBy("id");
					page.setOrder(Page.DESC);
				
			}
			if(locationQuery == null) {
				locationQuery = new LocationQuery();
			}
			page = locationService.findPage(page, locationQuery);
			responseSuccessJson(page, "location.label.location", "common.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("location.label.location", ex.getErrorCode()));
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
	@Action(value="/webadmin/location/delete/save")
	public String delete() throws Exception {
		try {
			
			locationService.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "location.label.location", "common.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("location.label.location", ex.getErrorCode()));
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
	@Action(value="/webadmin/location/add/save")
	public String add() throws Exception {
		try {			
			locationService.save(location);
			responseSuccessJson(location, "location.label.location", "common.add.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonAddErrorInfo("location.label.location", ex.getErrorCode()));
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
	@Action(value="/webadmin/location/edit/save")
	public String edit() throws Exception {
		try {			
			locationService.update(location);
			responseSuccessJson(location, "location.label.location", "common.edit.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonEditErrorInfo("location.label.location", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	@Action(value="/webadmin/location/input")
	public String input() throws Exception {
		try {
			location = new Location();
			if(id != null) {
				location = locationService.getById(id);
			}
			responseSuccessJson(location, "location.label.location", "common.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("location.label.location", ex.getErrorCode()));
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

	public Page<Location> getPage() {
		return page;
	}

	public void setPage(Page<Location> page) {
		this.page = page;
	}

	public void setLocationQuery(LocationQuery locationQuery) {
		this.locationQuery = locationQuery;
	}

	public LocationQuery getLocationQuery() {
		return locationQuery;
	}

	public List<java.lang.Long> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<java.lang.Long> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	

}
