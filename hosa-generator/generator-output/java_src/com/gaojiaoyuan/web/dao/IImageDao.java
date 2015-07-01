/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao;

import org.springframework.dao.DataAccessException;

import com.gaojiaoyuan.core.base.BaseDao;
import com.gaojiaoyuan.web.model.Image;

public interface IImageDao extends BaseDao<Image, java.lang.Long>{
	
	public Integer saveOrUpdate(Image entity) throws DataAccessException;

	
}
