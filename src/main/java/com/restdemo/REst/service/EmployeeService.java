package com.restdemo.REst.service;

import com.restdemo.REst.dao.EmployeeDAO;
import com.restdemo.REst.entity.Employee;

import java.util.List;

// @Service
public interface EmployeeService {
    public List<Employee> findAll();
    public Employee find(int id);
    public Employee save(Employee emp);
    public Employee update(int id, String email);
}
