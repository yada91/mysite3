package com.mysite.action.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

import com.mysite.user.DAO.UsersDAO;
import com.mysite.user.VO.Users;
import com.mysites3.web.Action;
import com.mysites3.web.util.WebUtil;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		String sNo = request.getParameter("no");
		Long no = Long.parseLong(sNo);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");

		Users users = new Users();
		users.setName(name);
		users.setGender(gender);
		users.setNo(no);
		users.setPassword(password);
		UsersDAO.update(users);

		// 세션 재 호출
		Users authUser = new Users();
		authUser.setName(name);
		authUser.setNo(no);
		
		HttpSession session = request.getSession();
		session.setAttribute("authUser", authUser);

		WebUtil.redirect(request, response, "/mysite3/main");
	}

}
