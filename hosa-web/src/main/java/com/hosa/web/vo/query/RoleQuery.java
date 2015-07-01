/*
 * Automatically generated
 */

package com.hosa.web.vo.query;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hosa.core.base.BaseQuery;

public class RoleQuery extends BaseQuery implements Serializable {
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

