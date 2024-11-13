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
    @Override
    public List<Person> getAllPeople()
    {
        return personRepository.findAll();
    }

    @Override
    public List<Person> findAllByName(String name) {
        //List<Person> people = personRepository.findAllByName(name);
        return personRepository.findAllByName(name);
    }

    /*
    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

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
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

     */
}

