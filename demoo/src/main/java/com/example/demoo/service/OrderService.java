package com.example.demoo.service;

import com.example.demoo.entity.Customer;
import com.example.demoo.repository.CustomerRepository;
import com.example.demoo.repository.OrderRepository;
import com.example.demoo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
// __________________________________________________________________________________________________________
@Service
public class OrderService implements OrderServiceInterface{
    private final OrderRepository orderRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    // ______________________________________________________________________________________________________
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    // ______________________________________________________________________________________________________
    @Override
    public Order getOrderById(long id) {
        Optional<Order> orders = orderRepository.findById(id);
        if(orders.isPresent())
            return orders.get();
        else
            throw new RuntimeException("Sorry, this order doesn't found");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void addOrder(Order newOrder) {
        Optional<Order> orders = orderRepository.findById(newOrder.getId());
        if (orders.isPresent())
            throw new RuntimeException("Sorry, the order with this id already exists");
        else
            orderRepository.save(newOrder);
    }
    // ______________________________________________________________________________________________________
    @Override
    public void updateOrder(Order updatedOrder) {
        Optional<Order> orders = orderRepository.findById(updatedOrder.getId());

        if (orders.isPresent()) {
            Order order = orders.get();

            order.setDate(updatedOrder.getDate());
            order.setTotalCost(updatedOrder.getTotalCost());
            order.setStatus(updatedOrder.getStatus());

            Optional<Customer> customers = customerRepository.findById(updatedOrder.getCustomer().getId());
            if (customers.isPresent())
                order.setCustomer(customers.get());
            else
                throw new RuntimeException("Invalid customer id for this order");
            orderRepository.save(order);
        } else
            throw new RuntimeException("Sorry, this order doesn't exist");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }
}
