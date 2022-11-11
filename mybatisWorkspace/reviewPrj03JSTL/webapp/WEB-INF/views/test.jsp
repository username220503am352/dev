<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>어떤 복잡한 연산의 결과 ::: ${n} </h1>
	
	<hr>
	
	<c:if test="${n > 0}">
		<h3>양수입니다</h3>
	</c:if>
	<c:if test="${n <= 0}">
		<h3>음수입니다</h3>
	</c:if>
	
	<%-- 
	<% int n = (int) request.getAttribute("n"); %>
	<% if(n > 0){ %>
		<h3>양수입니다</h3>
	<%} else {%>
		<h3>음수입니다</h3>
	<%} %> 
	--%>
	
	<hr>
	
	<c:forEach begin="1" end="10" step="2" var="num" varStatus="svo">
		<h3>${num} //svo의 어떤 필드 ::: ${svo.last} </h3>
	</c:forEach>
	
	<%-- 
	<% for(int i = 1 ; i <= 10; i++){ %>
		<h3><%= i %></h3>
	<%} %>
 	--%>
 	
 	<hr>
 	
 	<h3>${numList}</h3>
 	
 	<c:forEach items="${numList}" var="str">
 		<h3>${str}</h3>
 	</c:forEach>
 	
 	<%-- 
 	<% List<String> numList = (List)request.getAttribute("numList"); %>
 	<% for(String str : numList){ %>
		<h3><%= str %></h3> 	
 	<%} %>
 	 --%>
 	
</body>
</html>




















