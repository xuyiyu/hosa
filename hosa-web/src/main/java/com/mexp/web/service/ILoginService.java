package com.mexp.web.service;

import com.mexp.core.exceptions.ServiceException;

public interface ILoginService {

	public void login(String username, String password, Boolean rememberMe) throws ServiceException;

}
