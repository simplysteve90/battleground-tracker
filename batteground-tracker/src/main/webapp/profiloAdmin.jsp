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
<button type="submit" class="pulsante" name="action" value="2">Modifica Eroe</button><br><br>
<button type="submit" class="pulsante" name="action" value="3">Aggiungi Composizione</button><br><br>
<button type="submit" class="pulsante" name="action" value="4">Modifica Composizione</button>
<button type="submit" class="pulsante" name="action" value="5">Log Out</button>
</form>
</body>
</html>