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

        <div>1</div>
        <div>안녕하세요</div>
        <div>홍길동</div>
        <div>2022-10-11</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>홍길동</div>
        <div>2022-10-11</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>홍길동</div>
        <div>2022-10-11</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>홍길동</div>
        <div>2022-10-11</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>홍길동</div>
        <div>2022-10-11</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>홍길동</div>
        <div>2022-10-11</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>홍길동</div>
        <div>2022-10-11</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>홍길동</div>
        <div>2022-10-11</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>홍길동</div>
        <div>2022-10-11</div>
        <div>100</div>

        <div>1</div>
        <div>안녕하세요</div>
        <div>홍길동</div>
        <div>2022-10-11</div>
        <div>100</div>

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