package com.springboot.data_jpa.Converter;

import com.springboot.data_jpa.dto.PassportDto;
import com.springboot.data_jpa.dto.PersonDto;
import com.springboot.data_jpa.entity.Passport;
import com.springboot.data_jpa.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonConverter {

    public PassportDto entityToPassportDto(Passport passport){
        PassportDto dtoPassport = new PassportDto();
        dtoPassport.setSeries(passport.getSeries());
        dtoPassport.setNumber(passport.getNumber());
        dtoPassport.setDate_Of_Issue(passport.getDate_Of_Issue());
        return dtoPassport;
    }
    public PersonDto entityToDto(Person person){
        PersonDto dto = new PersonDto();
        dto.setName(person.getName());
        dto.setSurname(person.getSurname());
        dto.setPatronymic(person.getPatronymic());
        dto.setAge(person.getAge());
        dto.setPassportDto(entityToPassportDto(person.getPassport()));
        return dto;
    }
    public List<PersonDto> entityToDto(List<Person> person){
        return person.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }


    public Passport passportDtoToEntity(PassportDto passportDto){
        Passport passport = new Passport();
        passport.setSeries(passportDto.getSeries());
        passport.setNumber(passportDto.getNumber());
        passport.setDate_Of_Issue(passportDto.getDate_Of_Issue());
        return passport;
    }
    public Person dtoToEntity(PersonDto dto){
        Person per = new Person();
        per.setName(dto.getName());
        per.setSurname(dto.getSurname());
        per.setPatronymic(dto.getPatronymic());
        per.setAge(dto.getAge());
        per.setPassport(passportDtoToEntity(dto.getPassportDto()));
        return per;
    }

    public List<Person> dtoToEntity(List<PersonDto> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
