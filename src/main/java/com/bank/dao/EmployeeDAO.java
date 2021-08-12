package com.bank.dao;


import com.bank.client.Employee;


public interface EmployeeDAO {
	public Employee existingEmployee(String EmployeeId);
}
