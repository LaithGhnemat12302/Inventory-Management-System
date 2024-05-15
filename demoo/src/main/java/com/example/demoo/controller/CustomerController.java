package com.example.demoo.controller;

import com.example.demoo.entity.Customer;
import com.example.demoo.entity.Supplier;
import com.example.demoo.service.CustomerService;
import com.example.demoo.service.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        if (customers.isEmpty())
            return ResponseEntity.notFound().build(); // Return 404 Not Found if no customers are found
        else
            return ResponseEntity.ok(customers); // Return 200 OK with the list of customers
    }
    // ______________________________________________________________________________________________________
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        if (customerOptional.isPresent())
            return ResponseEntity.ok(customerOptional.get()); // Return 200 OK with the customer if it exists
        else
            return ResponseEntity.notFound().build(); // Return 404 Not Found if the customer doesn't exist
    }
    // ______________________________________________________________________________________________________
    @PostMapping("/addCustomer")
    public ResponseEntity<Void> addCustomer(@Valid @RequestBody Customer customer) {
        if (customer.getName() != null && customer.getAddress() != null &&
                customer.getEmail() != null && customer.getPhone() != null){
            customerService.addCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).build(); // Return 201 for successfully created
        }
        else
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request for invalid request body
    }
    // ______________________________________________________________________________________________________
    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<Void> updateCustomer(@PathVariable int id, @Valid @RequestBody Customer customer){
        if (customer.getName() == null || customer.getAddress() == null ||
                customer.getEmail() == null || customer.getPhone() == null)
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request for invalid request body
        else {
            customer.setId(id);
            try {
                customerService.updateCustomer(customer);
                return ResponseEntity.ok().build(); // Return 200 OK for successfully updated
            } catch (RuntimeException e) {
                // Return 404 Not Found if the order with the given id does not exist
                return ResponseEntity.notFound().build();
            }
        }
    }
    // ______________________________________________________________________________________________________
//    @PatchMapping("/updateCustomer/{id}")
//    public ResponseEntity<Void> updateCustomerPartially(@PathVariable int id, @RequestBody Customer customer) {
//        customer.setId(id);
//        customerService.updateCustomerPartially(customer);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    @PatchMapping("/updateCustomer/{id}")
    public ResponseEntity<Void> updateCustomerPartially(@PathVariable int id,
                                      @Valid @RequestBody Customer customer, BindingResult result) {
        if (result.hasErrors())
            return ResponseEntity.badRequest().build(); // Return 400 Bad Request for invalid request body
        else {
            customer.setId(id);
            try {
                customerService.updateCustomerPartially(customer);
                return ResponseEntity.ok().build(); // Return 200 OK for successfully updated
            } catch (RuntimeException e) {
                // Return 404 Not Found if the customer with the given id does not exist
                return ResponseEntity.notFound().build();
            }
        }
    }
    // ______________________________________________________________________________________________________
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build(); // Return 204 No Content on successful deletion
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if Customer doesn't exist
        }
    }
}