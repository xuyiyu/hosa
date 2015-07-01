/*
 * Automatically generated
 */

package com.mexp.web.web.action.system;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import com.mexp.web.web.action.WebActionSupport;
import com.mexp.web.service.ISettingsService;
import com.mexp.core.page.Page;
import com.mexp.web.model.Settings;
import com.mexp.web.vo.query.SettingsQuery;
import com.mexp.core.exceptions.ServiceException;

@Namespace("/webadmin/system/settings")
@Scope("prototype")
public class SettingsAction extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(SettingsAction.class);

	@Autowired
	@Qualifier("settingsService")
	private ISettingsService settingsService;
	
	private java.lang.Long id;
	
	private Page<Settings> page;
	
	private SettingsQuery settingsQuery;
	
	private List<java.lang.Long> checkedIdList;
	
	private Settings settings;
	
	private List<Settings> settingList;
	

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		try {
			/*if(page == null) {
				page = new Page<Settings>();
			}
			if (!page.isOrderBySetted()) {
		        	page.setOrderBy("id");
					page.setOrder(Page.DESC);
				
			}*/
			if(settingsQuery == null) {
				settingsQuery = new SettingsQuery();
			}
			settingsQuery.setDepartmentId(getRootDepartmentId());
			settingList = settingsService.findList(settingsQuery);
			responseSuccessJson(settingList, "settings.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("label.settings", ex.getErrorCode()));
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
			
			settingsService.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "settings.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("label.settings", ex.getErrorCode()));
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
			settings.setDepartmentId(getRootDepartmentId());
			settingsService.saveVariableToCache(settings);
			responseSuccessJson(settings, "settings.save.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonSaveErrorInfo("label.settings", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}
	
	public String input() throws Exception {
		try {
			settings = new Settings();
			if(id != null) {
				settings = settingsService.getById(id);
			}
			responseSuccessJson(settings, "settings.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("label.settings", ex.getErrorCode()));
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

	public Page<Settings> getPage() {
		return page;
	}

	public void setPage(Page<Settings> page) {
		this.page = page;
	}

	public void setSettingsQuery(SettingsQuery settingsQuery) {
		this.settingsQuery = settingsQuery;
	}

	public SettingsQuery getSettingsQuery() {
		return settingsQuery;
	}

	public List<java.lang.Long> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<java.lang.Long> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public Settings getSettings() {
		return settings;
	}

	public void setSettings(Settings settings) {
		this.settings = settings;
	}

	public List<Settings> getSettingList() {
		return settingList;
	}

	public void setSettingList(List<Settings> settingList) {
		this.settingList = settingList;
	}
	
	

}
