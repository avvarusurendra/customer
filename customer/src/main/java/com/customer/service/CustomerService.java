package com.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {
   
	@Autowired
	CustomerRepository customerRepository;
	
	public String saveCustomer(Customer customer) {
		
		int status = customerRepository.saveCustomer(customer);
		
		if(status==1) {
			return "inserted record in DB successfully "+status;
			
		}else {
			return "not inserted in DB "+status;
			
		}
	}
     
}
	