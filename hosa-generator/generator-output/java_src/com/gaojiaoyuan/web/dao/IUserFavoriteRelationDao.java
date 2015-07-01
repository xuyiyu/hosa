/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao;

import org.springframework.dao.DataAccessException;

import com.gaojiaoyuan.core.base.BaseDao;
import com.gaojiaoyuan.web.model.UserFavoriteRelation;

public interface IUserFavoriteRelationDao extends BaseDao<UserFavoriteRelation, java.lang.Long>{
	
	public Integer saveOrUpdate(UserFavoriteRelation entity) throws DataAccessException;

	
}
