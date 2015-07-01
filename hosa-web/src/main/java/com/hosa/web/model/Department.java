/*
 * Automatically generated
 */

package com.hosa.web.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hosa.core.base.BaseEntity;
import com.hosa.core.utils.DateConvertUtils;

public class Department extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "部门表";
	public static final String ALIAS_ID = "编号";
	public static final String ALIAS_NAME = "名称";
	public static final String ALIAS_PARENT_ID = "上级编号";
	public static final String ALIAS_SIMPLE_CODE = "简码";
	public static final String ALIAS_LEVEL = "层级";
	public static final String ALIAS_DESCRIPTION = "描述";
	public static final String ALIAS_CREATED_AT = "创建时间";
	public static final String ALIAS_MODIFIED = "最后修改时间";
	
	//date formats
	public static final String FORMAT_CREATED_AT = DATE_FORMAT;
	public static final String FORMAT_MODIFIED = TIMESTAMP_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 编号       db_column: id 
     */	
	
	private java.lang.Long id;
    /**
     * 名称       db_column: name 
     */	
	
	private java.lang.String name;
    /**
     * 上级编号       db_column: parent_id 
     */	
	
	private java.lang.Long parentId;
    /**
     * 简码       db_column: simple_code 
     */	
	
	private java.lang.String simpleCode;
    /**
     * 层级       db_column: level 
     */	
	
	private java.lang.String level;
    /**
     * 描述       db_column: description 
     */	
	
	private java.lang.String description;
    /**
     * 创建时间       db_column: created_at 
     */	
	
	private java.util.Date createdAt;
    /**
     * 最后修改时间       db_column: modified 
     */	
	
	private java.util.Date modified;
	//columns END

	public Department(){
	}

	public Department(
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
	public void setParentId(java.lang.Long value) {
		this.parentId = value;
	}
	
	public java.lang.Long getParentId() {
		return this.parentId;
	}
	public void setSimpleCode(java.lang.String value) {
		this.simpleCode = value;
	}
	
	public java.lang.String getSimpleCode() {
		return this.simpleCode;
	}
	public void setLevel(java.lang.String value) {
		this.level = value;
	}
	
	public java.lang.String getLevel() {
		return this.level;
	}
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	
	public java.lang.String getDescription() {
		return this.description;
	}
	public String getCreatedAtString() {
		return DateConvertUtils.format(getCreatedAt(), FORMAT_CREATED_AT);
	}
	public void setCreatedAtString(String value) {
		setCreatedAt(DateConvertUtils.parse(value, FORMAT_CREATED_AT,java.util.Date.class));
	}
	
	public void setCreatedAt(java.util.Date value) {
		this.createdAt = value;
	}
	
	public java.util.Date getCreatedAt() {
		return this.createdAt;
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
			.append("ParentId",getParentId())
			.append("SimpleCode",getSimpleCode())
			.append("Level",getLevel())
			.append("Description",getDescription())
			.append("CreatedAt",getCreatedAt())
			.append("Modified",getModified())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Department == false) return false;
		if(this == obj) return true;
		Department other = (Department)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
	
	
	//custom
	List<Long> roleIdList = new ArrayList<Long>();
	List<Role> roleList = new ArrayList<Role>();

	Department parentDepartment;
	
	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public Department getParentDepartment() {
		return parentDepartment;
	}

	public void setParentDepartment(Department parentDepartment) {
		this.parentDepartment = parentDepartment;
	}

	
	
}

