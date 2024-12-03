package com.springboot.data_jpa.repository;

import com.springboot.data_jpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    public Person findByName(String name);
    public List<Person> findAllByName(String name);
    public List<Person> findAllByNameAndAge(String name, Integer age);
    public List<Person> findAllByAge(Integer age);

    @Query(
            value = "SELECT * FROM people p WHERE p.age >= 30",
            nativeQuery = true)
    public List<Person> findAllPersonOver30();

}
