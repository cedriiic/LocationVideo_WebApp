<%@ include file="/header.jsp" %>  	

<% Video v = (Video) request.getAttribute("video"); %>

<h1>Fiche d�taill�e</h1>
<form method="post" action="panier">
	<input type="hidden" name="action" value="ajout" />
	<input type="hidden" name="idVideo" value="<%=v.getId() %>" />
	<h2>Titre : <%= v.getTitre() %></h2>
	<p><strong>Dur�e : </strong><%= v.getDuree() %> minutes</p>
	<p><strong>Cat�gorie : </strong></p>
	<p><strong>Synopsis : </strong><%= v.getSynopsis() %></p>
	<input type="submit" value="Ajouter au panier" />
</form>
<%@ include file="/footer.jsp" %>