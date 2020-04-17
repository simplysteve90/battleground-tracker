<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="registrazione" method="post">
<input type="text" name="username" required="required">
<input type="password" name="password" required="required">
<input type="number" name="rating" min="0" required="required">
<button type="submit">Submit</button>
</form>
</body>
</html>