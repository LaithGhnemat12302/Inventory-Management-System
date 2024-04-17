package com.example.demoo.service;

import com.example.demoo.entity.Order;
import java.util.List;
// __________________________________________________________________________________________________________
public interface OrderServiceInterface {
    List<Order> getAllOrders();

    Order getOrderById(long id);

    void addOrder(Order order);

    void updateOrder(Order order);

    void deleteOrder(long id);
}
