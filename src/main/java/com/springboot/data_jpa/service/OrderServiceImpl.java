package com.springboot.data_jpa.service;

import com.springboot.data_jpa.entity.Client;
import com.springboot.data_jpa.entity.Order;
import com.springboot.data_jpa.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order getOrder(int id) {
        Order order = null;
        Optional<Order> optional = orderRepository.findById(id);
        if (optional.isPresent()){
            order = optional.get();

        }
        else System.out.println("ID is not found.");
        return order;
    }

    @Override
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
