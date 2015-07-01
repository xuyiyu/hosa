package com.hosa.web.service.security;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UserToken extends UsernamePasswordToken {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6499632107955151537L;
	
	public UserToken() {
		super();
	}

	public UserToken(String username, String password, boolean rememberMe) {
		super(username, password, rememberMe);
	}

	
}
