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
import com.hosa.web.dao.IFavoriteListDao;
import com.hosa.web.model.FavoriteList;
import com.hosa.web.service.IFavoriteListService;
import com.hosa.web.vo.query.FavoriteListQuery;
import com.hosa.core.exceptions.ServiceException;
import com.hosa.core.base.BaseService;

@Service
@Transactional
public class FavoriteListService extends BaseService implements IFavoriteListService {

	private static final Logger log = LoggerFactory.getLogger(FavoriteListService.class);
	
	@Autowired
	@Qualifier("favoriteListDao")
	private IFavoriteListDao favoriteListDao;

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.FavoriteListQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<FavoriteList> findPage(Page<FavoriteList> page, FavoriteListQuery query) {
		return favoriteListDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		return favoriteListDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return favoriteListDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#saveOrUpdate(com.lps.db.model.FavoriteList)
	 */
	@Override
	public Integer saveOrUpdate(FavoriteList entity) throws ServiceException {
		Integer cnt = favoriteListDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#save(com.lps.db.model.FavoriteList)
	 */
	@Override
	public Integer save(FavoriteList entity) throws ServiceException {
		Integer cnt = favoriteListDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#update(com.lps.db.model.FavoriteList)
	 */
	@Override
	public Integer update(FavoriteList entity) throws ServiceException {
		Integer cnt = favoriteListDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public FavoriteList getById(java.lang.Long id) {
		return favoriteListDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<FavoriteList> getByMultipleId(List<java.lang.Long> idList) {
		return favoriteListDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public FavoriteList getByIdFromCache(java.lang.Long id) {
		return favoriteListDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#findList(com.lps.db.vo.query.FavoriteListQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<FavoriteList> findList(FavoriteListQuery query) {
		return favoriteListDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#findList(com.lps.db.vo.query.FavoriteListQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<FavoriteList> findList(FavoriteListQuery query, Integer size) {
		return favoriteListDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#findList(com.lps.db.vo.query.FavoriteListQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<FavoriteList> findList(FavoriteListQuery query, Integer size, Integer offset) {
		return favoriteListDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IFavoriteListService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<FavoriteList> findAllList() {
		FavoriteListQuery query = new FavoriteListQuery();
		return favoriteListDao.findList(query);
	}


	/*查询显示列备注
	query.setIdQueryShow(true);
	query.setFavoriteListIdQueryShow(true);
	query.setImageIdQueryShow(true);
	query.setCreatedAtQueryShow(true);
	*/
}
