package com.mysite.action.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPException;

import com.mysite.DAO.BoardDAO;
import com.mysite.VO.Board;
import com.mysite.VO.Users;
import com.mysite.web.Action;
import com.mysite.web.util.WebUtil;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String p = request.getParameter("p");

		HttpSession session = request.getSession();
		Users authUser = (Users) session.getAttribute("authUser");

		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setUser_no(authUser.getNo());

		BoardDAO.insert(board);

		WebUtil.redirect(request, response, "/board?p=" + p);

	}

}
