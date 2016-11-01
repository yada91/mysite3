package com.mysite.action.guestbook;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.DAO.GuestBookDAO;
import com.mysite.DAO.UsersDAO;
import com.mysite.VO.GuestBook;
import com.mysite.VO.Users;
import com.mysite.web.Action;

import net.sf.json.JSONObject;

public class AjaxAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {
		String name = request.getParameter("name");
		String password = request.getParameter("pw");
		String content = request.getParameter("ct");

		GuestBook gb = new GuestBook();
		gb.setName(name);
		gb.setPassword(password);
		gb.setContent(content);
		Long id = GuestBookDAO.insert(gb);
		GuestBook newGb = GuestBookDAO.get(id);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		if (newGb == null) {
			map.put("data", "not exist");
		} else {
			map.put("data", newGb);
		}

		response.setContentType("application/json; charset=utf-8");
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.getWriter().println(jsonObject.toString());

	}

}
