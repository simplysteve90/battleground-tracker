<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String path = request.getContextPath(); %>
<form action="<%=path%>/utente/scelta" method="post">
<button type="submit" name="action" value="1">Aggiungi Partita</button>
<button type="submit" name="action" value="2">Lista Partite</button>
<button type="submit" name="action" value="3">Statistiche Eroi</button>
</form>
</body>
</html>