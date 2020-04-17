<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Benvenuto</title>

<style>
<%@ include file="/static/homepage.css" %>
</style>
</head>
<body>

<div class="colonnasinistra">
<form action= "accesso" method="post">
<input type="text" name="username" >
<input type="password" name="password" >
<button type="submit" value="1" name="action">ACCEDI</button>
<button type="submit" value="2" name="action">REGISTRATI</button>
</form>
</div>
<div class="colonnadestra">
<h1>CIAO</h1>
<br>
<br><br><br><br><br><br><br><br>
</div>


</body>
</html>