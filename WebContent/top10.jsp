<%@ include file="/header.jsp" %>  	

<% List<Video> listeVideos = (List<Video>) request.getAttribute("listeVideos"); %>

<h1>Top 10</h1>
	<% int indice = 1;
		for(Video v : listeVideos) { %>
			<table>
				<tr>
					<td><%=indice %></td>
					<td><%= v.getTitre() %></td>
					<td>Cat�gorie</strong></td>
				</tr>
			</table>
		
	<% indice++; 
	} %>
<%@ include file="/footer.jsp" %>  	