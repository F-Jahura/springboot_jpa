package com.springboot.data_jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name = "surname")
    private String surname;

    @Column(name = "creation_date")
    private LocalDate creation_date;

    @Column(name = "password")
    private String password;

    @Column(name = "passport")
    private String passport;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;
}