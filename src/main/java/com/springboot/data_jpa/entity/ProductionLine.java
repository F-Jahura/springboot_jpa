package com.springboot.data_jpa.entity;


import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ProductionLine {
    private String name;
    private int equipments_count;
    private int square;

    public int sumSquare(){
        int sum = 0;
            sum = sum + square;
        return sum;

    }

}
