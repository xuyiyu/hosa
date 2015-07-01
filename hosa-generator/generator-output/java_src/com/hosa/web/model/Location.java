/*
 * Automatically generated
 */

package com.hosa.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.hosa.core.base.BaseEntity;
import com.hosa.core.utils.DateConvertUtils;

@Entity
public class Location extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Location";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NAME = "name";
	public static final String ALIAS_TYPE = "1.��ϸ��ַ  ��������ϸ�ľ�γ�ȣ�             2.ĳһ����Χ����";
	public static final String ALIAS_FOLLOWER = "follower";
	public static final String ALIAS_IMAGE_CNT = "imageCnt";
	public static final String ALIAS_FAVORITED_CNT = "favoritedCnt";
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
     * 1.��ϸ��ַ  ��������ϸ�ľ�γ�ȣ�             2.ĳһ����Χ����       db_column: type 
     */	
	
	private Integer type;
    /**
     * follower       db_column: follower 
     */	
	
	private java.lang.Integer follower;
    /**
     * imageCnt       db_column: image_cnt 
     */	
	
	private java.lang.Integer imageCnt;
    /**
     * favoritedCnt       db_column: favorited_cnt 
     */	
	
	private java.lang.Integer favoritedCnt;
    /**
     * createdAt       db_column: created_at 
     */	
	
	private java.util.Date createdAt;
	//columns END

	public Location(){
	}

	public Location(
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
	public void setType(Integer value) {
		this.type = value;
	}
	
	public Integer getType() {
		return this.type;
	}
	public void setFollower(java.lang.Integer value) {
		this.follower = value;
	}
	
	public java.lang.Integer getFollower() {
		return this.follower;
	}
	public void setImageCnt(java.lang.Integer value) {
		this.imageCnt = value;
	}
	
	public java.lang.Integer getImageCnt() {
		return this.imageCnt;
	}
	public void setFavoritedCnt(java.lang.Integer value) {
		this.favoritedCnt = value;
	}
	
	public java.lang.Integer getFavoritedCnt() {
		return this.favoritedCnt;
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
			.append("Type",getType())
			.append("Follower",getFollower())
			.append("ImageCnt",getImageCnt())
			.append("FavoritedCnt",getFavoritedCnt())
			.append("CreatedAt",getCreatedAt())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Location == false) return false;
		if(this == obj) return true;
		Location other = (Location)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

