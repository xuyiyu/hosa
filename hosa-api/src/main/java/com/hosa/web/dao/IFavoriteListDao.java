/*
 * Automatically generated
 */

package com.hosa.web.dao;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.FavoriteList;

public interface IFavoriteListDao extends BaseDao<FavoriteList, java.lang.Long>{
	
	public Integer saveOrUpdate(FavoriteList entity) throws DataAccessException;

	
}
