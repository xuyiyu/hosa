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
import com.gaojiaoyuan.web.dao.IFavoriteDao;
import com.gaojiaoyuan.web.model.Favorite;
import com.gaojiaoyuan.web.service.IFavoriteService;
import com.gaojiaoyuan.web.vo.query.FavoriteQuery;
import com.gaojiaoyuan.core.exceptions.ServiceException;
import com.gaojiaoyuan.core.base.BaseService;

@Service
@Transactional
public class FavoriteService extends BaseService implements IFavoriteService {

	private static final Logger log = LoggerFactory.getLogger(FavoriteService.class);
	
	@Autowired
	@Qualifier("favoriteDao")
	private IFavoriteDao favoriteDao;

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.FavoriteQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<Favorite> findPage(Page<Favorite> page, FavoriteQuery query) {
		return favoriteDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		return favoriteDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return favoriteDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#saveOrUpdate(com.lps.db.model.Favorite)
	 */
	@Override
	public Integer saveOrUpdate(Favorite entity) throws ServiceException {
		Integer cnt = favoriteDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#save(com.lps.db.model.Favorite)
	 */
	@Override
	public Integer save(Favorite entity) throws ServiceException {
		Integer cnt = favoriteDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#update(com.lps.db.model.Favorite)
	 */
	@Override
	public Integer update(Favorite entity) throws ServiceException {
		Integer cnt = favoriteDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Favorite getById(java.lang.Long id) {
		return favoriteDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Favorite> getByMultipleId(List<java.lang.Long> idList) {
		return favoriteDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Favorite getByIdFromCache(java.lang.Long id) {
		return favoriteDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#findList(com.lps.db.vo.query.FavoriteQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Favorite> findList(FavoriteQuery query) {
		return favoriteDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#findList(com.lps.db.vo.query.FavoriteQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Favorite> findList(FavoriteQuery query, Integer size) {
		return favoriteDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#findList(com.lps.db.vo.query.FavoriteQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Favorite> findList(FavoriteQuery query, Integer size, Integer offset) {
		return favoriteDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.gaojiaoyuan.web.service.IFavoriteService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Favorite> findAllList() {
		FavoriteQuery query = new FavoriteQuery();
		return favoriteDao.findList(query);
	}


	/*查询显示列备注
	query.setIdQueryShow(true);
	query.setNameQueryShow(true);
	query.setFavoriteCntQueryShow(true);
	query.setCreatedAtQueryShow(true);
	*/
}
