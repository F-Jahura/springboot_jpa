package com.springboot.data_jpa.dto;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentDto_1 {
    private Integer id;
    private List<PersonDto_1> personDto_1List;
}
