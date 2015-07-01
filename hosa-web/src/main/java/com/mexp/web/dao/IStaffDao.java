/*
 * Automatically generated
 */

package com.mexp.web.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mexp.core.base.BaseDao;
import com.mexp.web.model.Staff;

public interface IStaffDao extends BaseDao<Staff, java.lang.Long>{
	
	public Integer saveOrUpdate(Staff entity) throws DataAccessException;

	public Staff getByMobile(java.lang.String val);
	
	public Staff getByLoginId(java.lang.String val);
	
	public List<Long> findDepartmentIdByMultipleId(List<Long> idList); 
	
	public Long getDepartmentIdById(Long id); 
}
