<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statistiche Eroe</title>
</head>
<body>
<%
		String path = request.getContextPath();
%>
	<form action="<%=path%>/utente/statistiche-eroe" method="post">
		<select size="1" class="select" style="width: 25%" name="eroe"
			id="eroe">
			<c:forEach items="${listaEroi}" var="lista">
				<option><c:out value="${lista.getNome()}" /></option>
			</c:forEach>
		</select><br>
		<button type="submit">Cerca</button>
	</form>
<table>
		<thead>
			<tr>
				<td>Nome</td>
				<td>Partite Giocate</td>
				<td>Top 4</td>
				<td>Partite Vinte</td>
				<td><c:forEach items="${listaComposizioni}" var="lista">
						<option><c:out value="${lista.getNome()}" /></option>
					</c:forEach></td>
			</tr>
		</thead>
	
	</table>
</body>
</html>