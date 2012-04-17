<%@ include file="/header.jsp" %>  

<div> 
   	<h1>Accueil</h1>  
   	<table id="liste_films">
   		<tr>
   			<th>Titre</th>
   			<th>Catégorie</th>
   			<th>Prix</th>
   			<th></th>
   		</tr>
   		<% for (int i=0; i < 10; i++) { %>
   				<tr>
   					<td>Titre <%= i %></td>
   					<td>Action</td>
   					<td>10 euros</td>
   					<td><button>Ajouter au panier</button></td>
   				</tr>
   		<% } %>
   	</table>
 </div>
						
<%@ include file="/footer.jsp" %>  		