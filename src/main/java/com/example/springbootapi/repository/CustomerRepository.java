package com.example.springbootapi.repository;



import com.example.springbootapi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getAll() {
        return jdbcTemplate.query("SELECT customer_id, name, TelNumber FROM Customer",
                BeanPropertyRowMapper.newInstance(Customer.class));
    }

    public Customer getByCustomerId(int customer_id) {
        return jdbcTemplate.queryForObject("SELECT customer_id, name, TelNumber from customer where " +
                "customer_id = ?", BeanPropertyRowMapper.newInstance(Customer.class), customer_id);
    }

    public void save(Customer customer) {
         jdbcTemplate.update("INSERT INTO customer(customer.name, customer.TelNumber) VALUES(?, ?)",
                        customer.getName(), customer.getTelNumber());


    }

    public void save(List<Customer> customers) {
        customers.forEach(customer -> jdbcTemplate
                .update("INSERT INTO customer(customer.name, customer.TelNumber) VALUES(?, ?)",
                        customer.getName(), customer.getTelNumber()));


    }

    public int update(Customer customer) {
        return jdbcTemplate.update("UPDATE customer SET name=?, TelNumber=? WHERE customer_id=?",
                customer.getName(), customer.getTelNumber(), customer.getCustomer_id());
    }

    public int delete(int customer_id) {
        return jdbcTemplate.update("DELETE FROM customer WHERE customer_id=?", customer_id);
    }

}
