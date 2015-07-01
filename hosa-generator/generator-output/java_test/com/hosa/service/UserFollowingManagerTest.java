/*
 * Automatically generated
 */

package com.hosa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import cn.org.rapid_framework.test.context.TestMethodContext;
import static junit.framework.Assert.*;

import java.util.*;



import com.hosa.model.*;
import com.hosa.dao.*;
import com.hosa.service.*;
import com.hosa.vo.query.*;




public class UserFollowingManagerTest extends BaseManagerTestCase{

	private UserFollowingManager manager;
	
	@Autowired
	public void setUserFollowingManager(UserFollowingManager manager) {
		this.manager = manager;
	}

    @Override
    protected String[] getDbUnitDataFiles() {
        //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
        return new String[]{"classpath:testdata/common.xml","classpath:testdata/UserFollowing.xml",
                            "classpath:testdata/UserFollowing_"+TestMethodContext.getMethodName()+".xml"};
    }

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		UserFollowing obj = newUserFollowing();
		manager.save(obj);
		manager.getEntityDao().flush();
		
		manager.update(obj);
		manager.getEntityDao().flush();
		
		assertNotNull(obj.getId());
		
		manager.removeById(obj.getId());
		manager.getEntityDao().flush();
	
	}
	
	public static UserFollowing newUserFollowing() {
		UserFollowing obj = new UserFollowing();
		
	  	obj.setUserId(new java.lang.Long("1"));
	  	obj.setFollowerUserId(new java.lang.Long("1"));
	  	obj.setCreatedAt(new java.util.Date(System.currentTimeMillis()));
		return obj;
	}
}
