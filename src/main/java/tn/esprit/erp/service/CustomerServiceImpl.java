package tn.esprit.erp.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.erp.entity.Customer;
import tn.esprit.erp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	private static final Logger l = LogManager.getLogger(CustomerServiceImpl.class);

	@Override
	public List<Customer> retrieveAllCustomers() {
		// Affichage de la liste des clients
		List<Customer> customers = customerRepository.findAll();
		for (Customer customer : customers) {
			l.info("user +++" + customer);
		}
		return customers;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// Ajouter un client
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(String id) {
		// Supprimer un utilisateur
		customerRepository.deleteById(id);
	}

	@Override
	public Customer updateCustomer(String id, Customer customer) {
		// Modifier un client existant
		if (customerRepository.findById(id).isPresent()) {
			Customer customerExistant = customerRepository.findById(id).get();
			customerExistant.setFirstName(customer.getFirstName());
			customerExistant.setLastName(customer.getLastName());
			customerExistant.setEmail(customer.getEmail());
			return customerRepository.save(customerExistant);
		} else return null;
	}

	@Override
	public Customer retrieveCustomer(String id) {
		// Retourner un client par son ID
		return customerRepository.findById(id).get();
	}

}
