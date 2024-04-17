package com.example.demoo.service;

import com.example.demoo.entity.Customer;
import java.util.List;
// __________________________________________________________________________________________________________
public interface CustomerServiceInterface {
    List<Customer> getAllCustomers();

    Customer getCustomerById(long id);

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(long id);
}
