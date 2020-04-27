<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="static/style.css">
<meta charset="UTF-8">
<title>Eroi</title>
</head>
<body>
<%String path = request.getContextPath(); %>
	<hr>
	<table style="border-collapse: collapse; width: 100%;">
	<thead>
	<tr>
	<th>Nome</th>
	<th>Immagine</th>
	<th>Hero Power</th>
	<th>Costo</th>
	<th>Descrizione</th>
	</tr>
	</thead>
	
		<c:forEach items="${listaEroi}" var="lista">
	<tbody>
	<tr>
	<td><c:out value="${lista.getNome()}" /></td>
	<td style="width:90px; height:90px;"> <img src="data:image/png;base64,<c:out value="${lista.getImage()}"/>" style="max-height:100%; max-width:100%"> </td>
	<td><c:out value="${lista.getHeroPower()}" /></td>
	<td><c:out value="${lista.getCosto()}" /></td>
	<td><c:out value="${lista.getDescrizione()}" /></td>
	<td>
<form action="<%=path %>/admin/scelta-modifica" method="post" enctype="multipart/form-data">
			<input type="hidden" name="nome" value="${lista.getNome()}">
			<input type="hidden" name="immagine" value="${lista.getImage()}">
			<input type="hidden" name="power" value="${lista.getHeroPower()}">
			<input type="hidden" name="costo" value="${lista.getCosto()}">
			<input type="hidden" name="descrizione" value="${lista.getDescrizione()}">
			<button type="submit" class="pulsante" name="action" value="1">Modifica</button>
			<button type="submit" class="pulsante" name="action" value="2">Elimina</button>
</form>
	</td>
	</tr>
		</c:forEach>
	</tbody>
	
	</table>
			
			
<form action="<%=path %>/admin/tornaAlProfiloAdmin" method="post">
<button type="submit" class="pulsante">Torna indietro</button>
</form>
	<hr>
</body>
</html>