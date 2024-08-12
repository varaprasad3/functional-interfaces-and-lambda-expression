package com.wissen.day3task.functionalinterfaces;

import java.time.LocalDate;

@FunctionalInterface
public interface UserNameGenerator {
	
	public String generate(String firstName, String lastName, LocalDate yearOfBirth,int id) ;

}
