package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bank.hibernet.HibernateUtill;
import com.bank.client.Customer;
import com.bank.client.CustomerTransaction;


public class CustomerDAOImp implements CustomerDAO{
	
	@Override
	public void newCustomer(Customer cust) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		Session session=null;
		try {
			session = HibernateUtill.getSessionFactory().openSession();
	        tx=session.beginTransaction();
	        session.save(cust);
	        tx.commit();
	        
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
	
	public List<Customer> allCustomers(){
		Transaction tx=null;
		Session session=null;
		List<Customer> clist=new ArrayList<Customer>();
		Customer cus=null;
		try {
			cus=new Customer();
			session = HibernateUtill.getSessionFactory().openSession();
	        tx=session.beginTransaction();
	        clist=session.getNamedQuery("allCustomers").list();
	        for(Customer customer : clist) {
	    		System.out.println(customer);
	        }
	        tx.commit();
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
		return clist;
	}
	
	public Customer existingCustomer(int CustomerAccountNumber,String CustomerName) {
		 
		Transaction tx=null;
		Session session=null;
		Customer c=new Customer();
		Customer pass=null;
//		Customer query=null;
		try {
		session = HibernateUtill.getSessionFactory().openSession();
    	tx=session.beginTransaction();
//    	query = (Customer) session.getNamedQuery("customerLogin").setParameter("CustomerAccountNumber",CustomerAccountNumber).uniqueResult();
    	 //String sts=query.();
    	c=session.get(Customer.class,CustomerAccountNumber);
    	c.getCustomerName();
//    	session.save(c);
    	String pas=c.getCustomerName();
    	session.getTransaction().commit();
    	System.out.println(pas);
        if(CustomerName.equalsIgnoreCase(pas)) {
        	System.out.println("Sucess");
        }
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
		return pass;
	}
	
	@Override
	public List<Customer> getCustomer(int CustomerAccountNumber) {
		Customer cus=null;
		
		Transaction tx=null;
		Session session=null;
		List<Customer> list=null;
		 try {
			 cus=new Customer();
				session = HibernateUtill.getSessionFactory().openSession();
		        tx=session.beginTransaction();
		        list=session.getNamedQuery("getCustomer").setParameter("CustomerAccountNumber",CustomerAccountNumber).list();
		        tx.commit();
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
			return list;	
			}
	
	
	public Customer depositUpdate(int CustomerAccountNumber,int CreditedAmount) {
		 
		Transaction tx=null;
		Session session=null;
		Customer c=new Customer();
		try {
		session = HibernateUtill.getSessionFactory().openSession();
    	tx=session.beginTransaction();
    	c=session.get(Customer.class,CustomerAccountNumber);
    	int curramo=c.getCurrentAmount();
    	int total=curramo+CreditedAmount;
    	c.setCreditedAmount(CreditedAmount);
    	c.setCurrentAmount(total);
    	session.update(c);
    	session.save(c);
    	session.getTransaction().commit();
    	System.out.println(c);
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
		//return 0;
		return c;
	}
	
	public Customer withdrawUpdate(int CustomerAccountNumber,int DebitedAmount) {
		 
		Transaction tx=null;
		Session session=null;
		Customer c=new Customer();
		try {
		session = HibernateUtill.getSessionFactory().openSession();
    	tx=session.beginTransaction();
    	c=session.get(Customer.class,CustomerAccountNumber);
    	int curramo=c.getCurrentAmount();
    	int total=curramo-DebitedAmount;
    	c.setDebitedAmount(DebitedAmount);
    	c.setCurrentAmount(total);
    	if(total>=500) {
    	session.update(c);
    	session.save(c);
    	session.getTransaction().commit();
    	System.out.println(c);
    	}else {
    		System.out.println("You Amount is not Sufficent. Please try to withdraw other amount!");
    	}
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
		//return 0;
		return c;
	}
	
	
//	public int customerTransaction(CustomerTransaction ct) {
//		// TODO Auto-generated method stub
//		Transaction tx=null;
//		Session session=null;
//		int result=0;
//		try {
//			session = HibernateUtill.getSessionFactory().openSession();
//	        tx=session.beginTransaction();
//	        session.save(ct);
//	        tx.commit();
//	        System.out.println(ct);
//	        result=1;
//		}catch(Exception e) {
//    		if(tx!=null) {
//    			tx.rollback();
//    		}
//    		e.printStackTrace();
//    	}finally {
//    		if(session!=null) {
//    			session.close();
//    		}
//    	}
//		return result;
//	}
}	
	
//	@Override
//	public List<Customer> getPersons() {
//		
//		
//		Customer person=null;
//		List<Customer> personList = new ArrayList<Customer>();
//		Connection conn=null;
//		
//		 try {
//			conn=ConnectionUtils.getConnection();
//			 
//			Statement stmt=conn.createStatement();
//			String queryActor="Select * from customer";
//			ResultSet rs=stmt.executeQuery(queryActor);
//			
//			while(rs.next()) {
//				 person=new Customer();
//				person.setCustomerAccountNumber(rs.getInt(0));
//				person.setCustomerName(rs.getString(1));
//				person.setMailId(rs.getString(2));
//				person.setMailId(rs.getString(3));
//				personList.add(person);
//			}		
//			
//						stmt.close();
//						conn.close();
//						
//					}  catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					return personList;
//				}
//	}


//	@Override
//	public List<Customer> existingCustomer(long  customerAccountNumber) {
//		// TODO Auto-generated method stub
//		//List<Customer> listOfcus=null;
//			Session session = HibernateUtill.getSessionFactory().openSession();
//	    	Transaction tx=session.beginTransaction();
//	    	Query query=session.getNamedQuery("findCustomerByAccountNumber").setParameter("CustomerAccountNumber",customerAccountNumber);
//	    	List<Customer> sts=query.getResultList();
//	    	for(Customer student : sts) {
//	    		System.out.println(student);
//	    	}
//	    	session.getTransaction().commit();
//	    	session.close();
//			return sts;
//	}

