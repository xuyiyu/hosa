/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.gaojiaoyuan.core.mybatis.BaseMybatisDao;
import com.gaojiaoyuan.web.dao.ILocationFollowingDao;
import com.gaojiaoyuan.web.model.LocationFollowing;
import java.util.Map;
import java.util.HashMap;

@Repository
public class LocationFollowingDao extends BaseMybatisDao<LocationFollowing, java.lang.Integer> implements ILocationFollowingDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "LocationFollowing";
	}
	
	public Integer saveOrUpdate(LocationFollowing entity) {
		if(entity.getId() == null){
			return save(entity);
		} else {
			return update(entity);
		}
	}

	

}
