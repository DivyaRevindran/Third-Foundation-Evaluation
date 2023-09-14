package com.nissan.rest;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.DTO.ActiveCustomerDTO;
import com.nissan.common.APIResponse;
import com.nissan.model.Customer;
import com.nissan.service.IAdminService;
import com.nissan.util.JwtUtilAdmin;

@RestController // Controller+@Configuration
@RequestMapping("/api")
public class AdminController {
	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private IAdminService adminService;

	@Autowired
	private JwtUtilAdmin jwtUtilAdmin;

	// list
	@GetMapping("/admin")
	public List<Customer> getCustomer(@RequestHeader(value = "adminAuthorisation", defaultValue = "") String auth)
			throws AccessDeniedException {
		jwtUtilAdmin.verify(auth);
		return adminService.getCustomer();
	}

	// search by account number
	@GetMapping("/admin/{id}")
	public Customer getCustomer(@PathVariable int id,
			@RequestHeader(value = "adminAuthorisation", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtilAdmin.verify(auth);
		return adminService.getCustomer(id);
	}

	// add
	@PostMapping("/admin")
	public ResponseEntity<APIResponse> addEmployee(@RequestBody Customer customer,
			@RequestHeader(value = "adminAuthorisation", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtilAdmin.verify(auth);
		apiResponse = adminService.saveCustomer(customer);

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// update Employee
	@PutMapping("/admin")
	public ResponseEntity<APIResponse> updateEmployee(@RequestBody Customer customer,
			@RequestHeader(value = "adminAuthorisation", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtilAdmin.verify(auth);
		apiResponse = adminService.saveUpdatedCustomer(customer);

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// disable or delete Employee
	@DeleteMapping("/admin/{accNo}")
	public ResponseEntity<APIResponse> deleteEmployee(@PathVariable int accNo,
			@RequestHeader(value = "adminAuthorisation", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtilAdmin.verify(auth);
		adminService.deleteCustomer(accNo);
		apiResponse.setData("Customer deleted successfully");
		apiResponse.setStatus(200);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	//display all active customer
	@GetMapping("/admin/dto")
	public List<ActiveCustomerDTO> getActiveCustomers(@RequestHeader(value = "adminAuthorisation", defaultValue = "") String auth) throws AccessDeniedException
	{
		jwtUtilAdmin.verify(auth);
		return adminService.getAllActiveCustomers();
	}
}
