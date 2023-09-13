package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.User;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {
	
	
	//custom method
	@Query("from User WHERE userName=?1 AND password=?2")
	public User findUserByUserNameAndPassword(String userName,String password);

}
