package com.example.demoo.service;

import com.example.demoo.entity.Customer;
import com.example.demoo.entity.Supplier;

import java.util.List;
import java.util.Optional;

// __________________________________________________________________________________________________________
public interface CustomerServiceInterface {
    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(int id);

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void updateCustomerPartially(Customer customer);

    void deleteCustomer(int id);
}
