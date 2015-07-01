/*
 * Automatically generated
 */

package com.mexp.web.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mexp.core.base.BaseDao;
import com.mexp.web.model.DepartmentRoleRelation;

public interface IDepartmentRoleRelationDao extends BaseDao<DepartmentRoleRelation, java.lang.Long>{
	
	public Integer saveOrUpdate(DepartmentRoleRelation entity) throws DataAccessException;

	public void deleteByMultipleDepartmentIdAndMultipleRoleId(List<Long> departmentIdList, List<Long> roleList) throws DataAccessException;
	
	public void deleteByMultipleDepartmentId(List<Long> idList) throws DataAccessException;
}
