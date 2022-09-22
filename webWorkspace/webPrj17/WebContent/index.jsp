<%@ page import="com.kh.app17.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	HttpSession s = request.getSession();
	MemberVo vo = (MemberVo)s.getAttribute("data");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인덱스</h1>
	
	
	<%if(vo != null){%>
		<h2><%= vo.getMemberNick() %> 님 환영합니다 ~</h2>
		<br>
		<a href="/app17/member/logout">로그아웃</a>
	<%}else{%>
		<a href="/app17/member/join">회원가입</a>
		<br>
		<a href="/app17/member/login">로그인</a>
	<%}%>
	
</body>
</html>












