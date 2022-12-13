<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>메인</h1>
	
	<h2>로그인한 계정 : ${ loginMember.memberId }</h2>
	
	<h3>쿠키x값 확인 : ${ cookie.x.name}</h3>
	<h3>쿠키x값 확인 : ${ cookie.x.value }</h3>
	
	<a href="/app/member/join">회원가입</a>
	<br>
	<a href="/app/member/login">로그인</a>
	
	

</body>
</html>