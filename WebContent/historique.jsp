<%@ include file="/header.jsp" %>  	

<% List<Location> listeLocations = (List<Location>) request.getAttribute("listeLocations"); %> 
<h1>Historique des vidéos retirées</h1>
<% if(listeLocations != null) { %>
	<table>
		<% for(int i=0; i < listeLocations.size(); i++) { 
			Location l = listeLocations.get(i); %>
		<tr>
			<td><%= l.getExemplaire().getVideo().getTitre() %></td>
			<td><%= l.getDateLocation() %></td>
			<td><%= l.getNbHeuresLocation() %></td>
		</tr>
		<% } %>
	</table>
<% }
else {
	out.println("liste vide");
}%>
<%@ include file="/footer.jsp" %>