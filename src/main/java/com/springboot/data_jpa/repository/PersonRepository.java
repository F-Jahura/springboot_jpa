package com.springboot.data_jpa.repository;

import com.springboot.data_jpa.dto.UpdatePersonDepartmentRequest;
import com.springboot.data_jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    public Person findByName(String name);
    public List<Person> findAllByName(String name);
    public List<Person> findAllByNameAndBirthday(String name, LocalDate birthday);
    public List<Person> findAllByBirthday(LocalDate birthday);

    @Query(
            value = "SELECT * FROM people p WHERE p.age >= 30",
            nativeQuery = true)
    public List<Person> findAllPersonOver30();

    @Transactional
    @Modifying
    @Query(
            value = "UPDATE people SET people.department_id = :department_id WHERE people.id = :id",
            nativeQuery = true)
    public void updateDepartmentByQuery(@Param("id") Integer id, @Param("department_id") Integer department_id);


}
