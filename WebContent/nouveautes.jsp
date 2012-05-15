<%@ include file="/header.jsp" %>  	

<% List<Video> listeVideos = (List<Video>) request.getAttribute("listeVideos"); %>

<h1>Nouveautés</h1>
	<table id="tableVideos">
		<tr>
			<th>Titre</th>
			<th>Catégorie</th>
			<th></th>
			<th></th>
		</tr>
		
		<% for(Video v : listeVideos) { %> 
			<tr>
				<td><strong><%= v.getTitre() %></strong></td>
				<td><strong>Catégorie : </strong></td>
				<td><a href="detailFilm?idVideo=<%= v.getId() %>">Lire la suite</a></td>
				<form method="post" action="panier">
					<input type="hidden" name="action" value="ajout" />
					<input type="hidden" name="idVideo" value="<%=v.getId() %>" />
					<td><input type="submit" value="Ajouter au panier" /></td>
				</form>
			</tr>
		<% } %>
	</table>
<%@ include file="/footer.jsp" %>