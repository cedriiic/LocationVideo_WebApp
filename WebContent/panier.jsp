<%@ include file="/header.jsp" %>  	

<% String etape = (String) request.getAttribute("etape");  
if(etape == null) { %>
<h1>Mon panier</h1>
	<% String message = request.getParameter("message");
	if(message != null) { %>
		<span style="font-weigh:bold; color:#3A9D23"><%= message %></span>
	<% } 
	
	if(panier == null || panier.size() == 0) {
		out.println("Aucune vidéo dans le panier");
	}
	else { %>	
	<table id="tableVideos">
		<tr>
			<th>Titre</th>
			<th>Catégorie</th>
			<th></th>
		</tr>
		<% for(Video v : panier) { %>
			<tr>
				<form method="post" action="panier">
					<input type="hidden" name="action" value="suppression" />
					<input type="hidden" name="idVideo" value="<%=v.getId() %>" />
					<td><strong><%= v.getTitre() %></strong></td>
					<td></td>
					<td><input type="submit" value="Retirer du panier" /></td>
				</form>
			</tr>
		<% } %>
	</table>
	<form method="get" action="panier">
		<input type="hidden" name="etape" value="2">
		<table>
			<tr><td><input type="submit" value="Valider" /></td></tr>
		</table>
	</form>
	
<%	} 
}
else if(etape.equals("2")){ %>
	<h1>Moyen de paiement</h1>
	<form method="post" action="panier">
	<input type="radio" name="choix" value="CB" id="CB" /> <label for="CB">Carte bancaire</label><br />
    <input type="radio" name="choix" value="VideoClub" id="VideoClub" /> <label for="VideoClub">Carte VideoClub</label><br />
    
    <input type="submit" value="Valider" />
</form>
<% } %>
<%@ include file="/footer.jsp" %>