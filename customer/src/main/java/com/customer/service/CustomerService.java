package com.customer.service;

import com.customer.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService{
    public Customer addCustomer(Customer customer);
    public String deleteCustomer(int id);
    public String updateCustomer(Customer customer);
    public List<Customer> getCustomer();

    Optional<Customer> getCustomerById(int id);
}
