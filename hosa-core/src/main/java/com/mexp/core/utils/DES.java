package com.mexp.core.utils;

import javax.crypto.SecretKey;

/**
 *
 * @author Allen
 *
 */
public class DES {
	protected SecretKey	m_key;

	//属性对象,所有在本类中创建，并允许外部访问的对象在此声明并提供get/set方法-----------------------------------

	//引用对象,所有在外部创建并传入使用的对象在此声明并提供set方法-----------------------------------------------

	//内部方法,所有仅在本类或派生类中使用的函数在此定义为protected方法-------------------------------------------

	//公共方法,所有可提供外部使用的函数在此定义为public方法------------------------------------------------------
	/**
	 * @param bysKey 一个长度为8的byte[]，当作密匙
	 */
	public void SetDESKey(String strKey) throws Exception
	{

		byte[] bysKey = (strKey).getBytes();
//		System.out.println(bysKey.toString());
		javax.crypto.spec.DESKeySpec deskeyspec=new javax.crypto.spec.DESKeySpec(bysKey);
		javax.crypto.SecretKeyFactory skf=javax.crypto.SecretKeyFactory.getInstance("DES");
		m_key	=(javax.crypto.SecretKey)skf.generateSecret(deskeyspec);
	}

	/**
	 * 加密
	 * @param bysInput
	 * @return
	 * @throws Exception
	 */
	public byte[] DESEncrypt(byte[] bysInput) throws Exception
	{
		javax.crypto.Cipher cipher=javax.crypto.Cipher.getInstance("DES");
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE,m_key);

		byte[] bysOutput	=cipher.doFinal(bysInput);

		return bysOutput;
	}

	/**
	 * 解密
	 * @param bysInput
	 * @return
	 * @throws Exception
	 */
	public byte[] DESDecrypt(byte[] bysInput) throws Exception
	{
		javax.crypto.Cipher cipher=javax.crypto.Cipher.getInstance("DES");
		cipher.init(javax.crypto.Cipher.DECRYPT_MODE,m_key);

		byte[] bysOutput	=cipher.doFinal(bysInput);

		return bysOutput;
	}

	//接口实现,所有实现接口函数的实现在此定义--------------------------------------------------------------------

	//事件处理,所有重载派生类的事件类方法(一般为on...ed)在此定义-------------------------------------------------

	//事件定义,所有在本类中定义并调用，由派生类实现或重载的事件类方法(一般为on...ed)在此定义---------------------

	//构造函数,所有构造函数在此定义------------------------------------------------------------------------------

	public DES()
	{
		super();
		

		//请在此加入初始化代码,内部对象和属性对象负责创建或赋初值,引用对象初始化为null，初始化完成后在设置各对象之间的关系
		m_key		=null;
	}
	public DES(String strKey)
	{
		super();
		try {
			this.SetDESKey(strKey);
		} catch (Exception e) {
			m_key = null;
		}
	}
	
	

	public static void main(String[] args)
	{

	    
		String strA = "3554545";
		DES des = new DES();
		try
		{
			des.SetDESKey("1057");
			
			String aa = ConvertUtils.BytesToHexString(des.DESEncrypt(strA.getBytes()));
			System.out.println(aa);
			des.SetDESKey("1057");
			String bb = new String(des.DESDecrypt(ConvertUtils.HexStringToBytes(aa)));
			System.out.println(bb);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
