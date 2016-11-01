package com.mysite.action.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

import com.mysite.DAO.UsersDAO;
import com.mysite.VO.Users;
import com.mysite.web.Action;

import net.sf.json.JSONObject;

public class APICheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException {

		String email = request.getParameter("email");

		Users vo = UsersDAO.selectNo(email);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		if (vo == null) {
			map.put("data", "not exist");
		} else {
			map.put("data", "exist");
		}

		response.setContentType("application/json; charset=utf-8");
		JSONObject jsonObject = JSONObject.fromObject(map);
		response.getWriter().println(jsonObject.toString());
	}

}
