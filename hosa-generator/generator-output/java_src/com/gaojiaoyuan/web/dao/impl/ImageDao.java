/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.gaojiaoyuan.core.mybatis.BaseMybatisDao;
import com.gaojiaoyuan.web.dao.IImageDao;
import com.gaojiaoyuan.web.model.Image;
import java.util.Map;
import java.util.HashMap;

@Repository
public class ImageDao extends BaseMybatisDao<Image, java.lang.Long> implements IImageDao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "Image";
	}
	
	public Integer saveOrUpdate(Image entity) {
		if(entity.getId() == null){
			return save(entity);
		} else {
			return update(entity);
		}
	}

	

}
