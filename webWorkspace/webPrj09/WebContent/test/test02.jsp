<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 
	1. 데이터 받기					=> JAVA
	2. 받은 데이터 화면에 보여주기	=> HTML + java
	
 --%>
 
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String nick = request.getParameter("nick");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String hobby = request.getParameter("hobby");
	String country = request.getParameter("country");
%>
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>테스트02</h1>
	
	<span>아이디 : <%= id %> </span>
	<br>
	<span>패스워드 : <%= pwd %></span>
	<br>
	<span>닉네임 : <%= nick %></span>
	<br>
	<span>나이 : <%= age %></span>
	<br>
	<span>성별: <%= gender %></span>
	<br>
	<span>취미 : <%= hobby %></span>
	<br>
	<span>거주지 : <%= country %></span>
	
</body>
</html>
















