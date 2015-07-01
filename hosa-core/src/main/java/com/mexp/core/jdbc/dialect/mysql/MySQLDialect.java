package com.mexp.core.jdbc.dialect.mysql;

import com.mexp.core.jdbc.dialect.Dialect;


/**
 * 
 * @author allennb
 *
 */
public class MySQLDialect extends Dialect {

	public boolean supportsLimitOffset(){
		return true;
	}
	
    public boolean supportsLimit() {   
        return true;   
    }  
    
    /**
     * @param sql               实际SQL语句
	 * @param offset            分页开始纪录条数
	 * @param offsetPlaceholder 分页开始纪录条数－占位符号
	 * @param limitPlaceholder  分页纪录条数占位符号
	 * @return 					包含占位符的分页sql
     */
	public String getLimitString(String sql, int offset,String offsetPlaceholder, int limit, String limitPlaceholder) {
		StringBuilder stringBuilder = new StringBuilder(sql);
		stringBuilder.append(" limit ");
        if (offset > 0) {   
        	stringBuilder.append(offsetPlaceholder).append(",").append(limitPlaceholder);
        } else {   
            stringBuilder.append(limitPlaceholder);
        }  
        return stringBuilder.toString();
	}   
  
}
