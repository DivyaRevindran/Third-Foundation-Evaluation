package com.nissan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.model.User;
import com.nissan.repo.ISignUpRepository;

@Service
public class SignUpServiceImple implements ISignUpService {
	
	@Autowired
	private ISignUpRepository signUpRepository;
	
	@Autowired
	private APIResponse apiResponse;
	
	@Override
	public APIResponse signUpByNameAndPassword(User user) {
		
		signUpRepository.save(user);
		apiResponse.setStatus(200);
		apiResponse.setData("You are signed in");
		return apiResponse;
		
	}

}
