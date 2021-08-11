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
import com.bank.client.CustomerTransaction;
import com.bank.dao.CustomerDAOImp;
import com.bank.dao.EmployeeDAOImplementation;

public class Deposit extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger log = Logger.getLogger(Deposit.class);
		log.debug("Deposit Money!");
		int id = Integer.parseInt(request.getParameter("CustomerAccountNumber"));
     	int amount = Integer.parseInt(request.getParameter("CreditedAmount"));
		
		
		//CustomerTransaction ct=new CustomerTransaction();
		CustomerDAOImp dao=new CustomerDAOImp();
		Customer c=new Customer();
//		int cum=c.getCurrentAmount()+amount;
//		c.setCreditedAmount(amount);
//		c.setCurrentAmount(cum);
//		c.setCustomerAccountNumber(id);
		Customer d=dao.depositUpdate(id,amount);	
		PrintWriter out=response.getWriter();
		if(d!=null) {
				//int curam = c.getCurrentAmount(Integer.parseInt(request.getParameter("CurrentAmount")));
				//int camou=curam+amount; 
				//c.setCurrentAmount(amount);
			
				RequestDispatcher rd=request.getRequestDispatcher("CustomerHome.html");
				rd.include(request, response);
				
				log.debug("Amount Deposited!");
	}else {
		RequestDispatcher rd=request.getRequestDispatcher("Deposit.html");
		rd.include(request, response);
		log.warn("Amount not Deposited!");
	}
	}
	}

