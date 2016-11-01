package com.mysite.action.guestbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.DAO.GuestBookDAO;
import com.mysite.VO.GuestBook;
import com.mysite.web.Action;

import net.sf.json.JSONObject;

public class AjaxDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		String name = request.getParameter("name");
		String password = request.getParameter("pw");
		String sId = request.getParameter("id");
		Long id;
		if ("".equals(sId) || "undefined".equals(sId)) {
			id = 1L;
		} else {
			id = Long.parseLong(sId);
		}
		GuestBook gb = new GuestBook();
		gb.setName(name);
		gb.setPassword(password);
		gb.setId(id);

		boolean flag = GuestBookDAO.delete(gb);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		if (flag == true) {
			map.put("data", "yes");
		} else {
			map.put("data", "no");
		}

		response.setContentType("application/json; charset=utf-8");
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.getWriter().println(jsonObject.toString());
	}

}
