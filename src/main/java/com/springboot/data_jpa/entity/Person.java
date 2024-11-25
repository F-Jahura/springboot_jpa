package com.springboot.data_jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Temporal;

import java.time.LocalDate;



@Getter
@Setter
@Data
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

    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDate creation_date;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "password")
    private String password;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "passport")
    private String passport;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "address")
    private String address;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "mobile")
    private String mobile;
}