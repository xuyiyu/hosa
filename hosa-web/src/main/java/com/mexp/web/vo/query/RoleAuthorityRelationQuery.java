/*
 * Automatically generated
 */

package com.mexp.web.vo.query;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.mexp.core.base.BaseQuery;

public class RoleAuthorityRelationQuery extends BaseQuery implements Serializable {
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
	/** 角色编号 */
	private java.lang.Long roleId;
	private java.lang.Long roleIdNotEq;
	private java.lang.Long roleIdGT;
	private java.lang.Long roleIdLT;
	
	private java.lang.Long roleIdGE;
	private java.lang.Long roleIdLE;
	
	private List<java.lang.Long> roleIdList;
	private List<java.lang.Long> roleIdNotEqList;
	/** 权限编号 */
	private java.lang.Long authorityId;
	private java.lang.Long authorityIdNotEq;
	private java.lang.Long authorityIdGT;
	private java.lang.Long authorityIdLT;
	
	private java.lang.Long authorityIdGE;
	private java.lang.Long authorityIdLE;
	
	private List<java.lang.Long> authorityIdList;
	private List<java.lang.Long> authorityIdNotEqList;
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
	public java.lang.Long getRoleId() {
		return this.roleId;
	}
	
	public void setRoleId(java.lang.Long value) {
		this.roleId = value;
	}
	public java.lang.Long getRoleIdNotEq() {
		return roleIdNotEq;
	}

	public void setRoleIdNotEq(java.lang.Long value) {
		this.roleIdNotEq = value;
	}
	
	public java.lang.Long getRoleIdGT() {
		return roleIdGT;
	}

	public void setRoleIdGT(java.lang.Long value) {
		this.roleIdGT = value;
	}
	public java.lang.Long getRoleIdLT() {
		return roleIdLT;
	}

	public void setRoleIdLT(java.lang.Long value) {
		this.roleIdLT = value;
	}
	
	public java.lang.Long getRoleIdGE() {
		return roleIdGE;
	}

	public void setRoleIdGE(java.lang.Long value) {
		this.roleIdGE = value;
	}
	public java.lang.Long getRoleIdLE() {
		return roleIdLE;
	}

	public void setRoleIdLE(java.lang.Long value) {
		this.roleIdLE = value;
	}
	
	public List<java.lang.Long> getRoleIdList() {
		return this.roleIdList;
	}
	
	public void setRoleIdList(List<java.lang.Long> value) {
		this.roleIdList = value;
	}
	public List<java.lang.Long> getRoleIdNotEqList() {
		return roleIdNotEqList;
	}

	public void setRoleIdNotEqList(List<java.lang.Long> value) {
		this.roleIdNotEqList = value;
	}
	public java.lang.Long getAuthorityId() {
		return this.authorityId;
	}
	
	public void setAuthorityId(java.lang.Long value) {
		this.authorityId = value;
	}
	public java.lang.Long getAuthorityIdNotEq() {
		return authorityIdNotEq;
	}

	public void setAuthorityIdNotEq(java.lang.Long value) {
		this.authorityIdNotEq = value;
	}
	
	public java.lang.Long getAuthorityIdGT() {
		return authorityIdGT;
	}

	public void setAuthorityIdGT(java.lang.Long value) {
		this.authorityIdGT = value;
	}
	public java.lang.Long getAuthorityIdLT() {
		return authorityIdLT;
	}

	public void setAuthorityIdLT(java.lang.Long value) {
		this.authorityIdLT = value;
	}
	
	public java.lang.Long getAuthorityIdGE() {
		return authorityIdGE;
	}

	public void setAuthorityIdGE(java.lang.Long value) {
		this.authorityIdGE = value;
	}
	public java.lang.Long getAuthorityIdLE() {
		return authorityIdLE;
	}

	public void setAuthorityIdLE(java.lang.Long value) {
		this.authorityIdLE = value;
	}
	
	public List<java.lang.Long> getAuthorityIdList() {
		return this.authorityIdList;
	}
	
	public void setAuthorityIdList(List<java.lang.Long> value) {
		this.authorityIdList = value;
	}
	public List<java.lang.Long> getAuthorityIdNotEqList() {
		return authorityIdNotEqList;
	}

	public void setAuthorityIdNotEqList(List<java.lang.Long> value) {
		this.authorityIdNotEqList = value;
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
	
}

