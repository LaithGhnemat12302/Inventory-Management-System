package com.example.demoo.service;

import com.example.demoo.entity.Supplier;
import com.example.demoo.repository.CustomerRepository;
import com.example.demoo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// __________________________________________________________________________________________________________
@Service
public class CustomerService implements CustomerServiceInterface{
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    // ______________________________________________________________________________________________________
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    // ______________________________________________________________________________________________________
    @Override
    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.findById(id);
    }
    // ______________________________________________________________________________________________________
    @Override
    public void addCustomer(Customer newCustomer) {
        customerRepository.save(newCustomer);
    }
    // ______________________________________________________________________________________________________
    // @Override
	public void updateCustomer(Customer updatedCustomer) {
		Optional<Customer> existingCustomerOptional = customerRepository.findById(updatedCustomer.getId());

		if (existingCustomerOptional.isPresent()) {
			Customer existingCustomer = existingCustomerOptional.get();

			existingCustomer.setName(updatedCustomer.getName());
			existingCustomer.setEmail(updatedCustomer.getEmail());
			existingCustomer.setAddress(updatedCustomer.getAddress());
			existingCustomer.setPhone(updatedCustomer.getPhone());
			customerRepository.save(existingCustomer);
		} else
			throw new RuntimeException("Sorry, this customer doesn't exist");
	}
	// ______________________________________________________________________________________________________
    @Override
    public void updateCustomerPartially(Customer updatedCustomer) {
        Optional<Customer> existingCustomerOptional = customerRepository.findById(updatedCustomer.getId());

        if (existingCustomerOptional.isPresent()) {
            Customer customer = existingCustomerOptional.get();

            if (updatedCustomer.getName() != null)
                customer.setName(updatedCustomer.getName());
            if (updatedCustomer.getEmail() != null)
                customer.setEmail(updatedCustomer.getEmail());
            if (updatedCustomer.getAddress() != null)
                customer.setAddress(updatedCustomer.getAddress());
            if (updatedCustomer.getPhone() != null)
                customer.setPhone(updatedCustomer.getPhone());
            customerRepository.save(customer);
        }
        else
            throw new RuntimeException("Sorry, this customer doesn't exist");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void deleteCustomer(int id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent())
            customerRepository.deleteById(id);
        else
            throw new ResourceNotFoundException("Customer not found with id: " + id);
    }
}
