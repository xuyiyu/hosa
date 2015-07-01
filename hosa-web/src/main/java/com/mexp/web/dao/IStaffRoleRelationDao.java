/*
 * Automatically generated
 */

package com.mexp.web.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mexp.core.base.BaseDao;
import com.mexp.web.model.StaffRoleRelation;

public interface IStaffRoleRelationDao extends BaseDao<StaffRoleRelation, java.lang.Long>{
	
	public Integer saveOrUpdate(StaffRoleRelation entity) throws DataAccessException;

	public void deleteByMultipleDepartmentIdAndMultipleRoleId(List<Long> departmentIdList, List<Long> roleList) throws DataAccessException;
	
	public void deleteByMultipleStaffId(List<Long> idList) throws DataAccessException;
}
