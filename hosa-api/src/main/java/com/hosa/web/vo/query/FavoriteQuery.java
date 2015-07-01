/*
 * Automatically generated
 */

package com.hosa.web.vo.query;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import com.hosa.core.base.BaseQuery;
import java.util.List;

public class FavoriteQuery extends BaseQuery implements Serializable {


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
	/** name */
	private java.lang.String name;
	private java.lang.String nameLike;
	private java.lang.String nameBeginLike;
	private java.lang.String nameEndLike;
	
	private List<java.lang.String> nameListAnd;
	private List<java.lang.String> nameLikeListAnd;
	private List<java.lang.String> nameBeginLikeListAnd;
	private List<java.lang.String> nameEndLikeListAnd;
	
	private List<java.lang.String> nameListOr;
	private List<java.lang.String> nameLikeListOr;
	private List<java.lang.String> nameBeginLikeListOr;
	private List<java.lang.String> nameEndLikeListOr;
	
	private Boolean nameQueryShow = false;
	/** favoriteCnt */
	private java.lang.Integer favoriteCnt;
	private java.lang.Integer favoriteCntNotEq;
	private java.lang.Integer favoriteCntGT;
	private java.lang.Integer favoriteCntLT;
	
	private java.lang.Integer favoriteCntGE;
	private java.lang.Integer favoriteCntLE;
	
	private List<java.lang.Integer> favoriteCntList;
	private List<java.lang.Integer> favoriteCntNotEqList;
	
	private Boolean favoriteCntQueryShow = false;
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
	public java.lang.String getName() {
		return this.name;
	}
	
	public void setName(java.lang.String value) {
		this.name = value;
	}
	public java.lang.String getNameLike() {
		return this.nameLike;
	}
	
	public void setNameLike(java.lang.String value) {
		this.nameLike = value;
	}
	public java.lang.String getNameBeginLike() {
		return this.nameBeginLike;
	}
	
	public void setNameBeginLike(java.lang.String value) {
		this.nameBeginLike = value;
	}
	public java.lang.String getNameEndLike() {
		return this.nameEndLike;
	}
	
	public void setNameEndLike(java.lang.String value) {
		this.nameEndLike = value;
	}

	public List<java.lang.String> getNameListAnd() {
		return this.nameListAnd;
	}
	
	public void setNameListAnd(List<java.lang.String> value) {
		this.nameListAnd = value;
	}
	public List<java.lang.String> getNameLikeListAnd() {
		return this.nameLikeListAnd;
	}
	
	public void setNameLikeListAnd(List<java.lang.String> value) {
		this.nameLikeListAnd = value;
	}
	public List<java.lang.String> getNameBeginLikeListAnd() {
		return this.nameBeginLikeListAnd;
	}
	
	public void setNameBeginLikeListAnd(List<java.lang.String> value) {
		this.nameBeginLikeListAnd = value;
	}
	public List<java.lang.String> getNameEndLikeListAnd() {
		return this.nameEndLikeListAnd;
	}
	
	public void setNameEndLikeListAnd(List<java.lang.String> value) {
		this.nameEndLikeListAnd = value;
	}
	
	public List<java.lang.String> getNameListOr() {
		return this.nameListOr;
	}
	
	public void setNameListOr(List<java.lang.String> value) {
		this.nameListOr = value;
	}
	public List<java.lang.String> getNameLikeListOr() {
		return this.nameLikeListOr;
	}
	
	public void setNameLikeListOr(List<java.lang.String> value) {
		this.nameLikeListOr = value;
	}
	public List<java.lang.String> getNameBeginLikeListOr() {
		return this.nameBeginLikeListOr;
	}
	
	public void setNameBeginLikeListOr(List<java.lang.String> value) {
		this.nameBeginLikeListOr = value;
	}
	public List<java.lang.String> getNameEndLikeListOr() {
		return this.nameEndLikeListOr;
	}
	
	public void setNameEndLikeListOr(List<java.lang.String> value) {
		this.nameEndLikeListOr = value;
	}
	
	public Boolean getNameQueryShow() {
		return nameQueryShow;
	}

	public void setNameQueryShow(Boolean value) {
		this.nameQueryShow = value;
	}
	public java.lang.Integer getFavoriteCnt() {
		return this.favoriteCnt;
	}
	
	public void setFavoriteCnt(java.lang.Integer value) {
		this.favoriteCnt = value;
	}
	public java.lang.Integer getFavoriteCntNotEq() {
		return favoriteCntNotEq;
	}

	public void setFavoriteCntNotEq(java.lang.Integer value) {
		this.favoriteCntNotEq = value;
	}
	
	public java.lang.Integer getFavoriteCntGT() {
		return favoriteCntGT;
	}

	public void setFavoriteCntGT(java.lang.Integer value) {
		this.favoriteCntGT = value;
	}
	public java.lang.Integer getFavoriteCntLT() {
		return favoriteCntLT;
	}

	public void setFavoriteCntLT(java.lang.Integer value) {
		this.favoriteCntLT = value;
	}
	
	public java.lang.Integer getFavoriteCntGE() {
		return favoriteCntGE;
	}

	public void setFavoriteCntGE(java.lang.Integer value) {
		this.favoriteCntGE = value;
	}
	public java.lang.Integer getFavoriteCntLE() {
		return favoriteCntLE;
	}

	public void setFavoriteCntLE(java.lang.Integer value) {
		this.favoriteCntLE = value;
	}
	
	public List<java.lang.Integer> getFavoriteCntList() {
		return this.favoriteCntList;
	}
	
	public void setFavoriteCntList(List<java.lang.Integer> value) {
		this.favoriteCntList = value;
	}
	public List<java.lang.Integer> getFavoriteCntNotEqList() {
		return favoriteCntNotEqList;
	}

	public void setFavoriteCntNotEqList(List<java.lang.Integer> value) {
		this.favoriteCntNotEqList = value;
	}

	
	public Boolean getFavoriteCntQueryShow() {
		return favoriteCntQueryShow;
	}

	public void setFavoriteCntQueryShow(Boolean value) {
		this.favoriteCntQueryShow = value;
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

