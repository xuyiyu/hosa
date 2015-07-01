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
public class UserFavoriteRelationManager extends BaseManager<UserFavoriteRelation,java.lang.Long>{

	private UserFavoriteRelationDao userFavoriteRelationDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUserFavoriteRelationDao(UserFavoriteRelationDao dao) {
		this.userFavoriteRelationDao = dao;
	}
	
	public EntityDao getEntityDao() {
		return this.userFavoriteRelationDao;
	}
	
	/** */
	public UserFavoriteRelation createUserFavoriteRelation(UserFavoriteRelation userFavoriteRelation) {
	    Assert.notNull(userFavoriteRelation,"'userFavoriteRelation' must be not null");
	    initDefaultValuesForCreate(userFavoriteRelation);
	    new UserFavoriteRelationChecker().checkCreateUserFavoriteRelation(userFavoriteRelation);
	    this.userFavoriteRelationDao.save(userFavoriteRelation);
	    return userFavoriteRelation;
	}
	
    public UserFavoriteRelation updateUserFavoriteRelation(UserFavoriteRelation userFavoriteRelation) {
        Assert.notNull(userFavoriteRelation,"'userFavoriteRelation' must be not null");
        new UserFavoriteRelationChecker().checkUpdateUserFavoriteRelation(userFavoriteRelation);
        this.userFavoriteRelationDao.update(userFavoriteRelation);
        return userFavoriteRelation;
    }	

    public void deleteUserFavoriteRelationById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        this.userFavoriteRelationDao.deleteById(id);
    }
    
    public UserFavoriteRelation getUserFavoriteRelationById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        return this.userFavoriteRelationDao.getById(id);
    }
    
	@Transactional(readOnly=true)
	public Page findPage(UserFavoriteRelationQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return userFavoriteRelationDao.findPage(query);
	}
	
    
    public void initDefaultValuesForCreate(UserFavoriteRelation v) {
    }
    
    public class UserFavoriteRelationChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateUserFavoriteRelation(UserFavoriteRelation v) {
            checkUserFavoriteRelation(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateUserFavoriteRelation(UserFavoriteRelation v) {
            checkUserFavoriteRelation(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkUserFavoriteRelation(UserFavoriteRelation v) {
            //各个属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
