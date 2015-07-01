/*
 * Automatically generated
 */

package com.hosa.web.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.hosa.core.base.BaseEntity;
import com.hosa.core.utils.DateConvertUtils;

public class StaffRoleRelation extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "员工角色关系";
	public static final String ALIAS_ID = "编号";
	public static final String ALIAS_STAFF_ID = "员工编号";
	public static final String ALIAS_ROLE_ID = "角色编号";
	public static final String ALIAS_MODIFIED = "最后修改时间";
	
	//date formats
	
	public static final String FORMAT_MODIFIED = TIMESTAMP_FORMAT;
	
	//可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
	//columns START
    /**
     * 编号       db_column: id 
     */	
	
	private java.lang.Long id;
    /**
     * 员工编号       db_column: staff_id 
     */	
	
	private java.lang.Long staffId;
    /**
     * 角色编号       db_column: role_id 
     */	
	
	private java.lang.Long roleId;
    /**
     * 最后修改时间       db_column: modified 
     */	
	
	private java.util.Date modified;
	//columns END

	public StaffRoleRelation(){
	}

	public StaffRoleRelation(
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
	public void setStaffId(java.lang.Long value) {
		this.staffId = value;
	}
	
	public java.lang.Long getStaffId() {
		return this.staffId;
	}
	public void setRoleId(java.lang.Long value) {
		this.roleId = value;
	}
	
	public java.lang.Long getRoleId() {
		return this.roleId;
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
			.append("StaffId",getStaffId())
			.append("RoleId",getRoleId())
			.append("Modified",getModified())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof StaffRoleRelation == false) return false;
		if(this == obj) return true;
		StaffRoleRelation other = (StaffRoleRelation)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
	
	//custom
	private Staff staff;
	private Role role;

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}

