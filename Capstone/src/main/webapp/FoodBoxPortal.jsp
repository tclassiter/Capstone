<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Food Box Customer Portal</title>
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
  width: 50%;
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

<body>
<div class = bg-image></div>
<div class = bg-text>

<h2><font color = "white">You can pick a main entree</font></h2>

<form action = PaymentGateway.jsp>
<input type="submit" value = "Chicken" style="background-color: #00cc99;">
<input type="submit" value = "Beef" style="background-color: #00cc99;">
<input type="submit" value = "Seafood" style="background-color: #00cc99;">
<input type="submit" value = "Vegetarian" style="background-color: #00cc99;">
</form>
<br><br>

<h2><font color = "white">Or search for a specific food</font></h2>


<form action = CustomerSearch method = get>
<input type = text name = JSPFoodSelection placeholder = "ex. Greek Salad">
<input type = submit name = SubmitButton  style = "background-color: #00cc99">
</form>





</div>
</body>
</html>