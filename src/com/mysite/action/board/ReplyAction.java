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

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		String p = request.getParameter("p");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String sNo = request.getParameter("no");
		Long no = Long.parseLong(sNo);

		HttpSession session = request.getSession();
		Users authUser = (Users) session.getAttribute("authUser");

		Board board = BoardDAO.replyView(no);

		Board reBoard = new Board();
		reBoard.setContent(content);
		reBoard.setTitle(title);
		reBoard.setUser_no(authUser.getNo());
		reBoard.setGroup_no(board.getGroup_no());
		reBoard.setDepth(board.getDepth() + 1);
		reBoard.setOrder_no(board.getOrder_no() + 1);

		BoardDAO.updateReply(reBoard);
		BoardDAO.insertReply(reBoard);

		WebUtil.redirect(request, response, "/board?p=" + p);
	}

}
