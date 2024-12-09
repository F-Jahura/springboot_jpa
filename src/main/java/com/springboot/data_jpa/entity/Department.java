package com.springboot.data_jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="title")
    private String title;

    @Column(name = "building_num")
    private int building_num;

    @Column(name = "staffs_num")
    private int staffs_num;


    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "department")
    private List<Person> personlist;

    public void addPersonToDepartment(Person person){
        if (personlist == null){
            personlist = new ArrayList<>();
        }
        personlist.add(person);
        person.setDepartment(this);
    }

    /*@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private List<Person> personList;

    public void addPersonToDepartment(Person person){
        if (personList == null){
            personList = new ArrayList<>();
        }
        personList.add(person);
    }*/

}
