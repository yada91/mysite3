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

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Users users = UsersDAO.selectNo(email, password);
		if (users == null) {
			WebUtil.redirect(request, response, "/mysite3/user?a=loginform&result=fail");
			return; // 주의: redirect를 한 후 다음 코드가 실행 되지 않도록 함수 종료
		}

		// false or 빈 파라미터 - jsessionid 와 연결된 sseion 객체가 없으면 null
		// true- jsessionid 와 연결된 session 객체가 없으면 만들어서 리턴
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", users);

		WebUtil.redirect(request, response, "/mysite3/main");
	}

}
