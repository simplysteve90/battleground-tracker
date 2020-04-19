<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aggiunta Eroe</title>
</head>
<body>
<form action="aggiungi-eroe" method="post" enctype="multipart/form-data">
<input type="file" name="immagine">
<input type="text" name="nome" placeholder="Nome">
<input type="text" name="power" placeholder="Hero Power">
<button type="submit">Aggiungi</button>
</form>
</body>
</html>