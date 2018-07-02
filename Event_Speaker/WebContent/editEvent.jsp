<!DOCTYPE html>
<html>
   <head>
    <meta charset = "utf-8"> 
	<title> Login </title>
	<link rel = "stylesheet" type = "text/css" href = "editEvent.css">
</head>
	<body>
	<div class = "login-box">
	<img src = "postlogo.png" class = "avatar">
		<h1>Edit event</h1>
			<form action="Controller" method="post">
			<p>Id</p>
            <input type="text" name="id" value=${eventData.id} >
			<p>Name</p>
           <input type="text" name="name" value=${eventData.name} > 
            <p>Date</>
            <input type="text" name="date" value=${eventData.date} >
			<p>Start Time</p>
			<input type="text" name="startTime" value=${eventData.startTime}>
			<p>End Time</p>
			<input type="text" name="endTime" value=${eventData.endTime}>
			<p>Fee</p>
			<input type="text" name="fee" value=${eventData.fee}>
			<p>Venue</p>
			<input type="text" name="venue" value=${eventData.venue}>
			<label>Photo:</label>
        		<input type=file name="eventPic" value=${eventData.eventPic}>
			<p>Details</p>
			 <input type="text" name="details" value=${eventData.details}>
			<p>Cheif Guest</p>
			<input type = "text" name = "status" value=${eventData.status }>
			<p>Category Id</p>
			 <input type = "text" name = "categoryId" value=${eventData.categoryId.id }>
			<input type = "hidden" name= "action"  value = "UpdateServlet">
			<input type = "submit" name = "s" value ="Submit">	
			</form>
		</div>
	</body>
	</html>