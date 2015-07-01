package com.mexp.web.utils;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PropertiesUtlis {
	
	private static Logger log = LoggerFactory.getLogger(PropertiesUtlis.class);
	
	public static final String DOWNLOAD_PATH= "upload.base.url";
	
	public static final String WEB_HOST = "web.host";
	
	public static final String WEB_CONTEXT_PATH = "web.context.path";
	
	private static Properties properties ;
	
	private static Integer lock = 1;
	
	private static void init(){
		InputStream inputStream = PropertiesUtlis.class.getClassLoader()
				.getResourceAsStream("spring/application.properties");
		properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (Exception e1) {
			log.error("load application.properties error.", e1);
		}
	}
	

	public static String get(String key){
		if(properties == null){
			synchronized (lock) {
				if(properties == null){
					init();
				}
			}
		}
		
		return properties.getProperty(key);
	}
}
