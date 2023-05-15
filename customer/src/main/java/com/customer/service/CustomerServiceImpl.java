package com.customer.service;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepo;
    @Override
    public String addCustomer(Customer customer){
        customerRepo.save(customer);
        return "CustomerMedicine added";
    }
    public String deleteCustomer(int id){
        Customer customer=customerRepo.getById(id);
        customerRepo.delete(customer);
        return "Customer deleted "+id;
    }
    public String updateCustomer(Customer customer){
        customerRepo.save(customer);
        return "customer Updated";
    }
    public List<Customer> getCustomer(){
        List<Customer> customers=customerRepo.findAll();
        return customers;
    }

    @Override
    public Optional<Customer> getCustomerById(int id) {
        Optional<Customer> cust =customerRepo.findById(id);
        return cust;
    }

}
