package com.springboot.data_jpa.Controller;

import com.springboot.data_jpa.Converter.Converter;
import com.springboot.data_jpa.dto.DepartmentDto;
import com.springboot.data_jpa.dto.DepartmentDto_1;
import com.springboot.data_jpa.dto.PersonDto;
import com.springboot.data_jpa.dto.PersonDto_1;
import com.springboot.data_jpa.entity.Department;
import com.springboot.data_jpa.entity.Passport;
import com.springboot.data_jpa.entity.Person;
import com.springboot.data_jpa.exception_handling.PersonException;
import com.springboot.data_jpa.repository.PassportRepository;
import com.springboot.data_jpa.repository.PersonRepository;
import com.springboot.data_jpa.service.DepartmentService;
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
    Converter converter;

    @Autowired
    private PassportRepository passportRepository;

    @Autowired
    private DepartmentService departmentService;

    //@Autowired
    //private DepartmentDto_1Repository departmentDto_1Repository;


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
        //return converter.entityToDto(person);
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

//find person-passport-department by id
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


//find person-passport-department details by name
@GetMapping("/person-passport/by-name")
public List<PersonDto> showAllDetailsByName(@RequestParam String name){
    List<Person> personList = personRepository.findAllByName(name);
        return converter.entityToDto(personList);
    }

//add new passport
@PostMapping("/add-passport")
public Passport addNewPassport(@RequestBody Passport passport){
        passportService.savePassport(passport);
    return passport;
}

//add new passport
@PutMapping("/update-passport")
public Passport updatePassport(@RequestBody Passport passport){
    passportService.savePassport(passport);
    return passport;
}

//add list of new person with passport details
@PostMapping("/add/list/person-passport")
public List<Person> addPersonPassportList(@RequestBody List<Person> person){
    List<Person> personList = personService.savePersonList(person);
    //personService.savePerson(person);
    return personList;
    }


//update person with passport details
@PutMapping("/update/person-passport")
public Person updatePersonPassport(@RequestBody Person person){
    personService.savePerson(person);
    return person;
}


//add new department
@PostMapping("/add-department")
public Department addNewDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return department;
}

//update department
@PutMapping("/update-department")
public Department updateDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return department;
}

//get department list
@GetMapping("/get-department")
public List<Department> showAllDepartment(){
    List<Department> listDepartment = departmentService.getAllDepartment();
    return listDepartment;
}


//find person-passport-department details by department-id
@GetMapping("/find-department/full-details/{id}")
public DepartmentDto showAllDetailsById(@PathVariable int id){
        Department department = departmentService.getDepartment(id);
    if (department == null) {
        throw new PersonException("There is no department with id = " +
                id + " in Database");
    }
        return converter.departmentToDto(department);
}

//////////////////////////////////////////////////////
    @GetMapping("/find-department/details/{id}")
    public DepartmentDto_1 showDetailsById(@PathVariable int id){
        Department department = departmentService.getDepartment(id);
        if (department == null) {
            throw new PersonException("There is no department with id = " +
                    id + " in Database");
        }
        //return departmentDto_1;
        return converter.entityDepToDto_1(department);
    }

    @PostMapping("/add-department/in-person")
    public DepartmentDto_1 save(@RequestBody DepartmentDto_1 dto_1, PersonDto_1 personDto_1){
        Department department = converter.dto_1DepToEntity(dto_1);
        Person person = converter.dtoPerToEntity_1(personDto_1);
        department.addPersonToDepartment(person);
        person.setDepartment(department);
        department = departmentService.saveDepartment(department);


        return converter.entityDepToDto_1(department);
    }

    ////////////////////////////////////////////////////

    @PutMapping("/add-person-department")
    public Person addDepartmentID(@RequestParam Department department, Person person){
        //////////////////adding department_id in people table
        person.setDepartment(department);
        ////////////////////////////////////////////////
        personService.savePerson(person);
        departmentService.saveDepartment(department);

        return person;
    }

}

