<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<form action="register2", method="post">
					<table class="table table-bordered table-hover table-striped">
						<div class="mb-3 mt-3">
							<label for="title" class="form-label">제목:</label>
							<input type="text" class="form-control" id="title"
								placeholder="제목을 입력해주세요" name="title">
						</div>
						<div class="mb-3">
							<label for="writer" class="form-label">작성자:</label>
							<input type="text" class="form-control" id="writer"
								placeholder="작성자를 입력해주세요" name="writer">
						</div>
						<div class="mb-3">
							<label for="content" class="form-label">내용:</label>
							<input type="text" class="form-control" id="content"
								placeholder="내용을 입력해주세요" name="content">
						</div>
						<button type="submit" class="btn btn-primary">등록</button>
					</table>
				</form>
			</div>
		</div>
	</div>



</body>
</html>