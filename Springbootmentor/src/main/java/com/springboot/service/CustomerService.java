package com.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.model.Customer;
import com.springboot.repos.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService
{
	private final CustomerRepository customerrepository;
	
	public Customer save(@RequestBody Customer customer)
	{
		return customerrepository.save(customer);
	}
	
	public List<Customer> getAllCustomer()
	{
		return customerrepository.findAll();
	}
	
	public Customer updateCustomer(Customer customer, Long id)
	{
		Customer existingcustomer = customerrepository.findById(id).get(); 
		existingcustomer.setCname(customer.getCname());
		existingcustomer.setOccupation(customer.getOccupation());
		return customerrepository.save(existingcustomer);
	}
	
	public void deleteCustomer(Long id)
	{
		Customer existingcustomer = customerrepository.findById(id).get(); 
		customerrepository.delete(existingcustomer);
	}
	public Customer getCustomersById(Long id)
	{
		return customerrepository.findById(id).orElseThrow(()
		-> new RuntimeException("Customer found for the id "+id));	
	}
}
