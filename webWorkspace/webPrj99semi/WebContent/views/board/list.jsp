<%@page import="com.kh.semi.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<BoardVo> voList = (List<BoardVo>)request.getAttribute("voList");
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
        margin: 0 auto;
        display: grid;
        grid-template-columns: 1fr 5fr 3fr 3fr 1fr;
        grid-template-rows: repeat(13 , 30px);
        align-content: center;
    }

    #main>div{
        border-bottom: 1px dashed black;
    }

    #main > #page-area{
        grid-column: span 5;
        text-align: center;
        margin-top: 20px;
        border-bottom: none;
    }

    #main-top{
        grid-column: span 5;
        row-gap: 50px;
        display: flex;
        flex-direction: row-reverse;
    }

</style>

</head>

<body>

	<%@ include file="/views/common/header.jsp" %>

    <div id="main">

        <div id="main-top">
            <a href="/semi/board/write" class="btn btn-primary">글쓰기</a>
        </div>

        <div>번호</div>
        <div>제목</div>
        <div>작성자</div>
        <div>작성일시</div>
        <div>조회수</div>

		<%for(int i = 0; i < voList.size(); ++i){%>
			<div><%= voList.get(i).getNo() %></div>
	        <div><%= voList.get(i).getTitle() %></div>
	        <div><%= voList.get(i).getWriter() %></div>
	        <div><%= voList.get(i).getEnrollDate() %></div>
	        <div><%= voList.get(i).getHit()%></div>
		<%}%>

        <div id="page-area">
            <a href="/semi/board/list?p=1" class="btn btn-primary btn-sm">1</a>
            <a href="/semi/board/list?p=2" class="btn btn-primary btn-sm">2</a>
            <a href="/semi/board/list?p=3" class="btn btn-primary btn-sm">3</a>
            <a href="/semi/board/list?p=4" class="btn btn-primary btn-sm">4</a>
            <a href="/semi/board/list?p=5" class="btn btn-primary btn-sm">5</a>
        </div>


    </div>

</body>
</html>