<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Utenti</title>
</head>
<style>
<%@include file="style.css" %>
</style>
<body>
<div id="scritta"></div>
<%String path = request.getContextPath(); %>
<form action="<%=path %>/admin/tornaAlProfiloAdmin" method="post">
<button type="submit">Torna indietro</button>
</form>
	<table>
	<thead>
	<tr>
	<th>Username</th>
	<th>Email</th>
	<th>Rating</th>
	<th>Active</th>
	</tr>
	</thead>
		<c:forEach items="${listaUtenti}" var="lista">
	<tbody>
	<tr>
	<td><c:out value="${lista.getUsername()}" /> </td>
	<td><c:out value="${lista.getEmail()}" /> </td>
	<td><c:out value="${lista.getRating()}" /> </td>
	<td><c:out value="${lista.isActive()}" /> </td>
	<td><form action="<%=path %>/admin/elimina-utente" method="post">
			<input type="hidden" name="username" value="${lista.getUsername()}">
			<button type="submit" name="action">Elimina</button><br><br>
</form></td>
	</tr>
	</tbody>
		</c:forEach>
	</table>
	<hr>
</body>
</html>