/*
 * Automatically generated
 */

package com.mexp.web.vo.query;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.mexp.core.base.BaseQuery;

public class SettingsQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;

	/** id */
	private java.lang.Long id;
	private java.lang.Long idNotEq;
	private java.lang.Long idGT;
	private java.lang.Long idLT;
	
	private java.lang.Long idGE;
	private java.lang.Long idLE;
	
	private List<java.lang.Long> idList;
	private List<java.lang.Long> idNotEqList;
	/** departmentId */
	private java.lang.Long departmentId;
	private java.lang.Long departmentIdNotEq;
	private java.lang.Long departmentIdGT;
	private java.lang.Long departmentIdLT;
	
	private java.lang.Long departmentIdGE;
	private java.lang.Long departmentIdLE;
	
	private List<java.lang.Long> departmentIdList;
	private List<java.lang.Long> departmentIdNotEqList;
	/** 系统变量名称 */
	private java.lang.String variable;
	private java.lang.String variableLike;
	private java.lang.String variableBeginLike;
	private java.lang.String variableEndLike;
	/** 系统变量值 */
	private java.lang.String val;
	private java.lang.String valLike;
	private java.lang.String valBeginLike;
	private java.lang.String valEndLike;
	/** 描述 */
	private java.lang.String description;
	private java.lang.String descriptionLike;
	private java.lang.String descriptionBeginLike;
	private java.lang.String descriptionEndLike;
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
	public java.lang.String getVariable() {
		return this.variable;
	}
	
	public void setVariable(java.lang.String value) {
		this.variable = value;
	}
	public java.lang.String getVariableLike() {
		return this.variableLike;
	}
	
	public void setVariableLike(java.lang.String value) {
		this.variableLike = value;
	}
	public java.lang.String getVariableBeginLike() {
		return this.variableBeginLike;
	}
	
	public void setVariableBeginLike(java.lang.String value) {
		this.variableBeginLike = value;
	}
	public java.lang.String getVariableEndLike() {
		return this.variableEndLike;
	}
	
	public void setVariableEndLike(java.lang.String value) {
		this.variableEndLike = value;
	}
	public java.lang.String getVal() {
		return this.val;
	}
	
	public void setVal(java.lang.String value) {
		this.val = value;
	}
	public java.lang.String getValLike() {
		return this.valLike;
	}
	
	public void setValLike(java.lang.String value) {
		this.valLike = value;
	}
	public java.lang.String getValBeginLike() {
		return this.valBeginLike;
	}
	
	public void setValBeginLike(java.lang.String value) {
		this.valBeginLike = value;
	}
	public java.lang.String getValEndLike() {
		return this.valEndLike;
	}
	
	public void setValEndLike(java.lang.String value) {
		this.valEndLike = value;
	}
	public java.lang.String getDescription() {
		return this.description;
	}
	
	public void setDescription(java.lang.String value) {
		this.description = value;
	}
	public java.lang.String getDescriptionLike() {
		return this.descriptionLike;
	}
	
	public void setDescriptionLike(java.lang.String value) {
		this.descriptionLike = value;
	}
	public java.lang.String getDescriptionBeginLike() {
		return this.descriptionBeginLike;
	}
	
	public void setDescriptionBeginLike(java.lang.String value) {
		this.descriptionBeginLike = value;
	}
	public java.lang.String getDescriptionEndLike() {
		return this.descriptionEndLike;
	}
	
	public void setDescriptionEndLike(java.lang.String value) {
		this.descriptionEndLike = value;
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

