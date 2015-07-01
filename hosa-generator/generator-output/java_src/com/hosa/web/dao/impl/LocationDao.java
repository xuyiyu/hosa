/*
 * Automatically generated
 */

package com.hosa.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.hosa.core.mybatis.BaseMybatisDao;
import com.hosa.web.dao.ILocationDao;
import com.hosa.web.model.Location;
import java.util.Map;
import java.util.HashMap;

@Repository
public class LocationDao extends BaseMybatisDao<Location, java.lang.Long> implements ILocationDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "Location";
	}
	
	public Integer saveOrUpdate(Location entity) {
		if(entity.getId() == null){
			return save(entity);
		} else {
			return update(entity);
		}
	}

	

}
