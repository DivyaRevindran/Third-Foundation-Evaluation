package com.nissan.rest;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.service.ICustomerService;
import com.nissan.util.JwtUtilCustomer;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private ICustomerService customerService;;

	@Autowired
	private JwtUtilCustomer jwtUtilCustomer;

	// deposit
	@GetMapping("/customer/deposit/{accNo}&{amount}")
	public ResponseEntity<APIResponse> depositAmount(@PathVariable int accNo, @PathVariable double amount,
			@RequestHeader(value = "customerAuthorisation", defaultValue = "") String auth)
			throws AccessDeniedException {
		jwtUtilCustomer.verify(auth);
		apiResponse = customerService.depositCash(accNo, amount);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	@GetMapping("/customer/withdraw/{accNo}&{amount}")
	public ResponseEntity<APIResponse> withdrawAmount(@PathVariable Integer accNo, @PathVariable double amount,
			@RequestHeader(value = "customerAuthorisation", defaultValue = "") String auth)
			throws AccessDeniedException {
		jwtUtilCustomer.verify(auth);
		apiResponse = customerService.withdrawCash(accNo, amount);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@GetMapping("/customer/balance/{accNo}")
	public ResponseEntity<APIResponse> balanceAmount(@PathVariable Integer accNo,
			@RequestHeader(value = "customerAuthorisation", defaultValue = "") String auth)
			throws AccessDeniedException {
		jwtUtilCustomer.verify(auth);
		apiResponse = customerService.showBalanceCash(accNo);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	@GetMapping("/customer/transfer/{accNo}&{amount}")
	public ResponseEntity<APIResponse> transferAmount(@PathVariable Integer accNo, @PathVariable double amount,
			@RequestHeader(value = "customerAuthorisation", defaultValue = "") String auth)
			throws AccessDeniedException {
		jwtUtilCustomer.verify(auth);
		apiResponse = customerService.transferCash(accNo, amount);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
}
