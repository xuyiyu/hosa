/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.vo.query;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import com.gaojiaoyuan.core.base.BaseQuery;
import java.util.List;

public class LocationFollowingQuery extends BaseQuery implements Serializable {


	/** id */
	private java.lang.Integer id;
	private java.lang.Integer idNotEq;
	private java.lang.Integer idGT;
	private java.lang.Integer idLT;
	
	private java.lang.Integer idGE;
	private java.lang.Integer idLE;
	
	private List<java.lang.Integer> idList;
	private List<java.lang.Integer> idNotEqList;
	
	private Boolean idQueryShow = false;
	/** locationId */
	private java.lang.Long locationId;
	private java.lang.Long locationIdNotEq;
	private java.lang.Long locationIdGT;
	private java.lang.Long locationIdLT;
	
	private java.lang.Long locationIdGE;
	private java.lang.Long locationIdLE;
	
	private List<java.lang.Long> locationIdList;
	private List<java.lang.Long> locationIdNotEqList;
	
	private Boolean locationIdQueryShow = false;
	/** followerUserId */
	private java.lang.Long followerUserId;
	private java.lang.Long followerUserIdNotEq;
	private java.lang.Long followerUserIdGT;
	private java.lang.Long followerUserIdLT;
	
	private java.lang.Long followerUserIdGE;
	private java.lang.Long followerUserIdLE;
	
	private List<java.lang.Long> followerUserIdList;
	private List<java.lang.Long> followerUserIdNotEqList;
	
	private Boolean followerUserIdQueryShow = false;
	/** createdAt */
	private java.util.Date createdAtBegin;
	private java.util.Date createdAtEnd;
	
	private Boolean createdAtQueryShow = false;

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	public java.lang.Integer getIdNotEq() {
		return idNotEq;
	}

	public void setIdNotEq(java.lang.Integer value) {
		this.idNotEq = value;
	}
	
	public java.lang.Integer getIdGT() {
		return idGT;
	}

	public void setIdGT(java.lang.Integer value) {
		this.idGT = value;
	}
	public java.lang.Integer getIdLT() {
		return idLT;
	}

	public void setIdLT(java.lang.Integer value) {
		this.idLT = value;
	}
	
	public java.lang.Integer getIdGE() {
		return idGE;
	}

	public void setIdGE(java.lang.Integer value) {
		this.idGE = value;
	}
	public java.lang.Integer getIdLE() {
		return idLE;
	}

	public void setIdLE(java.lang.Integer value) {
		this.idLE = value;
	}
	
	public List<java.lang.Integer> getIdList() {
		return this.idList;
	}
	
	public void setIdList(List<java.lang.Integer> value) {
		this.idList = value;
	}
	public List<java.lang.Integer> getIdNotEqList() {
		return idNotEqList;
	}

	public void setIdNotEqList(List<java.lang.Integer> value) {
		this.idNotEqList = value;
	}

	
	public Boolean getIdQueryShow() {
		return idQueryShow;
	}

	public void setIdQueryShow(Boolean value) {
		this.idQueryShow = value;
	}
	public java.lang.Long getLocationId() {
		return this.locationId;
	}
	
	public void setLocationId(java.lang.Long value) {
		this.locationId = value;
	}
	public java.lang.Long getLocationIdNotEq() {
		return locationIdNotEq;
	}

	public void setLocationIdNotEq(java.lang.Long value) {
		this.locationIdNotEq = value;
	}
	
	public java.lang.Long getLocationIdGT() {
		return locationIdGT;
	}

	public void setLocationIdGT(java.lang.Long value) {
		this.locationIdGT = value;
	}
	public java.lang.Long getLocationIdLT() {
		return locationIdLT;
	}

	public void setLocationIdLT(java.lang.Long value) {
		this.locationIdLT = value;
	}
	
	public java.lang.Long getLocationIdGE() {
		return locationIdGE;
	}

	public void setLocationIdGE(java.lang.Long value) {
		this.locationIdGE = value;
	}
	public java.lang.Long getLocationIdLE() {
		return locationIdLE;
	}

	public void setLocationIdLE(java.lang.Long value) {
		this.locationIdLE = value;
	}
	
	public List<java.lang.Long> getLocationIdList() {
		return this.locationIdList;
	}
	
	public void setLocationIdList(List<java.lang.Long> value) {
		this.locationIdList = value;
	}
	public List<java.lang.Long> getLocationIdNotEqList() {
		return locationIdNotEqList;
	}

	public void setLocationIdNotEqList(List<java.lang.Long> value) {
		this.locationIdNotEqList = value;
	}

	
	public Boolean getLocationIdQueryShow() {
		return locationIdQueryShow;
	}

	public void setLocationIdQueryShow(Boolean value) {
		this.locationIdQueryShow = value;
	}
	public java.lang.Long getFollowerUserId() {
		return this.followerUserId;
	}
	
	public void setFollowerUserId(java.lang.Long value) {
		this.followerUserId = value;
	}
	public java.lang.Long getFollowerUserIdNotEq() {
		return followerUserIdNotEq;
	}

	public void setFollowerUserIdNotEq(java.lang.Long value) {
		this.followerUserIdNotEq = value;
	}
	
	public java.lang.Long getFollowerUserIdGT() {
		return followerUserIdGT;
	}

	public void setFollowerUserIdGT(java.lang.Long value) {
		this.followerUserIdGT = value;
	}
	public java.lang.Long getFollowerUserIdLT() {
		return followerUserIdLT;
	}

	public void setFollowerUserIdLT(java.lang.Long value) {
		this.followerUserIdLT = value;
	}
	
	public java.lang.Long getFollowerUserIdGE() {
		return followerUserIdGE;
	}

	public void setFollowerUserIdGE(java.lang.Long value) {
		this.followerUserIdGE = value;
	}
	public java.lang.Long getFollowerUserIdLE() {
		return followerUserIdLE;
	}

	public void setFollowerUserIdLE(java.lang.Long value) {
		this.followerUserIdLE = value;
	}
	
	public List<java.lang.Long> getFollowerUserIdList() {
		return this.followerUserIdList;
	}
	
	public void setFollowerUserIdList(List<java.lang.Long> value) {
		this.followerUserIdList = value;
	}
	public List<java.lang.Long> getFollowerUserIdNotEqList() {
		return followerUserIdNotEqList;
	}

	public void setFollowerUserIdNotEqList(List<java.lang.Long> value) {
		this.followerUserIdNotEqList = value;
	}

	
	public Boolean getFollowerUserIdQueryShow() {
		return followerUserIdQueryShow;
	}

	public void setFollowerUserIdQueryShow(Boolean value) {
		this.followerUserIdQueryShow = value;
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

