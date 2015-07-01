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
import com.mexp.web.dao.IStaffRoleRelationDao;
import com.mexp.web.model.StaffRoleRelation;
import com.mexp.web.service.IStaffRoleRelationService;
import com.mexp.web.vo.query.StaffRoleRelationQuery;

@Service
@Transactional
public class StaffRoleRelationService extends BaseService implements IStaffRoleRelationService {

	private static final Logger log = LoggerFactory.getLogger(StaffRoleRelationService.class);
	
	@Autowired
	@Qualifier("staffRoleRelationDao")
	private IStaffRoleRelationDao staffRoleRelationDao;

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.StaffRoleRelationQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<StaffRoleRelation> findPage(Page<StaffRoleRelation> page, StaffRoleRelationQuery query) {
		return staffRoleRelationDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		return staffRoleRelationDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return staffRoleRelationDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#saveOrUpdate(com.lps.db.model.StaffRoleRelation)
	 */
	@Override
	public Integer saveOrUpdate(StaffRoleRelation entity) throws ServiceException {
		Integer cnt = staffRoleRelationDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "staffRoleRelation.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#save(com.lps.db.model.StaffRoleRelation)
	 */
	@Override
	public Integer save(StaffRoleRelation entity) throws ServiceException {
		Integer cnt = staffRoleRelationDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "staffRoleRelation.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#update(com.lps.db.model.StaffRoleRelation)
	 */
	@Override
	public Integer update(StaffRoleRelation entity) throws ServiceException {
		Integer cnt = staffRoleRelationDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "staffRoleRelation.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public StaffRoleRelation getById(java.lang.Long id) {
		return staffRoleRelationDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<StaffRoleRelation> getByMultipleId(List<java.lang.Long> idList) {
		return staffRoleRelationDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public StaffRoleRelation getByIdFromCache(java.lang.Long id) {
		return staffRoleRelationDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#findList(com.lps.db.vo.query.StaffRoleRelationQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<StaffRoleRelation> findList(StaffRoleRelationQuery query) {
		return staffRoleRelationDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#findList(com.lps.db.vo.query.StaffRoleRelationQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<StaffRoleRelation> findList(StaffRoleRelationQuery query, Integer size) {
		return staffRoleRelationDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#findList(com.lps.db.vo.query.StaffRoleRelationQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<StaffRoleRelation> findList(StaffRoleRelationQuery query, Integer size, Integer offset) {
		return staffRoleRelationDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffRoleRelationService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<StaffRoleRelation> findAllList() {
		return staffRoleRelationDao.findAll();
	}

	
}
