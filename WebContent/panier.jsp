<%@ include file="/header.jsp" %>  	
<% if(client == null ) { %>
	<jsp:forward page="index.jsp">
		<jsp:param name="message" value="Veuillez vous connecter pour accéder à cette page." />
	</jsp:forward>
<% }

String etape = (String) request.getAttribute("etape");  
if(etape == null) { %>
<h1>Mon panier</h1>
	<% String message = (String) request.getAttribute("message");
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
					<td><%= v.getCategorie().getLibelle() %></td>
					<td><input type="submit" value="Retirer du panier" /></td>
				</form>
			</tr>
		<% } %>
		<form method="get" action="panier">
			<input type="hidden" name="etape" value="2">
			<tr><td colspan="3" align="right"><input type="submit" value="Valider" /></td></tr>
		</form>
		</table>
	
<%	} 
}
else if(etape.equals("2")){ 
	float total = 0;
	for(Video v : panier) {
		total += v.getPrix();
	}

%>
	<h1>Moyen de paiement</h1>
	<form method="get" action="panier">
		<input type="hidden" name="etape" value="3">
		<strong>Total : <span style="color:#3A9D23"><%= total %> euros</span></strong><br /><br />
		<input type="radio" name="typePaiement" value="Carte Bancaire" id="Carte Bancaire" /> <label for="CB">Carte bancaire</label><br /><br />
	    <input type="radio" name="typePaiement" value="Carte Video Club" id="Carte Video Club" /> <label for="VideoClub">Carte VideoClub</label><br /><br />
	    <input type="submit" value="Valider" />
	</form>
<% }
else if(etape.equals("3")) {
	String typePaiement = (String) request.getAttribute("typePaiement"); %>	
	<% if(typePaiement.equals("Carte Bancaire")) { %>
		<%@ include file="/paiementCarteBancaire.jsp" %>			
	<% }
	else { %>
		<%@ include file="/paiementCarteVideoClub.jsp" %>
	<% } 
} %>
<%@ include file="/footer.jsp" %>