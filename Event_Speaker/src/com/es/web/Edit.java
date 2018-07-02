package com.es.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.es.dao.EventDAO;
import com.es.dto.Event;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	
	    int id = Integer.parseInt(request.getParameter("eventId"));
	    
	    Event event = new EventDAO().getEventDetails(id);
	    
	    request.setAttribute("eventData", event);
	    RequestDispatcher rd = request.getRequestDispatcher("editEvent.jsp");
	    rd.forward(request, response);
	} 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
