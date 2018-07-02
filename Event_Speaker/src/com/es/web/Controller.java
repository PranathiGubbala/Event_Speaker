package com.es.web;
import java.util.List;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.es.dto.*;
import com.es.dao.*;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50,
location = "//home//pranathi//event_speaker//Event_Speaker//WebContent//images")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("action");
		System.out.println("the action is" + action);
		
		if(action.equalsIgnoreCase("GetImages")){
			
			 EventDAO dao=new EventDAO();
			 List<Event> imageList= dao.getImages();
			 System.out.println("inside the image servlet" + imageList);
			 
			 request.setAttribute("imageList", imageList);
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayAllImages.jsp");
			 dispatcher.forward(request, response);	
		}else if(action.equalsIgnoreCase("LoginServlet")){
			
			PrintWriter out=response.getWriter();
			String userName=request.getParameter("uname");
			String password=request.getParameter("pwd");
			
			System.out.println(password);
			
			HttpSession session = request.getSession();
			session.setAttribute("loggedUser",userName);
			session.setAttribute("Password",password);
			
			response.setContentType("text/html");
			
			UserDAO  userDao = new UserDAO();
			User user = userDao.getUser(userName, password);
			
			
			System.out.println("Inside servlet:"+user);
			//System.out.println(customer.getCustId());
			
		    out.println("<html>");
			
		    if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
	             RequestDispatcher dispatcher=request.getRequestDispatcher("adminHomePage.jsp");	
		         dispatcher.forward(request, response);
		         session.setAttribute("adminId", 1);
			}else if(user !=null){
				int id = user.getId();
				session.setAttribute("userId", id);
	            RequestDispatcher dispatcher=request.getRequestDispatcher("userHomePanel.jsp");	
			    dispatcher.forward(request, response);			
			}else{
		        out.println("<body text=white font><center><h1>Invalid Username or Password</h1></center>!</body>");
	            RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
			    dispatcher.include(request, response);		
			}
			out.println("</html>");
		}else if(action.equalsIgnoreCase("RegisterUser")){
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String college = request.getParameter("college");
			String collegeId = request.getParameter("collegeId");
	        String designation = request.getParameter("designation");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String houseNo = request.getParameter("houseNo");
			String street = request.getParameter("street");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String pincode = request.getParameter("pincode");
			
			User user = new User();

			user.setName(name);
			user.setPassword(password);
			user.setCollege(college);
			user.setCollegeId(collegeId);
			user.setDesignation(designation);
	        user.setEmail(email);
			user.setContact(contact);
			user.setHouseNo(houseNo);
			user.setStreet(street);
			user.setCity(city);
			user.setState(state);
			user.setPincode(pincode);	
			
			System.out.println(user);
			UserDAO userDao = new UserDAO();

			int flag = userDao.add(user);
			
			System.out.println("the status is :" + flag);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
		    dispatcher.include(request, response);
		    
		}else if(action.equalsIgnoreCase("DisplayUserEvent")){
			 HttpSession session = request.getSession(false);
			 int userId = (int)session.getAttribute("userId");
			 System.out.println("userID is " + userId);
			 
			 EventDAO dao = new EventDAO();
			 List<Event> eventList = dao.displayAllUser(userId);
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("displayUserEvents.jsp");
			request.setAttribute("eventList", eventList);
			dispatcher.forward(request, response);	
		}else if(action.equalsIgnoreCase("DeleteEvent")){
			
			int id = Integer.parseInt(request.getParameter("eventId"));
			System.out.println("the delete "+ id);
			EventDAO dao = new EventDAO();
		    dao.delete(id);
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher("adminHomePage.jsp");
			dispatcher.forward(request, response);	
			
		}else if(action.equalsIgnoreCase("Delete")){
			
			int id = Integer.parseInt(request.getParameter("eventId"));
			System.out.println("the delete "+ id);
			EventDAO dao = new EventDAO();
		    dao.delete(id);
		    
		    RequestDispatcher dispatcher = request.getRequestDispatcher("userHomePanel.jsp");
			dispatcher.forward(request, response);	
			
		}else if(action.equalsIgnoreCase("UploadImage")){
			 HttpSession session = request.getSession(false);
			 int userId = (int)session.getAttribute("userId");
			 User user = new User();
			 user.setId(userId);
			 System.out.println("the id is" + userId);
			String name = request.getParameter("eventName");
			String date = request.getParameter("date");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
	        Double fee  = Double.parseDouble(request.getParameter("fee"));
			String venue = request.getParameter("venue");
			String eventPic = request.getParameter("eventPic");
			String details = request.getParameter("details");
			String status = request.getParameter("status");
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			
			
			
	        java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
	        java.util.Date utilDate = null;
	        try {
	           
	            utilDate=sdf.parse(date);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	       
	    Part part = request.getPart("eventPic");
	    String fileName = getFileName(part);
	    part.write(fileName);
	   
	    EventDAO eventDao = new EventDAO();  
	    
	    Event event = new Event();
	    event.setName(name);
	    event.setDate(utilDate);
	    event.setStartTime(startTime);
	    event.setEndTime(endTime);
	    event.setFee(fee);
	    event.setVenue(venue);
	    event.setEventPic(fileName);
	    event.setDetails(details);
	    event.setStatus(status);
	    EventCategory obj = new EventCategory();
	    obj.setId(categoryId);
	    event.setCategoryId(obj);
	    event.setUserId(user);
	   System.out.println(event); 
	   eventDao.insert(event);
	   
	   RequestDispatcher dispatcher=request.getRequestDispatcher("userHomePanel.jsp");	
	    dispatcher.forward(request, response);	
	   
	}else if(action.equalsIgnoreCase("AllEventsDetails")){
           EventDAO dao=new EventDAO();
		
		   List<Event> eventList=dao.displayAll();
		
		   RequestDispatcher dispatcher = request.getRequestDispatcher("displayAllEvents.jsp");
		   request.setAttribute("eventList", eventList);
		    dispatcher.forward(request, response);
		
	}else if(action.equalsIgnoreCase("DisplayAllUsers")){
        
		
		UserDAO dao=new UserDAO();
		
		List<User> userList=dao.displayAll();
		System.out.println("inside the servlet" + userList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("displayAllUsers.jsp");
		request.setAttribute("userList", userList);
		dispatcher.forward(request, response);	
		
	}else if(action.equalsIgnoreCase("DisplayCategory")){
		 EventCategoryDAO dao=new EventCategoryDAO();
			
			List<EventCategory> ecList=dao.displayAll();
			System.out.println("inside the servlet" + ecList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayAllCategory.jsp");
			request.setAttribute("ecList", ecList);
			dispatcher.forward(request, response);
			
	}else if(action.equalsIgnoreCase("AddCategory")){
		
		HttpSession session = request.getSession(false);
		 int adminId = (int)session.getAttribute("adminId");
		 
		 String name = request.getParameter("name");
		 EventCategory ec = new EventCategory();
		 
		 ec.setName(name);
		 Admin a = new Admin();
		 a.setId(adminId);
		 ec.setAdminId(a);
		 
		 EventCategoryDAO eventDao = new EventCategoryDAO();
		  
	        if(eventDao.add(ec) != 0) {
	    		RequestDispatcher dispatcher=request.getRequestDispatcher("adminHomePage.jsp");
	    		dispatcher.include(request, response);
	        }
		 

	}else if(action.equalsIgnoreCase("DeleteCategory")){
		int id = Integer.parseInt(request.getParameter("categoryId"));
		System.out.println("the delete "+ id);
		EventCategoryDAO dao = new EventCategoryDAO();
		dao.delete(id);
		 RequestDispatcher rd = request.getRequestDispatcher("adminHomePage.jsp");
		 rd.forward(request, response);
		
	}else if(action.equalsIgnoreCase("DeleteUser")){
		int id = Integer.parseInt(request.getParameter("userId"));
		System.out.println("the delete "+ id);
		UserDAO dao = new UserDAO();
		dao.delete(id);
		 RequestDispatcher rd = request.getRequestDispatcher("adminHomePage.jsp");
		 rd.forward(request, response);
	} else if(action.equalsIgnoreCase("EventDetails")){
		int eventId = Integer.parseInt(request.getParameter("eventId"));	
		Event event = new EventDAO().getEvent(eventId);
			request.setAttribute("eventData", event);			
            RequestDispatcher rd = request.getRequestDispatcher("displayEventDetails.jsp");
			rd.forward(request, response);
			
	}else if(action.equalsIgnoreCase("RegisterParticipant")){
		String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String college = request.getParameter("college");
        Participant part = new Participant();

        part.setName(name);
        part.setMobile(mobile);
        part.setCollege(college);
        
        System.out.println(part);
        ParticipantDAO partDao = new ParticipantDAO();
        
        if(partDao.add(part) != 0) {
        	int id = partDao.getId();
            HttpSession session = request.getSession(false);
               int eventId = (int)session.getAttribute("eventId");
               RegisteredEvents re = new RegisteredEvents();
             Participant p = new Participant();
             Event e = new Event();
             e.setId(eventId);
             p.setId(id);
             re.setParticipantId(p);
             re.setEventId(e);
             RegisteredEventDAO  dao = new RegisteredEventDAO();
             dao.register(re);

       System.out.println("finished");
       EventDAO dao1 = new EventDAO();
		 List<Event> imageList= dao1.getImages();
		 System.out.println("inside the image servlet" + imageList);
		 
		 request.setAttribute("imageList", imageList);
		 
            
            RequestDispatcher dispatcher=request.getRequestDispatcher("DisplayAllImages.jsp");
            dispatcher.include(request, response);

        }
	} else if(action.equalsIgnoreCase("ShowDetails")){
        
        int id = Integer.parseInt(request.getParameter("eventId"));
        HttpSession session = request.getSession();
        session.setAttribute("eventId", id);
        
        System.out.println(id);
        Event event = new EventDAO().getEventDetails(id);
        System.out.println(event);
        request.setAttribute("eventData", event);
        RequestDispatcher rd = request.getRequestDispatcher("displayEventDetails.jsp");
        rd.forward(request, response);
    }else if(action.equalsIgnoreCase("Edit")){
         int eventId = Integer.parseInt(request.getParameter("eventId"));
            
            Event event = new EventDAO().getEventDetails(eventId);
            
            request.setAttribute("eventData", event);
            RequestDispatcher rd = request.getRequestDispatcher("editEvent.jsp");
            rd.forward(request, response);
    }else if(action.equalsIgnoreCase("UpdateServlet")){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = (request.getParameter("date"));
        String startTime = (request.getParameter("startTime"));
        String endTime = request.getParameter("endTime");
        Double fee = Double.parseDouble(request.getParameter("fee"));
        String venue = (request.getParameter("venue"));
        String eventPic = request.getParameter("eventPic");
        String details = request.getParameter("details");
        String status = request.getParameter("status");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        
         java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = null;
            try {
               
                utilDate=sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        event.setDate(utilDate);
        event.setStartTime(startTime);
        event.setEndTime(endTime);
        event.setFee(fee);
        event.setVenue(venue);
        event.setEventPic(eventPic);
        event.setDetails(details);
        event.setStatus(status);

        
        EventCategory ec = new EventCategory();
        ec.setId(categoryId);
        event.setCategoryId(ec);
        
        int x = new EventDAO().Edit(event);
        RequestDispatcher rd = request.getRequestDispatcher("userHomePanel.jsp");
        
        rd.forward(request, response);
        
        /*if(x > 0) {        
             EventDAO dao=new EventDAO();
             System.out.println("Update Servlet");
                List<Event> eventList=dao.displayAll();
                request.setAttribute("eventList", eventList);
                RequestDispatcher rd = request.getRequestDispatcher("displayAllEvents.jsp");
               
                rd.forward(request, response);
        }*/
    }else if(action.equalsIgnoreCase("RegisterEvents")){
    	HttpSession session = request.getSession(false);
    	int eventId = (int)session.getAttribute("eventId");
    	
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("In RegisterEvents");
        RegisteredEvents re = new RegisteredEvents();
        Participant p = new Participant();
        Event e = new Event();
        e.setId(eventId);
        p.setId(id);
        re.setParticipantId(p);
        re.setEventId(e);
        RegisteredEventDAO  dao = new RegisteredEventDAO();
        dao.register(re);

      System.out.println("finished");
      RequestDispatcher rd = request.getRequestDispatcher("LandingPage.html");
      
      rd.forward(request, response);
      
        
    }else if(action.equalsIgnoreCase("DisplayUserParticipant")){
    	
    	System.out.println("inside the controller");
    	HttpSession session = request.getSession(false);
        int id = (int)session.getAttribute("userId");
        
       String name = request.getParameter("name");
       System.out.println("inside the action" + name);
       ParticipantDAO part=new ParticipantDAO();
       List<Participant> partlist=part.getUserParticipants(name,id);
       
       System.out.print("This is required:"+partlist);
       
       RequestDispatcher dispatcher=request.getRequestDispatcher("displayUserParticipants.jsp");
       request.setAttribute("partlist", partlist);
       dispatcher.forward(request, response);

    }else if(action.equalsIgnoreCase("sendMail")){
        response.setContentType("text/html");  
        //System.out.println(" I am irritating you");
        PrintWriter out = response.getWriter(); 
          
        String to=request.getParameter("to");  
        String subject= "Invite Friend";
       // System.out.println(subject);
        String message = "I have registered for the event on the Event Speaker website.Please check it out for other information";  
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
              
        Mailer.send(to,subject,message,user,pass);  
        out.print("mail has been sent successfully");
        
        HttpSession session = request.getSession(false);
         int eventId = (int)session.getAttribute("eventId");
         
         System.out.println(eventId);
            Event event = new EventDAO().getEventDetails(eventId);
            System.out.println(event);
            request.setAttribute("eventData", event);
            
            out.print("mail has been sent successfully");
            RequestDispatcher rd = request.getRequestDispatcher("displayEventDetails.jsp");
            
            rd.forward(request, response);
    }

        
	}
private String getFileName(Part part) {
    String content = part.getHeader("content-disposition");
    System.out.println("content-disposition :"+content);
String fileName = content.substring(content.indexOf("filename") + 10, content.length() - 1);
 System.out.println("fileName"+fileName);
return fileName;
}

/*public void getImages(){
        EventDAO dao=new EventDAO();
        List<Event> imageList= dao.getImages();
        System.out.println("inside the image servlet" + imageList);

       request.setAttribute("imageList", imageList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayAllImages.jsp");
       dispatcher.forward(request, response);
}*/

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
