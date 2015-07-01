<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}${projectpackage}.dao;

import org.springframework.dao.DataAccessException;

import ${basepackage}.core.base.BaseDao;
import ${basepackage}${projectpackage}.model.${className};

public interface I${className}Dao extends BaseDao<${className}, ${table.idColumn.javaType}>{
	
	public Integer saveOrUpdate(${className} entity) throws DataAccessException;

	
	 <#list table.uniqueIndexList as uniqueIndexs>
		<#assign methodName="" />
		<#assign paramName="" />
		<#list uniqueIndexs as uniqueIndex>
		<#if uniqueIndex_index gt 0>
			<#assign methodName = methodName+ "And" />
			<#assign paramName = paramName + ", " />
		</#if>
		<#assign methodName = methodName + uniqueIndex.columnName />
		<#assign paramName = paramName + uniqueIndex.javaType + " " +uniqueIndex.columnNameFirstLower  />
		</#list>	
	public ${className} getBy${methodName}(${paramName});
		
		
	</#list>
}
