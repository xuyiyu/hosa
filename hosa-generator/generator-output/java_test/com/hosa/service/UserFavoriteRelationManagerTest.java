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




public class UserFavoriteRelationManagerTest extends BaseManagerTestCase{

	private UserFavoriteRelationManager manager;
	
	@Autowired
	public void setUserFavoriteRelationManager(UserFavoriteRelationManager manager) {
		this.manager = manager;
	}

    @Override
    protected String[] getDbUnitDataFiles() {
        //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
        return new String[]{"classpath:testdata/common.xml","classpath:testdata/UserFavoriteRelation.xml",
                            "classpath:testdata/UserFavoriteRelation_"+TestMethodContext.getMethodName()+".xml"};
    }

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		UserFavoriteRelation obj = newUserFavoriteRelation();
		manager.save(obj);
		manager.getEntityDao().flush();
		
		manager.update(obj);
		manager.getEntityDao().flush();
		
		assertNotNull(obj.getId());
		
		manager.removeById(obj.getId());
		manager.getEntityDao().flush();
	
	}
	
	public static UserFavoriteRelation newUserFavoriteRelation() {
		UserFavoriteRelation obj = new UserFavoriteRelation();
		
	  	obj.setUserId(new java.lang.Long("1"));
	  	obj.setFavoriteId(new java.lang.Long("1"));
	  	obj.setCreatedAt(new java.util.Date(System.currentTimeMillis()));
		return obj;
	}
}
