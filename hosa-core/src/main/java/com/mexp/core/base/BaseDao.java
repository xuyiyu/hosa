package com.mexp.core.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mexp.core.page.Page;

/**
 * 
 * @author allennb
 *
 * @param <E>
 * @param <PK>
 */
public interface BaseDao <E, PK extends Serializable>{

	public E getById(PK id) throws DataAccessException;
	
	public Integer deleteById(PK id) throws DataAccessException;
	
	/** 插入数据 */
	public Integer save(E entity) throws DataAccessException;
	
	/** 更新数据 */
	public Integer update(E entity) throws DataAccessException;

	/** 根据id检查是否插入或是更新数据 */
	public Integer saveOrUpdate(E entity) throws DataAccessException;

	public boolean isUnique(E entity, String uniquePropertyNames) throws DataAccessException;
	
	/** 用于hibernate.flush() 有些dao实现不需要实现此类  */
	public void flush() throws DataAccessException;
	
	public List<E> findAll() throws DataAccessException;
	
	public Long getQueryCount(final BaseQuery query) throws DataAccessException;
	
	public Page<E> pageQuery(final Page<E> page, final BaseQuery query) throws DataAccessException;
	
	public Page<E> pageQuery(final Page<E> page, final String statement,final BaseQuery query) throws DataAccessException;
	
	public List<E> findList(final BaseQuery query) throws DataAccessException;
	
	public List<E> findList(final BaseQuery query, Integer size) throws DataAccessException;
	
	public List<E> findList(final BaseQuery query, Integer size, Integer offset) throws DataAccessException;
	
	public Integer deleteByMultipleId(List<PK> idList) throws DataAccessException;
	
	public List<E> getByMultipleId(List<PK> idList) throws DataAccessException;
}
