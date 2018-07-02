package com.es.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.es.dao.EventDAO;
import com.es.dto.Event;

/**
 * Servlet implementation class GetImages
 */
@WebServlet("/GetImages")
public class GetImages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        EventDAO dao=new EventDAO();
		
		List<Event> imageList= dao.getImages();
		
		System.out.println("inside the image servlet" + imageList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayAllImages.jsp");
		request.setAttribute("imageList", imageList);
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
