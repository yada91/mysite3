package com.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.DAO.BoardDAO;
import com.mysite.VO.Board;
import com.mysite.web.Action;
import com.mysite.web.util.WebUtil;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		String sNo = request.getParameter("no");
		String p = request.getParameter("p");
		Long no = Long.parseLong(sNo);

		Board board = BoardDAO.view(no);
		BoardDAO.updateHits(no);
		request.setAttribute("view", board);
		request.setAttribute("p", p);
		try {
			WebUtil.forward(request, response, "/WEB-INF/views/board/view.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
