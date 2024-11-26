package com.springboot.data_jpa.service;

import com.springboot.data_jpa.entity.Person;
import com.springboot.data_jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    //List of all people
    @Override
    public List<Person> getAllPeople()
    {
        return personRepository.findAll();
    }

    //find person by name
    @Override
    public List<Person> findAllByName(String name) {
        return personRepository.findAllByName(name);
    }

    //add new person or update person
    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    //delete person
    @Override
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    //find person by age
    @Override
    public List<Person> findAllByAge(Integer age) {
        return personRepository.findAllByAge(age);
    }

    //find person by name and age
    @Override
    public List<Person> findAllByNameAndAge(String name, Integer age) {
        return personRepository.findAllByNameAndAge(name, age);
    }

    //find person by id
    @Override
    public Person getPerson(int id) {
        Person person = null;
        Optional<Person> optional = personRepository.findById(id);
        if (optional.isPresent()){
            person = optional.get();

        }
        else System.out.println("ID is not found.");
        return person;
    }

    @Override
    public Person findByName(String name) {
        return personRepository.findByName(name);
    }
}
