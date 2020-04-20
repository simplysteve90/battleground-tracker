<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Composizione</title>
</head>
<body>
<%String path = request.getContextPath(); %>
<c:forEach items="${listaComposizioni}" var="lista">
			<li><c:out value="${lista.getNome()}" /></li>
		</c:forEach>
<form action="<%=path %>/admin/aggiungicomposizione" method="post">
<input type="text" name="nome" placeholder="Inserisci nome composizione">
<button type="submit">Aggiungi</button>

</form>
<form action="<%=path %>/admin/tornaAlProfiloAdmin" method="post">
<button type="submit">Torna indietro</button>
</form>


</body>
</html>