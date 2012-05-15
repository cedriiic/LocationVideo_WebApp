<%@ include file="/header.jsp" %>  	

<% List<Video> listeVideos = (List<Video>) request.getAttribute("listeVideos"); %>

<h1>Listes des vidéos</h1>
	<% String message = (String) request.getAttribute("message"); 
		if(message != null) { %>
			<span style="font-weigh:bold; color:#3A9D23"><%= message %></span>		
	<%	} %>
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
		<br />
<%@ include file="/footer.jsp" %>  	