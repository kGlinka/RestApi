package com.example.springbootapi.service;

import com.example.springbootapi.model.Customer;
import com.example.springbootapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.getAll();
    }

    public Customer getCustomerById(int customerId) {
        return customerRepository.getByCustomerId(customerId);

    }


    public int saveCustomers(List<Customer> customers) {
        customerRepository.save(customers);
        return 0;
    }

    public int saveCustomers(Customer customers) {
        customerRepository.save(customers);
        return 0;
    }

    public void updateCustomer(Customer customer) {
        customerRepository.update(customer);
    }

    public int deleteCustomer(int customerId) {
        customerRepository.delete(customerId);
        return customerId;
    }
}
