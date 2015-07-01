/*
 * Automatically generated
 */

package com.hosa.web.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hosa.core.mybatis.BaseMybatisDao;
import com.hosa.web.dao.ISettingsDao;
import com.hosa.web.model.Settings;


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
