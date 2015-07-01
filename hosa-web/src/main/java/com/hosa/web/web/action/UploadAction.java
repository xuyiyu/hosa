/*
 * Automatically generated
 */

package com.hosa.web.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;

import com.hosa.core.exceptions.ServiceException;
import com.hosa.core.utils.DateConvertUtils;
import com.hosa.core.utils.GB2AlphaUtils;
import com.hosa.core.utils.StringCodeUtils;
import com.hosa.web.utils.Struts2Utils;

@Namespace("/webadmin")
@Scope("prototype")
public class UploadAction extends WebActionSupport {

	private String qqfile;
	private String type;
	private File uploadFile;
	private String uploadFileFileName;
	
	private List<File> filedata;
	private List<String> filename;
	
	@Value("${upload.base.url}")
	private String baseUrl;
	
	@Value("${upload.filectx}")
	private String fileCtx;
	
	private File imgFile;
	private String imgFileFileName;
	private String dir;
	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(UploadAction.class);

	@Override
	@Actions({@Action(value="/commons/upload")
	,@Action(value="/webadmin/upload")})
	
	public String execute() throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			String[] fileName = upload();
			
			returnMap.put("r_code", 0);
			returnMap.put("r_info", "success");
			returnMap.put("r_data", fileName);
			returnMap.put("success", true);
			Struts2Utils.renderJson(returnMap);
		} catch(Exception e) {
			returnMap.put("success", false);
			Struts2Utils.renderJson(returnMap);
		}
		
		return null;
	}
	
	private String[] upload() throws ServiceException {
		InputStream in;
		try {
			java.io.File f = new java.io.File(baseUrl);
			if(!f.exists()) {
				f.mkdirs();
			}
			
			if(!StringUtils.endsWith(baseUrl, "/") && !StringUtils.endsWith(baseUrl, "\\")) {
				baseUrl = baseUrl + "/";
			}
			Date now = new Date();
			int year = DateConvertUtils.getYearOfDate(now);
			int month = DateConvertUtils.getMonthOfDate(now);
			int day = DateConvertUtils.getDayOfDate(now);
			StringBuffer fullPath = new StringBuffer();
			//fullPath.append(baseUrl);
			fullPath.append(year);
			fullPath.append("/");
			fullPath.append(month);
			fullPath.append("/");
			f = new java.io.File(baseUrl+fullPath.toString());
			if(!f.exists()) {
				f.mkdirs();
			}
			
			if(filename != null && filedata != null) {
				int size = filedata.size();
				String []returnNames = new String[filename.size()];
				for(int i=0; i< size; i++) {
					File file = filedata.get(i);
					in = new FileInputStream(file);
					String name = fullPath.toString() + StringCodeUtils.randomString(6) + "_" + filename.get(i);
					FileOutputStream fos = new FileOutputStream(baseUrl + name);
			        IOUtils.copy(in, fos);
			        IOUtils.closeQuietly(in);
			        IOUtils.closeQuietly(fos);
			        in.close();
			        fos.close();
			        returnNames[i] = name;
				}
				return returnNames;
			}else if(uploadFileFileName != null &&uploadFile!=null) {
				in = new FileInputStream(uploadFile);
			}else{
				in = Struts2Utils.getRequest().getInputStream();
			}
		
			String suffix = StringUtils.substringAfterLast(uploadFileFileName, ".");
			String n = StringUtils.substringBeforeLast(uploadFileFileName, ".");
			if(!"".equals(suffix)) {
				suffix = "." + suffix;
			}
			String fileName = fullPath.toString() + StringCodeUtils.randomString(6) + "_" +GB2AlphaUtils.getPinYinHeadChar(n) + suffix;
			FileOutputStream fos = new FileOutputStream(baseUrl + fileName);
	        IOUtils.copy(in, fos);
	        IOUtils.closeQuietly(in);
	        IOUtils.closeQuietly(fos);
	        in.close();
	        fos.close();
	        return new String[]{fileCtx + "/" + fileName, baseUrl + fileName};
		} catch (IOException e) {
			log.error("upload file error", e);
			throw new ServiceException("upload.file.error");
		}
		
	}

	public String ckeditorUpload() throws Exception {
		InputStream in;
		Map<String, Object> returnMap = new HashMap<String, Object>();
		try {
			java.io.File f = new java.io.File(baseUrl);
			if(!f.exists()) {
				f.mkdirs();
			}
			
			if(!StringUtils.endsWith(baseUrl, "/") && !StringUtils.endsWith(baseUrl, "\\")) {
				baseUrl = baseUrl + "/";
			}
			Date now = new Date();
			int year = DateConvertUtils.getYearOfDate(now);
			int month = DateConvertUtils.getMonthOfDate(now);
			int day = DateConvertUtils.getDayOfDate(now);
			StringBuffer fullPath = new StringBuffer();
			StringBuilder fullUrlPath = new StringBuilder();
			//fullPath.append(baseUrl);
			fullPath.append(year);
			fullUrlPath.append(year);
			fullPath.append(File.separator);
			fullUrlPath.append("/");
			fullPath.append(month);
			fullUrlPath.append(month);
			fullPath.append(File.separator);
			fullUrlPath.append("/");
			f = new java.io.File(baseUrl+fullPath.toString());
			if(!f.exists()) {
				f.mkdirs();
			}
			
			in = new FileInputStream(imgFile);
			
			String suffix = StringUtils.substringAfterLast(imgFileFileName, ".");
			String n = StringUtils.substringBeforeLast(imgFileFileName, ".");
			if(!"".equals(suffix)) {
				suffix = "." + suffix;
			}
			String fileName = StringCodeUtils.randomString(6) + "_" +GB2AlphaUtils.getPinYinHeadChar(n) + suffix;
			FileOutputStream fos = new FileOutputStream(baseUrl + fullPath.toString() + fileName);
	        IOUtils.copy(in, fos);
	        IOUtils.closeQuietly(in);
	        IOUtils.closeQuietly(fos);
	        in.close();
	        fos.close();
	        
	        returnMap.put("error", 0);
	        returnMap.put("url", fileCtx + fullUrlPath + fileName);
	        Struts2Utils.renderJson(returnMap);

	        //Struts2Utils.renderHtml(str.toString());
		} catch (IOException e) {
			log.error("upload file error", e);
			//throw new ServiceException("upload.file.error");
			returnMap.put("error", 1);
			returnMap.put("message", "upload file error");
			Struts2Utils.renderJson(returnMap);
		}
		
		
		return null;
	}
	public String getQqfile() {
		return qqfile;
	}

	public void setQqfile(String qqfile) {
		this.qqfile = qqfile;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public List<File> getFiledata() {
		return filedata;
	}

	public void setFiledata(List<File> filedata) {
		this.filedata = filedata;
	}

	public List<String> getFilename() {
		return filename;
	}

	public void setFilename(List<String> filename) {
		this.filename = filename;
	}

	
	
	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}


	public File getImgFile() {
		return imgFile;
	}

	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}

	public String getImgFileFileName() {
		return imgFileFileName;
	}

	public void setImgFileFileName(String imgFileFileName) {
		this.imgFileFileName = imgFileFileName;
	}

	public static void main(String args[]) {
		String s = "a\123b";
		System.out.println(s.replaceAll("\\\\", "\\\\"));
	}

}
