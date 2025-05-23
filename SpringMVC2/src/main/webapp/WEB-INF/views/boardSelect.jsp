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
				<%
					// getAttribute() : Return Type -> Object
					// 따라서 사용 시 형변환 필요!
					BoardVO vo = (BoardVO)request.getAttribute("vo");
				%>
				<form action = #>
					<table class="table table-bordered table-hover table-striped">
						<tr>
							<td>제목</td>
							<td><%=vo.getTitle()%></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><%=vo.getContent()%></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><%=vo.getWriter()%></td>
						</tr>
						<tr>
							<td>작성일</td>
							<td><%=vo.getIndate()%></td>
						</tr>
					</table>
				</form>
				<td colspan = "2">
					<button class = "">돌아가기</button>
					<button onclick = "location.href = '${cpath}/boardUpdate?idx=${vo.idx}'" class = "btn btn-primary">수정</button>
					<button onclick = "location.href = '${cpath}/boardDelete?idx=${vo.idx}'" class = "btn btn-danger">삭제</button>
				</td>
			</div>
		</div>
	</div>

</body>
</html>