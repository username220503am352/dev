<%@page import="com.kh.main.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberVo x = (MemberVo)request.getAttribute("vo");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과화면</h1>
	
	<div>아이디 : <%= x.getMemberId() %></div>
	<div>패스워드 : <%= x.getMemberPwd() %></div>
	
</body>
</html>