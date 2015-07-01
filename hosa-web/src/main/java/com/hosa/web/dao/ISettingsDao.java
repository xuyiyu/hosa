/*
 * Automatically generated
 */

package com.hosa.web.dao;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.Settings;

public interface ISettingsDao extends BaseDao<Settings, java.lang.Long>{
	
	public Integer saveOrUpdate(Settings entity) throws DataAccessException;

	public Settings getByVariableAndDepartmentId(Long departmentId, String variable);
}
