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

   <script>
   //   닉네임을 입력하고 닉네임 확정 버튼을 클릭하면 
    // 순수 js코드로 input태그를 통해 입력 받은 닉네임을 가져오기!!
    // *0. 필요한 태그 먼저 변수로 가져오기!
    let checkbtn = document.getElementById("eCheck");
    let nickname = document.getElementById("nickname");
    let sendMsg = document.getElementById("sendMsg");
    let chattingRoom = document.getElementById("Chatting");
    let content = document.getElementById("content");
    let websocket;

    // *1. id가 eCheck인 버튼 클릭 시, id가 nickname인 input태그를 가져와서 그 안의 값 꺼내기
    //     console.log를 통해서 가져온 닉네임 출력
    checkbtn.onclick = function(){
        console.log(nickname.value);
      
       if(nickname.value != ''){
        // *2. 닉네임이 확정되고 나면 닉네임을 입력하는 input태그를 읽기 전용으로 바꾸기
          nickname.readOnly = true;
        // * 3 전송 버튼 비활성화(disabled) -> 비활성화 속성 제거후, 버튼 활성화
          sendMsg.removeAttribute("disabled");
       }
    }
    document.addEventListener("DOMContentLoaded", connection);
    
    function connection() {
       // 웹 소캣 생성
       // http통신에서 url의 시작은 http://인데
       // 웹 소캣에서는 ws이다.
       // location.host -> localhost
       let url ="ws://" + location.host + "${cpath}/websocket";
       websocket = new WebSocket(url);
       console.log(websocket);
       
      // 1. 소캣이 열렸을 때, 실행할 함수
       websocket.onopen = function(){
          console.log("연결 성공");
       };
       
       // 2. 소캣이 닫혔을 때, 실행할 함수
       websocket.onclose = function(){
          console.log("연결 실패");
       };
       
       //3. 소캣을 사용해서 데이터 전송할 함수
       websocket.onmessage =function(evt){
         console.log("연결 메세지 수신");
         console.log("데이터 확인 >> ", evt);

         // 받아온 메시지가 success -> 채팅방 화면에 출력
         if(evt.data == "success") {
         // div 태그 속에 데이터 추가
         chattingRoom.append("=== 채팅방 입장을 환영합니다! ===");
         }
         else {
            // 다른 사람이 보낸 텍스트 데이터를 수신할 때, 실행할 code
            console.log("다른 사람이 보낸 텍스트 >> " + evt.data);

            // 화면 구성 변환(상단에 디자인 정의된 .my .others 활용)

            // 1. display block 속성을 가지고 있는 div 태그 생성
            let div = document.createElement("div");

            // 2. div 태그 안 쪽에 evt.data.content만 꺼내와서 글자로 세팅
            let temp = JSON.parse(evt.data);
            div.innerText = temp.content;

            // 3. div 태그에 class 속성을 others 부여
            div.className = "others";

            // 4. chatingRoom에 추가
            chattingRoom.append(div);
         }
       };
    } // connection 함수 끝

   // 1. 전송 버튼 클릭 시 실행할 함수 생성
   sendMsg.addEventListener("click", function() {

      // 2. 닉네임, 메시지 내용 가져오기 -> 입력된 값을 가져와서 key, value 값으로 넣어주기
      let sendData = {
         nickname : nickname.value,
         content : content.value
      }
      console.log(sendData);

      // json 데이터를 변환 후, websocket을 이용해서 전달!
      websocket.send(JSON.stringify(sendData));

      let div = document.createElement("div");
      div.innerText = content.value;
      div.className = "my";
      chattingRoom.append(div);
   });

   </script>
</body>
</html>