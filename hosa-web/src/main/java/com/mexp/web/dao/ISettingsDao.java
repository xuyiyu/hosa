/*
 * Automatically generated
 */

package com.mexp.web.dao;

import org.springframework.dao.DataAccessException;

import com.mexp.core.base.BaseDao;
import com.mexp.web.model.Settings;

public interface ISettingsDao extends BaseDao<Settings, java.lang.Long>{
	
	public Integer saveOrUpdate(Settings entity) throws DataAccessException;

	public Settings getByVariableAndDepartmentId(Long departmentId, String variable);
}
