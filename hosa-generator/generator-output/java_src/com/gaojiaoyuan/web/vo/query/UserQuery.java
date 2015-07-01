/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.vo.query;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import com.gaojiaoyuan.core.base.BaseQuery;
import java.util.List;

public class UserQuery extends BaseQuery implements Serializable {


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
	/** nick */
	private java.lang.String nick;
	private java.lang.String nickLike;
	private java.lang.String nickBeginLike;
	private java.lang.String nickEndLike;
	
	private List<java.lang.String> nickListAnd;
	private List<java.lang.String> nickLikeListAnd;
	private List<java.lang.String> nickBeginLikeListAnd;
	private List<java.lang.String> nickEndLikeListAnd;
	
	private List<java.lang.String> nickListOr;
	private List<java.lang.String> nickLikeListOr;
	private List<java.lang.String> nickBeginLikeListOr;
	private List<java.lang.String> nickEndLikeListOr;
	
	private Boolean nickQueryShow = false;
	/** portraitUrl */
	private java.lang.String portraitUrl;
	private java.lang.String portraitUrlLike;
	private java.lang.String portraitUrlBeginLike;
	private java.lang.String portraitUrlEndLike;
	
	private List<java.lang.String> portraitUrlListAnd;
	private List<java.lang.String> portraitUrlLikeListAnd;
	private List<java.lang.String> portraitUrlBeginLikeListAnd;
	private List<java.lang.String> portraitUrlEndLikeListAnd;
	
	private List<java.lang.String> portraitUrlListOr;
	private List<java.lang.String> portraitUrlLikeListOr;
	private List<java.lang.String> portraitUrlBeginLikeListOr;
	private List<java.lang.String> portraitUrlEndLikeListOr;
	
	private Boolean portraitUrlQueryShow = false;
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
	/** userFollowing */
	private java.lang.Integer userFollowing;
	private java.lang.Integer userFollowingNotEq;
	private java.lang.Integer userFollowingGT;
	private java.lang.Integer userFollowingLT;
	
	private java.lang.Integer userFollowingGE;
	private java.lang.Integer userFollowingLE;
	
	private List<java.lang.Integer> userFollowingList;
	private List<java.lang.Integer> userFollowingNotEqList;
	
	private Boolean userFollowingQueryShow = false;
	/** locationFollowing */
	private java.lang.Integer locationFollowing;
	private java.lang.Integer locationFollowingNotEq;
	private java.lang.Integer locationFollowingGT;
	private java.lang.Integer locationFollowingLT;
	
	private java.lang.Integer locationFollowingGE;
	private java.lang.Integer locationFollowingLE;
	
	private List<java.lang.Integer> locationFollowingList;
	private List<java.lang.Integer> locationFollowingNotEqList;
	
	private Boolean locationFollowingQueryShow = false;
	/** briefDescription */
	private java.lang.String briefDescription;
	private java.lang.String briefDescriptionLike;
	private java.lang.String briefDescriptionBeginLike;
	private java.lang.String briefDescriptionEndLike;
	
	private List<java.lang.String> briefDescriptionListAnd;
	private List<java.lang.String> briefDescriptionLikeListAnd;
	private List<java.lang.String> briefDescriptionBeginLikeListAnd;
	private List<java.lang.String> briefDescriptionEndLikeListAnd;
	
	private List<java.lang.String> briefDescriptionListOr;
	private List<java.lang.String> briefDescriptionLikeListOr;
	private List<java.lang.String> briefDescriptionBeginLikeListOr;
	private List<java.lang.String> briefDescriptionEndLikeListOr;
	
	private Boolean briefDescriptionQueryShow = false;
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
	/** praisingCnt */
	private java.lang.Integer praisingCnt;
	private java.lang.Integer praisingCntNotEq;
	private java.lang.Integer praisingCntGT;
	private java.lang.Integer praisingCntLT;
	
	private java.lang.Integer praisingCntGE;
	private java.lang.Integer praisingCntLE;
	
