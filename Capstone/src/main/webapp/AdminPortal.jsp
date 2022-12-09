<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

* {
  box-sizing: border-box;
}
.column {
  float: left;
  width: 50%;
  align: center;
  padding: 10px;
  height: 550px;
}
.row:after {
  align: center;
  content: "";
  display: table;
  clear: both;
}
input[type=text], select {
	text-align: center;
	width: 25%;
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
<br><br><br><br>
<h1 align = center>Food Box Administrative Portal</h1>

<div class="row" align =center>
<div class="column" style="background-color:#aaa;">

<h2>Input New Products and Prices</h2>
<form action=AdminProductControl method = post>
<input type =text name = "FoodBrand" placeholder = "Food Brand"><br>
<input type =text name = "FoodCategory" placeholder = "Food Category"><br>
<input type =text name = "FoodDescription" placeholder = "Food Description"><br>
<input type =text name = "FoodPrice" placeholder = "Food Price"><br>
<input type = submit style ="background-color: #FF0000"><br><br>
</form>
</div>

<div class="column" style="background-color:#bbb;">
<br><br><br><br><br>
<h2>Browse Customers</h2>
<form action=CustomerInformation method = get>
<input type =text name = "CustomerFirstName" placeholder = "Customer's First Name">
<input type =text name = "CustomerLastName" placeholder = "Customer's Last Name">
<input type =submit style ="background-color: #FF0000">
</form>

<br><br><br>
<h2>Search Purchase Reports by Date and Category</h2>
<form action = AdminProductControl method = get>
<input type =text name = PurchaseDate placeholder = "Date of Purchase">
<input type =text name = ProductCategory placeholder = "Category of Product">
<input type = submit style ="background-color: #FF0000">
</form>
</div>

</div>
</body>
</html>

