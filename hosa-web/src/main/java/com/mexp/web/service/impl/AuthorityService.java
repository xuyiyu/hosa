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
import com.mexp.web.dao.IAuthorityDao;
import com.mexp.web.model.Authority;
import com.mexp.web.service.IAuthorityService;
import com.mexp.web.vo.query.AuthorityQuery;

@Service
@Transactional
public class AuthorityService extends BaseService implements IAuthorityService {

	private static final Logger log = LoggerFactory.getLogger(AuthorityService.class);
	
	@Autowired
	@Qualifier("authorityDao")
	private IAuthorityDao authorityDao;

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.AuthorityQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<Authority> findPage(Page<Authority> page, AuthorityQuery query) {
		return authorityDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		return authorityDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return authorityDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#saveOrUpdate(com.lps.db.model.Authority)
	 */
	@Override
	public Integer saveOrUpdate(Authority entity) throws ServiceException {
		return authorityDao.saveOrUpdate(entity);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#save(com.lps.db.model.Authority)
	 */
	@Override
	public Integer save(Authority entity) throws ServiceException {
		return authorityDao.save(entity);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#update(com.lps.db.model.Authority)
	 */
	@Override
	public Integer update(Authority entity) throws ServiceException {
		return authorityDao.update(entity);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Authority getById(java.lang.Long id) {
		return authorityDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Authority> getByMultipleId(List<java.lang.Long> idList) {
		return authorityDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Authority getByIdFromCache(java.lang.Long id) {
		return authorityDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#findList(com.lps.db.vo.query.AuthorityQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Authority> findList(AuthorityQuery query) {
		return authorityDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#findList(com.lps.db.vo.query.AuthorityQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Authority> findList(AuthorityQuery query, Integer size) {
		return authorityDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#findList(com.lps.db.vo.query.AuthorityQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Authority> findList(AuthorityQuery query, Integer size, Integer offset) {
		return authorityDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IAuthorityService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Authority> findAllList() {
		return authorityDao.findAll();
	}

		/*
		 * (non-Javadoc)
		 * @see com.lps.db.service.IAuthorityService#getByMark(java.lang.String val)
		 */
		@Override
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public Authority getByMark(java.lang.String val) {
			return authorityDao.getByMark(val);
		}	
		
		/*
		 * (non-Javadoc)
		 * @see com.mexp.jilinpress.service.IAuthorityService#findListByUserId(java.lang.Long)
		 */
		@Override
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public List<Authority> findListByStaffId(Long staffId) {
			return authorityDao.findListByStaffId(staffId);
		}	
}
