<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="start" value="${page.startPage}" />
	<c:set var="size" value="${page.listSize}" />
	<c:set var="last" value="${page.lastPage}" />
	<c:set var="current" value="${page.currentPage}" />
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form"
					action="${pageContext.request.contextPath }/board?a=search"
					method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:set var="count" value="${total}" />
					<c:forEach items="${list}" var="list" varStatus="status">
						<tr>
							<td>[${count - list.rn+1}]</td>
							<td class="left" style="padding-left:${list.depth*20}px"><c:choose>
									<c:when test="${list.depth == 0}">
										<a
											href="${pageContext.request.contextPath }/board?a=view&no=${list.no}&p=${current}">
											${list.title}</a>
									</c:when>
									<c:otherwise>
										<img
											src="${pageContext.request.contextPath }/assets/images/reply.png">
										<a
											href="${pageContext.request.contextPath }/board?a=view&no=${list.no}&p=${current}">
											${list.title}</a>
									</c:otherwise>
								</c:choose></td>
							<td>${list.user_name}</td>
							<td>${list.hits }</td>
							<td>[${list.reg_date }]</td>
							<c:choose>
								<c:when test="${empty authUser }">
								</c:when>
								<c:otherwise>
									<c:if test="${authUser.no == list.user_no}">
										<td><a
											href="${pageContext.request.contextPath }/board?a=delete&no=${list.no}&p=${current}"
											class="del"><img
												src="${pageContext.request.contextPath }/assets/images/recycle.png"></a></td>
									</c:if>
								</c:otherwise>
							</c:choose>
						</tr>

					</c:forEach>
				</table>
				<div class="pager">

					<ul>
						<c:choose>
							<c:when test="${1 <= start-size+1 }">
								<li><a
									href="${pageContext.request.contextPath }/board?p=${start-size+1}&l=${start-size+1}">◀</a></li>
							</c:when>
							<c:otherwise>
								<li>◀</li>
							</c:otherwise>
						</c:choose>


						<c:forEach var="i" begin="${ start }" end="${size}"
							varStatus="status">
							<c:choose>
								<c:when test="${page.currentPage == start+status.index-1 }">
									<li class="selected">${start+status.index-1 }</li>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${last >= start+status.index-1 }">
											<li><a
												href="${pageContext.request.contextPath }/board?p=${start+status.index-1 }">${start+status.index-1 }</a></li>
										</c:when>
										<c:otherwise>
											<li>${start+status.index-1 }</li>
										</c:otherwise>
									</c:choose>
								</c:otherwise>

							</c:choose>
						</c:forEach>
						<c:choose>
							<c:when test="${last >= start+size }">
								<li><a
									href="${pageContext.request.contextPath }/board?p=${start+size}&l=${start+size}">▶</a></li>
							</c:when>
							<c:otherwise>
								<li>▶</li>
							</c:otherwise>
						</c:choose>

					</ul>
				</div>
				<div class="bottom">
					<c:choose>
						<c:when test="${empty authUser }">
						</c:when>
						<c:otherwise>
							<a
								href="${pageContext.request.contextPath }/board?a=writeform&p=${current}"
								id="new-book">글쓰기</a>
						</c:otherwise>
					</c:choose>

				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="board" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>