/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao;

import org.springframework.dao.DataAccessException;

import com.gaojiaoyuan.core.base.BaseDao;
import com.gaojiaoyuan.web.model.LocationFollowing;

public interface ILocationFollowingDao extends BaseDao<LocationFollowing, java.lang.Integer>{
	
	public Integer saveOrUpdate(LocationFollowing entity) throws DataAccessException;

	
}
