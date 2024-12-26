package com.springboot.data_jpa.dto;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentDto1 {
    private Integer id;
    private List<PersonDto1> personDto_1List;
}
