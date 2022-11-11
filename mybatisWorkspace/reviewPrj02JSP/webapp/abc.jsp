<%
	
%>




<h1>abc</h1>
<h2>hello world</h2>

<div>

	${sessionScope.name}
	
	<%= (String)session.getAttribute("name") %>

	${x}
	
	<%= (String)request.getAttribute("y") %>
	
	<%= (String)request.getAttribute("z") %>
</div>
