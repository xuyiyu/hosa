<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}${projectpackage}.dao.impl;

import org.springframework.stereotype.Repository;

import ${basepackage}.core.mybatis.BaseMybatisDao;
import ${basepackage}${projectpackage}.dao.I${className}Dao;
import ${basepackage}${projectpackage}.model.${className};
import java.util.Map;
import java.util.HashMap;

@Repository
public class ${className}Dao extends BaseMybatisDao<${className}, ${table.idColumn.javaType}> implements I${className}Dao {
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "${className}";
	}
	
	public Integer saveOrUpdate(${className} entity) {
		if(entity.get${table.idColumn.columnName}() == null){
			return save(entity);
		} else {
			return update(entity);
		}
	}

	
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
	public ${className} getBy${methodName}(${paramName}) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		<#list uniqueIndexs as uniqueIndex>
		paramMap.put("${uniqueIndex.columnNameFirstLower}", ${uniqueIndex.columnNameFirstLower});
		</#list>
		return (${className})getSqlSessionTemplate().selectOne("${className}.getBy${methodName}", paramMap);
	}
		
		
	</#list>

}
