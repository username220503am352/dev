<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>피자 주문하기</h1>
	
	<form action="/app13/pizza" method="post">
	
		주소 : <input type="text" name="addr">
		<br>
		전화번호 : <input type="text" name="phone">
		<br>
		
		피자 : 
		<select name="topping">
			<option value="co">콤비네이션</option>
			<option value="pp">페페로니</option>
			<option value="ch">치즈피자</option>
			<option value="sp">고구마</option>
			<option value="hm">하와이안민트초코</option>
		</select>
		
		<br>
		
		도우 :
		씬 <input type="radio" value="th" name="dough">
		&nbsp;
		치즈크러스트 <input type="radio" value="cc" name="dough">
		&nbsp;
		에그타르트 <input type="radio" value="et" name="dough">
		
		<br>
		
		사이드 : 
		스파게티 <input type="checkbox" value="sp" name="side">
		&nbsp;
		콘샐러드 <input type="checkbox" value="cs" name="side">
		&nbsp;
		치즈볼 <input type="checkbox" value="cb" name="side">
		
		<br>
		
		<input type="submit" value="주문하기">
		
	</form>
	
</body>
</html>








