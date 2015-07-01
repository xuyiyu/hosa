/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gaojiaoyuan.core.base.BaseEntity;
import com.gaojiaoyuan.core.utils.DateConvertUtils;

@Entity
public class Favorite extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Favorite";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_FAVORITE_CNT = "favoriteCnt";
	public static final String ALIAS_CREATED_AT = "createdAt";
	
	//date formats
	public static final String FORMAT_CREATED_AT = DATE_FORMAT;
	
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * id       db_column: id 
     */	
	@Id	
	private java.lang.Long id;
    /**
     * name       db_column: name 
     */	
	
	private java.lang.String name;
    /**
     * favoriteCnt       db_column: favorite_cnt 
     */	
	
	private java.lang.Integer favoriteCnt;
    /**
     * createdAt       db_column: created_at 
     */	
	
	private java.util.Date createdAt;
	//columns END

	public Favorite(){
	}

	public Favorite(
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
	public void setFavoriteCnt(java.lang.Integer value) {
		this.favoriteCnt = value;
	}
	
	public java.lang.Integer getFavoriteCnt() {
		return this.favoriteCnt;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("FavoriteCnt",getFavoriteCnt())
			.append("CreatedAt",getCreatedAt())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Favorite == false) return false;
		if(this == obj) return true;
		Favorite other = (Favorite)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

