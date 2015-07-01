/*
 * Automatically generated
 */

package com.hosa.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.hosa.core.mybatis.BaseMybatisDao;
import com.hosa.web.dao.ILocationFollowingDao;
import com.hosa.web.model.LocationFollowing;
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
