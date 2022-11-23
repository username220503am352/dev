<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="/mb04">HOME</a>

	<h1>게시글 작성</h1>
	
	<form action="/mb04/board/write" method="post">
		게시글 제목 : <input type="text" name="title">
		<br>
		게시글 내용 : <textarea name="content"></textarea>
		<br>
		<input type="submit" value="작성하기">
	</form>

</body>
</html>
































