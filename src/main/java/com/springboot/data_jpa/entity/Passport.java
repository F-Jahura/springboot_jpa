package com.springboot.data_jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Data
@Entity
@Table(name = "passport")
public class Passport {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "series")
    private String series;

    @Column(name = "number")
    private String number;

    @Column(name = "date_Of_Issue")
    private LocalDate date_Of_Issue;

    /*@OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private Person person;*/

}
