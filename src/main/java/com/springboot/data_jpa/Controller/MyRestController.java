package com.springboot.data_jpa.Controller;

import com.springboot.data_jpa.entity.Person;
import com.springboot.data_jpa.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private PersonService personService;

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

//find person by id
/*
@GetMapping("/find-person/{id}")
public Person getPerson1(@PathVariable int id){
        Person person = personService.getPerson(id);
        return person;
    }

// add new person
@PostMapping("/add-person")
public Person addNedPerson(@RequestBody Person person){
        personService.savePerson(person);
        return person;
    }

 */

}
