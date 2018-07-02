package com.es.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.es.dao.EventDAO;
import com.es.dto.Event;

/**
 * Servlet implementation class EventDetails
 */
@WebServlet("/EventDetails")
public class EventDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		int eventId = Integer.parseInt(request.getParameter("eventId"));	
		Event event = new EventDAO().getEvent(eventId);
			request.setAttribute("eventData", event);			
            RequestDispatcher rd = request.getRequestDispatcher("displayEventDetail.jsp");
			rd.forward(request, response);
	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);	
	}
}