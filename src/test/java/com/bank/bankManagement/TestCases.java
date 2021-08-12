package com.bank.bankManagement;

import org.junit.Assert;
import org.junit.Test;

import com.bank.client.CustomerTransaction;
import com.bank.dao.CustomerDAOImp;
import com.bank.dao.EmployeeDAOImplementation;

public class TestCases {
	CustomerDAOImp cus=new CustomerDAOImp();
	EmployeeDAOImplementation emp=new  EmployeeDAOImplementation();
	@Test
	public void testTransfer() {		
		Assert.assertEquals(1,cus.transfer(1, 500, 1000));
	}
	@Test
	public void testNewCustomer() {
				Assert.assertNotEquals(1,cus.allCustomers());
	}
	@Test
	public void testExistingCustomer() {
		Assert.assertNotEquals(1,cus.existingCustomer(1, "mahe"));
	}
	@Test
	public void testGetCustomer() {
		Assert.assertNotEquals(null,cus.getCustomer(1));
	}
	@Test
	public void testDeposit() {
		Assert.assertNotEquals(null,cus.depositUpdate(2, 200));
	}
	@Test
	public void testwithdraw() {
		Assert.assertNotEquals(null,cus.withdrawUpdate(2, 500));
	}
	@Test
	public void testTransaction() {
		CustomerTransaction ct=new CustomerTransaction();
		Assert.assertNotEquals(null,cus.customerTransaction(ct));
	}
	@Test
	public void testTransactionDetails() {
		CustomerTransaction ct=new CustomerTransaction();
		Assert.assertNotEquals(null,cus.getCustomerTransaction(1));
	}
	@Test
	public void testCustomer() {		
		Assert.assertNotNull(cus);
	}
	@Test
	public void employee() {		
		Assert.assertTrue(emp.equals(emp));
	}
	@Test
	public void employee2() {	
		Assert.assertTrue(true);
	}
	@Test
	public void employee3() {	
		Assert.assertSame(emp, emp);
	}
	@Test
	public void employee6() {	
		Assert.assertFalse(false);
	}
}
