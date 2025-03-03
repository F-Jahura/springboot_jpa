package com.springboot.data_jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "region_code")
    private String regionCode;

    @Column(name = "area_name")
    private String areaName;

    @Column(name = "locality_name")
    private String localityName;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private int houseNumber;

    @Column(name = "building_number")
    private int buildingNumber;

    @Column(name = "Office_number")
    private int officeNumber;



    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Order order;*/

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private List<Order> orderList = new ArrayList<>();

    public void addOrderToClient(Order order){
        if (orderList == null){
            orderList = new ArrayList<>();
        }
        orderList.add(order);
        order.setClient(this);

    }

}
