<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인덱스</h1>
	
	<%if(request.getAttribute("nick") != null){%>
		<h3><%= request.getAttribute("nick") %> 님 환영합니다.</h3>
	<%}else{%>
		<a href="/app15/member/join">회원가입</a>
		<a href="/app15/member/login">로그인</a>
	<% } %>
	
	
</body>
</html>










