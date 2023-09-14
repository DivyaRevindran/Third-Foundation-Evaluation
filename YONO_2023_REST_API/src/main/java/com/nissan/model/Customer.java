package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@Column(name="accountNo")
	private int accountNo;
	
	@Column(name="customerName",nullable=false,length=60)
	private String customerName;
	
	@Column(name="accountType",nullable=false,length=60)
	private String accountType="Savings";
	
	@Column(name="balance",nullable=false,length=60)
	private double balance;
	
	
	private double minimumBalance=1000;
	
	@Column(name="mobNumber",nullable=false,length=60)
	private String mobNumber;
	
	@Column(name="emailId",nullable=false,length=60)
	private String emailId;

	
	@Column(name="atmPin",nullable=false,length=60)
	private int atmPin;
	//check the status of customer
	private boolean isActive=true;
	public Customer() {
	
	}
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	public String getMobNumber() {
		return mobNumber;
	}
	public void setMobNumber(String mobNumber) {
		this.mobNumber = mobNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAtmPin() {
		return atmPin;
	}
	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", customerName=" + customerName + ", accountType=" + accountType
				+ ", balance=" + balance + ", minimumBalance=" + minimumBalance + ", mobNumber=" + mobNumber
				+ ", emailId=" + emailId + ", atmPin=" + atmPin + ", isActive=" + isActive + "]";
	}

	

}
