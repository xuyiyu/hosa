/*
 * Automatically generated
 */

package com.mexp.web.vo.query;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.mexp.core.base.BaseQuery;

public class StaffQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;

	/** 编号 */
	private java.lang.Long id;
	private java.lang.Long idNotEq;
	private java.lang.Long idGT;
	private java.lang.Long idLT;
	
	private java.lang.Long idGE;
	private java.lang.Long idLE;
	
	private List<java.lang.Long> idList;
	private List<java.lang.Long> idNotEqList;
	/** 姓名 */
	private java.lang.String name;
	private java.lang.String nameLike;
	private java.lang.String nameBeginLike;
	private java.lang.String nameEndLike;
	/** 简码 */
	private java.lang.String simpleCode;
	private java.lang.String simpleCodeLike;
	private java.lang.String simpleCodeBeginLike;
	private java.lang.String simpleCodeEndLike;
	/** 用户组 */
	private java.lang.Long departmentId;
	private java.lang.Long departmentIdNotEq;
	private java.lang.Long departmentIdGT;
	private java.lang.Long departmentIdLT;
	
	private java.lang.Long departmentIdGE;
	private java.lang.Long departmentIdLE;
	
	private List<java.lang.Long> departmentIdList;
	private List<java.lang.Long> departmentIdNotEqList;
	/** 性别{1：男，2：女，0：未知} */
	private java.lang.Integer gender;
	private java.lang.Integer genderNotEq;
	private java.lang.Integer genderGT;
	private java.lang.Integer genderLT;
	
	private java.lang.Integer genderGE;
	private java.lang.Integer genderLE;
	
	private List<java.lang.Integer> genderList;
	private List<java.lang.Integer> genderNotEqList;
	/** mobile */
	private java.lang.String mobile;
	private java.lang.String mobileLike;
	private java.lang.String mobileBeginLike;
	private java.lang.String mobileEndLike;
	/** 登录名 */
	private java.lang.String loginId;
	private java.lang.String loginIdLike;
	private java.lang.String loginIdBeginLike;
	private java.lang.String loginIdEndLike;
	/** 密码 */
	private java.lang.String password;
	private java.lang.String passwordLike;
	private java.lang.String passwordBeginLike;
	private java.lang.String passwordEndLike;
	/** 是否可用{1：可用，0：不可用} */
	private java.lang.Integer isAvailable;
	private java.lang.Integer isAvailableNotEq;
	private java.lang.Integer isAvailableGT;
	private java.lang.Integer isAvailableLT;
	
	private java.lang.Integer isAvailableGE;
	private java.lang.Integer isAvailableLE;
	
	private List<java.lang.Integer> isAvailableList;
	private List<java.lang.Integer> isAvailableNotEqList;
	/** 头像 */
	private java.lang.String headImageUrl;
	private java.lang.String headImageUrlLike;
	private java.lang.String headImageUrlBeginLike;
	private java.lang.String headImageUrlEndLike;
	/** 头像存储地址 */
	private java.lang.String headImageStoragePath;
	private java.lang.String headImageStoragePathLike;
	private java.lang.String headImageStoragePathBeginLike;
	private java.lang.String headImageStoragePathEndLike;
	/** 最后登录时间 */
	private java.util.Date lastAccessBegin;
	private java.util.Date lastAccessEnd;
	/** 创建时间 */
	private java.util.Date createdAtBegin;
	private java.util.Date createdAtEnd;
	/** 最后修改时间 */
	private java.util.Date modifiedBegin;
	private java.util.Date modifiedEnd;
	
	

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
	public java.lang.String getSimpleCode() {
		return this.simpleCode;
	}
	
	public void setSimpleCode(java.lang.String value) {
		this.simpleCode = value;
	}
	public java.lang.String getSimpleCodeLike() {
		return this.simpleCodeLike;
	}
	
	public void setSimpleCodeLike(java.lang.String value) {
		this.simpleCodeLike = value;
	}
	public java.lang.String getSimpleCodeBeginLike() {
		return this.simpleCodeBeginLike;
	}
	
	public void setSimpleCodeBeginLike(java.lang.String value) {
		this.simpleCodeBeginLike = value;
	}
	public java.lang.String getSimpleCodeEndLike() {
		return this.simpleCodeEndLike;
	}
	
	public void setSimpleCodeEndLike(java.lang.String value) {
		this.simpleCodeEndLike = value;
	}
	public java.lang.Long getDepartmentId() {
		return this.departmentId;
	}
	
	public void setDepartmentId(java.lang.Long value) {
		this.departmentId = value;
	}
	public java.lang.Long getDepartmentIdNotEq() {
		return departmentIdNotEq;
	}

	public void setDepartmentIdNotEq(java.lang.Long value) {
		this.departmentIdNotEq = value;
	}
	
	public java.lang.Long getDepartmentIdGT() {
		return departmentIdGT;
	}

	public void setDepartmentIdGT(java.lang.Long value) {
		this.departmentIdGT = value;
	}
	public java.lang.Long getDepartmentIdLT() {
		return departmentIdLT;
	}

	public void setDepartmentIdLT(java.lang.Long value) {
		this.departmentIdLT = value;
	}
	
	public java.lang.Long getDepartmentIdGE() {
		return departmentIdGE;
	}

	public void setDepartmentIdGE(java.lang.Long value) {
		this.departmentIdGE = value;
	}
	public java.lang.Long getDepartmentIdLE() {
		return departmentIdLE;
	}

	public void setDepartmentIdLE(java.lang.Long value) {
		this.departmentIdLE = value;
	}
	
	public List<java.lang.Long> getDepartmentIdList() {
		return this.departmentIdList;
	}
	
	public void setDepartmentIdList(List<java.lang.Long> value) {
		this.departmentIdList = value;
	}
	public List<java.lang.Long> getDepartmentIdNotEqList() {
		return departmentIdNotEqList;
	}

	public void setDepartmentIdNotEqList(List<java.lang.Long> value) {
		this.departmentIdNotEqList = value;
	}
	public java.lang.Integer getGender() {
		return this.gender;
	}
	
	public void setGender(java.lang.Integer value) {
		this.gender = value;
	}
	public java.lang.Integer getGenderNotEq() {
		return genderNotEq;
	}

	public void setGenderNotEq(java.lang.Integer value) {
		this.genderNotEq = value;
	}
	
	public java.lang.Integer getGenderGT() {
		return genderGT;
	}

	public void setGenderGT(java.lang.Integer value) {
		this.genderGT = value;
	}
	public java.lang.Integer getGenderLT() {
		return genderLT;
	}

	public void setGenderLT(java.lang.Integer value) {
		this.genderLT = value;
	}
	
	public java.lang.Integer getGenderGE() {
		return genderGE;
	}

	public void setGenderGE(java.lang.Integer value) {
		this.genderGE = value;
	}
	public java.lang.Integer getGenderLE() {
		return genderLE;
	}

	public void setGenderLE(java.lang.Integer value) {
		this.genderLE = value;
	}
	
	public List<java.lang.Integer> getGenderList() {
		return this.genderList;
	}
	
	public void setGenderList(List<java.lang.Integer> value) {
		this.genderList = value;
	}
	public List<java.lang.Integer> getGenderNotEqList() {
		return genderNotEqList;
	}

	public void setGenderNotEqList(List<java.lang.Integer> value) {
		this.genderNotEqList = value;
	}
	public java.lang.String getMobile() {
		return this.mobile;
	}
	
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	public java.lang.String getMobileLike() {
		return this.mobileLike;
	}
	
	public void setMobileLike(java.lang.String value) {
		this.mobileLike = value;
	}
	public java.lang.String getMobileBeginLike() {
		return this.mobileBeginLike;
	}
	
	public void setMobileBeginLike(java.lang.String value) {
		this.mobileBeginLike = value;
	}
	public java.lang.String getMobileEndLike() {
		return this.mobileEndLike;
	}
	
	public void setMobileEndLike(java.lang.String value) {
		this.mobileEndLike = value;
	}
	public java.lang.String getLoginId() {
		return this.loginId;
	}
	
	public void setLoginId(java.lang.String value) {
		this.loginId = value;
	}
	public java.lang.String getLoginIdLike() {
		return this.loginIdLike;
	}
	
	public void setLoginIdLike(java.lang.String value) {
		this.loginIdLike = value;
	}
	public java.lang.String getLoginIdBeginLike() {
		return this.loginIdBeginLike;
	}
	
	public void setLoginIdBeginLike(java.lang.String value) {
		this.loginIdBeginLike = value;
	}
	public java.lang.String getLoginIdEndLike() {
		return this.loginIdEndLike;
	}
	
	public void setLoginIdEndLike(java.lang.String value) {
		this.loginIdEndLike = value;
	}
	public java.lang.String getPassword() {
		return this.password;
	}
	
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	public java.lang.String getPasswordLike() {
		return this.passwordLike;
	}
	
	public void setPasswordLike(java.lang.String value) {
		this.passwordLike = value;
	}
	public java.lang.String getPasswordBeginLike() {
		return this.passwordBeginLike;
	}
	
	public void setPasswordBeginLike(java.lang.String value) {
		this.passwordBeginLike = value;
	}
	public java.lang.String getPasswordEndLike() {
		return this.passwordEndLike;
	}
	
	public void setPasswordEndLike(java.lang.String value) {
		this.passwordEndLike = value;
	}
	public java.lang.Integer getIsAvailable() {
		return this.isAvailable;
	}
	
	public void setIsAvailable(java.lang.Integer value) {
		this.isAvailable = value;
	}
	public java.lang.Integer getIsAvailableNotEq() {
		return isAvailableNotEq;
	}

	public void setIsAvailableNotEq(java.lang.Integer value) {
		this.isAvailableNotEq = value;
	}
	
	public java.lang.Integer getIsAvailableGT() {
		return isAvailableGT;
	}

	public void setIsAvailableGT(java.lang.Integer value) {
		this.isAvailableGT = value;
	}
	public java.lang.Integer getIsAvailableLT() {
		return isAvailableLT;
	}

	public void setIsAvailableLT(java.lang.Integer value) {
		this.isAvailableLT = value;
	}
	
	public java.lang.Integer getIsAvailableGE() {
		return isAvailableGE;
	}

	public void setIsAvailableGE(java.lang.Integer value) {
		this.isAvailableGE = value;
	}
	public java.lang.Integer getIsAvailableLE() {
		return isAvailableLE;
	}

	public void setIsAvailableLE(java.lang.Integer value) {
		this.isAvailableLE = value;
	}
	
	public List<java.lang.Integer> getIsAvailableList() {
		return this.isAvailableList;
	}
	
	public void setIsAvailableList(List<java.lang.Integer> value) {
		this.isAvailableList = value;
	}
	public List<java.lang.Integer> getIsAvailableNotEqList() {
		return isAvailableNotEqList;
	}

	public void setIsAvailableNotEqList(List<java.lang.Integer> value) {
		this.isAvailableNotEqList = value;
	}
	public java.lang.String getHeadImageUrl() {
		return this.headImageUrl;
	}
	
	public void setHeadImageUrl(java.lang.String value) {
		this.headImageUrl = value;
	}
	public java.lang.String getHeadImageUrlLike() {
		return this.headImageUrlLike;
	}
	
	public void setHeadImageUrlLike(java.lang.String value) {
		this.headImageUrlLike = value;
	}
	public java.lang.String getHeadImageUrlBeginLike() {
		return this.headImageUrlBeginLike;
	}
	
	public void setHeadImageUrlBeginLike(java.lang.String value) {
		this.headImageUrlBeginLike = value;
	}
	public java.lang.String getHeadImageUrlEndLike() {
		return this.headImageUrlEndLike;
	}
	
	public void setHeadImageUrlEndLike(java.lang.String value) {
		this.headImageUrlEndLike = value;
	}
	public java.lang.String getHeadImageStoragePath() {
		return this.headImageStoragePath;
	}
	
	public void setHeadImageStoragePath(java.lang.String value) {
		this.headImageStoragePath = value;
	}
	public java.lang.String getHeadImageStoragePathLike() {
		return this.headImageStoragePathLike;
	}
	
	public void setHeadImageStoragePathLike(java.lang.String value) {
		this.headImageStoragePathLike = value;
	}
	public java.lang.String getHeadImageStoragePathBeginLike() {
		return this.headImageStoragePathBeginLike;
	}
	
	public void setHeadImageStoragePathBeginLike(java.lang.String value) {
		this.headImageStoragePathBeginLike = value;
	}
	public java.lang.String getHeadImageStoragePathEndLike() {
		return this.headImageStoragePathEndLike;
	}
	
	public void setHeadImageStoragePathEndLike(java.lang.String value) {
		this.headImageStoragePathEndLike = value;
	}
	public java.util.Date getLastAccessBegin() {
		return this.lastAccessBegin;
	}
	
	public void setLastAccessBegin(java.util.Date value) {
		this.lastAccessBegin = value;
	}	
	
	public java.util.Date getLastAccessEnd() {
		return this.lastAccessEnd;
	}
	
	public void setLastAccessEnd(java.util.Date value) {
		this.lastAccessEnd = value;
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
	
	public java.util.Date getModifiedBegin() {
		return this.modifiedBegin;
	}
	
	public void setModifiedBegin(java.util.Date value) {
		this.modifiedBegin = value;
	}	
	
	public java.util.Date getModifiedEnd() {
		return this.modifiedEnd;
	}
	
	public void setModifiedEnd(java.util.Date value) {
		this.modifiedEnd = value;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
	private java.lang.String extendsQuery;

	private java.lang.Long orStaffId;
	
	


	public java.lang.Long getOrStaffId() {
		return orStaffId;
	}

	public void setOrStaffId(java.lang.Long orStaffId) {
		this.orStaffId = orStaffId;
	}

	public java.lang.String getExtendsQuery() {
		return extendsQuery;
	}

	public void setExtendsQuery(java.lang.String extendsQuery) {
		this.extendsQuery = extendsQuery;
	}


	

	
	
	
}

