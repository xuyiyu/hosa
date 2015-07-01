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
import com.gaojiaoyuan.web.dao.IUserFollowingDao;
import com.gaojiaoyuan.web.model.UserFollowing;
import com.gaojiaoyuan.web.service.IUserFollowingService;
import com.gaojiaoyuan.web.vo.query.UserFollowingQuery;
import com.gaojiaoyuan.core.exceptions.ServiceException;
import com.gaojiaoyuan.core.base.BaseService;

@Service
@Transactional
public class UserFollowingService extends BaseService implements IUserFollowingService {

	private static final Logger log = LoggerFactory.getLogger(UserFollowingService.class);
	
	@Autowired
	@Qualifier("userFollowingDao")
	private IUserFollowingDao userFollowingDao;

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.UserFollowingQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<UserFollowing> findPage(Page<UserFollowing> page, UserFollowingQuery query) {
		return userFollowingDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		return userFollowingDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return userFollowingDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#saveOrUpdate(com.lps.db.model.UserFollowing)
	 */
	@Override
	public Integer saveOrUpdate(UserFollowing entity) throws ServiceException {
		Integer cnt = userFollowingDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#save(com.lps.db.model.UserFollowing)
	 */
	@Override
	public Integer save(UserFollowing entity) throws ServiceException {
		Integer cnt = userFollowingDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#update(com.lps.db.model.UserFollowing)
	 */
	@Override
	public Integer update(UserFollowing entity) throws ServiceException {
		Integer cnt = userFollowingDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public UserFollowing getById(java.lang.Long id) {
		return userFollowingDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UserFollowing> getByMultipleId(List<java.lang.Long> idList) {
		return userFollowingDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public UserFollowing getByIdFromCache(java.lang.Long id) {
		return userFollowingDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#findList(com.lps.db.vo.query.UserFollowingQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UserFollowing> findList(UserFollowingQuery query) {
		return userFollowingDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#findList(com.lps.db.vo.query.UserFollowingQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UserFollowing> findList(UserFollowingQuery query, Integer size) {
		return userFollowingDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#findList(com.lps.db.vo.query.UserFollowingQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UserFollowing> findList(UserFollowingQuery query, Integer size, Integer offset) {
		return userFollowingDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IUserFollowingService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<UserFollowing> findAllList() {
		UserFollowingQuery query = new UserFollowingQuery();
		return userFollowingDao.findList(query);
	}


	/*查询显示列备注
	query.setIdQueryShow(true);
	query.setUserIdQueryShow(true);
	query.setFollowerUserIdQueryShow(true);
	query.setCreatedAtQueryShow(true);
	*/
}
