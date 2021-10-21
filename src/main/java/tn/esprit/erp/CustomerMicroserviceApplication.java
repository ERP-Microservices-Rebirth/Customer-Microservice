package tn.esprit.erp;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import tn.esprit.erp.entity.Customer;
import tn.esprit.erp.repository.CustomerRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CustomerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMicroserviceApplication.class, args);
	}
	
	/*@Bean
	ApplicationRunner init(CustomerRepository customerRepository) {
		Customer customer1 = new Customer("Malek", "Ajmi", "ajmi.malek@esprit.tn");
		Customer customer2 = new Customer("Achref", "Aguel", "achref.aguel@esprit.tn");
		Customer customer3 = new Customer("Malek", "Personal", "ajmimalek5@gmail.com");
		return args -> {
			Stream.of(customer1, customer2, customer3).forEach(customer -> {
				customerRepository.save(customer);
			});
		};
}*/
}
