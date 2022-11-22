<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="/mb04">HOME</a>

	<h1>회원가입</h1>
	
	<form action="/mb04/member/join" method="POST">
	
		아이디 : <input type="text" name="memberId">
		<br>
		비밀번호 : <input type="password" name="memberPwd">
		<br>
		<input type="submit" value="회원가입">
	
	</form>

</body>
</html>






















