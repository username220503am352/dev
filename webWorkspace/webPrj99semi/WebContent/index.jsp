<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    /* 공통 */
    html , body {
        padding: 0;
        margin: 0;
    }
    div{
        box-sizing: border-box;
    }

    /* 헤더 */
    #header{
        width: 60vw;
        height: 20vh;
        border: 1px solid black;
        margin:auto;
    }
    #header-top{
        width: 100%;
        height: 80%;
    	display: grid;
        grid-template-columns: 2fr 5fr 2fr;
    }
</style>

</head>
<body>

    <div id="header">

        <div id="header-top">
            <div></div>
            <div><img src="/semi/resources/img/logo.PNG" alt="로고이미지" width="100%" height="100%"></div>
            <div>회원</div>
        </div>
        <div id="header-bot">

        </div>

    </div>

</body>
</html>