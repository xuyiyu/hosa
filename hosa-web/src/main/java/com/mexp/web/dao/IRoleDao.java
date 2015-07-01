/*
 * Automatically generated
 */

package com.mexp.web.dao;

import org.springframework.dao.DataAccessException;

import com.mexp.core.base.BaseDao;
import com.mexp.web.model.Role;

public interface IRoleDao extends BaseDao<Role, java.lang.Long>{
	
	public Integer saveOrUpdate(Role entity) throws DataAccessException;

	public Role getByName(java.lang.String val);
	
}
