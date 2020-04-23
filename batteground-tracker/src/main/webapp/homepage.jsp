<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="https://bit.ly/3cFpBIa" type="image/gif" >
<link rel="stylesheet" type="text/css" href="style.css">
<meta charset="ISO-8859-1">
<title>Benvenuto</title>
<style>
<%@include file="style.css" %>
</style>
</head>
<body>
		<form action="accesso" method="post">
		<label for="username" class="label"><b>Username</b></label><br>
			<input type="text" name="username" placeholder="Inserisci l'username"><br>
			<label for="password" class="label"><b>Password</b></label><br>
			 <input type="password" name="password" placeholder="Inserisci la password"><br>
			<button type="submit" value="1" class="pulsante" name="action"><b>ACCEDI</b></button>
			<button type="submit" class="pulsante" value="2" name="action"><b>REGISTRATI</b></button><br>
		</form>	
</body>
</html>