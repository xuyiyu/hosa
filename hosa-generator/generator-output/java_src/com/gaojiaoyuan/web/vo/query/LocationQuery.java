/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.vo.query;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import com.gaojiaoyuan.core.base.BaseQuery;
import java.util.List;

public class LocationQuery extends BaseQuery implements Serializable {


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
	/** 1.��ϸ��ַ  ��������ϸ�ľ�γ�ȣ�             2.ĳһ����Χ���� */
	private Integer type;
	private Integer typeNotEq;
	private Integer typeGT;
	private Integer typeLT;
	
	private Integer typeGE;
	private Integer typeLE;
	
	private List<Integer> typeList;
	private List<Integer> typeNotEqList;
	
	private Boolean typeQueryShow = false;
	/** follower */
	private java.lang.Integer follower;
	private java.lang.Integer followerNotEq;
	private java.lang.Integer followerGT;
	private java.lang.Integer followerLT;
	
	private java.lang.Integer followerGE;
	private java.lang.Integer followerLE;
	
	private List<java.lang.Integer> followerList;
	private List<java.lang.Integer> followerNotEqList;
	
	private Boolean followerQueryShow = false;
	/** imageCnt */
	private java.lang.Integer imageCnt;
	private java.lang.Integer imageCntNotEq;
	private java.lang.Integer imageCntGT;
	private java.lang.Integer imageCntLT;
	
	private java.lang.Integer imageCntGE;
	private java.lang.Integer imageCntLE;
	
	private List<java.lang.Integer> imageCntList;
	private List<java.lang.Integer> imageCntNotEqList;
	
	private Boolean imageCntQueryShow = false;
	/** favoritedCnt */
	private java.lang.Integer favoritedCnt;
	private java.lang.Integer favoritedCntNotEq;
	private java.lang.Integer favoritedCntGT;
	private java.lang.Integer favoritedCntLT;
	
	private java.lang.Integer favoritedCntGE;
	private java.lang.Integer favoritedCntLE;
	
	private List<java.lang.Integer> favoritedCntList;
	private List<java.lang.Integer> favoritedCntNotEqList;
	
	private Boolean favoritedCntQueryShow = false;
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
	public Integer getType() {
		return this.type;
	}
	
	public void setType(Integer value) {
		this.type = value;
	}
	public Integer getTypeNotEq() {
		return typeNotEq;
	}

	public void setTypeNotEq(Integer value) {
		this.typeNotEq = value;
	}
	
	public Integer getTypeGT() {
		return typeGT;
	}

	public void setTypeGT(Integer value) {
		this.typeGT = value;
	}
	public Integer getTypeLT() {
		return typeLT;
	}

	public void setTypeLT(Integer value) {
		this.typeLT = value;
	}
	
	public Integer getTypeGE() {
		return typeGE;
	}

	public void setTypeGE(Integer value) {
		this.typeGE = value;
	}
	public Integer getTypeLE() {
		return typeLE;
	}

	public void setTypeLE(Integer value) {
		this.typeLE = value;
	}
	
	public List<Integer> getTypeList() {
		return this.typeList;
	}
	
	public void setTypeList(List<Integer> value) {
		this.typeList = value;
	}
	public List<Integer> getTypeNotEqList() {
		return typeNotEqList;
	}

	public void setTypeNotEqList(List<Integer> value) {
		this.typeNotEqList = value;
	}

	
	public Boolean getTypeQueryShow() {
		return typeQueryShow;
	}

	public void setTypeQueryShow(Boolean value) {
		this.typeQueryShow = value;
	}
	public java.lang.Integer getFollower() {
		return this.follower;
	}
	
	public void setFollower(java.lang.Integer value) {
		this.follower = value;
	}
	public java.lang.Integer getFollowerNotEq() {
		return followerNotEq;
	}

	public void setFollowerNotEq(java.lang.Integer value) {
		this.followerNotEq = value;
	}
	
	public java.lang.Integer getFollowerGT() {
		return followerGT;
	}

	public void setFollowerGT(java.lang.Integer value) {
		this.followerGT = value;
	}
	public java.lang.Integer getFollowerLT() {
		return followerLT;
	}

	public void setFollowerLT(java.lang.Integer value) {
		this.followerLT = value;
	}
	
	public java.lang.Integer getFollowerGE() {
		return followerGE;
	}

	public void setFollowerGE(java.lang.Integer value) {
		this.followerGE = value;
	}
	public java.lang.Integer getFollowerLE() {
		return followerLE;
	}

