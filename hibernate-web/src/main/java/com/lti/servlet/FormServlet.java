package com.lti.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lti.training.hibernate.dao.CustomerDao;
import com.lti.training.hibernate.entity.Customer;

@WebServlet("/formservlet")
public class FormServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		
		
			Customer C = new Customer();
			C.setName(name);
			C.setEmail(email);
			C.setCity(city);
			
			CustomerDao dao = new CustomerDao();
			dao.add(C);
		}
	}


