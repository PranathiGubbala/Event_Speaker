<!DOCTYPE html>
<html>
   <head>
    <meta charset = "utf-8"> 
	<title> Post Event Details </title>
	<link rel = "stylesheet" type = "text/css" href = "eventDetails.css">
	<script>
		function myFunction() {
    		alert("Enter '1' for a technical event\n Enter '2' for a Non-technical event");
		}
	</script>
	
</head>
	<body>
	<div class = "login-box">
	<img src = "postlogo.png" class = "avatar">
		<h1>Post an event</h1>
			<form action="Controller" method="post" enctype="multipart/form-data">
			<p>Event Name</p>
			<input type="text"  name="eventName"  placeholder="eventName" required/>
			<p>Date</p>
             <input type=date name="date"    required="required" />
			<p>Start Time</p>
			<input type="text"  name="startTime"  placeholder="startTime" required/>
			<p>End Time</p>
			<input type="text"  name="endTime"  placeholder="endTime" required/>
			<p>Fee</p>
			<input type="text"  name="fee"  placeholder="fee" required/>
			<p>Venue</p>
			<input type="text"  name="venue"  placeholder="venue" required/>
			<label>Photo:</label>
        		<input type="file" name="eventPic" required="required"/>
			<p>Details</p>
			<input type="text"  name="details"  placeholder="details" required/>
			<p>Cheif Guest</p>
			<input type="text"  name="status"  placeholder="get details about the participant" required/><br>
			<p>Category Id <button onclick="myFunction()">Know Id</button> </p>
			<input type="text"  name="categoryId"  placeholder="categoryId" required/>
			<input type = "hidden" name= "action"  value = "UploadImage">
			<input type = "submit" name = "s" value ="Add">	
			</form>
		</div>
	</body>
	</html>