package com.es.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.es.dto.EventCategory;
import com.es.dao.EventCategoryDAO;
import com.es.dto.Admin;

/**
 * Servlet implementation class AddCategory
 */
@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
	        	response.getWriter().println("<h1>Success</h1>");
	    		RequestDispatcher dispatcher=request.getRequestDispatcher("./ParticipantDetails.html");
	    		dispatcher.include(request, response);
	        }
		 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
