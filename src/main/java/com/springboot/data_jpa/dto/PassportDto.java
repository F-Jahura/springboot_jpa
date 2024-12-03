package com.springboot.data_jpa.dto;

import com.springboot.data_jpa.entity.Person;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PassportDto {
    private String series;
    private String number;
    private LocalDate date_Of_Issue;
}
