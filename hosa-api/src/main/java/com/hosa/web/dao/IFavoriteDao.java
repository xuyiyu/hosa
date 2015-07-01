/*
 * Automatically generated
 */

package com.hosa.web.dao;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.Favorite;

public interface IFavoriteDao extends BaseDao<Favorite, java.lang.Long>{
	
	public Integer saveOrUpdate(Favorite entity) throws DataAccessException;

	
}
