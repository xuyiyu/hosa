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
public class User extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "User";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_NICK = "nick";
	public static final String ALIAS_PORTRAIT_URL = "portraitUrl";
	public static final String ALIAS_FOLLOWER = "follower";
	public static final String ALIAS_USER_FOLLOWING = "userFollowing";
	public static final String ALIAS_LOCATION_FOLLOWING = "locationFollowing";
	public static final String ALIAS_BRIEF_DESCRIPTION = "briefDescription";
	public static final String ALIAS_IMAGE_CNT = "imageCnt";
	public static final String ALIAS_PRAISING_CNT = "praisingCnt";
	public static final String ALIAS_PRAISED_CNT = "praisedCnt";
	public static final String ALIAS_NOTIFIY_CNT = "notifiyCnt";
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
     * nick       db_column: nick 
     */	
	
	private java.lang.String nick;
    /**
     * portraitUrl       db_column: portrait_url 
     */	
	
	private java.lang.String portraitUrl;
    /**
     * follower       db_column: follower 
     */	
	
	private java.lang.Integer follower;
    /**
     * userFollowing       db_column: user_following 
     */	
	
	private java.lang.Integer userFollowing;
    /**
     * locationFollowing       db_column: location_following 
     */	
	
	private java.lang.Integer locationFollowing;
    /**
     * briefDescription       db_column: brief_description 
     */	
	
	private java.lang.String briefDescription;
    /**
     * imageCnt       db_column: image_cnt 
     */	
	
	private java.lang.Integer imageCnt;
    /**
     * praisingCnt       db_column: praising_cnt 
     */	
	
	private java.lang.Integer praisingCnt;
    /**
     * praisedCnt       db_column: praised_cnt 
     */	
	
	private java.lang.Integer praisedCnt;
    /**
     * notifiyCnt       db_column: notifiy_cnt 
     */	
	
	private java.lang.Integer notifiyCnt;
    /**
     * createdAt       db_column: created_at 
     */	
	
	private java.util.Date createdAt;
	//columns END

	public User(){
	}

	public User(
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
	public void setNick(java.lang.String value) {
		this.nick = value;
	}
	
	public java.lang.String getNick() {
		return this.nick;
	}
	public void setPortraitUrl(java.lang.String value) {
		this.portraitUrl = value;
	}
	
	public java.lang.String getPortraitUrl() {
		return this.portraitUrl;
	}
	public void setFollower(java.lang.Integer value) {
		this.follower = value;
	}
	
	public java.lang.Integer getFollower() {
		return this.follower;
	}
	public void setUserFollowing(java.lang.Integer value) {
		this.userFollowing = value;
	}
	
	public java.lang.Integer getUserFollowing() {
		return this.userFollowing;
	}
	public void setLocationFollowing(java.lang.Integer value) {
		this.locationFollowing = value;
	}
	
	public java.lang.Integer getLocationFollowing() {
		return this.locationFollowing;
	}
	public void setBriefDescription(java.lang.String value) {
		this.briefDescription = value;
	}
	
	public java.lang.String getBriefDescription() {
		return this.briefDescription;
	}
	public void setImageCnt(java.lang.Integer value) {
		this.imageCnt = value;
	}
	
	public java.lang.Integer getImageCnt() {
		return this.imageCnt;
	}
	public void setPraisingCnt(java.lang.Integer value) {
		this.praisingCnt = value;
	}
	
	public java.lang.Integer getPraisingCnt() {
		return this.praisingCnt;
	}
	public void setPraisedCnt(java.lang.Integer value) {
		this.praisedCnt = value;
	}
	
	public java.lang.Integer getPraisedCnt() {
		return this.praisedCnt;
	}
	public void setNotifiyCnt(java.lang.Integer value) {
		this.notifiyCnt = value;
	}
	
	public java.lang.Integer getNotifiyCnt() {
		return this.notifiyCnt;
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
			.append("Nick",getNick())
			.append("PortraitUrl",getPortraitUrl())
			.append("Follower",getFollower())
			.append("UserFollowing",getUserFollowing())
			.append("LocationFollowing",getLocationFollowing())
			.append("BriefDescription",getBriefDescription())
			.append("ImageCnt",getImageCnt())
			.append("PraisingCnt",getPraisingCnt())
			.append("PraisedCnt",getPraisedCnt())
			.append("NotifiyCnt",getNotifiyCnt())
			.append("CreatedAt",getCreatedAt())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof User == false) return false;
		if(this == obj) return true;
		User other = (User)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

