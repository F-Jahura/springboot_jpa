package com.springboot.data_jpa.service;

import com.springboot.data_jpa.entity.Department;
import com.springboot.data_jpa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        departmentRepository.save(department);
        return department;
    }

    @Override
    public Department getDepartment(int id) {
        Department department = null;
        Optional<Department> optional = departmentRepository.findById(id);
        if (optional.isPresent()){
            department = optional.get();
        }
        else System.out.println("ID is not found");
        return department;
    }

}
