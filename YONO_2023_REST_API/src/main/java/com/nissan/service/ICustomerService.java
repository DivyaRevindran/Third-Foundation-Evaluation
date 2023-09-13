package com.nissan.service;

import com.nissan.common.APIResponse;

public interface ICustomerService {

	
	//deposit amount
	public APIResponse depositCash(int accountNo,double amount);

	//withdraw amount
	public APIResponse withdrawCash(int accountNo,double amount);

	//show balance amount
	public APIResponse showBalanceCash(int accountNo);

	//transfer amount
	public APIResponse transferCash(int accountNo,double amount);

}
