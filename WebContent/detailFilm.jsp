<%@ include file="/header.jsp" %>  	
<% if(client == null ) { %>
	<jsp:forward page="index.jsp">
		<jsp:param name="message" value="Veuillez vous connecter pour accéder à cette page." />
	</jsp:forward>
<% }
Video v = (Video) request.getAttribute("video"); %>

<h1>Fiche détaillée</h1>
<form method="post" action="panier">
	<input type="hidden" name="action" value="ajout" />
	<input type="hidden" name="idVideo" value="<%=v.getId() %>" />
	<h2>Titre : <%= v.getTitre() %></h2>
	<p><strong>Durée : </strong><%= v.getDuree() %> minutes</p>
	<p><strong>Date de sortie : </strong><%= v.getDateSortie() %></p>
	<p><strong>Catégorie : </strong><%= v.getCategorie().getLibelle() %></p>
	<p><strong>Prix : </strong><%= v.getPrix() %></p>
	<p><strong>Synopsis : </strong><%= v.getSynopsis() %></p>
	<input type="submit" value="Ajouter au panier" />
</form>
<%@ include file="/footer.jsp" %>