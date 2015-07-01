/*
 * Automatically generated
 */

package com.mexp.web.vo.query;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.mexp.core.base.BaseQuery;

public class DepartmentRoleRelationQuery extends BaseQuery implements Serializable {
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
	/** 组编号 */
	private java.lang.Long departmentId;
	private java.lang.Long departmentIdNotEq;
	private java.lang.Long departmentIdGT;
	private java.lang.Long departmentIdLT;
	
	private java.lang.Long departmentIdGE;
	private java.lang.Long departmentIdLE;
	
	private List<java.lang.Long> departmentIdList;
	private List<java.lang.Long> departmentIdNotEqList;
	/** 角色编号 */
	private java.lang.Long roleId;
	private java.lang.Long roleIdNotEq;
	private java.lang.Long roleIdGT;
	private java.lang.Long roleIdLT;
	
	private java.lang.Long roleIdGE;
	private java.lang.Long roleIdLE;
	
	private List<java.lang.Long> roleIdList;
	private List<java.lang.Long> roleIdNotEqList;
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

