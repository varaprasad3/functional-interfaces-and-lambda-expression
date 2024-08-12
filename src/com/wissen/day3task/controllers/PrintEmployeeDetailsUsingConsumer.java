package com.wissen.day3task.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.wissen.day3task.functionalinterfaces.ConsumerImpl;
import com.wissen.day3task.model.Employee;

public class PrintEmployeeDetailsUsingConsumer {
    public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>() ;
		employees.add(new Employee(1,"Anand","dev",LocalDate.parse("2000-08-20"),1000)) ;
		employees.add(new Employee(2,"DayAnand","dev",LocalDate.parse("2000-08-20"),1000)) ;
		employees.add(new Employee(3,"VirAnand","dev",LocalDate.parse("2000-08-20"),1000)) ;
		employees.add(new Employee(4,"MajaAnand","dev",LocalDate.parse("2000-08-20"),1000)) ;
		employees.add(new Employee(5,"MasterAnand","dev",LocalDate.parse("2000-08-20"),1000)) ;
		
		Consumer<List<Employee>> consumer = new ConsumerImpl() ;
		consumer.accept(employees); 
		
		
	}
}
