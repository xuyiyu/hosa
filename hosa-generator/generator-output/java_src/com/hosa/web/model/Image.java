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
public class Image extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Image";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_BITMAP_WIDTH = "bitmapWidth";
	public static final String ALIAS_BITMAP_HEIGHT = "bitmapHeight";
	public static final String ALIAS_ORIGINAL_URL = "originalUrl";
	public static final String ALIAS_COMPRESS_URL = "compressUrl";
	public static final String ALIAS_LOCATION_NAME = "locationName";
	public static final String ALIAS_LONGITUDE = "longitude";
	public static final String ALIAS_LATITUDE = "latitude";
	public static final String ALIAS_CONTENT = "content";
	public static final String ALIAS_USER_ID = "userId";
	public static final String ALIAS_FAVORITED_CNT = "favoritedCnt";
	public static final String ALIAS_COMMENT_CNT = "commentCnt";
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
     * bitmapWidth       db_column: bitmap_width 
     */	
	
	private java.lang.Integer bitmapWidth;
    /**
     * bitmapHeight       db_column: bitmap_height 
     */	
	
	private java.lang.Integer bitmapHeight;
    /**
     * originalUrl       db_column: original_url 
     */	
	
	private java.lang.String originalUrl;
    /**
     * compressUrl       db_column: compress_url 
     */	
	
	private java.lang.String compressUrl;
    /**
     * locationName       db_column: location_name 
     */	
	
	private java.lang.String locationName;
    /**
     * longitude       db_column: longitude 
     */	
	
	private java.lang.String longitude;
    /**
     * latitude       db_column: latitude 
     */	
	
	private java.lang.String latitude;
    /**
     * content       db_column: content 
     */	
	
	private java.lang.String content;
    /**
     * userId       db_column: user_id 
     */	
	
	private java.lang.Long userId;
    /**
     * favoritedCnt       db_column: favorited_cnt 
     */	
	
	private java.lang.Integer favoritedCnt;
    /**
     * commentCnt       db_column: comment_cnt 
     */	
	
	private java.lang.Integer commentCnt;
    /**
     * createdAt       db_column: created_at 
     */	
	
	private java.util.Date createdAt;
	//columns END

	public Image(){
	}

	public Image(
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
	public void setBitmapWidth(java.lang.Integer value) {
		this.bitmapWidth = value;
	}
	
	public java.lang.Integer getBitmapWidth() {
		return this.bitmapWidth;
	}
	public void setBitmapHeight(java.lang.Integer value) {
		this.bitmapHeight = value;
	}
	
	public java.lang.Integer getBitmapHeight() {
		return this.bitmapHeight;
	}
	public void setOriginalUrl(java.lang.String value) {
		this.originalUrl = value;
	}
	
	public java.lang.String getOriginalUrl() {
		return this.originalUrl;
	}
	public void setCompressUrl(java.lang.String value) {
		this.compressUrl = value;
	}
	
	public java.lang.String getCompressUrl() {
		return this.compressUrl;
	}
	public void setLocationName(java.lang.String value) {
		this.locationName = value;
	}
	
	public java.lang.String getLocationName() {
		return this.locationName;
	}
	public void setLongitude(java.lang.String value) {
		this.longitude = value;
	}
	
	public java.lang.String getLongitude() {
		return this.longitude;
	}
	public void setLatitude(java.lang.String value) {
		this.latitude = value;
	}
	
	public java.lang.String getLatitude() {
		return this.latitude;
	}
	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	
	public java.lang.Long getUserId() {
		return this.userId;
	}
	public void setFavoritedCnt(java.lang.Integer value) {
		this.favoritedCnt = value;
	}
	
	public java.lang.Integer getFavoritedCnt() {
		return this.favoritedCnt;
	}
	public void setCommentCnt(java.lang.Integer value) {
		this.commentCnt = value;
	}
	
	public java.lang.Integer getCommentCnt() {
		return this.commentCnt;
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
			.append("BitmapWidth",getBitmapWidth())
			.append("BitmapHeight",getBitmapHeight())
			.append("OriginalUrl",getOriginalUrl())
			.append("CompressUrl",getCompressUrl())
			.append("LocationName",getLocationName())
			.append("Longitude",getLongitude())
			.append("Latitude",getLatitude())
			.append("Content",getContent())
			.append("UserId",getUserId())
			.append("FavoritedCnt",getFavoritedCnt())
			.append("CommentCnt",getCommentCnt())
			.append("CreatedAt",getCreatedAt())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Image == false) return false;
		if(this == obj) return true;
		Image other = (Image)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

