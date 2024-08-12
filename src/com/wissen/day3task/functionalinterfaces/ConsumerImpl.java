package com.wissen.day3task.functionalinterfaces;

import java.util.List;
import java.util.function.Consumer;

import com.wissen.day3task.model.Employee;

public class ConsumerImpl implements Consumer<List<Employee>>{

	@Override
	public void accept(List<Employee> t) {
		t.forEach(System.out :: println);
	}

}
