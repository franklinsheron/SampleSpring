package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.model.Customer;
import com.springboot.service.CustomerService;
@RestController
@RequestMapping("/customers")
public class CustomerController
{
	@Autowired
	private CustomerService customerservice;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer create(@RequestBody Customer customer ) 
	{
		return customerservice.save(customer);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Customer> read() {
		return customerservice.getAllCustomer();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	public Customer read(@PathVariable Long id) {
		return customerservice.getCustomersById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		customerservice.deleteCustomer(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PutMapping("/{id}")
	public Customer update(@PathVariable Long id, @RequestBody Customer customer) {
		return customerservice.updateCustomer(customer, id);
	}

}
