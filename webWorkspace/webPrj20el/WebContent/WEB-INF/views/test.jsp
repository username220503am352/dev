<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>테스트 ~~~ </h1>
	
	<h2>${id}</h2>
	<h2>${sessionScope.name}</h2>
	<h2>${age}</h2>
	
	<ul>
		<li>${hobby[0]}</li>
		<li>${hobby[1]}</li>
		<li>${hobby[2]}</li>
	</ul>
	
	<hr>
	
	<ul>
		<li>${foodList[0]}</li>
		<li>${foodList[1]}</li>
		<li>${foodList[2]}</li>
	</ul>
	
	<hr>
	
	<ul>
		<li>${pet["자"]}</li>
		<li>${pet["축"]}</li>
		<li>${pet["인"]}</li>
		<li>${pet["묘"]}</li>
	</ul>
	
	<hr>
	
	<ul>
		<li>${pokemon.name}</li>
		<li>${pokemon.atk}</li>
		<li>${pokemon.def}</li>
	</ul>
	
	
	
	
	
	
	
	<hr><hr><hr><hr><hr>
	
	
	
	
	
	
	<h2>JSTL</h2>
	
	
	<ul>
		<c:forEach items="${hobby}" var="x">
			<li>${x}</li>
		</c:forEach>
	</ul>
	
	<hr>
	
	<ul>
		<li>${foodList[0]}</li>
		<li>${foodList[1]}</li>
		<li>${foodList[2]}</li>
	</ul>
	
	<hr>
	
	<ul>
		<li>${pet["자"]}</li>
		<li>${pet["축"]}</li>
		<li>${pet["인"]}</li>
		<li>${pet["묘"]}</li>
	</ul>
	
	<hr>
	
	<ul>
		<li>${pokemon.name}</li>
		<li>${pokemon.atk}</li>
		<li>${pokemon.def}</li>
	</ul>
	
	<c:if test="${fn:contains(pokemon.name , '피카')}">
		<h1>통과</h1>
	</c:if>
	
	<c:if test="${pokemon.def lt 100}">
		<h1>물몸</h1>
	</c:if>
	
	<c:if test="${pokemon.atk ge 100}">
		<h1>탱커</h1>
	</c:if>
	
	<c:if test="${not empty loginMember}">
		<h1>글쓰기</h1>
	</c:if>
	
	
	
</body>
</html>



























