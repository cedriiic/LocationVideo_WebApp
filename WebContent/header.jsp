<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<% if(1==1) { %>
				<form method="post" action="login">
					<table>
						<tr>
							<td>Login : </td>
							<td><input type="text" name="login" />
								<% String erreur = (String) request.getAttribute("erreur");
						      		if (erreur != null) { %>
						            	<strong><span style="text-indent:5px; color:red; font-weight:bold;"><% out.println(erreur); %></span></strong>
						      		<% } %>
						    </td>
						</tr>
						<tr>
							<td>Mot de passe : </td>
							<td><input type="password" name="password" /></td>
						</tr> 
						<tr>
							<td><a href="formulaireInscription.jsp">Créer un compte</a></td>
							<td align="left" style="text-indent:48px;"><input type="submit" value="Se connecter" /></td>
						</tr>
					</table>
				</form>
			<% }
			else { %>
				Bienvenue, LOGIN A METTRE
				<table>
					<tr>
						<td>Mon panier : X élément(s)</td>
					</tr>
					<tr>
						<td><a href="/panier">Voir le panier</a></td>
					</tr>
				</table>
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
			<li>
				<a href="top10" shape="rect">TOP 10</a>
			</li>
		</ul> 
	</div>
	
	<body>
   
    <div id="wrapper"> 
		<div id="container"> 
			<div id="content"> 
				<div style="margin-top:20px;"> 
					<div class="one_fourth"> 
						<div class="bloc rounded"> 
							<h3>Battleship</h3>  
							<p> 
								<img src="images/affiches/battleship.jpg" style="float:right;margin:0 0 0 8px" />
							</p> 
						</div> 
					</div>  
					<div class="one_fourth"> 
						<div class="bloc rounded"> 
							<h3>Projet X</h3>  
							<p> 
							  <img src="images/affiches/projetx.jpg" style="float:right;margin:0 0 0 8px" />
							</p> 
						</div> 
					</div>  
					<div class="one_fourth"> 
						<div class="bloc rounded"> 
							<h3>John Carter</h3>  
							<p> 
							  <img src="images/affiches/johncarter.jpg" style="float:right;margin:0 0 0 8px" />
							</p> 
						</div> 
					</div>  
					<div class="one_fourth last"> 
						<div class="bloc rounded"> 
					    	<h3>The Avengers</h3>  
					    	<p> 
					      		<img src="images/affiches/avengers.jpg" style="float:right;margin:0 0 0 8px" />
					      	</p> 
					    </div> 
				  	</div>