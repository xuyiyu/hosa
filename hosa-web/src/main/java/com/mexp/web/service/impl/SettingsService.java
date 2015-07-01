/*
 * Automatically generated
 */

package com.mexp.web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mexp.core.base.BaseService;
import com.mexp.core.cache.Memcached;
import com.mexp.core.cache.MemcachedManager;
import com.mexp.core.exceptions.ServiceException;
import com.mexp.core.page.Page;
import com.mexp.web.Constant;
import com.mexp.web.context.ContextHolder;
import com.mexp.web.dao.ISettingsDao;
import com.mexp.web.model.Settings;
import com.mexp.web.service.ISettingsService;
import com.mexp.web.vo.query.SettingsQuery;

@Service
@Transactional
public class SettingsService extends BaseService implements ISettingsService {

	private static final Logger log = LoggerFactory.getLogger(SettingsService.class);
	
	@Autowired
	@Qualifier("settingsDao")
	private ISettingsDao settingsDao;
	
	@Autowired
	private MemcachedManager memcachedManager;

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.SettingsQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<Settings> findPage(Page<Settings> page, SettingsQuery query) {
		return settingsDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		return settingsDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return settingsDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#saveOrUpdate(com.lps.db.model.Settings)
	 */
	@Override
	public Integer saveOrUpdate(Settings entity) throws ServiceException {
		Integer cnt = settingsDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "settings.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#save(com.lps.db.model.Settings)
	 */
	@Override
	public Integer save(Settings entity) throws ServiceException {
		Integer cnt = settingsDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "settings.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#update(com.lps.db.model.Settings)
	 */
	@Override
	public Integer update(Settings entity) throws ServiceException {
		Integer cnt = settingsDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "settings.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Settings getById(java.lang.Long id) {
		return settingsDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Settings> getByMultipleId(List<java.lang.Long> idList) {
		return settingsDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Settings getByIdFromCache(java.lang.Long id) {
		return settingsDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#findList(com.lps.db.vo.query.SettingsQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Settings> findList(SettingsQuery query) {
		return settingsDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#findList(com.lps.db.vo.query.SettingsQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Settings> findList(SettingsQuery query, Integer size) {
		return settingsDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#findList(com.lps.db.vo.query.SettingsQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Settings> findList(SettingsQuery query, Integer size, Integer offset) {
		return settingsDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.ISettingsService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Settings> findAllList() {
		return settingsDao.findAll();
	}

	@Override
	public Settings getByVariable(String val) {
		Long departmentId = ContextHolder.get().getRootDepartmentId();
		return settingsDao.getByVariableAndDepartmentId(departmentId, val);
	}
	
	public Settings getByVariable(java.lang.Long departmentId ,java.lang.String val){
		return settingsDao.getByVariableAndDepartmentId(departmentId, val);
	}

	@Override
	public String getByVariableFromCache(String variable) {
		Long departmentId = ContextHolder.get().getRootDepartmentId();
		Memcached cache = memcachedManager.getCache(Constant.CACHE_POOL_SETTINGS);
		StringBuilder key = new StringBuilder();
		key.append(departmentId + "_" + variable);
		String val = "";
		if(cache != null) {
			val = cache.get(key.toString());
		}
		
		if(val == null || "".equals(val)) {
			Settings settings = settingsDao.getByVariableAndDepartmentId(departmentId, variable);
			if(settings != null) {
				val = settings.getVal();
				
				if(cache != null && val != null) {
					cache.put(key.toString(), val);
				}
			}
		}
		return val;
	}

	@Override
	public void saveVariableToCache(Settings entity) {
		Long departmentId = ContextHolder.get().getRootDepartmentId();
		if(entity.getDepartmentId() != departmentId.longValue()) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		Settings settings = settingsDao.getByVariableAndDepartmentId(departmentId, entity.getVariable());
		if(settings == null) {
			settings = new Settings();
			settings.setDepartmentId(departmentId);
			settings.setVariable(entity.getVariable());
		} else {
			settings.setModified(entity.getModified());
		}
		
		settings.setVal(entity.getVal());
		int cnt = settingsDao.saveOrUpdate(settings);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "settings.save.dataisnotsavedormodified");
		}
		
		Memcached cache = memcachedManager.getCache(Constant.CACHE_POOL_SETTINGS);
		StringBuilder key = new StringBuilder();
		key.append(departmentId + "_" + settings.getVariable());
		if(cache != null) {
			cache.put(key.toString(), settings.getVal());
		}
	}

	
}
