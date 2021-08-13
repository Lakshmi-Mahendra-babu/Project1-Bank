package com.bank.dao;

import java.util.List;

import com.bank.client.Customer;
import com.bank.client.CustomerTransaction;


public interface CustomerDAO {
	public Customer newCustomer(Customer cust);
	public List<Customer> allCustomers();
	public Customer existingCustomer(int CustomerAccountNumber,String CustomerName);
	public List<Customer> getCustomer(int CustomerAccountNumber);
	public Customer depositUpdate(int CustomerAccountNumber,int CreditedAmount);
	public Customer withdrawUpdate(int CustomerAccountNumber,int DebitedAmount);
	public List<CustomerTransaction> getCustomerTransaction(int CustomerAccountNumber);
	
	
}
