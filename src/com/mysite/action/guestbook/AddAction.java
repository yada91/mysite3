package com.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.DAO.GuestBookDAO;
import com.mysite.VO.GuestBook;
import com.mysite.web.Action;
import com.mysite.web.util.WebUtil;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		GuestBook gb = new GuestBook();
		gb.setName(name);
		gb.setPassword(password);
		gb.setContent(content);
		GuestBookDAO.insert(gb);

		WebUtil.redirect(request, response, "/gb");
	}

}
