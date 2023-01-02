<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

	<h1>채팅</h1>
	
	<input type="text" id="msgBox">
	<button onclick="sendMsg();">전송</button>
	
	<hr>
	
	<div id="result"></div>
	
	<script>
		
		//소켓 생성
		const webSocket = new WebSocket("ws://138.2.116.28:8888/app/chat/server");
		webSocket.onopen = function(){
			console.log("onopen 함수 실행됨 ~~~ (연결됨)");
		}

		function sendMsg(){	//전송 버튼 클릭시 동작하는 함수
			//발신
			const msg = document.querySelector("#msgBox").value;
			webSocket.send(msg);
			document.querySelector("#msgBox").value = "";
		}
		
		//수신
		webSocket.onmessage = function(event){		//인자 : 메세지 이벤트
			const result = document.querySelector("#result");
		
			$(result).append("<h3>" + event.data + "</h3>");
		};
		
		//소켓 닫기
		//webSocket.close();

		
	
	</script>

</body>
</html>

















