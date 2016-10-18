package com.mysite.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;

public interface Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, HTTPException;
}
