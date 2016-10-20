package com.mysite.action.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.DAO.GuestBookDAO;
import com.mysite.VO.GuestBook;
import com.mysite.web.Action;
import com.mysite.web.util.WebUtil;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub

		List<GuestBook> list = GuestBookDAO.selectAll();

		request.setAttribute("list", list);

		try {
			WebUtil.forward(request, response, "/WEB-INF/views/guestbook/list.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