	private List<java.lang.Integer> praisingCntList;
	private List<java.lang.Integer> praisingCntNotEqList;
	
	private Boolean praisingCntQueryShow = false;
	/** praisedCnt */
	private java.lang.Integer praisedCnt;
	private java.lang.Integer praisedCntNotEq;
	private java.lang.Integer praisedCntGT;
	private java.lang.Integer praisedCntLT;
	
	private java.lang.Integer praisedCntGE;
	private java.lang.Integer praisedCntLE;
	
	private List<java.lang.Integer> praisedCntList;
	private List<java.lang.Integer> praisedCntNotEqList;
	
	private Boolean praisedCntQueryShow = false;
	/** notifiyCnt */
	private java.lang.Integer notifiyCnt;
	private java.lang.Integer notifiyCntNotEq;
	private java.lang.Integer notifiyCntGT;
	private java.lang.Integer notifiyCntLT;
	
	private java.lang.Integer notifiyCntGE;
	private java.lang.Integer notifiyCntLE;
	
	private List<java.lang.Integer> notifiyCntList;
	private List<java.lang.Integer> notifiyCntNotEqList;
	
	private Boolean notifiyCntQueryShow = false;
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
	public java.lang.String getNick() {
		return this.nick;
	}
	
	public void setNick(java.lang.String value) {
		this.nick = value;
	}
	public java.lang.String getNickLike() {
		return this.nickLike;
	}
	
	public void setNickLike(java.lang.String value) {
		this.nickLike = value;
	}
	public java.lang.String getNickBeginLike() {
		return this.nickBeginLike;
	}
	
	public void setNickBeginLike(java.lang.String value) {
		this.nickBeginLike = value;
	}
	public java.lang.String getNickEndLike() {
		return this.nickEndLike;
	}
	
	public void setNickEndLike(java.lang.String value) {
		this.nickEndLike = value;
	}

	public List<java.lang.String> getNickListAnd() {
		return this.nickListAnd;
	}
	
	public void setNickListAnd(List<java.lang.String> value) {
		this.nickListAnd = value;
	}
	public List<java.lang.String> getNickLikeListAnd() {
		return this.nickLikeListAnd;
	}
	
	public void setNickLikeListAnd(List<java.lang.String> value) {
		this.nickLikeListAnd = value;
	}
	public List<java.lang.String> getNickBeginLikeListAnd() {
		return this.nickBeginLikeListAnd;
	}
	
	public void setNickBeginLikeListAnd(List<java.lang.String> value) {
		this.nickBeginLikeListAnd = value;
	}
	public List<java.lang.String> getNickEndLikeListAnd() {
		return this.nickEndLikeListAnd;
	}
	
	public void setNickEndLikeListAnd(List<java.lang.String> value) {
		this.nickEndLikeListAnd = value;
	}
	
	public List<java.lang.String> getNickListOr() {
		return this.nickListOr;
	}
	
	public void setNickListOr(List<java.lang.String> value) {
		this.nickListOr = value;
	}
	public List<java.lang.String> getNickLikeListOr() {
		return this.nickLikeListOr;
	}
	
	public void setNickLikeListOr(List<java.lang.String> value) {
		this.nickLikeListOr = value;
	}
	public List<java.lang.String> getNickBeginLikeListOr() {
		return this.nickBeginLikeListOr;
	}
	
	public void setNickBeginLikeListOr(List<java.lang.String> value) {
		this.nickBeginLikeListOr = value;
	}
	public List<java.lang.String> getNickEndLikeListOr() {
		return this.nickEndLikeListOr;
	}
	
	public void setNickEndLikeListOr(List<java.lang.String> value) {
		this.nickEndLikeListOr = value;
	}
	
	public Boolean getNickQueryShow() {
		return nickQueryShow;
	}

	public void setNickQueryShow(Boolean value) {
		this.nickQueryShow = value;
	}
	public java.lang.String getPortraitUrl() {
		return this.portraitUrl;
	}
	
