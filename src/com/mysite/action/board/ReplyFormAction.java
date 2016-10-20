package com.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.web.Action;
import com.mysite.web.util.WebUtil;

public class ReplyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		// TODO Auto-generated method stub
		String p = request.getParameter("p");
		String sNo = request.getParameter("no");
		Long no = Long.parseLong(sNo);

		request.setAttribute("p", p);
		request.setAttribute("no", no);
		try {
			WebUtil.forward(request, response, "/WEB-INF/views/board/reply.jsp");
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
