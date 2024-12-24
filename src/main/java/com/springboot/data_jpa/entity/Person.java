package com.springboot.data_jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name="age")
    private int age;

    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDate creation_date;

    @Column(name = "password")
    private String password;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "address")
    private String address;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "mobile")
    private String mobile;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "department_id")
    private Department department;
}