package com.springboot.data_jpa.repository;

import com.springboot.data_jpa.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
    @Query(
            value = "SELECT * FROM passport WHERE date_Of_Issue IS NOT NULL", nativeQuery = true
    )
    public List<Passport> findAllPassportWithDateOfIssue();
}
