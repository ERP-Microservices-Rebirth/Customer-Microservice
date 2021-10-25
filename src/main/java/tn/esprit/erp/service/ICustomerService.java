package tn.esprit.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.erp.entity.Customer;

@Service
public interface ICustomerService {
	List<Customer> retrieveAllCustomers();
	Customer addCustomer(Customer customer);
	void deleteCustomer(String id);
	void deleteAllCustomers();
	Customer updateCustomer(String id, Customer customer);
	Customer retrieveCustomer(String id);
}
