package com.springboot.data_jpa.repository;

import com.springboot.data_jpa.entity.Person;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    public List<Person> findAllByName(String name);
}
