/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.vo.query;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import com.gaojiaoyuan.core.base.BaseQuery;
import java.util.List;

public class UserFollowingQuery extends BaseQuery implements Serializable {


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

