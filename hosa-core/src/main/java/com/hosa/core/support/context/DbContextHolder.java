package com.hosa.core.support.context;

public abstract class DbContextHolder {
	public final static String DATA_SOURCE_1 = "db1";
    public final static String DATA_SOURCE_2 = "db2";
    
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>(); 
    
    public static void setDbType(String dbType) {  
        contextHolder.set(dbType);  
    }  
      
    public static String getDbType() {  
        return contextHolder.get();  
    }  
      
    public static void clearDbType() {  
        contextHolder.remove();  
    }  
}
