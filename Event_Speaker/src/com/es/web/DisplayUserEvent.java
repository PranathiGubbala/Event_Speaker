package com.es.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.es.dao.EventCategoryDAO;
import com.es.dao.EventDAO;
import com.es.dto.Event;

/**
 * Servlet implementation class DisplayUserEvent
 */
@WebServlet("/DisplayUserEvent")
public class DisplayUserEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 HttpSession session = request.getSession(false);
		 int userId = (int)session.getAttribute("userId");
		 System.out.println("userID is " + userId);
		 
		 EventDAO dao = new EventDAO();
		 List<Event> eventList = dao.displayAllUser(userId);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("displayAllEvents.jsp");
		request.setAttribute("eventList", eventList);
		dispatcher.forward(request, response);	
		
		 
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
