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
import com.hosa.web.dao.IImageDao;
import com.hosa.web.model.Image;
import com.hosa.web.service.IImageService;
import com.hosa.web.vo.query.ImageQuery;
import com.hosa.core.exceptions.ServiceException;
import com.hosa.core.base.BaseService;

@Service
@Transactional
public class ImageService extends BaseService implements IImageService {

	private static final Logger log = LoggerFactory.getLogger(ImageService.class);
	
	@Autowired
	@Qualifier("imageDao")
	private IImageDao imageDao;

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.ImageQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<Image> findPage(Page<Image> page, ImageQuery query) {
		return imageDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		return imageDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return imageDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#saveOrUpdate(com.lps.db.model.Image)
	 */
	@Override
	public Integer saveOrUpdate(Image entity) throws ServiceException {
		Integer cnt = imageDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#save(com.lps.db.model.Image)
	 */
	@Override
	public Integer save(Image entity) throws ServiceException {
		Integer cnt = imageDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#update(com.lps.db.model.Image)
	 */
	@Override
	public Integer update(Image entity) throws ServiceException {
		Integer cnt = imageDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "common.hasbeenmodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Image getById(java.lang.Long id) {
		return imageDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Image> getByMultipleId(List<java.lang.Long> idList) {
		return imageDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Image getByIdFromCache(java.lang.Long id) {
		return imageDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#findList(com.lps.db.vo.query.ImageQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Image> findList(ImageQuery query) {
		return imageDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#findList(com.lps.db.vo.query.ImageQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Image> findList(ImageQuery query, Integer size) {
		return imageDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#findList(com.lps.db.vo.query.ImageQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Image> findList(ImageQuery query, Integer size, Integer offset) {
		return imageDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.hosa.web.service.IImageService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Image> findAllList() {
		ImageQuery query = new ImageQuery();
		return imageDao.findList(query);
	}


	/*查询显示列备注
	query.setIdQueryShow(true);
	query.setBitmapWidthQueryShow(true);
	query.setBitmapHeightQueryShow(true);
	query.setOriginalUrlQueryShow(true);
	query.setCompressUrlQueryShow(true);
	query.setLocationNameQueryShow(true);
	query.setLongitudeQueryShow(true);
	query.setLatitudeQueryShow(true);
	query.setContentQueryShow(true);
	query.setUserIdQueryShow(true);
	query.setFavoritedCntQueryShow(true);
	query.setCommentCntQueryShow(true);
	query.setCreatedAtQueryShow(true);
	*/
}
