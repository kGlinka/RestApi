package com.example.springbootapi.controller;

import com.example.springbootapi.repository.CustomerRepository;
import com.example.springbootapi.model.Customer;
import com.example.springbootapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;




    @GetMapping("")
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int customer_id) {
        return customerService.getCustomerById(customer_id);
    }

    @PostMapping("")
    public int add(@RequestBody List<Customer> customers) {
        return customerService.saveCustomers(customers);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") int id, @RequestBody Customer updatedCustomer) {
        Customer customer = customerRepository.getByCustomerId(id);

        if (customer != null) {
           customer.setName(updatedCustomer.getName());
           customer.setTelNumber(updatedCustomer.getTelNumber());

           customerRepository.update(customer);

           return 1;
        }else{
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") int customer_id, @RequestBody Customer updatedCustomer){
       Customer customer = customerRepository.getByCustomerId(customer_id);

       if (customer != null) {
           if (updatedCustomer.getName() != null) customer.setName(updatedCustomer.getName());
           if (updatedCustomer.getTelNumber() != null) customer.setTelNumber(updatedCustomer.getTelNumber());
           customerRepository.update(customer);
           return 1;
       }else{
           return -1;
       }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") int customer_id) {
        return customerService.deleteCustomer(customer_id);
    }


}
