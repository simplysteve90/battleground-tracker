<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifica Eroe</title>
</head>
<body>
	<%
	String path = request.getContextPath();
	String nome = (String) request.getAttribute("nome");
	%>
<form action="<%=path%>/admin/modifica-eroe" method="post" enctype="multipart/form-data">
Modifica l'eroe <%=nome %>
<input type="hidden" value=<%=nome %> name="nome">
<input type="file" name="immagine">
<input type="text" name="power" placeholder="Hero Power">
<button type="submit">Modifica</button>
</form>
</body>
</html>