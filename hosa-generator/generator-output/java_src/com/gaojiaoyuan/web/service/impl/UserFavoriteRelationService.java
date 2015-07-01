/*
 * Automatically generated
 */

package com.gaojiaoyuan.web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gaojiaoyuan.core.exceptions.ServiceException;

import com.gaojiaoyuan.core.exceptions.ServiceException;

import com.gaojiaoyuan.core.page.Page;
import com.gaojiaoyuan.web.dao.IUserFavoriteRelationDao;
import com.gaojiaoyuan.web.model.UserFavoriteRelation;
import com.gaojiaoyuan.web.service.IUserFavoriteRelationService;
import com.gaojiaoyuan.web.vo.query.UserFavoriteRelationQuery;
import com.gaojiaoyuan.core.exceptions.ServiceException;
import com.gaojiaoyuan.core.base.BaseService;

@Service
@Transactional
public class UserFavoriteRelationService extends BaseService implements IUserFavoriteRelationService {

	private static final Logger log = LoggerFactory.getLogger(UserFavoriteRelationService.class);
	
	@Autowired
	@Qualifier("userFavoriteRelationDao")
	private IUserFavoriteRelationDao userFavoriteRelationDao;

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.UserFavoriteRelationQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<UserFavoriteRelation> findPage(Page<UserFavoriteRelation> page, UserFavoriteRelationQuery query) {
		return userFavoriteRelationDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		return userFavoriteRelationDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return userFavoriteRelationDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#saveOrUpdate(com.lps.db.model.UserFavoriteRelation)
	 */
	@Override
	public Integer saveOrUpdate(UserFavoriteRelation entity) throws ServiceException {
		Integer cnt = userFavoriteRelationDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#save(com.lps.db.model.UserFavoriteRelation)
	 */
	@Override
	public Integer save(UserFavoriteRelation entity) throws ServiceException {
		Integer cnt = userFavoriteRelationDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#update(com.lps.db.model.UserFavoriteRelation)
	 */
	@Override
	public Integer update(UserFavoriteRelation entity) throws ServiceException {
		Integer cnt = userFavoriteRelationDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public UserFavoriteRelation getById(java.lang.Long id) {
		return userFavoriteRelationDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UserFavoriteRelation> getByMultipleId(List<java.lang.Long> idList) {
		return userFavoriteRelationDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public UserFavoriteRelation getByIdFromCache(java.lang.Long id) {
		return userFavoriteRelationDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#findList(com.lps.db.vo.query.UserFavoriteRelationQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UserFavoriteRelation> findList(UserFavoriteRelationQuery query) {
		return userFavoriteRelationDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#findList(com.lps.db.vo.query.UserFavoriteRelationQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UserFavoriteRelation> findList(UserFavoriteRelationQuery query, Integer size) {
		return userFavoriteRelationDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#findList(com.lps.db.vo.query.UserFavoriteRelationQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UserFavoriteRelation> findList(UserFavoriteRelationQuery query, Integer size, Integer offset) {
		return userFavoriteRelationDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFavoriteRelationService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UserFavoriteRelation> findAllList() {
		UserFavoriteRelationQuery query = new UserFavoriteRelationQuery();
		return userFavoriteRelationDao.findList(query);
	}


	/*查询显示列备注
	query.setIdQueryShow(true);
	query.setUserIdQueryShow(true);
	query.setFavoriteIdQueryShow(true);
	query.setCreatedAtQueryShow(true);
	*/
}
