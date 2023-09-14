package com.nissan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.common.APIResponse;
import com.nissan.common.Validation;
import com.nissan.repo.ICustomerRepository;

@Service
public class CustomerServiceImple implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepo;

	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private Validation validation;

	@Transactional
	@Override
	public APIResponse depositCash(int accountNo, double amount) {
		if (validation.checkAccNumber(accountNo)) {
			if (amount > 50000) {

				
				customerRepo.depositAmount(accountNo, amount);
				apiResponse.setData("You have to enter the pan number.");
				apiResponse.setStatus(200);
				return apiResponse;

			} else {
				customerRepo.depositAmount(accountNo, amount);
				apiResponse.setData("Deposited amount successfuly");
				apiResponse.setStatus(200);
				return apiResponse;
			}
		} else {
			apiResponse.setData("Account number should be 9 digits long!");
			apiResponse.setStatus(500);
			return apiResponse;
		}

	}

	@Transactional
	@Override
	public APIResponse withdrawCash(int accountNo, double amount) {
		if (validation.checkAccNumber(accountNo)) {
			if (customerRepo.getBalance(accountNo) > amount) {
				customerRepo.withdrawAmount(accountNo, amount);
				apiResponse.setData("Amount is debited from your account");
				apiResponse.setStatus(200);
				return apiResponse;
			} else {
				apiResponse.setData("Insufficient balance");
				apiResponse.setStatus(500);
				return apiResponse;
			}
		} else {
			apiResponse.setData("Account number should be 9 digits long!");
			apiResponse.setStatus(500);
			return apiResponse;
		}

	}

	@Override
	public APIResponse showBalanceCash(int accountNo) {
		if (validation.checkAccNumber(accountNo)) {
			double balance = customerRepo.getBalance(accountNo);
			apiResponse.setStatus(200);
			apiResponse.setData("Balance is " + balance);
			return apiResponse;
		} else {
			apiResponse.setData("Account number should be 9 digits long!");
			apiResponse.setStatus(500);
			return apiResponse;
		}
	}

	@Transactional
	@Override
	public APIResponse transferCash(int accountNo, double amount) {
		if (validation.checkAccNumber(accountNo)) {
			if (customerRepo.getBalance(accountNo) > amount) {
				customerRepo.transferAmount(accountNo, amount);
				apiResponse.setData("Transferred amount successfuly");
				apiResponse.setStatus(200);
				return apiResponse;

			} else {
				apiResponse.setStatus(500);
				apiResponse.setData("Insufficient balance");
				return apiResponse;
			}
		} else {
			apiResponse.setData("Account number should be 9 digits long!");
			apiResponse.setStatus(500);
			return apiResponse;
		}

	}

}
