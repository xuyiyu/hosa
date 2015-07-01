<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}${projectpackage}.vo.query;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import ${basepackage}.core.base.BaseQuery;
import java.util.List;

public class ${className}Query extends BaseQuery implements Serializable {

    <@generateFields/>
    <@generateProperties/>
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

<#macro generateFields>

	<#list table.columns as column>
	/** ${column.columnAlias} */
	<#if column.isDateTimeColumn >
	private ${column.javaType} ${column.columnNameLower}Begin;
	private ${column.javaType} ${column.columnNameLower}End;
	
	<#elseif column.isStringColumn>
	private ${column.javaType} ${column.columnNameLower};
	private ${column.javaType} ${column.columnNameLower}Like;
	private ${column.javaType} ${column.columnNameLower}BeginLike;
	private ${column.javaType} ${column.columnNameLower}EndLike;
	
	private List<${column.javaType}> ${column.columnNameLower}ListAnd;
	private List<${column.javaType}> ${column.columnNameLower}LikeListAnd;
	private List<${column.javaType}> ${column.columnNameLower}BeginLikeListAnd;
	private List<${column.javaType}> ${column.columnNameLower}EndLikeListAnd;
	
	private List<${column.javaType}> ${column.columnNameLower}ListOr;
	private List<${column.javaType}> ${column.columnNameLower}LikeListOr;
	private List<${column.javaType}> ${column.columnNameLower}BeginLikeListOr;
	private List<${column.javaType}> ${column.columnNameLower}EndLikeListOr;
	
	<#elseif column.isNumberColumn>
	private ${column.javaType} ${column.columnNameLower};
	private ${column.javaType} ${column.columnNameLower}NotEq;
	private ${column.javaType} ${column.columnNameLower}GT;
	private ${column.javaType} ${column.columnNameLower}LT;
	
	private ${column.javaType} ${column.columnNameLower}GE;
	private ${column.javaType} ${column.columnNameLower}LE;
	
	private List<${column.javaType}> ${column.columnNameLower}List;
	private List<${column.javaType}> ${column.columnNameLower}NotEqList;
	
	<#else>	
	private ${column.javaType} ${column.columnNameLower};
	
	</#if>
	private Boolean ${column.columnNameLower}QueryShow = false;
	</#list>

</#macro>

<#macro generateProperties>
	<#list table.columns as column>
	<#if column.isDateTimeColumn>
	public ${column.javaType} get${column.columnName}Begin() {
		return this.${column.columnNameLower}Begin;
	}
	
	public void set${column.columnName}Begin(${column.javaType} value) {
		this.${column.columnNameLower}Begin = value;
	}	
	
	public ${column.javaType} get${column.columnName}End() {
		return this.${column.columnNameLower}End;
	}
	
