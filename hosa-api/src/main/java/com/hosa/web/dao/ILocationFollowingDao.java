/*
 * Automatically generated
 */

package com.hosa.web.dao;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.LocationFollowing;

public interface ILocationFollowingDao extends BaseDao<LocationFollowing, java.lang.Integer>{
	
	public Integer saveOrUpdate(LocationFollowing entity) throws DataAccessException;

	
}
