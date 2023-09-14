package com.nissan.service;

import java.util.List;

import com.nissan.DTO.ActiveCustomerDTO;
import com.nissan.common.APIResponse;
import com.nissan.model.Customer;;

public interface IAdminService {
	
	//list
		public List<Customer> getCustomer();
		
		//insert
		public APIResponse saveCustomer(Customer customer);
		
		//search by accountNumber
		public Customer getCustomer(int accNo);
		
		//delete 
		public void deleteCustomer(int accNo);
		
		//update
		public APIResponse saveUpdatedCustomer(Customer customer);
		
		//get active customers
		public List<ActiveCustomerDTO> getAllActiveCustomers();
		
		
		

}
