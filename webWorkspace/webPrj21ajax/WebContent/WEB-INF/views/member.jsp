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
	<h1>member ~~~</h1>
	
	<button onclick="searchMember();">ajax로 회원정보조회</button>
	
	<script>
	
		function searchMember(){
			$.ajax({
				url : "/app21/member" ,
				method : "POST" ,
				//data : ~~~ ,
				success : function(x){
					o = JSON.parse(x);
					console.log(o);
				} ,
				error : function(){
					alert("통신 에러 !");
				}
			});
		}
	
	</script>
	
</body>














</html>