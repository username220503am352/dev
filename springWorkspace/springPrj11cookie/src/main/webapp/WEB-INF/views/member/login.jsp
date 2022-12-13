<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인</h1>
	
	<form action="/app/member/login" method="post">
        <table>
            <tbody>
                <tr>
                    <td><label>아이디</label> </td>
                    <td><input type="text" name="memberId"></td>
                </tr>
                <tr>
                    <td><label>비밀번호</label></td>
                    <td><input type="password" name="memberPwd"></td>
                </tr>
                
                <tr>
                    <td>아이디저장<input type="checkbox" name="save" value="true"></td>
                    <td><input style="width: 100%;" type="submit" value="로그인"></td>
                </tr>
            </tbody>
        </table>
    </form>

</body>
</html>