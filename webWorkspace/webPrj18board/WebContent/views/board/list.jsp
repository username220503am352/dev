
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.app18.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 목록 조회</h1>
	
	<table border="1">
		<tr>
			<td>제목</td>
			<td>내용</td>
		</tr>
		
		<%
			ArrayList<BoardVo> voList = (ArrayList<BoardVo>)request.getAttribute("voList");
		
			for(int i = 0 ; i < voList.size(); ++i){%>
				<tr>
					<td><%= voList.get(i).getTitle() %></td>
					<td><%= voList.get(i).getContent() %></td>
				</tr>
		<%}%>
		
		
	</table>
	
</body>
</html>
















