package com.mysite.action.guestbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.DAO.GuestBookDAO;
import com.mysite.VO.GuestBook;
import com.mysite.web.Action;

import net.sf.json.JSONObject;

public class AjaxListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		String sPage = request.getParameter("p");
		int page;
		if ("".equals(sPage)) {
			page = 1;
		} else {
			page = Integer.parseInt(sPage);
		}

		List<GuestBook> list = GuestBookDAO.selectAll(page);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("data", list);

		response.setContentType("application/json; charset=utf-8");
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.getWriter().println(jsonObject.toString());
	}

}
