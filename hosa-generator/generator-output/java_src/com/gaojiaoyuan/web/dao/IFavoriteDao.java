/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao;

import org.springframework.dao.DataAccessException;

import com.gaojiaoyuan.core.base.BaseDao;
import com.gaojiaoyuan.web.model.Favorite;

public interface IFavoriteDao extends BaseDao<Favorite, java.lang.Long>{
	
	public Integer saveOrUpdate(Favorite entity) throws DataAccessException;

	
}
