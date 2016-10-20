package com.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.DAO.GuestBookDAO;
import com.mysite.web.Action;
import com.mysite.web.util.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		String id1 = request.getParameter("id");
		Long id = Long.parseLong(id1);

		GuestBookDAO.delete(id);

		WebUtil.redirect(request, response, "/gb");
	}

}
