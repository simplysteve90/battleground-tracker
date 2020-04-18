<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="https://bit.ly/2RO89t2" type="image/gif" />
<meta charset="ISO-8859-1">
<title>ProfiloUtente</title>
<style>
<%@include file="/static/homepage.css" %>
</style>
</head>
<body>
<div id="scritta"></div>
<%String path = request.getContextPath(); %>
<form action="<%=path%>/utente/scelta" method="post">
<button type="submit" class="pulsante" name="action" value="1">Aggiungi Partita</button><br><br>
<button type="submit" class="pulsante" name="action" value="2">Lista Partite</button><br><br>
<button type="submit" class="pulsante" name="action" value="3">Statistiche Eroi</button>
</form>
</body>
</html>