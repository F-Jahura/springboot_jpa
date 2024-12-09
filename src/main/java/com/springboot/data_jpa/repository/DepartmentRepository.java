package com.springboot.data_jpa.repository;

import com.springboot.data_jpa.entity.Department;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
