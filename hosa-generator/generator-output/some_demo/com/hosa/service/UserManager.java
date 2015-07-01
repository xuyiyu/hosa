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
public class UserManager extends BaseManager<User,java.lang.Long>{

	private UserDao userDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setUserDao(UserDao dao) {
		this.userDao = dao;
	}
	
	public EntityDao getEntityDao() {
		return this.userDao;
	}
	
	/** */
	public User createUser(User user) {
	    Assert.notNull(user,"'user' must be not null");
	    initDefaultValuesForCreate(user);
	    new UserChecker().checkCreateUser(user);
	    this.userDao.save(user);
	    return user;
	}
	
    public User updateUser(User user) {
        Assert.notNull(user,"'user' must be not null");
        new UserChecker().checkUpdateUser(user);
        this.userDao.update(user);
        return user;
    }	

    public void deleteUserById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        this.userDao.deleteById(id);
    }
    
    public User getUserById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        return this.userDao.getById(id);
    }
    
	@Transactional(readOnly=true)
	public Page findPage(UserQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return userDao.findPage(query);
	}
	
    
    public void initDefaultValuesForCreate(User v) {
    }
    
    public class UserChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateUser(User v) {
            checkUser(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateUser(User v) {
            checkUser(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkUser(User v) {
            //各个属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
