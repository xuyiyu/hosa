/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.service;

import java.util.List;

import com.gaojiaoyuan.core.page.Page;
import com.gaojiaoyuan.web.model.LocationFollowing;
import com.gaojiaoyuan.web.vo.query.LocationFollowingQuery;
import com.gaojiaoyuan.core.exceptions.ServiceException;


public interface ILocationFollowingService {
	
	/**
	 * 分页查询
	 * @param page
	 * @param query
	 * @return
	 */
	public Page<LocationFollowing> findPage(Page<LocationFollowing> page, LocationFollowingQuery query);
	
	/**
	 * 删除
	 * @param idList
	 * @throws ServiceException
	 */
	public Integer deleteByMultipleId(List<java.lang.Integer> idList) throws ServiceException;
	
	/**
	 * 删除
	 * @param id
	 * @throws ServiceException
	 */
	public Integer deleteById(java.lang.Integer id) throws ServiceException;
	
	/**
	 * 保存
	 * @param entity
	 * @throws ServiceException
	 */
	public Integer saveOrUpdate(LocationFollowing entity) throws ServiceException;
	
	/**
	 * 新增
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer save(LocationFollowing entity) throws ServiceException;
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer update(LocationFollowing entity) throws ServiceException;
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public LocationFollowing getById(java.lang.Integer id); 
	
	/**
	 * 查询
	 * @param idList
	 * @return
	 */
	public List<LocationFollowing> getByMultipleId(List<java.lang.Integer> idList); 
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public LocationFollowing getByIdFromCache(java.lang.Integer id); 
	
	/**
	 * 查询
	 * @param query
	 * @return
	 */
	public List<LocationFollowing> findList(LocationFollowingQuery query);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @return
	 */
	public List<LocationFollowing> findList(LocationFollowingQuery query, Integer size);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @param offset
	 * @return
	 */
	public List<LocationFollowing> findList(LocationFollowingQuery query, Integer size, Integer offset);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<LocationFollowing> findAllList();
	
}
