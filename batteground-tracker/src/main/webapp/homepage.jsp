<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="https://bit.ly/2RO89t2" type="image/gif" />
<title>Benvenuto</title>

<style>
<%@include file="/static/homepage.css" %>
</style>
</head>
<body>
<div id="scritta"></div>
<div id="rotate"></div>
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