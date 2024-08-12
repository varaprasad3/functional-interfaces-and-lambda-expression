package com.wissen.day3task.controllers;

import java.time.LocalDate;
import java.util.function.Predicate;

import com.wissen.day3task.model.Employee;

public class CheckEmployeeSalaryUsingPredicate {
    public static void main(String[] args) {
		Predicate<Employee> pr = (e)-> e.getSalary()>2000 ;
		
		Employee e = new Employee(2,"vara","prasad", LocalDate.parse("2000-09-20") , 10000);
		
		System.out.println(pr.test(e));
	}
}
