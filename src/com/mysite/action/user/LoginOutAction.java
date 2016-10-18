package com.mysite.action.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.xml.ws.http.HTTPException;

import com.mysite.user.VO.Users;
import com.mysite.web.Action;
import com.mysite.web.util.WebUtil;

public class LoginOutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session == null) {
			WebUtil.redirect(request, response, "/main");
			return;
		}

		Users user = (Users) session.getAttribute("authUser");
		if (user != null) {
			session.removeAttribute("authUser");
			session.invalidate();

		}
		WebUtil.redirect(request, response, "/main");
	}

}
