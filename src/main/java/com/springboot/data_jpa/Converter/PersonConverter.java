package com.springboot.data_jpa.Converter;

import com.springboot.data_jpa.dto.PersonDto;
import com.springboot.data_jpa.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonConverter {
    public PersonDto entityToDto(Person person){
        PersonDto dto = new PersonDto();
        dto.setId(person.getId());
        dto.setName(person.getName());
        dto.setAge(person.getAge());
        dto.setSurname(person.getSurname());
        return dto;
    }
    public List<PersonDto> entityToDto(List<Person> person){
        return person.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public Person dtoToEntity(PersonDto dto){
        Person per = new Person();
        per.setId(dto.getId());
        per.setName(dto.getName());
        per.setAge(dto.getAge());
        per.setSurname(dto.getSurname());
        return per;
    }

    public List<Person> dtoToEntity(List<PersonDto> dto){
        return dto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
