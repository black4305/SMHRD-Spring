<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
      <p>SpringBoot을 활용해서 간단한 게시판을 만들어보자!</p>
   </div>
   <div class="container">
      <div class="panel panel-default">
         <div class="col">
            <div class="panel-heading">SpringBoot 게시판 글 등록하기</div>
            <div class="panel-body">

               <form action = "goInsert" method = "post">
                  <table class = "table table-bordered table-hover">
                     <tr>
                        <th>작성자</th>
                        <td><input type = "text" name = "writer" class = "form-control"></td>
                     </tr>
                     <tr>
                        <th>제목</th>
                        <td><input type = "text" name = "title" class = "form-control"></td>
                     </tr>
                     <tr>
                        <th>내용</th>
                        <td><textarea type = "text" name = "content" class = "form-control" rows = "20"></textarea></td>
                     </tr>
                     <tr>
                        <td><button type = "submit" class = "btn btn-succcess">등록</button></td>
                     </tr>
                  </table>
               
               </form>
               
            </div>
         </div>
      </div>
   </div>

</body>
</html>