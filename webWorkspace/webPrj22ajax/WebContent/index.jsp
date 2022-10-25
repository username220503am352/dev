<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@6.2.0/css/fontawesome.min.css" integrity="sha384-z4tVnCr80ZcL0iufVdGQSUzNvJsKjEtqYZjiQrrYKlpGow+btDHDfQWkFjoaz/Zr" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css" integrity="sha384-xeJqLiuOvjUBq3iGOjvSQSIlwrpqjSHXpduPd6rQpuiM3f5/ijby8pCsnbu5S81n" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
</head>
<body>

	<h1>인덱스</h1>
	
	<a href="http://127.0.0.1:8888/app22/lotto">숫자 6개 보내주는 서버한테 요청 보내기</a>
	
	<br>
	
	<input type="text" id="target">
	
	<button onclick="f01();">숫자 6개 보내주는 서버한테 요청 보내기(ajax 방식)</button>
	
	<script>
	
		var a = document.querySelector('#target').value;
	
		function f01(){
			$.ajax({
				url : "http://127.0.0.1:8888/app22/lotto" ,
				type : "get" ,
				data : {
					"name" : a ,
					"pwd":"1234"
					} ,
				success : function(x){
					alert(x);
				} ,
				error : function(){
					alert("통신에러발생~~~");
				}
					
			});
		}
	
		
	
		//let nums = "1,2,3,4,5,6";
		//alert(nums);
	</script>

</body>
</html>




















