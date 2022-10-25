<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>인덱스</h1>
	
	<a href="/temp/join">회원가입 페이지로 이동</a>
	
	<br>
	
	<a href="/temp/today">오늘날짜 물어보는 요청 보내기</a>
	
	<br>
	
	<button onclick="f01();">오늘날짜 물어보는 요청 보내기</button>
	
	<script type="text/javascript">
	
		function f01(){
			$.ajax({
				url : "/temp/today" ,
				method : "get" ,
				success : function(a){
					alert("success ~~~");
					x = JSON.parse(a);
					console.log(a);
					console.log(x);
				} ,
				error : function(){
					alert("fail .. ~~~");
				}
				
			});
		}
	
	</script>
	
</body>
</html>