	public void setPortraitUrl(java.lang.String value) {
		this.portraitUrl = value;
	}
	public java.lang.String getPortraitUrlLike() {
		return this.portraitUrlLike;
	}
	
	public void setPortraitUrlLike(java.lang.String value) {
		this.portraitUrlLike = value;
	}
	public java.lang.String getPortraitUrlBeginLike() {
		return this.portraitUrlBeginLike;
	}
	
	public void setPortraitUrlBeginLike(java.lang.String value) {
		this.portraitUrlBeginLike = value;
	}
	public java.lang.String getPortraitUrlEndLike() {
		return this.portraitUrlEndLike;
	}
	
	public void setPortraitUrlEndLike(java.lang.String value) {
		this.portraitUrlEndLike = value;
	}

	public List<java.lang.String> getPortraitUrlListAnd() {
		return this.portraitUrlListAnd;
	}
	
	public void setPortraitUrlListAnd(List<java.lang.String> value) {
		this.portraitUrlListAnd = value;
	}
	public List<java.lang.String> getPortraitUrlLikeListAnd() {
		return this.portraitUrlLikeListAnd;
	}
	
	public void setPortraitUrlLikeListAnd(List<java.lang.String> value) {
		this.portraitUrlLikeListAnd = value;
	}
	public List<java.lang.String> getPortraitUrlBeginLikeListAnd() {
		return this.portraitUrlBeginLikeListAnd;
	}
	
	public void setPortraitUrlBeginLikeListAnd(List<java.lang.String> value) {
		this.portraitUrlBeginLikeListAnd = value;
	}
	public List<java.lang.String> getPortraitUrlEndLikeListAnd() {
		return this.portraitUrlEndLikeListAnd;
	}
	
	public void setPortraitUrlEndLikeListAnd(List<java.lang.String> value) {
		this.portraitUrlEndLikeListAnd = value;
	}
	
	public List<java.lang.String> getPortraitUrlListOr() {
		return this.portraitUrlListOr;
	}
	
	public void setPortraitUrlListOr(List<java.lang.String> value) {
		this.portraitUrlListOr = value;
	}
	public List<java.lang.String> getPortraitUrlLikeListOr() {
		return this.portraitUrlLikeListOr;
	}
	
	public void setPortraitUrlLikeListOr(List<java.lang.String> value) {
		this.portraitUrlLikeListOr = value;
	}
	public List<java.lang.String> getPortraitUrlBeginLikeListOr() {
		return this.portraitUrlBeginLikeListOr;
	}
	
	public void setPortraitUrlBeginLikeListOr(List<java.lang.String> value) {
		this.portraitUrlBeginLikeListOr = value;
	}
	public List<java.lang.String> getPortraitUrlEndLikeListOr() {
		return this.portraitUrlEndLikeListOr;
	}
	
	public void setPortraitUrlEndLikeListOr(List<java.lang.String> value) {
		this.portraitUrlEndLikeListOr = value;
	}
	
	public Boolean getPortraitUrlQueryShow() {
		return portraitUrlQueryShow;
	}

