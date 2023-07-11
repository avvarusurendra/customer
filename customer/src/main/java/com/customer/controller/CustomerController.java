package com.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;
import com.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping(value = "/customer")
	public String saveCustomer(@RequestBody Customer customer) {
		String status = null;
		if (customer.getcAge() > 18) {
			status = customerService.saveCustomer(customer);
		} else {
			status = "customer age is lessthan 18";
		}
		return status;

	}

}
