package com.es.web;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.es.dao.*;
import com.es.dto.*;

/**
 * Servlet implementation class UploadImage
 */
@WebServlet("/UploadImage")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 50,
location = "//home//sonu//workspace//EventSpeaker//WebContent//images")

public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//String dob = request.getParameter("dob");
		 HttpSession session = request.getSession(false);
		 int userId = (int)session.getAttribute("userId");
		 User user = new User();
		 user.setId(userId);
		String name = request.getParameter("name");
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
    event.setEventPic(fileName);
    event.setDetails(details);
    event.setStatus(status);
    EventCategory obj = new EventCategory();
    obj.setId(categoryId);
    event.setCategoryId(obj);
    event.setUserId(user);
    
   eventDao.insert(event);
}


private String getFileName(Part part) {
    String content = part.getHeader("content-disposition");
    System.out.println("content-disposition :"+content);
String fileName = content.substring(content.indexOf("filename") + 10, content.length() - 1);
 System.out.println("fileName"+fileName);
return fileName;
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
