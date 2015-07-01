/*
 * Automatically generated
 */

package com.mexp.web.service.impl;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mexp.core.base.BaseService;
import com.mexp.core.exceptions.ServiceException;
import com.mexp.core.page.Page;
import com.mexp.core.utils.ConvertUtils;
import com.mexp.core.utils.DateConvertUtils;
import com.mexp.core.utils.GB2AlphaUtils;
import com.mexp.core.utils.StringCodeUtils;
import com.mexp.web.context.ContextHolder;
import com.mexp.web.dao.IDepartmentRoleRelationDao;
import com.mexp.web.dao.IStaffDao;
import com.mexp.web.dao.IStaffRoleRelationDao;
import com.mexp.web.model.Department;
import com.mexp.web.model.DepartmentRoleRelation;
import com.mexp.web.model.Role;
import com.mexp.web.model.Staff;
import com.mexp.web.model.StaffRoleRelation;
import com.mexp.web.service.IStaffService;
import com.mexp.web.vo.query.DepartmentRoleRelationQuery;
import com.mexp.web.vo.query.StaffQuery;
import com.mexp.web.vo.query.StaffRoleRelationQuery;

@Service
@Transactional
public class StaffService extends BaseService implements IStaffService {

	private static final Logger log = LoggerFactory.getLogger(StaffService.class);
	
	@Autowired
	@Qualifier("staffDao")
	private IStaffDao staffDao;
	
	@Autowired
	@Qualifier("staffRoleRelationDao")
	private IStaffRoleRelationDao staffRoleRelationDao;
	
	@Autowired
	@Qualifier("departmentRoleRelationDao")
	private IDepartmentRoleRelationDao departmentRoleRelationDao;

