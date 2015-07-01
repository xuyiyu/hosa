/*
 * Automatically generated
 */

package com.hosa.web.vo.query;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import com.hosa.core.base.BaseQuery;
import java.util.List;

public class FavoriteListQuery extends BaseQuery implements Serializable {


	/** id */
	private java.lang.Long id;
	private java.lang.Long idNotEq;
	private java.lang.Long idGT;
	private java.lang.Long idLT;
	
	private java.lang.Long idGE;
	private java.lang.Long idLE;
	
	private List<java.lang.Long> idList;
	private List<java.lang.Long> idNotEqList;
	
	private Boolean idQueryShow = false;
	/** favoriteListId */
	private java.lang.Long favoriteListId;
	private java.lang.Long favoriteListIdNotEq;
	private java.lang.Long favoriteListIdGT;
	private java.lang.Long favoriteListIdLT;
	
	private java.lang.Long favoriteListIdGE;
	private java.lang.Long favoriteListIdLE;
	
	private List<java.lang.Long> favoriteListIdList;
	private List<java.lang.Long> favoriteListIdNotEqList;
	
	private Boolean favoriteListIdQueryShow = false;
	/** imageId */
	private java.lang.Long imageId;
	private java.lang.Long imageIdNotEq;
	private java.lang.Long imageIdGT;
	private java.lang.Long imageIdLT;
	
	private java.lang.Long imageIdGE;
	private java.lang.Long imageIdLE;
	
	private List<java.lang.Long> imageIdList;
	private List<java.lang.Long> imageIdNotEqList;
	
	private Boolean imageIdQueryShow = false;
	/** createdAt */
	private java.util.Date createdAtBegin;
	private java.util.Date createdAtEnd;
	
	private Boolean createdAtQueryShow = false;

	public java.lang.Long getId() {
		return this.id;
	}
	
	public void setId(java.lang.Long value) {
		this.id = value;
	}
	public java.lang.Long getIdNotEq() {
		return idNotEq;
	}

	public void setIdNotEq(java.lang.Long value) {
		this.idNotEq = value;
	}
	
	public java.lang.Long getIdGT() {
		return idGT;
	}

	public void setIdGT(java.lang.Long value) {
		this.idGT = value;
	}
	public java.lang.Long getIdLT() {
		return idLT;
	}

	public void setIdLT(java.lang.Long value) {
		this.idLT = value;
	}
	
	public java.lang.Long getIdGE() {
		return idGE;
	}

	public void setIdGE(java.lang.Long value) {
		this.idGE = value;
	}
	public java.lang.Long getIdLE() {
		return idLE;
	}

	public void setIdLE(java.lang.Long value) {
		this.idLE = value;
	}
	
	public List<java.lang.Long> getIdList() {
		return this.idList;
	}
	
	public void setIdList(List<java.lang.Long> value) {
		this.idList = value;
	}
	public List<java.lang.Long> getIdNotEqList() {
		return idNotEqList;
	}

	public void setIdNotEqList(List<java.lang.Long> value) {
		this.idNotEqList = value;
	}

	
	public Boolean getIdQueryShow() {
		return idQueryShow;
	}

	public void setIdQueryShow(Boolean value) {
		this.idQueryShow = value;
	}
	public java.lang.Long getFavoriteListId() {
		return this.favoriteListId;
	}
	
	public void setFavoriteListId(java.lang.Long value) {
		this.favoriteListId = value;
	}
	public java.lang.Long getFavoriteListIdNotEq() {
		return favoriteListIdNotEq;
	}

	public void setFavoriteListIdNotEq(java.lang.Long value) {
		this.favoriteListIdNotEq = value;
	}
	
	public java.lang.Long getFavoriteListIdGT() {
		return favoriteListIdGT;
	}

	public void setFavoriteListIdGT(java.lang.Long value) {
		this.favoriteListIdGT = value;
	}
	public java.lang.Long getFavoriteListIdLT() {
		return favoriteListIdLT;
	}

	public void setFavoriteListIdLT(java.lang.Long value) {
		this.favoriteListIdLT = value;
	}
	
	public java.lang.Long getFavoriteListIdGE() {
		return favoriteListIdGE;
	}

	public void setFavoriteListIdGE(java.lang.Long value) {
		this.favoriteListIdGE = value;
	}
	public java.lang.Long getFavoriteListIdLE() {
		return favoriteListIdLE;
	}

	public void setFavoriteListIdLE(java.lang.Long value) {
		this.favoriteListIdLE = value;
	}
	
	public List<java.lang.Long> getFavoriteListIdList() {
		return this.favoriteListIdList;
	}
	
	public void setFavoriteListIdList(List<java.lang.Long> value) {
		this.favoriteListIdList = value;
	}
	public List<java.lang.Long> getFavoriteListIdNotEqList() {
		return favoriteListIdNotEqList;
	}

	public void setFavoriteListIdNotEqList(List<java.lang.Long> value) {
		this.favoriteListIdNotEqList = value;
	}

	
	public Boolean getFavoriteListIdQueryShow() {
		return favoriteListIdQueryShow;
	}

	public void setFavoriteListIdQueryShow(Boolean value) {
		this.favoriteListIdQueryShow = value;
	}
	public java.lang.Long getImageId() {
		return this.imageId;
	}
	
	public void setImageId(java.lang.Long value) {
		this.imageId = value;
	}
	public java.lang.Long getImageIdNotEq() {
		return imageIdNotEq;
	}

	public void setImageIdNotEq(java.lang.Long value) {
		this.imageIdNotEq = value;
	}
	
	public java.lang.Long getImageIdGT() {
		return imageIdGT;
	}

	public void setImageIdGT(java.lang.Long value) {
		this.imageIdGT = value;
	}
	public java.lang.Long getImageIdLT() {
		return imageIdLT;
	}

	public void setImageIdLT(java.lang.Long value) {
		this.imageIdLT = value;
	}
	
	public java.lang.Long getImageIdGE() {
		return imageIdGE;
	}

	public void setImageIdGE(java.lang.Long value) {
		this.imageIdGE = value;
	}
	public java.lang.Long getImageIdLE() {
		return imageIdLE;
	}

	public void setImageIdLE(java.lang.Long value) {
		this.imageIdLE = value;
	}
	
	public List<java.lang.Long> getImageIdList() {
		return this.imageIdList;
	}
	
	public void setImageIdList(List<java.lang.Long> value) {
		this.imageIdList = value;
	}
	public List<java.lang.Long> getImageIdNotEqList() {
		return imageIdNotEqList;
	}

	public void setImageIdNotEqList(List<java.lang.Long> value) {
		this.imageIdNotEqList = value;
	}

	
	public Boolean getImageIdQueryShow() {
		return imageIdQueryShow;
	}

	public void setImageIdQueryShow(Boolean value) {
		this.imageIdQueryShow = value;
	}
	public java.util.Date getCreatedAtBegin() {
		return this.createdAtBegin;
	}
	
	public void setCreatedAtBegin(java.util.Date value) {
		this.createdAtBegin = value;
	}	
	
	public java.util.Date getCreatedAtEnd() {
		return this.createdAtEnd;
	}
	
	public void setCreatedAtEnd(java.util.Date value) {
		this.createdAtEnd = value;
	}

	
	public Boolean getCreatedAtQueryShow() {
		return createdAtQueryShow;
	}

	public void setCreatedAtQueryShow(Boolean value) {
		this.createdAtQueryShow = value;
	}
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}

