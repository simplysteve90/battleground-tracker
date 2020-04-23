<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="https://bit.ly/2RO89t2" type="image/gif" />
<meta charset="UTF-8">
<title>Lista Partite</title>
</head>
<style>
<%@include file="style.css" %>
</style>
<body>
	<%
		String path = request.getContextPath();
		long partiteGiocate = (long) request.getAttribute("numeroPartite");
		double numeroTopFour = (double) request.getAttribute("numeroTopFour");
		long numeroVincite = (long) request.getAttribute("numeroVincite");
	%>
	<form action="<%=path%>/utente/tornaAlProfilo" method="post">
		<hr>
		<ol>
			<c:forEach items="${listaPartiteUtente}" var="lista">
				<li><c:out value="${lista}" /></li>
			</c:forEach>
		</ol>
		<hr>
		<table>
			<thead>
				<tr>
					<th>Partite Giocate</th>
					<th>Top 4(%)</th>
					<th>Partite Vinte</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=partiteGiocate%></td>
					<td><%=numeroTopFour%>%</td>
					<td><%=numeroVincite%></td>
				</tr>
			</tbody>
		</table>

		<input type="submit" value="Profilo">
	</form>

</body>
</html>