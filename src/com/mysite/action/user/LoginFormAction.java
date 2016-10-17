package com.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysites3.web.Action;
import com.mysites3.web.util.WebUtil;

public class LoginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		try {
			WebUtil.forward(request, response, "/WEB-INF/views/user/loginform.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
