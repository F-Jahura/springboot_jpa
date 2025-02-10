package com.springboot.data_jpa.repository;

import com.springboot.data_jpa.entity.Department;
import com.springboot.data_jpa.entity.Person;
import com.springboot.data_jpa.entity.ProductionLine;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(
            value = "SELECT COUNT(title) FROM department", nativeQuery = true)
    long count();

  //option 1
   @Query(
            value = "SELECT SUM(square) FROM department_production_line WHERE department_id=?1 GROUP BY department_id",
            nativeQuery = true)
    public int selectTotals(Integer depID);


    //option 2
    /*@Query(
            value = "SELECT SUM(square) FROM department_production_line WHERE department_id=:depID GROUP BY department_id", nativeQuery = true)
    public int selectTotals(@Param("depID") Integer depID);*/


}
