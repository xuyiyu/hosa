/*
 * Automatically generated
 */

package com.hosa.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hosa.core.base.BaseService;
import com.hosa.core.exceptions.ServiceException;
import com.hosa.core.page.Page;
import com.hosa.core.utils.ConvertUtils;
import com.hosa.core.utils.DateConvertUtils;
import com.hosa.core.utils.GB2AlphaUtils;
import com.hosa.web.Constant;
import com.hosa.web.context.ContextHolder;
import com.hosa.web.dao.IDepartmentDao;
import com.hosa.web.dao.IDepartmentRoleRelationDao;
import com.hosa.web.dao.IStaffDao;
import com.hosa.web.dao.IStaffRoleRelationDao;
import com.hosa.web.model.Department;
import com.hosa.web.model.DepartmentRoleRelation;
import com.hosa.web.model.Role;
import com.hosa.web.model.Staff;
import com.hosa.web.service.IDepartmentService;
import com.hosa.web.vo.query.DepartmentQuery;
import com.hosa.web.vo.query.DepartmentRoleRelationQuery;
import com.hosa.web.vo.query.StaffQuery;

@Service
@Transactional
public class DepartmentService extends BaseService implements IDepartmentService {

	private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	@Qualifier("departmentDao")
	private IDepartmentDao departmentDao;

	@Autowired
	@Qualifier("departmentRoleRelationDao")
	private IDepartmentRoleRelationDao departmentRoleRelationDao;
	
	@Autowired
	@Qualifier("staffRoleRelationDao")
	private IStaffRoleRelationDao staffRoleRelationDao;
	
