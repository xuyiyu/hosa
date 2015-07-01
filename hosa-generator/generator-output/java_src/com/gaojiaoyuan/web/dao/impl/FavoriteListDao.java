/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.gaojiaoyuan.core.mybatis.BaseMybatisDao;
import com.gaojiaoyuan.web.dao.IFavoriteListDao;
import com.gaojiaoyuan.web.model.FavoriteList;
import java.util.Map;
import java.util.HashMap;

@Repository
public class FavoriteListDao extends BaseMybatisDao<FavoriteList, java.lang.Long> implements IFavoriteListDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "FavoriteList";
	}
	
	public Integer saveOrUpdate(FavoriteList entity) {
		if(entity.getId() == null){
			return save(entity);
		} else {
			return update(entity);
		}
	}

	

}
