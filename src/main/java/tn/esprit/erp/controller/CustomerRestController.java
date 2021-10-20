package tn.esprit.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.erp.entity.Customer;
import tn.esprit.erp.service.ICustomerService;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerRestController {
	@Autowired
	ICustomerService customerService;

	// Ajouter Client : http://localhost:8081/api/customers
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
	}
		
	// Supprimer Client : http://localhost:8081/api/customers/{id}
	@DeleteMapping("/{id}")
	@ResponseBody
	public void removeCustomer(@PathVariable("id") String id) {
		customerService.deleteCustomer(id);
	}
		
	// Modifier Client : http://localhost:8081/api/customers/{id}
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Customer> modifyCustomer(@PathVariable(value = "id") String id,
			@RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.updateCustomer(id,customer), HttpStatus.OK);
	}
}
