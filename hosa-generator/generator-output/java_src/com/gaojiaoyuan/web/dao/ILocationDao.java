/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao;

import org.springframework.dao.DataAccessException;

import com.gaojiaoyuan.core.base.BaseDao;
import com.gaojiaoyuan.web.model.Location;

public interface ILocationDao extends BaseDao<Location, java.lang.Long>{
	
	public Integer saveOrUpdate(Location entity) throws DataAccessException;

	
}
