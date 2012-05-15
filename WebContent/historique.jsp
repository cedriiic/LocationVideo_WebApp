<%@ include file="/header.jsp" %>  	
<% if(client == null ) { %>
	<jsp:forward page="index.jsp">
		<jsp:param name="message" value="Veuillez vous connecter pour accéder à cette page." />
	</jsp:forward>
<% }

List<Location> listeLocations = (List<Location>) request.getAttribute("listeLocations"); %> 
<h1>Historique des vidéos retirées</h1>
<% if(listeLocations != null) { %>
	<table id="tableVideos">
		<tr>
			<th>Titre</th>
			<th>Date de location</th>
			<th>Nombre d'heures de location</th>
		</tr>
		<% for(Location l : listeLocations) { %>
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