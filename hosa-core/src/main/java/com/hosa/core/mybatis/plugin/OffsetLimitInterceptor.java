package com.hosa.core.mybatis.plugin;



import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.xmltags.DynamicContext;
import org.apache.ibatis.scripting.xmltags.DynamicSqlSource;
import org.apache.ibatis.scripting.xmltags.SqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.StringUtils;

import com.hosa.core.jdbc.dialect.Dialect;
import com.hosa.core.utils.PropertiesHelper;
import com.hosa.core.utils.ReflectionUtils;


/**
 * 为ibatis3提供基于方言(Dialect)的分页查询的插件
 * 
 * 将拦截Executor.query()方法实现分页方言的插入.
 * 
 * 配置文件内容:
 * <pre>
 * 	&lt;plugins>
 *		&lt;plugin interceptor="cn.org.rapid_framework.ibatis3.plugin.OffsetLimitInterceptor">
 *			&lt;property name="dialectClass" value="cn.org.rapid_framework.jdbc.dialect.MySQLDialect"/>
 *		&lt;/plugin>
 *	&lt;/plugins>
 * </pre>
 * 
 * @author badqiu
 *
 */

@Intercepts({@Signature(
		type= Executor.class,
		method = "query",
		args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class OffsetLimitInterceptor implements Interceptor{
	static int MAPPED_STATEMENT_INDEX = 0;
	static int PARAMETER_INDEX = 1;
	static int ROWBOUNDS_INDEX = 2;
	static int RESULT_HANDLER_INDEX = 3;
	
	Dialect dialect;
	
	public Object intercept(Invocation invocation) throws Throwable {
		processIntercept(invocation.getArgs());
		return invocation.proceed();
	}

	void processIntercept(final Object[] queryArgs) {
		//queryArgs = query(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler)
		MappedStatement ms = (MappedStatement)queryArgs[MAPPED_STATEMENT_INDEX];
		Object parameter = queryArgs[PARAMETER_INDEX];
		final RowBounds rowBounds = (RowBounds)queryArgs[ROWBOUNDS_INDEX];
		int offset = rowBounds.getOffset();
		int limit = rowBounds.getLimit();
		
		if(dialect.supportsLimit() && (offset != RowBounds.NO_ROW_OFFSET || limit != RowBounds.NO_ROW_LIMIT)) {
			BoundSql boundSql = ms.getBoundSql(parameter);
			String sql = boundSql.getSql().trim();
			if (dialect.supportsLimitOffset()) {
				sql = dialect.getLimitString(sql, offset, limit);
				offset = RowBounds.NO_ROW_OFFSET;
			} else {
				sql = dialect.getLimitString(sql, 0, limit);
			}
			limit = RowBounds.NO_ROW_LIMIT;
			
			queryArgs[ROWBOUNDS_INDEX] = new RowBounds(offset,limit);
			
			BoundSql newBoundSql = new BoundSql(ms.getConfiguration(),sql, boundSql.getParameterMappings(), boundSql.getParameterObject());
			
			BoundSqlSqlSource newSqlSource = new BoundSqlSqlSource(newBoundSql);
			if(ms.getSqlSource() instanceof 	DynamicSqlSource){
				DynamicSqlSource d = (DynamicSqlSource)ms.getSqlSource();
				SqlNode rootSqlNode = null;
				rootSqlNode = (SqlNode)ReflectionUtils.getFieldValue(d, "rootSqlNode");
				//newSqlSource = new DynamicSqlSource(ms.getConfiguration(),rootSqlNode);
				newSqlSource.setConfiguration(ms.getConfiguration());
				newSqlSource.setRootSqlNode(rootSqlNode);
			}
			MappedStatement newMs = copyFromMappedStatement(ms, newSqlSource);
			queryArgs[MAPPED_STATEMENT_INDEX] = newMs;
		}
	}
	
	//see: MapperBuilderAssistant
	private MappedStatement copyFromMappedStatement(MappedStatement ms,SqlSource newSqlSource) {
		Builder builder = new MappedStatement.Builder(ms.getConfiguration(),ms.getId(),newSqlSource,ms.getSqlCommandType());
		
		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		builder.keyProperty(StringUtils.arrayToCommaDelimitedString(ms.getKeyProperties()));
		builder.keyColumn(StringUtils.arrayToCommaDelimitedString(ms.getKeyColumns()));
		
		
		//setStatementTimeout()
		builder.timeout(ms.getTimeout());
		
		//setStatementResultMap()
		builder.parameterMap(ms.getParameterMap());
		
		//setStatementResultMap()
		builder.resultMaps(ms.getResultMaps());
		builder.resultSetType(ms.getResultSetType());
	    
		//setStatementCache()
		builder.cache(ms.getCache());
		builder.flushCacheRequired(ms.isFlushCacheRequired());
		builder.useCache(ms.isUseCache());
		
		return builder.build();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		String dialectClass = new PropertiesHelper(properties).getRequiredString("dialectClass");
		try {
			dialect = (Dialect)Class.forName(dialectClass).newInstance();
		} catch (Exception e) {
			throw new RuntimeException("cannot create dialect instance by dialectClass:"+dialectClass,e);
		} 
		System.out.println(OffsetLimitInterceptor.class.getSimpleName()+".dialect="+dialectClass);
	}
	
	public static class BoundSqlSqlSource implements SqlSource {
		BoundSql boundSql;
		
		Configuration configuration;
		SqlNode rootSqlNode;
		
		public BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}
		public BoundSql getBoundSql(Object parameterObject) {
			if(configuration!=null&&rootSqlNode!=null){
				DynamicContext context = new DynamicContext(configuration, parameterObject);
			    rootSqlNode.apply(context);
//			    SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(configuration);
//			    Class parameterType = parameterObject == null ? Object.class : parameterObject.getClass();
//			    SqlSource sqlSource = sqlSourceParser.parse(context.getSql(), parameterType);
			    //BoundSql boundSql = sqlSource.getBoundSql(parameterObject);
			    for (Map.Entry<String, Object> entry : context.getBindings().entrySet()) {
			      boundSql.setAdditionalParameter(entry.getKey(), entry.getValue());
			    }			    
			}
			return boundSql;
		}
		/**
		 * @param configuration the configuration to set
		 */
		public void setConfiguration(Configuration configuration) {
			this.configuration = configuration;
		}
		/**
		 * @param rootSqlNode the rootSqlNode to set
		 */
		public void setRootSqlNode(SqlNode rootSqlNode) {
			this.rootSqlNode = rootSqlNode;
		}
	}
	
}
