package com.springboot.data_jpa.service;

import com.springboot.data_jpa.dto.UpdateClientOrder;
import com.springboot.data_jpa.dto.UpdatePersonDepartmentRequest;
import com.springboot.data_jpa.entity.Client;
import com.springboot.data_jpa.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrder();
    public void saveOrder(Order order);

    public Order getOrder(int id);

    public void deleteOrder(int id);
    public void updateOrder(UpdateClientOrder clientOrder);
}
