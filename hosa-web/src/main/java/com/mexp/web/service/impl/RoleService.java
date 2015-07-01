/*
 * Automatically generated
 */

package com.mexp.web.service.impl;

import java.util.ArrayList;
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
import com.mexp.core.utils.ConvertUtils;
import com.mexp.web.dao.IDepartmentRoleRelationDao;
import com.mexp.web.dao.IRoleAuthorityRelationDao;
import com.mexp.web.dao.IRoleDao;
import com.mexp.web.dao.IStaffRoleRelationDao;
import com.mexp.web.model.Authority;
import com.mexp.web.model.DepartmentRoleRelation;
import com.mexp.web.model.Role;
import com.mexp.web.model.RoleAuthorityRelation;
import com.mexp.web.model.StaffRoleRelation;
import com.mexp.web.service.IRoleService;
import com.mexp.web.vo.query.DepartmentRoleRelationQuery;
import com.mexp.web.vo.query.RoleAuthorityRelationQuery;
import com.mexp.web.vo.query.RoleQuery;
import com.mexp.web.vo.query.StaffRoleRelationQuery;

@Service
@Transactional
public class RoleService extends BaseService implements IRoleService {

	private static final Logger log = LoggerFactory.getLogger(RoleService.class);
	
	@Autowired
	@Qualifier("roleDao")
	private IRoleDao roleDao;

	
	@Autowired
	@Qualifier("roleAuthorityRelationDao")
	private IRoleAuthorityRelationDao roleAuthorityRelationDao;
	
	@Autowired
	@Qualifier("staffRoleRelationDao")
	private IStaffRoleRelationDao staffRoleRelationDao;
	
