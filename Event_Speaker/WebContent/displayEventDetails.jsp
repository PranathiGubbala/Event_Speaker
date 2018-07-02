<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700" rel="stylesheet">
	<meta charset="UTF-8">
	<meta content="width=device-width, initial-scale=1" name="viewport">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel = "stylesheet" href="LandingPage.css">
 <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="css/normalize.css" rel="stylesheet" type="text/css">
<link href="css/xopixel.css" rel="stylesheet" type="text/css">
<link href="DisplayAllUsers.css" rel="stylesheet" type="text/css">
<title>Event Details</title>
</head>
<body>
<header class="xopixel-header">
	<center><h1>Details</h1></center>
	<ul class="nav navbar-nav navbar-right">
  			<li><a href="Controller?action=GetImages"><span class="glyphicon glyphicon-log-in"> HomePage</span></a></li>
    </ul>
	<ul class="nav navbar-nav navbar-right">
  			<li><a href="Invite.jsp"><span class="glyphicon glyphicon-log-in"> InviteFriend</span></a></li>
    </ul>
</header>   
<form action="ParticipantDetails.html" method="post">
<table class="container">            
    <thead>
      <tr>
        <th><h2>Name</h2></th>
        <th><h2>Date</h2></th>
        <th><h2>StartTime</h2></th>
        <th><h2>EndTime</h2>
        <th><h2>Fee</h2></th>
        <th><h2>Venue</h2></th>
        <th><h2>Details</h2></th>        
      </tr>
    </thead>
     <tbody>
     <c:forEach items="${eventData}" var="ec">
      <tr>
       	<td><h2>${eventData.name}</h2></td>
		<td><h2>${eventData.date}</h2></td>
		<td><h2>${eventData.startTime}</h2></td>
		<td><h2>${eventData.endTime}</h2></td>
		<td><h2>${eventData.fee}</h2></td>
		<td><h2>${eventData.venue}</h2></td>
		<td><h2>${eventData.details}</h2></td>    
      </tr>
    </c:forEach>
    </tbody>
</table>
<center>  
<button class = "button button1" type = "submit"><span>Register</span></button>
</center>
</form>
</body>
</html> 