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
	<h1>나이 확인</h1>
	
	<input type="text" name="age">
	<button onclick="check();">확인</button>
	
	<script>
	
		function check(){
			//입력된 나이 가져오기
			let age = $('input[name="age"]').val();
			
			// ajax 이용해서, 서버한테 데이터 보내고 응답받기
			$.ajax({
				url : "/app21/test2" ,
				type : "post" ,
				data : 
				{
					"age" : age	
				} ,
				success : function(x){
					alert(x);
				} ,
				error : function(){
					alert("에러 발생...");
				}
			});
		}
	
	</script>
	
</body>
</html>





