/*
 * Automatically generated
 */

package com.hosa.web.vo.query;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hosa.core.base.BaseQuery;

public class AuthorityQuery extends BaseQuery implements Serializable {
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
	/** 权限名称 */
	private java.lang.String name;
	private java.lang.String nameLike;
	private java.lang.String nameBeginLike;
	private java.lang.String nameEndLike;
	/** 权限标识 */
	private java.lang.String mark;
	private java.lang.String markLike;
	private java.lang.String markBeginLike;
	private java.lang.String markEndLike;
	/** 权限链 */
	private java.lang.String chain;
	private java.lang.String chainLike;
	private java.lang.String chainBeginLike;
	private java.lang.String chainEndLike;
	/** 排序 */
	private java.lang.Integer sort;
	private java.lang.Integer sortNotEq;
	private java.lang.Integer sortGT;
	private java.lang.Integer sortLT;
	
	private java.lang.Integer sortGE;
	private java.lang.Integer sortLE;
	
	private List<java.lang.Integer> sortList;
	private List<java.lang.Integer> sortNotEqList;
	/** 级别 */
	private java.lang.Integer level;
	private java.lang.Integer levelNotEq;
	private java.lang.Integer levelGT;
	private java.lang.Integer levelLT;
	
	private java.lang.Integer levelGE;
	private java.lang.Integer levelLE;
	
	private List<java.lang.Integer> levelList;
	private List<java.lang.Integer> levelNotEqList;
	/** 自定义{1：自定义，0：默认} */
	private java.lang.Integer custom;
	private java.lang.Integer customNotEq;
	private java.lang.Integer customGT;
	private java.lang.Integer customLT;
	
	private java.lang.Integer customGE;
	private java.lang.Integer customLE;
	
	private List<java.lang.Integer> customList;
	private List<java.lang.Integer> customNotEqList;
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
	public java.lang.String getMark() {
		return this.mark;
	}
	
	public void setMark(java.lang.String value) {
		this.mark = value;
	}
	public java.lang.String getMarkLike() {
		return this.markLike;
	}
	
	public void setMarkLike(java.lang.String value) {
		this.markLike = value;
	}
	public java.lang.String getMarkBeginLike() {
		return this.markBeginLike;
	}
	
	public void setMarkBeginLike(java.lang.String value) {
		this.markBeginLike = value;
	}
	public java.lang.String getMarkEndLike() {
		return this.markEndLike;
	}
	
	public void setMarkEndLike(java.lang.String value) {
		this.markEndLike = value;
	}
	public java.lang.String getChain() {
		return this.chain;
	}
	
	public void setChain(java.lang.String value) {
		this.chain = value;
	}
	public java.lang.String getChainLike() {
		return this.chainLike;
	}
	
	public void setChainLike(java.lang.String value) {
		this.chainLike = value;
	}
	public java.lang.String getChainBeginLike() {
		return this.chainBeginLike;
	}
	
	public void setChainBeginLike(java.lang.String value) {
		this.chainBeginLike = value;
	}
	public java.lang.String getChainEndLike() {
		return this.chainEndLike;
	}
	
	public void setChainEndLike(java.lang.String value) {
		this.chainEndLike = value;
	}
	public java.lang.Integer getSort() {
		return this.sort;
	}
	
	public void setSort(java.lang.Integer value) {
		this.sort = value;
	}
	public java.lang.Integer getSortNotEq() {
		return sortNotEq;
	}

	public void setSortNotEq(java.lang.Integer value) {
		this.sortNotEq = value;
	}
	
	public java.lang.Integer getSortGT() {
		return sortGT;
	}

	public void setSortGT(java.lang.Integer value) {
		this.sortGT = value;
	}
	public java.lang.Integer getSortLT() {
		return sortLT;
	}

	public void setSortLT(java.lang.Integer value) {
		this.sortLT = value;
	}
	
	public java.lang.Integer getSortGE() {
		return sortGE;
	}

	public void setSortGE(java.lang.Integer value) {
		this.sortGE = value;
	}
	public java.lang.Integer getSortLE() {
		return sortLE;
	}

	public void setSortLE(java.lang.Integer value) {
		this.sortLE = value;
	}
	
	public List<java.lang.Integer> getSortList() {
		return this.sortList;
	}
	
	public void setSortList(List<java.lang.Integer> value) {
		this.sortList = value;
	}
	public List<java.lang.Integer> getSortNotEqList() {
		return sortNotEqList;
	}

	public void setSortNotEqList(List<java.lang.Integer> value) {
		this.sortNotEqList = value;
	}
	public java.lang.Integer getLevel() {
		return this.level;
	}
	
	public void setLevel(java.lang.Integer value) {
		this.level = value;
	}
	public java.lang.Integer getLevelNotEq() {
		return levelNotEq;
	}

	public void setLevelNotEq(java.lang.Integer value) {
		this.levelNotEq = value;
	}
	
	public java.lang.Integer getLevelGT() {
		return levelGT;
	}

	public void setLevelGT(java.lang.Integer value) {
		this.levelGT = value;
	}
	public java.lang.Integer getLevelLT() {
		return levelLT;
	}

	public void setLevelLT(java.lang.Integer value) {
		this.levelLT = value;
	}
	
	public java.lang.Integer getLevelGE() {
		return levelGE;
	}

	public void setLevelGE(java.lang.Integer value) {
		this.levelGE = value;
	}
	public java.lang.Integer getLevelLE() {
		return levelLE;
	}

	public void setLevelLE(java.lang.Integer value) {
		this.levelLE = value;
	}
	
	public List<java.lang.Integer> getLevelList() {
		return this.levelList;
	}
	
	public void setLevelList(List<java.lang.Integer> value) {
		this.levelList = value;
	}
	public List<java.lang.Integer> getLevelNotEqList() {
		return levelNotEqList;
	}

	public void setLevelNotEqList(List<java.lang.Integer> value) {
		this.levelNotEqList = value;
	}
	public java.lang.Integer getCustom() {
		return this.custom;
	}
	
	public void setCustom(java.lang.Integer value) {
		this.custom = value;
	}
	public java.lang.Integer getCustomNotEq() {
		return customNotEq;
	}

	public void setCustomNotEq(java.lang.Integer value) {
		this.customNotEq = value;
	}
	
	public java.lang.Integer getCustomGT() {
		return customGT;
	}

	public void setCustomGT(java.lang.Integer value) {
		this.customGT = value;
	}
	public java.lang.Integer getCustomLT() {
		return customLT;
	}

	public void setCustomLT(java.lang.Integer value) {
		this.customLT = value;
	}
	
	public java.lang.Integer getCustomGE() {
		return customGE;
	}

	public void setCustomGE(java.lang.Integer value) {
		this.customGE = value;
	}
	public java.lang.Integer getCustomLE() {
		return customLE;
	}

	public void setCustomLE(java.lang.Integer value) {
		this.customLE = value;
	}
	
	public List<java.lang.Integer> getCustomList() {
		return this.customList;
	}
	
	public void setCustomList(List<java.lang.Integer> value) {
		this.customList = value;
	}
	public List<java.lang.Integer> getCustomNotEqList() {
		return customNotEqList;
	}

	public void setCustomNotEqList(List<java.lang.Integer> value) {
		this.customNotEqList = value;
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

