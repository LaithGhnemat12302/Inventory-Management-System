package com.example.demoo.controller;

import com.example.demoo.entity.OrderDTO;
import com.example.demoo.entity.Orderr;
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
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }
    // ______________________________________________________________________________________________________
    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }
    // ______________________________________________________________________________________________________
    @PostMapping("/addOrder")
    public void addOrder(@RequestBody OrderDTO orderDTO) {
        orderService.addOrder(orderDTO);
    }
    // ______________________________________________________________________________________________________
    @PutMapping("/updateOrder/{id}")
    public void updateOrder(@PathVariable int id, @RequestBody OrderDTO orderDTO) {
        orderDTO.setId(id);
        orderService.updateOrder(orderDTO);
    }
    // ______________________________________________________________________________________________________
    @PatchMapping("/updateOrder/{id}")
    public void updateOrderPartially(@PathVariable int id, @RequestBody OrderDTO orderDTO) {
        orderDTO.setId(id);
        orderService.updateOrderPartially(orderDTO);
    }
    // ______________________________________________________________________________________________________
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }
}
