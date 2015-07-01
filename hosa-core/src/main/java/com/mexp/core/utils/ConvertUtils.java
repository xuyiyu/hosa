
package com.mexp.core.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.lang3.StringUtils;


/**
 * 
 * @author allen
 *
 */
public class ConvertUtils {

	static {
		registerDateConverter();
	}

	/**
	 * 提取集合中的对象的属性(通过getter函数), 组合成List.
	 * 
	 * @param collection 来源集合.
	 * @param propertyName 要提取的属性名.
	 */
	@SuppressWarnings("unchecked")
	public static List convertElementPropertyToList(final Collection collection, final String propertyName) {
		List list = new ArrayList();

		try {
			for (Object obj : collection) {
				list.add(PropertyUtils.getProperty(obj, propertyName));
			}
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}

		return list;
	}

	/**
	 * 提取集合中的对象的属性(通过getter函数), 组合成由分割符分隔的字符串.
	 * 
	 * @param collection 来源集合.
	 * @param propertyName 要提取的属性名.
	 * @param separator 分隔符.
	 */
	@SuppressWarnings("unchecked")
	public static String convertElementPropertyToString(final Collection collection, final String propertyName,
			final String separator) {
		List list = convertElementPropertyToList(collection, propertyName);
		return StringUtils.join(list, separator);
	}

	/**
	 * 转换字符串到相应类型.
	 * 
	 * @param value 待转换的字符串.
	 * @param toType 转换目标类型.
	 */
	public static Object convertStringToObject(String value, Class<?> toType) {
		try {
			return org.apache.commons.beanutils.ConvertUtils.convert(value, toType);
		} catch (Exception e) {
			throw ReflectionUtils.convertReflectionExceptionToUnchecked(e);
		}
	}

	/**
	 * 定义日期Converter的格式: yyyy-MM-dd 或 yyyy-MM-dd HH:mm:ss
	 */
	private static void registerDateConverter() {
		DateConverter dc = new DateConverter();
		dc.setUseLocaleFormat(true);
		dc.setPatterns(new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss" });
		org.apache.commons.beanutils.ConvertUtils.register(dc, Date.class);
	}
	
	public static String BytesToHexString(byte[] bysBytes)
	{
		String strDigital="0123456789ABCDEF";
		
	    StringBuffer sb=new StringBuffer("");
	    byte[] bs = bysBytes;
	    int bit;
	    
	    for(int i=0;i<bs.length;i++)
	    {
	      bit=(bs[i]&0x0f0)>>4;
	      sb.append(strDigital.substring(bit,bit+1));
	      bit=bs[i]&0x0f;
	      sb.append(strDigital.substring(bit,bit+1));
	    }

	    return sb.toString();
	}
	
	public static byte[] HexStringToBytes(String strHexString)
	{
		String strDigital="0123456789ABCDEF";
	    
		byte[] bytes= new byte[strHexString.length()/2];
	    int temp;
	    for(int i=0;i<bytes.length;i++){
	      temp=strDigital.indexOf(strHexString.substring(2*i,2*i+1))*16;
	      temp+=strDigital.indexOf(strHexString.substring(2*i+1,2*i+2));
	      bytes[i]=(byte)(temp&0xff);
	    }

	    return bytes;
	}
	
	public static Map mapReflect(Object obj) {  
		  Map hashMap = new HashMap();  
		  try {  
		   Class c = obj.getClass();  
		   Method m[] = c.getDeclaredMethods();  
		   for (int i = 0; i < m.length; i++) {  
		    if (m[i].getName().indexOf("get")==0) {  
		      //System.out.println("方法名："+m[i].getName());  
		     // System.out.println("值："+ m[i].invoke(obj, new Object[0]));  
		     hashMap.put(m[i].getName(), m[i].invoke(obj, new Object[0]));  
		    }  
		   }  
		  } catch (Throwable e) {  
		   System.err.println(e);  
		  }  
		  return hashMap;  
		 }  
	
	
	public static Map<String,Object> convertMap (Object bean){
		Map<String,Object> rnt = null;
		if(bean!=null){
			rnt = new HashMap<String,Object>();
			Map<String,Object> param = new BeanMap(bean);
			for(String key :param.keySet()){
				Object value = param.get(key);
				rnt.put(key, value);
			}
		}
		return rnt;
	}
}
