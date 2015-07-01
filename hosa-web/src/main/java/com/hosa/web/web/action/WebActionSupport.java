package com.hosa.web.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hosa.core.exceptions.ServiceException;
import com.hosa.web.model.Staff;
import com.hosa.web.service.security.UserSession;
import com.hosa.web.utils.Struts2Utils;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 继承控制
 * @author allennb
 *
 */
public class WebActionSupport extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7684275304624546418L;
	private static final Logger log = LoggerFactory.getLogger(WebActionSupport.class);
	protected final String SUCCESS = "success";
	protected final String FAILURE = "failure";

	public Long getStaffId(){
		Long staffId = null;
		Staff staff = (Staff)SecurityUtils.getSubject().getPrincipal();
		if(staff != null) {
			staffId = staff.getId();
		}
		return staffId ;
	}
	
	public Long getDepartmentId(){
		Long departmentId = null;
		Staff staff = (Staff)SecurityUtils.getSubject().getPrincipal();
		if(staff != null) {
			departmentId = staff.getDepartmentId();
		}
		return departmentId ;
	}
	
	public Long getRootDepartmentId(){
		Long departmentId = null;
		Staff staff = (Staff)SecurityUtils.getSubject().getPrincipal();
		if(staff != null) {
			departmentId = staff.getRootDepartment().getId();
		}
		return departmentId ;
	}
	
	public String getDepartmentLevel(){
		String level = "";
		UserSession userSession = (UserSession) SecurityUtils.getSubject().getPrincipals();
		if(userSession != null && userSession.getDepartment() != null) {
			level = userSession.getDepartment().getLevel();
		}
		return level ;
	}
	
	public List<Long> getManagementDepartmentIdList() {
		List<Long> deptIdList = new ArrayList<Long>();
		UserSession userSession = (UserSession) SecurityUtils.getSubject().getPrincipals();
		if(userSession != null) {
			deptIdList = userSession.getManagementDepartmentIdList();
		}
		return deptIdList ;
	}
	
	public String getErrorInfo(ServiceException e) {
		return getText(e.getErrorCode(), e.getArgs());
	}
	
	public String getCommonErrorInfo() {
		return getText("common.error");
	}
	
	public String getCommonSuccessfulInfo() {
		return getText("common.successful");
	}
	
	public String getCommonListErrorInfo(String name, String reason) {
		List<String> list = new ArrayList<String>();
		list.add(getText(name));
		if(!"".equals(reason)) {
			list.add(getText(reason));
		} else {
			list.add(getText("common.unknown"));
		}
//		String error = getText("common.list.error", list);
		String error = getText(reason, list);
		return error;
	}
	
	public String getCommonDeleteErrorInfo(String name , String reason) {
		List<String> list = new ArrayList<String>();
		list.add(getText(name));
		if(!"".equals(reason)) {
			list.add(getText(reason));
		} else {
			list.add(getText("common.unknown"));
		}
//		String error = getText("common.delete.error", list);
		String error = getText(reason, list);
		return error;
	}
	
	public String getCommonSaveErrorInfo(String name , String reason) {
		List<String> list = new ArrayList<String>();
		list.add(getText(name));
		if(!"".equals(reason)) {
			list.add(getText(reason));
		} else {
			list.add(getText("common.unknown"));
		}
//		String error = getText("common.save.error", list);
		String error = getText(reason, list);
		return error;
	}
	
	public String getCommonInputErrorInfo(String name , String reason) {
		List<String> list = new ArrayList<String>();
		list.add(getText(name));
		if(!"".equals(reason)) {
			list.add(getText(reason));
		} else {
			list.add(getText("common.unknown"));
		}
//		String error = getText("common.input.error", list);
		String error = getText(reason, list);
		return error;
	}
	

	
	
	public void responseSuccessJson(Object returnObj, String reason) {
		String info = "common.success";
		if(reason != null && !"".equals(reason)) {
			info = reason;
		}
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("r_code", 0);
		returnMap.put("r_info", getText(info));
		returnMap.put("r_data", returnObj);
		Struts2Utils.renderJson(returnMap);
	}
	
	public void responseServiceErrorJson(String info) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("r_code", -2);
		returnMap.put("r_info", info);
		returnMap.put("r_data", null);
		Struts2Utils.renderJson(returnMap);
	}
	
	public void responseSystemErrorJson(String info) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("r_code", -1);
		returnMap.put("r_info", info);
		returnMap.put("r_data", null);
		Struts2Utils.renderJson(returnMap);
	}
	
	public void responseJson(int returnCode, String returnInfo, Object returnObj) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("r_code", returnCode);
		returnMap.put("r_info", returnInfo);
		returnMap.put("r_data", returnObj);
		Struts2Utils.renderJson(returnMap);
	}

}