	public void setFollowerLE(java.lang.Integer value) {
		this.followerLE = value;
	}
	
	public List<java.lang.Integer> getFollowerList() {
		return this.followerList;
	}
	
	public void setFollowerList(List<java.lang.Integer> value) {
		this.followerList = value;
	}
	public List<java.lang.Integer> getFollowerNotEqList() {
		return followerNotEqList;
	}

	public void setFollowerNotEqList(List<java.lang.Integer> value) {
		this.followerNotEqList = value;
	}

	
	public Boolean getFollowerQueryShow() {
		return followerQueryShow;
	}

	public void setFollowerQueryShow(Boolean value) {
		this.followerQueryShow = value;
	}
	public java.lang.Integer getImageCnt() {
		return this.imageCnt;
	}
	
	public void setImageCnt(java.lang.Integer value) {
		this.imageCnt = value;
	}
	public java.lang.Integer getImageCntNotEq() {
		return imageCntNotEq;
	}

	public void setImageCntNotEq(java.lang.Integer value) {
		this.imageCntNotEq = value;
	}
	
	public java.lang.Integer getImageCntGT() {
		return imageCntGT;
	}

	public void setImageCntGT(java.lang.Integer value) {
		this.imageCntGT = value;
	}
	public java.lang.Integer getImageCntLT() {
		return imageCntLT;
	}

	public void setImageCntLT(java.lang.Integer value) {
		this.imageCntLT = value;
	}
	
	public java.lang.Integer getImageCntGE() {
		return imageCntGE;
	}

	public void setImageCntGE(java.lang.Integer value) {
		this.imageCntGE = value;
	}
	public java.lang.Integer getImageCntLE() {
		return imageCntLE;
	}

	public void setImageCntLE(java.lang.Integer value) {
		this.imageCntLE = value;
	}
	
	public List<java.lang.Integer> getImageCntList() {
		return this.imageCntList;
	}
	
	public void setImageCntList(List<java.lang.Integer> value) {
		this.imageCntList = value;
	}
	public List<java.lang.Integer> getImageCntNotEqList() {
		return imageCntNotEqList;
	}

	public void setImageCntNotEqList(List<java.lang.Integer> value) {
		this.imageCntNotEqList = value;
	}

	
	public Boolean getImageCntQueryShow() {
		return imageCntQueryShow;
	}

	public void setImageCntQueryShow(Boolean value) {
		this.imageCntQueryShow = value;
	}
	public java.lang.Integer getFavoritedCnt() {
		return this.favoritedCnt;
	}
	
	public void setFavoritedCnt(java.lang.Integer value) {
		this.favoritedCnt = value;
	}
	public java.lang.Integer getFavoritedCntNotEq() {
		return favoritedCntNotEq;
	}

	public void setFavoritedCntNotEq(java.lang.Integer value) {
		this.favoritedCntNotEq = value;
	}
	
	public java.lang.Integer getFavoritedCntGT() {
		return favoritedCntGT;
	}

	public void setFavoritedCntGT(java.lang.Integer value) {
		this.favoritedCntGT = value;
	}
	public java.lang.Integer getFavoritedCntLT() {
		return favoritedCntLT;
	}

	public void setFavoritedCntLT(java.lang.Integer value) {
		this.favoritedCntLT = value;
	}
	
	public java.lang.Integer getFavoritedCntGE() {
		return favoritedCntGE;
	}

	public void setFavoritedCntGE(java.lang.Integer value) {
		this.favoritedCntGE = value;
	}
	public java.lang.Integer getFavoritedCntLE() {
		return favoritedCntLE;
	}

	public void setFavoritedCntLE(java.lang.Integer value) {
		this.favoritedCntLE = value;
	}
	
	public List<java.lang.Integer> getFavoritedCntList() {
		return this.favoritedCntList;
	}
	
	public void setFavoritedCntList(List<java.lang.Integer> value) {
		this.favoritedCntList = value;
	}
	public List<java.lang.Integer> getFavoritedCntNotEqList() {
		return favoritedCntNotEqList;
	}

	public void setFavoritedCntNotEqList(List<java.lang.Integer> value) {
		this.favoritedCntNotEqList = value;
	}

	
	public Boolean getFavoritedCntQueryShow() {
		return favoritedCntQueryShow;
	}

	public void setFavoritedCntQueryShow(Boolean value) {
		this.favoritedCntQueryShow = value;
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

