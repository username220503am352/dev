<%@page import="com.kh.app16.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>디비</h1>
	
	<%
		MemberVo x = (MemberVo)session.getAttribute("data");
	%>
	
	<%if(x != null){%>
		<h2><%= x.getMemberId() %>님 환영합니다 ~ ^^</h2>
		<a href="/app16/member/logout">로그아웃</a>
	<%}else{%>
		<a href="/app16/member/join">회원가입</a>
		<br>
		<a href="/app16/member/login">로그인</a>
	<%}%>
	
</body>
</html>








