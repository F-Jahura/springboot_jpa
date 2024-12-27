package com.springboot.data_jpa.service;

import com.springboot.data_jpa.Converter.Converter;
import com.springboot.data_jpa.dto.UpdatePersonDepartmentRequest;
import com.springboot.data_jpa.entity.Department;
import com.springboot.data_jpa.entity.Person;
import com.springboot.data_jpa.repository.DepartmentRepository;
import com.springboot.data_jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private Converter converter;

    //List of all people
    @Override
    public List<Person> getAllPeople()
    {
        return repository.findAll();
    }

    //find person by name
    @Override
    public List<Person> findAllByName(String name) {
        return repository.findAllByName(name);
    }

    //add new person or update person
    @Override
    public void savePerson(Person person) {
        repository.save(person);
    }



    //delete person
    @Override
    public void deletePerson(int id) {
        repository.deleteById(id);
    }

    //find person by age
    @Override
    public List<Person> findAllByBirthday(LocalDate birhtday) {
        return repository.findAllByBirthday(birhtday);
    }

    //find person by name and age
    @Override
    public List<Person> findAllByNameAndBirthday(String name, LocalDate birthday) {
        return repository.findAllByNameAndBirthday(name, birthday);
    }

    //find person by id
    @Override
    public Person getPerson(int id) {
        Person person = null;
        Optional<Person> optional = repository.findById(id);
        if (optional.isPresent()){
            person = optional.get();

        }
        else System.out.println("ID is not found.");
        return person;
    }

    @Override
    public Person findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Person> savePersonList(List<Person> person) {
        return repository.saveAll(person);
    }

    @Override
    public void updateDepartment(UpdatePersonDepartmentRequest updatePersonDepartmentRequest) {
        Person person = null;
        Optional<Person> optional = repository.findById(updatePersonDepartmentRequest.getPersonID());
        person = optional.get();
        Department department = null;
        Optional<Department> optional1 = departmentRepository.findById(updatePersonDepartmentRequest.getDepartmentID());
        department = optional1.get();
        person.setDepartment(department);
        repository.save(person);
    }

    @Override
    public void updateDepartment1(int personID, int DepartmentID){

    }

}

