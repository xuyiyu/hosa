/*
 * Automatically generated
 */

package com.hosa.web.dao;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.UserFollowing;

public interface IUserFollowingDao extends BaseDao<UserFollowing, java.lang.Long>{
	
	public Integer saveOrUpdate(UserFollowing entity) throws DataAccessException;

	
}
