/*
 * Automatically generated
 */

package com.mexp.web.vo.query;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.mexp.core.base.BaseQuery;

public class DepartmentQuery extends BaseQuery implements Serializable {
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
	/** 名称 */
	private java.lang.String name;
	private java.lang.String nameLike;
	private java.lang.String nameBeginLike;
	private java.lang.String nameEndLike;
	/** 上级编号 */
	private java.lang.Long parentId;
	private java.lang.Long parentIdNotEq;
	private java.lang.Long parentIdGT;
	private java.lang.Long parentIdLT;
	
	private java.lang.Long parentIdGE;
	private java.lang.Long parentIdLE;
	
	private List<java.lang.Long> parentIdList;
	private List<java.lang.Long> parentIdNotEqList;
	/** 简码 */
	private java.lang.String simpleCode;
	private java.lang.String simpleCodeLike;
	private java.lang.String simpleCodeBeginLike;
	private java.lang.String simpleCodeEndLike;
	/** 层级 */
	private java.lang.String level;
	private java.lang.String levelLike;
	private java.lang.String levelBeginLike;
	private java.lang.String levelEndLike;
	/** 描述 */
	private java.lang.String description;
	private java.lang.String descriptionLike;
	private java.lang.String descriptionBeginLike;
	private java.lang.String descriptionEndLike;
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
	public java.lang.Long getParentId() {
		return this.parentId;
	}
	
	public void setParentId(java.lang.Long value) {
		this.parentId = value;
	}
	public java.lang.Long getParentIdNotEq() {
		return parentIdNotEq;
	}

	public void setParentIdNotEq(java.lang.Long value) {
		this.parentIdNotEq = value;
	}
	
	public java.lang.Long getParentIdGT() {
		return parentIdGT;
	}

	public void setParentIdGT(java.lang.Long value) {
		this.parentIdGT = value;
	}
	public java.lang.Long getParentIdLT() {
		return parentIdLT;
	}

	public void setParentIdLT(java.lang.Long value) {
		this.parentIdLT = value;
	}
	
	public java.lang.Long getParentIdGE() {
		return parentIdGE;
	}

	public void setParentIdGE(java.lang.Long value) {
		this.parentIdGE = value;
	}
	public java.lang.Long getParentIdLE() {
		return parentIdLE;
	}

	public void setParentIdLE(java.lang.Long value) {
		this.parentIdLE = value;
	}
	
	public List<java.lang.Long> getParentIdList() {
		return this.parentIdList;
	}
	
	public void setParentIdList(List<java.lang.Long> value) {
		this.parentIdList = value;
	}
	public List<java.lang.Long> getParentIdNotEqList() {
		return parentIdNotEqList;
	}

	public void setParentIdNotEqList(List<java.lang.Long> value) {
		this.parentIdNotEqList = value;
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
	public java.lang.String getLevel() {
		return this.level;
	}
	
	public void setLevel(java.lang.String value) {
		this.level = value;
	}
	public java.lang.String getLevelLike() {
		return this.levelLike;
	}
	
	public void setLevelLike(java.lang.String value) {
		this.levelLike = value;
	}
	public java.lang.String getLevelBeginLike() {
		return this.levelBeginLike;
	}
	
	public void setLevelBeginLike(java.lang.String value) {
		this.levelBeginLike = value;
	}
	public java.lang.String getLevelEndLike() {
		return this.levelEndLike;
	}
	
	public void setLevelEndLike(java.lang.String value) {
		this.levelEndLike = value;
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
	
}

