<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%-- 
    	JSP : Java Server Page
    	
    	서블릿과 반대로,
    	HTML 코드가 메인 , java 코드가 서브
    	
    	JSP 도 사실은 서블릿
    	
    	JSP에는 내장객체가 있다.
    	(개발자가 직접 만든 객체가 아닌데, 자동으로 만들어지는 객체들)
    	서블릿에서 파라미터로 req, resp 를 받는것처럼.
    	
    	
    
    	<%@ ~~~ %> : 페이지 속성 정보 , 기타 등등 페이지 관련 내용들 작성 가능
    	<%! ~~~ %> : 선언문 (전역변수 , 메소드) 
    	<%= ~~~ %> : 표현식 (out.write(인자값) 메소드의 인자값을 전달함)
    	<%  ~~~ %> : scriptlet (자바코드 - service 메소드 내부에 작성됨)
     --%>
    
    
<!-- 데이터 받아서 화면에 보여주기 -->
    <%
    	//자바코드 주석
    	
    	//데이터 받기
    	String x = request.getParameter("data");
    
    	printHello();
    %>
    
    
    
    <%-- 선언문 --%>
    <%!
    	int global = 100;
    
    	public void printHello(){
    		System.out.println("Hello ~~~ !");
    	}
    	
    	
    
    %>
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석 그대로 가능 ㅎㅎ -->
	<%-- 
	이건 JSP 주석 ~~~ 
	--%>
	<h1>테스트01</h1>
	
	<span>받아온 data : <% out.write(x); %> </span>
	<br>
	<span>받아온 data : <%= x %> </span>
	
	<br><br><br>
	<hr>
	<br><br><br>
	
	<span>전역변수(global) : <%= global %> </span>
	
	
</body>
</html>










