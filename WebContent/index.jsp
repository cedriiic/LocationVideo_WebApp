<%@ include file="/header.jsp" %>  	
<h1>Bienvenue sur Planet DVD</h1>
<%
	String message = (String) request.getAttribute("message");
	if(message != null) { %>
		<span style="font-weight:bold; color:red; font-size:18px"><%= message %></span>
<%	} %>
<br />
<%@ include file="/footer.jsp" %>  		