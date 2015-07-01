/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao;

import org.springframework.dao.DataAccessException;

import com.gaojiaoyuan.core.base.BaseDao;
import com.gaojiaoyuan.web.model.User;

public interface IUserDao extends BaseDao<User, java.lang.Long>{
	
	public Integer saveOrUpdate(User entity) throws DataAccessException;

	
}
