/*
 * Automatically generated
 */

package com.hosa.web.service;

import java.util.List;

import com.hosa.core.exceptions.ServiceException;
import com.hosa.core.page.Page;
import com.hosa.web.model.Role;
import com.hosa.web.vo.query.RoleQuery;


public interface IRoleService {
	
	/**
	 * 分页查询
	 * @param page
	 * @param query
	 * @return
	 */
	public Page<Role> findPage(Page<Role> page, RoleQuery query);
	
	/**
	 * 删除
	 * @param idList
	 * @return
	 * @throws ServiceException
	 */
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException;
	
	/**
	 * 删除
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public Integer deleteById(java.lang.Long id) throws ServiceException;
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer saveOrUpdate(Role entity) throws ServiceException;
	
	/**
	 * 新增
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer save(Role entity) throws ServiceException;
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer update(Role entity) throws ServiceException;
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public Role getById(java.lang.Long id); 
	
	/**
	 * 查询
	 * @param idList
	 * @return
	 */
	public List<Role> getByMultipleId(List<java.lang.Long> idList); 
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public Role getByIdFromCache(java.lang.Long id); 
	
	/**
	 * 查询
	 * @param query
	 * @return
	 */
	public List<Role> findList(RoleQuery query);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @return
	 */
	public List<Role> findList(RoleQuery query, Integer size);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @param offset
	 * @return
	 */
	public List<Role> findList(RoleQuery query, Integer size, Integer offset);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Role> findAllList();
	
	/**
	 * 查询
	 * @param val
	 * @return
	 */
	public Role getByName(java.lang.String val);
		
}
