<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String path = request.getContextPath(); %>
<form action="<%=path %>/admin/tornaAlProfiloAdmin" method="post">
<button type="submit">Torna indietro</button>
</form>

<form action="" method="post">
	<hr>
	<ol>
		<c:forEach items="${listaEroi}" var="lista">
			<li><c:out value="${lista.getNome()}" /></li>
			 <img src="data:image/png;base64,<c:out value="${lista.getImage()}" />"> 
		</c:forEach>
	</ol>
	<hr>
	<input type="submit" value="Profilo">
</form>
</body>
</html>