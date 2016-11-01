package com.mysite.controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysite.VO.Users;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/ajax")
public class AjaxTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		/*
		 * { "name": "안대혁", "message" : "hello; }
		 */

		List<Users> list = new ArrayList<Users>();

		Users vo = new Users();
		vo.setNo(10L);
		vo.setName("안대혁");
		vo.setEmail("nap@nate.com");
		vo.setGender("male");
		list.add(vo);

		Users vo1 = new Users();
		vo1.setNo(11L);
		vo1.setName("둘리");
		vo1.setEmail("둘리@nate.com");
		vo1.setGender("male");
		list.add(vo1);

		PrintWriter out = response.getWriter();
		// JSONObject jsonObject = JSONObject.fromObject(vo);
		JSONArray jsonArray = JSONArray.fromObject(list);
		out.println(jsonArray);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
