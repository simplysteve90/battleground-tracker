<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="static/style.css">
<meta charset="ISO-8859-1">
<title>Aggiungi Composizione</title>
</head>
<body>
<%String path = request.getContextPath(); %>
<c:forEach items="${listaComposizioni}" var="lista">
			<li><c:out value="${lista.getNome()}" /></li>
		</c:forEach>
<form action="<%=path %>/admin/aggiungicomposizione" method="post">
<input type="text" name="nome" placeholder="Inserisci nome composizione"><br>
<button type="submit" class="pulsante">Aggiungi</button>

</form>
<form action="<%=path %>/admin/tornaAlProfiloAdmin" method="post">
<button type="submit" class="pulsante">Torna indietro</button>
</form>


</body>
</html>