package com.example.demoo.service;

import com.example.demoo.entity.*;
import com.example.demoo.repository.CustomerRepository;
import com.example.demoo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// __________________________________________________________________________________________________________
@Service
public class OrderService implements OrderServiceInterface{
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }
    // ______________________________________________________________________________________________________
    @Override
    public List<OrderDTO> getAllOrders() {
        List<Orderr> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();

        for (Orderr order : orders) {
            OrderDTO o = new OrderDTO();
            o.setId(order.getId());
            o.setOrder_date(order.getOrder_date());
            o.setTotalCost(order.getTotalCost());
            o.setOrder_status(order.getOrder_status());
            o.setCustomer_id(order.getCustomer().getId());
            orderDTOs.add(o);
        }

        return orderDTOs;
    }
    // ______________________________________________________________________________________________________
    @Override
    public OrderDTO getOrderById(int id) {
        List<Orderr> orders = orderRepository.findAll();

        for(Orderr order : orders){
            if(order.getId() == id) {
                OrderDTO o = new OrderDTO();
                o.setId(order.getId());
                o.setOrder_date(order.getOrder_date());
                o.setTotalCost(order.getTotalCost());
                o.setOrder_status(order.getOrder_status());
                o.setCustomer_id(order.getCustomer().getId());
                return o;
            }
        }
        throw new RuntimeException("Sorry, this order doesn't found");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void addOrder(OrderDTO orderDTO) {
        orderDTO.setId(orderRepository.findTopByOrderByIdDesc().getId() + 1);

        Orderr newOrder = new Orderr();
        newOrder.setId(orderDTO.getId());
        newOrder.setOrder_date(orderDTO.getOrder_date());
        newOrder.setTotalCost(orderDTO.getTotalCost());
        newOrder.setOrder_status(orderDTO.getOrder_status());

        Customer customer = customerRepository.findById(orderDTO.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("The customer of this order isn't found"));

        newOrder.setCustomer(customer);
        orderRepository.save(newOrder);
    }
    // ______________________________________________________________________________________________________
    @Override
    public void updateOrder(OrderDTO orderDTO) {
        Optional<Orderr> orders = orderRepository.findById(orderDTO.getId());

        if (orders.isPresent()) {
            Orderr order = orders.get();
            order.setOrder_date(orderDTO.getOrder_date());
            order.setTotalCost(orderDTO.getTotalCost());
            order.setOrder_status(orderDTO.getOrder_status());

            Optional<Customer> customers = customerRepository.findById(orderDTO.getCustomer_id());
            if (customers.isPresent()) {
                order.setCustomer(customers.get());
                orderRepository.save(order);
            }
            else
                throw new RuntimeException("Invalid customer for this order");
        }
        else
            throw new RuntimeException("Sorry, this order doesn't exist");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void updateOrderPartially(OrderDTO orderDTO) {
        Optional<Orderr> orders = orderRepository.findById(orderDTO.getId());

        if (orders.isPresent()) {
            Orderr order = orders.get();
            if(orderDTO.getOrder_date() != null)
                order.setOrder_date(orderDTO.getOrder_date());
            if(orderDTO.getTotalCost() != 0)
                order.setTotalCost(orderDTO.getTotalCost());
            if(orderDTO.getOrder_status() != null)
                order.setOrder_status(orderDTO.getOrder_status());

            if(orderDTO.getCustomer_id() != 0) {
                Optional<Customer> customers = customerRepository.findById(orderDTO.getCustomer_id());
                if (customers.isPresent())
                    order.setCustomer(customers.get());
                else
                    throw new RuntimeException("Invalid customer for this order");
            }
            orderRepository.save(order);
        }
        else
            throw new RuntimeException("Sorry, this order doesn't exist");
    }
    // ______________________________________________________________________________________________________
    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
