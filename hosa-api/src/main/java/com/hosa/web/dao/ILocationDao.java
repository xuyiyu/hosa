/*
 * Automatically generated
 */

package com.hosa.web.dao;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.Location;

public interface ILocationDao extends BaseDao<Location, java.lang.Long>{
	
	public Integer saveOrUpdate(Location entity) throws DataAccessException;

	
}
