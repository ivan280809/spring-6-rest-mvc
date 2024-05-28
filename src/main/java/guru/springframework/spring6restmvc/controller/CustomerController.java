package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    CustomerService customerService;

    @GetMapping()
    public List<Customer> listCustomers(){
        log.debug("CustomerController called");
        return customerService.listCustomers();
    }

    @GetMapping(value ="/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId){
        log.debug("CustomerController called");
        return customerService.getCustomerById(customerId);
    }
}
