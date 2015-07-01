/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.service;

import java.util.List;

import com.gaojiaoyuan.core.page.Page;
import com.gaojiaoyuan.web.model.FavoriteList;
import com.gaojiaoyuan.web.vo.query.FavoriteListQuery;
import com.gaojiaoyuan.core.exceptions.ServiceException;


public interface IFavoriteListService {
	
	/**
	 * 分页查询
	 * @param page
	 * @param query
	 * @return
	 */
	public Page<FavoriteList> findPage(Page<FavoriteList> page, FavoriteListQuery query);
	
	/**
	 * 删除
	 * @param idList
	 * @throws ServiceException
	 */
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException;
	
	/**
	 * 删除
	 * @param id
	 * @throws ServiceException
	 */
	public Integer deleteById(java.lang.Long id) throws ServiceException;
	
	/**
	 * 保存
	 * @param entity
	 * @throws ServiceException
	 */
	public Integer saveOrUpdate(FavoriteList entity) throws ServiceException;
	
	/**
	 * 新增
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer save(FavoriteList entity) throws ServiceException;
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer update(FavoriteList entity) throws ServiceException;
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public FavoriteList getById(java.lang.Long id); 
	
	/**
	 * 查询
	 * @param idList
	 * @return
	 */
	public List<FavoriteList> getByMultipleId(List<java.lang.Long> idList); 
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public FavoriteList getByIdFromCache(java.lang.Long id); 
	
	/**
	 * 查询
	 * @param query
	 * @return
	 */
	public List<FavoriteList> findList(FavoriteListQuery query);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @return
	 */
	public List<FavoriteList> findList(FavoriteListQuery query, Integer size);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @param offset
	 * @return
	 */
	public List<FavoriteList> findList(FavoriteListQuery query, Integer size, Integer offset);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<FavoriteList> findAllList();
	
}
