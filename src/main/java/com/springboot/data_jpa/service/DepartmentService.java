package com.springboot.data_jpa.service;

import com.springboot.data_jpa.entity.Department;
import com.springboot.data_jpa.entity.Person;

import java.util.List;

public interface DepartmentService {

    public List<Department> getAllDepartment();
    public void saveDepartment(Department department);
    public Department getDepartment(int id);
}
