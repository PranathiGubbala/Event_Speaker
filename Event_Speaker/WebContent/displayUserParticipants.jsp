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
 <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="css/normalize.css" rel="stylesheet" type="text/css">
<link href="css/xopixel.css" rel="stylesheet" type="text/css">
<link href="displayUserParticipants.css" rel="stylesheet" type="text/css">
<title>Participants Details</title>
</head>
<body>
<header class="xopixel-header">
	 <h1>Participant Details</h1>
	<ul class="nav navbar-nav navbar-right">
  		<li><a href="userHomePanel.jsp"><span class="glyphicon glyphicon-log-in"> UserHomePanel</span></a></li>
    </ul>
   
</header>   
<table class="container">            
    <thead>
      <tr>
        <th><h2>Name</h2></th>
		<th><h2>Mobile</h2></th>
		<th><h2>College</h2></th>      
      </tr>
     </thead>
     <tbody> 
        <c:forEach items="${partlist}" var="part">
            <tr>
                <td><h2>${part.name }</h2></td>
            	<td><h2>${part.mobile}</h2></td>
            	<td><h2>${part.college}</h2></td>
            </tr>
        </c:forEach>
    </tbody>    
    </table>
</body>
</html>