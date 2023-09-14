package com.nissan.repo;

import org.springframework.data.repository.CrudRepository;

import com.nissan.model.User;

public interface ISignUpRepository extends CrudRepository<User, Integer>{
	
	

}
