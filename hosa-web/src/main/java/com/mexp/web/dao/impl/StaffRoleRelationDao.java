/*
 * Automatically generated
 */

package com.mexp.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mexp.core.mybatis.BaseMybatisDao;
import com.mexp.web.dao.IStaffRoleRelationDao;
import com.mexp.web.model.StaffRoleRelation;


@Repository
public class StaffRoleRelationDao extends BaseMybatisDao<StaffRoleRelation, java.lang.Long> implements IStaffRoleRelationDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "StaffRoleRelation";
	}
	
	public Integer saveOrUpdate(StaffRoleRelation entity) {
		if(entity.getId() == null) {
			return save(entity);
		} else {
			return update(entity);
		}
	}
	
	public void deleteByMultipleDepartmentIdAndMultipleRoleId(List<Long> departmentIdList, List<Long> roleList)  {
		String statement = getIbatisMapperNamesapce() + ".deleteByMultipleDepartmentIdAndMultipleRoleId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("departmentIdList", departmentIdList);
		param.put("roleList", roleList);
		getSqlSessionTemplate().delete(statement, param);
	}
	
	public void deleteByMultipleStaffId(List<Long> idList) throws DataAccessException {
		String statement = getIbatisMapperNamesapce() + ".deleteByMultipleStaffId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("staffIdList", idList);
		getSqlSessionTemplate().delete(statement, param);
	}
}
