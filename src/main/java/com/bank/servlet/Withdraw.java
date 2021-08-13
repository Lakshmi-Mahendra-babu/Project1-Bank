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


public class Withdraw extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(Withdraw.class);
		
		int id = Integer.parseInt(request.getParameter("CustomerAccountNumber"));
     	int amount = Integer.parseInt(request.getParameter("DebitedAmount"));
		
     	
     	CustomerDAOImp dao=new CustomerDAOImp();
     	Customer c=new Customer();

     	Customer d=dao.withdrawUpdate(id,amount);	
     	PrintWriter out=response.getWriter();
		if(d!=null) {
				
			out.println("<script>");
	        String alert = "Amount Debited Sucessfully!";
			out.println("alert('" + alert + "');");
	        out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("CustomerHome.html");
				rd.include(request, response);
				
				log.info("Amount Withdraw Sucess!");
	}else {
		out.println("<script>");
        String alert = "Amount Withdraw Fail. Try Again!";
		out.println("alert('" + alert + "');");
        out.println("</script>");
		RequestDispatcher rd=request.getRequestDispatcher("Withdraw.html");
		rd.include(request, response);
	}
	}

}
