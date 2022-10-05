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
		margin: auto;
	}
	form{
		width: 100%;
		height: 100%;
	}
	#join-area{
		width: 100%;
		height: 70%;
		border: 1px solid red;
		display: grid;
		grid-template-columns: 1fr 4fr;
		grid-template-rows: repeat(7 , 1fr);
		justify-items: center;
	}
	#join-area>div{
		width: 80%;
	}
</style>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>
	
	<div id="main">
		<h1 align="center">마이페이지</h1>

		<form action="/semi/member/mypage" method="post" onsubmit="return check();">
			<div id="join-area">
				<div>아이디</div>
				<div><input type="text" name="memberId" value="<%=loginMember.getId()%>"></div>
				<div>비밀번호</div>
				<div><input type="password" name="memberPwd1"></div>
				<div>비밀번호 확인</div>
				<div><input type="password" name="memberPwd2"></div>
				<div>닉네임</div>
				<div><input type="text" name="memberNick" value="<%= loginMember.getNick() %>"></div>
				<div>주소</div>
				<div><input type="text" name="addr" value="<%= loginMember.getAddr() %>"></div>
				<div>취미</div>
				<div>
					<label>코딩
						<input type="checkbox" name="hobby" value="coding">
					</label>
					<label>낚시
						<input type="checkbox" name="hobby" value="fishing">
					</label>
					<label>운동
						<input type="checkbox" name="hobby" value="workout">
					</label>
				</div>
				<div><a href="/semi/member/quit">회원탈퇴</a></div>
				<div><input type="submit" value="정보수정"></div>
			</div>

		</form>

	</div>
	
	<script>
		// 비밀번호 일치여부 체크
		const pwd1 = document.querySelector("input[name=memberPwd1]");
		const pwd2 = document.querySelector("input[name=memberPwd2]");
	
		function check(){
			
			if(pwd1.value.length > 0 && pwd1.value == pwd2.value){
				return true;
			}else{
				alert('패스워드가 일치하지 않습니다');
				return false;
			}
			
		}
	</script>
	
	
	<script>
		//마이페이지 취미 체크
		const hobbyArr = document.querySelectorAll('input[name=hobby]');
		const hobbyStr = '<%= loginMember.getHobby() %>';

		for(let i = 0; i < hobbyArr.length; i++){
			const v = hobbyArr[i].value;
			
			let result = hobbyStr.search(v);
			if(result >= 0){
				hobbyArr[i].checked = true;
			}
		}
	</script>


</body>
</html>












