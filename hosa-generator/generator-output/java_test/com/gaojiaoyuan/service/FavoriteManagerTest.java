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




public class FavoriteManagerTest extends BaseManagerTestCase{

	private FavoriteManager manager;
	
	@Autowired
	public void setFavoriteManager(FavoriteManager manager) {
		this.manager = manager;
	}

    @Override
    protected String[] getDbUnitDataFiles() {
        //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
        return new String[]{"classpath:testdata/common.xml","classpath:testdata/Favorite.xml",
                            "classpath:testdata/Favorite_"+TestMethodContext.getMethodName()+".xml"};
    }

	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void crud() {

		Favorite obj = newFavorite();
		manager.save(obj);
		manager.getEntityDao().flush();
		
		manager.update(obj);
		manager.getEntityDao().flush();
		
		assertNotNull(obj.getId());
		
		manager.removeById(obj.getId());
		manager.getEntityDao().flush();
	
	}
	
	public static Favorite newFavorite() {
		Favorite obj = new Favorite();
		
	  	obj.setName(new java.lang.String("1"));
	  	obj.setFavoriteCnt(new java.lang.Integer("1"));
	  	obj.setCreatedAt(new java.util.Date(System.currentTimeMillis()));
		return obj;
	}
}
