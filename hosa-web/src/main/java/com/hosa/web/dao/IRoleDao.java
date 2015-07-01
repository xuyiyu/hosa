/*
 * Automatically generated
 */

package com.hosa.web.dao;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.Role;

public interface IRoleDao extends BaseDao<Role, java.lang.Long>{
	
	public Integer saveOrUpdate(Role entity) throws DataAccessException;

	public Role getByName(java.lang.String val);
	
}
