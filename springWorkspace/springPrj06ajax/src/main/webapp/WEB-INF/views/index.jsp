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

	<h1>인덱스 ~~~</h1>
	
	<button onclick="random();">랜덤숫자 달라고 ajax로 요청보내기</button>
	
	<div id="result"></div>
	
	<script type="text/javascript">
	
		function random(){
			$.ajax({
				url : "/app/test/random",
				method : "GET" ,
				success : function(x){
					alert(x);
				} ,
				error : function(){
					alert("error...");
				}
			});
		}
		
	</script>

</body>
</html>




























