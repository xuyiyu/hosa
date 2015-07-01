/*
 * Automatically generated
 */

package com.hosa.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hosa.core.mybatis.BaseMybatisDao;
import com.hosa.web.dao.IDepartmentRoleRelationDao;
import com.hosa.web.model.DepartmentRoleRelation;


@Repository
public class DepartmentRoleRelationDao extends BaseMybatisDao<DepartmentRoleRelation, java.lang.Long> implements IDepartmentRoleRelationDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "DepartmentRoleRelation";
	}
	
	public Integer saveOrUpdate(DepartmentRoleRelation entity) {
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
	public void deleteByMultipleDepartmentId(List<Long> idList)  {
		String statement = getIbatisMapperNamesapce() + ".deleteByMultipleDepartmentId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("departmentIdList", idList);
		getSqlSessionTemplate().delete(statement, param);
	}
}
