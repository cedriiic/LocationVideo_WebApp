<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Vidéothèque</title>
</head>
<body>
	<div id="entete">
		<div id="titre">
			Vidéothèque
		</div>
		
		<div id="connexion">
			<% String erreur = (String) request.getAttribute("Erreur");
				if(erreur != null) { %>
					<strong>Erreur : <% out.println(erreur); %></strong>
			<%	} %>
				<form method="post" action="login">
					Login : <input type="text" name="login" />
					Mot de passe : <input type="password" name="password" />
					<input type="submit" name="Valider" value="Valider" />
					<br />
					<a href="">Créer un compte</a>
				</form>
		</div>
	</div>
	
	<div id="corps">
		<div id="menu">
			<ul>
				<li><a href="">Nouveautés</a></li>
				<li><a href="">Genre</a></li>
				<li><a href="">Top 10</a></li>
			</ul>
		</div>
		
		<div id="videos">
			<table>
				<tr>
					<th>Titre</th>
					<th>Genre</th>
					<th>Prix</th>
				</tr>
				
				<tr>
					<td>Le silence des agneaux</td>
					<td>Thriller</td>
					<td>1 euro</td>
				</tr>
				
			</table>
		</div>
		
		<div id="panier">
			<h1>Mon panier</h1>
		</div>
	</div>
</body>
</html>