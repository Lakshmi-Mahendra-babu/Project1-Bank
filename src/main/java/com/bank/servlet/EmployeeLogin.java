package com.bank.servlet;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.bank.client.Employee;
import com.bank.dao.EmployeeDAOImplementation;

public class EmployeeLogin extends HttpServlet {
//	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger log = Logger.getLogger(EmployeeLogin.class);
		log.info("Welcome to Employee Login!");
		String userid = request.getParameter("EmployeeId");
     	String password = request.getParameter("Password");
		
		Employee e=new Employee();
		String ui=e.setEmployeeId(request.getParameter("EmployeeId"));
		String pass=e.setPassword(request.getParameter("Password"));
		EmployeeDAOImplementation dao=new EmployeeDAOImplementation();
		dao.existingEmployee(userid);
		PrintWriter out=response.getWriter();
		if(userid.equalsIgnoreCase(ui)) {
			if(password.equalsIgnoreCase(pass)) {
				out.println("<script>");
		        String alert = "Your Login Sucess!";
				out.println("alert('" + alert + "');");
		        out.println("</script>");
				RequestDispatcher rd=request.getRequestDispatcher("EmployeeHome.html");
				rd.include(request, response);
				log.isDebugEnabled();
	}else {
		out.println("<script>");
        String alert = "Your Login failed. Try again!";
		out.println("alert('" + alert + "');");
        out.println("</script>");
		RequestDispatcher rd=request.getRequestDispatcher("EmployeeLogin.html");
		rd.include(request, response);
	}

}	
	}
}
