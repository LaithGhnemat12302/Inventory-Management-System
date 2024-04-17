package com.example.demoo.controller;

import com.example.demoo.entity.Customer;
import com.example.demoo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// __________________________________________________________________________________________________________
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    // ______________________________________________________________________________________________________
    @GetMapping("/")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    // ______________________________________________________________________________________________________
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable long id) {
        Customer customer = customerService.getCustomerById(id);
        if(customer == null)
            throw new RuntimeException("The customer with the id " + id + " doesn't exist");
        return customer;
    }
    // ______________________________________________________________________________________________________
    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }
    // ______________________________________________________________________________________________________
//    @PutMapping("/updateCustomer/{id}")
//    public void updateCustomer(@RequestBody Customer customer) {
//        customerService.updateCustomer(customer);
//    }

	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<Void> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
		customer.setId(id);
		customerService.updateCustomer(customer);
		return new ResponseEntity<>(HttpStatus.OK);
	}
    // ______________________________________________________________________________________________________
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
    }
}