	public void set${column.columnName}End(${column.javaType} value) {
		this.${column.columnNameLower}End = value;
	}

	
	<#elseif column.isStringColumn>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	public ${column.javaType} get${column.columnName}Like() {
		return this.${column.columnNameLower}Like;
	}
	
	public void set${column.columnName}Like(${column.javaType} value) {
		this.${column.columnNameLower}Like = value;
	}
	public ${column.javaType} get${column.columnName}BeginLike() {
		return this.${column.columnNameLower}BeginLike;
	}
	
	public void set${column.columnName}BeginLike(${column.javaType} value) {
		this.${column.columnNameLower}BeginLike = value;
	}
	public ${column.javaType} get${column.columnName}EndLike() {
		return this.${column.columnNameLower}EndLike;
	}
	
	public void set${column.columnName}EndLike(${column.javaType} value) {
		this.${column.columnNameLower}EndLike = value;
	}

	public List<${column.javaType}> get${column.columnName}ListAnd() {
		return this.${column.columnNameLower}ListAnd;
	}
	
	public void set${column.columnName}ListAnd(List<${column.javaType}> value) {
		this.${column.columnNameLower}ListAnd = value;
	}
	public List<${column.javaType}> get${column.columnName}LikeListAnd() {
		return this.${column.columnNameLower}LikeListAnd;
	}
	
	public void set${column.columnName}LikeListAnd(List<${column.javaType}> value) {
		this.${column.columnNameLower}LikeListAnd = value;
	}
	public List<${column.javaType}> get${column.columnName}BeginLikeListAnd() {
		return this.${column.columnNameLower}BeginLikeListAnd;
	}
	
	public void set${column.columnName}BeginLikeListAnd(List<${column.javaType}> value) {
		this.${column.columnNameLower}BeginLikeListAnd = value;
	}
	public List<${column.javaType}> get${column.columnName}EndLikeListAnd() {
		return this.${column.columnNameLower}EndLikeListAnd;
	}
	
	public void set${column.columnName}EndLikeListAnd(List<${column.javaType}> value) {
		this.${column.columnNameLower}EndLikeListAnd = value;
	}
	
	public List<${column.javaType}> get${column.columnName}ListOr() {
		return this.${column.columnNameLower}ListOr;
	}
	
	public void set${column.columnName}ListOr(List<${column.javaType}> value) {
		this.${column.columnNameLower}ListOr = value;
	}
	public List<${column.javaType}> get${column.columnName}LikeListOr() {
		return this.${column.columnNameLower}LikeListOr;
	}
	
	public void set${column.columnName}LikeListOr(List<${column.javaType}> value) {
		this.${column.columnNameLower}LikeListOr = value;
	}
	public List<${column.javaType}> get${column.columnName}BeginLikeListOr() {
		return this.${column.columnNameLower}BeginLikeListOr;
	}
	
	public void set${column.columnName}BeginLikeListOr(List<${column.javaType}> value) {
		this.${column.columnNameLower}BeginLikeListOr = value;
	}
	public List<${column.javaType}> get${column.columnName}EndLikeListOr() {
		return this.${column.columnNameLower}EndLikeListOr;
	}
	
	public void set${column.columnName}EndLikeListOr(List<${column.javaType}> value) {
		this.${column.columnNameLower}EndLikeListOr = value;
	}
	
	<#elseif column.isNumberColumn>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	public ${column.javaType} get${column.columnName}NotEq() {
		return ${column.columnNameLower}NotEq;
	}

	public void set${column.columnName}NotEq(${column.javaType} value) {
		this.${column.columnNameLower}NotEq = value;
	}
	
	public ${column.javaType} get${column.columnName}GT() {
		return ${column.columnNameLower}GT;
	}

	public void set${column.columnName}GT(${column.javaType} value) {
		this.${column.columnNameLower}GT = value;
	}
	public ${column.javaType} get${column.columnName}LT() {
		return ${column.columnNameLower}LT;
	}

	public void set${column.columnName}LT(${column.javaType} value) {
		this.${column.columnNameLower}LT = value;
	}
	
	public ${column.javaType} get${column.columnName}GE() {
		return ${column.columnNameLower}GE;
	}

	public void set${column.columnName}GE(${column.javaType} value) {
		this.${column.columnNameLower}GE = value;
	}
	public ${column.javaType} get${column.columnName}LE() {
		return ${column.columnNameLower}LE;
	}

	public void set${column.columnName}LE(${column.javaType} value) {
		this.${column.columnNameLower}LE = value;
	}
	
	public List<${column.javaType}> get${column.columnName}List() {
		return this.${column.columnNameLower}List;
	}
	
	public void set${column.columnName}List(List<${column.javaType}> value) {
		this.${column.columnNameLower}List = value;
	}
	public List<${column.javaType}> get${column.columnName}NotEqList() {
		return ${column.columnNameLower}NotEqList;
	}

	public void set${column.columnName}NotEqList(List<${column.javaType}> value) {
		this.${column.columnNameLower}NotEqList = value;
	}

	
	<#else>
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	</#if>
	public Boolean get${column.columnName}QueryShow() {
		return ${column.columnNameLower}QueryShow;
	}

	public void set${column.columnName}QueryShow(Boolean value) {
		this.${column.columnNameLower}QueryShow = value;
	}
	</#list>
</#macro>



