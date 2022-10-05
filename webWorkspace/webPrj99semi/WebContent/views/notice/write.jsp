<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#main{
		width: 60vw;
		height: 60vh;
		margin: 0 auto;
		display: grid;
		grid-template-columns: 1fr 5fr;
		grid-template-rows: 1fr 5fr 1fr;
		text-align: center;
		border: 1px solid black;
	}
	#main input , #main textarea{
		width: 80%;
		height: 80%;
		margin: 0 auto;
	}

</style>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>
	
	<h1 align="center">공지사항 작성하기</h1>

	<form action="" method="post">
		<div id="main">

			<div>제목</div>
			<div><input type="text" name="title"></div>

			<div>내용</div>
			<div><textarea name="content"></textarea></div>

			<div></div>
			<div><input type="submit" value="작성하기"></div>
			
		</div>
	</form>

</body>
</html>