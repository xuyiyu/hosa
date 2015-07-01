/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.gaojiaoyuan.core.mybatis.BaseMybatisDao;
import com.gaojiaoyuan.web.dao.IFavoriteDao;
import com.gaojiaoyuan.web.model.Favorite;
import java.util.Map;
import java.util.HashMap;

@Repository
public class FavoriteDao extends BaseMybatisDao<Favorite, java.lang.Long> implements IFavoriteDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "Favorite";
	}
	
	public Integer saveOrUpdate(Favorite entity) {
		if(entity.getId() == null){
			return save(entity);
		} else {
			return update(entity);
		}
	}

	

}
