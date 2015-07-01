/*
 * Automatically generated
 */

package com.hosa.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.hosa.core.mybatis.BaseMybatisDao;
import com.hosa.web.dao.IUserDao;
import com.hosa.web.model.User;
import java.util.Map;
import java.util.HashMap;

@Repository
public class UserDao extends BaseMybatisDao<User, java.lang.Long> implements IUserDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "User";
	}
	
	public Integer saveOrUpdate(User entity) {
		if(entity.getId() == null){
			return save(entity);
		} else {
			return update(entity);
		}
	}

	

}
