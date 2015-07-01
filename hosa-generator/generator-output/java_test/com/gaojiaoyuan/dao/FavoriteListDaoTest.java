/*
 * Automatically generated
 */

package com.gaojiaoyuan.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import cn.org.rapid_framework.test.context.TestMethodContext;

import static junit.framework.Assert.*;

import java.util.*;



import com.gaojiaoyuan.model.*;
import com.gaojiaoyuan.dao.*;
import com.gaojiaoyuan.service.*;
import com.gaojiaoyuan.vo.query.*;




public class FavoriteListDaoTest extends BaseDaoTestCase{
	
	private FavoriteListDao dao;
	
	@Autowired
	public void setFavoriteListDao(FavoriteListDao dao) {
		this.dao = dao;
	}

	@Override 
	protected String[] getDbUnitDataFiles() {
	    //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
		return new String[]{"classpath:testdata/common.xml","classpath:testdata/FavoriteList.xml",
		                    "classpath:testdata/FavoriteList_"+TestMethodContext.getMethodName()+".xml"};
	}
	
	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void findPage() {

		FavoriteListQuery query = newFavoriteListQuery();
		Page page = dao.findPage(query);
		
		assertEquals(pageNumber,page.getThisPageNumber());
		assertEquals(pageSize,page.getPageSize());
		List resultList = (List)page.getResult();
		assertNotNull(resultList);
		
	}
	
	static int pageNumber = 1;
	static int pageSize = 10;	
	public static FavoriteListQuery newFavoriteListQuery() {
		FavoriteListQuery query = new FavoriteListQuery();
		query.setPageNumber(pageNumber);
		query.setPageSize(pageSize);
		query.setSortColumns(null);
		
	  	query.setFavoriteListId(new Long("1"));
	  	query.setImageId(new Long("1"));
		query.setCreatedAtBegin(new Date(System.currentTimeMillis()));
		query.setCreatedAtEnd(new Date(System.currentTimeMillis()));
		return query;
	}
	
}
