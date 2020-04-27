<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <link rel="stylesheet" type="text/css" href="static/style.css"> -->
<!-- <meta charset="ISO-8859-1"> -->
<!-- <link rel="icon" href="https://bit.ly/2RO89t2" type="image/gif" /> -->
<!-- <title>Registrazione</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- <div id="scritta"></div> -->
<!-- <form action="registrazione" method="post"> -->
<!-- <label for="username" class="label"><b>Email</b></label><br> -->
<!-- <input type="email" required="required" name="email" placeholder="Inserisci l'email"><br> -->
<!-- <label for="username" class="label"><b>Username</b></label><br> -->
<!-- <input type="text" name="username" placeholder="Inserisci l'username" required="required"><br> -->
<!-- <label for="password" class="label" ><b>Password</b></label><br> -->
<!-- <input type="password" name="password" placeholder="Inserisci la password" required="required"><br> -->
<!-- <label for="rating" class="label"><b>Rating</b></label><br> -->
<!-- <input type="number" name="rating" min="0" placeholder="Inserisci il rating" required="required"><br> -->
<!-- <button type="submit" class="pulsante"><b>REGISTRATI</b></button> -->
<!-- </form> -->
<!-- </body> -->
<!-- </html> -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Registrati</title>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
 <link rel="stylesheet" type="text/css" href="static/registrazione.css">
</head>

<body>
<!-- This snippet uses Font Awesome 5 Free as a dependency. You can download it at fontawesome.io! -->

  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div class="card card-signin flex-row my-5">
          <div class="card-img-left d-none d-md-flex">
             <!-- Background image for card set in CSS! -->
          </div>
          <div class="card-body">
            <h5 class="card-title text-center">Registrati</h5>
            <form class="form-signin" action="registrazione" method="post">
              <div class="form-label-group">
                <input type="text" id="inputUserame" name="username" class="form-control" placeholder="Nome" required autofocus>
                <label for="inputUserame">Username</label>
              </div>    
                  <div class="form-label-group">
                <input type="number" id="inputRating" name="rating" class="form-control" placeholder="Nome" required autofocus>
                <label for="inputRating">Rating</label>
              </div>    
              <div class="form-label-group">
                <input type="text" id="inputEmail" class="form-control"  name="email" placeholder="Email" required>
                <label for="inputEmail">Email</label>
              </div>
              <hr>
              <div class="form-label-group">
                <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>

              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" style="background-color: #819444">Registrati</button>
              <hr class="my-4">
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>

</html>