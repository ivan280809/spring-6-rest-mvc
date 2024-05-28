package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    CustomerService customerService;

    @PatchMapping("/{customerId}")
    public ResponseEntity<Void> handlePatch(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer){
        customerService.patchCustomerById(customerId, customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{customerId}")
    public ResponseEntity<Void> handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer){
        customerService.updateCustomerById(customerId, customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping
    public ResponseEntity<Void> handlePost(@RequestBody Customer customer){

        Customer savedCustomer = customerService.saveCustomer(customer);
        log.debug(savedCustomer.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer" + savedCustomer.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
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
