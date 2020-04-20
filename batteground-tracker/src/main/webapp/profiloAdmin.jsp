<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
<%String path = request.getContextPath(); %>
<form action="<%=path%>/admin/scelta-operazione-admin" method="post">
<button type="submit" class="pulsante" name="action" value="1">Aggiungi Eroe</button><br><br>
<button type="submit" class="pulsante" name="action" value="2">Eroi</button><br><br>
<button type="submit" class="pulsante" name="action" value="3">Aggiungi Composizione</button><br><br>
<button type="submit" class="pulsante" name="action" value="4">Composizioni</button><br><br>
<button type="submit" class="pulsante" name="action" value="5">Utenti</button><br><br>
<button type="submit" class="pulsante" name="action" value="6">Log Out</button>
</form>
</body>
</html>