<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Invalid Login</title>
<style>

body {
background-image: URL(" "); 
background-repeat: no-repeat;
background-size: cover;
background-color: #d3d3d3;
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

<br><br><br><br><br><br><br><br>

<div align = center>
<form action = NewAdminLogin.jsp>
<h2>Looks like you don't have a valid login.</h2> 
<h2>Please select the button below to create an account or reset your login.</h2>                          
<input type = submit value = "New Login" style ="background-color: #FF0000">
</form>

</div>
</body>
</html>