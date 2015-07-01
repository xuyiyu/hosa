package com.hosa.web.service;

import com.hosa.core.exceptions.ServiceException;

public interface ILoginService {

	public void login(String username, String password, Boolean rememberMe) throws ServiceException;

}
