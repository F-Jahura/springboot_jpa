package com.springboot.data_jpa.dto;

import lombok.Data;

@Data
public class PersonDto {
    private String name;
    private String surname;
    private String patronymic;
    private int age;
    //private Passport passport;
    private PassportDto passportDto;

}
