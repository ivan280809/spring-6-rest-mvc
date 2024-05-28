package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CustomerService {
    Customer getCustomerById(UUID customerId);

    List<Customer> listCustomers();

    Customer saveCustomer (Customer customer);

    void updateCustomerById(UUID customerId, Customer customer);
}
