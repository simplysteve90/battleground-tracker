<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" href="https://bit.ly/2RO89t2" type="image/gif" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="tornaAlProfilo" method="post">
	<hr>
	<ol>
		<c:forEach items="${listaPartiteUtente}" var="lista">
			<li><c:out value="${lista}" /></li>
		</c:forEach>
	</ol>
	<hr>
	<input type="submit" value="Profilo">
</form>

</body>
</html>