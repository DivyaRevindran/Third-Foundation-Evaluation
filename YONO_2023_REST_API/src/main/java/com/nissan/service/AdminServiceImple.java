package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.DTO.ActiveCustomerDTO;
import com.nissan.common.APIResponse;
import com.nissan.common.Validation;
import com.nissan.model.Customer;
import com.nissan.repo.IAdminRepository;

@Service
public class AdminServiceImple implements IAdminService {
	@Autowired
	private IAdminRepository adminRepo;

	@Autowired
	private Validation validation;

	@Autowired
	private AutoGenerator autoGenerator;
	
	@Autowired
	private APIResponse apiResponse;

	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return (List<Customer>) adminRepo.findAll();
	}

	@Override
	public APIResponse saveCustomer(Customer customer) {
		
		customer.setAccountNo(autoGenerator.getAccountNo());
		customer.setAtmPin(autoGenerator.getPin());
		if (validation.isNameValid(customer.getCustomerName())) 
		{
			if(validation.checkMobileNumber(customer.getMobNumber()))
			{
				adminRepo.save(customer);
				apiResponse.setData("Customer added successfully");
				apiResponse.setStatus(200);
				return apiResponse;
			}
			else
			{
				apiResponse.setData("Mobile number should contain only digits and should be 10 digits long");
				apiResponse.setStatus(500);
				return apiResponse;
				
			}
		}
		else
		{
			apiResponse.setData("name should contain only alphabets and should be less than 30 letters");
			apiResponse.setStatus(500);
			return apiResponse;
			
		}
		
	}

	@Override
	public Customer getCustomer(int accNo) {
		
		return adminRepo.findById(accNo)
				.orElseThrow(() -> new RuntimeException("Customer not found for account number" + accNo));
	}

	@Transactional
	@Override
	public void deleteCustomer(int accNo) {
		if(adminRepo.findById(accNo)==null) {
			throw new RuntimeException("Customer not found for account number" + accNo);
		}
		else {
		adminRepo.deleteCustomer(accNo);
		}

	}

	@Override
	public APIResponse saveUpdatedCustomer(Customer customer) {

		if (validation.isNameValid(customer.getCustomerName())) 
		{
			if(validation.checkMobileNumber(customer.getMobNumber()))
			{
				adminRepo.save(customer);
				apiResponse.setData("Customer updated successfully");
				apiResponse.setStatus(200);
				return apiResponse;
			}
			else
			{
				apiResponse.setData("Mobile number should contain only digits and should be 10 digits long");
				apiResponse.setStatus(500);
				return apiResponse;
				
			}
		}
		else
		{
			apiResponse.setData("name should contain only alphabets and should be less than 30 letters");
			apiResponse.setStatus(500);
			return apiResponse;
			
		}

	}

	@Override
	public List<ActiveCustomerDTO> getAllActiveCustomers() {
		// TODO Auto-generated method stub
		return adminRepo.getActiveCustomers();
	}

}
