/*
 * Automatically generated
 */

package com.hosa.web.dao;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.User;

public interface IUserDao extends BaseDao<User, java.lang.Long>{
	
	public Integer saveOrUpdate(User entity) throws DataAccessException;

	
}
