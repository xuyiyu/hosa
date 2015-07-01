<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign classNameLowerCase = className?lower_case> 
<#assign idColumnLower = table.idColumn.columnName?uncap_first> 
package ${basepackage}${projectpackage}.web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

import ${basepackage}${projectpackage}.web.action.WebActionSupport;
import ${basepackage}${projectpackage}.service.I${className}Service;
import ${basepackage}.core.page.Page;
import ${basepackage}${projectpackage}.model.${className};
import ${basepackage}${projectpackage}.vo.query.${className}Query;
import ${basepackage}.core.exceptions.ServiceException;

@Namespace("/webadmin/${classNameLowerCase}")
@Scope("prototype")
public class ${className}Action extends WebActionSupport {

	/**
	 * 
	 */
	private static final Logger log = LoggerFactory.getLogger(${className}Action.class);

	@Autowired
	@Qualifier("${classNameLower}Service")
	private I${className}Service ${classNameLower}Service;
	
	private ${table.idColumn.javaType} id;
	
	private Page<${className}> page;
	
	private ${className}Query ${classNameLower}Query;
	
	private List<${table.idColumn.javaType}> checkedIdList;
	
	private ${className} ${classNameLower};
	

	/**
	 * 列表
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/${classNameLowerCase}/list")
	public String list() throws Exception {
		try {
			if(page == null) {
				page = new Page<${className}>();
			}
			if (!page.isOrderBySetted()) {
				<#list table.compositeIdColumns as column>
		        	page.setOrderBy("${column.sqlName}");
					page.setOrder(Page.DESC);
		     	</#list>
				
			}
			if(${classNameLower}Query == null) {
				${classNameLower}Query = new ${className}Query();
			}
			page = ${classNameLower}Service.findPage(page, ${classNameLower}Query);
			responseSuccessJson(page, "${classNameLowerCase}.label.${classNameLowerCase}", "common.list.success");
			
		} catch(ServiceException ex) {
			log.warn("list fail.", ex);
			responseServiceErrorJson(getCommonListErrorInfo("${classNameLowerCase}.label.${classNameLowerCase}", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("list error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}
	
	/**
	 * 删除
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/${classNameLowerCase}/delete/save")
	public String delete() throws Exception {
		try {
			
			${classNameLower}Service.deleteByMultipleId(checkedIdList);
			responseSuccessJson(checkedIdList, "${classNameLowerCase}.label.${classNameLowerCase}", "common.delete.success");			
		} catch(ServiceException ex) {
			log.warn("delete fail.", ex);
			responseServiceErrorJson(getCommonDeleteErrorInfo("${classNameLowerCase}.label.${classNameLowerCase}", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("delete error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}
	
	/**
	 * 新增保存
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/${classNameLowerCase}/add/save")
	public String add() throws Exception {
		try {			
			${classNameLower}Service.save(${classNameLower});
			responseSuccessJson(${classNameLower}, "${classNameLowerCase}.label.${classNameLowerCase}", "common.add.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonAddErrorInfo("${classNameLowerCase}.label.${classNameLowerCase}", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}
	
	/**
	 * 修改保存
	 * @return
	 * @throws Exception
	 */
	@Action(value="/webadmin/${classNameLowerCase}/edit/save")
	public String edit() throws Exception {
		try {			
			${classNameLower}Service.update(${classNameLower});
			responseSuccessJson(${classNameLower}, "${classNameLowerCase}.label.${classNameLowerCase}", "common.edit.success");			
		} catch(ServiceException ex) {
			log.warn("save fail.", ex);
			responseServiceErrorJson(getCommonEditErrorInfo("${classNameLowerCase}.label.${classNameLowerCase}", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("save error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	@Action(value="/webadmin/${classNameLowerCase}/input")
	public String input() throws Exception {
		try {
			${classNameLower} = new ${className}();
			if(id != null) {
				${classNameLower} = ${classNameLower}Service.getById(id);
			}
			responseSuccessJson(${classNameLower}, "${classNameLowerCase}.label.${classNameLowerCase}", "common.input.success");			
		} catch(ServiceException ex) {
			log.warn("input fail.", ex);
			responseServiceErrorJson(getCommonInputErrorInfo("${classNameLowerCase}.label.${classNameLowerCase}", ex.getErrorCode()));
		} catch(Exception e) {
			log.error("input error.", e);
			responseSystemErrorJson(getCommonErrorInfo());
		}
		
		return null;
	}

	
	
	public ${table.idColumn.javaType} getId() {
		return id;
	}

	public void setId(${table.idColumn.javaType} id) {
		this.id = id;
	}

	public Page<${className}> getPage() {
		return page;
	}

	public void setPage(Page<${className}> page) {
		this.page = page;
	}

	public void set${className}Query(${className}Query ${classNameLower}Query) {
		this.${classNameLower}Query = ${classNameLower}Query;
	}

	public ${className}Query get${className}Query() {
		return ${classNameLower}Query;
	}

	public List<${table.idColumn.javaType}> getCheckedIdList() {
		return checkedIdList;
	}

	public void setCheckedIdList(List<${table.idColumn.javaType}> checkedIdList) {
		this.checkedIdList = checkedIdList;
	}

	public ${className} get${className}() {
		return ${classNameLower};
	}

	public void set${className}(${className} ${classNameLower}) {
		this.${classNameLower} = ${classNameLower};
	}
	
	

}
