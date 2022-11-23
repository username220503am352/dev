<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/board/write.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="/mb04">HOME</a>

	<h1>게시글 목록 조회</h1>
	
	<table border="1">
		<tr>
			<th>제목</th>
			<th>내용</th>
			<th>작성일</th>
		</tr>
		<c:forEach items="${voList}" var="bvo">
			<tr>
				<td>${bvo.title}</td>
				<td>${bvo.content}</td>
				<td>${bvo.enrollDate}</td>
			</tr>
		</c:forEach>
		
	</table>

</body>
</html>




















