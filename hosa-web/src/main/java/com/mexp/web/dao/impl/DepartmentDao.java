/*
 * Automatically generated
 */

package com.mexp.web.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mexp.core.mybatis.BaseMybatisDao;
import com.mexp.web.dao.IDepartmentDao;
import com.mexp.web.model.Department;


@Repository
public class DepartmentDao extends BaseMybatisDao<Department, java.lang.Long> implements IDepartmentDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "Department";
	}
	
	public Integer saveOrUpdate(Department entity) {
		if(entity.getId() == null) {
			return save(entity);
		} else {
			return update(entity);
		}
			
	}
	
	public Department getByLevel(java.lang.String val) {
		return (Department)getSqlSessionTemplate().selectOne("Department.getByLevel", val);
	}	
	
	public Department getByNameAndParentId(java.lang.String name, java.lang.Long parentId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		param.put("parentId", parentId);
		return (Department)getSqlSessionTemplate().selectOne("Department.getByNameAndParentId", param);
	}
}
