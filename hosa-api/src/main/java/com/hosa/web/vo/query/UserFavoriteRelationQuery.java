/*
 * Automatically generated
 */

package com.hosa.web.vo.query;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import com.hosa.core.base.BaseQuery;
import java.util.List;

public class UserFavoriteRelationQuery extends BaseQuery implements Serializable {


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
	/** userId */
	private java.lang.Long userId;
	private java.lang.Long userIdNotEq;
	private java.lang.Long userIdGT;
	private java.lang.Long userIdLT;
	
	private java.lang.Long userIdGE;
	private java.lang.Long userIdLE;
	
	private List<java.lang.Long> userIdList;
	private List<java.lang.Long> userIdNotEqList;
	
	private Boolean userIdQueryShow = false;
	/** favoriteId */
	private java.lang.Long favoriteId;
	private java.lang.Long favoriteIdNotEq;
	private java.lang.Long favoriteIdGT;
	private java.lang.Long favoriteIdLT;
	
	private java.lang.Long favoriteIdGE;
	private java.lang.Long favoriteIdLE;
	
	private List<java.lang.Long> favoriteIdList;
	private List<java.lang.Long> favoriteIdNotEqList;
	
	private Boolean favoriteIdQueryShow = false;
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
	public java.lang.Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}
	public java.lang.Long getUserIdNotEq() {
		return userIdNotEq;
	}

	public void setUserIdNotEq(java.lang.Long value) {
		this.userIdNotEq = value;
	}
	
	public java.lang.Long getUserIdGT() {
		return userIdGT;
	}

	public void setUserIdGT(java.lang.Long value) {
		this.userIdGT = value;
	}
	public java.lang.Long getUserIdLT() {
		return userIdLT;
	}

	public void setUserIdLT(java.lang.Long value) {
		this.userIdLT = value;
	}
	
	public java.lang.Long getUserIdGE() {
		return userIdGE;
	}

	public void setUserIdGE(java.lang.Long value) {
		this.userIdGE = value;
	}
	public java.lang.Long getUserIdLE() {
		return userIdLE;
	}

	public void setUserIdLE(java.lang.Long value) {
		this.userIdLE = value;
	}
	
	public List<java.lang.Long> getUserIdList() {
		return this.userIdList;
	}
	
	public void setUserIdList(List<java.lang.Long> value) {
		this.userIdList = value;
	}
	public List<java.lang.Long> getUserIdNotEqList() {
		return userIdNotEqList;
	}

	public void setUserIdNotEqList(List<java.lang.Long> value) {
		this.userIdNotEqList = value;
	}

	
	public Boolean getUserIdQueryShow() {
		return userIdQueryShow;
	}

	public void setUserIdQueryShow(Boolean value) {
		this.userIdQueryShow = value;
	}
	public java.lang.Long getFavoriteId() {
		return this.favoriteId;
	}
	
	public void setFavoriteId(java.lang.Long value) {
		this.favoriteId = value;
	}
	public java.lang.Long getFavoriteIdNotEq() {
		return favoriteIdNotEq;
	}

	public void setFavoriteIdNotEq(java.lang.Long value) {
		this.favoriteIdNotEq = value;
	}
	
	public java.lang.Long getFavoriteIdGT() {
		return favoriteIdGT;
	}

	public void setFavoriteIdGT(java.lang.Long value) {
		this.favoriteIdGT = value;
	}
	public java.lang.Long getFavoriteIdLT() {
		return favoriteIdLT;
	}

	public void setFavoriteIdLT(java.lang.Long value) {
		this.favoriteIdLT = value;
	}
	
	public java.lang.Long getFavoriteIdGE() {
		return favoriteIdGE;
	}

	public void setFavoriteIdGE(java.lang.Long value) {
		this.favoriteIdGE = value;
	}
	public java.lang.Long getFavoriteIdLE() {
		return favoriteIdLE;
	}

	public void setFavoriteIdLE(java.lang.Long value) {
		this.favoriteIdLE = value;
	}
	
	public List<java.lang.Long> getFavoriteIdList() {
		return this.favoriteIdList;
	}
	
	public void setFavoriteIdList(List<java.lang.Long> value) {
		this.favoriteIdList = value;
	}
	public List<java.lang.Long> getFavoriteIdNotEqList() {
		return favoriteIdNotEqList;
	}

	public void setFavoriteIdNotEqList(List<java.lang.Long> value) {
		this.favoriteIdNotEqList = value;
	}

	
	public Boolean getFavoriteIdQueryShow() {
		return favoriteIdQueryShow;
	}

	public void setFavoriteIdQueryShow(Boolean value) {
		this.favoriteIdQueryShow = value;
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

