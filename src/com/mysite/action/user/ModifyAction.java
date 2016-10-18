package com.mysite.action.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

import com.mysite.user.DAO.UsersDAO;
import com.mysite.user.VO.Users;
import com.mysite.web.Action;
import com.mysite.web.util.WebUtil;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		String sNo = request.getParameter("no");
		Long no = Long.parseLong(sNo);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");

		if (password.equals("")) {
			Users users = new Users();
			users.setName(name);
			users.setGender(gender);
			users.setPassword(password);
			users.setNo(no);
			UsersDAO.update(users);
		} else {
			Users users = new Users();
			users.setName(name);
			users.setGender(gender);
			users.setNo(no);
			UsersDAO.update(users, password);
		}

		Users authUser = (Users) request.getSession().getAttribute("authUser");
		authUser.setName(name);
		request.getSession().setAttribute("authUser", authUser);

		WebUtil.redirect(request, response, "/user?a=modifyform&result=success");
	}

}