	@Autowired
	@Qualifier("departmentRoleRelationDao")
	private IDepartmentRoleRelationDao departmentRoleRelationDao;
	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.RoleQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<Role> findPage(Page<Role> page, RoleQuery query) {
		return roleDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		if(idList.contains(1)) {
			throw new ServiceException("Contains super role can not be deleted", "role.delete.containssuperrolecannotbedeleted");
		}
		
		DepartmentRoleRelationQuery departmentRoleRelationQuery = new DepartmentRoleRelationQuery();
		departmentRoleRelationQuery.setRoleIdList(idList);
		List<DepartmentRoleRelation> departmentRoleList = departmentRoleRelationDao.findList(departmentRoleRelationQuery);
		if(!departmentRoleList.isEmpty()) {
			throw new ServiceException("Roles have been used can not be deleted", "role.delete.Roleshavebeenusedcannotbedeleted");
		}
		
		StaffRoleRelationQuery staffRoleRelationQuery = new StaffRoleRelationQuery();
		staffRoleRelationQuery.setRoleIdList(idList);
		List<StaffRoleRelation> staffRoleList = staffRoleRelationDao.findList(staffRoleRelationQuery);
		if(!staffRoleList.isEmpty()) {
			throw new ServiceException("Roles have been used can not be deleted", "role.delete.Roleshavebeenusedcannotbedeleted");
		}
		
		RoleAuthorityRelationQuery roleAuthorityRelationQuery = new RoleAuthorityRelationQuery();
		roleAuthorityRelationQuery.setRoleIdList(idList);
		List<RoleAuthorityRelation> roleAuthorityRelationList = roleAuthorityRelationDao.findList(roleAuthorityRelationQuery);
		
		if(!roleAuthorityRelationList.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Long> roleAuthorityRelationIdList = ConvertUtils.convertElementPropertyToList(roleAuthorityRelationList, "id");
			roleAuthorityRelationDao.deleteByMultipleId(roleAuthorityRelationIdList);
		}
		
		return roleDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		return roleDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#saveOrUpdate(com.lps.db.model.Role)
	 */
	@Override
	public Integer saveOrUpdate(Role entity) throws ServiceException {
		Integer cnt = 0;
		Role role = roleDao.getByName(entity.getName());
		if(role != null) {
			if(entity.getId() == null || role.getId().longValue() != entity.getId())
			throw new ServiceException("name repeat", "role.save.namerepeat");
		}
		cnt = roleDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "role.save.dataisnotsavedormodified");
		}
		List<Long> newAuthorityIdList = entity.getAuthorityIdList();
		if(newAuthorityIdList == null) {
			newAuthorityIdList = new ArrayList<Long>();
		}
		RoleAuthorityRelationQuery roleAuthorityQuery = new RoleAuthorityRelationQuery();
		roleAuthorityQuery.setRoleId(entity.getId());
		List<RoleAuthorityRelation> roleAuthorityRelationList = roleAuthorityRelationDao.findList(roleAuthorityQuery);
		List<Long> deleteRoleAuthorityIdList = new ArrayList<Long>();
		for(RoleAuthorityRelation roleAuthorityRelation: roleAuthorityRelationList) {
			long roleAuthorityId = roleAuthorityRelation.getId();
			long authorityId = roleAuthorityRelation.getAuthorityId();
			if(newAuthorityIdList.contains(authorityId)) {
				newAuthorityIdList.remove(authorityId);
			} else {
				deleteRoleAuthorityIdList.add(roleAuthorityId);
			}	
		}
		if(!deleteRoleAuthorityIdList.isEmpty()) {
			roleAuthorityRelationDao.deleteByMultipleId(deleteRoleAuthorityIdList);
		}
		
		
		for(Long newAuthorityId: newAuthorityIdList) {
			RoleAuthorityRelation ra = new RoleAuthorityRelation();
			ra.setRoleId(entity.getId());
			ra.setAuthorityId(newAuthorityId);
			roleAuthorityRelationDao.save(ra);
		}
		
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#save(com.lps.db.model.Role)
	 */
	@Override
	public Integer save(Role entity) throws ServiceException {
		Integer cnt = roleDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "role.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#update(com.lps.db.model.Role)
	 */
	@Override
	public Integer update(Role entity) throws ServiceException {
		Integer cnt = roleDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "role.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Role getById(java.lang.Long id) {
		Role role = roleDao.getById(id);
		if(role != null) {
			RoleAuthorityRelationQuery roleAuthorityQuery = new RoleAuthorityRelationQuery();
			roleAuthorityQuery.setRoleId(id);
			List<RoleAuthorityRelation> roleAuthorityRelationList = roleAuthorityRelationDao.findList(roleAuthorityQuery);
			List<Long> authorityIdList = ConvertUtils.convertElementPropertyToList(roleAuthorityRelationList, "authorityId");
			
			role.setAuthorityIdList(authorityIdList);
		}
		
		
		return role;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Role> getByMultipleId(List<java.lang.Long> idList) {
		return roleDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Role getByIdFromCache(java.lang.Long id) {
		return roleDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#findList(com.lps.db.vo.query.RoleQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Role> findList(RoleQuery query) {
		List<Role> roleList = roleDao.findList(query);
		
		@SuppressWarnings("unchecked")
		List<Long> roleIdList = ConvertUtils.convertElementPropertyToList(roleList, "id");
		
		RoleAuthorityRelationQuery roleAuthorityRelationQuery = new RoleAuthorityRelationQuery();
		roleAuthorityRelationQuery.setRoleIdList(roleIdList);
		roleAuthorityRelationQuery.setSortColumns("id");
		List<RoleAuthorityRelation> roleAuthorityRelationList = roleAuthorityRelationDao.findList(roleAuthorityRelationQuery);
		
		List<RoleAuthorityRelation> tempDeleteRoleAuthorityRelationList = new ArrayList<RoleAuthorityRelation>();
		for(Role role: roleList) {
			long id = role.getId();
			
			for(RoleAuthorityRelation roleAuthorityRelation: roleAuthorityRelationList) {
				long relationId = roleAuthorityRelation.getRoleId();
				
				if(relationId == id) {
					tempDeleteRoleAuthorityRelationList.add(roleAuthorityRelation);
					
					List<Authority> authorityList = role.getAuthorityList();
					if(authorityList == null) {
						authorityList = new ArrayList<Authority>();
					}
					authorityList.add(roleAuthorityRelation.getAuthority());
					role.setAuthorityList(authorityList);
				}
				
			}
			roleAuthorityRelationList.removeAll(tempDeleteRoleAuthorityRelationList);
			
		}
		
		return roleList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#findList(com.lps.db.vo.query.RoleQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Role> findList(RoleQuery query, Integer size) {
		return roleDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#findList(com.lps.db.vo.query.RoleQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Role> findList(RoleQuery query, Integer size, Integer offset) {
		return roleDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IRoleService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Role> findAllList() {
		return roleDao.findAll();
	}

		/*
		 * (non-Javadoc)
		 * @see com.lps.db.service.IRoleService#getByName(java.lang.String val)
		 */
		@Override
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public Role getByName(java.lang.String val) {
			return roleDao.getByName(val);
		}	
		
	
}
