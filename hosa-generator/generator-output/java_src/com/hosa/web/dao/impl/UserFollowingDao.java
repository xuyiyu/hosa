/*
 * Automatically generated
 */

package com.hosa.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.hosa.core.mybatis.BaseMybatisDao;
import com.hosa.web.dao.IUserFollowingDao;
import com.hosa.web.model.UserFollowing;
import java.util.Map;
import java.util.HashMap;

@Repository
public class UserFollowingDao extends BaseMybatisDao<UserFollowing, java.lang.Long> implements IUserFollowingDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "UserFollowing";
	}
	
	public Integer saveOrUpdate(UserFollowing entity) {
		if(entity.getId() == null){
			return save(entity);
		} else {
			return update(entity);
		}
	}

	

}
