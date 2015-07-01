/*
 * Automatically generated
 */

package com.hosa.web.dao;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.UserFavoriteRelation;

public interface IUserFavoriteRelationDao extends BaseDao<UserFavoriteRelation, java.lang.Long>{
	
	public Integer saveOrUpdate(UserFavoriteRelation entity) throws DataAccessException;

	
}
