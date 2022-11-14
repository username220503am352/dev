<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="div-result"></div>

	<h1>인덱스</h1>
	
	<a href="/app05/test">요청보내기 ~~~</a>
	
	<hr>
	
	<form action="/app05/test" method="get">
	
		<input type="submit">
	
	</form>
	
	<hr>
	
	<button onclick="f01();">버튼</button>
	
	<hr>
	
	<button onclick="f02();">AJAX 버튼</button>

</body>
</html>

<script>
	function f01(){
		location.href = '/app05/test';
	}
	
	function f02(){
		//ajax 로 /app05/test 에다가 요청을 보냄
		$.ajax({
			url : "/app05/test" , 
			method : "GET" ,
			data : {
				age : 20 ,
				"nick" : "1dragon"
			} ,
			success : function(str){
				const resultDiv = document.querySelector('#div-result');
				resultDiv.innerText = str;
			}
		});
	}
</script>






















