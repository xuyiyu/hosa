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
public class LocationFollowingManager extends BaseManager<LocationFollowing,java.lang.Integer>{

	private LocationFollowingDao locationFollowingDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setLocationFollowingDao(LocationFollowingDao dao) {
		this.locationFollowingDao = dao;
	}
	
	public EntityDao getEntityDao() {
		return this.locationFollowingDao;
	}
	
	/** */
	public LocationFollowing createLocationFollowing(LocationFollowing locationFollowing) {
	    Assert.notNull(locationFollowing,"'locationFollowing' must be not null");
	    initDefaultValuesForCreate(locationFollowing);
	    new LocationFollowingChecker().checkCreateLocationFollowing(locationFollowing);
	    this.locationFollowingDao.save(locationFollowing);
	    return locationFollowing;
	}
	
    public LocationFollowing updateLocationFollowing(LocationFollowing locationFollowing) {
        Assert.notNull(locationFollowing,"'locationFollowing' must be not null");
        new LocationFollowingChecker().checkUpdateLocationFollowing(locationFollowing);
        this.locationFollowingDao.update(locationFollowing);
        return locationFollowing;
    }	

    public void deleteLocationFollowingById(java.lang.Integer id) {
        Assert.notNull(id,"'id' must be not null");
        this.locationFollowingDao.deleteById(id);
    }
    
    public LocationFollowing getLocationFollowingById(java.lang.Integer id) {
        Assert.notNull(id,"'id' must be not null");
        return this.locationFollowingDao.getById(id);
    }
    
	@Transactional(readOnly=true)
	public Page findPage(LocationFollowingQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return locationFollowingDao.findPage(query);
	}
	
    
    public void initDefaultValuesForCreate(LocationFollowing v) {
    }
    
    public class LocationFollowingChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateLocationFollowing(LocationFollowing v) {
            checkLocationFollowing(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateLocationFollowing(LocationFollowing v) {
            checkLocationFollowing(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkLocationFollowing(LocationFollowing v) {
            //各个属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
