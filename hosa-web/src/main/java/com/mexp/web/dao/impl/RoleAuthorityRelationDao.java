/*
 * Automatically generated
 */

package com.mexp.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.mexp.core.mybatis.BaseMybatisDao;
import com.mexp.web.dao.IRoleAuthorityRelationDao;
import com.mexp.web.model.RoleAuthorityRelation;


@Repository
public class RoleAuthorityRelationDao extends BaseMybatisDao<RoleAuthorityRelation, java.lang.Long> implements IRoleAuthorityRelationDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "RoleAuthorityRelation";
	}
	
	public Integer saveOrUpdate(RoleAuthorityRelation entity) {
		if(entity.getId() == null) {
			return save(entity);
		} else {
			return update(entity);
		}
	}
	

}
