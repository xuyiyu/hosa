/*
 * Automatically generated
 */

package com.hosa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

import cn.org.rapid_framework.test.context.TestMethodContext;

import static junit.framework.Assert.*;

import java.util.*;



import com.hosa.model.*;
import com.hosa.dao.*;
import com.hosa.service.*;
import com.hosa.vo.query.*;




public class UserDaoTest extends BaseDaoTestCase{
	
	private UserDao dao;
	
	@Autowired
	public void setUserDao(UserDao dao) {
		this.dao = dao;
	}

	@Override 
	protected String[] getDbUnitDataFiles() {
	    //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
		return new String[]{"classpath:testdata/common.xml","classpath:testdata/User.xml",
		                    "classpath:testdata/User_"+TestMethodContext.getMethodName()+".xml"};
	}
	
	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void findPage() {

		UserQuery query = newUserQuery();
		Page page = dao.findPage(query);
		
		assertEquals(pageNumber,page.getThisPageNumber());
		assertEquals(pageSize,page.getPageSize());
		List resultList = (List)page.getResult();
		assertNotNull(resultList);
		
	}
	
	static int pageNumber = 1;
	static int pageSize = 10;	
	public static UserQuery newUserQuery() {
		UserQuery query = new UserQuery();
		query.setPageNumber(pageNumber);
		query.setPageSize(pageSize);
		query.setSortColumns(null);
		
	  	query.setNick(new String("1"));
	  	query.setPortraitUrl(new String("1"));
	  	query.setFollower(new Integer("1"));
	  	query.setUserFollowing(new Integer("1"));
	  	query.setLocationFollowing(new Integer("1"));
	  	query.setBriefDescription(new String("1"));
	  	query.setImageCnt(new Integer("1"));
	  	query.setPraisingCnt(new Integer("1"));
	  	query.setPraisedCnt(new Integer("1"));
	  	query.setNotifiyCnt(new Integer("1"));
		query.setCreatedAtBegin(new Date(System.currentTimeMillis()));
		query.setCreatedAtEnd(new Date(System.currentTimeMillis()));
		return query;
	}
	
}
