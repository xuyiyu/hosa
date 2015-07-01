/*
 * Automatically generated
 */

package com.hosa.web.service;

import java.util.List;

import com.hosa.core.exceptions.ServiceException;
import com.hosa.core.page.Page;
import com.hosa.web.model.RoleAuthorityRelation;
import com.hosa.web.vo.query.RoleAuthorityRelationQuery;


public interface IRoleAuthorityRelationService {
	
	/**
	 * 分页查询
	 * @param page
	 * @param query
	 * @return
	 */
	public Page<RoleAuthorityRelation> findPage(Page<RoleAuthorityRelation> page, RoleAuthorityRelationQuery query);
	
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
	public Integer saveOrUpdate(RoleAuthorityRelation entity) throws ServiceException;
	
	/**
	 * 新增
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer save(RoleAuthorityRelation entity) throws ServiceException;
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer update(RoleAuthorityRelation entity) throws ServiceException;
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public RoleAuthorityRelation getById(java.lang.Long id); 
	
	/**
	 * 查询
	 * @param idList
	 * @return
	 */
	public List<RoleAuthorityRelation> getByMultipleId(List<java.lang.Long> idList); 
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public RoleAuthorityRelation getByIdFromCache(java.lang.Long id); 
	
	/**
	 * 查询
	 * @param query
	 * @return
	 */
	public List<RoleAuthorityRelation> findList(RoleAuthorityRelationQuery query);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @return
	 */
	public List<RoleAuthorityRelation> findList(RoleAuthorityRelationQuery query, Integer size);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @param offset
	 * @return
	 */
	public List<RoleAuthorityRelation> findList(RoleAuthorityRelationQuery query, Integer size, Integer offset);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<RoleAuthorityRelation> findAllList();
	
}
