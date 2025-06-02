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
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<style type="text/css">
.ChatWrapper {
   width: 100%;
   height: 100%;
}

#Chatting {
   width: 60%;
   height: 400px;
   border : 1px solid gray;
}

#Chatting-send{
   width: 60%;
}
.content {
   width: 100%;
   height: 5%;
}
.my{
   text-align : right;
}
.others{
   text-align : left;
}
</style>

</head>
<body>

   <div class="container">
      <h2>WebSocket Chatting</h2>
      <div class="panel panel-default">
         <div class="panel-heading">채팅구현하기</div>
         <div class="panel-body" align="center">
         
            <div class="ChatWrapper">
               <div id="Chatting">
               </div>
               
               <br>
               
               <div id = "Chatting-send">
                  <div class="form-group">
                     <label class="control-label col-sm-2" for="nickname">닉네임:</label>
                     <div class="col-sm-8">
                        <input type="email" class="form-control" id="nickname"
                           placeholder="닉네임입력" name="nickname">
                     </div>
                     <button id="eCheck" class="btn btn-success col-sm-2">닉네임확정</button>
                  </div>
                  <br>
                  <div class="form-group">
                     <label class="control-label col-sm-2" for="content">메시지:</label>
                     <div class="col-sm-8">
                        <textarea placeholder="메시지입력" rows="5" class="form-control" id="content" name="content"></textarea>
                     </div>
                  </div>
                  <div class="form-group">
                     <button class="btn btn-info col-sm-2" id="sendMsg" disabled>전송</button>                  
                  </div>
               </div>
            </div>
         </div>
         <div class="panel-footer">클라우드 분석서비스 개발자과정 - 홍길동</div>
      </div>
   </div>
</body>
</html>