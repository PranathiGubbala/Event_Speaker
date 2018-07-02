package com.es.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.es.dao.UserDAO;
import com.es.dto.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("uname");
		String password=request.getParameter("pwd");
		
		System.out.println(password);
		HttpSession session = request.getSession();
		session.setAttribute("loggedUser",userName);
		session.setAttribute("Password",password);
		
		response.setContentType("text/html");
		
		UserDAO  userDao = new UserDAO();
		User user = userDao.getUser(userName, password);
		
		
		System.out.println("Inside servlet:"+user);
		//System.out.println(customer.getCustId());
		
		out.println("<html>");
		if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
             RequestDispatcher dispatcher=request.getRequestDispatcher("adminHomePage.jsp");	
	         dispatcher.forward(request, response);
	         session.setAttribute("adminId", 1);
		}else if(user !=null){
			int id = user.getId();
			session.setAttribute("userId", id);
            RequestDispatcher dispatcher=request.getRequestDispatcher("userHomePanel.jsp");	
		    dispatcher.forward(request, response);			
		}
		else{
	        out.println("<body bgcolor=yellow text=red> Invalid credentials.!</body>");
            RequestDispatcher dispatcher=request.getRequestDispatcher("login.html");
		    dispatcher.include(request, response);		
		}
		out.println("</html>");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
