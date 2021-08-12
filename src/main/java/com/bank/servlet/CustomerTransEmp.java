package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bank.client.CustomerTransaction;
import com.bank.dao.CustomerDAOImp;

public class CustomerTransEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger log = Logger.getLogger(OneCustomer.class);
		int CustomerAccountNumber = Integer.parseInt(request.getParameter("CustomerAccountNumber"));
		log.info("Customer Transaction Details Generated!");
		PrintWriter out= response.getWriter();
		CustomerDAOImp dao=new CustomerDAOImp();
		List<CustomerTransaction> li=dao.getCustomerTransaction(CustomerAccountNumber);
		 out.println("<html>"
		 		+ "<head>"
		 		+ "<style>"
		 		+ "table, th, td {"
		 		+ " border: 1px solid black;"
		 		+ "background-color:SandyBrown;"
		 		+ "height:50px;"
		 		+ "}"
		 		+ "</style>"
		 		+ "</head>"
		 		+ "<body><center><table id=\"customertrans/transaction/CustomerAccountNumber\"  style=width:100%>");  
         out.println("<tr><th>CustomerAccountNumber</th><th>CurrentAmount</th><th>Credited/DebitedAmount</th><th>Type</th><tr></center>");  
         
		for(int i=0;i<li.size();i++) {
			int caccno=li.get(i).getCustomerAccountNumber();
			
			int camonut=li.get(i).getBalanceAmount();
			int ccredit=li.get(i).getAmount();
			String type=li.get(i).getType();
			
			out.println("<tr><td>" + caccno + "</td><td>"+ camonut+ "</td><td>"+ ccredit +"</td><td>" + type + "</td></tr>"); 
			
		}
		out.println("<script>");
        String alert = "Customer Transaction Details Generated!";
		out.println("alert('" + alert + "');");
        out.println("</script>");
		 RequestDispatcher rd=request.getRequestDispatcher("EmployeeHome.html");  
         rd.include(request, response); 
	}

}
