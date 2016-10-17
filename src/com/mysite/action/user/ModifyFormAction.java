package com.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

import com.mysite.user.DAO.UsersDAO;
import com.mysite.user.VO.Users;
import com.mysites3.web.Action;
import com.mysites3.web.util.WebUtil;

public class ModifyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		HttpSession session = request.getSession();
		Users authUser = (Users) session.getAttribute("authUser");

		Users users = UsersDAO.selectNo(authUser.getNo());

		request.setAttribute("users", users);

		try {
			WebUtil.forward(request, response, "/WEB-INF/views/user/modifyform.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
