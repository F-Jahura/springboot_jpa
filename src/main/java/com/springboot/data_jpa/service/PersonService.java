package com.springboot.data_jpa.service;

import com.springboot.data_jpa.dto.UpdatePersonDepartmentRequest;
import com.springboot.data_jpa.entity.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public interface PersonService {
    public List<Person> getAllPeople();

    public List<Person> findAllByName(String name);
    public void savePerson(Person person);
    public void deletePerson(int id);
    public List<Person> findAllByNameAndBirthday(String name, LocalDate birthday);
    public List<Person> findAllByBirthday(LocalDate birhtday);

    public Person getPerson(int id);
    public Person findByName(String name);
    public List<Person> findAllPersonOver30();

    public List<Person> savePersonList(List<Person> person);

    public void updateDepartment(UpdatePersonDepartmentRequest updatePersonDepartmentRequest);
    public void updateDepartment1(int personID, int DepartmentID);

    //public void countPersonList();



    //public void savePersonDto(PersonDto personDto);
}

