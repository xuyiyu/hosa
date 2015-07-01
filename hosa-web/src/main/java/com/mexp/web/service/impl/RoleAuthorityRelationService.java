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
import com.mexp.web.dao.IRoleAuthorityRelationDao;
import com.mexp.web.model.RoleAuthorityRelation;
import com.mexp.web.service.IRoleAuthorityRelationService;
import com.mexp.web.vo.query.RoleAuthorityRelationQuery;

@Service
@Transactional
public class RoleAuthorityRelationService extends BaseService implements IRoleAuthorityRelationService {

	private static final Logger log = LoggerFactory.getLogger(RoleAuthorityRelationService.class);
	
	@Autowired
	@Qualifier("roleAuthorityRelationDao")
	private IRoleAuthorityRelationDao roleAuthorityRelationDao;

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.RoleAuthorityRelationQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<RoleAuthorityRelation> findPage(Page<RoleAuthorityRelation> page, RoleAuthorityRelationQuery query) {
		return roleAuthorityRelationDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		return roleAuthorityRelationDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return roleAuthorityRelationDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#saveOrUpdate(com.lps.db.model.RoleAuthorityRelation)
	 */
	@Override
	public Integer saveOrUpdate(RoleAuthorityRelation entity) throws ServiceException {
		Integer cnt = roleAuthorityRelationDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "roleAuthorityRelation.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#save(com.lps.db.model.RoleAuthorityRelation)
	 */
	@Override
	public Integer save(RoleAuthorityRelation entity) throws ServiceException {
		Integer cnt = roleAuthorityRelationDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "roleAuthorityRelation.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#update(com.lps.db.model.RoleAuthorityRelation)
	 */
	@Override
	public Integer update(RoleAuthorityRelation entity) throws ServiceException {
		Integer cnt = roleAuthorityRelationDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "roleAuthorityRelation.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public RoleAuthorityRelation getById(java.lang.Long id) {
		return roleAuthorityRelationDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<RoleAuthorityRelation> getByMultipleId(List<java.lang.Long> idList) {
		return roleAuthorityRelationDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public RoleAuthorityRelation getByIdFromCache(java.lang.Long id) {
		return roleAuthorityRelationDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#findList(com.lps.db.vo.query.RoleAuthorityRelationQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<RoleAuthorityRelation> findList(RoleAuthorityRelationQuery query) {
		return roleAuthorityRelationDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#findList(com.lps.db.vo.query.RoleAuthorityRelationQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<RoleAuthorityRelation> findList(RoleAuthorityRelationQuery query, Integer size) {
		return roleAuthorityRelationDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#findList(com.lps.db.vo.query.RoleAuthorityRelationQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<RoleAuthorityRelation> findList(RoleAuthorityRelationQuery query, Integer size, Integer offset) {
		return roleAuthorityRelationDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleAuthorityRelationService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<RoleAuthorityRelation> findAllList() {
		return roleAuthorityRelationDao.findAll();
	}

	
}
