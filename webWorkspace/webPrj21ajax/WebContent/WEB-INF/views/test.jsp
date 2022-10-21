<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>
	<h1>test ~~~</h1>
	
	<input type="text" name="memberId">
	<button onclick="dupCheck();">중복체크</button>
	<br>
	<div id="result">~~~~~</div>
	
	<script type="text/javascript">
	
		function dupCheck(){
			//alert("버튼 클릭 ~~~");
			//$('#result').load("/app21/data");
			//$.ajax(url~~~ , 통신성공이후에 할 동작 , 방식 , 통신실패시 동작 , 완료 후 무조건 할 동작 , 보내는데이터 , 받는데이터타입);
			$.ajax({
				url : "/app21/datazzz" ,
				method : "GET" ,
				data : 
					{
						"msg" : 'hi ~~~ 나는 클라이언트' ,
						"msg2" : "오늘은 목요일 ~~~"
					} ,
				success : function(x){
					alert("통신성공~!");
					console.log(x);
					$('#result').text(x);
				} ,
				error : function(y){
					alert("통신에러~!");
					console.log(y);
				} ,
				complete : function(){
					alert("통신 끝 ~!");
				}
			});
		}
	
	</script>
	
</body>
</html>






















