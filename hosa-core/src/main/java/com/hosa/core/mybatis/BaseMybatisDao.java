package com.hosa.core.mybatis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DaoSupport;
import org.springframework.util.Assert;

import com.hosa.core.base.BaseDao;
import com.hosa.core.base.BaseQuery;
import com.hosa.core.page.Page;

/**
 * 
 * @author allennb
 *
 * @param <E>
 * @param <PK>
 */
public abstract class BaseMybatisDao<E,PK extends Serializable> extends DaoSupport implements BaseDao<E,PK> {
    protected final Log log = LogFactory.getLog(getClass());
    
    private SqlSessionFactory sqlSessionFactory;
    private SqlSessionTemplate sqlSessionTemplate;
	protected void checkDaoConfig() throws IllegalArgumentException {
		Assert.notNull(sqlSessionFactory,"sqlSessionFactory must be not null");
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
		//this.sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
	}

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public SqlSessionTemplate getSqlSessionTemplate() {
    	return sqlSessionTemplate;
    }
    
    public E getById(PK primaryKey) {
        E object = (E)getSqlSessionTemplate().selectOne(getFindByPrimaryKeyStatement(), primaryKey);
        return object;
    }
    
    @SuppressWarnings("unchecked")
	public List<E> getByMultipleId(List idList) {
    	return (List<E>) getSqlSessionTemplate().selectList(getFindByMultiplePrimaryKeyStatement(), idList);
    }
    
	public Integer deleteById(PK id) {
		return getSqlSessionTemplate().delete(getDeleteStatement(), id);
	}
	
	public Integer deleteByMultipleId(List idList) throws DataAccessException {
		return getSqlSessionTemplate().delete(getDeleteMultipleStatement(), idList);
	}
	
    public Integer save(E entity) {
		prepareObjectForSaveOrUpdate(entity);
		return getSqlSessionTemplate().insert(getInsertStatement(), entity);    	
    }
    
	public Integer update(E entity) {
		prepareObjectForSaveOrUpdate(entity);
		return getSqlSessionTemplate().update(getUpdateStatement(), entity);
	}

