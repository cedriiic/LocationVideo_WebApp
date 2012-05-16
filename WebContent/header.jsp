<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="fr.epsi.location.pojo.Client" %>
<%@page import="fr.epsi.location.pojo.Video" %>
<%@page import="fr.epsi.location.pojo.Location" %>
<%@page import="fr.epsi.location.pojo.Categorie" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="style.css">
		<title>Vidéothèque</title>
	</head>
	
	<div id="topWrapper"> 
		<div id="topBanner"></div> 
		<div id="userpanel">
			<% 
				session = request.getSession();
				Client client = (Client) session.getAttribute("client");
				List<Video> panier = (List<Video>) session.getAttribute("panier");
				if(client == null) {
			%>
				<form method="post" action="login">
					<table id="connexion">
						<tr>
							<td>Email : </td>
							<td><input type="text" name="email" value="<% String email = (String) request.getAttribute("email");
							if (email != null) {
								out.println(email);
							}%>"/>
							<% String erreur = (String) request.getAttribute("erreur");
					      	if (erreur != null) { %>
					           	<strong><span style="color:red; font-weight:bold;"><%=erreur %></span></strong>
					      	<% } %>
						    </td>
						</tr>
						<tr>
							<td>Mot de passe : </td>
							<td><input type="password" name="password" value="<% String password = (String) request.getAttribute("password");
							if(password != null) {
								out.println(password);
							}%>"/></td>
						</tr> 
						<tr>
							<td><a href="formulaireInscription.jsp">Créer un compte</a></td>
							<td align="left" style="text-indent:48px;"><input type="submit" value="Se connecter" /></td>
						</tr>
					</table>
				</form>
			<% }
			else { %>
				<form method="post" action="deconnexion">
					<table>
						<tr>
							<td>Bienvenue, <strong><%=client.getPrenom() %></strong><br /></td>
							<td><input type="submit" value="Déconnexion" /></td>
						<tr>
							<td>Mon panier :</td>
							<td><%= (panier != null)?panier.size():0 %> élément(s)</td>
						</tr>
						<tr>
							<td><a href="panier">Voir le panier</a></td>
							<td align="left"><a href="historique">Mon historique</a></td>
						</tr>
						<tr>
							<td colspan="2"></td>
						</tr>
					</table>
				</form>			
			<% } %>
		</div>
	</div>  
			
	<div id="topnav"> 
		<ul>
			<li id="current" style="border:none">
				<a href="index.jsp" shape="rect">Accueil</a>
			</li>
			<li>
				<a href="nouveautes" shape="rect">Nouveautés</a>
			</li>
			<li>
				<a href="categories" shape="rect">Catégories</a>
			</li>
		</ul> 
	</div>
	
	<body>
   
    <div id="wrapper"> 
		<div id="container"> 
			<div id="content"> 
				<div style="margin-top:20px;">
					<br />