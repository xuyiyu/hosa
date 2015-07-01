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
import com.gaojiaoyuan.web.dao.ILocationFollowingDao;
import com.gaojiaoyuan.web.model.LocationFollowing;
import com.gaojiaoyuan.web.service.ILocationFollowingService;
import com.gaojiaoyuan.web.vo.query.LocationFollowingQuery;
import com.gaojiaoyuan.core.exceptions.ServiceException;
import com.gaojiaoyuan.core.base.BaseService;

@Service
@Transactional
public class LocationFollowingService extends BaseService implements ILocationFollowingService {

	private static final Logger log = LoggerFactory.getLogger(LocationFollowingService.class);
	
	@Autowired
	@Qualifier("locationFollowingDao")
	private ILocationFollowingDao locationFollowingDao;

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.LocationFollowingQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<LocationFollowing> findPage(Page<LocationFollowing> page, LocationFollowingQuery query) {
		return locationFollowingDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Integer> idList) throws ServiceException {
		return locationFollowingDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#deleteById(java.lang.Integer)
	 */
	@Override
	public Integer deleteById(java.lang.Integer id) throws ServiceException {
		return locationFollowingDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#saveOrUpdate(com.lps.db.model.LocationFollowing)
	 */
	@Override
	public Integer saveOrUpdate(LocationFollowing entity) throws ServiceException {
		Integer cnt = locationFollowingDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#save(com.lps.db.model.LocationFollowing)
	 */
	@Override
	public Integer save(LocationFollowing entity) throws ServiceException {
		Integer cnt = locationFollowingDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#update(com.lps.db.model.LocationFollowing)
	 */
	@Override
	public Integer update(LocationFollowing entity) throws ServiceException {
		Integer cnt = locationFollowingDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#getById(java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public LocationFollowing getById(java.lang.Integer id) {
		return locationFollowingDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<LocationFollowing> getByMultipleId(List<java.lang.Integer> idList) {
		return locationFollowingDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#getByIdFromCache(java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public LocationFollowing getByIdFromCache(java.lang.Integer id) {
		return locationFollowingDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#findList(com.lps.db.vo.query.LocationFollowingQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<LocationFollowing> findList(LocationFollowingQuery query) {
		return locationFollowingDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#findList(com.lps.db.vo.query.LocationFollowingQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<LocationFollowing> findList(LocationFollowingQuery query, Integer size) {
		return locationFollowingDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#findList(com.lps.db.vo.query.LocationFollowingQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<LocationFollowing> findList(LocationFollowingQuery query, Integer size, Integer offset) {
		return locationFollowingDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.ILocationFollowingService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<LocationFollowing> findAllList() {
		LocationFollowingQuery query = new LocationFollowingQuery();
		return locationFollowingDao.findList(query);
	}


	/*查询显示列备注
	query.setIdQueryShow(true);
	query.setLocationIdQueryShow(true);
	query.setFollowerUserIdQueryShow(true);
	query.setCreatedAtQueryShow(true);
	*/
}
