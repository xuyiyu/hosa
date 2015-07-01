/*
 * Automatically generated
 */

package com.mexp.web.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mexp.core.base.BaseDao;
import com.mexp.web.model.Authority;

public interface IAuthorityDao extends BaseDao<Authority, java.lang.Long>{
	
	public Integer saveOrUpdate(Authority entity) throws DataAccessException;

	public Authority getByMark(java.lang.String val);
	
	public List<Authority> findListByStaffId(Long userId);
}
