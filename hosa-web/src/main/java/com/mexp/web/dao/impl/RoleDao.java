/*
 * Automatically generated
 */

package com.mexp.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.mexp.core.mybatis.BaseMybatisDao;
import com.mexp.web.dao.IRoleDao;
import com.mexp.web.model.Role;


@Repository
public class RoleDao extends BaseMybatisDao<Role, java.lang.Long> implements IRoleDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "Role";
	}
	
	public Integer saveOrUpdate(Role entity) {
		if(entity.getId() == null) {
			return save(entity);
		} else {
			return update(entity);
		}
	}
	
	public Role getByName(java.lang.String val) {
		return (Role)getSqlSessionTemplate().selectOne("Role.getByName", val);
	}	
	

}
