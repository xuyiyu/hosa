<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign classNameLowerCase = className?lower_case> 
package ${basepackage}${projectpackage}.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ${basepackage}.core.exceptions.ServiceException;

import ${basepackage}.core.exceptions.ServiceException;

import ${basepackage}.core.page.Page;
import ${basepackage}${projectpackage}.dao.I${className}Dao;
import ${basepackage}${projectpackage}.model.${className};
import ${basepackage}${projectpackage}.service.I${className}Service;
import ${basepackage}${projectpackage}.vo.query.${className}Query;
import ${basepackage}.core.exceptions.ServiceException;
import ${basepackage}.core.base.BaseService;

@Service
@Transactional
public class ${className}Service extends BaseService implements I${className}Service {

	private static final Logger log = LoggerFactory.getLogger(${className}Service.class);
	
	@Autowired
	@Qualifier("${classNameLower}Dao")
	private I${className}Dao ${classNameLower}Dao;

	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.${className}Query)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<${className}> findPage(Page<${className}> page, ${className}Query query) {
		return ${classNameLower}Dao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<${table.idColumn.javaType}> idList) throws ServiceException {
		return ${classNameLower}Dao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#deleteById(${table.idColumn.javaType})
	 */
	@Override
	public Integer deleteById(${table.idColumn.javaType} id) throws ServiceException {
		return ${classNameLower}Dao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#saveOrUpdate(com.lps.db.model.${className})
	 */
	@Override
	public Integer saveOrUpdate(${className} entity) throws ServiceException {
		Integer cnt = ${classNameLower}Dao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#save(com.lps.db.model.${className})
	 */
	@Override
	public Integer save(${className} entity) throws ServiceException {
		<#list table.uniqueIndexList as uniqueIndexs>
			<#if uniqueIndexs_index == 0>
		${className}Query ${classNameLower}Query = new ${className}Query();
			</#if>
			<#if uniqueIndexs_index gt 0>
			
		${classNameLower}Query = new ${className}Query();
			</#if>
		${classNameLower}Query.setIdNotEq(entity.getId());
			<#assign repeatName="" />
			<#list uniqueIndexs as uniqueIndex>
		${classNameLower}Query.set${uniqueIndex.columnName}(entity.get${uniqueIndex.columnName}());
				<#if uniqueIndex_index gt 0>
					<#assign repeatName = repeatName+ "and" />
				</#if>
				<#assign repeatName = repeatName + uniqueIndex.columnNameLowerCase />
			</#list>
		Long queryCount = ${classNameLower}Dao.getQueryCount(${classNameLower}Query);
		if(queryCount != null && queryCount>0) {
			throw new ServiceException("${repeatName} repeat", "${classNameLowerCase}.${repeatName}repeat");
		}
		</#list>
		Integer cnt = ${classNameLower}Dao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#update(com.lps.db.model.${className})
	 */
	@Override
	public Integer update(${className} entity) throws ServiceException {
		<#list table.uniqueIndexList as uniqueIndexs>
		
			<#assign repeatName="" />
			<#assign methodName="" />
			<#list uniqueIndexs as uniqueIndex>
		
				<#if uniqueIndex_index gt 0>
					<#assign repeatName = repeatName+ "and" />
					<#assign methodName= methodName + " && " />
				</#if>
				<#assign repeatName = repeatName + uniqueIndex.columnNameLowerCase />
				<#assign methodName = methodName + "entity.get" + uniqueIndex.columnName + "() != null"/>
			</#list>
			if(${methodName}) {
				${className}Query ${classNameLower}Query = new ${className}Query();
				${classNameLower}Query.setIdNotEq(entity.getId());
				<#list uniqueIndexs as uniqueIndex>
				${classNameLower}Query.set${uniqueIndex.columnName}(entity.get${uniqueIndex.columnName}());						
				</#list>
				Long queryCount = ${classNameLower}Dao.getQueryCount(${classNameLower}Query);
				if(queryCount != null && queryCount>0) {
					throw new ServiceException("${repeatName} repeat", "${classNameLowerCase}.${repeatName}repeat");
				}
			}
		
		</#list>
		Integer cnt = ${classNameLower}Dao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#getById(${table.idColumn.javaType})
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public ${className} getById(${table.idColumn.javaType} id) {
		return ${classNameLower}Dao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<${className}> getByMultipleId(List<${table.idColumn.javaType}> idList) {
		return ${classNameLower}Dao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#getByIdFromCache(${table.idColumn.javaType})
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public ${className} getByIdFromCache(${table.idColumn.javaType} id) {
		return ${classNameLower}Dao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#findList(com.lps.db.vo.query.${className}Query)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<${className}> findList(${className}Query query) {
		return ${classNameLower}Dao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#findList(com.lps.db.vo.query.${className}Query, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<${className}> findList(${className}Query query, Integer size) {
		return ${classNameLower}Dao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#findList(com.lps.db.vo.query.${className}Query, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<${className}> findList(${className}Query query, Integer size, Integer offset) {
		return ${classNameLower}Dao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<${className}> findAllList() {
		${className}Query query = new ${className}Query();
		return ${classNameLower}Dao.findList(query);
	}


	<#list table.uniqueIndexList as uniqueIndexs>
	<#assign methodName="" />
	<#assign paramName="" />
	<#assign paramVal="" />
	<#list uniqueIndexs as uniqueIndex>
	<#if uniqueIndex_index gt 0>
	<#assign methodName = methodName+ "And" />
	<#assign paramName = paramName + ", " />
	<#assign paramVal = paramVal + ", " />
	</#if>
	<#assign methodName = methodName + uniqueIndex.columnName />
	<#assign paramName = paramName + uniqueIndex.javaType + " " +uniqueIndex.columnNameFirstLower  />
	<#assign paramVal = paramVal + uniqueIndex.columnNameFirstLower  />
	</#list>
	/*
	 * (non-Javadoc)
	 * @see ${basepackage}${projectpackage}.service.I${className}Service#getBy${methodName}(${paramName})
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public ${className} getBy${methodName}(${paramName}) {
		return ${classNameLower}Dao.getBy${methodName}(${paramVal});
	}
	</#list>
	/*查询显示列备注
	<#list table.columns as column>
	query.set${column.columnName}QueryShow(true);
	</#list>
	*/
}
