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


public class Deposit extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger log = Logger.getLogger(Deposit.class);
		log.debug("Deposit Money!");
		int id = Integer.parseInt(request.getParameter("CustomerAccountNumber"));
     	int amount = Integer.parseInt(request.getParameter("CreditedAmount"));
		
		CustomerDAOImp dao=new CustomerDAOImp();
		Customer d=dao.depositUpdate(id,amount);	
		PrintWriter out=response.getWriter();
		if(d!=null) {
			out.println("<script>");
	        String alert = "Amount Deposited Sucessfully!";
			out.println("alert('" + alert + "');");
	        out.println("</script>");
			
				RequestDispatcher rd=request.getRequestDispatcher("CustomerHome.html");
				rd.include(request, response);
				
				log.debug("Amount Deposited!");
	}else {
		out.println("<script>");
        String alert = "Amount Not Deposited! Please Try Again";
		out.println("alert('" + alert + "');");
        out.println("</script>");
		RequestDispatcher rd=request.getRequestDispatcher("Deposit.html");
		rd.include(request, response);
		log.warn("Amount not Deposited!");
	}
	}
	}

