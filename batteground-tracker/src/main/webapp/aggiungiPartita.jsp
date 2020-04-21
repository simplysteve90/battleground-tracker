<%@page import="it.dstech.model.Eroe"%>
<%@page import="it.dstech.model.Composizione"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
<%
String path = request.getContextPath();
%>
<form action="<%=path %>/utente/partita" method="post">
<select size="1" class="select" style= "width: 25%" name="eroe" id="eroe">
<c:forEach items="${listaEroi}" var="lista">
			<option><c:out value="${lista.getNome()}" /></option>
		</c:forEach>
</select><br>
	<select size="1" class="select" style= "width: 25%" name="composizione" id="eroe">
	<c:forEach items="${listaComposizioni}" var="listaComp">
			<option><c:out value="${listaComp.getNome()}" /></option>
		</c:forEach>
	</select><br>
	<input type="number" name="punteggio" placeholder="Punteggio" required="required"><br>
	<input type="number" min="1" max="8" name="posizione" placeholder="Posizione" required="required"><br>
	<input type="text" name="note" placeholder="Note" required="required"><br>
	<button type="submit" class="pulsante" >Aggiungi</button>
	</form>
	<form action="<%=path%>/utente/tornaAlProfilo" method="post">
	<input type="submit" value="Torna Al Profilo">
	</form>
</body>
</html>