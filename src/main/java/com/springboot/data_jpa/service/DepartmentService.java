package com.springboot.data_jpa.service;

import com.springboot.data_jpa.entity.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> getAllDepartment();
    public Department saveDepartment(Department department);
    public Department getDepartment(int id);

}
