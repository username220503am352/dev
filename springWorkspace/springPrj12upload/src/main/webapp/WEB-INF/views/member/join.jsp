<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원가입</h1>

	<form action="/app/member/join" method="post" enctype="multipart/form-data">
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
                    <td><label>닉네임</label> </td>
                    <td><input type="text" name="memberNick"></td>
                </tr>
                <tr>
                    <td><label>사진</label> </td>
                    <td><input multiple="multiple" type="file" name="profile"></td>
                </tr>
                <tr>
                    <td colspan="2"><input style="width: 100%;" type="submit" value="회원가입"></td>
                </tr>
            </tbody>
        </table>
    </form>

</body>
</html>