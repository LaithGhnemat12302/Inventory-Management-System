package com.example.demoo.service;

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
    public Customer getCustomerById(long id) {
        Optional<Customer> customers = customerRepository.findById(id);
        if(customers.isPresent())
            return customers.get();
        else
            throw new RuntimeException("Sorry, this customer doesn't found");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void addCustomer(Customer newCustomer) {
        Optional<Customer> customers = customerRepository.findById(newCustomer.getId());
        if (customers.isPresent())
            throw new RuntimeException("Sorry, the customer with this id already exists");
        else
            customerRepository.save(newCustomer);
    }
    // ______________________________________________________________________________________________________
//     @Override
//     public void updateCustomer(Customer updatedCustomer) {
//        Optional<Customer> customers = customerRepository.findById(updatedCustomer.getId());
//
//        if (customers.isPresent()) {
//            Customer customer = customers.get();
//
//            customer.setName(updatedCustomer.getName());
//            customer.setEmail(updatedCustomer.getEmail());
//            customer.setAddress(updatedCustomer.getAddress());
//            customer.setPhone(updatedCustomer.getPhone());
//
//            customerRepository.save(customer);
//        }
//        else
//            throw new RuntimeException("Sorry, this customer doesn't exist");
//    }

//	public void updateCustomer(Long customerId, String customerName, String email, String address, String phone) {
//		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new IllegalStateException(
//			"customer with id" + customerId + "does Not exist"
//		));
//
//		if (customer != null){
//			if(!customerName.isEmpty() && !Objects.equals(customer.getName(), customerName) ){
//				product.setProductName(productName);
//			}
//			if(!description.isEmpty() && !Objects.equals(product.getDescription(),description) ){
//				product.setDescription(description);
//			}
//			if(!price.isNaN() && !Objects.equals(product.getPrice(),price) ){
//				product.setPrice(price);
//			}
//			if(!productCategory.isEmpty() && !Objects.equals(product.getProductCategory(),productCategory) ){
//				product.setProductCategory(productCategory);
//			}
//		}

	@Override
	public void updateCustomer(Customer updatedCustomer) {
		Optional<Customer> existingCustomerOptional = customerRepository.findById(updatedCustomer.getId());

		if (existingCustomerOptional.isPresent()) {
			Customer existingCustomer = existingCustomerOptional.get();

			existingCustomer.setName(updatedCustomer.getName());
			existingCustomer.setEmail(updatedCustomer.getEmail());
			existingCustomer.setAddress(updatedCustomer.getAddress());
			existingCustomer.setPhone(updatedCustomer.getPhone());

			customerRepository.save(existingCustomer);
		} else {
			throw new RuntimeException("Sorry, this customer doesn't exist");
		}
	}
	// ______________________________________________________________________________________________________
    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }
}
