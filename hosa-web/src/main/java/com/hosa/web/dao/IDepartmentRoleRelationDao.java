/*
 * Automatically generated
 */

package com.hosa.web.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.DepartmentRoleRelation;

public interface IDepartmentRoleRelationDao extends BaseDao<DepartmentRoleRelation, java.lang.Long>{
	
	public Integer saveOrUpdate(DepartmentRoleRelation entity) throws DataAccessException;

	public void deleteByMultipleDepartmentIdAndMultipleRoleId(List<Long> departmentIdList, List<Long> roleList) throws DataAccessException;
	
	public void deleteByMultipleDepartmentId(List<Long> idList) throws DataAccessException;
}
