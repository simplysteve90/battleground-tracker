<%@page import="it.dstech.model.Utente"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statistiche Partite</title>
</head>
<body>
	<%
		String path = request.getContextPath();
		String nome = (String) request.getAttribute("nome");
		Utente utente = (Utente) request.getAttribute("utente");
	%>


	<form action="<%=path%>/utente/statistiche-eroe" method="post">
		<select size="1" class="select" style="width: 25%" name="eroe"
			id="eroe">

			<c:forEach items="${listaEroi}" var="lista">
				<option value="${lista.getNome()}">${lista.getNome()}</option>
			</c:forEach>
		</select><br>
		<button type="submit">Cerca</button>
	</form>
	<form action="<%=path%>/utente/tornaAlProfilo" method="post">
		<input type="submit" value="Torna Al Profilo">
	</form>
	
	<table>
		<thead>
			<tr>
				<th>Rating iniziale</th>
				<th>Rating attuale</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=utente.getRatingIniziale()%></td>
				<td><%=utente.getRating()%></td>
			</tr>
		</tbody>
	</table>
	<%
		if (nome != null) {
	%>
	<%
		long topFourEroe = (long) request.getAttribute("numeroTopFourEroe");
			long vincitaEroe = (long) request.getAttribute("numeroVinciteEroe");
			long partiteEroe = (long) request.getAttribute("numeroPartiteEroe");
			double topFourEroePercentuale = (double) request.getAttribute("numeroTopFourEroePercentuale");
	%>
	<table>
		<thead>
			<tr>
				<th>Partite Giocate</th>
				<th>Top 4</th>
				<th>Partite Vinte</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=partiteEroe%></td>
				<td><%=topFourEroe%> (<%=topFourEroePercentuale%>)</td>
				<td><%=vincitaEroe%></td>
			</tr>
		</tbody>
	</table>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Composizione</th>
				<th>Posizione</th>
				<th>Punteggio</th>
				<th>Note</th>
			</tr>
		</thead>
		<c:forEach items="${listaPartite}" var="listaPartite">
			<tbody>
				<tr>
					<td><c:out value="${listaPartite.getEroe()}" /></td>
					<td><c:out value="${listaPartite.getComposition()}" /></td>
					<td><c:out value="${listaPartite.getPosizione()}" /></td>
					<td><c:out value="${listaPartite.getPunteggio()}" /></td>
					<td><c:out value="${listaPartite.getNote()}" /></td>
				</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<table>
	<thead>
	<tr>
	<th>Composizione</th>
	<th>Top 4 (%)</th>
	</tr>
	</thead>
		<c:forEach var="entry" items="${mappaComposizioneEroe}">
			<tr>
				<td><c:out value="${entry.key}" /></td>
				<td><c:out value="${entry.value}" /></td>
			</tr>
		</c:forEach>
	</table>


	<%
		}
	%>
</body>
</html>