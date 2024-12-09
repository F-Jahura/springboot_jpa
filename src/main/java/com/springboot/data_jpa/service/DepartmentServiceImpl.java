package com.springboot.data_jpa.service;

import com.springboot.data_jpa.entity.Department;
import com.springboot.data_jpa.entity.Person;
import com.springboot.data_jpa.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;
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
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
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
