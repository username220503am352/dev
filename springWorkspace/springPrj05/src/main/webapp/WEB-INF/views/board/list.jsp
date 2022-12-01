<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시글 목록</h1>
	
	<table border="1">
		<tr>
			<th>제목</th>
			<th>내용</th>
			<th>작성일시</th>
		</tr>
		
		<c:forEach items="${voList}" var="vo">
			<tr>
				<td>${vo.title}</td>
				<td>${vo.content}</td>
				<td>${vo.enrollDate}</td>
			</tr>
		</c:forEach>
		
		
	</table>

</body>
</html>


