	@Value("${web.context.path}")
	private String contextPath;
	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#findPage(com.lps.db.base.page.Page, com.lps.db.vo.query.StaffQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Page<Staff> findPage(Page<Staff> page, StaffQuery query) {
		Page<Staff> p = staffDao.pageQuery(page, query);
		List<Staff> list = p.getResult();
		if(!list.isEmpty()) {
			@SuppressWarnings("unchecked")
			List<Long> staffIdList = ConvertUtils.convertElementPropertyToList(list, "id");
			
			StaffRoleRelationQuery staffRoleRelationQuery = new StaffRoleRelationQuery();
			staffRoleRelationQuery.setStaffIdList(staffIdList);
			staffRoleRelationQuery.setSortColumns("id");
			List<StaffRoleRelation> staffRoleRelationList = staffRoleRelationDao.findList(staffRoleRelationQuery);
			
			List<StaffRoleRelation> tempDeleteStaffRoleRelationList = new ArrayList<StaffRoleRelation>();
			for(Staff staff: list) {
				long id = staff.getId();
				
				for(StaffRoleRelation staffRoleRelation: staffRoleRelationList) {
					long relationId = staffRoleRelation.getStaffId();
					
					if(relationId == id) {
						tempDeleteStaffRoleRelationList.add(staffRoleRelation);
						
						List<Role> roleList = staff.getRoleList();
						if(roleList == null) {
							roleList = new ArrayList<Role>();
						}
						roleList.add(staffRoleRelation.getRole());
						staff.setRoleList(roleList);
					}
					
				}
				staffRoleRelationList.removeAll(tempDeleteStaffRoleRelationList);
				
			}
		}
		return p;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#deleteByMultipleId(java.util.List)
	 */
	@Override
	public Integer deleteByMultipleId(List<java.lang.Long> idList) throws ServiceException {
		List<Long> managerDepartmentIdList = ContextHolder.get().getManagementDepartmentIdList();
		if(managerDepartmentIdList == null || managerDepartmentIdList.isEmpty()) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		List<Long> departmentIdList = staffDao.findDepartmentIdByMultipleId(idList);
		if(!managerDepartmentIdList.containsAll(departmentIdList)) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		staffRoleRelationDao.deleteByMultipleStaffId(idList);
		return staffDao.deleteByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#deleteById(java.lang.Long)
	 */
	@Override
	public Integer deleteById(java.lang.Long id) throws ServiceException {
		List<Long> managerDepartmentIdList = ContextHolder.get().getManagementDepartmentIdList();
		if(managerDepartmentIdList == null || managerDepartmentIdList.isEmpty()) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		Long departmentId = staffDao.getDepartmentIdById(id);
		if(!managerDepartmentIdList.contains(departmentId)) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		return staffDao.deleteById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#saveOrUpdate(com.lps.db.model.Staff)
	 */
	@Override
	public Integer saveOrUpdate(Staff entity) throws ServiceException {
		Integer cnt = 0;
		if(entity.getId() == null) {
			entity.setCreatedAt(DateConvertUtils.getCurrentDateTime());
			entity.setLastAccess(DateConvertUtils.getCurrentDateTime());
		}
		
		if(entity.getHeadImageUrl() == null || "".equals(entity.getHeadImageUrl())) {
			entity.setHeadImageUrl(contextPath + "/img/user.png");
		}
		
		entity.setSimpleCode(GB2AlphaUtils.getPinYinHeadChar(entity.getName()));
		
		Staff staff = staffDao.getByMobile(entity.getMobile());
		if(staff != null) {
			if(entity.getId() == null || (entity.getId() != staff.getId() && entity.getMobile().equals(staff.getMobile()))) {
				throw new ServiceException("mobile repeat", "staff.save.mobilerepeat");
			}
		}
		
		
		staff = staffDao.getByLoginId(entity.getLoginId());
		if(staff != null) {
			if(entity.getId() == null || (entity.getId() != staff.getId() && entity.getLoginId().equals(staff.getLoginId()))) {
				throw new ServiceException("loginId repeat", "staff.save.loginIdrepeat");
			}
		}
		
		if("".equals(entity.getPassword())) {
			entity.setPassword(null);
		}
		if(entity.getPassword() != null) {
			String pass = "";
			try {
				pass = StringCodeUtils.sha1(entity.getPassword());
				entity.setPassword(pass);
			} catch (NoSuchAlgorithmException e) {
				throw new ServiceException("Password conversion error.", "staff.save.passwordconversionerror");
			}
			
		}
		
		cnt = staffDao.saveOrUpdate(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "staff.save.dataisnotsavedormodified");
		}
		//添加角色
		List<Long> newRoleIdList = entity.getRoleIdList();
		if(newRoleIdList == null) {
			newRoleIdList = new ArrayList<Long>();
		}
		List<Long> managerDepartmentIdList = ContextHolder.get().getManagementDepartmentIdList();
		if(managerDepartmentIdList == null || managerDepartmentIdList.isEmpty()) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		Long departmentId = staffDao.getDepartmentIdById(entity.getId());
		if(!managerDepartmentIdList.contains(departmentId)) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		
		DepartmentRoleRelationQuery departmentRoleRelationQuery = new DepartmentRoleRelationQuery();
		departmentRoleRelationQuery.setDepartmentIdList(managerDepartmentIdList);
		List<DepartmentRoleRelation> departmentRoleRelationList = departmentRoleRelationDao.findList(departmentRoleRelationQuery);
		if(!newRoleIdList.isEmpty() && (departmentRoleRelationList == null || departmentRoleRelationList.isEmpty())) {
			throw new ServiceException("illegal role", "staff.save.illegalrole");
		}
		@SuppressWarnings("unchecked")
		List<Long> managerDepartmentRoleIdList = ConvertUtils.convertElementPropertyToList(departmentRoleRelationList, "roleId");
		if(!managerDepartmentRoleIdList.containsAll(newRoleIdList)) {
			throw new ServiceException("illegal role", "staff.save.illegalrole");
		}
		
		StaffRoleRelationQuery staffRoleRelationQuery = new StaffRoleRelationQuery();
		staffRoleRelationQuery.setStaffId(entity.getId());
		List<StaffRoleRelation> staffRoleRelationList = staffRoleRelationDao.findList(staffRoleRelationQuery);
		List<Long> deleteStaffRoleRelationIdList = new ArrayList<Long>();
		List<Long> tempDeleteRoleIdList = new ArrayList<Long>();
		for(StaffRoleRelation staffRoleRelation: staffRoleRelationList) {
			long relationId = staffRoleRelation.getId();
			long roleId = staffRoleRelation.getRoleId();
			if(newRoleIdList.contains(roleId)) {
				newRoleIdList.remove(roleId);
			} else {
				deleteStaffRoleRelationIdList.add(relationId);
				tempDeleteRoleIdList.add(roleId);
			}	
		}
		
		for(Long newRoleId: newRoleIdList) {
			StaffRoleRelation relation = new StaffRoleRelation();
			relation.setStaffId(entity.getId());
			relation.setRoleId(newRoleId);
			staffRoleRelationDao.save(relation);
		}
		
		if(!deleteStaffRoleRelationIdList.isEmpty()) {
			staffRoleRelationDao.deleteByMultipleId(deleteStaffRoleRelationIdList);
		}

		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#save(com.lps.db.model.Staff)
	 */
	@Override
	public Integer save(Staff entity) throws ServiceException {
		Integer cnt = staffDao.save(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "staff.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#update(com.lps.db.model.Staff)
	 */
	@Override
	public Integer update(Staff entity) throws ServiceException {
		List<Long> managerDepartmentIdList = ContextHolder.get().getManagementDepartmentIdList();
		if(managerDepartmentIdList == null || managerDepartmentIdList.isEmpty()) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		Long departmentId = staffDao.getDepartmentIdById(entity.getId());
		if(!managerDepartmentIdList.contains(departmentId)) {
			throw new ServiceException("illegal operation", "common.illegaloperation");
		}
		Integer cnt = staffDao.update(entity);
		if(cnt == 0) {
			throw new ServiceException("data is not saved or modified", "staff.save.dataisnotsavedormodified");
		}
		return cnt;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#getById(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Staff getById(java.lang.Long id) {
		Staff staff = staffDao.getById(id);
		if(staff != null) {
			StaffRoleRelationQuery staffRoleRelationQuery = new StaffRoleRelationQuery();
			staffRoleRelationQuery.setStaffId(id);
			List<StaffRoleRelation> staffRoleRelationList = staffRoleRelationDao.findList(staffRoleRelationQuery);
			@SuppressWarnings("unchecked")
			List<Long> roleIdList = ConvertUtils.convertElementPropertyToList(staffRoleRelationList, "roleId");
			
			staff.setRoleIdList(roleIdList);
		}
		
		return staff;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#getByMultipleId(java.util.List)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Staff> getByMultipleId(List<java.lang.Long> idList) {
		return staffDao.getByMultipleId(idList);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#getByIdFromCache(java.lang.Long)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public Staff getByIdFromCache(java.lang.Long id) {
		return staffDao.getById(id);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#findList(com.lps.db.vo.query.StaffQuery)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Staff> findList(StaffQuery query) {
		return staffDao.findList(query);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#findList(com.lps.db.vo.query.StaffQuery, int)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Staff> findList(StaffQuery query, Integer size) {
		return staffDao.findList(query, size);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#findList(com.lps.db.vo.query.StaffQuery, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Staff> findList(StaffQuery query, Integer size, Integer offset) {
		return staffDao.findList(query, size, offset);
	}

	/*
	 * (non-Javadoc)
	 * @see com.lps.db.service.IStaffService#findAllList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Staff> findAllList() {
		return staffDao.findAll();
	}

		/*
		 * (non-Javadoc)
		 * @see com.lps.db.service.IStaffService#getByMobile(java.lang.String val)
		 */
		@Override
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public Staff getByMobile(java.lang.String val) {
			return staffDao.getByMobile(val);
		}	
		
		/*
		 * (non-Javadoc)
		 * @see com.lps.db.service.IStaffService#getByLoginId(java.lang.String val)
		 */
		@Override
		@Transactional(propagation=Propagation.NOT_SUPPORTED)
		public Staff getByLoginId(java.lang.String val) {
			return staffDao.getByLoginId(val);
		}	
		
		@Override
		public void savePassword(Staff entity) throws ServiceException {
			Staff staff = staffDao.getById(entity.getId());
			if(staff != null) {
				String pass = "";
				try {
					pass = StringCodeUtils.sha1(entity.getPassword());
				} catch (NoSuchAlgorithmException e) {
					throw new ServiceException("Password conversion error.", "staff.savePassword.passwordconversionerror");
				}
				if(!pass.equals(staff.getPassword())) {
					throw new ServiceException("Original password wrong", "staff.savePassword.originalpasswordwrong");
				}
				String newPass = "";
				try {
					newPass = StringCodeUtils.sha1(entity.getNewPassword());
					entity.setPassword(newPass);
					staffDao.update(entity);
				} catch (NoSuchAlgorithmException e) {
					throw new ServiceException("Password conversion error.", "staff.savePassword.passwordconversionerror");
				}
				
			} else {
				throw new ServiceException("not found staff", "staff.savePassword.notfoundstaff");
			}
		}
}
