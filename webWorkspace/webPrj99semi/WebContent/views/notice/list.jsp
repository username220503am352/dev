<%@page import="com.kh.semi.notice.vo.NoticeVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<NoticeVo> voList = (List<NoticeVo>)request.getAttribute("voList");
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
        display: grid;
        grid-template-rows: repeat(11 , 30px);
        grid-template-columns: 1fr 5fr 3fr 3fr;
        margin: 0 auto;
        border: 1px solid black;
        align-content: center;
        row-gap: 10px;
    }

    #main > div{
        display: flex;
        justify-content: center;
        border-bottom: 1px solid black;
    }

    #main-top{
        width: 60vw;
        margin: 0 auto;
        display: flex;
        flex-direction: row-reverse;
    }

</style>
</head>
<body>

	<%@ include file="/views/common/header.jsp"%>

    <h1 align="center">공지사항</h1>

	<%if(loginMember != null && loginMember.getId().equals("admin")){%>
		<div id="main-top">
	        <a href="/semi/notice/write">글쓰기</a>
	    </div>
	<%}%>
    

    <div id="main">

        <div>번호</div>
        <div>제목</div>
        <div>작성자</div>
        <div>조회수</div>

        <%for(int i = 0 ; i < voList.size(); ++i){%>
            <div><%= voList.get(i).getNo() %></div>
            <div><a href="/semi/notice/detail?no=<%= voList.get(i).getNo() %>"><%= voList.get(i).getTitle() %></a></div>
            <div><%= voList.get(i).getWriter() %></div>
            <div><%= voList.get(i).getHit() %></div>
        <%}%>

    </div>




</body>
</html>