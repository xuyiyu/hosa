package com.mexp.web.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mexp.core.exceptions.ServiceException;
import com.mexp.core.utils.StringCodeUtils;
import com.mexp.web.model.Staff;
import com.mexp.web.service.ILoginService;
import com.mexp.web.service.security.UserToken;


@Service
@Transactional
public class LoginService implements ILoginService{

	private static final Logger log = LoggerFactory.getLogger(LoginService.class);
	
	/*
	 * (non-Javadoc)
	 * @see com.mexp.jiuzhai.service.ILoginService#login(java.lang.String, java.lang.String, java.lang.Boolean)
	 */
	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void login(String username, String password, Boolean rememberMe) throws ServiceException {

		try{
			Staff staff = (Staff)SecurityUtils.getSubject().getPrincipal();
			
//			if(user != null) {
//				throw new ServiceException("login.failure.alreadylogin");	
//			}
			
			password = StringCodeUtils.sha1(password);
			UserToken token = new UserToken(username, password, rememberMe);
			
			SecurityUtils.getSubject().login(token);
			
			
			
//			Long currentDateTime = System.currentTimeMillis();
			
			log.debug(" login successful");
		} catch(ServiceException e) {
			log.error("login failure.", e);
			throw new ServiceException(e);
		} catch(AuthenticationException e) {
			log.error("login failure.", e);
			throw new ServiceException("login failure", "login.failure");
		} catch(Exception e) {
			log.error("login error.", e);
			throw new ServiceException("common error", "common.error");
		}
		
	}
}
