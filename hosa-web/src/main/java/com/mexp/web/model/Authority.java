/*
 * Automatically generated
 */

package com.mexp.web.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.mexp.core.base.BaseEntity;
import com.mexp.core.utils.DateConvertUtils;

public class Authority extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "权限表";
	public static final String ALIAS_ID = "编号";
	public static final String ALIAS_NAME = "权限名称";
	public static final String ALIAS_MARK = "权限标识";
	public static final String ALIAS_CHAIN = "权限链";
	public static final String ALIAS_SORT = "排序";
	public static final String ALIAS_LEVEL = "级别";
	public static final String ALIAS_CUSTOM = "自定义{1：自定义，0：默认}";
	public static final String ALIAS_MODIFIED = "最后修改时间";
	
	//date formats
	
	public static final String FORMAT_MODIFIED = TIMESTAMP_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 编号       db_column: id 
     */	
	
	private java.lang.Long id;
    /**
     * 权限名称       db_column: name 
     */	
	
	private java.lang.String name;
    /**
     * 权限标识       db_column: mark 
     */	
	
	private java.lang.String mark;
    /**
     * 权限链       db_column: chain 
     */	
	
	private java.lang.String chain;
    /**
     * 排序       db_column: sort 
     */	
	
	private java.lang.Integer sort;
    /**
     * 级别       db_column: level 
     */	
	
	private java.lang.Integer level;
    /**
     * 自定义{1：自定义，0：默认}       db_column: custom 
     */	
	
	private java.lang.Integer custom;
    /**
     * 最后修改时间       db_column: modified 
     */	
	
	private java.util.Date modified;
	//columns END

	public Authority(){
	}

	public Authority(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setMark(java.lang.String value) {
		this.mark = value;
	}
	
	public java.lang.String getMark() {
		return this.mark;
	}
	public void setChain(java.lang.String value) {
		this.chain = value;
	}
	
	public java.lang.String getChain() {
		return this.chain;
	}
	public void setSort(java.lang.Integer value) {
		this.sort = value;
	}
	
	public java.lang.Integer getSort() {
		return this.sort;
	}
	public void setLevel(java.lang.Integer value) {
		this.level = value;
	}
	
	public java.lang.Integer getLevel() {
		return this.level;
	}
	public void setCustom(java.lang.Integer value) {
		this.custom = value;
	}
	
	public java.lang.Integer getCustom() {
		return this.custom;
	}
	public String getModifiedString() {
		return DateConvertUtils.format(getModified(), FORMAT_MODIFIED);
	}
	public void setModifiedString(String value) {
		setModified(DateConvertUtils.parse(value, FORMAT_MODIFIED,java.util.Date.class));
	}
	
	public void setModified(java.util.Date value) {
		this.modified = value;
	}
	
	public java.util.Date getModified() {
		return this.modified;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("Mark",getMark())
			.append("Chain",getChain())
			.append("Sort",getSort())
			.append("Level",getLevel())
			.append("Custom",getCustom())
			.append("Modified",getModified())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Authority == false) return false;
		if(this == obj) return true;
		Authority other = (Authority)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

