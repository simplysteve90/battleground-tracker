<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
<%@include file="/static/homepage.css" %>
</style>
<body>
	<%
		String path = request.getContextPath();
	%>
	<hr>
	<ol>
		<c:forEach items="${listaComposizioni}" var="lista">
			<li><c:out value="${lista.getNome()}" /></li>
			<form action="<%=path%>/admin/scelta-modifica-composizione"
				method="post">
				<input type="hidden" name="nome" value="${lista.getNome()}">
				<button type="submit" class="pulsante" name="action">Elimina</button>
				<br>
				<br>
			</form>
		</c:forEach>
	</ol>
	<hr>

	<form action="<%=path%>/admin/tornaAlProfiloAdmin" method="post">
		<button type="submit" class="pulsante">Torna indietro</button>
	</form>
</body>
</html>