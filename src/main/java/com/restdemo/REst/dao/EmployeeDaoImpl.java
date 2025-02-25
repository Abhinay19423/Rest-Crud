package com.restdemo.REst.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

import com.restdemo.REst.entity.Employee;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
// import jakarta.annotation.AutoWired;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{

    private final EntityManager entityManager;

//     public EmployeeDaoImpl(){}

    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    
    @Override
    public Employee addEmployee(Employee employee) {
        employee = entityManager.merge(employee);
        return employee;
    }

     @Override
     public void removeEmployee(int id) {
         Employee employee = entityManager.find(Employee.class, id);
         entityManager.remove(employee);
     }
    
    List<Employee> emp;
    
    @PostConstruct
    public void loadData() {
    	emp = entityManager.createQuery("From Employee", Employee.class).getResultList();
    }
    @Override
    public List<Employee> showEmployees(){
         return emp;
    }
    @Override
    public Employee showEmployee(int id){
        Employee emp = entityManager.find(Employee.class, id);
        return emp;  
    }
    
    @Override
    public Employee updateEmployee(int id, String email) {
    	
    	Employee emp = entityManager.find(Employee.class, id);
//    			find("from employee e where e.name := theName ", Employee.class);
    	emp.setEmail(email);
    	emp = entityManager.merge(emp);
    	return emp;
    	
    }
}
