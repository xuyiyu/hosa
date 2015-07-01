/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao;

import org.springframework.dao.DataAccessException;

import com.gaojiaoyuan.core.base.BaseDao;
import com.gaojiaoyuan.web.model.FavoriteList;

public interface IFavoriteListDao extends BaseDao<FavoriteList, java.lang.Long>{
	
	public Integer saveOrUpdate(FavoriteList entity) throws DataAccessException;

	
}
