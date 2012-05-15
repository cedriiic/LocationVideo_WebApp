<%@ include file="/header.jsp" %>  	
<% if(client == null ) { %>
	<jsp:forward page="index.jsp">
		<jsp:param name="message" value="Veuillez vous connecter pour accéder à cette page." />
	</jsp:forward>
<% }

List<Categorie> listeCategories = (List<Categorie>) request.getAttribute("listeCategories");
List<Video> listeVideos = (List<Video>) request.getAttribute("listeVideos"); 
int idCategorie = -1;
if(request.getAttribute("idCategorie") != null)
	idCategorie = (Integer) request.getAttribute("idCategorie");
%>

<h1>Catégories</h1> 
	Sélectionnez une catégorie :
	<form method="post" action="categories"> 
		<select name="choix_categorie" onchange="submit();">
			<option value="-1">-- Tous --</option>
			<% for (Categorie c : listeCategories) { %>
				<option value="<%= c.getId() %>" <% if(idCategorie == c.getId()) out.print("selected=\"selected\""); %> ><%= c.getLibelle() %> </option>
			<% } %>
		</select>
	</form>
	<br />
	<table id="tableVideos">
		<tr>
			<th>Titre</th>
			<th>Catégorie</th>
			<th>Prix</th>
			<th></th>
			<th></th>
		</tr>
		<% if(listeVideos != null) {
			for(Video v : listeVideos) { %> 
				<tr>
					<td><strong><%= v.getTitre() %></strong></td>
					<td><strong><%= v.getCategorie().getLibelle() %></strong></td>
					<td><strong><%= v.getPrix() %> euros</strong></td>
					<td><a href="detailFilm?idVideo=<%= v.getId() %>">Lire la suite</a></td>
					<form method="post" action="panier">
						<input type="hidden" name="action" value="ajout" />
						<input type="hidden" name="idVideo" value="<%=v.getId() %>" />
						<td><input type="submit" value="Ajouter au panier" /></td>
					</form>
				</tr>
			<% } 
		} %>
		
	</table>
<%@ include file="/footer.jsp" %>