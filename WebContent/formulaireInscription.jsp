<%@ include file="/header.jsp" %>
<%@ page import="java.util.List" %>
<% 
	String nom	 			= request.getParameter("nom");
	String prenom 			= request.getParameter("prenom");
	String datedenaissance 	= request.getParameter("datedenaissance");
	String adresse			= request.getParameter("adresse");
	String ville			= request.getParameter("ville");
	String codepostal 		= request.getParameter("codepostal");
	String pays				= request.getParameter("pays");
	String telephone		= request.getParameter("telephone");
	String password			= request.getParameter("password");
	String password2		= request.getParameter("password2");
	String email			= request.getParameter("email");
	String message 			= (String) request.getAttribute("message");
	String etatInsertion	= (String) request.getAttribute("etatInsertion");
%>
	<h1>Création de compte</h1>
<%	if(etatInsertion == null || etatInsertion.equals("erreur")) { %>
		
		<% if(message != null) { %>
			<span style="color:red; font-size:18px; font-weight:bold;"><%=message %></span><br /><br />
		<%} %>
		
		<form method="post" action="inscription">
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
					<td>Mot de passe : </td>
					<td><input type="password" name="password" value="<% if (password != null) out.println(password); %>" size="30" /></td>
				</tr>
				
				<tr>
					<td>Retapez le mot de passe : </td>
					<td><input type="password" name="password2" value="<% if (password2 != null) out.println(password2); %>" size="30" /></td>
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
<% 	}
	else { %>
	<%=message %><br /><br />
	<a href="index.jsp">Retour à l'accueil</a>
<%	}
%>
<%@ include file="/footer.jsp" %>  