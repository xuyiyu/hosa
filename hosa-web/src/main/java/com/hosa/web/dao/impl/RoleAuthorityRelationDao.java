/*
 * Automatically generated
 */

package com.hosa.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.hosa.core.mybatis.BaseMybatisDao;
import com.hosa.web.dao.IRoleAuthorityRelationDao;
import com.hosa.web.model.RoleAuthorityRelation;


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
