/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.gaojiaoyuan.core.mybatis.BaseMybatisDao;
import com.gaojiaoyuan.web.dao.IUserDao;
import com.gaojiaoyuan.web.model.User;
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
