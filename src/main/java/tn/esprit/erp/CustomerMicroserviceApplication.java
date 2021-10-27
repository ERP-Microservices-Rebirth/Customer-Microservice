package tn.esprit.erp;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import tn.esprit.erp.entity.Customer;
import tn.esprit.erp.repository.CustomerRepository;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CustomerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMicroserviceApplication.class, args);
	}
	
	/*@Bean
	ApplicationRunner init(CustomerRepository customerRepository) {
		Customer customer1 = new Customer("Malek", "Ajmi", "ajmi.malek@esprit.tn","Nouvelle Medina");
		Customer customer2 = new Customer("Achref", "Aguel", "achref.aguel@esprit.tn", "Mahdia");
		Customer customer3 = new Customer("Malek", "Personal", "ajmimalek5@gmail.com", "Ben Arous");
		return args -> {
			Stream.of(customer1, customer2, customer3).forEach(customer -> {
				customerRepository.save(customer);
			});
		};
}*/
	@Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI().info(apiInfo());
    }

    public Info apiInfo() {
        Info info = new Info();
        info
                .title("Customer Microservice")
                .description("A Microservice used to manage customers")
                .version("v1.0.0");
        return info;
    }

}
