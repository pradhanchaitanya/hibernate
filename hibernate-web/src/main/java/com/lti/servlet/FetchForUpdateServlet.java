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

@WebServlet("/fetchforUpdate")
public class FetchForUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerDao dao = new CustomerDao();
		Customer c =dao.fetchById(id);
		HttpSession session = request.getSession();
		session.setAttribute("cust",c);
		response.sendRedirect("update.jsp");
	}

	

}
