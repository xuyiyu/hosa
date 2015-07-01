/*
 * Automatically generated
 */

package com.hosa.web.dao;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.Department;

public interface IDepartmentDao extends BaseDao<Department, java.lang.Long>{
	
	public Integer saveOrUpdate(Department entity) throws DataAccessException;

	public Department getByLevel(java.lang.String val);
	
	public Department getByNameAndParentId(java.lang.String name, java.lang.Long parentId);
	
}
