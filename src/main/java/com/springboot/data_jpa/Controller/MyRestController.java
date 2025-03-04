package com.springboot.data_jpa.Controller;

import com.springboot.data_jpa.Converter.Converter;
import com.springboot.data_jpa.dto.*;
import com.springboot.data_jpa.entity.*;
import com.springboot.data_jpa.exception_handling.PersonException;
import com.springboot.data_jpa.repository.*;
import com.springboot.data_jpa.service.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@Validated
@RestController
@Slf4j
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

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private OrderService orderService;

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

//find person by name and age
@GetMapping("/person/name-age")
    public List<Person> personNameAge(@RequestParam String name, @RequestParam LocalDate birthday){
        return personService.findAllByNameAndBirthday(name, birthday);
    }

//find person by age
@GetMapping("/person/get-age")
    public List<Person> showPersonByAge(@RequestParam LocalDate birthday){
        List<Person> personList = personService.findAllByBirthday(birthday);
    //System.out.println(personList);
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
        //emailService.sendSimpleMailGet();
        throw new PersonException("There is no person with id = " +
                id + " in Database.");
    }
    return person;
}

@GetMapping("/find-name/{name}")
public Person getPersonName(@PathVariable String name, HttpServletRequest request){
        Person person = personService.findByName(name);
    if (person == null) {
        //emailService.sendSimpleMailGet();
        throw new PersonException("There is no person with name = " +
                name + " in Database.");
    }
        return person;
}


//find person-passport-department details by name
@GetMapping("/person-passport/by-name")
public List<PersonDto> showAllDetailsByName(@RequestParam String name) {
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

//add list of new person with passport details0.

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

//update department (in postman: do not use third bracket for whole group as shown in "get-department" but use third bracket for "line" as shown in "get-department")
@PutMapping("/update-department")
public Department updateDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return department;
}

//get department list
@GetMapping("/get-department")
public List<Department> showAllDepartment(){
    List<Department> listDepartment = departmentService.getAllDepartment();
    System.out.println(departmentRepository.count());
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


//adding department_id in people table by id
@PostMapping("/add/department/in-person")
public UpdatePersonDepartmentRequest saveDepartment(@RequestBody UpdatePersonDepartmentRequest request){
        personService.updateDepartment(request);
        return request;
}

@GetMapping("/add/department/in-person-query")
public void saveDepartmentID(@RequestParam Integer id, @RequestParam Integer department_id){
      personRepository.updateDepartmentByQuery(id,department_id);
}


//get sum square from department_production_line by department_id
@GetMapping("/get-sum-square/{depID}")
public Integer getSumSquare(@PathVariable int depID){
        int sumSquare = departmentRepository.selectTotals(depID);
    //int sumSquare = departmentRepository.selectTotals();

    return sumSquare;
}

@PostMapping("/person-validation")
public ResponseEntity<PersonValidation> validPerson(@Valid @RequestBody PersonValidation personValidation){
        personService.savePerson(personValidation.toPerson());
        return new ResponseEntity<>(personValidation, HttpStatus.CREATED);
}
//Client_Order part start
@PostMapping("/add-client")
public Client addNewClient(@RequestBody Client client){
        clientService.saveClient(client);
        return client;
}

@GetMapping("/find-client/{id}")
public Client getClientById(@PathVariable int id) {
    Client client = clientService.getClient(id);
    if (client == null) {
       throw new PersonException("There is no client with id = " +
       id + " in Database.");
    }

    return client;
}

@PutMapping("/update-client")
public Client updateClientDto(@RequestBody Client client){
    clientService.saveClient(client);
    return client;
 }

 @GetMapping("/get-client")
 public List<Client> showAllClient() {
     List<Client> allClient = clientService.getAllClient();
     return allClient;
 }


/*@GetMapping("/get-client")
public List<ClientDto> showAllClient(){
    List<Client> allClient = clientService.getAllClient();
    return converter.clientToClientDto(allClient);
    }

 @PostMapping("/add-OrderDtoID")
public ResponseEntity<ClientDto> addClientDto(@RequestBody ClientDto clientDto){
        clientService.saveClient(clientDto.toClient());
        return new ResponseEntity<>(clientDto, HttpStatus.CREATED);
}
 */

@DeleteMapping("/delete-client/{id}")
public String deleteClient(@PathVariable int id){
    clientService.deleteClient(id);
    return "Client with ID = " + id + " was deleted";
}

@PostMapping("/add-order")
public Order addNewOrder(@RequestBody Order order){
        orderService.saveOrder(order);
        return order;
}
@PostMapping("/add-client/in-order")
public UpdateClientOrder saveCLient(@RequestBody UpdateClientOrder clientOrder){
    orderService.updateOrder(clientOrder);
    return clientOrder;
}

@GetMapping("/find-order/{id}")
public Order getOrder(@PathVariable int id) {
    Order order = orderService.getOrder(id);
    if (order == null) {
       throw new PersonException("There is no order with id = " +
       id + " in Database.");
        }
    return order;
}
@PutMapping("/update-order")
public Order updateOrder(@RequestBody Order order){
    orderService.saveOrder(order);
    return order;
}

@GetMapping("/find-client-order/{id}")
public ClientDto getClientDtoById(@PathVariable int id) {
    Client client = clientService.getClient(id);
    if (client == null) {
        throw new PersonException("There is no client with id = " +
                id + " in Database.");
    }

    return converter.clientToClientDto(client);
}

@GetMapping("/get-order")
public List<Order> showAllOrder(){
    List<Order> allOrder = orderService.getAllOrder();
    return allOrder;
}

@DeleteMapping("/delete-order/{id}")
public String deleteOrder(@PathVariable int id){
    orderService.deleteOrder(id);
    return "Order with ID = " + id + " was deleted";
}

//Client-Order part end

    public void findAgeExample(){
        List<Person> findAgeOver30 = personRepository.findAllPersonOver30();
        System.out.println(findAgeOver30);
    }

    //write email body, subject and to whom in json
    @PostMapping("/sendMail")
    public String sendEmail(@RequestBody EmailDetails details){
        String status = emailService.sendSimpleMail(details);
        return status;
    }

    //email body, subject and to whom is ready. Just need to send.
    @GetMapping("/sendMailGet")
    public void sendEmailGet(){
        emailService.sendSimpleMailGet();
    }

    /*@GetMapping("/logback")
    public String index(){
        log.trace("A trace message");
        log.debug("A debug message");
        log.info("An info message");
        log.warn("A warn message");
        log.error("An error message");
        return "Howdy, check out the logs to get output....";
    }*/


    //////////////////////////////////////////////////////
    /*@GetMapping("/find-department/details/{id}")
    public DepartmentDto1 showDetailsById(@PathVariable int id){
        Department department = departmentService.getDepartment(id);
        if (department == null) {
            throw new PersonException("There is no department with id = " +
                    id + " in Database");
        }
        //return departmentDto_1;
        return converter.entityDepToDto_1(department);
    }

    @PostMapping("/add-department/in-person")
    public DepartmentDto1 save(@RequestBody DepartmentDto1 dto_1, PersonDto1 personDto_1){
        Department department = converter.dto_1DepToEntity(dto_1);
        Person person = converter.dtoPerToEntity_1(personDto_1);
        department.addPersonToDepartment(person);
        person.setDepartment(department);
        department = departmentService.saveDepartment(department);


        return converter.entityDepToDto_1(department);
    }*/

    ////////////////////////////////////////////////////


}

