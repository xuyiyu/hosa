/*
 * Automatically generated
 */

package com.hosa.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.*;



import com.hosa.model.*;
import com.hosa.dao.*;
import com.hosa.service.*;
import com.hosa.vo.query.*;



@Service
@Transactional
public class FavoriteListManager extends BaseManager<FavoriteList,java.lang.Long>{

	private FavoriteListDao favoriteListDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setFavoriteListDao(FavoriteListDao dao) {
		this.favoriteListDao = dao;
	}
	
	public EntityDao getEntityDao() {
		return this.favoriteListDao;
	}
	
	/** */
	public FavoriteList createFavoriteList(FavoriteList favoriteList) {
	    Assert.notNull(favoriteList,"'favoriteList' must be not null");
	    initDefaultValuesForCreate(favoriteList);
	    new FavoriteListChecker().checkCreateFavoriteList(favoriteList);
	    this.favoriteListDao.save(favoriteList);
	    return favoriteList;
	}
	
    public FavoriteList updateFavoriteList(FavoriteList favoriteList) {
        Assert.notNull(favoriteList,"'favoriteList' must be not null");
        new FavoriteListChecker().checkUpdateFavoriteList(favoriteList);
        this.favoriteListDao.update(favoriteList);
        return favoriteList;
    }	

    public void deleteFavoriteListById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        this.favoriteListDao.deleteById(id);
    }
    
    public FavoriteList getFavoriteListById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        return this.favoriteListDao.getById(id);
    }
    
	@Transactional(readOnly=true)
	public Page findPage(FavoriteListQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return favoriteListDao.findPage(query);
	}
	
    
    public void initDefaultValuesForCreate(FavoriteList v) {
    }
    
    public class FavoriteListChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateFavoriteList(FavoriteList v) {
            checkFavoriteList(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateFavoriteList(FavoriteList v) {
            checkFavoriteList(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkFavoriteList(FavoriteList v) {
            //各个属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
