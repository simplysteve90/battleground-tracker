<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="static/style.css">
<meta charset="UTF-8">
<title>Aggiunta Eroe</title>
</head>
<body>

	<hr>
	<%
		String path = request.getContextPath();
	%>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>HeroPower </th>
				<th>Costo  </th>
				<th>Descrizione</th>
			</tr>
		</thead>
		<c:forEach items="${listaEroi}" var="lista">
			<tbody>
				<tr>
					<td><c:out value="${lista.getNome()}" /></td>
					<td><c:out value="${lista.getHeroPower()}" /></td>
					<td><c:out value="${lista.getCosto()}" /></td>
					<td><c:out value="${lista.getDescrizione()}" /></td>
				</tr>
		</c:forEach>
		</tbody>
	</table>
	<hr>
	<form action="<%=path%>/admin/aggiungi-eroe" method="post"
		enctype="multipart/form-data">
		<input type="file" name="immagine" required="required"><br> <input
			type="text" name="nome" placeholder="Nome"> <br> 
			<select name="power">
			<option value="Passivo">Passivo</option>
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select>
<!-- 	 <input type="text" name="power" placeholder="Hero Power"><br> -->
		<input type="text" name="costo" placeholder="Costo"> <br>
		<input type="text" name="descrizione" placeholder="Descrizione">
		<br>
		<button type="submit" class="pulsante">Aggiungi</button>
		<br>
	</form>
	<form action="<%=path%>/admin/tornaAlProfiloAdmin" method="post">
		<button type="submit" class="pulsante">Torna indietro</button>
	</form>
</body>
</html>