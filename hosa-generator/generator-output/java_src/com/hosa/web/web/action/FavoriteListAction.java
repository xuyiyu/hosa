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
import com.hosa.web.service.IFavoriteListService;
import com.hosa.core.page.Page;
import com.hosa.web.model.FavoriteList;
import com.hosa.web.vo.query.FavoriteListQuery;
import com.hosa.core.exceptions.ServiceException;

@Namespace("/webadmin/favoritelist")
@Scope("prototype")
public class FavoriteListAction extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(FavoriteListAction.class);

	@Autowired
	@Qualifier("favoriteListService")
	private IFavoriteListService favoriteListService;
	
	private java.lang.Long id;
	
	private Page<FavoriteList> page;
	
	private FavoriteListQuery favoriteListQuery;
	
	private List<java.lang.Long> checkedIdList;
	
	private FavoriteList favoriteList;
	

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/favoritelist/list")
	public String list() throws Exception {
		try {
			if(page == null) {
				page = new Page<FavoriteList>();
			}
			if (!page.isOrderBySetted()) {
		        	page.setOrderBy("id");
					page.setOrder(Page.DESC);
				
			}
			if(favoriteListQuery == null) {
				favoriteListQuery = new FavoriteListQuery();
			}
			page = favoriteListService.findPage(page, favoriteListQuery);
			responseSuccessJson(page, "favoritelist.label.favoritelist", "common.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("favoritelist.label.favoritelist", ex.getErrorCode()));
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
	@Action(value="/webadmin/favoritelist/delete/save")
	public String delete() throws Exception {
		try {
			
			favoriteListService.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "favoritelist.label.favoritelist", "common.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("favoritelist.label.favoritelist", ex.getErrorCode()));
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
	@Action(value="/webadmin/favoritelist/add/save")
	public String add() throws Exception {
		try {			
			favoriteListService.save(favoriteList);
			responseSuccessJson(favoriteList, "favoritelist.label.favoritelist", "common.add.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonAddErrorInfo("favoritelist.label.favoritelist", ex.getErrorCode()));
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
	@Action(value="/webadmin/favoritelist/edit/save")
	public String edit() throws Exception {
		try {			
			favoriteListService.update(favoriteList);
			responseSuccessJson(favoriteList, "favoritelist.label.favoritelist", "common.edit.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonEditErrorInfo("favoritelist.label.favoritelist", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	@Action(value="/webadmin/favoritelist/input")
	public String input() throws Exception {
		try {
			favoriteList = new FavoriteList();
			if(id != null) {
				favoriteList = favoriteListService.getById(id);
			}
			responseSuccessJson(favoriteList, "favoritelist.label.favoritelist", "common.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("favoritelist.label.favoritelist", ex.getErrorCode()));
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

	public Page<FavoriteList> getPage() {
		return page;
	}

	public void setPage(Page<FavoriteList> page) {
		this.page = page;
	}

	public void setFavoriteListQuery(FavoriteListQuery favoriteListQuery) {
		this.favoriteListQuery = favoriteListQuery;
	}

	public FavoriteListQuery getFavoriteListQuery() {
		return favoriteListQuery;
	}

	public List<java.lang.Long> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<java.lang.Long> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public FavoriteList getFavoriteList() {
		return favoriteList;
	}

	public void setFavoriteList(FavoriteList favoriteList) {
		this.favoriteList = favoriteList;
	}
	
	

}
