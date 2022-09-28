<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
        border: 1px solid blue;
        margin:auto;
    }
    #header-top{
        width: 100%;
        height: 80%;
    	display: grid;
        grid-template-columns: 2fr 5fr 2fr;
    }
    #header-bot{
        width: 100%;
        height: 20%;
        border: 1px solid red;
    }
    #logo-box{
        width: 100%;
        height: 100%;
    }
    #logo-box, #member-box{
        width: 100%;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    #navi{
        width: 100%;
        height: 100%;
        background-color: black;
        color: white;
        font-size: 2rem;
        display: grid;
        grid-template-columns: repeat(4 , 1fr);
    }
    #navi > div{
        width: 10vw;
        height: 20%;
        border: 1px solid gray;
    }
    
</style>

    <div id="header">
        <div id="header-top">
            <div></div>
            <div id="logo-box"><img src="/semi/resources/img/logo.PNG" alt="로고이미지" width="80%" height="60%"></div>
            <div id="member-box">
                <form action="">
                    <table>
                        <tr>
                            <td>아이디</td>
                            <td><input type="text" name="memberId"></td>
                        </tr>
                        <tr>
                            <td>비밀번호</td>
                            <td><input type="password" name="memberPwd"></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="로그인"></td>
                            <td><input type="button" value="회원가입" onclick="location.href='/semi/member/join'"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>

        <div id="header-bot">
            <div id="navi">
                <div>HOME</div>
                <div>공지사항</div>
                <div>일반게시판</div>
                <div>사진게시판</div>
            </div>
        </div>

    </div>
