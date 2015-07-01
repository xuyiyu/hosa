/*
 * Automatically generated
 */

package com.hosa.web.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.Staff;

public interface IStaffDao extends BaseDao<Staff, java.lang.Long>{
	
	public Integer saveOrUpdate(Staff entity) throws DataAccessException;

	public Staff getByMobile(java.lang.String val);
	
	public Staff getByLoginId(java.lang.String val);
	
	public List<Long> findDepartmentIdByMultipleId(List<Long> idList); 
	
	public Long getDepartmentIdById(Long id); 
}
