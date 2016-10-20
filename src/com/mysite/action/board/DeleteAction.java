package com.mysite.action.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.DAO.BoardDAO;
import com.mysite.web.Action;
import com.mysite.web.util.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		String sNo = request.getParameter("no");
		String p = request.getParameter("p");
		Long no = Long.parseLong(sNo);

		BoardDAO.delete(no);

		WebUtil.redirect(request, response, "/board?p=" + p);
	}

}
