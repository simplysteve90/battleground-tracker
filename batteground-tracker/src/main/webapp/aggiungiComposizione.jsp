<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Composizione</title>
</head>
<body>
<%String path = request.getContextPath(); %>
<form action="aggiungicomposizione" method="post">
<input type="text" name="nome" placeholder="Inserisci nome composizione">
<button type="submit">Aggiungi</button>

</form>
<form action="<%=path %>/admin/tornaAlProfiloAdmin" method="post">
<button type="submit">Torna indietro</button>
</form>


</body>
</html>