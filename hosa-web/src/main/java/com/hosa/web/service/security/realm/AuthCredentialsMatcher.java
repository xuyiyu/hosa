package com.hosa.web.service.security.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;


public class AuthCredentialsMatcher extends SimpleCredentialsMatcher{

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		
//		 Object tokenCredentials = StringCodeUtils.encode(new String((char[])getCredentials(token)));
		Object tokenCredentials = getCredentials(token);
	     Object accountCredentials = getCredentials(info);
	     return equals(tokenCredentials, accountCredentials);
	}

}
