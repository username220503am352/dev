<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <div id="main-top">
        <a href="/semi/notice/write">글쓰기</a>
    </div>

    <div id="main">

        <div>번호</div>
        <div>제목</div>
        <div>작성자</div>
        <div>조회수</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>관리자</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>관리자</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>관리자</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>관리자</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>관리자</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>관리자</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>관리자</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>관리자</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>관리자</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>관리자</div>
        <div>100</div>

    </div>




</body>
</html>