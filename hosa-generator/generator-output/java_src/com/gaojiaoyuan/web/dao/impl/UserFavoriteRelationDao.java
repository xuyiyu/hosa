/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.gaojiaoyuan.core.mybatis.BaseMybatisDao;
import com.gaojiaoyuan.web.dao.IUserFavoriteRelationDao;
import com.gaojiaoyuan.web.model.UserFavoriteRelation;
import java.util.Map;
import java.util.HashMap;

@Repository
public class UserFavoriteRelationDao extends BaseMybatisDao<UserFavoriteRelation, java.lang.Long> implements IUserFavoriteRelationDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "UserFavoriteRelation";
	}
	
	public Integer saveOrUpdate(UserFavoriteRelation entity) {
		if(entity.getId() == null){
			return save(entity);
		} else {
			return update(entity);
		}
	}

	

}
