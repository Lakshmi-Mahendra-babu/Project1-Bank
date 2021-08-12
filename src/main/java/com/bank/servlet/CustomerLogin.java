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

public class CustomerLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger log = Logger.getLogger(CustomerLogin.class);
		log.info("Welcome to Customer Login!");
		int id = Integer.parseInt(request.getParameter("CustomerAccountNumber"));
     	String password = request.getParameter("CustomerName");
		
		CustomerDAOImp dao=new CustomerDAOImp();
		Customer cus=dao.existingCustomer(id,password);
		cus.getCustomerAccountNumber();
		String pass=cus.getCustomerName();
		PrintWriter out=response.getWriter();
			if(pass.equals(password)) {
				out.println("<script>");
		        String alert = "Customer has been Logined Sucessfully!";
				out.println("alert('" + alert + "');");
		        out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("CustomerHome.html");
				rd.include(request, response);
				log.info("Customer Login Sucess!");				
	}else {
		out.println("<script>");
        String alert = "Customer has been Logi Fail!";
		out.println("alert('" + alert + "');");
        out.println("</script>");
		RequestDispatcher rd=request.getRequestDispatcher("CustomerLogin.html");
		rd.include(request, response);
	}
	}
}
