package com.restdemo.REst.service;

import com.restdemo.REst.dao.EmployeeDAO;
import com.restdemo.REst.entity.Employee;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll(){  
        return employeeDAO.showEmployees();
    }

    @Override 
    public Employee find(int id){
        return employeeDAO.showEmployee(id);
    }
    
    @Transactional
    @Override
    public Employee save(Employee emp) {
    	
    	emp = employeeDAO.addEmployee(emp);
    	return emp;
    }
    
    @Transactional
    @Override
    public Employee update(int id, String email) {
    	Employee emp = employeeDAO.updateEmployee(id, email);
    	return emp;
    }

	

}
