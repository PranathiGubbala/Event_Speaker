<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700" rel="stylesheet">
	<meta charset="UTF-8">
	<meta content="width=device-width, initial-scale=1" name="viewport">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta content="IE=edge" http-equiv="X-UA-Compatible">
	<title>Admin Home Page</title>   
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/normalize.css" rel="stylesheet" type="text/css">
    <link href="adminHomePage.css" rel="stylesheet" type="text/css">
	<link href="css/xopixel.css" rel="stylesheet" type="text/css">
   
</head>
<body>
<header class="xopixel-header">
	<ul class="nav navbar-nav navbar-right">
  		<li><a href="Controller?action=GetImages"><span class="glyphicon glyphicon-log-in"> HomePage</span></a></li>
      	<li><a href="LandingPage.html"><span class="glyphicon glyphicon-log-in"> LogOut</span></a></li>
    </ul>
		<h1>Admin</h1>
 </header>    
    
	<div class="xop-section">
		<ul class="xop-grid">
			<li>
				<div class="xop-box xop-img-1">		
					<div class="xop-info">
					<a href= "EventCategory.jsp"><h3>Add Category</h3></a>
					</div>
				</div>
			</li>
			<li>
				<div class="xop-box xop-img-2">		
					<div class="xop-info">
					<a href= "Controller?action=DisplayCategory"><h3>Display all categories</h3></a>
					</div>
				</div>
			</li>
			<li>
				<div class="xop-box xop-img-3">		
					<div class="xop-info">
					<a href= "Controller?action=AllEventsDetails"><h3>Display Events</h3></a>
					</div>
				</div>
			</li>
            <li>
				<div class="xop-box xop-img-3">		
					<div class="xop-info">
					<a href="Controller?action=DisplayAllUsers"><h3>Display Users</h3></a>
					</div>
				</div>
			</li>
		</ul>
	</div>

</body>
</html>