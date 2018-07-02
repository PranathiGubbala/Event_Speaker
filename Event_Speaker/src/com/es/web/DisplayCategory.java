package com.es.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.es.dao.EventCategoryDAO;
import com.es.dto.EventCategory;

/**
 * Servlet implementation class DisplayCategory
 */
@WebServlet("/DisplayCategory")
public class DisplayCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        EventCategoryDAO dao=new EventCategoryDAO();
		
		List<EventCategory> ecList=dao.displayAll();
		System.out.println("inside the servlet" + ecList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayAllCategory.jsp");
		request.setAttribute("ecList", ecList);
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
