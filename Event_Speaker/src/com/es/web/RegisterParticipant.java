package com.es.web;

import java.io.IOException;
import com.es.dto.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.es.dao.*;
/**
 * Servlet implementation class RegisterCustomer
 */
@WebServlet("/RegisterParticipant")
public class RegisterParticipant extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());

        String name = request.getParameter("name");
        String mobile = request.getParameter("mobile");
        String college = request.getParameter("college");
        Participant part = new Participant();

        part.setName(name);
        part.setMobile(mobile);
        part.setCollege(college);
        
        System.out.println(part);
        ParticipantDAO partDao = new ParticipantDAO();
        
        if(partDao.add(part) != 0) {
        	response.getWriter().println("<h1>Registration Success</h1>");
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

