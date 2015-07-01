/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao;

import org.springframework.dao.DataAccessException;

import com.gaojiaoyuan.core.base.BaseDao;
import com.gaojiaoyuan.web.model.UserFollowing;

public interface IUserFollowingDao extends BaseDao<UserFollowing, java.lang.Long>{
	
	public Integer saveOrUpdate(UserFollowing entity) throws DataAccessException;

	
}
