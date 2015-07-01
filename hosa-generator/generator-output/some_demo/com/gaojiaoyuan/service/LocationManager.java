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
public class LocationManager extends BaseManager<Location,java.lang.Long>{

	private LocationDao locationDao;
	/**增加setXXXX()方法,spring就可以通过autowire自动设置对象属性,请注意大小写*/
	public void setLocationDao(LocationDao dao) {
		this.locationDao = dao;
	}
	
	public EntityDao getEntityDao() {
		return this.locationDao;
	}
	
	/** */
	public Location createLocation(Location location) {
	    Assert.notNull(location,"'location' must be not null");
	    initDefaultValuesForCreate(location);
	    new LocationChecker().checkCreateLocation(location);
	    this.locationDao.save(location);
	    return location;
	}
	
    public Location updateLocation(Location location) {
        Assert.notNull(location,"'location' must be not null");
        new LocationChecker().checkUpdateLocation(location);
        this.locationDao.update(location);
        return location;
    }	

    public void deleteLocationById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        this.locationDao.deleteById(id);
    }
    
    public Location getLocationById(java.lang.Long id) {
        Assert.notNull(id,"'id' must be not null");
        return this.locationDao.getById(id);
    }
    
	@Transactional(readOnly=true)
	public Page findPage(LocationQuery query) {
	    Assert.notNull(query,"'query' must be not null");
		return locationDao.findPage(query);
	}
	
    
    public void initDefaultValuesForCreate(Location v) {
    }
    
    public class LocationChecker {
        /**可以在此检查只有更新才需要的特殊检查 */
        public void checkUpdateLocation(Location v) {
            checkLocation(v);
        }
    
        /**可以在此检查只有创建才需要的特殊检查 */
        public void checkCreateLocation(Location v) {
            checkLocation(v);
        }
        
        /** 检查到有错误请直接抛异常，不要使用 return errorCode的方式 */
        public void checkLocation(Location v) {
            //各个属性的检查一般需要分开写几个方法，如 checkProperty1(v),checkProperty2(v)
        }
    }
}
