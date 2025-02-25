package com.restdemo.REst.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.restdemo.REst.dao.EmployeeDAO;
import com.restdemo.REst.entity.Employee;
import com.restdemo.REst.errors.EmployeeErrorResponse;
import com.restdemo.REst.errors.EmployeeNotFoundException;
import com.restdemo.REst.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class RestControllerImp {

    // private final EmployeeDAO employeeDAO;
    private final EmployeeService empService;

    public RestControllerImp(EmployeeService service){
        this.empService = service;
    }
    
    
    @PostMapping("/employees")
    public Employee addEmployees(@RequestBody Employee emp) {
    	emp.setId(0);
    	Employee empDB = empService.save(emp);
    	return empDB;
    	
//    	/ 
    }
    
    @PutMapping("/employees/{id}/{email}")
    public Employee updateEmployee(@PathVariable int id, @PathVariable String email) {
    	
    	Employee emp = empService.update(id, email);
    	return emp;
    	
    }
    
    @PutMapping("/employees/v1")
    public Employee updateEmployeeV1(@RequestParam("id") int id, @RequestParam("email") String email) {
    	Employee emp = empService.update(id, email);
    	return emp;
    	
    }
    
        

    @GetMapping("/employees")
    // @Override
    public List<Employee> showEmployees(){
        return empService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployee(@PathVariable int id){
        Employee emp = empService.find(id);
        if(emp == null)
            throw new EmployeeNotFoundException("Employee with id is not found " + id);
        else
        	return emp;
    }
    
    @GetMapping("/employees/v1/{id}")
    public Employee showEmployeeV1(@PathVariable int id){
        Employee emp = empService.find(id);
        if(emp == null)
            throw new EmployeeNotFoundException("Employee with id is not found " + id);
        else
        	return emp;
    }
    
    @GetMapping("/employees/v2/{id}")
    public String showEmployeeV2(@PathVariable int id){
        Employee emp = empService.find(id);
        if(emp == null)
            throw new EmployeeNotFoundException("Employee with id is not found " + id);
        else
        	return emp.getName() + " and the email is " + emp.getEmail();
    }
    
    @GetMapping(value = "/employees/{id}", params = "version=1")
    public String showEmployeeVersion1(@PathVariable int id){
        Employee emp = empService.find(id);
        if(emp == null)
            throw new EmployeeNotFoundException("Employee with id is not found " + id);
        else
        	return emp.getName() + " and the email is " + emp.getEmail() + " is an 990";
    }
    
//    @GetMapping(value = "/employees/v1/")
//    public int showEmployeeId(@RequestParam("name" ) String name, @RequestParam("email") String email) {
//    	Employee emp = entityService.getId(name, email)
//    }
    
//    @GetMapping(value = "/employees/{name}")
    

}
