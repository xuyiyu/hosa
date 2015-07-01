/*
 * Automatically generated
 */

package com.mexp.web.service;

import java.util.List;

import com.mexp.core.exceptions.ServiceException;
import com.mexp.core.page.Page;
import com.mexp.web.model.DepartmentRoleRelation;
import com.mexp.web.vo.query.DepartmentRoleRelationQuery;


public interface IDepartmentRoleRelationService {
	
	/**
	 * 分页查询
	 * @param page
	 * @param query
	 * @return
	 */
	public Page<DepartmentRoleRelation> findPage(Page<DepartmentRoleRelation> page, DepartmentRoleRelationQuery query);
	
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
	public Integer saveOrUpdate(DepartmentRoleRelation entity) throws ServiceException;
	
	/**
	 * 新增
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer save(DepartmentRoleRelation entity) throws ServiceException;
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer update(DepartmentRoleRelation entity) throws ServiceException;
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public DepartmentRoleRelation getById(java.lang.Long id); 
	
	/**
	 * 查询
	 * @param idList
	 * @return
	 */
	public List<DepartmentRoleRelation> getByMultipleId(List<java.lang.Long> idList); 
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public DepartmentRoleRelation getByIdFromCache(java.lang.Long id); 
	
	/**
	 * 查询
	 * @param query
	 * @return
	 */
	public List<DepartmentRoleRelation> findList(DepartmentRoleRelationQuery query);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @return
	 */
	public List<DepartmentRoleRelation> findList(DepartmentRoleRelationQuery query, Integer size);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @param offset
	 * @return
	 */
	public List<DepartmentRoleRelation> findList(DepartmentRoleRelationQuery query, Integer size, Integer offset);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<DepartmentRoleRelation> findAllList();
	
}
