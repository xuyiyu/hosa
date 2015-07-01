/*
 * Automatically generated
 */

package com.hosa.web.service;

import java.util.List;

import com.hosa.core.page.Page;
import com.hosa.web.model.Settings;
import com.hosa.web.vo.query.SettingsQuery;
import com.hosa.core.exceptions.ServiceException;


public interface ISettingsService {
	
	/**
	 * 分页查询
	 * @param page
	 * @param query
	 * @return
	 */
	public Page<Settings> findPage(Page<Settings> page, SettingsQuery query);
	
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
	public Integer saveOrUpdate(Settings entity) throws ServiceException;
	
	/**
	 * 新增
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer save(Settings entity) throws ServiceException;
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer update(Settings entity) throws ServiceException;
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public Settings getById(java.lang.Long id); 
	
	/**
	 * 查询
	 * @param idList
	 * @return
	 */
	public List<Settings> getByMultipleId(List<java.lang.Long> idList); 
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public Settings getByIdFromCache(java.lang.Long id); 
	
	/**
	 * 查询
	 * @param query
	 * @return
	 */
	public List<Settings> findList(SettingsQuery query);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @return
	 */
	public List<Settings> findList(SettingsQuery query, Integer size);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @param offset
	 * @return
	 */
	public List<Settings> findList(SettingsQuery query, Integer size, Integer offset);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Settings> findAllList();
	
	public Settings getByVariable(java.lang.String val);
	
	public Settings getByVariable(java.lang.Long departmentId ,java.lang.String val);
	
	public String getByVariableFromCache(java.lang.String variable);
	
	public void saveVariableToCache(Settings settings);
	
}
