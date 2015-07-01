/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.service;

import java.util.List;

import com.gaojiaoyuan.core.page.Page;
import com.gaojiaoyuan.web.model.Favorite;
import com.gaojiaoyuan.web.vo.query.FavoriteQuery;
import com.gaojiaoyuan.core.exceptions.ServiceException;


public interface IFavoriteService {
	
	/**
	 * 分页查询
	 * @param page
	 * @param query
	 * @return
	 */
	public Page<Favorite> findPage(Page<Favorite> page, FavoriteQuery query);
	
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
	public Integer saveOrUpdate(Favorite entity) throws ServiceException;
	
	/**
	 * 新增
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer save(Favorite entity) throws ServiceException;
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer update(Favorite entity) throws ServiceException;
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public Favorite getById(java.lang.Long id); 
	
	/**
	 * 查询
	 * @param idList
	 * @return
	 */
	public List<Favorite> getByMultipleId(List<java.lang.Long> idList); 
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public Favorite getByIdFromCache(java.lang.Long id); 
	
	/**
	 * 查询
	 * @param query
	 * @return
	 */
	public List<Favorite> findList(FavoriteQuery query);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @return
	 */
	public List<Favorite> findList(FavoriteQuery query, Integer size);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @param offset
	 * @return
	 */
	public List<Favorite> findList(FavoriteQuery query, Integer size, Integer offset);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Favorite> findAllList();
	
}
