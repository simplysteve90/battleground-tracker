<%@page import="it.dstech.model.Eroe"%>
<%@page import="it.dstech.model.Composizione"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="https://bit.ly/2RO89t2" type="image/gif" />
<meta charset="ISO-8859-1">
<title>Aggiungi Partita</title>
<style>
<%@include file="/static/homepage.css" %>
</style>
</head>
<body>
<%List<Eroe>listaEroi=(List<Eroe>)request.getAttribute("listaEroi");
List<Composizione>listaComposizioni=(List<Composizione>)request.getAttribute("listaComposizioni");
String path = request.getContextPath();
%>
<form action="<%=path %>/utente/partita" method="post">
<select size="1" class="select" style= "width: 25%" name="eroe" id="eroe"><br>
	<%for (Eroe eroe:listaEroi){ %>
	
	 <option ><%=eroe.getNome() %></option><br>
	 <%} %>
	</select><br>
	<select size="1" class="select" style= "width: 25%" name="composizione" id="eroe"><br>
	<%for (Composizione comp:listaComposizioni){ %>
	
	 <option ><%=comp.getNome() %></option><br>
	 <%} %>
	</select><br>
	<input type="number" name="punteggio"><br>
	<input type="number" min="1" max="8" name="posizione"><br>
	<input type="text" name="note" ><br>
	<button type="submit" >Aggiungi</button>
	</form>
</body>
</html>