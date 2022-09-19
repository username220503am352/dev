<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>더하기 결과</h1>
	
	<%
		//데이터 꺼내기
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		
		int a = Integer.parseInt(num1);
		int b = Integer.parseInt(num2);
		
		int result = a+b;
	%>
	
	<h2>결과 : <%= result %></h2>

</body>
</html>

























