package com.restdemo.REst.dao;

import java.util.List;
import com.restdemo.REst.entity.Employee;

public interface EmployeeDAO {

    public Employee addEmployee(Employee employee);
     public void removeEmployee(int id);
     public Employee updateEmployee(int id, String email);
     
    public Employee showEmployee(int id);
    public List<Employee> showEmployees(); 

}
