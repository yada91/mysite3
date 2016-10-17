<%@page import="com.mysite.user.VO.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite3/assets/css/user.css" rel="stylesheet"
	type="text/css">
<%
	Users users = (Users) request.getAttribute("users");
%>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		<div id="content">
			<div id="user">

				<form id="join-form" name="joinForm" method="post"
					action="/mysite3/user?a=modify">
					<input type="hidden" name="no" value="<%=users.getNo()%>">
					<label class="block-label" for="name">이름</label> <input id="name"
						name="name" type="text" value="<%=users.getName()%>"> <br />
					<strong><%=users.getEmail()%></strong> <label class="block-label">패스워드</label>
					<input name="password" type="password"
						value="<%=users.getPassword()%>">

					<fieldset>
						<legend>성별</legend>
						<%
							if ("male".equals(users.getGender())) {
						%>

						<label>여</label> <input type="radio" name="gender" value="female">
						<label>남</label> <input type="radio" name="gender" value="male"
							checked="checked">
						<%
							}
						%>
						<%
							if ("female".equals(users.getGender())) {
						%>

						<label>여</label> <input type="radio" name="gender" value="female"
							checked="checked"> <label>남</label> <input type="radio"
							name="gender" value="male">
						<%
							}
						%>
					</fieldset>

					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>

					<input type="submit" value="가입하기">

				</form>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
	</div>
</body>
</html>