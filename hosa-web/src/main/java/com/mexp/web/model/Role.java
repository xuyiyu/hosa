/*
 * Automatically generated
 */

package com.mexp.web.model;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.mexp.core.base.BaseEntity;
import com.mexp.core.utils.DateConvertUtils;

public class Role extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "角色表";
	public static final String ALIAS_ID = "编号";
	public static final String ALIAS_NAME = "名称";
	public static final String ALIAS_DESCRIPTION = "描述";
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
     * 名称       db_column: name 
     */	
	
	private java.lang.String name;
    /**
     * 描述       db_column: description 
     */	
	
	private java.lang.String description;
    /**
     * 最后修改时间       db_column: modified 
     */	
	
	private java.util.Date modified;
	//columns END

	public Role(){
	}

	public Role(
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
			.append("Name",getName())
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
		if(obj instanceof Role == false) return false;
		if(this == obj) return true;
		Role other = (Role)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
	
	//custom
		List<Authority> authorityList;
		List<Long> authorityIdList;

		public List<Authority> getAuthorityList() {
			return authorityList;
		}

		public void setAuthorityList(List<Authority> authorityList) {
			this.authorityList = authorityList;
		}

		public List<Long> getAuthorityIdList() {
			return authorityIdList;
		}

		public void setAuthorityIdList(List<Long> authorityIdList) {
			this.authorityIdList = authorityIdList;
		}
		
		
		//custom
}

