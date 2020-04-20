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
<% long partiteGiocate = (long)request.getAttribute("numeroPartite");
	double numeroTopFour = (double) request.getAttribute("numeroTopFour");
	long numeroVincite = (long) request.getAttribute("numeroVincite");
%>
<form action="" method="post">

	<hr>
	<input type="submit" value="Profilo">
</form>
</body>
</html>