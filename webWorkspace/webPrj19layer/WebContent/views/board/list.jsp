<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%List<BoardVo> x = (List<BoardVo>)request.getAttribute("voList");%>
    
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
			<th>제목</th>
			<th>내용</th>
		</tr>
			
		<%for(int i = 0 ; i < x.size(); ++i){%>
				<tr>
					<td><%= x.get(i).getTitle() %></td>
					<td><%= x.get(i).getContent() %></td>
				</tr>
		<%}%>
		
	</table>
	
</body>
</html>