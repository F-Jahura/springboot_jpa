package com.springboot.data_jpa.dto;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentDto {
    private String title;
    private int building_num;
    private int staffs_num;
    private List<PersonDto> personDtoList;
}
