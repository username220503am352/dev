<%@page import="com.kh.semi.board.vo.AttachmentVo"%>
<%@page import="com.kh.semi.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	BoardVo vo = (BoardVo)request.getAttribute("vo");
    	AttachmentVo attVo = (AttachmentVo)request.getAttribute("attachmentVo");
    	if(attVo == null){
    		attVo = new AttachmentVo();
    	}
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#main{
		width: 60vw;
		height: 60vh;
		border: 5px solid black;
		margin: auto;
		display: grid;
		grid-template-columns: 1fr 5fr 3fr 1fr 3fr;
		grid-template-rows: 30px 300px 100px;
		align-content : center;
	}
	
	#main>div{
		border : 1px solid black;
	}

	#content-box{
		grid-column: span 5;
	}
	
	#img-box{
		grid-column: span 5;
		display: flex;
		justify-content:center; 
	}
	
	

</style>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>
	
	<div id="main">
		
		<div><%= vo.getCategory() %></div>
		<div><%= vo.getTitle() %></div>
		<div><%= vo.getWriter() %></div>
		<div><%= vo.getHit() %></div>
		<div><%= vo.getEnrollDate()%></div>
		<div id="content-box"><%= vo.getContent() %></div>
		<div id="img-box"><img width="100px" height="100px" src="<%= root %>/<%= attVo.getFilePath() %>/<%= attVo.getChangeName() %>" alt="사진"></div>

	</div>

</body>
</html>



















