package com.nissan.DTO;

import javax.persistence.Column;

public class ActiveCustomerDTO {

	private int accountNo;

	private String customerName;

	private String mobNumber;

	private String emailId;

	private boolean isActive = true;

	public ActiveCustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActiveCustomerDTO(int accountNo, String customerName, String mobNumber, String emailId, boolean isActive) {
		super();
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.mobNumber = mobNumber;
		this.emailId = emailId;
		this.isActive = isActive;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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

	@Override
	public String toString() {
		return "ActiveCustomerDTO [accountNo=" + accountNo + ", customerName=" + customerName + ", mobNumber="
				+ mobNumber + ", emailId=" + emailId + ", isActive=" + isActive + "]";
	}

}