	public List<E> findList(BaseQuery query) {
		return  getSqlSessionTemplate().selectList(getFindListStatement(), query);
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findList(final BaseQuery query, Integer size) {
		return (List<E>) getSqlSessionTemplate().selectList(getFindListStatement(), query, new RowBounds(0, size));
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findList(final BaseQuery query, Integer size, Integer offset) {
		return (List<E>) getSqlSessionTemplate().selectList(getFindListStatement(), query, new RowBounds(offset, size));
	}
	
	/**
	 * 用于子类覆盖,在insert,update之前调用
	 * @param o
	 */
    protected void prepareObjectForSaveOrUpdate(E o) {
    }

    public String getIbatisMapperNamesapce() {
        throw new RuntimeException("not yet implement");
    }
    
    public String getFindByPrimaryKeyStatement() {
        return getIbatisMapperNamesapce()+".getById";
    }

    public String getFindByMultiplePrimaryKeyStatement() {
    	return getIbatisMapperNamesapce()+".getByMultipleId";
    }
    public String getInsertStatement() {
        return getIbatisMapperNamesapce()+".insert";
    }

    public String getUpdateStatement() {
    	return getIbatisMapperNamesapce()+".update";
    }

    public String getDeleteStatement() {
    	return getIbatisMapperNamesapce()+".delete";
    }
    
    public String getDeleteMultipleStatement() {
    	return getIbatisMapperNamesapce()+".deleteMultiple";
    }

    public String getFindListStatement() {
    	return getIbatisMapperNamesapce()+".findList";
    }
    public String getFindPageStatement() {
        return getIbatisMapperNamesapce()+".findPage";
    }
    
    public String getCountStatementForPaging(String statementName) {
		return statementName +".count";
	}
    
	/*protected Page pageQuery(String statementName, PageRequest pageRequest) {
		return pageQuery(getSqlSessionTemplate(),statementName,getCountStatementForPaging(statementName),pageRequest);
	}
	
	public static Page pageQuery(SqlSessionTemplate sqlSessionTemplate,String statementName,String countStatementName, PageRequest pageRequest) {
		
		Number totalCount = (Number) sqlSessionTemplate.selectOne(countStatementName,pageRequest);
		if(totalCount == null || totalCount.longValue() <= 0) {
			return new Page(pageRequest,0);
		}
		
		Page page = new Page(pageRequest,totalCount.intValue());
		
		//其它分页参数,用于不喜欢或是因为兼容性而不使用方言(Dialect)的分页用户使用. 与getSqlMapClientTemplate().queryForList(statementName, parameterObject)配合使用
		Map filters = new HashMap();
		filters.put("offset", page.getFirstResult());
		filters.put("pageSize", page.getPageSize());
		filters.put("lastRows", page.getFirstResult() + page.getPageSize());
		filters.put("sortColumns", pageRequest.getSortColumns());
		
		Map parameterObject = PropertyUtils.describe(pageRequest);
		filters.putAll(parameterObject);
		
		List list = sqlSessionTemplate.selectList(statementName, filters,page.getFirstResult(),page.getPageSize());
		page.setResult(list);
		return page;
	}
	*/
    
    @SuppressWarnings("unchecked")
	public Page<E> pageQuery(final Page<E> page, final BaseQuery query) {
    	return pageQuery( page, getFindPageStatement(), query);	
	}
    
    public Long getQueryCount(final BaseQuery query) {
      	 Number totalCount = (Number) sqlSessionTemplate.selectOne(getCountStatementForPaging(getFindPageStatement()), query);
      	 return totalCount.longValue();
    }
    
    public Page<E> pageQuery(final Page<E> page, final String statement,final BaseQuery query) {
		Assert.notNull(page, "page不能为空");

//		if (page.isAutoCount()) {
			Number totalCount = (Number) sqlSessionTemplate.selectOne(getCountStatementForPaging(statement), query);
			page.setTotalCount(totalCount.longValue());
			
			if(totalCount == null || totalCount.longValue() <= 0) {
				page.setResult(new ArrayList<E>());
				return page;
			}
//		}

		Map<String, Object> otherFilters = new HashMap<String, Object>();
		otherFilters.put("offset", page.getCurrentFirst() - 1);
		otherFilters.put("pageSize", page.getPageSize());
		otherFilters.put("lastRows", page.getCurrentLast());
		
		StringBuffer  sortColumns = new StringBuffer();
		sortColumns.append(" ");
		if (page.isOrderBySetted()) {
			String[] orderByArray = StringUtils.split(page.getOrderBy(), ',');
			String[] orderArray = StringUtils.split(page.getOrder(), ',');

			Assert.isTrue(orderByArray.length == orderArray.length, "分页多重排序参数中,排序字段与排序方向的个数不相等");

			for (int i = 0; i < orderByArray.length; i++) {
				if(i > 0) {
					sortColumns.append(" , ");
				}
				String orderBy = orderByArray[i];
				if(orderByArray[i].endsWith("Name")) {
					orderBy = " CONVERT( " + orderBy + " using gbk)";
				}
				sortColumns.append(orderBy);
				if (Page.ASC.equals(orderArray[i])) {
					sortColumns.append(" ASC ");
				} else {
					sortColumns.append(" DESC ");
				}
			}
		}
		if(!" ".equals(sortColumns.toString())) {
			query.setSortColumns(sortColumns.toString());
		}
		
		query.setOffset(page.getCurrentFirst());
		query.setPageSize(page.getPageSize());
		query.setLastRows(page.getCurrentLast());
//		otherFilters.put("sortColumns", sortColumns);

		List result = sqlSessionTemplate.selectList(statement, query, new RowBounds((int)page.getCurrentFirst()-1, page.getPageSize()) );
		page.setResult(result);
		return page;
	}
    
    
	public List findAll() {
		return getSqlSessionTemplate().selectList(getFindListStatement());
	}

	public boolean isUnique(E entity, String uniquePropertyNames) {
		throw new UnsupportedOperationException();
	}
	
	public void flush() {
		//ignore
	}
	

}
