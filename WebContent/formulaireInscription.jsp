<%@ include file="/header.jsp" %>
<h1>Création de compte</h1>
<form method="post" action="/creerCompte">
	<table>
		<tr>
			<td>Nom : </td>
			<td><input type="text" name="nom" value="" /></td>
		</tr>
		
		<tr>
			<td>Prénom : </td>
			<td><input type="text" name="prenom" value="" /></td>
		</tr>
		
		<tr>
			<td>Login : </td>
			<td><input type="text" name="login" value="" /></td>
		</tr>
		
		<tr>
			<td>Mot de passe : </td>
			<td><input type="text" name="password" value="" /></td>
		</tr>
		
		<tr>
			<td>Retapez le mot de passe : </td>
			<td><input type="text" name="nom" value="" /></td>
		</tr>
		
		<tr>
			<td>Adresse email : </td>
			<td><input type="text" name="email" value="" /></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Valider" /></td>
			<td><input type="button" value="Annuler" /></td>
		</tr>
	</table>
</form>
<%@ include file="/footer.jsp" %>  