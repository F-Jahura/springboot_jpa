package com.springboot.data_jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private int buildingNum;

    @Column(name = "staffs_num")
    private int staffsNum;

    //NEED TO OPEN BELOW CLOSE
    /////////////////////////////////////////////
    /*@ElementCollection
    @CollectionTable(name=" department_production_line", joinColumns=@JoinColumn(name="department_id"))
    private Set<ProductionLine> line;*/


    /*@JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "department")
    private List<Person> personlist = new ArrayList<>();

    public void addPersonToDepartment(Person person){
        if (personlist == null){
            personlist = new ArrayList<>();
        }
        personlist.add(person);
        person.setDepartment(this);
    }*/

    /////////////////////////////////////////////////

}
