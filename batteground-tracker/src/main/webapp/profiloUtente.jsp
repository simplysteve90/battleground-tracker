<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="static/style.css">
<link rel="icon" href="https://bit.ly/2RO89t2" type="image/gif" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>ProfiloUtente</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark container-fluid">
			
				
					<div class="col-sm">
						<a class="navbar-brand" href="homepage.jsp">Home</a>
					</div>
					<div class="col-sm">
					ciao</div>
					<div class="col-sm" align="right">
		
					</div>
			




		</nav>

<%String path = request.getContextPath(); %>
<form action="<%=path%>/utente/scelta" method="post">
<button type="submit" class="pulsante" name="action" value="1">Aggiungi Partita</button><br><br>
<button type="submit" class="pulsante" name="action" value="2">Lista Partite</button><br><br>
<button type="submit" class="pulsante" name="action" value="3">Statistiche Eroi</button><br><br>
<button type="submit" class="pulsante" name="action" value="4">LogOut</button>
</form>
</body>
</html>