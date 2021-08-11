package com.bank.bankManagement;
import java.util.List;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bank.client.Employee;
import com.bank.hibernet.HibernateUtill;

@Path("/employee")
public class EmplyoeeMain {
		
	@POST
	@Path("/employeeid")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public static void existingEmp(@FormParam("EmployeeId") int EmployeeId,@FormParam("Password") String Password) {
		
		Session session = HibernateUtill.getSessionFactory().openSession();
    	Transaction tx=session.beginTransaction();
    	Employee query = (Employee) session.getNamedQuery("employeeLogin").setParameter("EmployeeId",EmployeeId).uniqueResult();
    	//List<Employee> sts=query.getResultList();
//    	session.getTransaction().commit();
//    	session.close();
    	//query.getPassword();
//		Employee e=new Employee();
//		EmployeeDAOImplementation emp=new EmployeeDAOImplementation();
//		emp.existingEmployee(EmployeeId);
//		String pass=e.getPassword();
		if(query.getPassword().equalsIgnoreCase(Password)) {
			System.out.println("Employee Login Success!");
		}
	}			
}
