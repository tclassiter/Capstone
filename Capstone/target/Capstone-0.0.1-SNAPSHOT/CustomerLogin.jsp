<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Login</title>

<style>

body, html {
height: 100%
}

.bg-image {
background-image: URL("FriendsEating.jpeg"); 
background-repeat: no-repeat;
background-size: cover;
filter: blur(3px);
height: 100%; 
background-position: center;
background-repeat: no-repeat;
background-size: cover;
}

.bg-text {
  background-color: rgb(0,0,0);
  background-color: rgba(0,0,0, 0.4); 
  color: white;
  font-weight: bold;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
  width: 40%;
  padding: 2px;
  text-align: center;
}

input[type=text], select {
	text-align: center;
	width: 20%;
	padding: 10px 20px;
	margin: 10px;
	border: 1px solid #ccc;
}

input[type=submit], select {
	text-align: center;
	width: 20%;
	padding: 12px 20px;
	margin: 15px;
	border: 1px solid #ccc;
	cursor: pointer;
}	
</style>
</head>

<div class = "bg-image"></div> 
<div class = "bg-text">

<h1><font color = 'white'>Welcome to the Food Box!</font></h1><br> 
                   
<form action = CustomerLogin method = post>
<input type = text name = EmailAddress placeholder = "Email Address"><br>
<input type = text name = PassWord placeholder = "Pass Word"><br><br>
<input type = submit name = SubmitButton  style = "background-color: #00cc99">
</form>


<a href = "NewCustomerLogin.jsp"><font color = "white">New Login</font></a>
 

</div>
</body>
</html>


