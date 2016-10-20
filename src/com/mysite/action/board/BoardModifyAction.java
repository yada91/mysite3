package com.mysite.action.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.DAO.BoardDAO;
import com.mysite.VO.Board;
import com.mysite.web.Action;
import com.mysite.web.util.WebUtil;

public class BoardModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String p = request.getParameter("p");
		String sNo = request.getParameter("no");
		Long no = Long.parseLong(sNo);

		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setNo(no);

		BoardDAO.update(board);
		WebUtil.redirect(request, response, "/board?a=view&no=" + no + "&p=" + p);
	}

}
