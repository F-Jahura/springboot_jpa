package com.springboot.data_jpa.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonDto {
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    //private Passport passport;
    private PassportDto passportDto;

}
