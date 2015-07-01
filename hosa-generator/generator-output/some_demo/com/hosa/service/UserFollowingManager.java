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
public class UserFollowingManager extends BaseManager<UserFollowing,java.lang.Long>{

	private UserFollowingDao userFollowingDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUserFollowingDao(UserFollowingDao dao) {
		this.userFollowingDao = dao;
	}
	
	public EntityDao getEntityDao() {
		return this.userFollowingDao;
	}
	
	/** */
	public UserFollowing createUserFollowing(UserFollowing userFollowing) {
	    Assert.notNull(userFollowing,"'userFollowing' must be not null");
	    initDefaultValuesForCreate(userFollowing);
	    new UserFollowingChecker().checkCreateUserFollowing(userFollowing);
	    this.userFollowingDao.save(userFollowing);
	    return userFollowing;
	}
	
    public UserFollowing updateUserFollowing(UserFollowing userFollowing) {
        Assert.notNull(userFollowing,"'userFollowing' must be not null");
        new UserFollowingChecker().checkUpdateUserFollowing(userFollowing);
        this.userFollowingDao.update(userFollowing);
        return userFollowing;
    }	

    public void deleteUserFollowingById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        this.userFollowingDao.deleteById(id);
    }
    
    public UserFollowing getUserFollowingById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        return this.userFollowingDao.getById(id);
    }
    
	@Transactional(readOnly=true)
	public Page findPage(UserFollowingQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return userFollowingDao.findPage(query);
	}
	
    
    public void initDefaultValuesForCreate(UserFollowing v) {
    }
    
    public class UserFollowingChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateUserFollowing(UserFollowing v) {
            checkUserFollowing(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateUserFollowing(UserFollowing v) {
            checkUserFollowing(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkUserFollowing(UserFollowing v) {
            //各个属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
