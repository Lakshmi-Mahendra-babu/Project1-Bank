package com.bank.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
@NamedQueries({
@NamedQuery(name="allCustomers", query=" from Customer c"),
@NamedQuery(name="getCustomer", query="from Customer c where c.CustomerAccountNumber=:CustomerAccountNumber"),
@NamedQuery(name="customerLogin", query="select CustomerName from Customer c where c.CustomerAccountNumber=:CustomerAccountNumber")
})
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CustomerAccountNumber")
	private int CustomerAccountNumber;
	@Column(name="CustomerName")
	private String CustomerName;
	@Column(name="MailId")
	private String MailId;
	@Column(name="MobileNumber")
	private long MobileNumber;
	@Column(name="Address")
	private String Address;
	@Column(name="CurrentAmount")
	private int CurrentAmount;
	@Column(name="CreditedAmount")
	private int CreditedAmount;
	@Column(name="DebitedAmount")
	private int DebitedAmount;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerAccountNumber, String customerName, String mailId, long mobileNumber, String address,
			int currentAmount, int creditedAmount, int debitedAmount) {
		super();
		this.CustomerAccountNumber = customerAccountNumber;
		this.CustomerName = customerName;
		this.MailId = mailId;
		this.MobileNumber = mobileNumber;
		this.Address = address;
		this.CurrentAmount = currentAmount;
		this.CreditedAmount = creditedAmount;
		this.DebitedAmount = debitedAmount;
	}

	public int getCustomerAccountNumber() {
		return CustomerAccountNumber;
	}

	public void setCustomerAccountNumber(int customerAccountNumber) {
		this.CustomerAccountNumber = customerAccountNumber;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public String setCustomerName(String customerName) {
		return this.CustomerName = customerName;
	}

	public String getMailId() {
		return MailId;
	}

	public void setMailId(String mailId) {
		this.MailId = mailId;
	}

	public long getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.MobileNumber = mobileNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public int getCurrentAmount() {
		return CurrentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		this.CurrentAmount = currentAmount;
	}

	public int getCreditedAmount() {
		return CreditedAmount;
	}

	public void setCreditedAmount(int creditedAmount) {
		this.CreditedAmount = creditedAmount;
	}

	public int getDebitedAmount() {
		return DebitedAmount;
	}

	public void setDebitedAmount(int debitedAmount) {
		this.DebitedAmount = debitedAmount;
	}

	@Override
	public String toString() {
		return "Customer [CustomerAccountNumber=" + CustomerAccountNumber + ", CustomerName=" + CustomerName
				+ ", MailId=" + MailId + ", MobileNumber=" + MobileNumber + ", Address=" + Address + ", CurrentAmount="
				+ CurrentAmount + ", CreditedAmount=" + CreditedAmount + ", DebitedAmount=" + DebitedAmount + "]";
	}

	
	
}
