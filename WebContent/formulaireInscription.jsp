<%@ include file="/header.jsp" %>

<% 
	String nom	 			= (String) request.getAttribute("nom");
	String prenom 			= (String) request.getAttribute("prenom");
	String datedenaissance 	= (String) request.getAttribute("datedenaissance");
	String adresse			= (String) request.getAttribute("adresse");
	String ville			= (String) request.getAttribute("ville");
	String codepostal 		= (String) request.getAttribute("codepostal");
	String pays				= (String) request.getAttribute("pays");
	String telephone		= (String) request.getAttribute("telephone");
	String login 			= (String) request.getAttribute("login");
	String password			= (String) request.getAttribute("password");
	String password2		= (String) request.getAttribute("password2");
	String email			= (String) request.getAttribute("email");
	
%>

<h1>Création de compte</h1>
<form method="post" action="/creerCompte">
	<table id="formulaire">
		<tr>
			<td>Nom : </td>
			<td><input type="text" name="nom" value="<% if (nom != null) out.println(nom); %>" size="30" /></td>
		</tr>
		
		<tr>
			<td>Prénom : </td>
			<td><input type="text" name="prenom" value="<% if (prenom != null) out.println(prenom); %>" size="30" /></td>
		</tr>
		
		<tr>
			<td>Date de naissance: </td>
			<td><input type="text" name="datedenaissance" value="<% if (prenom != null) out.println(prenom); %>" size="30" /></td>
		</tr>
		
		<tr>
			<td>Adresse : </td>
			<td><input type="text" name="adresse" value="<% if (adresse != null) out.println(adresse); %>" size="30" /></td>
		</tr>
		
		<tr>
			<td>Ville : </td>
			<td><input type="text" name="ville" value="<% if (ville != null) out.println(ville); %>" size="30" /></td>
		</tr>
		
		<tr>
			<td>Code postal : </td>
			<td><input type="text" name="codepostal" value="<% if (codepostal != null) out.println(codepostal); %>" size="30" /></td>
		</tr>
		
		<tr>
			<td>Pays : </td>
			<td><input type="text" name="pays" value="<% if (pays != null) out.println(pays); %>" size="30" /></td>
		</tr>
		
		<tr>
			<td>Téléphone : </td>
			<td><input type="text" name="telephone" value="<% if (telephone != null) out.println(telephone); %>" size="30" /></td>
		</tr>
		
		<tr>
			<td>Login : </td>
			<td><input type="text" name="login" value="<% if (login != null) out.println(login); %>" size="30" /></td>
		</tr>
		
		<tr>
			<td>Mot de passe : </td>
			<td><input type="text" name="password" value="<% if (password != null) out.println(password); %>" size="30" /></td>
		</tr>
		
		<tr>
			<td>Retapez le mot de passe : </td>
			<td><input type="text" name="password2" value="<% if (password2 != null) out.println(password2); %>" size="30" /></td>
		</tr>
		
		<tr>
			<td>Adresse email : </td>
			<td><input type="text" name="email" value="<% if (email != null) out.println(email); %>" size="30" /></td>
		</tr>
		
		<tr>
			<td align="right"><input type="submit" value="Valider" /></td>
			<td><input type="button" value="Annuler" /></td>
		</tr>
	</table>
</form>
<%@ include file="/footer.jsp" %>  