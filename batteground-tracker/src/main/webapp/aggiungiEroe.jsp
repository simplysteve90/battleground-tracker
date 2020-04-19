<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aggiunta Eroe</title>
</head>
<body>
<%String path = request.getContextPath(); %>
<form action="<%=path%>/admin/aggiungi-eroe" method="post" enctype="multipart/form-data">
<input type="file" name="immagine">
<input type="text" name="nome" placeholder="Nome">
<input type="text" name="power" placeholder="Hero Power">
<button type="submit">Aggiungi</button>
</form>
<form action="<%=path %>/admin/tornaAlProfiloAdmin" method="post">
<button type="submit">Torna indietro</button>
</form>
</body>
</html>