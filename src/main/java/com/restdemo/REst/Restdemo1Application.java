package com.restdemo.REst;

import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.restdemo.REst.dao.EmployeeDAO;

@SpringBootApplication
public class Restdemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Restdemo1Application.class, args);
	}

	@Bean
	public CommandLineRunner startsHere(EmployeeDAO employeeDAO) {
		return runner -> {
			System.out.println("Successfully connected to the database");
		};
	}	

}
