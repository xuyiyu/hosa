/*
 * Automatically generated
 */

package com.mexp.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mexp.core.mybatis.BaseMybatisDao;
import com.mexp.web.dao.IAuthorityDao;
import com.mexp.web.model.Authority;


@Repository
public class AuthorityDao extends BaseMybatisDao<Authority, java.lang.Long> implements IAuthorityDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "Authority";
	}
	
	public Integer saveOrUpdate(Authority entity) {
		if(entity.getId() == null) {
			return save(entity);
		} else {
			return update(entity);
		}
	}
	
	public Authority getByMark(java.lang.String val) {
		return (Authority)getSqlSessionTemplate().selectOne("Authority.getByMark", val);
	}	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Authority> findListByStaffId(Long staffId) {
		String statements = getIbatisMapperNamesapce() + ".findListByStaffId";
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("staffId", staffId);
		return getSqlSessionTemplate().selectList(statements, paramMap);
	}
	
}
