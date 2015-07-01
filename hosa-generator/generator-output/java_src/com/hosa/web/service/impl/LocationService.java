/*
 * Automatically generated
 */

package com.hosa.web.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hosa.core.exceptions.ServiceException;

import com.hosa.core.exceptions.ServiceException;

import com.hosa.core.page.Page;
import com.hosa.web.dao.ILocationDao;
import com.hosa.web.model.Location;
import com.hosa.web.service.ILocationService;
import com.hosa.web.vo.query.LocationQuery;
import com.hosa.core.exceptions.ServiceException;
import com.hosa.core.base.BaseService;

@Service
@Transactional
public class LocationService extends BaseService implements ILocationService {

	private static final Logger log = LoggerFactory.getLogger(LocationService.class);
	
	@Autowired
	@Qualifier("locationDao")
	private ILocationDao locationDao;

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.LocationQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<Location> findPage(Page<Location> page, LocationQuery query) {
		return locationDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		return locationDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return locationDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#saveOrUpdate(com.lps.db.model.Location)
	 */
	@Override
	public Integer saveOrUpdate(Location entity) throws ServiceException {
		Integer cnt = locationDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#save(com.lps.db.model.Location)
	 */
	@Override
	public Integer save(Location entity) throws ServiceException {
		Integer cnt = locationDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#update(com.lps.db.model.Location)
	 */
	@Override
	public Integer update(Location entity) throws ServiceException {
		Integer cnt = locationDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Location getById(java.lang.Long id) {
		return locationDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Location> getByMultipleId(List<java.lang.Long> idList) {
		return locationDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Location getByIdFromCache(java.lang.Long id) {
		return locationDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#findList(com.lps.db.vo.query.LocationQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Location> findList(LocationQuery query) {
		return locationDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#findList(com.lps.db.vo.query.LocationQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Location> findList(LocationQuery query, Integer size) {
		return locationDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#findList(com.lps.db.vo.query.LocationQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Location> findList(LocationQuery query, Integer size, Integer offset) {
		return locationDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.ILocationService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Location> findAllList() {
		LocationQuery query = new LocationQuery();
		return locationDao.findList(query);
	}


	/*查询显示列备注
	query.setIdQueryShow(true);
	query.setNameQueryShow(true);
	query.setTypeQueryShow(true);
	query.setFollowerQueryShow(true);
	query.setImageCntQueryShow(true);
	query.setFavoritedCntQueryShow(true);
	query.setCreatedAtQueryShow(true);
	*/
}
