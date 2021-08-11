package com.bank.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CustomerTransaction")
//@NamedQuery(name="deposit", query="insert into CustomerTransaction ct (CustomerAccountNumber,CreditedAmount,DebitedAmount"
//		+BalanceAmount ") values()")
public class CustomerTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Sno;
	@Column(name="CustomerAccountNumber")
	private int CustomerAccountNumber;
	@Column(name="CreditedAmount")
	private double CreditedAmount;
	@Column(name="DebitedAmount")
	private double DebitedAmount;
	@Column(name="BalanceAmount")
	private double BalanceAmount;
	public CustomerTransaction() {
		super();
	}
		public CustomerTransaction(int CustomerAccountNumber,double CreditedAmount,double DebitedAmount,double BalanceAmount) {
			super();
			this.CustomerAccountNumber = CustomerAccountNumber;	
			this.CreditedAmount=CreditedAmount;
			this.DebitedAmount=DebitedAmount;
			this.BalanceAmount=BalanceAmount;
		}
		public int getCustomerAccountNumber() {
			return CustomerAccountNumber;
		}
		public void setCustomerAccountNumber(int  CustomerAccountNumber) {
			// TODO Auto-generated method stub
			this.CustomerAccountNumber = CustomerAccountNumber;
		}
		public double getCreditedAmount() {
			// TODO Auto-generated method stub
			return CreditedAmount;
		}
		public void setCreditedAmount(double CreditedAmount) {
			// TODO Auto-generated method stub
			this.CreditedAmount=CreditedAmount;
		}
		public double getDebitedAmount() {
			// TODO Auto-generated method stub
			return DebitedAmount;
		}
		public void setDebitedAmount(double DebitedAmount) {
			// TODO Auto-generated method stub
			this.DebitedAmount=DebitedAmount;
		}
		public double getBalanceAmount() {
			// TODO Auto-generated method stub
			return BalanceAmount;
		}
		public void setBalanceAmount(double BalanceAmount) {
			// TODO Auto-generated method stub
			this.BalanceAmount = BalanceAmount;
		}
		@Override
		public String toString() {
			return "CustomerTransaction [CustomerAccountNumber=" + CustomerAccountNumber + ", CreditedAmount="
					+ CreditedAmount + ", DebitedAmount=" + DebitedAmount + ", BalanceAmount=" + BalanceAmount + "]";
		}
	
}
