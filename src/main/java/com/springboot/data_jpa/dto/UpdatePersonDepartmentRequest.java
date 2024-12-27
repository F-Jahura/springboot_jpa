package com.springboot.data_jpa.dto;


import lombok.Data;


@Data
public class UpdatePersonDepartmentRequest {
    private Integer personID;
    private Integer departmentID;
}
