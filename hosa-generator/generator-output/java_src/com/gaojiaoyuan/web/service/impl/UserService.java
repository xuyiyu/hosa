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
import com.gaojiaoyuan.web.dao.IUserDao;
import com.gaojiaoyuan.web.model.User;
import com.gaojiaoyuan.web.service.IUserService;
import com.gaojiaoyuan.web.vo.query.UserQuery;
import com.gaojiaoyuan.core.exceptions.ServiceException;
import com.gaojiaoyuan.core.base.BaseService;

@Service
@Transactional
public class UserService extends BaseService implements IUserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	@Qualifier("userDao")
	private IUserDao userDao;

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.UserQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<User> findPage(Page<User> page, UserQuery query) {
		return userDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		return userDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return userDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#saveOrUpdate(com.lps.db.model.User)
	 */
	@Override
	public Integer saveOrUpdate(User entity) throws ServiceException {
		Integer cnt = userDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#save(com.lps.db.model.User)
	 */
	@Override
	public Integer save(User entity) throws ServiceException {
		Integer cnt = userDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#update(com.lps.db.model.User)
	 */
	@Override
	public Integer update(User entity) throws ServiceException {
		Integer cnt = userDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public User getById(java.lang.Long id) {
		return userDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<User> getByMultipleId(List<java.lang.Long> idList) {
		return userDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public User getByIdFromCache(java.lang.Long id) {
		return userDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#findList(com.lps.db.vo.query.UserQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<User> findList(UserQuery query) {
		return userDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#findList(com.lps.db.vo.query.UserQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<User> findList(UserQuery query, Integer size) {
		return userDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#findList(com.lps.db.vo.query.UserQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<User> findList(UserQuery query, Integer size, Integer offset) {
		return userDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<User> findAllList() {
		UserQuery query = new UserQuery();
		return userDao.findList(query);
	}


	/*查询显示列备注
	query.setIdQueryShow(true);
	query.setNickQueryShow(true);
	query.setPortraitUrlQueryShow(true);
	query.setFollowerQueryShow(true);
	query.setUserFollowingQueryShow(true);
	query.setLocationFollowingQueryShow(true);
	query.setBriefDescriptionQueryShow(true);
	query.setImageCntQueryShow(true);
	query.setPraisingCntQueryShow(true);
	query.setPraisedCntQueryShow(true);
	query.setNotifiyCntQueryShow(true);
	query.setCreatedAtQueryShow(true);
	*/
}
