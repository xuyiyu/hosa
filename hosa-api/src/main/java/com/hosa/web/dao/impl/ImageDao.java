/*
 * Automatically generated
 */

package com.hosa.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.hosa.core.mybatis.BaseMybatisDao;
import com.hosa.web.dao.IImageDao;
import com.hosa.web.model.Image;
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
