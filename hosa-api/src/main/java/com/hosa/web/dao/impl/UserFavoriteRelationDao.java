/*
 * Automatically generated
 */

package com.hosa.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.hosa.core.mybatis.BaseMybatisDao;
import com.hosa.web.dao.IUserFavoriteRelationDao;
import com.hosa.web.model.UserFavoriteRelation;
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
