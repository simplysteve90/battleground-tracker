<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Eroi</title>
</head>
<body>
<%String path = request.getContextPath(); %>
<form action="<%=path %>/admin/tornaAlProfiloAdmin" method="post">
<button type="submit">Torna indietro</button>
</form>
	<hr>
	<ol>
		<c:forEach items="${listaEroi}" var="lista">
			<li><c:out value="${lista.getNome()}" /></li>
			 <img src="data:image/png;base64,<c:out value="${lista.getImage()}" />"> 
<form action="<%=path %>/admin/scelta-modifica" method="post">
			<input type="hidden" name="nome" value="${lista.getNome()}">
			<button type="submit" name="action" value="1">Modifica</button><br><br>
			<button type="submit" name="action" value="2">Elimina</button><br><br>
</form>
		</c:forEach>
	</ol>
	<hr>
</body>
</html>