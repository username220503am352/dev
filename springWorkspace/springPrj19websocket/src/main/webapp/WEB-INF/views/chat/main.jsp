<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>채팅</h1>
	
	<button onclick="connect();">접속하기</button>
	<button onclick="disconnect();">종료하기</button>
	
	<br>
	
	<input type="text" name="msg">
	<button onclick="sendMsg();">전송</button>
	
	<hr>
	
	<div id="result"></div>
	
	<script>

		let webSocket = null;
		
		function connect(){
			//웹소켓 생성
			webSocket = new WebSocket("ws://127.0.0.1:8888/app/chat/server");
			alert('연결~~~');
			
			//웹소켓이 메세지 받았을 때 동작할 함수 지정
			webSocket.onmessage = function (x){
				console.log(x.data);
			}
			
		}
		
		function disconnect(){
			webSocket.close();
			alert('연결종료~~~');
		}

		function sendMsg(){
			const msg = document.querySelector("input[name=msg]").value;
			webSocket.send(msg);
		}
		
	
	</script>
	

</body>
</html>























