<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="fr.epsi.location.pojo.Video" %>    
<%@ include file="/header.jsp" %>  	

<% session = request.getSession(); 
List<Video> listeVideos = (List<Video>) request.getAttribute("listeVideos"); %>

<h1>Listes des vidéos</h1>
<table>
	<% for(Video v : listeVideos) { %>
		<tr>
			<td><%= v.getTitre() %></td>
			<td><%= v.getDuree() %></td>
		</tr>
	<% } %>
</table>
<%@ include file="/footer.jsp" %>  	