<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test02 데이터 입력 화면</h1>
	
	<form action="/app09/test/test02.jsp" method="get">
		아이디 : <input type="text" name="id">
		<br>
		패스워드 : <input type="password" name="pwd">
		<br>
		닉네임 : <input type="text" name="nick">
		<br>
		나이 : <input type="number" name="age">
		<br>
		성별 : 
		남자<input type="radio" value="male" name="gender">
		&nbsp;&nbsp;
		여자<input type="radio" value="female" name="gender">
		<br>
		취미 : 
		게임<input type="checkbox" name="hobby" value="game">&nbsp;
		낚시<input type="checkbox" name="hobby" value="fishing">&nbsp;
		코딩<input type="checkbox" name="hobby" value="coding">&nbsp;
		<br>
		거주 국가 :
		<select name="country">
			<option value="ko">한국</option>
			<option value="jp">일본</option>
			<option value="uk">영국</option>
		</select>
		<br>
		<input type="submit" value="회원가입">
	</form>
	
	
</body>
</html>




























