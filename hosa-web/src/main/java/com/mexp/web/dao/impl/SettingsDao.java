/*
 * Automatically generated
 */

package com.mexp.web.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mexp.core.mybatis.BaseMybatisDao;
import com.mexp.web.dao.ISettingsDao;
import com.mexp.web.model.Settings;


@Repository
public class SettingsDao extends BaseMybatisDao<Settings, java.lang.Long> implements ISettingsDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "Settings";
	}
	
	public Integer saveOrUpdate(Settings entity) {
		if(entity.getId() == null){
			return save(entity);
		} else {
			return update(entity);
		}
	}
	
	public Settings getByVariableAndDepartmentId(Long departmentId, String variable) {
		String statement = getIbatisMapperNamesapce() + ".getByVariableAndDepartmentId";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("departmentId", departmentId);
		param.put("variable", variable);
		return getSqlSessionTemplate().selectOne(statement, param);
	}
}
