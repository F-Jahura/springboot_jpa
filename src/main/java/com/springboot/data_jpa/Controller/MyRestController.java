package com.springboot.data_jpa.Controller;

import com.springboot.data_jpa.Converter.PersonConverter;
import com.springboot.data_jpa.dto.PersonDto;
import com.springboot.data_jpa.entity.Passport;
import com.springboot.data_jpa.entity.Person;
import com.springboot.data_jpa.exception_handling.PersonException;
import com.springboot.data_jpa.repository.PassportRepository;
import com.springboot.data_jpa.repository.PersonRepository;
import com.springboot.data_jpa.service.PassportService;
import com.springboot.data_jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private PersonService personService;
    @Autowired
    PassportService passportService;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    PersonConverter converter;

    @Autowired
    private PassportRepository passportRepository;


    //List of all people
    @GetMapping("/person")
    public List<Person> showAllPeople(){
        List<Person> allPeople = personService.getAllPeople();
        return allPeople;
}

//find person by name
@GetMapping("/person/get-name")
    //public Person getPerson(@RequestParam String name){
    public List<Person> showAllPersonByName(@RequestParam String name){
         List<Person> personList = personService.findAllByName(name);
         /*if (personList == null){
             throw new PersonException("There is no person with name = " +
                     name + " in Database");
         }*/
         return personList;
}


//update person
@PutMapping("/update-person")
    public Person updatePerson(@RequestBody Person person){
        personService.savePerson(person);
        return person;
}

//delete person
@DeleteMapping("/delete-person/{id}")
    public String deletePerson(@PathVariable int id){
        personService.deletePerson(id);
        return "Person with ID = " + id + " was deleted";
}

//find person by name and age
@GetMapping("/person/name-age")
    public List<Person> personNameAge(@RequestParam String name, @RequestParam Integer age){
        return personService.findAllByNameAndAge(name, age);
    }

//find person by age
@GetMapping("/person/get-age")
    public List<Person> showPersonByAge(@RequestParam Integer age){
        List<Person> personList = personService.findAllByAge(age);
        return personList;
}

//add new person
@PostMapping("/add-person")
    public Person addNewPerson(@RequestBody Person person){
        personService.savePerson(person);
        return person;
}

@GetMapping("/findall-dto")
    public List<PersonDto> findAllDto(){
       List<Person> findAll = personRepository.findAll();
       return converter.entityToDto(findAll);
}

@GetMapping("/age-over30")
    public List<PersonDto> findAge30(){
        List<Person> findAgeOver30 = personRepository.findAllPersonOver30();
        return converter.entityToDto(findAgeOver30);
}

//find person by id
@GetMapping("/find-person/{id}")
public Person getPerson1(@PathVariable int id) {
    Person person = personService.getPerson(id);
    if (person == null) {
        throw new PersonException("There is no person with id = " +
                id + " in Database");
    }
    return person;
}

@GetMapping("/find-name/{name}")
public Person getPersonName(@PathVariable String name){
        Person person = personService.findByName(name);
    if (person == null) {
        throw new PersonException("There is no person with name = " +
                name + " in Database");
    }
        return person;
}


//find person with passport details by name
@GetMapping("/person-passport/by-name")
public List<PersonDto> showAllDetailsByName(@RequestParam String name){
    List<Person> personList = personRepository.findAllByName(name);
        return converter.entityToDto(personList);
    }

//add new person-passport
@PostMapping("/add-passport")
public Passport addNewPassport(@RequestBody Passport passport){
        passportService.savePassport(passport);
    return passport;
}

//add new person with passport details
@PostMapping("/add-person-passport")
    public Person addPersonPassport(@RequestBody Person person){
        personService.savePerson(person);
        return person;
}

@PutMapping("/update-person-passport")
public Person updatePersonPassport(@RequestBody Person person){
    personService.savePerson(person);
    return person;
}

}
