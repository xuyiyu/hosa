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
import com.mexp.core.exceptions.ServiceException;
import com.mexp.core.page.Page;
import com.mexp.web.dao.IDepartmentRoleRelationDao;
import com.mexp.web.model.DepartmentRoleRelation;
import com.mexp.web.service.IDepartmentRoleRelationService;
import com.mexp.web.vo.query.DepartmentRoleRelationQuery;

@Service
@Transactional
public class DepartmentRoleRelationService extends BaseService implements IDepartmentRoleRelationService {

	private static final Logger log = LoggerFactory.getLogger(DepartmentRoleRelationService.class);
	
	@Autowired
	@Qualifier("departmentRoleRelationDao")
	private IDepartmentRoleRelationDao departmentRoleRelationDao;

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.DepartmentRoleRelationQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<DepartmentRoleRelation> findPage(Page<DepartmentRoleRelation> page, DepartmentRoleRelationQuery query) {
		return departmentRoleRelationDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		return departmentRoleRelationDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return departmentRoleRelationDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#saveOrUpdate(com.lps.db.model.DepartmentRoleRelation)
	 */
	@Override
	public Integer saveOrUpdate(DepartmentRoleRelation entity) throws ServiceException {
		Integer cnt = departmentRoleRelationDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "departmentRoleRelation.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#save(com.lps.db.model.DepartmentRoleRelation)
	 */
	@Override
	public Integer save(DepartmentRoleRelation entity) throws ServiceException {
		Integer cnt = departmentRoleRelationDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "departmentRoleRelation.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#update(com.lps.db.model.DepartmentRoleRelation)
	 */
	@Override
	public Integer update(DepartmentRoleRelation entity) throws ServiceException {
		Integer cnt = departmentRoleRelationDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "departmentRoleRelation.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public DepartmentRoleRelation getById(java.lang.Long id) {
		return departmentRoleRelationDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<DepartmentRoleRelation> getByMultipleId(List<java.lang.Long> idList) {
		return departmentRoleRelationDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public DepartmentRoleRelation getByIdFromCache(java.lang.Long id) {
		return departmentRoleRelationDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#findList(com.lps.db.vo.query.DepartmentRoleRelationQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<DepartmentRoleRelation> findList(DepartmentRoleRelationQuery query) {
		return departmentRoleRelationDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#findList(com.lps.db.vo.query.DepartmentRoleRelationQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<DepartmentRoleRelation> findList(DepartmentRoleRelationQuery query, Integer size) {
		return departmentRoleRelationDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#findList(com.lps.db.vo.query.DepartmentRoleRelationQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<DepartmentRoleRelation> findList(DepartmentRoleRelationQuery query, Integer size, Integer offset) {
		return departmentRoleRelationDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentRoleRelationService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<DepartmentRoleRelation> findAllList() {
		return departmentRoleRelationDao.findAll();
	}

	
}
