package tn.esprit.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	// Clients par Secteur : http://localhost:8081/api/customers/secteur/{secteur}
	@GetMapping(value = "/secteur/{secteur}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Customer>> findCustomersBySecteur(@PathVariable(value = "secteur") String secteur) {
		return new ResponseEntity<>(customerService.retrieveCustomersBySecteur(secteur), HttpStatus.OK);
	}

	// Ajouter Client : http://localhost:8081/api/customers
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
	}
		
	// Supprimer Client : http://localhost:8081/api/customers/{id}
	@DeleteMapping("/{id}")
	@ResponseBody
	public void removeCustomer(@PathVariable("id") String id) {
		customerService.deleteCustomer(id);
	}
	
	// Supprimer tous les Clients : http://localhost:8081/api/customers
		@DeleteMapping
		@ResponseBody
		public void removeAllCustomers() {
			customerService.deleteAllCustomers();
		}
		
	// Modifier Client : http://localhost:8081/api/customers/{id}
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Customer> modifyCustomer(@PathVariable(value = "id") String id,
			@Valid @RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.updateCustomer(id,customer), HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
}
