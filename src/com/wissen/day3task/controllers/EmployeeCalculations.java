package com.wissen.day3task.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.wissen.day3task.model.Employee;

public class EmployeeCalculations {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "Anand", "dev", LocalDate.parse("2000-08-20"), 1000,
				LocalDate.parse("2022-02-01"), "hr"));
		employees.add(new Employee(2, "DayAnand", "dev", LocalDate.parse("2000-08-20"), 1000,
				LocalDate.parse("2023-02-01"), "software"));
		employees.add(new Employee(3, "VirAnand", "dev", LocalDate.parse("2000-08-20"), 10080,
				LocalDate.parse("2023-01-01"), "hardware"));
		employees.add(new Employee(4, "MajaAnand", "dev", LocalDate.parse("2000-08-20"), 1000,
				LocalDate.parse("2024-02-01"), "hr"));
		employees.add(new Employee(5, "MasterAnand", "dev", LocalDate.parse("2000-08-20"), 100,
				LocalDate.parse("2024-02-01"), "hardware"));

		// finding the employee details who has minimum,maximum, sum and average of salary for all the employees in each department
		Employee employeeWithMinSalary = employees.stream().min((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))
				.get();

		
		Employee employeeWithMaxSalary = employees.stream().max((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))
				.get();

		
		double totalSalOfHrDept = employees.stream().filter(i -> i.getDepartment().equals("hr")).map(i -> i.getSalary())
				.mapToDouble(Double::new).sum();

		
		double totalSalofSoftwareDept = employees.stream().filter(i -> i.getDepartment().equals("software"))
				.map(i -> i.getSalary()).mapToDouble(Double::new).sum();

		
		double totalSalofHardWareDept = employees.stream().filter(i -> i.getDepartment().equals("hardware"))
				.map(i -> i.getSalary()).mapToDouble(Double::new).sum();

	
		double avgSalOfHrDept = employees.stream().filter(i -> i.getDepartment().equals("hr")).map(i -> i.getSalary())
				.mapToDouble(Double::new).average().getAsDouble();

		
		double avgSalOfSoftwareDept = employees.stream().filter(i -> i.getDepartment().equals("software"))
				.map(i -> i.getSalary()).mapToDouble(Double::new).average().getAsDouble();

		
		double avgSalOfHardwareDept = employees.stream().filter(i -> i.getDepartment().equals("hardware"))
				.map(i -> i.getSalary()).mapToDouble(Double::new).average().getAsDouble();
		
		
		//sorting all the employees based on their firstname except hr department and printing their details
		employees.stream().filter(e-> !e.getDepartment().equals("hr")).sorted((e1,e2)->e1.getFirstName().compareTo(e2.getFirstName())).forEach(System.out :: println); ;
		
		System.out.println("===================================================");
		
		//incrementing the salary of all the employees by 10% and printing their details
		employees.stream().map(e-> {e.setSalary(e.getSalary() + ((e.getSalary()*10)/100)) ;
			                return e ;
		}).forEach(System.out :: println) ;
		
		
		//printing 50 oddnumbers after 100
		IntStream.range(101, 200).filter(i->i%2!=0).forEach(System.out::println) ;

	}
}