	@Autowired
	@Qualifier("staffDao")
	private IStaffDao staffDao;
	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.DepartmentQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<Department> findPage(Page<Department> page, DepartmentQuery query) {
		return departmentDao.pageQuery(page, query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		
		List<Long> managerDepartmentIdList = ContextHolder.get().getManagementDepartmentIdList();
		if(managerDepartmentIdList == null || managerDepartmentIdList.isEmpty()) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		if(!idList.isEmpty() && !managerDepartmentIdList.containsAll(idList)) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		
		DepartmentQuery departmentQuery = new DepartmentQuery();
		departmentQuery.setParentIdList(idList);
		List<Department> subDepartmentList = departmentDao.findList(departmentQuery);
		if(!subDepartmentList.isEmpty()) {
			throw new ServiceException("There subordinate departments can not be deleted.", "department.delete.theresubordinatedepartmentscannotbedeleted");
		}
		StaffQuery staffQuery = new StaffQuery();
		staffQuery.setDepartmentIdList(idList);
		List<Staff> subStaffList = staffDao.findList(staffQuery);
		if(!subStaffList.isEmpty()) {
			throw new ServiceException("Employees can not be deleted under.", "department.delete.employeescannotbedeletedunder");
		}
		
		departmentRoleRelationDao.deleteByMultipleDepartmentId(idList);
		return departmentDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		List<Long> managerDepartmentIdList = ContextHolder.get().getManagementDepartmentIdList();
		if(managerDepartmentIdList == null || managerDepartmentIdList.isEmpty()) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		if(id != null && !managerDepartmentIdList.contains(id)) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		return departmentDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#saveOrUpdate(com.lps.db.model.Department)
	 */
	@Override
	public Integer saveOrUpdate(Department entity) throws ServiceException {
		Integer cnt = 0;
		StringBuilder parentLevel = new StringBuilder();
		List<Long> managerDepartmentIdList = ContextHolder.get().getManagementDepartmentIdList();
		if(managerDepartmentIdList == null || managerDepartmentIdList.isEmpty()) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		if(entity.getId() != null && !managerDepartmentIdList.contains(entity.getId())) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		
		Long parentId = entity.getParentId();
		if(entity.getId() == null) {
			parentLevel.append(departmentDao.getById(entity.getParentId()).getLevel());
			entity.setLevel("");
			entity.setCreatedAt(DateConvertUtils.getCurrentDateTime());
			
		} else {
			
			entity.setParentId(null);
		}
		Department department = departmentDao.getByNameAndParentId(entity.getName(), parentId);
		if(department != null && department.getId().longValue() != entity.getId()) {
			throw new ServiceException("name repeat", "department.save.namerepeat");
		}
		
		entity.setSimpleCode(GB2AlphaUtils.getPinYinHeadChar(entity.getName()));

		cnt = departmentDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "department.save.dataisnotsavedormodified");
		}
		
		List<Long> newRoleIdList = entity.getRoleIdList();
		if(newRoleIdList == null) {
			newRoleIdList = new ArrayList<Long>();
		}
		if(parentLevel.length() > 0) {
			parentLevel.append(entity.getId());
			parentLevel.append(Constant.LEVEL_SEPARATOR);
			
			Department d = departmentDao.getById(entity.getId());
			d.setLevel(parentLevel.toString());
			Integer cnt1 = departmentDao.update(d);
			if(cnt1 == 0) {
				throw new ServiceException("data is not saved or modified", "department.save.dataisnotsavedormodified");
			}
		} else {
			entity = departmentDao.getById(entity.getId());
		}

		
		
		
		DepartmentRoleRelationQuery departmentRoleRelationQuery = new DepartmentRoleRelationQuery();
		departmentRoleRelationQuery.setDepartmentIdList(managerDepartmentIdList);
		List<DepartmentRoleRelation> departmentRoleRelationList = departmentRoleRelationDao.findList(departmentRoleRelationQuery);
		if(!newRoleIdList.isEmpty() && (departmentRoleRelationList == null || departmentRoleRelationList.isEmpty())) {
			throw new ServiceException("illegal role", "department.save.illegalrole");
		}
		@SuppressWarnings("unchecked")
		List<Long> managerDepartmentRoleIdList = ConvertUtils.convertElementPropertyToList(departmentRoleRelationList, "roleId");
		if(!managerDepartmentRoleIdList.containsAll(newRoleIdList)) {
			throw new ServiceException("illegal role", "department.save.illegalrole");
		}
		
		
		departmentRoleRelationQuery = new DepartmentRoleRelationQuery();
		departmentRoleRelationQuery.setDepartmentId(entity.getId());
		departmentRoleRelationList = departmentRoleRelationDao.findList(departmentRoleRelationQuery);
		List<Long> deleteDepartmentRoleRelationIdList = new ArrayList<Long>();
		List<Long> tempDeleteRoleIdList = new ArrayList<Long>();
		for(DepartmentRoleRelation departmentRoleRelation: departmentRoleRelationList) {
			long relationId = departmentRoleRelation.getId();
			long roleId = departmentRoleRelation.getRoleId();
			if(newRoleIdList.contains(roleId)) {
				newRoleIdList.remove(roleId);
			} else {
				deleteDepartmentRoleRelationIdList.add(relationId);
				tempDeleteRoleIdList.add(roleId);
			}	
		}
		
		for(Long newRoleId: newRoleIdList) {
			DepartmentRoleRelation relation = new DepartmentRoleRelation();
			relation.setDepartmentId(entity.getId());
			relation.setRoleId(newRoleId);
			departmentRoleRelationDao.save(relation);
		}
		
//		if(!deleteDepartmentRoleRelationIdList.isEmpty()) {
//			departmentRoleRelationDao.deleteByMultipleId(deleteDepartmentRoleRelationIdList);
//		}
		if(!tempDeleteRoleIdList.isEmpty()) {
			//删除该部门和子部门角色
			DepartmentQuery departmentQuery = new DepartmentQuery();
			departmentQuery.setLevelBeginLike(entity.getLevel());
			List<Department> subDepartmentList = departmentDao.findList(departmentQuery);
			@SuppressWarnings("unchecked")
			List<Long> subDepartmentIdList = ConvertUtils.convertElementPropertyToList(subDepartmentList, "id");
			departmentRoleRelationDao.deleteByMultipleDepartmentIdAndMultipleRoleId(subDepartmentIdList, tempDeleteRoleIdList);
			
			//删除部门下员工角色
			staffRoleRelationDao.deleteByMultipleDepartmentIdAndMultipleRoleId(subDepartmentIdList, tempDeleteRoleIdList);
		}
		
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#save(com.lps.db.model.Department)
	 */
	@Override
	public Integer save(Department entity) throws ServiceException {
		Integer cnt = departmentDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "department.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#update(com.lps.db.model.Department)
	 */
	@Override
	public Integer update(Department entity) throws ServiceException {
		List<Long> managerDepartmentIdList = ContextHolder.get().getManagementDepartmentIdList();
		if(managerDepartmentIdList == null || managerDepartmentIdList.isEmpty()) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		if(entity.getId() != null && !managerDepartmentIdList.contains(entity.getId())) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		
		Integer cnt = departmentDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "department.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Department getById(java.lang.Long id) {
		Department department = departmentDao.getById(id);
		if(department != null) {
			DepartmentRoleRelationQuery departmentRoleRelationQuery = new DepartmentRoleRelationQuery();
			departmentRoleRelationQuery.setDepartmentId(id);
			List<DepartmentRoleRelation> departmentRoleRelationList = departmentRoleRelationDao.findList(departmentRoleRelationQuery);
			@SuppressWarnings("unchecked")
			List<Long> roleIdList = ConvertUtils.convertElementPropertyToList(departmentRoleRelationList, "roleId");
			
			department.setRoleIdList(roleIdList);
		}
		
		
		return department;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Department> getByMultipleId(List<java.lang.Long> idList) {
		return departmentDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Department getByIdFromCache(java.lang.Long id) {
		return departmentDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#findList(com.lps.db.vo.query.DepartmentQuery)
	 */
	@Override
	//@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Department> findList(DepartmentQuery query) {
		
		List<Department> departmentList = departmentDao.findList(query);
		
		@SuppressWarnings("unchecked")
		List<Long> departmentIdList = ConvertUtils.convertElementPropertyToList(departmentList, "id");
		
		DepartmentRoleRelationQuery departmentRoleRelationQuery = new DepartmentRoleRelationQuery();
		departmentRoleRelationQuery.setDepartmentIdList(departmentIdList);
		departmentRoleRelationQuery.setSortColumns("id");
		List<DepartmentRoleRelation> departmentRoleRelationList = departmentRoleRelationDao.findList(departmentRoleRelationQuery);
		
		List<DepartmentRoleRelation> tempDeleteDepartmentRoleRelationList = new ArrayList<DepartmentRoleRelation>();
		for(Department department: departmentList) {
			long id = department.getId();
			
			for(DepartmentRoleRelation departmentRoleRelation: departmentRoleRelationList) {
				long relationDepartmentId = departmentRoleRelation.getDepartmentId();
				
				if(relationDepartmentId == id) {
					tempDeleteDepartmentRoleRelationList.add(departmentRoleRelation);
					
					List<Role> roleList = department.getRoleList();
					if(roleList == null) {
						roleList = new ArrayList<Role>();
					}
					roleList.add(departmentRoleRelation.getRole());
					department.setRoleList(roleList);
				}
				
			}
			departmentRoleRelationList.removeAll(tempDeleteDepartmentRoleRelationList);
			
		}
		return departmentList;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#findList(com.lps.db.vo.query.DepartmentQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Department> findList(DepartmentQuery query, Integer size) {
		return departmentDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#findList(com.lps.db.vo.query.DepartmentQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Department> findList(DepartmentQuery query, Integer size, Integer offset) {
		return departmentDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IDepartmentService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Department> findAllList() {
		return departmentDao.findAll();
	}

		/*
		 * (non-Javadoc)
		 * @see com.lps.db.service.IDepartmentService#getByLevel(java.lang.String val)
		 */
		@Override
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public Department getByLevel(java.lang.String val) {
			return departmentDao.getByLevel(val);
		}	
		
		/*
		 * (non-Javadoc)
		 * @see com.hosa.jilinpress.service.IDepartmentService#getByNameAndParentId(java.lang.String, java.lang.String)
		 */
		@Override
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public Department getByNameAndParentId(java.lang.String name, java.lang.Long parentId) {
			return departmentDao.getByNameAndParentId(name, parentId);
		}

		@Override
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public List<Department> findManagementDepartmentById(Long id) {
			Department department = departmentDao.getById(id);
			DepartmentQuery departmentQuery = new DepartmentQuery();
			departmentQuery.setLevelBeginLike(department.getLevel());
			departmentQuery.setSortColumns("level asc");
			List<Department> managementDepartmentList = departmentDao.findList(departmentQuery);
			return managementDepartmentList;
		}

		@Override
		public Department getRootDepartment(Long id) {
			Department department = departmentDao.getById(id);
			String level = department.getLevel();
			String[] levels = level.split("-");
			StringBuilder rootLevel = new StringBuilder();
			for(int i=0; i< levels.length; i++) {
				rootLevel.append(levels[i]);
				rootLevel.append("-");
				if(i == 2){
					break;
				}
				
			}

			department = departmentDao.getByLevel(rootLevel.toString());
			
			return department;
		}
}
