/*
 * Automatically generated
 */

package com.mexp.web.dao;

import org.springframework.dao.DataAccessException;

import com.mexp.core.base.BaseDao;
import com.mexp.web.model.RoleAuthorityRelation;

public interface IRoleAuthorityRelationDao extends BaseDao<RoleAuthorityRelation, java.lang.Long>{
	
	public Integer saveOrUpdate(RoleAuthorityRelation entity) throws DataAccessException;

}
