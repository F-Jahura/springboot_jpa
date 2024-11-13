package com.springboot.data_jpa.service;

import com.springboot.data_jpa.entity.Person;

import java.util.List;

public interface PersonService {
    public List<Person> getAllPeople();

    public List<Person> findAllByName(String name);
    public void savePerson(Person person);
    public void deletePerson(int id);
    //public Person getPerson(int id);

}

