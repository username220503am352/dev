<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String nick = request.getParameter("nick");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 결과</h1>
	
	<div>아이디 : <%= id %></div>
	<div>패스워드 : <%= pwd %></div>
	<div>닉네임 : <%= nick %></div>
	
</body>
</html>







