package com.nissan.service;

import java.util.List;

import com.nissan.model.Customer;;

public interface IAdminService {
	
	//list
		public List<Customer> getCustomer();
		
		//insert
		public Customer saveCustomer(Customer customer);
		
		//search by accountNumber
		public Customer getCustomer(int accNo);
		
		//delete 
		public void deleteCustomer(int accNo);
		
		//update
		public Customer saveUpdatedCustomer(Customer customer);
		
		
		

}
