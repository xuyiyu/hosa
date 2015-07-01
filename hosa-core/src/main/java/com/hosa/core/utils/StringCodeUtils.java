package com.hosa.core.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author allennb
 *
 */
public class StringCodeUtils {
	
	protected static Logger logger = LoggerFactory.getLogger(StringCodeUtils.class);
	
	private static DES des = new DES(md5("mis.mik"));

	private static char[] CHAR_POOL = "1234567890qwertyuiopasdfghjklzxcvbnmABC".toCharArray();
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	/**
	 * 随机数
	 * @param len
	 * @return
	 */
	public static String randomString(int len){
		StringBuffer rnt = new StringBuffer();
		Random r = new Random(System.currentTimeMillis());
		for(int i=0;i<len;i++){
			int index = r.nextInt(CHAR_POOL.length-1);
			rnt.append(CHAR_POOL[index]);
		}
		return rnt.toString();
	}	
	
	/**
	 * sha1加密
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String sha1(String str) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		        byte[] result = mDigest.digest(str.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < result.length; i++) {
		            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		        }
		        return sb.toString();

	}
	
	/**
	 * md5加密
	 * @param str
	 * @return
	 */
	public static String md5(String str){
		 MessageDigest messageDigest = null;  
		  
	        try {  
	            messageDigest = MessageDigest.getInstance("MD5");  
	  
	            messageDigest.reset();  
	  
	            messageDigest.update(str.getBytes("UTF-8"));  
	        } catch (NoSuchAlgorithmException e) {  
	            System.out.println("NoSuchAlgorithmException caught!");  
	            System.exit(-1);  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	  
	        byte[] byteArray = messageDigest.digest();  
	  
	        StringBuffer md5StrBuff = new StringBuffer();  
	  
	        for (int i = 0; i < byteArray.length; i++) {              
	            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)  
	                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));  
	            else  
	                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));  
	        }  
	  
	        return md5StrBuff.toString();  
	}
	
	/**
	 * des解密
	 * @param str 字符串
	 * @return 解密字符串
	 */
	public static String decode(String str){
		//加密 解密 
		try {
			str = new String(des.DESDecrypt(ConvertUtils.HexStringToBytes(str)));
		} catch (Exception e) {
			logger.warn("decode error", e);
		}
		return str;
	}
	/**
	 * des加密
	 * @param str 字符串
	 * @return 加密字符串
	 */
	public static String encode(String str){
		try {
			str = ConvertUtils.BytesToHexString(des.DESEncrypt(str.getBytes()));
		} catch (Exception e) {
			logger.warn("encode error", e);
		}
		return str;
	}
	
	/**
	 * 对象转json串
	 * @param obj
	 * @return
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static String toJson(Object obj) throws JsonGenerationException, JsonMappingException, IOException{
		
		return mapper.writeValueAsString(obj);
	}
	
	/**
	 * json串转map
	 * @param str
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static Map<?,?> toMap(String str) throws JsonParseException, JsonMappingException, IOException {
		return toObject(str,Map.class);
	}
	
	/**
	 * json串转对象
	 * @param str
	 * @param toValueType
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T toObject(String str ,Class<T> toValueType ) throws JsonParseException, JsonMappingException, IOException{
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		return mapper.readValue(str, toValueType);
	}
	
	/**
	 * json串转对象
	 * @param str
	 * @param toValueType	转换的类
	 * @param subType	泛型
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T, K> T toObject(String str ,Class<T> toValueType, Class<K> subType) throws JsonParseException, JsonMappingException, IOException{
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		JavaType javaType =  mapper.getTypeFactory().constructParametricType(toValueType, subType);  
		return mapper.readValue(str, javaType);
	}
	
	public static <T, K, V> T toMap(String str ,Class<T> toValueType, Class<K> keyType, Class<V> valueType) throws JsonParseException, JsonMappingException, IOException{
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		JavaType javaType =  mapper.getTypeFactory().constructParametricType(toValueType, keyType, valueType);  
		return mapper.readValue(str, javaType);
	}

    /**
     * 将str将多个分隔符进行切分，
     * 
     * 示例：StringTokenizerUtils.split("1,2;3 4"," ,;");
     * 返回: ["1","2","3","4"]
     * 
     * @param str
     * @param seperators
     * @return
     */
	@SuppressWarnings("all")
	public static String[] split(String str,String seperators) {
		StringTokenizer tokenlizer = new StringTokenizer(str,seperators);
		List result = new ArrayList();
		
		while(tokenlizer.hasMoreElements()) {
			Object s = tokenlizer.nextElement();
			result.add(s);
		}
		return (String[])result.toArray(new String[result.size()]);
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "0841f4";
		String encodeStr = StringCodeUtils.encode(str);
		System.out.println("encodeStr:"+encodeStr);
		String decodeStr = StringCodeUtils.decode("3A58B2D6D311E27D");
		System.out.println("decodeStr:"+decodeStr);
		
		System.out.println("--------------");
		
		System.out.println(StringUtils.substring(StringCodeUtils.md5("txp_admin"), 0, 6));
		
		System.out.println("--------------");
		
		try {
			System.out.println(StringCodeUtils.md5(System.currentTimeMillis()+""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
