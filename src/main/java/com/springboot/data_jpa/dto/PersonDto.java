package com.springboot.data_jpa.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PersonDto {
    private Integer id;

    private String name;

    private int age;

    private String surname;
}
