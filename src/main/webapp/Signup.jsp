<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>

	<form action="SignupServlet" method="post">
		FirstName : <input type="text" name="firstName" value="${user.firstName}" />${firstNameError } <br><br> 
		LastName : <input type="text" name="lastName" value="${user.lastName}"/>${lastNameError } <br><br>
		Email :<input type="text" name="email" value="${user.email}" />${emailError } <br><br>
		Password : <input type="text" name="password"/>${passwordError } <br><br>
			
		<input type="submit" value="Signup"/>
		
	
	</form>
</body>
</html>