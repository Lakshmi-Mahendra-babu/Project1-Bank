package com.bank.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CustomerTransaction")
@NamedQuery(name="getCustomerTransaction", query="from CustomerTransaction ct where ct.CustomerAccountNumber=:CustomerAccountNumber")
public class CustomerTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Sno;
	@Column(name="CustomerAccountNumber")
	private int CustomerAccountNumber;
	@Column(name="Amount")
	private int Amount;
	@Column(name="BalanceAmount")
	private int BalanceAmount;
	@Column(name="Type")
	private String Type;
	public CustomerTransaction() {
		super();
	}
		public CustomerTransaction(int CustomerAccountNumber,int BalanceAmount,int Amount,String Type) {
			super();
			this.CustomerAccountNumber = CustomerAccountNumber;	
			this.Amount= Amount;
			this.BalanceAmount=BalanceAmount;
			this.Type=Type;
		}
		public int getCustomerAccountNumber() {
			return CustomerAccountNumber;
		}
		public void setCustomerAccountNumber(int  CustomerAccountNumber) {
			// TODO Auto-generated method stub
			this.CustomerAccountNumber = CustomerAccountNumber;
		}
		public int getAmount() {
			// TODO Auto-generated method stub
			return Amount;
		}
		public void setAmount(int Amount) {
			// TODO Auto-generated method stub
			this.Amount=Amount;
		}
		public int getBalanceAmount() {
			// TODO Auto-generated method stub
			return BalanceAmount;
		}
		public void setBalanceAmount(int BalanceAmount) {
			// TODO Auto-generated method stub
			this.BalanceAmount = BalanceAmount;
		}
		public String getType() {
			return Type;
		}
		public void setType(String type) {
			this.Type = type;
		}
		@Override
		public String toString() {
			return "CustomerTransaction [CustomerAccountNumber=" + CustomerAccountNumber + ", Amount=" + Amount + ", BalanceAmount=" + BalanceAmount + ",Type=" + Type + "]";
		}
	
}
