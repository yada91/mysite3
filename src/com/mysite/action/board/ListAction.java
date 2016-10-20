package com.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.DAO.BoardDAO;
import com.mysite.VO.Page;
import com.mysite.web.Action;
import com.mysite.web.util.WebUtil;

public class ListAction implements Action {

	final int LISTSIZE = 5;
	final int PAGESIZE = 5;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		String p = request.getParameter("p");
		String l = request.getParameter("l");

		double total = BoardDAO.count();
		int lastPage = (int) Math.ceil(total / (double) PAGESIZE);

		Page page = new Page();
		page.setListSize(LISTSIZE);
		page.setPageSize(PAGESIZE);
		page.setLastPage(lastPage);

		if (p == null || "".equals(p)) {
			int currentPage = 1;
			page.setCurrentPage(currentPage);
		} else {
			int currentPage = Integer.parseInt(p);
			page.setCurrentPage(currentPage);
		}

		if (l == null || "".equals(l)) {
			int startPage = 1;
			page.setStartPage(startPage);
		} else {
			int startPage = Integer.parseInt(p);
			page.setStartPage(startPage);
		}
		
		request.setAttribute("total", (int) total);
		request.setAttribute("list", BoardDAO.select(page));
		request.setAttribute("page", page);
		try {
			WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
