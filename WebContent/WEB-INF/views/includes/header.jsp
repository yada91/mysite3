<%@page import="com.mysite.user.VO.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Users user = (Users) session.getAttribute("authUser");
%>
<div id="header">
	<h1>MySite</h1>
	<ul>
		<%
			if (user == null) {
		%>
		<li><a href="/mysite3/user?a=loginform">로그인</a>
		<li>
		<li><a href="/mysite3/user?a=joinform">회원가입</a>
		<li>
			<%
				} else {
			%>
		
		<li><a href="/mysite3/user?a=modifyform">회원정보수정</a>
		<li>
		<li><a href="/mysite3/user?a=logout">로그아웃</a>
		<li>
		<li><%=user.getName()%>님 안녕하세요 ^^;</li>
		<%
			}
		%>
	</ul>
</div>