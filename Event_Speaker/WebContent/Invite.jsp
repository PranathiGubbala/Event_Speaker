<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
    <meta charset = "utf-8"> 
	<title> Invite your friends </title>
	<link rel = "stylesheet" type " text/css" href = "Invite.css">
</head>
	<body>
	<div class = "register-box">
	<img src = "invite_icon.png" class = "avatar">
		<h1>Invite</h1>
			<form action="Controller">
			<p>To</p>
			<input type="email"  name="to"  placeholder="Friend's email id" required = "required"/><br>
			<p>From</p>
			<input type="email"  name="user"  placeholder="Your email id" required = "required"/><br>
			<p>Password</p>
			<input type="password" name="pass" required/>
			<input type = "hidden" name= "action"  value = "sendMail">
			<input type = "submit" name = "s" value = "Send"><br>
				</form>
		</div>
	</body>
	</html>