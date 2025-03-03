package com.springboot.data_jpa.dto;


import com.springboot.data_jpa.entity.Order;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Data
public class OrderDto {
    private int orderNumber;
    private LocalDate creationDate;
    private String description;
    private int sum;

    public Order toOrder(OrderDto orderDto){
        Order order = new Order();
        order.setOrderNumber(orderDto.getOrderNumber());
        order.setCreationDate(orderDto.getCreationDate());
        order.setDescription(orderDto.getDescription());
        order.setSum(orderDto.getSum());
        return order;
    }

    public List<Order> toOrder(List<OrderDto> orderDtoList){
        return orderDtoList.stream().map(x -> toOrder(x)).collect(Collectors.toList());
    }
}
