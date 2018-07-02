<!DOCTYPE html>
<html>
   <head>
    <meta charset = "utf-8"> 
	<title> Login </title>
	<link rel = "stylesheet" type " text/css" href = "EventCategory.css">
</head>
	<body>
	<div class = "login-box">
	<img src = "Category.png" class = "avatar">
		<h1>Categories</h1>
			<form action="Controller">
			<p>Category Name</p>
			<input type = "text" name ="name" placeholder ="Category Name" required>
			<input type = "hidden" name= "action"  value = "AddCategory">
			<input type = "submit" name = "s" value ="Add">
			</form>
		</div>
	</body>
	</html>