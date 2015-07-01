/*
 * Automatically generated
 */

package com.hosa.web.dao;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.Image;

public interface IImageDao extends BaseDao<Image, java.lang.Long>{
	
	public Integer saveOrUpdate(Image entity) throws DataAccessException;

	
}
