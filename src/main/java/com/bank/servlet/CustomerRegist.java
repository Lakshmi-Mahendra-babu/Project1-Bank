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

public class CustomerRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger log = Logger.getLogger(CustomerLogin.class);
		log.info("Welcome to Customer Registration!");
		
		String name = request.getParameter("CustomerName");
		String mail = request.getParameter("MailId");
		long mobile = Long.parseLong(request.getParameter("MobileNumber"));
		String address = request.getParameter("Address");
		int amount = Integer.parseInt(request.getParameter("CurrentAmount"));
		Customer cust=new Customer();
		cust.setCustomerName(name);
		cust.setMailId(mail);
		cust.setMobileNumber(mobile);
		cust.setAddress(address);
		cust.setCurrentAmount(amount);
		CustomerDAOImp dao=new CustomerDAOImp();
		Customer st=dao.newCustomer(cust);
		PrintWriter out=response.getWriter();
		if(st!=null) {
			out.println("<script>");
	        String alert = "Customer has been Registered Sucessfully. You can login into the system!";
			out.println("alert('" + alert + "');");
	        out.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("CustomerRegistration.html");
			rd.include(request, response);
			log.info("Customer Registration Sucess!");	
		}
		else {
			out.println("<script>");
	        String alert = "Customer has been Logined Sucessfully!";
			out.println("alert('" + alert + "');");
	        out.println("</script>");
			RequestDispatcher rd=request.getRequestDispatcher("CustomerRegistration.html");
			rd.include(request, response);
			log.info("Customer Registration Failed!");	
		}
		
	}

}
