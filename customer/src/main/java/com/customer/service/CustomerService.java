package com.customer.service;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository dao;
    public String addCustomer(Customer customer){
        dao.save(customer);
        return "Customer added";
    }
    public String deleteCustomer(int id){
        Customer customer=dao.getById(id);
        dao.delete(customer);
        return "Customer deleted "+id;
    }
//    public CustomerEntity updateCustomer(CustomerEntity customer){
//        dao.save(customer);
//        return customer;
//    }

    public Customer updateCustomer(Customer obj) {
        Optional<Customer> cus = dao.findById(obj.getCustomerId());

        Customer updatedObj = cus.get();
        updatedObj.setCustomerName(obj.getCustomerName());
        updatedObj.setContact(obj.getContact());
        updatedObj.setBuyingDate(obj.getBuyingDate());
        updatedObj.setPrice(obj.getPrice());
        updatedObj.setQuantity(obj.getQuantity());
        updatedObj.setMedicineId(obj.getMedicineId());
        updatedObj.setMedicineName(obj.getMedicineName());
        Customer medicine1 = dao.save(updatedObj);
        return medicine1;
    }
    public  List<Customer> getCustomer(){
        List<Customer> customers=dao.findAll();
        return customers;
    }
}