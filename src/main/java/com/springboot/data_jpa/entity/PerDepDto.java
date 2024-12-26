package com.springboot.data_jpa.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "people")
public class PerDepDto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer personID;

    @Column(name= "department_id")
    private Integer departmentID;
}
