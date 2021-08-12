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
	
	public String existingCustomer(int CustomerAccountNumber,String CustomerName) {
		 
		Transaction tx=null;
		Session session=null;
		Customer c=new Customer();
		String pass=null;
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
    	if(curramo!=0) {
    		CustomerTransaction ct=new CustomerTransaction();
    		ct.setCustomerAccountNumber(CustomerAccountNumber);
    		ct.setAmount(CreditedAmount);
    		ct.setBalanceAmount(total);
    		ct.setType("Deposit");
    		customerTransaction(ct);
    	}
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
    	if(total!=0) {
        	CustomerTransaction ct=new CustomerTransaction();
    		ct.setCustomerAccountNumber(CustomerAccountNumber);
    		ct.setAmount(DebitedAmount);
    		ct.setBalanceAmount(total);
    		ct.setType("Withdraw");
    		customerTransaction(ct);
    	}
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
	public int transfer(int CustomerAccountNumber,int transferAccount,int Amount) {
		// TODO Auto-generated method stub
		int result=0;
		Customer c=depositUpdate(CustomerAccountNumber,Amount);
		if(c!=null) {
			withdrawUpdate(transferAccount, Amount);
			result=1;
		}
		return result;
	} 	
	
	public int customerTransaction(CustomerTransaction ct) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		Session session=null;
		int result=0;
		try {
			session = HibernateUtill.getSessionFactory().openSession();
	        tx=session.beginTransaction();
	        session.save(ct);
	        tx.commit();
	        System.out.println(ct);
	        result=1;
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
		return result;
	}
	@Override
	public List<CustomerTransaction> getCustomerTransaction(int CustomerAccountNumber) {
		CustomerTransaction cus=null;
		
		Transaction tx=null;
		Session session=null;
		List<CustomerTransaction> list=null;
		 try {
			 cus=new CustomerTransaction();
				session = HibernateUtill.getSessionFactory().openSession();
		        tx=session.beginTransaction();
		        list=session.getNamedQuery("getCustomerTransaction").setParameter("CustomerAccountNumber",CustomerAccountNumber).list();
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
}