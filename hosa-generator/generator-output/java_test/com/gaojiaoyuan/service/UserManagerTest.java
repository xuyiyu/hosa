/*
 * Automatically generated
 */

package com.gaojiaoyuan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import cn.org.rapid_framework.test.context.TestMethodContext;
import static junit.framework.Assert.*;

import java.util.*;



import com.gaojiaoyuan.model.*;
import com.gaojiaoyuan.dao.*;
import com.gaojiaoyuan.service.*;
import com.gaojiaoyuan.vo.query.*;




public class UserManagerTest extends BaseManagerTestCase{

	private UserManager manager;
	
	@Autowired
	public void setUserManager(UserManager manager) {
		this.manager = manager;
	}

    @Override
    protected String[] getDbUnitDataFiles() {
        //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
        return new String[]{"classpath:testdata/common.xml","classpath:testdata/User.xml",
                            "classpath:testdata/User_"+TestMethodContext.getMethodName()+".xml"};
    }

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		User obj = newUser();
		manager.save(obj);
		manager.getEntityDao().flush();
		
		manager.update(obj);
		manager.getEntityDao().flush();
		
		assertNotNull(obj.getId());
		
		manager.removeById(obj.getId());
		manager.getEntityDao().flush();
	
	}
	
	public static User newUser() {
		User obj = new User();
		
	  	obj.setNick(new java.lang.String("1"));
	  	obj.setPortraitUrl(new java.lang.String("1"));
	  	obj.setFollower(new java.lang.Integer("1"));
	  	obj.setUserFollowing(new java.lang.Integer("1"));
	  	obj.setLocationFollowing(new java.lang.Integer("1"));
	  	obj.setBriefDescription(new java.lang.String("1"));
	  	obj.setImageCnt(new java.lang.Integer("1"));
	  	obj.setPraisingCnt(new java.lang.Integer("1"));
	  	obj.setPraisedCnt(new java.lang.Integer("1"));
	  	obj.setNotifiyCnt(new java.lang.Integer("1"));
	  	obj.setCreatedAt(new java.util.Date(System.currentTimeMillis()));
		return obj;
	}
}
