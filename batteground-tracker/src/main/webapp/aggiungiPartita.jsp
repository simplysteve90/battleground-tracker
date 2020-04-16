<%@page import="it.dstech.model.Eroe"%>
<%@page import="it.dstech.model.Composizione"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Eroe>listaEroi=(List<Eroe>)request.getAttribute("listaEroi");
List<Composizione>listaComposizioni=(List<Composizione>)request.getAttribute("listaComposizioni");
%>
<form action="partita" method="post">
<select size="1" style= "width: 25%" name="eroe" id="eroe">
	<%for (Eroe eroe:listaEroi){ %>
	
	 <option ><%=eroe.getNome() %></option>
	 <%} %>
	</select>
	<select size="1" style= "width: 25%" name="eroe" id="eroe">
	<%for (Composizione comp:listaComposizioni){ %>
	
	 <option ><%=comp.getNome() %></option>
	 <%} %>
	</select>
	<input type="text" name="note">
	<button type="submit" >Aggiungi</button>
	</form>
</body>
</html>