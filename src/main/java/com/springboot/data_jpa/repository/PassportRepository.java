package com.springboot.data_jpa.repository;

import com.springboot.data_jpa.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
}
