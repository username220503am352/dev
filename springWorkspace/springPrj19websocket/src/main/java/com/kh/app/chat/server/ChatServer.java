package com.kh.app.chat.server;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//public class ChatServer implements WebSocketHandler {
public class ChatServer extends TextWebSocketHandler {

	//연결 완료 이후 동작
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		log.info("커넥션 만들어짐 ~~~");
		
	}
	
	//메세지 받았을 때 동작
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		log.info("메세지 수신 ~~~");
		log.info(message.toString());
		
		TextMessage tm = new TextMessage("메세지 받았음 ~~~");
		session.sendMessage(tm);
		
	}
	
}//class























