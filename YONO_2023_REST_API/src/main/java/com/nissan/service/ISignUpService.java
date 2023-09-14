package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.model.User;

public interface ISignUpService {
	
	
	public APIResponse signUpByNameAndPassword(User user);

}
