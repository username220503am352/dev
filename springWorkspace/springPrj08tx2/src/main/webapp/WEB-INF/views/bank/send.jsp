<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>계좌이체</h1>
	
	<form action="/app/bank/send" method="post">
		보내는사람 : <input type="text" name="sender">
		<br>
		받는사람: <input type="text" name="receiver">
		<br>
		금액 : <input type="number" name="money">
		<br>
		<input type="submit" value="이체하기">
	</form>
	

</body>
</html>




















