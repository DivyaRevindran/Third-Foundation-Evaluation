package com.nissan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.DTO.ActiveCustomerDTO;
import com.nissan.model.Customer;

@Repository
public interface IAdminRepository extends CrudRepository<Customer, Integer> {
	
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET isActive=0 WHERE accountNo= ?1")
	public void deleteCustomer(Integer accountNo);
	
	@Query("SELECT new com.nissan.DTO.ActiveCustomerDTO(c.accountNo,c.customerName,c.mobNumber,c.emailId,c.isActive) FROM Customer c WHERE isActive=1")
	public List<ActiveCustomerDTO> getActiveCustomers();

}
