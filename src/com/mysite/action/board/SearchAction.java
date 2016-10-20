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

public class SearchAction implements Action {
	final int LISTSIZE = 5;
	final int PAGESIZE = 5;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		String p = request.getParameter("p");
		String l = request.getParameter("l");
		String kwd = request.getParameter("kwd");

		double total;
		int lastPage;
		Page page = new Page();
		page.setListSize(LISTSIZE);
		page.setPageSize(PAGESIZE);

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

		if (kwd == null || "".equals(kwd)) {
			total = BoardDAO.count();
			lastPage = (int) Math.ceil(total / (double) PAGESIZE);

			page.setLastPage(lastPage);
			request.setAttribute("list", BoardDAO.select(page));
		} else {
			kwd = "%" + kwd + "%";
			total = BoardDAO.searchCount(kwd);
			lastPage = (int) Math.ceil(total / (double) PAGESIZE);

			page.setLastPage(lastPage);
			request.setAttribute("list", BoardDAO.search(page, kwd));
		}
		request.setAttribute("page", page);
		request.setAttribute("total", (int) total);
		try {
			WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
