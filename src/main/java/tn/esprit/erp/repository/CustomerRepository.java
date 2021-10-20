package tn.esprit.erp.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.erp.entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
}
