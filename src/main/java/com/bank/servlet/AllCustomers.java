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

import com.bank.client.Customer;
import com.bank.dao.CustomerDAOImp;
import com.bank.dao.EmployeeDAOImplementation;


public class AllCustomers extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(AllCustomers.class);
		log.info("All Customers Details Generated!");
		PrintWriter out= response.getWriter();
		CustomerDAOImp dao=new CustomerDAOImp();
		List<Customer> li=dao.allCustomers();
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
		 		+ "<body><center><table id=\"customerapi/all\"  style=width:100%>");  
         out.println("<tr><th>CustomerAccountNumber</th><th>CustomerName</th><th>MailId</th><th>MobileNumber</th><th>Address</th><th>CurrentAmount</th><th>CreditedAmount</th><th>DebitedAmount</th><tr></center>");  
         
		for(int i=0;i<li.size();i++) {
			int caccno=li.get(i).getCustomerAccountNumber();
			String cname=li.get(i).getCustomerName();
			String cmail=li.get(i).getMailId();
			long cmobile=li.get(i).getMobileNumber();
			String caddress=li.get(i).getAddress();
			int camonut=li.get(i).getCurrentAmount();
			int ccredit=li.get(i).getCreditedAmount();
			int cdebit=li.get(i).getDebitedAmount();
			
			out.println("<tr><td>" + caccno + "</td><td>" + cname + "</td><td>" + cmail + "</td><td>" + cmobile + "</td><td>"+ caddress +"</td><td>"+ camonut+ "</td><td>"+ ccredit +"</td><td>" + cdebit + "</td></tr>"); 
			
		}
		out.println("<script>");
        String alert = "Customers Details Loaded Sucessfully!";
		out.println("alert('" + alert + "');");
        out.println("</script>");
		 RequestDispatcher rd=request.getRequestDispatcher("EmployeeHome.html");  
         rd.include(request, response); 
	}

}
