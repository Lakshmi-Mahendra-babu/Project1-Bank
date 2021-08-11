package com.bank.dao;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.bank.bankManagement.CustomerMain;
import com.bank.client.Customer;
import com.bank.client.Employee;
import com.bank.hibernet.HibernateUtill;


public class EmployeeDAOImplementation implements EmployeeDAO {
	private static Logger log = Logger.getLogger(EmployeeDAOImplementation.class);
	public void existingEmployee(String EmployeeId) {
	 log.info("Welcome to Employee Login!");
		Transaction tx=null;
		Session session=null;
		try {
		session = HibernateUtill.getSessionFactory().openSession();
    	tx=session.beginTransaction();
    	Employee query = (Employee) session.getNamedQuery("employeeLogin").setParameter("EmployeeId",EmployeeId).uniqueResult();
    	 //String sts=query.();
    	session.getTransaction().commit();
		}catch(Exception e) {
    		if(tx!=null) {
    			tx.rollback();
    		}
    		e.printStackTrace();
    	}finally {
    		if(session!=null) {
    			session.close();
    		}
	}

}
}
