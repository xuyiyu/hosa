/*
 * Automatically generated
 */

package com.hosa.web.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hosa.core.base.BaseDao;
import com.hosa.web.model.Authority;

public interface IAuthorityDao extends BaseDao<Authority, java.lang.Long>{
	
	public Integer saveOrUpdate(Authority entity) throws DataAccessException;

	public Authority getByMark(java.lang.String val);
	
	public List<Authority> findListByStaffId(Long userId);
}
