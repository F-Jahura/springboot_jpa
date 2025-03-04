package com.springboot.data_jpa.service;

import com.springboot.data_jpa.dto.UpdateClientOrder;
import com.springboot.data_jpa.dto.UpdatePersonDepartmentRequest;
import com.springboot.data_jpa.entity.Client;
import com.springboot.data_jpa.entity.Department;
import com.springboot.data_jpa.entity.Order;
import com.springboot.data_jpa.entity.Person;
import com.springboot.data_jpa.repository.ClientRepository;
import com.springboot.data_jpa.repository.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ClientRepository clientRepository;

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

    @Override
    public void updateOrder(UpdateClientOrder clientOrder) {
       Order order = null;
       Optional<Order> optional = orderRepository.findById(clientOrder.getOrderID());
       order = optional.get();
       Client client = null;
       Optional<Client> optional1 = clientRepository.findById(clientOrder.getClientID());
       client = optional1.get();
       order.setClient(client);
       orderRepository.save(order);
    }

}
