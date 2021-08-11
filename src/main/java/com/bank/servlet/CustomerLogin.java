package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bank.client.Customer;
import com.bank.dao.CustomerDAOImp;
import com.bank.dao.EmployeeDAOImplementation;

public class CustomerLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger log = Logger.getLogger(EmployeeDAOImplementation.class);
		log.info("Welcome to Customer Login!");
		int id = Integer.parseInt(request.getParameter("CustomerAccountNumber"));
     	String password = request.getParameter("CustomerName");
		
		Customer c=new Customer();
		CustomerDAOImp dao=new CustomerDAOImp();
		Customer pass=dao.existingCustomer(id,password);
//		int accno = c.se();

		PrintWriter out=response.getWriter();
		out.print(pass);
//		if(id==accno) {
			if(pass!=null) {
				RequestDispatcher rd=request.getRequestDispatcher("CustomerHome.html");
				rd.include(request, response);
				log.info("Customer Login Sucess!");
	}else {
		RequestDispatcher rd=request.getRequestDispatcher("CustomerLogin.html");
		rd.include(request, response);
//	}
	}
	}
}
