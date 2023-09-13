package com.nissan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.common.APIResponse;
import com.nissan.repo.ICustomerRepository;

@Service
public class CustomerServiceImple implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepo;

	@Autowired
	private APIResponse apiResponse;

	@Transactional
	@Override
	public APIResponse depositCash(int accountNo, double amount) {
		if (amount > 50000) {
			System.out.println("Enter the pan number:");
			customerRepo.depositAmount(accountNo, amount);
			apiResponse.setData("Deposited amount successfuly");
			return apiResponse;

		} else {
			customerRepo.depositAmount(accountNo, amount);
			apiResponse.setData("Deposited amount successfuly");
			return apiResponse;
		}

	}

	@Transactional
	@Override
	public APIResponse withdrawCash(int accountNo, double amount) {
		if (customerRepo.getBalance(accountNo) > amount) {
			customerRepo.withdrawAmount(accountNo, amount);
			apiResponse.setData("Amount is debited from your account");
			return apiResponse;
		} else {
			apiResponse.setData("Insufficient balance");
			return apiResponse;
		}

	}

	@Override
	public APIResponse showBalanceCash(int accountNo) {
		double balance = customerRepo.getBalance(accountNo);
		apiResponse.setData("Balance is " + balance);
		return apiResponse;
	}

	@Transactional
	@Override
	public APIResponse transferCash(int accountNo, double amount) {
		if (customerRepo.getBalance(accountNo) > amount) {
			customerRepo.transferAmount(accountNo, amount);
			apiResponse.setData("Transferred amount successfuly");
			return apiResponse;

		} else {
			apiResponse.setData("Insufficient balance");
			return apiResponse;
		}
		

	}

}
