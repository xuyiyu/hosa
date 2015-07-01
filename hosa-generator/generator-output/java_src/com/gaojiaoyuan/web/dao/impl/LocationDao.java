/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.gaojiaoyuan.core.mybatis.BaseMybatisDao;
import com.gaojiaoyuan.web.dao.ILocationDao;
import com.gaojiaoyuan.web.model.Location;
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
