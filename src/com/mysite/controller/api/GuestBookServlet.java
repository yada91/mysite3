package com.mysite.controller.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysite.action.guestbook.GuestbookActionFactory;
import com.mysite.web.Action;
import com.mysite.web.ActionFactory;

@WebServlet(name = "GuestBookAPIServlet", urlPatterns = { "/api/gb" })
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String actionName = request.getParameter("a");

		ActionFactory af = new GuestbookActionFactory();
		Action a = af.getAction(actionName);
		a.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
