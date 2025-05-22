<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Board.jsp를 실행시킬 수 있도록 
	 		코드 작성해주세요~~~~
	    view(.jsp)를 실행시키려면
	    1) 직접적인 URL요청 불가
	    2) Controller를 통해서 요청!!
	  -->
	<div class="jumbotron">
		<h1>클라우드 과정 게시판</h1>
		<p>Spring을 활용해서 간단한 게시판을 만들어보자!</p>
	</div>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">SpringMVC 게시판</div>
			<div class="panel-body">
				<table class="table table-bordered table-hover table-striped">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
					</tr>
					
					<c:forEach items="${list}" var="b">
						<tr>
							<td>${b.idx}</td>
							<td><a href="/web/boardSelect?idx=${b.idx}">${b.title}</td>
							<td>${b.writer}</td>
							<td>${b.indate}</td>
						</tr>		
					</c:forEach>		
				</table>
				<button onclick="location.href='register'" type="button" class="btn btn-primary btn-sm">글쓰기</button>
			</div>
			<div class="panel-footer">클라우드기반 인공지능 서비스 엔지니어과정</div>
		</div>
	</div>
</body>
</html>