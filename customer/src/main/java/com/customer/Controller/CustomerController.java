package com.customer.Controller;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import com.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Retrieves a list of all customers from the CustomerRepository.
     * @return A list of Customer entities.
     */

    @CrossOrigin("http://localhost:4200")
    @GetMapping(path = "/getAllCustomeres")
    public List<Customer> getAllCustomeres() {
        return customerService.getCustomer();
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping(path = "/insertCustomer")
    public String insertCustomer(@Valid @RequestBody Customer obj) {
        System.out.println("Received data : " + obj);
        return customerService.addCustomer(obj);
    }

    @CrossOrigin("http://localhost:4200")
    @PutMapping(path = "/updateCustomer/{customerId}")
    public void updateMedicine(@RequestBody Customer medicine){
        customerService.updateCustomer(medicine);

    }
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping (path="/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        System.out.println("Customer record deleted. Given id : " + id);
        customerService.deleteCustomer(id);
        return "Record Deleted Successfully";
    }
}

