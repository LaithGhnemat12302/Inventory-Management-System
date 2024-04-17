package com.example.demoo.controller;

import com.example.demoo.entity.Order;
import com.example.demoo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// __________________________________________________________________________________________________________
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    // ______________________________________________________________________________________________________
    @GetMapping("/")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    // ______________________________________________________________________________________________________
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable long id) {
        Order order = orderService.getOrderById(id);
        if(order == null)
            throw new RuntimeException("The order with the id " + id + " doesn't exist");
        return order;
    }
    // ______________________________________________________________________________________________________
    @PostMapping("/")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
    }
    // ______________________________________________________________________________________________________
    @PutMapping("/")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
    }
    // ______________________________________________________________________________________________________
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable long id) {
        orderService.deleteOrder(id);
    }
}
