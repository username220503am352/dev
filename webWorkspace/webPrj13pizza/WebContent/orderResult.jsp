<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>주문 내역</h1>
	
	<!-- 사용자가 입력한 데이터들 쭉 보여주기 -->
	
	<%-- <%
		request.setCharacterEncoding("UTF-8");
		String[] sideArr = request.getParameterValues("side");
		String str = String.join(",", sideArr);

		String topping = "";
		String toppingTemp = request.getParameter("topping");
		if("co".equals(toppingTemp)){
			topping = "콤비네이션피자";
		}else if("pp".equals(toppingTemp)){
			topping = "페페로니피자";
		}
		else if("ch".equals(toppingTemp)){
			topping = "치즈피자";
		}
		else if("sp".equals(toppingTemp)){
			topping = "고구마피자";
		}
		else if("hm".equals(toppingTemp)){
			topping = "하와이안민트초코";
		}

		String dough = "";
		String doughTemp = request.getParameter("dough");
		if("th".equals(doughTemp)){
			dough = "씬 도우";
		}else if("cc".equals(doughTemp)){
			dough = "치즈크러스트 도우";
		}else if("et".equals(doughTemp)){
			dough = "에그타르트 도우";
		}
		
		String side = "";
		String[] sideTemp = request.getParameterValues("side");
		for(int i = 0 ; i < sideTemp.length; ++i){
			if("sp".equals(sideTemp[i])){
				side += "스파게티 ";
			}else if("cs".equals(sideTemp[i])){
				side += "콘샐러드 ";
			}else if("cb".equals(sideTemp[i])){
				side += "치즈볼 ";
			}
		}
		
		String addr = request.getParameter("addr");
		String phone = request.getParameter("phone");
	%> --%>
	
	<%-- <%
		String[] sideArr = request.getParameterValues("side");
		for(int i = 0 ; i < sideArr.length; ++i){
			out.write(sideArr[i]);
		}
	%> --%>
	
	<%
		String addr = (String)request.getAttribute("addr");
		String phone = (String)request.getAttribute("phone");
		String topping = (String)request.getAttribute("topping");
		String dough = (String)request.getAttribute("dough");
		String side = (String)request.getAttribute("side");
	%>
	
	<table border="1">
		<tr>
			<td>주소</td>
			<td><%= addr %></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><%= phone %></td>
		</tr>
		<tr>
			<td>토핑</td>
			<td><%= topping %></td>
		</tr>
		<tr>
			<td>도우</td>
			<td><%= dough %></td>
		</tr>
		<tr>
			<td>사이드</td>
			<td><%=side%></td>
		</tr>
	</table>

</body>
</html>








