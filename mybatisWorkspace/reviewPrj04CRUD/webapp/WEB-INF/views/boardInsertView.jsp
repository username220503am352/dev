<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP가 만든 페이지</title>
</head>
<body>

	<h1>게시글 작성하기</h1>

	<form action="/app04/board/insert" method="post">
		제목 : <input type="text" name="title">
		<br>
		내용 : <input type="text" name="content">
		<br>
		<input type="submit">
	</form>

</body>
</html>























