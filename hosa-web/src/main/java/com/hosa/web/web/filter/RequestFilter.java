package com.hosa.web.web.filter;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hosa.core.utils.DateConvertUtils;
import com.hosa.core.utils.StringCodeUtils;

public class RequestFilter implements Filter {

	private final static Logger logger = LoggerFactory.getLogger(RequestFilter.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
	    HttpServletResponse response = (HttpServletResponse) arg1;
		Date currentDate = DateConvertUtils.getCurrentDateTime();
//	    Date expires = DateConvertUtils.add(currentDate, Calendar.MINUTE, 5);
	    String webToken = StringCodeUtils.encode(currentDate.getTime()+"");
		request.setAttribute("authenticity_token", webToken);
	   
	    chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
