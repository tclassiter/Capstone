<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Administrator Login</title>

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

<br><br><br><br><br><br>
<div align = center>

<h1>Sporty Shoes, Inc.</h1>

<h2 align = center>Please Enter Your Administrator Username and Password</h2><br>

<form action = AdminLoginControl method = post>
<input type = text name = UserName placeholder = "User Name"><br>
<input type = text name = PassWord placeholder = "Pass Word"><br><br>
<input type = submit style ="background-color: #FF0000"><br><br>
</form>
</div>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<p>Please click <a href="NewAdminLogin.jsp">here </a>to create an administrator login</p><br>
</body>
</html>