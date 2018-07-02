package com.es.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.es.dao.EventDAO;
import com.es.dto.Event;
import com.es.dto.EventCategory;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	private PreparedStatement pst = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());doPost(request,response);	
		doPost(request,response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();			
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String date = (request.getParameter("date"));
		String startTime = (request.getParameter("startTime"));
		String endTime = request.getParameter("endTime");
		Double fee = Double.parseDouble(request.getParameter("fee"));
		String venue = (request.getParameter("venue"));
		String details = request.getParameter("details");
		//String eventPic = request.getParameter("eventPic");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		Event event = new Event();
		event.setId(id);
		event.setName(name);
		event.setDate(date);
		event.setStartTime(startTime);
		event.setEndTime(endTime);
		event.setFee(fee);
		event.setVenue(venue);
		event.setDetails(details);
		EventCategory ec = new EventCategory();
		ec.setId(categoryId);
		event.setCategoryId(ec);
		
		int x = new EventDAO().editEvent(event);
		if(x > 0) {											
			RequestDispatcher rd = request.getRequestDispatcher("DisplayAllEvents");
			rd.include(request, response);
			out.println("<center><h1>Update Successful...</h1><center>");			
		}
	}

}
