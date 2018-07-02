package com.es.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.es.dto.*;
import com.es.dao.*;
/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
