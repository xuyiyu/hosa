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

public class Settings extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Settings";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_DEPARTMENT_ID = "departmentId";
	public static final String ALIAS_VARIABLE = "系统变量名称";
	public static final String ALIAS_VAL = "系统变量值";
	public static final String ALIAS_DESCRIPTION = "描述";
	public static final String ALIAS_MODIFIED = "最后修改时间";
	
	//date formats
	
	public static final String FORMAT_MODIFIED = TIMESTAMP_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	
	private java.lang.Long id;
    /**
     * departmentId       db_column: department_id 
     */	
	
	private java.lang.Long departmentId;
    /**
     * 系统变量名称       db_column: variable 
     */	
	
	private java.lang.String variable;
    /**
     * 系统变量值       db_column: val 
     */	
	
	private java.lang.String val;
    /**
     * 描述       db_column: description 
     */	
	
	private java.lang.String description;
    /**
     * 最后修改时间       db_column: modified 
     */	
	
	private java.util.Date modified;
	//columns END

	public Settings(){
	}

	public Settings(
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
	public void setDepartmentId(java.lang.Long value) {
		this.departmentId = value;
	}
	
	public java.lang.Long getDepartmentId() {
		return this.departmentId;
	}
	public void setVariable(java.lang.String value) {
		this.variable = value;
	}
	
	public java.lang.String getVariable() {
		return this.variable;
	}
	public void setVal(java.lang.String value) {
		this.val = value;
	}
	
	public java.lang.String getVal() {
		return this.val;
	}
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	
	public java.lang.String getDescription() {
		return this.description;
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
			.append("DepartmentId",getDepartmentId())
			.append("Variable",getVariable())
			.append("Val",getVal())
			.append("Description",getDescription())
			.append("Modified",getModified())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Settings == false) return false;
		if(this == obj) return true;
		Settings other = (Settings)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

