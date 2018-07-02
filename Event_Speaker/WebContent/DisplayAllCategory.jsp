<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>All Categories</title>
 <meta charset="utf-8">
 <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700" rel="stylesheet">
	<meta charset="UTF-8">
	<meta content="width=device-width, initial-scale=1" name="viewport">
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/normalize.css" rel="stylesheet" type="text/css">
    <link href="DisplayAllCategories.css" rel="stylesheet" type="text/css">
	<link href="css/xopixel.css" rel="stylesheet" type="text/css">
</head>
<body>

<header class="xopixel-header">
		<h1>Categories</h1>
		<ul class="nav navbar-nav navbar-right">
  		<li><a href="adminHomePage.jsp"><span class="glyphicon glyphicon-log-in"> AdminHomePanel</span></a></li>
    </ul>
 </header>    
    
<table class="container">            
    <thead>
      <tr>
        <th><h2>Id</h2></th>
        <th><h2>Name</h2></th>
        <th><h2>Admin_ID</h2></th>
        <th><h2>Action</h2>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${ecList}" var="ec">
      <tr>
       	<td><h2>${ec.id }</h2></td>
		<td><h2>${ec.name }</h2></td>
		<td><h2>${ec.adminId.id}</h2></td>
		<td ><h2><a href = "Controller?action=DeleteCategory&categoryId=${ec.id }">delete</a></h2></td>    
      </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>