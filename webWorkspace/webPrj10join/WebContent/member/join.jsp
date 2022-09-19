<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입</h1>
	
	<!-- 
		아이디 , 패스워드 , 닉네임 3개 데이터 전달하여 회원가입 
		요청주소 : /app10/member/joinResult.jsp
		요청방식 : post
		
		요청 후 , 결과화면 : 전달 받은 데이터들(3개)을 h1 태그에 넣어서 화면(브라우저에서) 확인
	-->
	
	<form action="/app10/member/joinResult.jsp" method="POST">
		아이디 : <input type="text" name="id">
		<br>
		비밀번호 : <input type="password" name="pwd">
		<br>
		닉네임 : <input type="text" name="nick">
		<br>
		<input type="submit" value="회원가입">
	</form>
	
	 
	
	
</body>
</html>











