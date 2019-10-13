package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.training.hibernate.dao.CustomerDao;
import com.lti.training.hibernate.entity.Customer;


@WebServlet("/updateservlet")
public class UpdateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//int id = Integer.parseInt(request.getParameter("id"));
	String email= request.getParameter("email");
	String name = request.getParameter("name");
	String city =  request.getParameter("city");
	CustomerDao dao = new CustomerDao();
	HttpSession session = request.getSession();
	Customer c = (Customer)session.getAttribute("cust"); 
	c.setEmail(email);
	c.setName(name);
	c.setCity(city);
	dao.update(c);

	//response.sendRedirect("output.html");
	}

}
