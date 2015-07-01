package com.hosa.web.service.security;

import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import com.hosa.web.service.security.filter.AuthorityFilter;

public class ShiroFilterFactory extends ShiroFilterFactoryBean {

	
	private AuthorityFilter authorityFilter;
	
	public ShiroFilterFactory() {
		super();
		
	}
	
	private void initFilterChainDefinition() {
		String filterChainDefinitions = authorityFilter.loadAllAuthority();
		Map<String, String> authorityMap = getFilterChainDefinitionMap();
		this.setFilterChainDefinitions(filterChainDefinitions);
		authorityMap.putAll(getFilterChainDefinitionMap());
		this.setFilterChainDefinitionMap(authorityMap);
	}

	public void setAuthorityFilter(AuthorityFilter authorityFilter) {
		this.authorityFilter = authorityFilter;
		initFilterChainDefinition();
	}

}
