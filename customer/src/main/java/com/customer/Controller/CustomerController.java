package com.customer.Controller;

import com.customer.entity.Customer;
import com.customer.entity.Medicine;
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

    @GetMapping("/home")
    public String home(){
        return "Home";
    }
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/getAllCustomer")
    public List<Customer> getAllCustomer() {
        List<Customer> cust=customerService.getCustomer();
        for (Customer c : cust) {
            List<Medicine> medicines = this.restTemplate.exchange(
                    "http://medicine-service/medicine/customer/{customerId}",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Medicine>>() {},
                    c.getId()
            ).getBody();
            c.setMedicine(medicines);
        }

        return cust;
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
         Customer cus = customerService.getCustomerById(id).get();
         List medicines = this.restTemplate.getForObject("http://medicine-service/medicine/customer/"+id,List.class);
         cus.setMedicine(medicines);
         return cus;
    }

    /**
     * Inserts a new customer into the CustomerRepository.
     * @param obj The Customer entity to be inserted.
     * @return the saved Customer object.
     */
    @CrossOrigin("http://localhost:4200")
    @PostMapping("/insertCustomer")
    public Customer insertCustomer(@Valid @RequestBody Customer obj) {
        System.out.println("Received data : " + obj);
        return customerService.addCustomer(obj);
    }

    /**
     * Updates an existing Customer record in the database.
     * @param obj the Customer object to be updated, containing new values
     * @return the updated Customer object after saving to the database
     * @throws ChangeSetPersister.NotFoundException if the customer with the specified ID does not exist in the database
     * @throws Exception if there is an error while updating the customer record in the database
     */
    @CrossOrigin("http://localhost:4200")
    @PutMapping(path="/updateCustomer")
    public String updateCustomer(@Valid @RequestBody Customer obj) throws Exception {
        Optional<Customer> cus = customerRepository.findById(obj.getId());

        if (cus.isEmpty()) {
            throw new ChangeSetPersister.NotFoundException();
        }
        Customer cusUpd = cus.get();
        cusUpd.setFirstName(obj.getFirstName());
        cusUpd.setLastName(obj.getLastName());
        cusUpd.setContact(obj.getContact());
        cusUpd.setEmail(obj.getEmail());
        cusUpd.setMedicine(obj.getMedicine());
        cusUpd.setDob(obj.getDob());
        return customerService.updateCustomer(obj);

    }

    /**
     * Deletes a customer from the CustomerRepository based on the provided id.
     * @param id The id of the customer to be deleted.
     * @return A string confirming that the record was successfully deleted.
     */
    @CrossOrigin("http://localhost:4200")
    @DeleteMapping (path="/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        System.out.println("Customer record deleted. Given id : " + id);
        customerService.deleteCustomer(id);
        return "Record Deleted Successfully";
    }

    /**
     * Retrieves a list of CustomerMedicine entities from the CustomerRepository.
     * @return A list of CustomerMedicine object containing the details of Customers along with the Medicines they have purchased.
     */
//    @CrossOrigin("http://localhost:4200")
//    @GetMapping(path="/getMedicineWithCustomer")
//    public List<CustomerMedicine> getMedicineWithCustomer() {
//        List<CustomerMedicine> cus = customerRepo.getMedicineWithCustomer();
//        System.out.println("Get list of all CustomerMedicine successfully");
//        return cus;
//    }
}

