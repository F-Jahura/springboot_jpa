package com.springboot.data_jpa.repository;

import com.springboot.data_jpa.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
