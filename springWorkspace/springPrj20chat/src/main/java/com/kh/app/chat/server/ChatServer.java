package com.kh.app.chat.server;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

//웹소켓 만드는 방법
//WebSocketHandler 인터페이스 상속
//TextWebSocketHandler 클래스 상속
@Slf4j
public class ChatServer extends TextWebSocketHandler  {
	
	private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	
	//연결 완료 이후에 동작하는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		log.info("[연결] {}" , session);
		
		Map map = session.getAttributes();
		log.info(map.toString());
		
		sessionSet.add(session);
	}
	
	//발신 //session.sendMessage(메세지);
	
	//메세지가 수신되었을 때 동작
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		log.info("[수신] {} : {}" , session , message);
		
		//닉네임+메세지 객체 만들기
		String memberId = (String)session.getAttributes().get("memberId");
		TextMessage msg = new TextMessage("[" + memberId + "]" + message.getPayload());
		
		//연결된 모든 session에게 발신
		for(WebSocketSession x : sessionSet) {
			if(!x.isOpen()) continue;
			x.sendMessage(msg);
		}
		
	}
	
	//소켓 연결 종료 이후에 동작
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		log.info("[종료] {} : {} " , session , status);
		sessionSet.remove(session);
	}

}//class



























