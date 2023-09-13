package com.nissan.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {

	//deposit
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance + ?2 WHERE accountNo = ?1")
	public void depositAmount(Integer accountNo,double amount);
	
	//withdraw
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance =balance - ?2 WHERE accountNo = ?1")
	public void withdrawAmount(Integer accountNo,double amount);
	
	//get balance
	@Query("SELECT balance FROM Customer WHERE accountNo = ?1")
	public double getBalance(Integer accountNo);
	
	//transfer amount
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance =balance - ?2 WHERE accountNo = ?1")
	public void transferAmount(Integer accountNo,double amount);
	
	

}
