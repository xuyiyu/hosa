/*
 * Automatically generated
 */

package com.mexp.web.dao;

import org.springframework.dao.DataAccessException;

import com.mexp.core.base.BaseDao;
import com.mexp.web.model.Department;

public interface IDepartmentDao extends BaseDao<Department, java.lang.Long>{
	
	public Integer saveOrUpdate(Department entity) throws DataAccessException;

	public Department getByLevel(java.lang.String val);
	
	public Department getByNameAndParentId(java.lang.String name, java.lang.Long parentId);
	
}
