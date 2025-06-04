package kr.cloud.web.controller;

import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import jakarta.websocket.server.ServerEndpoint;

@Controller
@ServerEndpoint("/websocket") // 웹 소켓 사용 시, 요청하면 소캣으로 들어올 url매핑값
public class WebSocketHandler extends TextWebSocketHandler{
   
   private Logger logger = LoggerFactory.getLogger(getClass());
   
   // 소켓을 통해 접속한 사용자들에 대한 정보를 저장할 자료구조 생성
   // 선형 구조 : 일렬로 저장되는 구조
   // 비선형 구조 : 트리구조, map(계층적 특징을 나타내기에 좋다)
   // MAP(key, value 구성된 자료구조)
   // *key는 중복이 되면 안된다!
   // ConcurrentHashMap : 멀티 쓰레드 환경에 특화되어 있는 자료구조
   // - 멀티 쓰레드 : 한 컴퓨터에서 여러개의 프로그램(어플,프로세스) 실행
   // 프로그램 -> 프로세스
   // * 멀티 쓰레드를 이용하면 동시에 여러개의 프로그램을 실행 가능
   //   -> 동시에 여러개의 다중 작업 가능!
   // * 멀티 쓰레드를 이용하면 동시에 여러개의 프로그램을 실행 가능
   //   -> 동시에 여러개의 다중 작업 가능!
   private static ConcurrentHashMap<String,WebSocketSession> clients = new ConcurrentHashMap<>();
   
   @Override
   public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      logger.info("connection 로그 >>"+ session);
      // 웹 소캣 연결이 되었으면! 들어온 사용자를 Clients 자료구조에 추가
      clients.put(session.getId(), session);
      // 소켓에 제대로 접속 완료가 되었다면! 사용자에게 데이터 전송!!
      // 데이터를 전송하는 방법 : 접속한 사용자 본인에게 메세지 보내기
      session.sendMessage(new TextMessage("success"));
   }

   // *2. 웹 소켓이 텍스트 데이터를 전달 받았을 때, 실행되는 메서드
   @Override
   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
      logger.info("handle 로그 >>" + session);
      logger.info("message 확인 >> " + message.getPayload());

      // java 람다식 구조 : method(function)를 간략하게 생성
      // entryset : map 구조에서 모든 key-value 쌍을 가져와서 한 쌍으로 이뤄진 객체반환
      clients.entrySet().forEach(data -> {
         logger.info("받아온 데이터 >> { }" + data);

         if(! data.getValue().getId().equals(session.getId())) {
            // 받아온 데이터의 id != websocket의 id -> 데이터 전송

            try {
               data.getValue().sendMessage(message);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   // *3. 웹 소켓이 닫혔을때, 실행되는 메서드
   @Override
   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      logger.info("close 로그 >>" + session);
      // 사용자의 모든 정보가 들어있는 clients 자료 구조에서 해당 사용자 삭제
      clients.remove(session.getId());
   }
}
