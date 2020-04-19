<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String path = request.getContextPath(); %>
<form action="" method="post">
	<hr>
	<ol>
		<c:forEach items="${listaComposizioni}" var="lista">
			<li><c:out value="${lista}" /></li>
		</c:forEach>
	</ol>
	<hr>
</form>
<form action="<%=path %>/admin/tornaAlProfiloAdmin" method="post">
<button type="submit">Torna indietro</button>
</form>
</body>
</html>