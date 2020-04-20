<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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
				<th>Power </th>
			</tr>
		</thead>
		<c:forEach items="${listaEroi}" var="lista">
<tbody>
<tr>
			<td><c:out value="${lista.getEroe()}" /></td>
			<td><c:out value="${lista.getHeroPower()}" /></td>
		</tr>
		</c:forEach>
</tbody>
	</table>
	<hr>
	<form action="<%=path%>/admin/aggiungi-eroe" method="post"
		enctype="multipart/form-data">
		<input type="file" name="immagine"> <input type="text"
			name="nome" placeholder="Nome"> <input type="text"
			name="power" placeholder="Hero Power">
		<button type="submit">Aggiungi</button>
	</form>
	<form action="<%=path%>/admin/tornaAlProfiloAdmin" method="post">
		<button type="submit">Torna indietro</button>
	</form>
</body>
</html>