package com.hosa.web.service.security.filter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hosa.core.utils.ConvertUtils;
import com.hosa.web.model.Authority;
import com.hosa.web.service.IAuthorityService;
import com.hosa.web.vo.query.AuthorityQuery;



public class AuthorityFilter {

	@Autowired
	@Qualifier("authorityService")
	private IAuthorityService authorityService;
	
	public AuthorityFilter() {
		
	}
	
	public String loadAllAuthority() {
		AuthorityQuery query = new AuthorityQuery();
		query.setSortColumns("sort asc");
		List<Authority> authorityList = authorityService.findList(query);
		@SuppressWarnings("unchecked")
		List<String> keysList = ConvertUtils.convertElementPropertyToList(authorityList, "chain");
		String keys = StringUtils.join(keysList, "\n");
		StringBuffer buffer = new StringBuffer();
		buffer.append("\n");
		buffer.append("/webadmin/main* = authc, roles[auth-main]");
		buffer.append("\n");
		buffer.append("/webadmin/menu* = authc, roles[auth-menu]");
		buffer.append("\n");
		buffer.append("/webadmin/logout* = authc, roles[auth-logout]");
		buffer.append("\n");
		buffer.append("/webadmin/upload* = authc, roles[auth-upload]");
		buffer.append("\n");
		buffer.append("/webadmin/savePassword* = authc, roles[auth-modifyPassword]");
		buffer.append("\n");
		buffer.append("/webadmin/** = authc, roles[auth-all]");
		buffer.append("\n");
		keys += buffer.toString();
		return keys;
	}
}
