package com.springboot.data_jpa.dto;

import com.springboot.data_jpa.entity.Passport;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
