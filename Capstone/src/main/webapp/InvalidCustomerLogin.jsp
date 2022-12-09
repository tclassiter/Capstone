<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Invalid Login</title>

<style>
body {
background-image: URL("FriendsEating.jpeg"); 
background-repeat: no-repeat;
background-size: cover;
background-color: #d3d3d3;
}
.Format {
	text-align: center;
	width: 50%;
	margin: 300px 350px;
	padding: 20px;
}
input[type=text], select {
	text-align: center;
	width: 20%;
	padding: 10px 10px;
	margin: 20px;
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

<body>

<div class = Format>
<form action = NewCustomerLogin.jsp>
<h1><font color = "white">Looks like you don't have a valid login.</font></h1>                        
<input type = submit value = "Create New Login" style ="background-color: #00cc99">
</form>

</div>
</body>
</html>