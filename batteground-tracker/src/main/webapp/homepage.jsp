<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="icon" href="https://bit.ly/3cFpBIa" type="image/gif">
<link rel="stylesheet" type="text/css" href="static/style.css">
<meta charset="ISO-8859-1">
<title>Benvenuto</title>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
					<div class="col-sm">
						<a class="navbar-brand" href="profiloUtente.jsp">Home</a>
					</div>
					<div class="col-sm">
					</div>
					<div class="col-sm" align="right">
						<form action="accesso" method="post">
							<input type="text" name="username" required="required"
								placeholder="Username"> 
								<input type="password" name="password"  required="required"
								placeholder="Password">
							<button type="submit" value="1" class="pulsante" name="action">
								<b>Login</b>
							</button>
							<button type="submit" class="pulsante" value="2" name="action" formnovalidate="formnovalidate">
								<b>Register</b>
							</button>
							</form>
					</div>
		</nav>
		</header>
		
		<div class="iframe-container" align="center">
		<img src="./media/scritta.png" alt="Mountain"><br>
		
		<iframe width="1024" height="576" src="https://www.youtube.com/embed/NuW_wDMXl64" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
		</div>
		

</body>
</html>