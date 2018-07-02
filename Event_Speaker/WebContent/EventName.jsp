<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
    <meta charset = "utf-8"> 
	<title> Event Name</title>
	<link rel = "stylesheet" type " text/css" href = "Participant.css">
</head>
	<body>
	<div class = "login-box">
	<img src = "details.png" class = "avatar">
		<h1>EVENT NAME</h1>
			<form action="Controller">
			<p>Event Name</p>
			<input type = "text" name = "name" placeholder = "eventname" required><br>
			<input type = "hidden" name= "action"  value = "DisplayUserParticipant">
			<input type = "submit" name = "s" value ="Display">	
			</form>
		</div>
	</body>
	</html>