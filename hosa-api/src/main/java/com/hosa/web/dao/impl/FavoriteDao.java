/*
 * Automatically generated
 */

package com.hosa.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.hosa.core.mybatis.BaseMybatisDao;
import com.hosa.web.dao.IFavoriteDao;
import com.hosa.web.model.Favorite;
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
