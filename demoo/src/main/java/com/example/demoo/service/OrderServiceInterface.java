package com.example.demoo.service;

import com.example.demoo.entity.OrderDTO;
import com.example.demoo.entity.Orderr;
import java.util.List;
// __________________________________________________________________________________________________________
public interface OrderServiceInterface {
    List<OrderDTO> getAllOrders();

    OrderDTO getOrderById(int id);

    void addOrder(OrderDTO orderDTO);

    void updateOrder(OrderDTO orderDTO);

    void updateOrderPartially(OrderDTO orderDTO);

    void deleteOrder(int id);
}
