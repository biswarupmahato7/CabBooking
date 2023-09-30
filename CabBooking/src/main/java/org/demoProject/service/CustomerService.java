package org.demoProject.service;

import java.util.List;

import org.demoProject.model.Customer;
import org.springframework.stereotype.Service;


@Service
public interface CustomerService {
	public Customer addCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomer(Integer customerId);

	public Customer findById(Integer customerId);

	public List<Customer> findAll();
	
	public Customer findcustomerbyusername(String username);
	
	public Customer validateCustomer(String username, String password);
//
//	public Customer validateCustomer(String username, String password);

}
