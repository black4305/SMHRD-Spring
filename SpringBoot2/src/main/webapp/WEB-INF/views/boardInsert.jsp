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
<meta charset="UTF-8">

</head>
<body>
	<div class="jumbotron">
		<h1>클라우드 과정 게시판</h1>
		<p>SpringBoot를 활용해서 간단한 게시판을 만들어보자!</p>
	</div>
	<div class="container">
		<div class="panel panel-default">
			<div class="col">
				<div class="panel-heading">SpringBoot 게시판 글 등록하기</div>
				<div class="panel-body">
				<!--  파일을 업로드할때는 반드시 form태그에 enctype(전송되는 파일의 형태)를 지정해야한다.
					   일반 텍스트의 데이터는 key:value값으로 전송! url처럼 인코딩이 된다.
					   파일은 단순 텍스트가 아니라 바이너리데이터(0과 1로 구성)라서 텍스트방식 인코딩을하면
					   파일 내용이 깨짐/ 파일인지 텍스트인지 구분가능하도록 enctype 지정!
				 -->
					<form action="goInsert" method="post" enctype="multipart/form-data">
						<table class="table table-bordered table-hover">
							<tr>
								<td>작성자</td>
								<td><input type="text" name="writer" class="form-control"></td>
							</tr>
							<tr>
								<td>제목</td>
								<td><input type="text" name="title" class="form-control"></td>
							</tr>
							<tr>
								<td>내용</td>
								<td><textarea name="content" class="form-control" rows="20"></textarea></td>
							</tr>
							<tr>
								<td>파일 업로드</td>
								<td><input type="file" name="upload" class="form-control"></td>
							</tr>
							<tr>
								<td><button type="submit" class="btn btn-success">등록</button></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>