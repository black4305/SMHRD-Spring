<%@ page import = "com.smhrd.model.BoardVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="jumbotron">
		<h1>클라우드 과정 게시판</h1>
		<p>Spring을 활용해서 간단한 게시판을 만들어보자!</p>
	</div>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">SpringMVC 게시판 글 작성</div>
			<div class="panel-body">
				<form action = "${cpath}/boardUpdate" method = "post">
					<table class="table table-bordered table-hover table-striped">
						<tr>
							<td><input type = "hidden" name = "idx" value = "${vo.idx}"></td>
						</tr>
						<tr>
							<td>제목</td>
							<td><input type = "text" name = "title" value = "${vo.title}"></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><input type = "text" name = "content" value = "${vo.content}"></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input name = "writer" value = "${vo.writer}" readonly></td>
						</tr>
						<tr>
							<td><input type = "submit" value = "수정 허가"></td>
						</tr>
					</table>
				</form>
				<td colspan = "2">
					<button class = "btn btn-info" onclick="location.href='${cpath}/boardList'">돌아가기</button>
				</td>
			</div>
		</div>
	</div>
</body>
</html>