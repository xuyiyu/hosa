/*
 * Automatically generated
 */

package com.gaojiaoyuan.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.*;



import com.gaojiaoyuan.model.*;
import com.gaojiaoyuan.dao.*;
import com.gaojiaoyuan.service.*;
import com.gaojiaoyuan.vo.query.*;



@Service
@Transactional
public class ImageManager extends BaseManager<Image,java.lang.Long>{

	private ImageDao imageDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setImageDao(ImageDao dao) {
		this.imageDao = dao;
	}
	
	public EntityDao getEntityDao() {
		return this.imageDao;
	}
	
	/** */
	public Image createImage(Image image) {
	    Assert.notNull(image,"'image' must be not null");
	    initDefaultValuesForCreate(image);
	    new ImageChecker().checkCreateImage(image);
	    this.imageDao.save(image);
	    return image;
	}
	
    public Image updateImage(Image image) {
        Assert.notNull(image,"'image' must be not null");
        new ImageChecker().checkUpdateImage(image);
        this.imageDao.update(image);
        return image;
    }	

    public void deleteImageById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        this.imageDao.deleteById(id);
    }
    
    public Image getImageById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        return this.imageDao.getById(id);
    }
    
	@Transactional(readOnly=true)
	public Page findPage(ImageQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return imageDao.findPage(query);
	}
	
    
    public void initDefaultValuesForCreate(Image v) {
    }
    
    public class ImageChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateImage(Image v) {
            checkImage(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateImage(Image v) {
            checkImage(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkImage(Image v) {
            //各个属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
