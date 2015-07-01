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
import com.hosa.web.service.IFavoriteService;
import com.hosa.core.page.Page;
import com.hosa.web.model.Favorite;
import com.hosa.web.vo.query.FavoriteQuery;
import com.hosa.core.exceptions.ServiceException;

@Namespace("/webadmin/favorite")
@Scope("prototype")
public class FavoriteAction extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(FavoriteAction.class);

	@Autowired
	@Qualifier("favoriteService")
	private IFavoriteService favoriteService;
	
	private java.lang.Long id;
	
	private Page<Favorite> page;
	
	private FavoriteQuery favoriteQuery;
	
	private List<java.lang.Long> checkedIdList;
	
	private Favorite favorite;
	

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/favorite/list")
	public String list() throws Exception {
		try {
			if(page == null) {
				page = new Page<Favorite>();
			}
			if (!page.isOrderBySetted()) {
		        	page.setOrderBy("id");
					page.setOrder(Page.DESC);
				
			}
			if(favoriteQuery == null) {
				favoriteQuery = new FavoriteQuery();
			}
			page = favoriteService.findPage(page, favoriteQuery);
			responseSuccessJson(page, "favorite.label.favorite", "common.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("favorite.label.favorite", ex.getErrorCode()));
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
	@Action(value="/webadmin/favorite/delete/save")
	public String delete() throws Exception {
		try {
			
			favoriteService.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "favorite.label.favorite", "common.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("favorite.label.favorite", ex.getErrorCode()));
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
	@Action(value="/webadmin/favorite/add/save")
	public String add() throws Exception {
		try {			
			favoriteService.save(favorite);
			responseSuccessJson(favorite, "favorite.label.favorite", "common.add.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonAddErrorInfo("favorite.label.favorite", ex.getErrorCode()));
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
	@Action(value="/webadmin/favorite/edit/save")
	public String edit() throws Exception {
		try {			
			favoriteService.update(favorite);
			responseSuccessJson(favorite, "favorite.label.favorite", "common.edit.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonEditErrorInfo("favorite.label.favorite", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	@Action(value="/webadmin/favorite/input")
	public String input() throws Exception {
		try {
			favorite = new Favorite();
			if(id != null) {
				favorite = favoriteService.getById(id);
			}
			responseSuccessJson(favorite, "favorite.label.favorite", "common.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("favorite.label.favorite", ex.getErrorCode()));
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

	public Page<Favorite> getPage() {
		return page;
	}

	public void setPage(Page<Favorite> page) {
		this.page = page;
	}

	public void setFavoriteQuery(FavoriteQuery favoriteQuery) {
		this.favoriteQuery = favoriteQuery;
	}

	public FavoriteQuery getFavoriteQuery() {
		return favoriteQuery;
	}

	public List<java.lang.Long> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<java.lang.Long> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public Favorite getFavorite() {
		return favorite;
	}

	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}
	
	

}
