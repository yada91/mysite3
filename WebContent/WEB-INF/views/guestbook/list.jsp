<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link
	href="${pageContext.request.contextPath }/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<div id="wrapper">
			<div id="content">
				<div id="guestbook">
					<form action="${pageContext.request.contextPath }/gb" method="post">
						<input type="hidden" name="a" value="insert">
						<table border=1 width=500>
							<tr>
								<td>이름</td>
								<td><input type="text" name="name"></td>
								<td>비밀번호</td>
								<td><input type="password" name="password"></td>
							</tr>
							<tr>
								<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
							</tr>
							<tr>
								<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
							</tr>
						</table>
					</form>
					<br>

					<c:forEach items="${list }" var="vo">
						<table width=510 border=1>
							<tr>
								<td>[${vo.rank }]</td>
								<td>${vo.name }</td>
								<td>${vo.regdate }</td>
								<td><a
									href="${pageContext.request.contextPath }/gb?a=deleteform&id=${vo.id}">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4>${vo.content}</td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</div>
			<c:import url="/WEB-INF/views/includes/navigation.jsp">
				<c:param name="menu" value="guestbook"></c:param>
			</c:import>
			<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		</div>
</body>
</html>