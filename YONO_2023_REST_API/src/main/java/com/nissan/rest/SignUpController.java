package com.nissan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.model.User;
import com.nissan.service.ISignUpService;

@RestController
@RequestMapping("/api")
public class SignUpController {
	
	@Autowired
	private APIResponse apiResponse;
	
	@Autowired
	private ISignUpService signUpService;
	
	@PostMapping("/signup")
	public ResponseEntity<APIResponse> signUpForNewUser(@RequestBody User user){
		apiResponse=signUpService.signUpByNameAndPassword(user);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
		
		
	}

}
