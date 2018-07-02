package com.es.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.es.dao.EventDAO;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/DeleteEvent")
public class DeleteEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("eventId"));
		System.out.println("the delete "+ id);
		EventDAO dao = new EventDAO();
		dao.delete(id);
		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body bgcolor=yellow text=red> Deleted successfully.!</body>");
		out.println("</html>");
		
		//RequestDispatcher dispatcher=request.getRequestDispatcher("adminHomePage.jsp");	
		//dispatcher.include(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
