<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}${projectpackage}.service;

import java.util.List;

import ${basepackage}.core.page.Page;
import ${basepackage}${projectpackage}.model.${className};
import ${basepackage}${projectpackage}.vo.query.${className}Query;
import ${basepackage}.core.exceptions.ServiceException;


public interface I${className}Service {
	
	/**
	 * 分页查询
	 * @param page
	 * @param query
	 * @return
	 */
	public Page<${className}> findPage(Page<${className}> page, ${className}Query query);
	
	/**
	 * 删除
	 * @param idList
	 * @throws ServiceException
	 */
	public Integer deleteByMultipleId(List<${table.idColumn.javaType}> idList) throws ServiceException;
	
	/**
	 * 删除
	 * @param id
	 * @throws ServiceException
	 */
	public Integer deleteById(${table.idColumn.javaType} id) throws ServiceException;
	
	/**
	 * 保存
	 * @param entity
	 * @throws ServiceException
	 */
	public Integer saveOrUpdate(${className} entity) throws ServiceException;
	
	/**
	 * 新增
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer save(${className} entity) throws ServiceException;
	
	/**
	 * 更新
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public Integer update(${className} entity) throws ServiceException;
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public ${className} getById(${table.idColumn.javaType} id); 
	
	/**
	 * 查询
	 * @param idList
	 * @return
	 */
	public List<${className}> getByMultipleId(List<${table.idColumn.javaType}> idList); 
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public ${className} getByIdFromCache(${table.idColumn.javaType} id); 
	
	/**
	 * 查询
	 * @param query
	 * @return
	 */
	public List<${className}> findList(${className}Query query);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @return
	 */
	public List<${className}> findList(${className}Query query, Integer size);
	
	/**
	 * 查询
	 * @param query
	 * @param size
	 * @param offset
	 * @return
	 */
	public List<${className}> findList(${className}Query query, Integer size, Integer offset);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<${className}> findAllList();
	
	 <#list table.uniqueIndexList as uniqueIndexs>
		<#assign methodName="" />
		<#assign paramName="" />
	/**
	 * 查询	
	<#list uniqueIndexs as uniqueIndex>
	<#if uniqueIndex_index gt 0>
	<#assign methodName = methodName+ "And" />
	<#assign paramName = paramName + ", " />
	</#if>
	<#assign methodName = methodName + uniqueIndex.columnName />
	<#assign paramName = paramName + uniqueIndex.javaType + " " +uniqueIndex.columnNameFirstLower  />
	 * @param ${uniqueIndex.columnNameFirstLower}
	</#list>	
	 * @return
	 */
	public ${className} getBy${methodName}(${paramName});
		
		
	</#list>
}
