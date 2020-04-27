<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../static/style.css">
<meta charset="ISO-8859-1">
<title>Aggiungi Composizione</title>
</head>
<body>
	<%
		String path = request.getContextPath();
	%>
	<div class="container h-100">
    <div class="row align-items-center h-100">
		<div class="col-md-6">
			<c:forEach items="${listaComposizioni}" var="lista">
				<li><c:out value="${lista.getNome()}" /></li>
			</c:forEach>
		</div>
		<div class="col-md-6">
			<form action="<%=path%>/admin/aggiungicomposizione" method="post">
				<input type="text" name="nome" placeholder="Inserisci nome composizione"><br>
				<button type="submit" class="pulsante">Aggiungi</button>
			</form>
			</div>
			</div>
			</div>




	<form action="<%=path%>/admin/tornaAlProfiloAdmin" method="post">
		<button type="submit" class="pulsante">Torna indietro</button>
	</form>


</body>
</html>