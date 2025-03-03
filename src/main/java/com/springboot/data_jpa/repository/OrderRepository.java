package com.springboot.data_jpa.repository;

import com.springboot.data_jpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>
{
}
