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




public class ImageDaoTest extends BaseDaoTestCase{
	
	private ImageDao dao;
	
	@Autowired
	public void setImageDao(ImageDao dao) {
		this.dao = dao;
	}

	@Override 
	protected String[] getDbUnitDataFiles() {
	    //通过 TestMethodContext.getMethodName() 可以得到当前正在运行的测试方法名称
		return new String[]{"classpath:testdata/common.xml","classpath:testdata/Image.xml",
		                    "classpath:testdata/Image_"+TestMethodContext.getMethodName()+".xml"};
	}
	
	//数据库单元测试前会开始事务，结束时会回滚事务，所以测试方法可以不用关心测试数据的删除
	@Test
	public void findPage() {

		ImageQuery query = newImageQuery();
		Page page = dao.findPage(query);
		
		assertEquals(pageNumber,page.getThisPageNumber());
		assertEquals(pageSize,page.getPageSize());
		List resultList = (List)page.getResult();
		assertNotNull(resultList);
		
	}
	
	static int pageNumber = 1;
	static int pageSize = 10;	
	public static ImageQuery newImageQuery() {
		ImageQuery query = new ImageQuery();
		query.setPageNumber(pageNumber);
		query.setPageSize(pageSize);
		query.setSortColumns(null);
		
	  	query.setBitmapWidth(new Integer("1"));
	  	query.setBitmapHeight(new Integer("1"));
	  	query.setOriginalUrl(new String("1"));
	  	query.setCompressUrl(new String("1"));
	  	query.setLocationName(new String("1"));
	  	query.setLongitude(new String("1"));
	  	query.setLatitude(new String("1"));
	  	query.setContent(new String("1"));
	  	query.setUserId(new Long("1"));
	  	query.setFavoritedCnt(new Integer("1"));
	  	query.setCommentCnt(new Integer("1"));
		query.setCreatedAtBegin(new Date(System.currentTimeMillis()));
		query.setCreatedAtEnd(new Date(System.currentTimeMillis()));
		return query;
	}
	
}
