<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="static/style.css">
<meta charset="UTF-8">
<title>Modifica Eroe</title>
</head>
<body>
<div id="scritta"></div>
	<%
	String path = request.getContextPath();
	String nome = (String) request.getAttribute("nome");
	String power = (String) request.getAttribute("power");
	String costo = (String) request.getAttribute("costo");
	String descrizione = (String) request.getAttribute("descrizione");
	String immagine = (String) request.getAttribute("immagine");
	%>
<form action="<%=path%>/admin/modifica-eroe" method="post" enctype="multipart/form-data">
Modifica l'eroe <%=nome %>
<input type="hidden" value=<%=nome %> name="nome">
 <img src="data:image/png;base64,<%=immagine %>" style="max-height:100%; max-width:100%; width:90px; height:90px;">
<input type="file" name="immagine">
<input type="text" name="power" value=<%=power %> placeholder="Hero Power">
<input type="text" name="costo" value=<%=costo %> placeholder="Hero Power">
<input type="text" name="descrizione" value=<%=descrizione %> placeholder="Hero Power">
<button type="submit">Modifica</button>
</form>
</body>
</html>