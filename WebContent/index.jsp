<%@ include file="/header.jsp" %>  	
<h1>Bienvenue sur Planet DVD</h1>
<%
	String message = (String) request.getAttribute("message");
	if(message != null) { %>
		<%= message %>
<%	} %>
<br />
<%@ include file="/footer.jsp" %>  		