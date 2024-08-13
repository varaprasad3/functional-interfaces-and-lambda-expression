package com.wissen.day3task.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.wissen.day3task.functionalinterfaces.UserNameGenerator;
import com.wissen.day3task.model.Employee;
import com.wissen.day3task.model.User;

public class UserAndEmployeeDriver {
	public static void main(String[] args) {

		// create a supplier to generate 16 digit random number.

		Supplier<String> getRandomPassword = () -> {
			StringBuffer sb = new StringBuffer("");
			for (int i = 0; i < 16; i++) {
				Random r = new Random();

				char c = (char) ThreadLocalRandom.current().nextInt(48, 122);
				sb.append(c);
			}
			return sb.toString();
		};

		// implementing UserNameGenerator functional interface to generate random username.
		UserNameGenerator nameGenerator = (firstName, lastName, dateOfBirth, id) -> {
			return firstName + lastName + dateOfBirth + id;
		};

		List<Employee> employees = new ArrayList<Employee>() ;
		employees.add(new Employee(1,"Anand","dev",LocalDate.parse("2000-08-20"),1000,LocalDate.parse("2022-02-01"), "hr")) ;
		employees.add(new Employee(2,"DayAnand","dev",LocalDate.parse("2000-08-20"),1000,LocalDate.parse("2023-02-01"),"software") );
		employees.add(new Employee(3,"VirAnand","dev",LocalDate.parse("2000-08-20"),1000,LocalDate.parse("2023-01-01"), "hardware") );
		employees.add(new Employee(4,"MajaAnand","dev",LocalDate.parse("2000-08-20"),1000,LocalDate.parse("2024-02-01"),"hr")) ;
		employees.add(new Employee(5,"MasterAnand","dev",LocalDate.parse("2000-08-20"),1000,LocalDate.parse("2024-02-01"),"hardware")) ;
		
		// sorting employees based on month
		Collections.sort(employees, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getDateOfBirth().getMonth().compareTo(o2.getDateOfBirth().getMonth());
			}

		});

		// getting List<Users> from List<Employees>
		List<User> users = employees.stream()
				.map(e -> new User(e.getId(),
						nameGenerator.generate(e.getFirstName(), e.getLastName(), e.getDateOfBirth(), e.getId()),
						getRandomPassword.get()))
				.collect(Collectors.toList());

		
		//creating a thread to display employees details
		Runnable r1 = new Runnable() {

			@Override
			public void run() {

				for (Employee e : employees) {
					System.out.println(e);
				}

			}
		};

		//creating a thread to display to users details
		Runnable r2 = new Runnable() {

			@Override
			public void run() {

				for (User u : users) {
					System.out.println(u);
				}

			}
		};
		
		r1.run();
		r2.run();

	}
}
