/*
 * Automatically generated
 */

package com.hosa.web.dao;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.RoleAuthorityRelation;

public interface IRoleAuthorityRelationDao extends BaseDao<RoleAuthorityRelation, java.lang.Long>{
	
	public Integer saveOrUpdate(RoleAuthorityRelation entity) throws DataAccessException;

}
