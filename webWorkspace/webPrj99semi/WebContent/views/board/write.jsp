<%@page import="java.util.List"%>
<%@page import="com.kh.semi.board.vo.CategoryVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	List<CategoryVo> cateList = (List<CategoryVo>)request.getAttribute("cateList");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer{
		background: black;
		color: white;
		width: 60%;
		height: 550px;
		margin: auto;
		padding-top: 50px;
	}

	#enroll-form table{border: 1px solid white; margin:auto;}
	#enroll-form input, #enroll-form textarea{
		width: 100%;
		box-sizing: border-box;
	}

</style>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>
	
	<div id="main">

		<div class="outer">
        <br>
        <h2 align="center">일반게시판 작성하기</h2>
        <br>

        <form id="enroll-form" action="" method="post">

            <!-- 카테고리, 제목, 내용, 첨부파일 한개 -->
            <table>
                <tr>
                    <th width="70px">카테고리</th>
                    <td width="500px">
                        <select name="category">
                            <!-- CTEGORY 테이블로부터 조회해오기 -->
                            <%for(int i = 0 ; i < cateList.size(); ++i){%>
		                    	<option value="<%= cateList.get(i).getNo() %>"><%= cateList.get(i).getName() %></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="content" rows="10" style="resize:none;" required></textarea></td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td><input type="file" name="f"></td>
                </tr>
            </table>

            <div align="center">
                <button type="submit">작성하기</button>
                <button type="reset">취소하기</button>
            </div>

        </form>
        

    </div>

	</div>

</body>
</html>