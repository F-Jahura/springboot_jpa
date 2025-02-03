package com.springboot.data_jpa;

import com.springboot.data_jpa.Controller.MyRestController;
import com.springboot.data_jpa.dto.PersonDto;
import com.springboot.data_jpa.entity.Passport;
import com.springboot.data_jpa.entity.Person;
import com.springboot.data_jpa.repository.DepartmentRepository;
import com.springboot.data_jpa.repository.PassportRepository;
import com.springboot.data_jpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Formattable;
import java.util.List;

@Configuration
@EnableScheduling
@SpringBootApplication
public class DataJpaApplication {

	@Autowired
	PassportRepository passportRepository;
	@Autowired
	PersonRepository personRepository;



	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

	@Scheduled(fixedDelay = 10000)
	public void schedulePersonPatronymicRemindingTask(){
		System.out.println("\nPerson without patronymic: \n");
		for (Person person : personRepository.findAllPersonWithoutPatronymic()){
			System.out.println(person.toString() + System.currentTimeMillis() / 10000);
		}
	}

	/*@Bean
	public CommandLineRunner personDemo(){
		return (args) -> {
			System.out.println("\nNotes found with findAll: \n");

			for (Passport passport : passportRepository.findAllPassportWithDateOfIssue()){
				System.out.println(passport.toString());
			}

		};
	}*/

	/*@Scheduled(fixedDelay = 10000)
	public void scheduleFixedDelayTask(){
		System.out.println("\nPassport details: \n");
		for (Passport passport : passportRepository.findAllPassportWithDateOfIssue()){
			System.out.println(passport.toString() + System.currentTimeMillis() / 10000);
		}
		//System.out.println("Fixed delay task - " + personDemo().toString() + System.currentTimeMillis() / 1000);
	}*/



}
