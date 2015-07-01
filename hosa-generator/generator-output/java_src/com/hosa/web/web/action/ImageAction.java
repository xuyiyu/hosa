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
import com.hosa.web.service.IImageService;
import com.hosa.core.page.Page;
import com.hosa.web.model.Image;
import com.hosa.web.vo.query.ImageQuery;
import com.hosa.core.exceptions.ServiceException;

@Namespace("/webadmin/image")
@Scope("prototype")
public class ImageAction extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(ImageAction.class);

	@Autowired
	@Qualifier("imageService")
	private IImageService imageService;
	
	private java.lang.Long id;
	
	private Page<Image> page;
	
	private ImageQuery imageQuery;
	
	private List<java.lang.Long> checkedIdList;
	
	private Image image;
	

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/image/list")
	public String list() throws Exception {
		try {
			if(page == null) {
				page = new Page<Image>();
			}
			if (!page.isOrderBySetted()) {
		        	page.setOrderBy("id");
					page.setOrder(Page.DESC);
				
			}
			if(imageQuery == null) {
				imageQuery = new ImageQuery();
			}
			page = imageService.findPage(page, imageQuery);
			responseSuccessJson(page, "image.label.image", "common.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("image.label.image", ex.getErrorCode()));
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
	@Action(value="/webadmin/image/delete/save")
	public String delete() throws Exception {
		try {
			
			imageService.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "image.label.image", "common.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("image.label.image", ex.getErrorCode()));
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
	@Action(value="/webadmin/image/add/save")
	public String add() throws Exception {
		try {			
			imageService.save(image);
			responseSuccessJson(image, "image.label.image", "common.add.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonAddErrorInfo("image.label.image", ex.getErrorCode()));
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
	@Action(value="/webadmin/image/edit/save")
	public String edit() throws Exception {
		try {			
			imageService.update(image);
			responseSuccessJson(image, "image.label.image", "common.edit.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonEditErrorInfo("image.label.image", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	@Action(value="/webadmin/image/input")
	public String input() throws Exception {
		try {
			image = new Image();
			if(id != null) {
				image = imageService.getById(id);
			}
			responseSuccessJson(image, "image.label.image", "common.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("image.label.image", ex.getErrorCode()));
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

	public Page<Image> getPage() {
		return page;
	}

	public void setPage(Page<Image> page) {
		this.page = page;
	}

	public void setImageQuery(ImageQuery imageQuery) {
		this.imageQuery = imageQuery;
	}

	public ImageQuery getImageQuery() {
		return imageQuery;
	}

	public List<java.lang.Long> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<java.lang.Long> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	

}