	public void setPortraitUrlQueryShow(Boolean value) {
		this.portraitUrlQueryShow = value;
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
	public java.lang.Integer getUserFollowing() {
		return this.userFollowing;
	}
	
	public void setUserFollowing(java.lang.Integer value) {
		this.userFollowing = value;
	}
	public java.lang.Integer getUserFollowingNotEq() {
		return userFollowingNotEq;
	}

	public void setUserFollowingNotEq(java.lang.Integer value) {
		this.userFollowingNotEq = value;
	}
	
	public java.lang.Integer getUserFollowingGT() {
		return userFollowingGT;
	}

	public void setUserFollowingGT(java.lang.Integer value) {
		this.userFollowingGT = value;
	}
	public java.lang.Integer getUserFollowingLT() {
		return userFollowingLT;
	}

	public void setUserFollowingLT(java.lang.Integer value) {
		this.userFollowingLT = value;
	}
	
	public java.lang.Integer getUserFollowingGE() {
		return userFollowingGE;
	}

	public void setUserFollowingGE(java.lang.Integer value) {
		this.userFollowingGE = value;
	}
	public java.lang.Integer getUserFollowingLE() {
		return userFollowingLE;
	}

	public void setUserFollowingLE(java.lang.Integer value) {
		this.userFollowingLE = value;
	}
	
	public List<java.lang.Integer> getUserFollowingList() {
		return this.userFollowingList;
	}
	
	public void setUserFollowingList(List<java.lang.Integer> value) {
		this.userFollowingList = value;
	}
	public List<java.lang.Integer> getUserFollowingNotEqList() {
		return userFollowingNotEqList;
	}

	public void setUserFollowingNotEqList(List<java.lang.Integer> value) {
		this.userFollowingNotEqList = value;
	}

	
	public Boolean getUserFollowingQueryShow() {
		return userFollowingQueryShow;
	}

	public void setUserFollowingQueryShow(Boolean value) {
		this.userFollowingQueryShow = value;
	}
	public java.lang.Integer getLocationFollowing() {
		return this.locationFollowing;
	}
	
	public void setLocationFollowing(java.lang.Integer value) {
		this.locationFollowing = value;
	}
	public java.lang.Integer getLocationFollowingNotEq() {
		return locationFollowingNotEq;
	}

	public void setLocationFollowingNotEq(java.lang.Integer value) {
		this.locationFollowingNotEq = value;
	}
	
	public java.lang.Integer getLocationFollowingGT() {
		return locationFollowingGT;
	}

	public void setLocationFollowingGT(java.lang.Integer value) {
		this.locationFollowingGT = value;
	}
	public java.lang.Integer getLocationFollowingLT() {
		return locationFollowingLT;
	}

	public void setLocationFollowingLT(java.lang.Integer value) {
		this.locationFollowingLT = value;
	}
	
	public java.lang.Integer getLocationFollowingGE() {
		return locationFollowingGE;
	}

	public void setLocationFollowingGE(java.lang.Integer value) {
		this.locationFollowingGE = value;
	}
	public java.lang.Integer getLocationFollowingLE() {
		return locationFollowingLE;
	}

	public void setLocationFollowingLE(java.lang.Integer value) {
		this.locationFollowingLE = value;
	}
	
	public List<java.lang.Integer> getLocationFollowingList() {
		return this.locationFollowingList;
	}
	
	public void setLocationFollowingList(List<java.lang.Integer> value) {
		this.locationFollowingList = value;
	}
	public List<java.lang.Integer> getLocationFollowingNotEqList() {
		return locationFollowingNotEqList;
	}

	public void setLocationFollowingNotEqList(List<java.lang.Integer> value) {
		this.locationFollowingNotEqList = value;
	}

	
	public Boolean getLocationFollowingQueryShow() {
		return locationFollowingQueryShow;
	}

	public void setLocationFollowingQueryShow(Boolean value) {
		this.locationFollowingQueryShow = value;
	}
	public java.lang.String getBriefDescription() {
		return this.briefDescription;
	}
	
	public void setBriefDescription(java.lang.String value) {
		this.briefDescription = value;
	}
	public java.lang.String getBriefDescriptionLike() {
		return this.briefDescriptionLike;
	}
	
	public void setBriefDescriptionLike(java.lang.String value) {
		this.briefDescriptionLike = value;
	}
	public java.lang.String getBriefDescriptionBeginLike() {
		return this.briefDescriptionBeginLike;
	}
	
	public void setBriefDescriptionBeginLike(java.lang.String value) {
		this.briefDescriptionBeginLike = value;
	}
	public java.lang.String getBriefDescriptionEndLike() {
		return this.briefDescriptionEndLike;
	}
	
	public void setBriefDescriptionEndLike(java.lang.String value) {
		this.briefDescriptionEndLike = value;
	}

	public List<java.lang.String> getBriefDescriptionListAnd() {
		return this.briefDescriptionListAnd;
	}
	
	public void setBriefDescriptionListAnd(List<java.lang.String> value) {
		this.briefDescriptionListAnd = value;
	}
	public List<java.lang.String> getBriefDescriptionLikeListAnd() {
		return this.briefDescriptionLikeListAnd;
	}
	
	public void setBriefDescriptionLikeListAnd(List<java.lang.String> value) {
		this.briefDescriptionLikeListAnd = value;
	}
	public List<java.lang.String> getBriefDescriptionBeginLikeListAnd() {
		return this.briefDescriptionBeginLikeListAnd;
	}
	
	public void setBriefDescriptionBeginLikeListAnd(List<java.lang.String> value) {
		this.briefDescriptionBeginLikeListAnd = value;
	}
	public List<java.lang.String> getBriefDescriptionEndLikeListAnd() {
		return this.briefDescriptionEndLikeListAnd;
	}
	
	public void setBriefDescriptionEndLikeListAnd(List<java.lang.String> value) {
		this.briefDescriptionEndLikeListAnd = value;
	}
	
	public List<java.lang.String> getBriefDescriptionListOr() {
		return this.briefDescriptionListOr;
	}
	
	public void setBriefDescriptionListOr(List<java.lang.String> value) {
		this.briefDescriptionListOr = value;
	}
	public List<java.lang.String> getBriefDescriptionLikeListOr() {
		return this.briefDescriptionLikeListOr;
	}
	
	public void setBriefDescriptionLikeListOr(List<java.lang.String> value) {
		this.briefDescriptionLikeListOr = value;
	}
	public List<java.lang.String> getBriefDescriptionBeginLikeListOr() {
		return this.briefDescriptionBeginLikeListOr;
	}
	
	public void setBriefDescriptionBeginLikeListOr(List<java.lang.String> value) {
		this.briefDescriptionBeginLikeListOr = value;
	}
	public List<java.lang.String> getBriefDescriptionEndLikeListOr() {
		return this.briefDescriptionEndLikeListOr;
	}
	
	public void setBriefDescriptionEndLikeListOr(List<java.lang.String> value) {
		this.briefDescriptionEndLikeListOr = value;
	}
	
	public Boolean getBriefDescriptionQueryShow() {
		return briefDescriptionQueryShow;
	}

	public void setBriefDescriptionQueryShow(Boolean value) {
		this.briefDescriptionQueryShow = value;
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
	public java.lang.Integer getPraisingCnt() {
		return this.praisingCnt;
	}
	
	public void setPraisingCnt(java.lang.Integer value) {
		this.praisingCnt = value;
	}
	public java.lang.Integer getPraisingCntNotEq() {
		return praisingCntNotEq;
	}

	public void setPraisingCntNotEq(java.lang.Integer value) {
		this.praisingCntNotEq = value;
	}
	
	public java.lang.Integer getPraisingCntGT() {
		return praisingCntGT;
	}

	public void setPraisingCntGT(java.lang.Integer value) {
		this.praisingCntGT = value;
	}
	public java.lang.Integer getPraisingCntLT() {
		return praisingCntLT;
	}

	public void setPraisingCntLT(java.lang.Integer value) {
		this.praisingCntLT = value;
	}
	
	public java.lang.Integer getPraisingCntGE() {
		return praisingCntGE;
	}

	public void setPraisingCntGE(java.lang.Integer value) {
		this.praisingCntGE = value;
	}
	public java.lang.Integer getPraisingCntLE() {
		return praisingCntLE;
	}

	public void setPraisingCntLE(java.lang.Integer value) {
		this.praisingCntLE = value;
	}
	
	public List<java.lang.Integer> getPraisingCntList() {
		return this.praisingCntList;
	}
	
	public void setPraisingCntList(List<java.lang.Integer> value) {
		this.praisingCntList = value;
	}
	public List<java.lang.Integer> getPraisingCntNotEqList() {
		return praisingCntNotEqList;
	}

	public void setPraisingCntNotEqList(List<java.lang.Integer> value) {
		this.praisingCntNotEqList = value;
	}

	
	public Boolean getPraisingCntQueryShow() {
		return praisingCntQueryShow;
	}

	public void setPraisingCntQueryShow(Boolean value) {
		this.praisingCntQueryShow = value;
	}
	public java.lang.Integer getPraisedCnt() {
		return this.praisedCnt;
	}
	
	public void setPraisedCnt(java.lang.Integer value) {
		this.praisedCnt = value;
	}
	public java.lang.Integer getPraisedCntNotEq() {
		return praisedCntNotEq;
	}

	public void setPraisedCntNotEq(java.lang.Integer value) {
		this.praisedCntNotEq = value;
	}
	
	public java.lang.Integer getPraisedCntGT() {
		return praisedCntGT;
	}

	public void setPraisedCntGT(java.lang.Integer value) {
		this.praisedCntGT = value;
	}
	public java.lang.Integer getPraisedCntLT() {
		return praisedCntLT;
	}

	public void setPraisedCntLT(java.lang.Integer value) {
		this.praisedCntLT = value;
	}
	
	public java.lang.Integer getPraisedCntGE() {
		return praisedCntGE;
	}

	public void setPraisedCntGE(java.lang.Integer value) {
		this.praisedCntGE = value;
	}
	public java.lang.Integer getPraisedCntLE() {
		return praisedCntLE;
	}

	public void setPraisedCntLE(java.lang.Integer value) {
		this.praisedCntLE = value;
	}
	
	public List<java.lang.Integer> getPraisedCntList() {
		return this.praisedCntList;
	}
	
	public void setPraisedCntList(List<java.lang.Integer> value) {
		this.praisedCntList = value;
	}
	public List<java.lang.Integer> getPraisedCntNotEqList() {
		return praisedCntNotEqList;
	}

	public void setPraisedCntNotEqList(List<java.lang.Integer> value) {
		this.praisedCntNotEqList = value;
	}

	
	public Boolean getPraisedCntQueryShow() {
		return praisedCntQueryShow;
	}

	public void setPraisedCntQueryShow(Boolean value) {
		this.praisedCntQueryShow = value;
	}
	public java.lang.Integer getNotifiyCnt() {
		return this.notifiyCnt;
	}
	
	public void setNotifiyCnt(java.lang.Integer value) {
		this.notifiyCnt = value;
	}
	public java.lang.Integer getNotifiyCntNotEq() {
		return notifiyCntNotEq;
	}

	public void setNotifiyCntNotEq(java.lang.Integer value) {
		this.notifiyCntNotEq = value;
	}
	
	public java.lang.Integer getNotifiyCntGT() {
		return notifiyCntGT;
	}

	public void setNotifiyCntGT(java.lang.Integer value) {
		this.notifiyCntGT = value;
	}
	public java.lang.Integer getNotifiyCntLT() {
		return notifiyCntLT;
	}

	public void setNotifiyCntLT(java.lang.Integer value) {
		this.notifiyCntLT = value;
	}
	
	public java.lang.Integer getNotifiyCntGE() {
		return notifiyCntGE;
	}

	public void setNotifiyCntGE(java.lang.Integer value) {
		this.notifiyCntGE = value;
	}
	public java.lang.Integer getNotifiyCntLE() {
		return notifiyCntLE;
	}

	public void setNotifiyCntLE(java.lang.Integer value) {
		this.notifiyCntLE = value;
	}
	
	public List<java.lang.Integer> getNotifiyCntList() {
		return this.notifiyCntList;
	}
	
	public void setNotifiyCntList(List<java.lang.Integer> value) {
		this.notifiyCntList = value;
	}
	public List<java.lang.Integer> getNotifiyCntNotEqList() {
		return notifiyCntNotEqList;
	}

	public void setNotifiyCntNotEqList(List<java.lang.Integer> value) {
		this.notifiyCntNotEqList = value;
	}

	
	public Boolean getNotifiyCntQueryShow() {
		return notifiyCntQueryShow;
	}

	public void setNotifiyCntQueryShow(Boolean value) {
		this.notifiyCntQueryShow = value;
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

