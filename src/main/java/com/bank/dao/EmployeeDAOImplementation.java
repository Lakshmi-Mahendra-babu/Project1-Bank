package com.bank.dao;




import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bank.client.Employee;
import com.bank.hibernet.HibernateUtill;


public class EmployeeDAOImplementation implements EmployeeDAO {
	private static Logger log = Logger.getLogger(EmployeeDAOImplementation.class);
	
	public Employee existingEmployee(String EmployeeId) {
	 log.info("Welcome to Employee Login!");
		Transaction tx=null;
		Session session=null;
		Employee emp=new Employee();
		try {
		session = HibernateUtill.getSessionFactory().openSession();
    	tx=session.beginTransaction();
    	emp=session.get(Employee.class,EmployeeId);
    	emp.getEmployeeId();
    	emp.getPassword();
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
		return emp;

}
}
