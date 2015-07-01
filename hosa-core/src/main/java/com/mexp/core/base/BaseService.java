package com.mexp.core.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import freemarker.template.Template;

public class BaseService {

	protected void deleteFile(String filePath) {
		File f = new File(filePath);
		if(f.exists()) {
			f.delete();
		}
		
	}
	
	protected void generateHtml(Template template, Map<Object, Object> data, String contextPath, String filePath, String fileName) {
		if(contextPath == null) {
			contextPath = "/";
		}
		template.setEncoding("utf-8");
		//静态页面绝对路径  

        String htmlPath = filePath + fileName;  
        File htmlFile = new File(htmlPath);  
        if(!htmlFile.getParentFile().exists()){  
            htmlFile.getParentFile().mkdirs();  
        }  
        try {
        	if(htmlFile.exists()) {
        		htmlFile.delete();
        	}
        	htmlFile.createNewFile();
			
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));
			
            //处理模版    
            data.put("ctx", contextPath);
            template.process(data, out);  
            out.flush();  
            out.close();  
        }catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
