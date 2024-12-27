package com.springboot.data_jpa.Converter;

import com.springboot.data_jpa.dto.*;
import com.springboot.data_jpa.entity.Department;
import com.springboot.data_jpa.entity.Passport;
import com.springboot.data_jpa.entity.Person;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    public PassportDto entityToPassportDto(Passport passport){
        PassportDto dtoPassport = new PassportDto();
        dtoPassport.setSeries(passport.getSeries());
        dtoPassport.setNumber(passport.getNumber());
        dtoPassport.setDate_Of_Issue(passport.getDate_Of_Issue());
        return dtoPassport;
    }

    public Passport passportDtoToEntity(PassportDto passportDto){
        Passport passport = new Passport();
        passport.setSeries(passportDto.getSeries());
        passport.setNumber(passportDto.getNumber());
        passport.setDate_Of_Issue(passportDto.getDate_Of_Issue());
        return passport;
    }

    /////////////////////////////////////////////////////////////////////////
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

    /////////////////////////////////////////////////////////////////////////////////////

    public DepartmentDto departmentToDto(Department department){
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setTitle(department.getTitle());
        departmentDto.setBuilding_num(department.getBuildingNum());
        departmentDto.setStaffs_num(department.getStaffsNum());
        departmentDto.setPersonDtoList(entityToDto(department.getPersonlist()));
        return departmentDto;
    }

    public List<DepartmentDto> departmentToDto(List<Department> departments){
        return departments.stream().map(x -> departmentToDto(x)).collect(Collectors.toList());
    }


    ////////////////////////////////////////////////////////////////////////////

    /*public PersonDto1 entityPerToDto_1(Person person){
        PersonDto1 dto_1 = new PersonDto1();
        dto_1.setId(person.getId());
        return dto_1;
    }
    public List<PersonDto1> entityPerToDto_1(List<Person> person){
        return person.stream().map(x -> entityPerToDto_1(x)).collect(Collectors.toList());
    }


    public DepartmentDto1 entityDepToDto_1(Department department){
        DepartmentDto1 departmentDto_1 = new DepartmentDto1();
        departmentDto_1.setId(department.getId());
        departmentDto_1.setPersonDto_1List(entityPerToDto_1(department.getPersonlist()));
        return departmentDto_1;
    }

    public List<DepartmentDto1> entityDepToDto_1(List<Department> departments){
        return departments.stream().map(x -> entityDepToDto_1(x)).collect(Collectors.toList());
    }*/

    ////////////////////////////////////////////////////////////////////////////////////////
   /* public Person dtoPerToEntity_1(PersonDto1 personDto_1){
        Person person = new Person();
        person.setId(personDto_1.getId());
        return person;
    }
    public List<Person> dtoPerToEntity_1(List<PersonDto1> personDto_1List){
        return personDto_1List.stream().map(x -> dtoPerToEntity_1(x)).collect(Collectors.toList());
    }


    public Department dto_1DepToEntity(DepartmentDto1 departmentDto_1){
        Department department = new Department();
        department.setId(departmentDto_1.getId());
        department.setPersonlist(dtoPerToEntity_1(departmentDto_1.getPersonDto_1List()));
        return department;
    }

    public List<Department> dto_1DepToEntity(List<DepartmentDto1> departmentDto_1List){
        return departmentDto_1List.stream().map(x -> dto_1DepToEntity(x)).collect(Collectors.toList());
    }*/
}
