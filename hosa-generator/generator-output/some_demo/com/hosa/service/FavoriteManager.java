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
public class FavoriteManager extends BaseManager<Favorite,java.lang.Long>{

	private FavoriteDao favoriteDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setFavoriteDao(FavoriteDao dao) {
		this.favoriteDao = dao;
	}
	
	public EntityDao getEntityDao() {
		return this.favoriteDao;
	}
	
	/** */
	public Favorite createFavorite(Favorite favorite) {
	    Assert.notNull(favorite,"'favorite' must be not null");
	    initDefaultValuesForCreate(favorite);
	    new FavoriteChecker().checkCreateFavorite(favorite);
	    this.favoriteDao.save(favorite);
	    return favorite;
	}
	
    public Favorite updateFavorite(Favorite favorite) {
        Assert.notNull(favorite,"'favorite' must be not null");
        new FavoriteChecker().checkUpdateFavorite(favorite);
        this.favoriteDao.update(favorite);
        return favorite;
    }	

    public void deleteFavoriteById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        this.favoriteDao.deleteById(id);
    }
    
    public Favorite getFavoriteById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        return this.favoriteDao.getById(id);
    }
    
	@Transactional(readOnly=true)
	public Page findPage(FavoriteQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return favoriteDao.findPage(query);
	}
	
    
    public void initDefaultValuesForCreate(Favorite v) {
    }
    
    public class FavoriteChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateFavorite(Favorite v) {
            checkFavorite(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateFavorite(Favorite v) {
            checkFavorite(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkFavorite(Favorite v) {
            //各个属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
