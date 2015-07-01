/*
 * Automatically generated
 */

package com.hosa.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.hosa.core.mybatis.BaseMybatisDao;
import com.hosa.web.dao.IFavoriteListDao;
import com.hosa.web.model.FavoriteList;
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
