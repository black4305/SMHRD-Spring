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
      <p>Spring을 활용해서 간단한 게시판을 만들어보자!</p>
   </div>
   <div class="container">
      <div class="panel panel-default">
         <div class="col">
            <div class="panel-heading">SpringMVC 게시판</div>
            <div class="panel-body">
               <table class="table table-bordered table-hover">
                  <tr>
                     <th>번호</th>
                     <td>${result.idx}</td>
                  </tr>
                  <tr>
                     <th>제목</th>
                     <td>${result.title}</td>
                  </tr>
                  <tr>
                     <th>내용</th>
                     <td>${result.content}</td>
                  </tr>
                  <tr>
                     <th>작성일</th>
                     <td>${result.writer}</td>
                  </tr>
                  <tr>
                     <th>작성일</th>
                     <td>${result.indate}</td>
                  </tr>
                  <tr>
                     <th>조회수</th>
                     <td>${result.count}</td>
                  </tr>
               </table>
            </div>
         </div>
      </div>
   </div>

</body>
</html>