package com.hosa.web.internal.cometd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cometd.server.CometdServlet;



public class JSONCometdServlet extends CometdServlet{
	
	private static final long serialVersionUID = -3536635771671530223L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		super.service(request, response);
	}

}
