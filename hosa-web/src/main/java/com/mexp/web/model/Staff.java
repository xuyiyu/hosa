/*
 * Automatically generated
 */

package com.mexp.web.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.mexp.core.base.BaseEntity;
import com.mexp.core.utils.DateConvertUtils;

public class Staff extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "员工表";
	public static final String ALIAS_ID = "编号";
	public static final String ALIAS_NAME = "姓名";
	public static final String ALIAS_SIMPLE_CODE = "简码";
	public static final String ALIAS_DEPARTMENT_ID = "用户组";
	public static final String ALIAS_GENDER = "性别{1：男，2：女，0：未知}";
	public static final String ALIAS_MOBILE = "mobile";
	public static final String ALIAS_LOGIN_ID = "登录名";
	public static final String ALIAS_PASSWORD = "密码";
	public static final String ALIAS_IS_AVAILABLE = "是否可用{1：可用，0：不可用}";
	public static final String ALIAS_HEAD_IMAGE_URL = "头像";
	public static final String ALIAS_HEAD_IMAGE_STORAGE_PATH = "头像存储地址";
	public static final String ALIAS_LAST_ACCESS = "最后登录时间";
	public static final String ALIAS_CREATED_AT = "创建时间";
	public static final String ALIAS_MODIFIED = "最后修改时间";
	
	//date formats
	public static final String FORMAT_LAST_ACCESS = DATE_FORMAT;
	public static final String FORMAT_CREATED_AT = DATE_FORMAT;
	
	public static final String FORMAT_MODIFIED = TIMESTAMP_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 编号       db_column: id 
     */	
	
	private java.lang.Long id;
    /**
     * 姓名       db_column: name 
     */	
	
	private java.lang.String name;
    /**
     * 简码       db_column: simple_code 
     */	
	
	private java.lang.String simpleCode;
    /**
     * 用户组       db_column: department_id 
     */	
	
	private java.lang.Long departmentId;
    /**
     * 性别{1：男，2：女，0：未知}       db_column: gender 
     */	
	
	private java.lang.Integer gender;
    /**
     * mobile       db_column: mobile 
     */	
	
	private java.lang.String mobile;
    /**
     * 登录名       db_column: login_id 
     */	
	
	private java.lang.String loginId;
    /**
     * 密码       db_column: password 
     */	
	
	private java.lang.String password;
    /**
     * 是否可用{1：可用，0：不可用}       db_column: is_available 
     */	
	
	private java.lang.Integer isAvailable;
    /**
     * 头像       db_column: head_image_url 
     */	
	
	private java.lang.String headImageUrl;
    /**
     * 头像存储地址       db_column: head_image_storage_path 
     */	
	
	private java.lang.String headImageStoragePath;
    /**
     * 最后登录时间       db_column: last_access 
     */	
	
	private java.util.Date lastAccess;
    /**
     * 创建时间       db_column: created_at 
     */	
	
	private java.util.Date createdAt;
    /**
     * 最后修改时间       db_column: modified 
     */	
	
	private java.util.Date modified;
	//columns END

	
	

	public Staff(){
	}

	public Staff(
		java.lang.Long id
	){
		this.id = id;
	}

	public void setId(java.lang.Long value) {
		this.id = value;
	}
	
	public java.lang.Long getId() {
		return this.id;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setSimpleCode(java.lang.String value) {
		this.simpleCode = value;
	}
	
	public java.lang.String getSimpleCode() {
		return this.simpleCode;
	}
	public void setDepartmentId(java.lang.Long value) {
		this.departmentId = value;
	}
	
	public java.lang.Long getDepartmentId() {
		return this.departmentId;
	}
	public void setGender(java.lang.Integer value) {
		this.gender = value;
	}
	
	public java.lang.Integer getGender() {
		return this.gender;
	}
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setLoginId(java.lang.String value) {
		this.loginId = value;
	}
	
	public java.lang.String getLoginId() {
		return this.loginId;
	}
	public void setPassword(java.lang.String value) {
		this.password = value;
	}
	
	public java.lang.String getPassword() {
		return this.password;
	}
	public void setIsAvailable(java.lang.Integer value) {
		this.isAvailable = value;
	}
	
	public java.lang.Integer getIsAvailable() {
		return this.isAvailable;
	}
	public void setHeadImageUrl(java.lang.String value) {
		this.headImageUrl = value;
	}
	
	public java.lang.String getHeadImageUrl() {
		return this.headImageUrl;
	}
	public void setHeadImageStoragePath(java.lang.String value) {
		this.headImageStoragePath = value;
	}
	
	public java.lang.String getHeadImageStoragePath() {
		return this.headImageStoragePath;
	}
	public String getLastAccessString() {
		return DateConvertUtils.format(getLastAccess(), FORMAT_LAST_ACCESS);
	}
	public void setLastAccessString(String value) {
		setLastAccess(DateConvertUtils.parse(value, FORMAT_LAST_ACCESS,java.util.Date.class));
	}
	
	public void setLastAccess(java.util.Date value) {
		this.lastAccess = value;
	}
	
	public java.util.Date getLastAccess() {
		return this.lastAccess;
	}
	public String getCreatedAtString() {
		return DateConvertUtils.format(getCreatedAt(), FORMAT_CREATED_AT);
	}
	public void setCreatedAtString(String value) {
		setCreatedAt(DateConvertUtils.parse(value, FORMAT_CREATED_AT,java.util.Date.class));
	}
	
	public void setCreatedAt(java.util.Date value) {
		this.createdAt = value;
	}
	
	public java.util.Date getCreatedAt() {
		return this.createdAt;
	}
	public String getModifiedString() {
		return DateConvertUtils.format(getModified(), FORMAT_MODIFIED);
	}
	public void setModifiedString(String value) {
		setModified(DateConvertUtils.parse(value, FORMAT_MODIFIED,java.util.Date.class));
	}
	
	public void setModified(java.util.Date value) {
		this.modified = value;
	}
	
	public java.util.Date getModified() {
		return this.modified;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("SimpleCode",getSimpleCode())
			.append("DepartmentId",getDepartmentId())
			.append("Gender",getGender())
			.append("Mobile",getMobile())
			.append("LoginId",getLoginId())
			.append("Password",getPassword())
			.append("IsAvailable",getIsAvailable())
			.append("HeadImageUrl",getHeadImageUrl())
			.append("HeadImageStoragePath",getHeadImageStoragePath())
			.append("LastAccess",getLastAccess())
			.append("CreatedAt",getCreatedAt())
			.append("Modified",getModified())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Staff == false) return false;
		if(this == obj) return true;
		Staff other = (Staff)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
	
	// custom
	private String departmentName;
	private Department department;
	private Department rootDepartment;
	List<Long> roleIdList = new ArrayList<Long>();
	List<Role> roleList = new ArrayList<Role>();

	
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	
	//custom
	private String newPassword;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public Department getRootDepartment() {
		return rootDepartment;
	}

	public void setRootDepartment(Department rootDepartment) {
		this.rootDepartment = rootDepartment;
	}
	
	

	public Long getRootDepartmentId(){
		return rootDepartment==null?0L:rootDepartment.getId();
	}
	
	public String getGenderString() {
		StringBuilder condition = new StringBuilder();
		if(this.gender != null) {
			switch( this.gender) {
			case 1:
				condition.append("男");
				break;
			case 2:
				condition.append("女");
				break;
			default:
				condition.append("未知");
			}
		} else {
			condition.append("未知");
		}
		
			
		return condition.toString();
	}
	
	public String getIsAvailableString() {
		StringBuilder condition = new StringBuilder();
		if(this.isAvailable != null) {
			switch( this.isAvailable) {
				case 1:
					condition.append("有效");
					break;
				default:
					condition.append("无效");
			}
		} else {
			condition.append("无效");
		}
		
			
		return condition.toString();
	}
	
	private String nickName;




	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}

