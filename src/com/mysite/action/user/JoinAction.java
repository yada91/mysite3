package com.mysite.action.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.user.DAO.UsersDAO;
import com.mysite.user.VO.Users;
import com.mysite.web.Action;
import com.mysite.web.util.WebUtil;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");

		Users users = new Users();
		users.setEmail(email);
		users.setGender(gender);
		users.setName(name);
		users.setPassword(password);

		UsersDAO.insert(users);

		WebUtil.redirect(request, response, "/user?a=joinsuccess");
	}

}
