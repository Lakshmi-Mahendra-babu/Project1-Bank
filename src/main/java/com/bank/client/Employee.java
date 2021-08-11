package com.bank.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
@NamedQuery(name="employeeLogin", query="from Employee e where e.EmployeeId=:EmployeeId")
public class Employee {
	@Id
	@Column(name="EmployeeId")
	private String EmployeeId;
	@Column(name="EmployeeName")
	private String EmployeeName;
	@Column(name="Password")
	private String Password;
	@Column(name="MailId")
	private String MailId;
	@Column(name="MobileNumber")
	private long MobileNumber;
	
	public Employee(){
		super();
	}
	public Employee(String EmployeeId, String EmployeeName, String Password, String MailId,long MobileNumber) {
		super();
		this.EmployeeId = EmployeeId;
		this.EmployeeName = EmployeeName;
		this.Password = Password;
		this.MailId = MailId;
		this.MobileNumber = MobileNumber;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public String setEmployeeId(String EmployeeId) {
		return this.EmployeeId = EmployeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String EmployeeName) {
		this.EmployeeName = EmployeeName;
	}
	public String getPassword() {
		return Password;
	}
	public String setPassword(String Password) {
		 return this.Password = Password;
	}
	public String getMailId() {
		return MailId;
	}
	public void setMailId(String MailId) {
		this.MailId = MailId;
	}
	public long getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(long MobileNumber) {
		this.MobileNumber = MobileNumber;
	}
	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName + ", Password=" + Password
				+ ", MailId=" + MailId + ", MobileNumber=" + MobileNumber + "]";
	}

}
