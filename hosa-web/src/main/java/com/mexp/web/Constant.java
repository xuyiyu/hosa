package com.mexp.web;

public class Constant {
	
	/* ---------cache begin------------- */
	//默认缓存池
	private static final String CACHE_BASE = "mexp-WEB_";
	public static final String CACHE_POOL_DEFAULT = CACHE_BASE + "CACHE_POOL_DEFAULT";//默认cache
	
	
	public static final String CACHE_POOL_CAPTCHA = CACHE_BASE + "CACHE_POOL_CAPTCHA";
	public static final String CACHE_POOL_INBOUND_MENU = CACHE_BASE + "CACHE_POOL_INBOUND_MENU";//进线菜单cache
	public static final String CACHE_POOL_INBOUND_USER_ASSOCIATE_DATA = CACHE_BASE + "CACHE_POOL_INBOUND_USER_ASSOCIATE_DATA";//进线用户cache
	
	//微信
	public static final String WEIXIN_USER_INBOUND_STATUS_CACHE = CACHE_BASE + "CACHE_POOL_WEIXIN_USER_INBOUND_STATUS";
	//救援订单图片
	public static final String WEIXIN_USER_RESCUE_ORDER_IMG_CACHE = CACHE_BASE + "CACHE_POOL_WEIXIN_USER_RESCUE_ORDER_IMG";
	
	//自动应答
	public static final String WEIXIN_USER_AUTO_MENU_SELECTED_ID_CACHE = CACHE_BASE + "CACHE_POOL_WEIXIN_USER_AUTO_MENU_SELECTED_ID_CACHE";
	
	public static final String CACHE_POOL_SETTINGS = CACHE_BASE + "CACHE_POOL_SETTINGS";//settings cache
	/* ---------cache end------------- */
	public static final String LEVEL_SEPARATOR = "-";
	/* ---------settings------------- */
	public static final String SETTINGS_WEIXIN_APPID = "SETTINGS_WEIXIN_APPID";//微信appid
	public static final String SETTINGS_WEIXIN_APPSECRET = "SETTINGS_WEIXIN_APPSECRET";//微信appsecret
	public static final String SETTINGS_WEIXIN_ACCESS_TOKEN = "SETTINGS_WEIXIN_ACCESS_TOKEN";//微信accesstoken
	public static final String SETTINGS_WEIXIN_URL = "SETTINGS_WEIXIN_URL";//微信url
	public static final String SETTINGS_WEIXIN_TOKEN = "SETTINGS_WEIXIN_TOKEN";//微信token
	public static final String SETTINGS_WEIXIN_TYPE = "SETTINGS_WEIXIN_TYPE";//微信账号类型
	public static final String SETTINGS_WEIXIN_SUBSCRIBE_WELCOME = "SETTINGS_WEIXIN_SUBSCRIBE_WELCOME";//微信订阅欢迎语
	/* ---------settings------------- */
	
}
