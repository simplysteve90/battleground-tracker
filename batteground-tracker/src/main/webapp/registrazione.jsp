<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="https://bit.ly/2RO89t2" type="image/gif" />
<title>Registrazione</title>
<style>
<%@include file="/static/homepage.css" %>
</style>
</head>
<body>
<div id="scritta"></div>
<form action="registrazione" method="post">
<label for="username" class="label"><b>Email</b></label><br>
<input type="email" required="required" name="email" placeholder="Inserisci l'email"><br>
<label for="username" class="label"><b>Username</b></label><br>
<input type="text" name="username" placeholder="Inserisci l'username" required="required"><br>
<label for="password" class="label" ><b>Password</b></label><br>
<input type="password" name="password" placeholder="Inserisci la password" required="required"><br>
<label for="rating" class="label"><b>Rating</b></label><br>
<input type="number" name="rating" min="0" placeholder="Inserisci il rating" required="required"><br>
<button type="submit" class="pulsante"><b>REGISTRATI</b></button>
</form>
</body>
</html>