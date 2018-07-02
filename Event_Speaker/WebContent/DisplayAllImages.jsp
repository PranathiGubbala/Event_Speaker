<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<title>Home Page</title>   
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/normalize.css" rel="stylesheet" type="text/css">
    <link href="css/demo.css" rel="stylesheet" type="text/css">
	<link href="css/xopixel.css" rel="stylesheet" type="text/css">
</head>
<body background = "HomePage_bg.jpg">
     <header class="xopixel-header">
     <ul class="nav navbar-nav navbar-right">
      				<li><a href="login.html"><span class="glyphicon glyphicon-log-in" > Login</span></a></li>
    			</ul>
		<h1>Events</h1>
    </header>    
    
        <c:forEach items="${imageList}" var="image">
        <div class="xop-section">
		<ul class="xop-grid">
			<li>
				<div class="xop-box xop-img-1" >
					<div class="xop-info" >
					 <a href = "Controller?action=ShowDetails&eventId=${image.id }"><img src = "./images/${image.eventPic}" width = "850" height = "550"/></a>		
					</div>
				</div>
			</li> 
		</ul>
	</div>	                    
      
    </c:forEach>
  
</body>
</html>
